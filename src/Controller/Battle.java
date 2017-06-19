package Controller;

import Model.*;
import Views.Scenes.Scene_Battle;
import Views.StackPane_Shuffling;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

public class Battle {
    public static final int[]
            pos1 = new int[]{3360, 3800, 0},
            pos2 = new int[]{1560, 3800, 0},    // { X , Y , R}
            pos3 = new int[]{-1000, 2200, 90},
            pos4 = new int[]{-1000, 400, 90},
            pos5 = new int[]{1560, -1000, 180},
            pos6 = new int[]{3360, -1000, 180},
            pos7 = new int[]{5700, 400, -90},
            pos8 = new int[]{5700, 2200, -90},
            posDeck = new int[]{880, 1310, 0},
            posInciDeck = new int[]{2980, 1310, 0};
    //<editor-fold defaultstate="collapsed" desc="Variables">
    protected static final Label step1 = new Label(Main.lang.Lang.step1),
            step2 = new Label(Main.lang.Lang.step2),
            step3 = new Label(Main.lang.Lang.step3),
            step4 = new Label(Main.lang.Lang.step4),
            step5 = new Label(Main.lang.Lang.step5);
    protected static Pane MainPane = new Pane(), BackGroudPane = new StackPane(), MenuPane = new StackPane();
    protected static GridPane DeckView = new GridPane(),
            IncidentDeckView = new GridPane(),
            MainGrid = new GridPane(),
            UsedCardView = new GridPane(),
            usedIncidentView = new GridPane(),
            CollectedIncidentCardView = new GridPane(),
            CentralGrid,
            p1, p2, p3, p4, p5, p6, p7, p8;
    protected static Player[] Players;
    protected static Button EndTurn = new Button();
    protected static DeckCard[] Deck,
            UsedCard,
            CollectedCard;
    protected static IncidentCard CurrentIncident;
    protected static IncidentCard[] IncidentDeck,
            UsedIncident;
    protected static int currentTurn,
            loopCounter,
            loopnotifier;
    protected static Thread Battle;
    private static Node dealingCard;
    //</editor-fold>


