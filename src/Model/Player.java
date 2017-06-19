package Model;

import Controller.Battle;
import Controller.Main;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Player {
    //<editor-fold defaultState="collapse" desc="Variables">
    private int Id,
            Life = 4,
            MaxLife,
            SkipCount,
            Danmaku = 0,
            UsedDanmaku = 0,
            Range = 1,
            Distance = 0,
            MaxHand = 0;
    private final int[] CoordinatesAndRotate;
    private DeckCard[] Hand = new DeckCard[0],
            powerUp = new DeckCard[0];
    private CharacterCard Character;
    private RoleCard Role;
    private Thread thread;
    private GridPane HandCards = new GridPane(),
            powerUpCards = new GridPane(),
            RoleView,
            PlayerView;
    private TextArea PlayerStats = new TextArea();
    private Pane PatternPane;
    private boolean player,
            SpellCardAvailable = true,
            canSkip = true,
            ShouldSkip = false;
    private boolean StatsVisible = false;

    //</editor-fold>
    public Player(CharacterCard c, RoleCard r, int[] CandR) {
        Character = c;
        setRole(r);
        CoordinatesAndRotate = CandR;
        if (Role.getID() == 7)
            Life = 5;
    }

    /**
     * Set Danmaku limit based on players cards and Skills
     */
    private void setDanmaku() {
        Danmaku = 1;
        if (Character.getID() == 7)
            Danmaku += 1;
        if (Character.getID() == 8)
            Danmaku += 2;
        for (DeckCard power_up : powerUp) {
            if (power_up.getID() >= 33 && power_up.getID() <= 38)
                Danmaku += 1;
            if (power_up.getID() == 74)
                Distance += 1;
        }
    }

    /**
     * Manually set Danmaku Limit
     *
     * @param limit: Limit of Danmaku
     */
    public void setDanmaku(int limit) {
        Danmaku = limit;
        updateStats();
    }

    /**
     * Set Range limit based on players cards and Skills
     */
    private void setRange() {
        Range = 1;
        if (Character.getID() == 2)
            Range += 2;
        if (Character.getID() == 7)
            Range += 1;
        for (DeckCard power_up : powerUp) {
            if (power_up.getID() == 31)
                Range += 3;
            if (power_up.getID() >= 33 && power_up.getID() <= 38)
                Range += 1;
        }
    }

    /**
     * Manually set Range Limit
     *
     * @param limit: Limit of Range
     */
    public void setRange(int limit) {
        Range = limit;
        updateStats();
    }


    /**
     * Turn on/off the SpellCard Availability
     *
     * @param bln: true: Available, false:Not Available
     */
    public void setSpellCardAvailable(boolean bln) {
        SpellCardAvailable = bln;
        updateStats();
    }

    /**Automatically sets Distance bonus of the player
     * Based on Current power-ups, Skills and Game effects
     */
    private void setDistance() {
        Distance = 0;
        if (Character.getID() == 10)
            Distance += 1;
        for (DeckCard power_up : powerUp) {
            if (power_up.getID() >= 8 && power_up.getID() <= 10)
                Distance += 2;
            if (power_up.getID() == 74)
                Distance += 1;
        }
    }

    /** Manually sets Distance bonus of the player
     * @param newDistance the New Distance
     */
    public void setDistance(int newDistance) {
        Distance = newDistance;
        updateStats();
    }

    /** Automatically sets the Hand Limit of the player
     *  Based on Current power-ups, Skills and Game effects
     */
    private void setMaxHand() {
        MaxHand = 4;
        if (Role.getID() == 7)
            MaxHand += 1;
        // if Patchouli{
        if (Character.getID() == 17)
            MaxHand += 3;
        else //Sorcerer’s Sutra Scroll Doesn't affect patchouli}
            for (DeckCard card : powerUp)
                if (card.getID() == 67)
                    MaxHand += 3;
    }

    /** Set if Player can and Should Skip it's next turn
     */
    private void setSkipTurn() {
        if (ShouldSkip) {
            SkipCount = 0;
            canSkip = false;
        }
        if (!canSkip)
            SkipCount++;
        if (SkipCount >= 2)
            canSkip = true;
    }

    /** Automatically set Player's max life
     * Based in its role
     */
    private void setMaxLife() {
        MaxLife = 4;
        if (Role.getID() == 7 || Role.getID() == 4 || Role.getID() == 16)
            MaxLife += 1;
        if (Life > MaxLife)
            Life = MaxLife;
        updateStats();
    }

    /** Return Player's stats to the Current value
     * based on its card, skill, power-ups, etc...
     *  at the start of the turn
     */
    public void resetStats() {
        SpellCardAvailable = true;
        UsedDanmaku = 0;
        setDanmaku();
        setRange();
        setDistance();
        setMaxHand();
        setSkipTurn();
        setMaxLife();
        updateStats();
    }

    /** Get the current player's Cards in hand
     * @return Players's Card in Hand Array
     */
    public DeckCard[] getHand() {
        return Hand;
    }

    /** Set the Player's Card in hand based in an Array
     * @param hand DeckCard Array
     */
    public void setHand(DeckCard[] hand) {
        Hand = hand;
        updateHandGrid(PatternPane);
    }

    /** Generate a GridPane to Display Player's Card in Hand
     * on the Screen
     * @return GridPane with Player's card
     */
    GridPane getHandGrid() {
        return HandCards;
    }

    /** Gets the Current Player's Role Card
     * @return Player's Role Card
     */
    public RoleCard getRole() {
        return Role;
    }

    /**  Set a new Role for the Player
     * @param role new RoleCard
     */
    public void setRole(RoleCard role) {
        Role = role;
        setMaxLife();
        updateRole(PatternPane);
    }

    /** Generates a GridPane to Display All Player
     * characteristics, Cards, Role, Character, power-ups
     * and Stats
     * @param PatternPane Pane were the Grid is going to be displayed
     * @param bln Player's card should be face-up
     * @return GrindPane to be displayed
     */
    public GridPane getTable(Pane PatternPane, boolean bln) {
        this.PatternPane = PatternPane;
        player = bln;
        GridPane PlayerPane = new GridPane();
        PlayerView = PlayerPane;
        PlayerPane.setPrefSize(1800, 860);
        PlayerPane.setMinSize(1800, 860);
        PlayerPane.setMaxSize(1800, 860);

        //<editor-fold defaultState="collapsed" desc="ColumnConstraints">
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        ColumnConstraints col3 = new ColumnConstraints();
        col1.setPrefWidth(600);
        col1.setMinWidth(600);
        col1.setMaxWidth(600);
        col2.setPrefWidth(890);
        col2.setMinWidth(890);
        col2.setMaxWidth(890);
        col3.setPrefWidth(300);
        col3.setMinWidth(300);
        col3.setMaxWidth(300);
        PlayerPane.getColumnConstraints().addAll(col1, col2, col3);
        //</editor-fold>
        //<editor-fold defaultState="collapsed" desc="RowConstraints">
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        row1.setPrefHeight(430);
        row1.setMinHeight(430);
        row1.setMaxHeight(430);
        row2.setPrefHeight(430);
        row2.setMinHeight(430);
        row2.setMaxHeight(430);
        PlayerPane.getRowConstraints().addAll(row1, row2);
        //</editor-fold>

        updateHandGrid(this.PatternPane);
        updatePowerUps(this.PatternPane);

        GridPane CharacterView = Character.getView(100, true);
        PlayerStats.setText(String.format(Main.lang.Lang.PlayerStats, Life, Range, Distance, Danmaku - UsedDanmaku > 500 ? "Infinite" : Integer.toString(Danmaku - UsedDanmaku), SpellCardAvailable ? Main.lang.Lang.Yes : Main.lang.Lang.No, MaxHand));
        String Path;
        Font fon = null;
        try {
            Path = (new File("src/Fonts/Danmaku.ttf")).getCanonicalPath();
            fon = Font.loadFont(new FileInputStream(new File(Path)), 110);
        } catch (IOException ignored) {
        }
        PlayerStats.setFont(fon);
        PlayerStats.getStylesheets().add("Model/TextArea.css");
        PlayerStats.setEditable(false);
        PlayerStats.setTranslateX(3);
        PlayerStats.setVisible(StatsVisible);
        PlayerPane.add(powerUpCards, 1, 1);
        PlayerPane.add(CharacterView, 0, 1);
        PlayerPane.add(PlayerStats, 0, 0);
        PlayerPane.add(RoleView, 2, 1);
        PlayerPane.add(HandCards, 0, 0);
        GridPane.setRowSpan(PlayerStats, 2);
        GridPane.setColumnSpan(PlayerStats, 3);
        PlayerStats.toFront();

        updateRole(this.PatternPane);

        SetOnMouse__ViewZoom(this.PatternPane, CharacterView, Character, true, Main.H * 0.5221476510067114 / 420 * 100);
        PlayerPane.setStyle("-fx-background-image: url('Images/InGame/PlayerTable.png'); -fx-background-size: stretch");
        PlayerPane.setScaleX(0.99);
        return PlayerView;
    }

    /** gets the player's view GridPane
     * @return Player's view GridPane
     */
    public GridPane getTable() {
        return PlayerView;
    }

    /** Generates Role view GridPane to be displayed
     * in PLayer's View GridPane
     * @return Player's RolePlay GridPane
     */
    GridPane getRoleView() {
        return RoleView;
    }

    /** Gets the Current Player's Life point
     * @return Player's Life
     */
    public int getLife() {
        return Life;
    }

    /**Get Player's Location on PatternPane
     * @return Player's Location Array
     */
    public int[] getCoordinatesAndRotate() {
        return CoordinatesAndRotate;
    }

    /** Get the Current Player's Character Card
     * @return PLayer's Character Card
     */
    public CharacterCard getCharacter() {
        return Character;
    }

    /**Gets the Player's max hand size
     * @return Player's max hand size
     */
    public int getMaxHand() {
        return MaxHand;
    }

    /** Checks if Player can Play Danmaku Cards
     *
     * @return true if player can Play Danmaku Card
     */
    public boolean canPlayDanmaku() {
        return Danmaku > UsedDanmaku;
    }

    /** set the Player's Active Power Ups
     * @param powerUp PowerUps Cards Array
     */
    private void setPowerUp(DeckCard[] powerUp) {
        this.powerUp = powerUp;
    }

    /** Swap Current Player's Role with another Player
     * @param Player2 Player with whom the role is exchanged
     */
    public void swapRole(Player Player2) {
        RoleCard Temp1 = new RoleCard(Role.getID());
        RoleCard Temp2 = new RoleCard(Player2.getRole().getID());
        setRole(Temp2);
        Player2.setRole(Temp1);
        setMaxHand();
        setMaxLife();
        Player2.setMaxLife();
        if (this.getRole().getID() == 7) this.ModifyLife(1);
        if (Player2.getRole().getID() == 7) Player2.ModifyLife(1);
        Player2.setMaxHand();
    }

    /** Adds a Powerup card To the Active Power-Ups Array
     * @param P Power-up to add
     */
    public void addPowerup(DeckCard P) {
        int n = powerUp.length;
        DeckCard[] newPowerUp = new DeckCard[n + 1];
        System.arraycopy(powerUp, 0, newPowerUp, 0, n);
        newPowerUp[n] = P;
        setPowerUp(newPowerUp);
        updatePowerUps(PatternPane);
    }

    /** Swap Current Player's Hand with another Player
     * @param Player2 Player with whom the hand is exchanged
     */
    public void swapHand(Player Player2) {
        DeckCard[] Temp1 = Hand;
        DeckCard[] Temp2 = Player2.getHand();
        setHand(Temp2);
        Player2.setHand(Temp1);
    }

    /**Placer a new Card In Player's hand
     * @param Draw new Card
     */
    public void drawCard(DeckCard Draw) {
        int n = Hand.length;
        DeckCard[] newHand = new DeckCard[n + 1];
        System.arraycopy(Hand, 0, newHand, 0, n);
        newHand[n] = Draw;
        setHand(newHand);
    }

    /** Modify Player's Life in a specific amount
     * it will never be less than 0 or higher than
     * Player's max life
     * @param amount how much life is going to be added
     */
    public void ModifyLife(int amount) {
        if (Battle.getCurrentIncident() != null)
            if (Battle.getCurrentIncident().getID() == 14 && amount > 0)
                return;
        int CardsToDraw = Life > -amount ? -amount : Life;
        Life += amount;
        if (amount < 0) {
            Main.audio.playSFX("se_loselife");
            Pane pane = new Pane();
            pane.setStyle("-fx-background-color: rgba(255,0,0,0.4)");
            PlayerView.add(pane, 0, 0);
            GridPane.setRowSpan(pane, 2);
            GridPane.setColumnSpan(pane, 3);
            pane.toFront();
            Timeline tl = new Timeline();
            KeyValue k0 = new KeyValue(PlayerView.translateXProperty(), 0);
            KeyValue k1 = new KeyValue(PlayerView.translateXProperty(), 5);
            KeyValue k2 = new KeyValue(PlayerView.translateXProperty(), -5);
            for (int i = 0; i < 25; i++) {
                KeyFrame Frame;
                switch (i % 3) {
                    case 0:
                        Frame = new KeyFrame(new Duration(50 * i), k0);
                        break;
                    case 1:
                        Frame = new KeyFrame(new Duration(50 * i), k1);
                        break;
                    default:
                        Frame = new KeyFrame(new Duration(50 * i), k2);
                        break;
                }
                tl.getKeyFrames().add(Frame);
            }
            tl.setOnFinished(event -> PlayerView.getChildren().remove(pane));
            Battle.DrawAnimation(this, true, CardsToDraw, false);
            tl.play();
        } else {
            Main.audio.playSFX("se_1UP");
            Pane pane = new Pane();
            pane.setStyle("-fx-background-color: rgba(0,255,0,0.4)");
            PlayerView.add(pane, 0, 0);
            GridPane.setRowSpan(pane, 2);
            GridPane.setColumnSpan(pane, 3);
            pane.toFront();
            Timeline tl = new Timeline();
            KeyValue k0 = new KeyValue(PlayerView.translateXProperty(), 0);
            KeyValue k1 = new KeyValue(PlayerView.translateXProperty(), 5);
            KeyValue k2 = new KeyValue(PlayerView.translateXProperty(), -5);
            KeyFrame Frame;
            for (int i = 0; i < 25; i++) {
                switch (i % 3) {
                    case 0:
                        Frame = new KeyFrame(new Duration(50 * i), k0);
                        break;
                    case 1:
                        Frame = new KeyFrame(new Duration(50 * i), k1);
                        break;
                    default:
                        Frame = new KeyFrame(new Duration(50 * i), k2);
                        break;
                }
                tl.getKeyFrames().add(Frame);
            }
            tl.setOnFinished(event -> PlayerView.getChildren().remove(pane));
            tl.play();
        }
        if (Life < 0) Life = 0;
        updateStats();
    }

    /**Updates Player's Visible Hand GridPane
     * @param PatternPane Pane were Hand GridPane would be located
     */
    private void updateHandGrid(Pane PatternPane) {
        HandCards.getChildren().removeAll(HandCards.getChildren());
        HandCards.getColumnConstraints().removeAll();
        HandCards.getColumnConstraints().remove(0, HandCards.getColumnConstraints().size());
        for (int i = 0; i < Hand.length; i++) {
            ColumnConstraints col = new ColumnConstraints(1500 / (Hand.length - 1 > 0 ? Hand.length - 1 : 1));
            if (i + 1 == Hand.length) {
                col.setMaxWidth(300);
                col.setMinWidth(300);
            }
            col.setHalignment(HPos.LEFT);
            HandCards.getColumnConstraints().add(col);
            GridPane view = Hand[i].getView(70.2380952381, player);
            HandCards.add(view, i, 0);
            SetOnMouse__ViewZoom(PatternPane, view, Hand[i], player, Main.H * 0.5221476510067114 / 590 * 100);
        }
    }

    /**Updates Player's Visible Power-ups GridPane
     * @param PatternPane Pane were Power-ups GridPane would be located
     */
    private void updatePowerUps(Pane PatternPane) {
        powerUpCards.getChildren().removeAll();
        powerUpCards.getColumnConstraints().removeAll();
        powerUpCards.getColumnConstraints().remove(0, powerUpCards.getColumnConstraints().size());
        for (int i = 0; i < powerUp.length; i++) {
            ColumnConstraints col = new ColumnConstraints();
            if (i + 1 == powerUp.length) {
                col.setMaxWidth(300);
                col.setMinWidth(300);
            }
            col.setHalignment(HPos.LEFT);
            powerUpCards.getColumnConstraints().add(col);
            GridPane view = powerUp[i].getView(70.2380952381, true);
            powerUpCards.add(view, i, 0);
            SetOnMouse__ViewZoom(PatternPane, view, powerUp[i], true, Main.H * 0.5221476510067114 / 590 * 100);
        }
    }

    /**Updates Player's Visible Role GridPane
     * @param PatternPane Pane were Role GridPane would be located
     */
    private void updateRole(Pane PatternPane) {
        RoleView = Role.getView(70.2380952381, Role.isRevealed());
        if (PlayerView != null) {
            RoleView.setTranslateX(0);
            RoleView.setTranslateY(0);
            RoleView.setRotate(0);
            PlayerView.getChildren().remove(RoleView);
            PlayerView.add(RoleView, 2, 1);
            SetOnMouse__ViewZoom(this.PatternPane, RoleView, Role, player || Role.isRevealed(), Main.H * 0.5221476510067114 / 590 * 100);
        }
    }

    /**Updates Player's Current Stats Visible Values
     */
    private void updateStats() {
        PlayerStats.setText(String.format(Main.lang.Lang.PlayerStats,
                Life,
                Range > 500 ? "Infinite" : Range,
                Distance,
                Danmaku - UsedDanmaku > 500 ? "Infinite" : Integer.toString(Danmaku - UsedDanmaku),
                SpellCardAvailable ? Main.lang.Lang.Yes : Main.lang.Lang.No,
                MaxHand));
    }

    /**Set Card to be Zoomed when Mouse is over it for some time
     * @param PatternPane Pane were Zoomed Card will be displayed
     * @param View Card's view
     * @param card Card
     * @param bln Is face up
     * @param size_percentage sizer
     */
    public void SetOnMouse__ViewZoom(Pane PatternPane, GridPane View, Card card, boolean bln, double size_percentage) {
        View.setOnMouseEntered(e -> {
            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        failed();
                    }
                    return null;
                }
            };

            sleeper.setOnSucceeded(event -> PatternPane.getChildren().add(card.getView(size_percentage, bln)));
            thread = new Thread(sleeper);
            thread.start();
        });

        View.setOnMouseExited(e -> {
            try {
                thread.stop();
                ;
                if (PatternPane.getChildren().size() > 2)
                    PatternPane.getChildren().remove(1, PatternPane.getChildren().size());
                else if (PatternPane.getChildren().size() == 2)
                    PatternPane.getChildren().remove(1);
            } catch (NullPointerException ignored) {
            }
        });


    }

    /** Turns On/Off Visibility of Player's Stats
     */
    public void viewStats() {
        StatsVisible = !StatsVisible;
        PlayerStats.setVisible(StatsVisible);
    }
}
