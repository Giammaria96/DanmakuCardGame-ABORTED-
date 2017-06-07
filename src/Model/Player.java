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
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Player {
    //<editor-fold defaultstate="collapse" desc="Varaibles">
    private int             Id,
                            Life=4,
                            MaxLife,
                            SkipCount,
                            Danmaku=0,
                            UsedDanmaku=0,
                            Range=1,
                            Distance=0,
                            MaxHand=0;
    private int[]           CoordinatesAndRotate = new int[3];
    private DeckCard[]      Hand = new DeckCard[0],
                            powerup = new DeckCard[0];
    private CharacterCard   Character;
    private RoleCard        Role;
    private Thread          thread;
    private GridPane        Handcards = new GridPane(),
                            powerupcards = new GridPane(),
                            RoleView,
                            PlayerView;
    private TextArea        PlayerStats= new TextArea();
    private Pane            PatternPane;
    private boolean         player,
                            SpellcardAvaible=true,
                            canSkip=true,
                            ShouldSkip=false;
    private boolean  StatsVisible=false;
    //</editor-fold>
    public Player(CharacterCard c, RoleCard r, int[] CandR){
        Character = c;
        setRole(r);
        CoordinatesAndRotate=CandR;
        if (Role.getID()==7)
            Life=5;
    }

    /**Set Danmaku limit based on players cards and Skills
     */
    private void setDanmaku(){
        Danmaku=1;
        if (Character.getID()==7)
            Danmaku+=1;
        if (Character.getID()==8)
            Danmaku+=2;
        for (DeckCard power_up : powerup) {
            if (power_up.getID()>=33 && power_up.getID()<=38)
                Danmaku+=1;
            if (power_up.getID()==74)
                Distance+=1;
        }
    }

    /**Manually set Danmaku Limit
     * @param limit: Limit of Danmaku
     * */
    public void setDanmaku(int limit){
        Danmaku=limit;
        updateStats();
    }

    /**Set Range limit based on players cards and Skills
     */
    private void setRange(){
        Range=1;
        if (Character.getID()==2)
            Range+=2;
        if (Character.getID()==7)
            Range+=1;
        for (DeckCard power_up : powerup) {
            if (power_up.getID()==31)
                Range+=3;
            if (power_up.getID()>=33 && power_up.getID()<=38)
                Range+=1;
        }
    }

    /**Manually set Range Limit
     * @param limit: Limit of Range
     * */
    public void setRange(int limit){
        Range=limit; updateStats();
    }


    /**Turn on/off the Spellcard Availability
     * @param bln: true: Available, false:Not Available
     * */
    public void setSpellcardAvaible(boolean bln){
        SpellcardAvaible=bln;
        updateStats();
    }

    private void setDistance(){
        Distance=0;
        if (Character.getID()==10)
            Distance+=1;
        for (DeckCard power_up : powerup) {
            if (power_up.getID()>=8 && power_up.getID()<=10)
                Distance+=2;
            if (power_up.getID()==74)
                Distance+=1;
        }
    }
    public void setDistance(int limit){
        Distance=limit;
        updateStats();
    }
    private void setMaxHand(){
        MaxHand=4;
        if (Role.getID()==7)
            MaxHand+=1;
        // if Patchouli{
        if (Character.getID()==17)
            MaxHand+=3;
        else //Sorcerer’s Sutra Scroll Doesn't affect patchouli}
            for (DeckCard card : powerup)
                if (card.getID()==67)
                    MaxHand+=3;
    }
    private void setSkipTurn(){
        if (ShouldSkip) {
            SkipCount = 0;
            canSkip=false;
        }
        if (!canSkip)
            SkipCount++;
        if (SkipCount>=2)
            canSkip=true;
    }
    private void setMaxLife(){
        MaxLife=4;
        if (Role.getID()==7 || Role.getID()==4||Role.getID()==16)
            MaxLife+=1;
        if(Life>MaxLife)
            Life=MaxLife;
        updateStats();
    }
    public void resetStats(){
        SpellcardAvaible=true;
        UsedDanmaku=0;
        setDanmaku();
        setRange();
        setDistance();
        setMaxHand();
        setSkipTurn();
        setMaxLife();
        updateStats();
    }

    public DeckCard[] getHand() {
        return Hand;
    }
    public GridPane getHandGrid(){return Handcards;}
    public RoleCard getRole() {
        return Role;
    }
    public GridPane getTable(Pane PatternPane, boolean bln){
        this.PatternPane=PatternPane;
        player=bln;
        GridPane PlayerPane = new GridPane();
        PlayerPane.setPrefSize(1800,860);
        PlayerPane.setMinSize(1800,860);
        PlayerPane.setMaxSize(1800,860);

        //<editor-fold defaultstate="collapsed" desc="ColumnConstraints">
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
        PlayerPane.getColumnConstraints().addAll(col1,col2,col3);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="RowConstraints">
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        row1.setPrefHeight(430);
        row1.setMinHeight(430);
        row1.setMaxHeight(430);
        row2.setPrefHeight(430);
        row2.setMinHeight(430);
        row2.setMaxHeight(430);
        PlayerPane.getRowConstraints().addAll(row1,row2);
        //</editor-fold>

        updateHandGrid(PatternPane);
        updatePowerups(PatternPane);

        GridPane CharacterView = Character.getView(100,true);
        PlayerStats.setText(String.format(Main.lang.Lang.PlayerStats,Life,Range,Distance,Danmaku-UsedDanmaku>500?"Infinite":Integer.toString(Danmaku-UsedDanmaku),SpellcardAvaible?Main.lang.Lang.Yes:Main.lang.Lang.No,MaxHand));
        String Path = null;
        Font fon = null;
        try {
            Path = (new File("src/Fonts/Danmaku.ttf")).getCanonicalPath();
            fon = Font.loadFont(new FileInputStream(new File(Path)), 110);
        } catch (IOException e) {}
        PlayerStats.setFont(fon);
        PlayerStats.getStylesheets().add("Model/TextArea.css");
        PlayerStats.setEditable(false);
        PlayerStats.setTranslateX(3);
        PlayerStats.setVisible(StatsVisible);
        PlayerPane.add(powerupcards,1,1);
        PlayerPane.add(CharacterView,0,1);
        PlayerPane.add(PlayerStats,0,0);
        PlayerPane.add(RoleView,2,1);
        PlayerPane.add(Handcards,0,0);
        PlayerPane.setRowSpan(PlayerStats,2 );
        PlayerPane.setColumnSpan(PlayerStats,3 );
        PlayerStats.toFront();
        updateRole(PatternPane);

        SetOnMouse__ViewZoom(PatternPane, RoleView, Role, bln, Main.H*0.5221476510067114/590*100);
        SetOnMouse__ViewZoom(PatternPane, CharacterView, Character, true , Main.H*0.5221476510067114/420*100);
        PlayerPane.setStyle("-fx-background-image: url('Images/InGame/PlayerTable.png'); -fx-background-size: stretch");
        PlayerPane.setScaleX(0.99);
        PlayerView = PlayerPane;
        return PlayerView;
    }
    public GridPane getTable(){return PlayerView;}
    public GridPane getRoleView(){
        return RoleView;
    }
    public int getLife(){return Life;}
    public int[] getCoordinatesAndRotate() {
        return CoordinatesAndRotate;
    }
    public CharacterCard getCharacter() {
        return Character;
    }
    public int getMaxHand(){return MaxHand;}
    public boolean canPlayDanmaku(){return Danmaku>UsedDanmaku;}

    public void setHand(DeckCard[] hand) {
        Hand = hand;
        updateHandGrid(PatternPane);
    }
    public void setRole(RoleCard role) {
        Role = role;
        setMaxLife();
        updateRole(PatternPane);
    }
    private void setPowerup(DeckCard[] powerup) {
        this.powerup = powerup;
    }
    public void swapRole(Player Player2){
        RoleCard Temp1 = new RoleCard(Role.getID());
        RoleCard Temp2 = new RoleCard(Player2.getRole().getID());
        setRole(Temp2);
        Player2.setRole(Temp1);
        setMaxHand();
        setMaxLife();
        Player2.setMaxLife();
        if (this.getRole().getID()==7) this.ModifyLife(1);
        if (Player2.getRole().getID()==7) Player2.ModifyLife(1);
        Player2.setMaxHand();
    }

    public void addPowerup(DeckCard P){
        int n = powerup.length;
        DeckCard[] newpowerup = new DeckCard[n+1];
        for (int i = 0; i < n; i++) {
            newpowerup[i] = powerup[i];
        }
        newpowerup[n] = P;
        setPowerup(newpowerup);
        updatePowerups(PatternPane);
    }

    public void swapHand(Player Player2){
        DeckCard[] Temp1 = Hand;
        DeckCard[] Temp2 = Player2.getHand();
        setHand(Temp2);
        Player2.setHand(Temp1);
    }

    public void drawCard(DeckCard Draw){
        int n = Hand.length;
        DeckCard[] newHand = new DeckCard[n+1];
        for (int i = 0; i < n; i++) {
            newHand[i] = Hand[i];
        }
        newHand[n] = Draw;
        setHand(newHand);
    }

    public void ModifyLife(int amount){
        if (Battle.getCurrentIncident()!=null)
            if (Battle.getCurrentIncident().getID()==14 && amount>0)
                return;
        int CardsToDraw = Life>-amount?-amount:Life;;
        Life+=amount;
        if (amount<0) {
            Main.audio.playSFX("se_loselife");
            Pane pane = new Pane();
            pane.setStyle("-fx-background-color: rgba(255,0,0,0.4)");
            PlayerView.add(pane,0,0);
            PlayerView.setRowSpan(pane,2);
            PlayerView.setColumnSpan(pane,3);
            pane.toFront();
            Timeline tl = new Timeline();
            KeyValue k0 = new KeyValue(PlayerView.translateXProperty(),0);
            KeyValue k1 = new KeyValue(PlayerView.translateXProperty(),5);
            KeyValue k2 = new KeyValue(PlayerView.translateXProperty(),-5);
            for (int i = 0; i < 25; i++) {
                KeyFrame Frame;
                switch (i % 3) {
                    case 0 :Frame = new KeyFrame(new Duration(50 * i),k0);break;
                    case 1 :Frame = new KeyFrame(new Duration(50 * i),k1);break;
                    default:Frame = new KeyFrame(new Duration(50 * i),k2);break;
                }
                tl.getKeyFrames().add(Frame);
            }
            tl.setOnFinished(event -> PlayerView.getChildren().remove(pane));
            Battle.DrawAnimation(this,true, CardsToDraw,false);
            tl.play();
        }
        else{
            Main.audio.playSFX("se_1UP");
            Pane pane = new Pane();
            pane.setStyle("-fx-background-color: rgba(0,255,0,0.4)");
            PlayerView.add(pane,0,0);
            PlayerView.setRowSpan(pane,2);
            PlayerView.setColumnSpan(pane,3);
            pane.toFront();
            Timeline tl = new Timeline();
            KeyValue k0 = new KeyValue(PlayerView.translateXProperty(),0);
            KeyValue k1 = new KeyValue(PlayerView.translateXProperty(),5);
            KeyValue k2 = new KeyValue(PlayerView.translateXProperty(),-5);
            KeyFrame Frame;
            for (int i = 0; i < 25; i++) {
                switch (i % 3) {
                    case 0 :Frame = new KeyFrame(new Duration(50 * i),k0);break;
                    case 1 :Frame = new KeyFrame(new Duration(50 * i),k1);break;
                    default:Frame = new KeyFrame(new Duration(50 * i),k2);break;}
                tl.getKeyFrames().add(Frame);}
            tl.setOnFinished(event -> PlayerView.getChildren().remove(pane));
            tl.play();
        }
        if (Life<0) Life=0;
        updateStats();
    }


    private void updateHandGrid(Pane PatternPane){
        Handcards.getChildren().removeAll(Handcards.getChildren());
        Handcards.getColumnConstraints().removeAll();
        Handcards.getColumnConstraints().remove(0,Handcards.getColumnConstraints().size());
        for (int i = 0; i < Hand.length; i++) {
            ColumnConstraints col = new ColumnConstraints(1500/(Hand.length-1>0?Hand.length-1:1));
            if (i+1 == Hand.length) {
                col.setMaxWidth(300);
                col.setMinWidth(300);
            }
            col.setHalignment(HPos.LEFT);
            Handcards.getColumnConstraints().add(col);
            GridPane view = Hand[i].getView(70.2380952381,player);
            Handcards.add(view,i,0);
            SetOnMouse__ViewZoom(PatternPane, view, Hand[i],player, Main.H*0.5221476510067114/590*100);
        }
    }
    private void updatePowerups(Pane PatternPane){
        powerupcards.getChildren().removeAll();
        powerupcards.getColumnConstraints().removeAll();
        powerupcards.getColumnConstraints().remove(0,powerupcards.getColumnConstraints().size());
        for (int i = 0; i < powerup.length; i++) {
            ColumnConstraints col = new ColumnConstraints();
            if (i+1 == powerup.length) {
                col.setMaxWidth(300);
                col.setMinWidth(300);
            }
            col.setHalignment(HPos.LEFT);
            powerupcards.getColumnConstraints().add(col);
            GridPane view = powerup[i].getView(70.2380952381,true);
            powerupcards.add(view,i,0);
            SetOnMouse__ViewZoom(PatternPane, view, powerup[i],true, Main.H*0.5221476510067114/590*100);
        }
    }
    private void updateRole(Pane PatternPane){
        RoleView = Role.getView(70.2380952381,Role.isRevealed());
        SetOnMouse__ViewZoom(PatternPane, RoleView, Role, player || Role.isRevealed(), Main.H*0.5221476510067114/590*100);
        if (PlayerView!=null) {
            RoleView.setTranslateX(0);
            RoleView.setTranslateY(0);
            RoleView.setRotate(0);
            PlayerView.getChildren().remove(RoleView);
            PlayerView.add(RoleView, 2, 1);
        }
    }
    private void updateStats(){
        PlayerStats.setText(String.format(Main.lang.Lang.PlayerStats,
                Life,
                Range>500?"Infinite":Range,
                Distance,
                Danmaku-UsedDanmaku>500?"Infinite":Integer.toString(Danmaku-UsedDanmaku),
                SpellcardAvaible?Main.lang.Lang.Yes:Main.lang.Lang.No,
                MaxHand));
    }
    public void SetOnMouse__ViewZoom(Pane PatternPane, GridPane View, Card card, boolean bln, double size_percentage) {
        View.setOnMouseEntered(e-> {
            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        failed();
                    }
                    return null;
                }
            };
            sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    PatternPane.getChildren().add(card.getView(size_percentage, bln));
                }
            });
            thread = new Thread(sleeper);
            thread.start();
        });

        View.setOnMouseExited(e -> {
            try {
                thread.stop();
                if (PatternPane.getChildren().size() > 2)
                    PatternPane.getChildren().remove(1, PatternPane.getChildren().size());
                else if (PatternPane.getChildren().size() == 2)
                    PatternPane.getChildren().remove(1);
            }
            catch (NullPointerException error){}
        });



    }

    public void viewStats(){
        StatsVisible = !StatsVisible?true:false;
        PlayerStats.setVisible(StatsVisible);
    }

}