    public static void start(DeckCard[] Deck, RoleCard[] RoleDeck, CharacterCard[] CharacterDeck, int CharacterChoice) {
        Scene scene = Scene_Battle.scene();

        Main.setNewScene(scene);
        Main.audio.stopBGM();
        Task<Void> battle = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Task<Void> sleeper = new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        try {
                            Thread.sleep(400);
                        } catch (InterruptedException ignored) {
                        }
                        return null;
                    }
                };
                sleeper.setOnSucceeded(e -> {
                    setDeck(Deck);
                    setIncidentDeck(IncidentCard.generateIncidentDeck());
                    setPlayers(RoleDeck, CharacterDeck, CharacterChoice);
                    BackGroudPane.getChildren().add(MainPane);
                    MainGrid.add(CentralGrid, 1, 1);
                    GridPane.setColumnSpan(CentralGrid, 2);
                    GridPane.setRowSpan(CentralGrid, 2);
                });
                Thread thread = new Thread(sleeper);
                thread.start();
                return null;
            }
        };
        Battle = new Thread(battle);
        Battle.start();
        scene.addEventHandler(KeyEvent.KEY_PRESSED, t -> {
            if (t.getCode() == KeyCode.ESCAPE) {
                try {
                    BackGroudPane.getChildren().add(MenuPane);
                } catch (IllegalArgumentException ignored) {
                }
            }
        });
    }

    private static void Turn0() {
        loopnotifier = currentTurn;
        loopCounter = -1;
        for (Player player : Players)
            player.resetStats();
        dealCards();
    }

    private static void MatchStart() {
        StartTheTurnPhase();
    }

    //<editor-fold defaultstate="collapsed" desc="Game Functions">
    //<editor-fold defaultstate="collapsed" desc="Phase Function"
    private static void StartTheTurnPhase() {
        step1.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        step5.setStyle("-fx-background-color: brown; -fx-text-fill: white;");
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(800);
                } catch (InterruptedException ignored) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> IncidentPhase());
        Thread thread = new Thread(sleeper);
        thread.start();
        Players[currentTurn].resetStats();
    }

    private static void IncidentPhase() {
        step2.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        step1.setStyle("-fx-background-color: brown; -fx-text-fill: white;");
        if (CurrentIncident == null) {
            //CurrentIncident = new IncidentCard(IncidentDeck[IncidentDeck.length-1].getID());
            CurrentIncident = new IncidentCard(16);
            Node Rotatecard1 = IncidentDeckView.getChildren().get(IncidentDeck.length - 1),
                    Rotatecard2 = CurrentIncident.getView(72000 / 420, true);
            MainGrid.getChildren().addAll(Rotatecard1, Rotatecard2);
            Rotatecard1.setTranslateX(posInciDeck[0]);
            Rotatecard2.setTranslateX(posInciDeck[0]);
            Rotatecard1.setTranslateY(posInciDeck[1]);
            Rotatecard2.setTranslateY(posInciDeck[1]);
            Rotatecard1.setRotationAxis(Rotate.Y_AXIS);
            Rotatecard2.setRotationAxis(Rotate.Y_AXIS);
            Rotatecard2.setRotate(-90);
            KeyValue k1 = new KeyValue(Rotatecard1.rotateProperty(), 90);
            KeyValue k3 = new KeyValue(Rotatecard2.rotateProperty(), -90);
            KeyValue k4 = new KeyValue(Rotatecard2.rotateProperty(), 0);
            KeyValue k5 = new KeyValue(Rotatecard1.translateXProperty(), posInciDeck[0] + 650);
            KeyValue k6 = new KeyValue(Rotatecard2.translateXProperty(), posInciDeck[0] + 650);
            KeyFrame keyFrame1 = new KeyFrame(new Duration(1000), k1, k3);
            KeyFrame keyFrame2 = new KeyFrame(new Duration(2000), k4, k5, k6);
            Timeline tl = new Timeline();
            tl.getKeyFrames().addAll(keyFrame1, keyFrame2);
            tl.setOnFinished(event -> {
                MainGrid.getChildren().remove(Rotatecard1);
                MainGrid.getChildren().remove(Rotatecard2);
                Main.audio.playBGM("I" + CurrentIncident.getID());
                IncidentCard[] Deck = new IncidentCard[UsedIncident.length + 1];
                for (int i = 0; i < UsedIncident.length; i++)
                    Deck[i] = UsedIncident[i];
                Deck[UsedIncident.length] = CurrentIncident;
                UpdateUsedCardsView(Deck, usedIncidentView, Pos.CENTER_LEFT);
                Task<Void> sleeper = Main.sleeper(2500);
                sleeper.setOnSucceeded(f -> CurrentIncident.IncidentFunction(getHeroine(), Players, Players[currentTurn], currentTurn, true));
                Thread thread = new Thread(sleeper);
                thread.start();
            });
            tl.play();
        } else {
            CurrentIncident.IncidentFunction(getHeroine(), Players, Players[currentTurn], currentTurn, false);
        }
    }

    public static void DrawPhase() {
        step3.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        step2.setStyle("-fx-background-color: brown; -fx-text-fill: white;");
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ignored) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> MainPhase());
        Thread thread = new Thread(sleeper);
        thread.start();
        DrawAnimation(Players[currentTurn], true, 2, false);
    }

    public static void MainPhase() {
        step4.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        step3.setStyle("-fx-background-color: brown; -fx-text-fill: white;");
        step2.setStyle("-fx-background-color: brown; -fx-text-fill: white;");
        EndTurn.setDisable(false);
    }

    protected static void DiscardPhase() {
        step5.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        step4.setStyle("-fx-background-color: brown; -fx-text-fill: white;");
        EndTurn.setDisable(true);
        nextTurn();
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Turn Functions">
    public static void nextTurn() {
        currentTurn++;
        try {
            Players[currentTurn].getRole();
        } catch (ArrayIndexOutOfBoundsException e) {
            currentTurn = 0;
        }
    }

    public static void setTurn(int turn) {
        currentTurn = turn;
    }

    //</editor-fold>
    public static void solveIncident() {
        CurrentIncident = null;
    }

    //<editor-fold defaultstate="collapse" desc="pending">
    /*
    private static void checkWinners(){
        int[] lives = new int[Players.length];
        RoleCard[] Roles = new RoleCard[Players.length];
        boolean[] Winners = new boolean[Players.length];
        Player Heroine=getHeroine();
        for (int i = 0; i < Players.length; i++) {
            lives[i]=Players[i].getLife();
            Roles[i]=Players[i].getRole();
        }
        for (int i = 0; i < Players.length; i++) {
            if (Roles[i].getID()==12 && Heroine.getLife()==0) {
                Heroine.swapRole(Players[i]);
                return;
            }
            if (Roles[i].getID()>=13 && Roles[i].getID()<=15 && Heroine.getLife()==0)
                Winners[i]=true;
            if (Roles[i].getID()==7){
                Player[] partnerts= getPartners();
                boolean bln=true;
                for (int j=0;j<Roles.length;j++)
                    if((((Roles[j].getID() >= 1) && (Roles[j].getID() <= 6))
                            ||
                            (Roles[j].getID() == 11)
                            ||
                            ((Roles[j].getID() >= 13) && (Roles[j].getID() <= 15)))
                            &&
                            (lives[j] != 0)){bln=false;break;}
                if ()
            }
        }
    }*/
    //</editor-fold>
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Game setup Functions">
    protected static void setPlayers(RoleCard[] Roles, CharacterCard[] CharacterDeck, int CharacterChoice) {
        switch (Roles.length) {
            case 4:
                //<editor-fold defaultstate="collapsed" desc="Case 4 Players Game">
                Players = new Player[4];
                Players[0] = new Player(CharacterDeck[23 - CharacterChoice], Roles[3], pos1);
                Players[1] = new Player(CharacterDeck[21 - CharacterChoice], Roles[2], pos3);
                Players[2] = new Player(CharacterDeck[19 - CharacterChoice], Roles[1], pos5);
                Players[3] = new Player(CharacterDeck[17 - CharacterChoice], Roles[0], pos7);
                p1 = Players[0].getTable(BackGroudPane, true);
                p2 = Players[1].getTable(BackGroudPane, false);
                p3 = Players[2].getTable(BackGroudPane, false);
                p4 = Players[3].getTable(BackGroudPane, false);
                p2.setRotationAxis(Rotate.Z_AXIS);
                p3.setRotationAxis(Rotate.Z_AXIS);
                p4.setRotationAxis(Rotate.Z_AXIS);
                p2.setRotate(Players[1].getCoordinatesAndRotate()[2]);
                p3.setRotate(Players[2].getCoordinatesAndRotate()[2]);
                p4.setRotate(Players[3].getCoordinatesAndRotate()[2]);
                MainGrid.add(p1, 2, 3);
                MainGrid.add(p2, 0, 2);
                MainGrid.add(p3, 1, 0);
                MainGrid.add(p4, 3, 0);
                GridPane.setRowSpan(p2, 2);
                GridPane.setRowSpan(p3, 1);
                GridPane.setRowSpan(p4, 2);
                p1.setOpacity(0);
                p2.setOpacity(0);
                p3.setOpacity(0);
                p4.setOpacity(0);
                TimeLines(new GridPane[]{p1, p2, p3, p4}, 4, 0);
                break;
            //</editor-fold>
            case 5:
                //<editor-fold defaultstate="collapsed" desc="Case 5 Players Game">
                Players = new Player[5];
                Players[0] = new Player(CharacterDeck[23 - CharacterChoice], Roles[4], pos1);
                Players[1] = new Player(CharacterDeck[21 - CharacterChoice], Roles[3], pos3);
                Players[2] = new Player(CharacterDeck[19 - CharacterChoice], Roles[2], pos4);
                Players[3] = new Player(CharacterDeck[17 - CharacterChoice], Roles[1], pos5);
                Players[4] = new Player(CharacterDeck[15 - CharacterChoice], Roles[0], pos7);
                p1 = Players[0].getTable(BackGroudPane, true);
                p2 = Players[1].getTable(BackGroudPane, false);
                p3 = Players[2].getTable(BackGroudPane, false);
                p4 = Players[3].getTable(BackGroudPane, false);
                p5 = Players[4].getTable(BackGroudPane, false);
                p2.setRotationAxis(Rotate.Z_AXIS);
                p3.setRotationAxis(Rotate.Z_AXIS);
                p4.setRotationAxis(Rotate.Z_AXIS);
                p5.setRotationAxis(Rotate.Z_AXIS);
                p2.setRotate(Players[1].getCoordinatesAndRotate()[2]);
                p3.setRotate(Players[2].getCoordinatesAndRotate()[2]);
                p4.setRotate(Players[3].getCoordinatesAndRotate()[2]);
                p5.setRotate(Players[4].getCoordinatesAndRotate()[2]);
                MainGrid.add(p1, 2, 3);
                MainGrid.add(p2, 0, 2);
                MainGrid.add(p3, 0, 0);
                MainGrid.add(p4, 1, 0);
                MainGrid.add(p5, 3, 0);
                GridPane.setRowSpan(p2, 2);
                GridPane.setRowSpan(p3, 2);
                GridPane.setRowSpan(p4, 1);
                GridPane.setRowSpan(p5, 2);
                p1.setOpacity(0);
                p2.setOpacity(0);
                p3.setOpacity(0);
                p4.setOpacity(0);
                p5.setOpacity(0);
                TimeLines(new GridPane[]{p1, p2, p3, p4, p5}, 5, 0);
                break;
            //</editor-fold>
            case 6:
                //<editor-fold defaultstate="collapsed" desc="Case 6 Players Game">
                Players = new Player[6];
                Players[0] = new Player(CharacterDeck[23 - CharacterChoice], Roles[5], pos1);
                Players[1] = new Player(CharacterDeck[21 - CharacterChoice], Roles[4], pos3);
                Players[2] = new Player(CharacterDeck[19 - CharacterChoice], Roles[3], pos4);
                Players[3] = new Player(CharacterDeck[17 - CharacterChoice], Roles[2], pos5);
                Players[4] = new Player(CharacterDeck[15 - CharacterChoice], Roles[1], pos6);
                Players[5] = new Player(CharacterDeck[13 - CharacterChoice], Roles[0], pos7);
                p1 = Players[0].getTable(BackGroudPane, true);
                p2 = Players[1].getTable(BackGroudPane, false);
                p3 = Players[2].getTable(BackGroudPane, false);
                p4 = Players[3].getTable(BackGroudPane, false);
                p5 = Players[4].getTable(BackGroudPane, false);
                p6 = Players[5].getTable(BackGroudPane, false);
                p2.setRotationAxis(Rotate.Z_AXIS);
                p3.setRotationAxis(Rotate.Z_AXIS);
                p4.setRotationAxis(Rotate.Z_AXIS);
                p5.setRotationAxis(Rotate.Z_AXIS);
                p6.setRotationAxis(Rotate.Z_AXIS);
                p2.setRotate(Players[1].getCoordinatesAndRotate()[2]);
                p3.setRotate(Players[2].getCoordinatesAndRotate()[2]);
                p4.setRotate(Players[3].getCoordinatesAndRotate()[2]);
                p5.setRotate(Players[4].getCoordinatesAndRotate()[2]);
                p6.setRotate(Players[5].getCoordinatesAndRotate()[2]);
                MainGrid.add(p1, 2, 3);
                MainGrid.add(p2, 0, 2);
                MainGrid.add(p3, 0, 0);
                MainGrid.add(p4, 1, 0);
                MainGrid.add(p5, 2, 0);
                MainGrid.add(p6, 3, 0);
                GridPane.setRowSpan(p2, 2);
                GridPane.setRowSpan(p3, 2);
                GridPane.setRowSpan(p4, 1);
                GridPane.setRowSpan(p5, 1);
                GridPane.setRowSpan(p6, 2);
                p1.setOpacity(0);
                p2.setOpacity(0);
                p3.setOpacity(0);
                p4.setOpacity(0);
                p5.setOpacity(0);
                p6.setOpacity(0);
                TimeLines(new GridPane[]{p1, p2, p3, p4, p5, p6}, 6, 0);
                break;
            //</editor-fold>
            case 7:
                //<editor-fold defaultstate="collapsed" desc="Case 7 Players Game">
                Players = new Player[7];
                Players[0] = new Player(CharacterDeck[23 - CharacterChoice], Roles[6], pos1);
                Players[1] = new Player(CharacterDeck[21 - CharacterChoice], Roles[5], pos3);
                Players[2] = new Player(CharacterDeck[19 - CharacterChoice], Roles[4], pos4);
                Players[3] = new Player(CharacterDeck[17 - CharacterChoice], Roles[3], pos5);
                Players[4] = new Player(CharacterDeck[15 - CharacterChoice], Roles[2], pos6);
                Players[5] = new Player(CharacterDeck[13 - CharacterChoice], Roles[1], pos7);
                Players[6] = new Player(CharacterDeck[11 - CharacterChoice], Roles[0], pos8);
                p1 = Players[0].getTable(BackGroudPane, true);
                p2 = Players[1].getTable(BackGroudPane, false);
                p3 = Players[2].getTable(BackGroudPane, false);
                p4 = Players[3].getTable(BackGroudPane, false);
                p5 = Players[4].getTable(BackGroudPane, false);
                p6 = Players[5].getTable(BackGroudPane, false);
                p7 = Players[6].getTable(BackGroudPane, false);
                p2.setRotationAxis(Rotate.Z_AXIS);
                p3.setRotationAxis(Rotate.Z_AXIS);
                p4.setRotationAxis(Rotate.Z_AXIS);
                p5.setRotationAxis(Rotate.Z_AXIS);
                p6.setRotationAxis(Rotate.Z_AXIS);
                p7.setRotationAxis(Rotate.Z_AXIS);
                p2.setRotate(Players[1].getCoordinatesAndRotate()[2]);
                p3.setRotate(Players[2].getCoordinatesAndRotate()[2]);
                p4.setRotate(Players[3].getCoordinatesAndRotate()[2]);
                p5.setRotate(Players[4].getCoordinatesAndRotate()[2]);
                p6.setRotate(Players[5].getCoordinatesAndRotate()[2]);
                p7.setRotate(Players[6].getCoordinatesAndRotate()[2]);
                MainGrid.add(p1, 2, 3);
                MainGrid.add(p2, 0, 2);
                MainGrid.add(p3, 0, 0);
                MainGrid.add(p4, 1, 0);
                MainGrid.add(p5, 2, 0);
                MainGrid.add(p6, 3, 0);
                MainGrid.add(p7, 3, 2);
                GridPane.setRowSpan(p2, 2);
                GridPane.setRowSpan(p3, 2);
                GridPane.setRowSpan(p4, 1);
                GridPane.setRowSpan(p5, 1);
                GridPane.setRowSpan(p6, 2);
                GridPane.setRowSpan(p7, 2);
                p1.setOpacity(0);
                p2.setOpacity(0);
                p3.setOpacity(0);
                p4.setOpacity(0);
                p5.setOpacity(0);
                p6.setOpacity(0);
                p7.setOpacity(0);
                TimeLines(new GridPane[]{p1, p2, p3, p4, p5, p6, p7}, 7, 0);
                break;
            //</editor-fold>
            case 8:
                //<editor-fold defaultstate="collapsed" desc="Case 8 Players Game">
                Players = new Player[8];
                Players[0] = new Player(CharacterDeck[23 - CharacterChoice], Roles[7], pos1);
                Players[1] = new Player(CharacterDeck[21 - CharacterChoice], Roles[6], pos2);
                Players[2] = new Player(CharacterDeck[19 - CharacterChoice], Roles[5], pos3);
                Players[3] = new Player(CharacterDeck[17 - CharacterChoice], Roles[4], pos4);
                Players[4] = new Player(CharacterDeck[15 - CharacterChoice], Roles[3], pos5);
                Players[5] = new Player(CharacterDeck[13 - CharacterChoice], Roles[2], pos6);
                Players[6] = new Player(CharacterDeck[11 - CharacterChoice], Roles[1], pos7);
                Players[7] = new Player(CharacterDeck[9 - CharacterChoice], Roles[0], pos8);
                p1 = Players[0].getTable(BackGroudPane, true);
                p2 = Players[1].getTable(BackGroudPane, false);
                p3 = Players[2].getTable(BackGroudPane, false);
                p4 = Players[3].getTable(BackGroudPane, false);
                p5 = Players[4].getTable(BackGroudPane, false);
                p6 = Players[5].getTable(BackGroudPane, false);
                p7 = Players[6].getTable(BackGroudPane, false);
                p8 = Players[7].getTable(BackGroudPane, false);
                p3.setRotationAxis(Rotate.Z_AXIS);
                p4.setRotationAxis(Rotate.Z_AXIS);
                p5.setRotationAxis(Rotate.Z_AXIS);
                p6.setRotationAxis(Rotate.Z_AXIS);
                p7.setRotationAxis(Rotate.Z_AXIS);
                p8.setRotationAxis(Rotate.Z_AXIS);
                p3.setRotate(Players[2].getCoordinatesAndRotate()[2]);
                p4.setRotate(Players[3].getCoordinatesAndRotate()[2]);
                p5.setRotate(Players[4].getCoordinatesAndRotate()[2]);
                p6.setRotate(Players[5].getCoordinatesAndRotate()[2]);
                p7.setRotate(Players[6].getCoordinatesAndRotate()[2]);
                p8.setRotate(Players[7].getCoordinatesAndRotate()[2]);
                MainGrid.add(p1, 2, 3);
                MainGrid.add(p2, 1, 3);
                MainGrid.add(p3, 0, 2);
                MainGrid.add(p4, 0, 0);
                MainGrid.add(p5, 1, 0);
                MainGrid.add(p6, 2, 0);
                MainGrid.add(p7, 3, 0);
                MainGrid.add(p8, 3, 2);
                GridPane.setRowSpan(p2, 1);
                GridPane.setRowSpan(p3, 2);
                GridPane.setRowSpan(p4, 2);
                GridPane.setRowSpan(p5, 1);
                GridPane.setRowSpan(p6, 1);
                GridPane.setRowSpan(p7, 2);
                GridPane.setRowSpan(p8, 2);
                p1.setOpacity(0);
                p2.setOpacity(0);
                p3.setOpacity(0);
                p4.setOpacity(0);
                p5.setOpacity(0);
                p6.setOpacity(0);
                p7.setOpacity(0);
                p8.setOpacity(0);
                TimeLines(new GridPane[]{p1, p2, p3, p4, p5, p6, p7, p8}, 8, 0);
                break;
            //</editor-fold>
        }
    }

    public static void setUsedDeck(DeckCard[] newDeck) {
        UsedCard = newDeck;
        UpdateUsedCardsView(UsedCard, UsedCardView, Pos.CENTER_RIGHT);
    }

    protected static void setIncidentDeck(IncidentCard[] newDeck) {
        IncidentDeck = newDeck;
        UpdateIncidentDeckView();
    }

    protected static void setStarterPlayer() {
        while (true) {
            if (Players[currentTurn].getRole().getID() == 7)
                break;
            currentTurn++;
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="GUI control Functions">
    protected static void UpdateDeckView() {
        try {
            DeckView.getChildren().remove(0, DeckView.getChildren().size() - 1);
        } catch (IllegalArgumentException ignored) {
        }
        for (int i = 0; i < Deck.length; i++) {
            GridPane View = Deck[i].getView(700D / 420 * 100, false); //900/590*
            View.setMaxSize(700, 983.3333333333333);
            View.setMinSize(700, 983.3333333333333);
            View.setTranslateY(-i * 4);
            DeckView.add(View, 0, 0);
        }
    }

    protected static void UpdateIncidentDeckView() {
        try {
            IncidentDeckView.getChildren().remove(0, IncidentDeckView.getChildren().size() - 1);
        } catch (IllegalArgumentException ignored) {
        }
        for (int i = 0; i < IncidentDeck.length; i++) {
            GridPane View = IncidentDeck[i].getView(720 / 420.0D * 100, false);
            View.setMaxSize(720, 1011.428571428571);
            View.setMinSize(720, 1011.428571428571);
            View.setTranslateY(-i * 4);
            IncidentDeckView.add(View, 0, 0);
        }
    }

    protected static void UpdateUsedCardsView(Card[] UsedDeck, GridPane UsedDeckView, Pos pos) {
        try {
            UsedDeckView.getChildren().removeAll(UsedDeckView.getChildren());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < UsedDeck.length; i++) {
            GridPane View = UsedDeck[i].getView(150, true);
            View.setMaxSize(630, 885);
            View.setMinSize(630, 885);
            View.setTranslateY(-i * 2);
            UsedDeckView.add(View, 0, 0);
        }
        try {
            Card.SetOnMouse__ViewZoom(BackGroudPane, UsedDeckView, UsedDeck[UsedDeck.length - 1], true, 100, pos);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="GUI Animations Functions">
    private static void TimeLines(GridPane[] Panes, int Players, int i) {
        Timeline tl = new Timeline();
        KeyValue k0 = new KeyValue(Panes[i].opacityProperty(), 0);
        KeyValue k1 = new KeyValue(Panes[i].opacityProperty(), 1);
        KeyFrame F0 = new KeyFrame(Duration.ZERO, k0);
        KeyFrame F1 = new KeyFrame(new Duration(Main.audio.get0AndPlay("se_ch02") + 1000.1320), k1);
        tl.getKeyFrames().addAll(F0, F1);
        if (Players == 1)
            tl.setOnFinished(e -> {
                setStarterPlayer();
                Turn0();
            });
        else {
            final int Playerss = Players - 1;
            final int is = i + 1;
            tl.setOnFinished(e -> TimeLines(Panes, Playerss, is));
        }
        tl.play();
    }

    public static void DrawAnimation(Player player, boolean FromDeck, int NofCards, boolean patchouliRoute) {
        Timeline tl = getDrawAnimation(player, FromDeck);
        tl.setOnFinished(e -> {
            player.drawCard(new DeckCard(Deck[Deck.length - 1].getID()));
            DeckCard[] newDeck = new DeckCard[Deck.length - 1];
            for (int i = 0; i < newDeck.length; i++)
                newDeck[i] = Deck[i];
            setDeck(newDeck);
            final int remainCard = NofCards - 1;
            if (remainCard != 0 && patchouliRoute)
                DrawAnimation(player, FromDeck, remainCard, true);
            else if (remainCard != 0)
                DrawAnimation(player, FromDeck, remainCard, false);
            if (remainCard == 0 && patchouliRoute)
                MatchStart();
        });
        tl.play();
    }

    public static Timeline getDrawAnimation(Player player, Node dealingCard) {
        Timeline tl = new Timeline();
        KeyValue kx0, ky0, kr0, kx1, ky1, kr1;
        try {
            MainGrid.getChildren().remove(dealingCard);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainGrid.getChildren().add(dealingCard);
        dealingCard.toFront();
        kx0 = new KeyValue(dealingCard.translateXProperty(), posDeck[0]);
        ky0 = new KeyValue(dealingCard.translateYProperty(), posDeck[1]);
        kr0 = new KeyValue(dealingCard.rotateProperty(), 0);
        kx1 = new KeyValue(dealingCard.translateXProperty(), player.getCoordinatesAndRotate()[0]);
        ky1 = new KeyValue(dealingCard.translateYProperty(), player.getCoordinatesAndRotate()[1]);
        kr1 = new KeyValue(dealingCard.rotateProperty(), player.getCoordinatesAndRotate()[2]);
        KeyFrame F0 = new KeyFrame(Duration.ZERO, kx0, ky0, kr0);
        KeyFrame F1 = new KeyFrame(new Duration(Main.audio.get0AndPlay("se_cardslide") + 475), kx1, ky1, kr1);
        tl.getKeyFrames().addAll(F0, F1);
        return tl;
    }

    public static Timeline getDrawAnimation(Player player, boolean FromDeck) {
        Timeline tl = new Timeline();
        KeyValue kx0, ky0, kr0, kx1, ky1, kr1;
        if (FromDeck || UsedCard.length == 0) {
            dealingCard = DeckView.getChildren().get(DeckView.getChildren().size() - 1);
            dealingCard.setTranslateX(posDeck[0]);
            dealingCard.setTranslateY(posDeck[1]);
        } else {
            dealingCard = UsedCardView.getChildren().get(UsedCardView.getChildren().size() - 1);
            dealingCard.setTranslateX(posDeck[0] + 685);
            dealingCard.setTranslateY(posDeck[1] + 685);
        }
        try {
            MainGrid.getChildren().remove(dealingCard);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainGrid.getChildren().add(dealingCard);
        dealingCard.toFront();
        kx0 = new KeyValue(dealingCard.translateXProperty(), posDeck[0]);
        ky0 = new KeyValue(dealingCard.translateYProperty(), posDeck[1]);
        kr0 = new KeyValue(dealingCard.rotateProperty(), 0);
        if (FromDeck) {
            kx1 = new KeyValue(dealingCard.translateXProperty(), player.getCoordinatesAndRotate()[0]);
            ky1 = new KeyValue(dealingCard.translateYProperty(), player.getCoordinatesAndRotate()[1]);
            kr1 = new KeyValue(dealingCard.rotateProperty(), player.getCoordinatesAndRotate()[2]);
        } else {
            kx1 = new KeyValue(dealingCard.translateXProperty(), -685 + player.getCoordinatesAndRotate()[0]);
            ky1 = new KeyValue(dealingCard.translateYProperty(), -685 + player.getCoordinatesAndRotate()[1]);
            kr1 = new KeyValue(dealingCard.rotateProperty(), player.getCoordinatesAndRotate()[2]);
        }
        KeyFrame F0 = new KeyFrame(Duration.ZERO, kx0, ky0, kr0);
        KeyFrame F1 = new KeyFrame(new Duration(Main.audio.get0AndPlay("se_cardslide") + 475), kx1, ky1, kr1);
        tl.getKeyFrames().addAll(F0, F1);
        return tl;
    }

    public static Timeline getFlipAnimation() {
        DeckCard Card = new DeckCard(Deck[Deck.length - 1].getID());
        GridPane CardPane = Card.getView(70000 / 420, true);
        Node FaceDownCardNode = DeckView.getChildren().get(Deck.length);
        FaceDownCardNode.toFront();
        CardPane.setRotationAxis(Rotate.Y_AXIS);
        CardPane.setRotate(-90);
        CardPane.setTranslateX(posDeck[0]);
        CardPane.setTranslateY(posDeck[1] - 4 * (Deck.length - 1));
        MainGrid.getChildren().add(CardPane);
        FaceDownCardNode.setRotationAxis(Rotate.Y_AXIS);
        KeyValue K0 = new KeyValue(CardPane.rotateProperty(), -90);
        KeyValue K1 = new KeyValue(FaceDownCardNode.rotateProperty(), 90);
        KeyValue K2 = new KeyValue(CardPane.rotateProperty(), 0);
        KeyValue K3 = new KeyValue(CardPane.translateXProperty(), posDeck[0]);
        KeyValue K4 = new KeyValue(CardPane.translateYProperty(), posDeck[1] - 4 * (Deck.length - 1));
        KeyValue K5 = new KeyValue(CardPane.translateXProperty(), posDeck[0] + 685);
        KeyValue K6 = new KeyValue(CardPane.translateYProperty(), posDeck[1] - 4 * (UsedCard.length - 1));
        KeyFrame F0 = new KeyFrame(Duration.millis(750), K0, K1);
        KeyFrame F1 = new KeyFrame(Duration.millis(1500), K2);
        KeyFrame F2 = new KeyFrame(Duration.millis(2250), K2);
        KeyFrame F3 = new KeyFrame(Duration.millis(4500), K3, K4);
        KeyFrame F4 = new KeyFrame(Duration.millis(5000), K5, K6);
        KeyFrame F5 = new KeyFrame(Duration.millis(5001), e -> MainGrid.getChildren().remove(CardPane));
        return new Timeline(F0, F1, F2, F3, F4, F5);
    }

    public static Timeline getDiscardCardAnimation(Player Player, DeckCard Discading) {
        GridPane CardView = Discading.getView(200, true);
        CardView.setTranslateX(Player.getCoordinatesAndRotate()[0]);
        CardView.setTranslateY(Player.getCoordinatesAndRotate()[1]);
        CardView.setRotate(Player.getCoordinatesAndRotate()[2]);
        return new Timeline(new KeyFrame(Duration.millis(1500), new KeyValue(CardView.translateXProperty(), posDeck[0]),
                new KeyValue(CardView.translateYProperty(), posDeck[1]),
                new KeyValue(CardView.rotateProperty(), posDeck[2])));
    }

    private static void dealCards() {
        if (dealingCard != null) {
            MainGrid.getChildren().remove(dealingCard);
            dealingCard = null;
        }
        Timeline tl = new Timeline();
        Player player = Players[currentTurn];
        KeyValue kx0, ky0, kr0, kx1, ky1, kr1;
        dealingCard = DeckView.getChildren().get(Deck.length - 1);
        MainGrid.getChildren().add(dealingCard);
        dealingCard.setTranslateX(posDeck[0]);
        dealingCard.setTranslateY(posDeck[1]);
        dealingCard.toFront();
        kx0 = new KeyValue(dealingCard.translateXProperty(), posDeck[0]);
        ky0 = new KeyValue(dealingCard.translateYProperty(), posDeck[1]);
        kr0 = new KeyValue(dealingCard.rotateProperty(), 0);
        kx1 = new KeyValue(dealingCard.translateXProperty(), player.getCoordinatesAndRotate()[0]);
        ky1 = new KeyValue(dealingCard.translateYProperty(), player.getCoordinatesAndRotate()[1]);
        kr1 = new KeyValue(dealingCard.rotateProperty(), player.getCoordinatesAndRotate()[2]);
        KeyFrame F0 = new KeyFrame(Duration.ZERO, kx0, ky0, kr0);
        KeyFrame F1 = new KeyFrame(new Duration(325), kr1);
        KeyFrame F2 = new KeyFrame(new Duration(Main.audio.get0AndPlay("se_cardslide") + 475), kx1, ky1);
        tl.getKeyFrames().addAll(F0, F1, F2);
        tl.setOnFinished(e -> {
            boolean patche = false;
            player.drawCard(new DeckCard(Deck[Deck.length - 1].getID()));
            DeckCard[] newDeck = new DeckCard[Deck.length - 1];
            for (int i = 0; i < newDeck.length; i++)
                newDeck[i] = Deck[i];
            setDeck(newDeck);
            if (currentTurn == loopnotifier)
                loopCounter++;
            if (loopCounter == 4) {
                for (Player patchouli : Players) {
                    if (patchouli.getCharacter().getID() == 17) {
                        patche = true;
                        DrawAnimation(patchouli, true, 3, true);
                    }
                }
                if (!patche)
                    MatchStart();
            } else {
                nextTurn();
                dealCards();
            }
        });
        tl.play();
    }

    @Nullable
    private static Player getHeroine() {
        for (Player player : Players)
            if (player.getRole().getID() == 7)
                return player;
        return null;
    }
    //</editor-fold>

    //TODO
    @Nullable
    private static Player[] getPartners() {
        Player[] toReturn = new Player[3];
        int i = 0;
        for (Player player : Players)
            if (player.getRole().getID() >= 8 && player.getRole().getID() <= 10) {
                toReturn[i] = player;
                i++;
            }
        return null;
    }

    public static DeckCard[] getDeck() {
        return Deck;
    }

    public static void setDeck(DeckCard[] newDeck) {
        Deck = newDeck;
        UpdateDeckView();
        if (newDeck.length == 0) {
            if (CurrentIncident != null)
                if (CurrentIncident.getID() == 3)
                    CurrentIncident = null;
            newDeck = DeckCard.shuffle(UsedCard);
            StackPane_Shuffling PPane = new StackPane_Shuffling(newDeck);
            StackPane pane = PPane.getPane();
            Timeline tl = PPane.getTimeline();
            BackGroudPane.getChildren().add(pane);
            Deck = newDeck;
            tl.setOnFinished(e -> {
                Task<Void> sleeper = Main.sleeper(1000);
                Thread thread = new Thread(sleeper);
                sleeper.setOnSucceeded(g -> {
                    BackGroudPane.getChildren().remove(pane);
                    UsedCard = new DeckCard[]{};
                    UpdateUsedCardsView(UsedCard, UsedCardView, Pos.CENTER_LEFT);
                    UpdateDeckView();
                });
                thread.start();
            });
            Main.audio.playSFX("se_cardShuffle");
            tl.play();
        }
    }

    public static DeckCard[] getUsedCard() {
        return UsedCard;
    }

    public static IncidentCard getCurrentIncident() {
        return CurrentIncident;
    }

    public static GridPane getDeckView() {
        return DeckView;
    }

    public static Pane getMainPane() {
        return MainPane;
    }

    @Contract(pure = true)
    public static int getCurrentTurn() {
        return currentTurn;
    }
}
