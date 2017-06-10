package Model;

import Controller.Battle;
import Controller.Main;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IncidentCard extends Card {

    public IncidentCard(int ID) {
        super("Incident", ID);
        String[] text = Main.lang.Lang.getIncidentText(ID);
        Name = text[0];
        Description = text[1];
    }

    public static IncidentCard[] shuffle(IncidentCard[] toShuffle) {
        List<IncidentCard> CardList = Arrays.asList(toShuffle);
        Collections.shuffle(CardList);
        return CardList.toArray(new IncidentCard[CardList.size()]);
    }

    public static IncidentCard[] generateIncidentDeck(Boolean LilyWhite) {
        int N = LilyWhite ? 16 : 15;
        IncidentCard[] Deck = new IncidentCard[N];
        for (int i = 0; i < N; i++) {
            Deck[i] = new IncidentCard(i + 1);
        }
        Deck = shuffle(Deck);
        return Deck;
    }

    public void IncidentFunction(Player Heroine, Player[] players, Player CurrentPlayer, int CurrentTurn, boolean IncidentJustStarted) {
        switch (ID) {
            case 1:
                Crisis_of_Faith(Heroine, players, CurrentTurn);
                break;
            case 2:
                Crossing_to_Higan(players);
                break;
            case 3:
                Endless_Party(players, CurrentTurn, Battle.getDeck());
                break;
            case 4:
                Eternal_Night(players);
                break;
            case 5:
                Five_Impossible_Requests(CurrentPlayer, true, CurrentPlayer.getHand().length);
                break;
            case 6:
                Great_Barrier_Weakening(CurrentPlayer);
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                Rekindle_Blazing_Hell(players, CurrentPlayer, CurrentTurn, IncidentJustStarted);
                break;
            case 10:
                Saigyou_Ayakashi_Blooming(CurrentPlayer);
                break;
            case 11:
                break;
            case 12:
                Spring_Snow(players);
                break;
            case 13:
                break;
            case 14:
                Voyage_to_Makai();
                break;
            case 15:
                break;
            default:
                Lily_White(CurrentPlayer);
        }
    }

    //<editor-fold defaultstate="collapse" desc="IncidentEffects">
    /**When this incident enters play, each player except the Heroine
    flips the top card of the deck until someone flips an Autumn.
    That player permanently swaps Role cards with the Heroine and
    gains 1 life.
    Then, resolve this incident.*/
    private void Crisis_of_Faith(Player Heroine, Player[] players, int CurrentTurn) {
        Player player = players[Battle.getCurrentTurn()];
        if (player.getRole().getID() == 7) {
            Battle.nextTurn();
            Crisis_of_Faith(Heroine, players, CurrentTurn);
        } else {
            DeckCard[] Deck = Battle.getDeck();
            int LastCardIndex = Deck.length - 1;
            DeckCard FlippingCard = new DeckCard(Deck[LastCardIndex].getID());
            Timeline timeline = Battle.getFlipAnimation();
            timeline.setOnFinished(e -> {
                DeckCard[] newUsedDeck = new DeckCard[Battle.getUsedCard().length + 1];
                for (int i = 0; i < newUsedDeck.length - 1; i++) {
                    newUsedDeck[i] = Battle.getUsedCard()[i];
                }
                newUsedDeck[newUsedDeck.length - 1] = FlippingCard;
                Battle.setUsedDeck(newUsedDeck);
                DeckCard[] newDeck = new DeckCard[Deck.length - 1];
                for (int i = 0; i < newDeck.length; i++)
                    newDeck[i] = Deck[i];
                Battle.setDeck(newDeck);
                if (FlippingCard.getSeason() == 0) {
                    Battle.setTurn(CurrentTurn);

                    Node J1Role = player.getRoleView();
                    Node J2Role = Heroine.getRoleView();
                    KeyValue k_1, k_2, k_3, k_4;
                    k_1 = new KeyValue(J1Role.translateYProperty(), 800);
                    k_2 = new KeyValue(J2Role.translateYProperty(), 800);
                    k_3 = new KeyValue(J1Role.translateYProperty(), 0);
                    k_4 = new KeyValue(J2Role.translateYProperty(), 0);
                    KeyFrame F_1 = new KeyFrame(Duration.millis(1250), k_1, k_2);
                    KeyFrame F_2 = new KeyFrame(Duration.millis(1250), g -> player.swapRole(Heroine));
                    KeyFrame F_3 = new KeyFrame(Duration.millis(1750), k_1, k_2);
                    KeyFrame F_4 = new KeyFrame(Duration.millis(3000), k_3, k_4);
                    Timeline timeline1 = new Timeline(F_1, F_2, F_3, F_4);
                    timeline1.setOnFinished(h -> {
                        Battle.DrawPhase();
                        Battle.solveIncident();
                    });
                    timeline1.play();
                } else {
                    Battle.nextTurn();
                    Crisis_of_Faith(Heroine, players, CurrentTurn);
                }
            });
            timeline.play();
        }
    }

    /**All players are considered in range, regardless of distance.
    Resolution: A player is defeated.*/
    private void Crossing_to_Higan(Player[] players) {
        for (Player player : players)
            player.setRange(999);
        Task<Void> sleeper = Main.sleeper(1500);
        sleeper.setOnSucceeded(e -> Battle.DrawPhase());
        Thread thread = new Thread(sleeper);
        thread.start();
    }

    /**During your incident step, each player draws one card.
    You still take your draw step.
    Resolution: The deck is reshuffled.*/
    private void Endless_Party(Player[] players, int CurrentTurn, DeckCard[] deck) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                if (Battle.getDeck().length == 0)
                    Thread.sleep(3500);
                return null;
            }
        };
        task.setOnSucceeded(e -> {
            Player player = players[Battle.getCurrentTurn()];
            DeckCard[] Deck = Battle.getDeck();
            Timeline tl = Battle.getDrawAnimation(players[Battle.getCurrentTurn()], true);
            tl.setOnFinished(f -> {
                        player.drawCard(new DeckCard(Deck[Deck.length - 1].getID()));
                        DeckCard[] newDeck = new DeckCard[Deck.length - 1];
                        for (int i = 0; i < newDeck.length; i++)
                            newDeck[i] = Deck[i];
                        Battle.setDeck(newDeck);
                        Battle.nextTurn();
                        if (Battle.getCurrentTurn() == CurrentTurn) {
                            Battle.DrawPhase();
                        } else {
                            Endless_Party(players, CurrentTurn, newDeck);
                        }
                    }
            );
            tl.play();
        });
        Thread thread = new Thread(task);
        thread.start();
    }

    /**Players may play any number of Danmaku cards each turn.
    Collect the top card of the deck during your incident step.
    Collect any Danmaku cards.
    Resolution: Collect 12 cards.*/
    private void Eternal_Night(Player[] players) {
        for (Player player : players)
            player.setDanmaku(999);
        Battle.DrawPhase();
    }

    /**During your incident step, discard your hand and draw that many cards.
    You still take your draw step.
    Resolution: Collect 1 Artifact card.*/
    private void Five_Impossible_Requests(Player CurrentPlayer, boolean discard, int Cards_in_hand) {
        if (discard) {
            Pane MainPane = Battle.getMainPane();
            GridPane Hand = CurrentPlayer.getHandGrid();
            KeyValue[] Keys = new KeyValue[Hand.getChildren().size()];
            for (int i = 0; i < Hand.getChildren().size(); i++) {
                Keys[i] = new KeyValue(Hand.getChildren().get(i).translateYProperty(), 1600);
            }
            KeyFrame frame = new KeyFrame(Duration.seconds(2), Keys);
            Timeline tl = new Timeline(frame);
            tl.setOnFinished(e -> {
                KeyValue[] keys2 = new KeyValue[Hand.getChildren().size() * 3];
                double size = Hand.getChildren().size();
                for (int i = 0; i < Hand.getChildren().size(); i++) {
                    Node card = Hand.getChildren().get(i);
                    card.setScaleX(2);
                    card.setScaleY(2);
                    Hand.getChildren().removeAll(Hand.getChildren());
                    MainPane.getChildren().add(card);
                    try {
                        StackPane.setAlignment(card, Pos.TOP_LEFT);
                    } catch (ArrayIndexOutOfBoundsException error) {
                        error.printStackTrace();
                    }
                    if (CurrentPlayer.getCoordinatesAndRotate()[0] <= 0 || CurrentPlayer.getCoordinatesAndRotate()[0] >= 5700) {
                        card.setTranslateX(CurrentPlayer.getCoordinatesAndRotate()[0]);
                        card.setTranslateY(CurrentPlayer.getCoordinatesAndRotate()[1] - 600 + (1200 / size) * i);
                    } else {
                        card.setTranslateX(CurrentPlayer.getCoordinatesAndRotate()[0] - 600 + (1200 / size) * i);
                        card.setTranslateY(CurrentPlayer.getCoordinatesAndRotate()[1]);
                    }
                    card.setRotate(CurrentPlayer.getCoordinatesAndRotate()[2]);
                    keys2[i * 3] = new KeyValue(card.translateXProperty(), Battle.posDeck[0] + 900);
                    keys2[i * 3 + 1] = new KeyValue(card.translateYProperty(), Battle.posDeck[1] + 200);
                    keys2[i * 3 + 2] = new KeyValue(card.rotateProperty(), Battle.posDeck[2]);
                }
                KeyFrame frames2 = new KeyFrame(Duration.millis(2000), keys2);
                Timeline tl2 = new Timeline(frames2);
                tl2.setOnFinished(f -> {
                    Task<Void> sleeper = Main.sleeper(200);
                    sleeper.setOnSucceeded(g -> {
                                try {
                                    MainPane.getChildren().remove(1, MainPane.getChildren().size());
                                } catch (ArrayIndexOutOfBoundsException error) {
                                    error.printStackTrace();
                                }
                                DeckCard[] usedDeck = Battle.getUsedCard();
                                DeckCard[] newDeck = new DeckCard[usedDeck.length + CurrentPlayer.getHand().length];
                                for (int i = 0; i < usedDeck.length; i++)
                                    newDeck[i] = new DeckCard(usedDeck[i].getID());
                                for (int i = usedDeck.length; i < newDeck.length; i++)
                                    newDeck[i] = new DeckCard(CurrentPlayer.getHand()[i].getID());
                                Battle.setUsedDeck(newDeck);
                                CurrentPlayer.setHand(new DeckCard[]{});
                                Five_Impossible_Requests(CurrentPlayer, false, Cards_in_hand);
                            }
                    );
                    new Thread(sleeper).start();
                });
                tl2.play();
            });
            tl.play();
        } else {
            Timeline tl = Battle.getDrawAnimation(CurrentPlayer, true);
            tl.setOnFinished(g -> {
                DeckCard[] Deck = Battle.getDeck();
                CurrentPlayer.drawCard(new DeckCard(Battle.getDeck()[Deck.length - 1].getID()));
                DeckCard[] newDeck = new DeckCard[Deck.length - 1];
                for (int i = 0; i < newDeck.length; i++)
                    newDeck[i] = Deck[i];
                Battle.setDeck(newDeck);
                if (CurrentPlayer.getHand().length == Cards_in_hand) {
                    Battle.DrawPhase();
                } else
                    Five_Impossible_Requests(CurrentPlayer, false, Cards_in_hand);
            });
            tl.play();
        }
    }

    /**Draw your first card each turn from the discard pile.
    If the discard pile is empty, draw from the deck instead.
    Cards must be placed on the discard pile in the order they are played.
    Resolution: Collect 3 Invocation cards.*/
    private void Great_Barrier_Weakening(Player CurrentPlayer) {
        Timeline tl;
        if (Battle.getUsedCard().length == 0)
            tl = Battle.getDrawAnimation(CurrentPlayer, true);
        else
            tl = Battle.getDrawAnimation(CurrentPlayer, false);
        Timeline tl2 = Battle.getDrawAnimation(CurrentPlayer, true);
        tl.setOnFinished(e -> tl2.play());
        tl2.setOnFinished(e -> Battle.MainPhase());
        tl.play();
    }

    /**When this incident enters play, all other players must
    discard a Danmaku card or lose 1 life.
    During your incident step, discard a Danmaku card or lose 1 life.
    Resolution: Collect 9 Danmaku cards.*/
    private void Great_Fairy_Wars(boolean Just_Entered, int CurrentTurn) {
        if (Just_Entered) {

        } else {

        }
    }

    /**You may pay 1 life to activate your Spell Card.
    You can only activate one Spell Card per round.
    Resolution: Collect 6 Dodge cards.¨*/
    private void Overdrive() {
    }

    /**When this incident enters play, all players draw up to their max hand size.
    During your incident step, draw up to your max hand size.
    You still take your draw step.
    Resolution: Collect 6 Summer cards.*/
    private void Rekindle_Blazing_Hell(Player[] players, Player playerDrawing, int CurrentTurn, boolean Entered) {
        boolean AllHandMax = true;
        Timeline tl = Battle.getDrawAnimation(playerDrawing, true);
        DeckCard[] Deck = Battle.getDeck();
        /*Timeline tl = new Timeline();
        KeyValue kx0, ky0, kr0, kx1, ky1, kr1;
        Node dealingCard = Battle.getDeckView().getChildren().get(Deck.length - 1);
        Battle.getMainPane().getChildren().add(dealingCard);
        dealingCard.setTranslateX(Battle.posDeck[0]);
        dealingCard.setTranslateY(Battle.posDeck[1]);
        dealingCard.toFront();
        kx0 = new KeyValue(dealingCard.translateXProperty(), Battle.posDeck[0]);
        ky0 = new KeyValue(dealingCard.translateYProperty(), Battle.posDeck[1]);
        kr0 = new KeyValue(dealingCard.rotateProperty(), 0);
        kx1 = new KeyValue(dealingCard.translateXProperty(), playerDrawing.getCoordinatesAndRotate()[0]);
        ky1 = new KeyValue(dealingCard.translateYProperty(), playerDrawing.getCoordinatesAndRotate()[1]);
        kr1 = new KeyValue(dealingCard.rotateProperty(), playerDrawing.getCoordinatesAndRotate()[2]);
        KeyFrame F0 = new KeyFrame(Duration.ZERO, kx0, ky0, kr0);
        KeyFrame F1 = new KeyFrame(new Duration(Main.audio.get0AndPlay("se_cardslide") + 475), kx1, ky1, kr1);
        tl.getKeyFrames().addAll(F0, F1);*/
        tl.setOnFinished(e -> {
            playerDrawing.drawCard(new DeckCard(Deck[Deck.length - 1].getID()));
            DeckCard[] newDeck = new DeckCard[Deck.length - 1];
            for (int i = 0; i < newDeck.length; i++)
                newDeck[i] = Deck[i];
            Battle.setDeck(newDeck);
            Rekindle_Blazing_Hell(players, players[Battle.getCurrentTurn()], CurrentTurn, true);
        });

        if (Entered) {
            for (Player player : players)
                if (player.getMaxHand() > player.getHand().length)
                    AllHandMax = false;
            if (playerDrawing.getMaxHand() > playerDrawing.getHand().length) {
                tl.play();
            } else if (Battle.getCurrentTurn() == CurrentTurn && AllHandMax) {
                Battle.DrawPhase();
            } else {
                Battle.nextTurn();
                Rekindle_Blazing_Hell(players, players[Battle.getCurrentTurn()], CurrentTurn, true);
            }
        } else if (playerDrawing.getMaxHand() > playerDrawing.getHand().length) {
            tl.play();
        } else {
            Battle.DrawPhase();
        }
    }

    /**Lose 1 life during your incident step.
    This is not an attack.
    Resolution: Collect 6 Winter cards.*/
    private void Saigyou_Ayakashi_Blooming(Player player) {
        Task<Void> sleeper = Main.sleeper(1500);
        sleeper.setOnSucceeded(e -> player.ModifyLife(-1));
        Thread thread = new Thread(sleeper);
        Task<Void> sleeper2 = Main.sleeper(1500);
        sleeper2.setOnSucceeded(e -> Battle.DrawPhase());
        Thread thread2 = new Thread(sleeper2);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
        }
        thread2.start();
    }

    /**During your incident step, flip the top card of the
    deck and perform an action according to its season.
    Spring: Swap hands with the player on your right.
    Summer: Draw one card.
    Autumn: Swap hands with the player on your left.
    Winter: Discard 1 card at random from your hand.
    Resolution: Collect 2 cards of each season.*/
    private void Scarlet_Weather_Rhapsody() {
    }

    /**Players cannot activate Spell Cards.
    Resolution: Collect 6 Spring cards.*/
    private void Spring_Snow(Player[] players) {
        for (Player player : players)
            player.setSpellCardAvailable(false);
        Task<Void> sleeper = Main.sleeper(1500);
        sleeper.setOnSucceeded(e -> Battle.DrawPhase());
        Thread thread = new Thread(sleeper);
        thread.start();
    }

    /**During your incident step, reveal the top 3 cards of the deck.
    You may choose a Powerup, Invocation, or Healing card from among
    these and add it to your hand.
    Collect all other cards revealed this way.
    Resolution: Collect 12 cards.*/
    private void Undefined_Fantastic_Object() {
    }

    /**Players cannot gain life. Players cannot be returned to life.
    Resolution: Collect 6 Autumn cards.*/
    private void Voyage_to_Makai() {
    }

    /**When this incident enters play, all players discard all Item cards in play.
    If a player would put an Item card into play, they discard it instead.
    Resolution: Collect 4 Item cards.*/
    private void Worldly_Desires() {
    }

    /**During your incident step, flip the top card of the deck.
    If it is a Summer, resolve this incident.
    If it is a Spring, you lose 3 life.
    This is not an attack.*/
    private void Lily_White(Player CurrentPlayer) {
        DeckCard[] Deck = Battle.getDeck();
        int LastCardIndex = Deck.length - 1;
        DeckCard FlippingCard = new DeckCard(Deck[LastCardIndex].getID());
        Timeline timeline = Battle.getFlipAnimation();
        timeline.setOnFinished(e -> {
            DeckCard[] newUsedDeck = new DeckCard[Battle.getUsedCard().length + 1];
            for (int i = 0; i < newUsedDeck.length - 1; i++) {
                newUsedDeck[i] = Battle.getUsedCard()[i];
            }
            newUsedDeck[newUsedDeck.length - 1] = FlippingCard;
            Battle.setUsedDeck(newUsedDeck);
            DeckCard[] newDeck = new DeckCard[Deck.length - 1];
            for (int i = 0; i < newDeck.length; i++)
                newDeck[i] = Deck[i];
            Battle.setDeck(newDeck);

            if (FlippingCard.getSeason() == 2) {
                CurrentPlayer.ModifyLife(-3);
            } else if (FlippingCard.getSeason() == 3) {
                Battle.solveIncident();
            }
            Battle.DrawPhase();
        });
        timeline.play();
    }

    //</editor-fold>
}
