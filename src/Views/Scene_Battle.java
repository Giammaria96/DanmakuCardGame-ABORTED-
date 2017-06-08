package Views;

import Controller.Battle;
import Controller.Main;
import Model.DeckCard;
import Model.IncidentCard;
import Model.Player;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.io.*;

public class Scene_Battle extends Battle {


    private static void initComponent() {
        UsedCard = new DeckCard[]{};
        CollectedCard = new DeckCard[]{};
        UsedIncident = new IncidentCard[]{};
        MainPane = new StackPane();
        BackGroudPane = new StackPane();
        DeckView = new GridPane();
        IncidentDeckView = new GridPane();
        UsedCardView = new GridPane();
        usedIncidentView = new GridPane();
        CollectedIncidentCardView = new GridPane();
        CurrentIncident = null;
        currentTurn = 0;
        MainGrid = getMainGridPane();
        CentralGrid = getCentralGridPane();
        MenuPane = getMenuStackPane();
    }

    public static Scene scene() {
        initComponent();
        DeckView.setMaxSize(720.0D, 815.0D);
        DeckView.setMinSize(720.0D, 815.0D);
        IncidentDeckView.setMaxSize(720.0D, 815.0D);
        IncidentDeckView.setMinSize(720.0D, 815.0D);
        MainPane.getChildren().add(MainGrid);
        MainPane.setMaxSize(5320.0D, 3600.0D);
        MainPane.setPrefSize(5320.0D, 3600.0D);
        MainPane.setMinSize(5320.0D, 3600.0D);
        MainPane.setScaleX(Main.W / 5320.0D);
        MainPane.setScaleY(Main.H / 3600.0D);
        BackGroudPane.setStyle(" -fx-background-color: transparent; -fx-background-image: url(\'/images/InGame/rough_wood.jpg\'); -fx-background-position: center center; -fx-background-repeat: stretch;-fx-background-size: cover;");
        return new Scene(BackGroudPane);
    }

    private static GridPane getMainGridPane() {
        GridPane MainGrid = new GridPane();
        ColumnConstraints col1 = new ColumnConstraints(860.0D, 860.0D, 860.0D);
        ColumnConstraints col2 = new ColumnConstraints(1800.0D, 1800.0D, 1800.0D);
        ColumnConstraints col3 = new ColumnConstraints(1800.0D, 1800.0D, 1800.0D);
        ColumnConstraints col4 = new ColumnConstraints(860.0D, 860.0D, 860.0D);
        col1.setHalignment(HPos.CENTER);
        col4.setHalignment(HPos.CENTER);
        RowConstraints row1 = new RowConstraints(860.0D, 860.0D, 860.0D);
        RowConstraints row2 = new RowConstraints(940.0D, 940.0D, 940.0D);
        RowConstraints row3 = new RowConstraints(940.0D, 940.0D, 940.0D);
        RowConstraints row4 = new RowConstraints(860.0D, 860.0D, 860.0D);
        MainGrid.getColumnConstraints().addAll(col1, col2, col3, col4);
        MainGrid.getRowConstraints().addAll(row1, row2, row3, row4);
        return MainGrid;
    }

    private static GridPane getCentralGridPane() {
        GridPane CentralPane = new GridPane();
        CentralPane.setAlignment(Pos.CENTER);
        CentralPane.getColumnConstraints().addAll(new ColumnConstraints(720.0D, 720.0D, 720.0D), new ColumnConstraints(720.0D, 720.0D, 720.0D), new ColumnConstraints(720.0D, 720.0D, 720.0D), new ColumnConstraints(720.0D, 720.0D, 720.0D), new ColumnConstraints(720.0D, 720.0D, 720.0D));
        CentralPane.getRowConstraints().addAll(new RowConstraints(100.0D, 100.0D, 100.0D), new RowConstraints(815.0D, 815.0D, 815.0D), new RowConstraints(815.0D, 815.0D, 815.0D), new RowConstraints(150.0D, 150.0D, 150.0D));
        Label[] steps = new Label[]{step1, step2, step3, step4, step5};
        int var3 = steps.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            Label step = steps[var4];
            step.setMaxSize(720.0D, 100.0D);
            step.setMinSize(720.0D, 100.0D);
            step.setFont(new Font("Times New Roman", 65.0D));
            step.setAlignment(Pos.CENTER);
            step.setStyle("-fx-background-color: Brown; -fx-text-fill: white;");
        }

        HBox Buttons = new HBox(200);
        Buttons.setAlignment(Pos.CENTER);
        Button ViewStats = new Button(Main.lang.Lang.ViewStats);
        EndTurn = new Button(Main.lang.Lang.EndTurn);
        ViewStats.setOnAction(e -> {
            for (Player player :
                    Players)
                player.viewStats();
        });
        EndTurn.setOnAction(e -> DiscardPhase());
        EndTurn.setDisable(true);
        Button[] BUTTONS = {ViewStats, EndTurn};
        for (Button button :
                BUTTONS) {
            button.setMaxSize(720, 150);
            button.setMinSize(720, 150);
            button.setFont(new Font("Times New Roman", 65.0D));
            button.setAlignment(Pos.CENTER);
        }
        Buttons.getChildren().addAll(ViewStats, EndTurn);

        CentralPane.add(step1, 0, 0);
        CentralPane.add(step2, 1, 0);
        CentralPane.add(step3, 2, 0);
        CentralPane.add(step4, 3, 0);
        CentralPane.add(step5, 4, 0);
        CentralPane.add(DeckView, 0, 1);
        CentralPane.add(UsedCardView, 1, 1);
        CentralPane.add(CollectedIncidentCardView, 2, 1);
        CentralPane.add(IncidentDeckView, 3, 1);
        CentralPane.add(usedIncidentView, 4, 1);
        CentralPane.add(Buttons, 0, 3);
        GridPane.setColumnSpan(Buttons, 5);
        GridPane.setRowSpan(DeckView, 2);
        GridPane.setRowSpan(UsedCardView, 2);
        GridPane.setRowSpan(CollectedIncidentCardView, 2);
        GridPane.setRowSpan(IncidentDeckView, 2);
        GridPane.setRowSpan(usedIncidentView, 2);
        DeckView.setAlignment(Pos.CENTER_RIGHT);
        UsedCardView.setAlignment(Pos.CENTER_LEFT);
        CollectedIncidentCardView.setAlignment(Pos.CENTER_RIGHT);
        IncidentDeckView.setAlignment(Pos.CENTER);
        usedIncidentView.setAlignment(Pos.CENTER_LEFT);
        UpdateUsedCardsView(UsedIncident, usedIncidentView, Pos.CENTER_LEFT);
        UpdateUsedCardsView(UsedCard, UsedCardView, Pos.CENTER_RIGHT);
        UpdateUsedCardsView(CollectedCard, CollectedIncidentCardView, Pos.CENTER_LEFT);
        return CentralPane;
    }

    private static StackPane getMenuStackPane() {
        StackPane BackgroundLayout = new StackPane();
        BackgroundLayout.setStyle("-fx-background-color: rgba(0,0,0,0.70)");
        BorderPane Layout1 = new BorderPane();
        VBox Layout2 = new VBox(15);
        HBox Layout3 = new HBox(50);
        HBox Layout2_1 = new HBox(80);

        BackgroundLayout.getChildren().add(Layout1);
        Layout1.setCenter(Layout2);
        Layout1.setBottom(Layout3);

        Slider slider1 = new Slider();
        Slider slider2 = new Slider();
        Button button1 = new Button(Main.lang.Lang.Exit);
        Button button2 = new Button(Main.lang.Lang.SandE);
        ComboBox<String> cb = new ComboBox<>();
        Layout2.getChildren().addAll(new Label("SFX Volume"), slider1, new Label(""), new Label("BGM Volume"), slider2, new Label(""), Layout2_1);
        Layout3.getChildren().addAll(button1, button2);
        Layout2_1.getChildren().addAll(new Label(Main.lang.Lang.language), cb);

        Layout2.setAlignment(Pos.CENTER);
        Layout3.setAlignment(Pos.CENTER);
        Layout2_1.setAlignment(Pos.CENTER);

        button1.setPrefHeight(30);
        button1.setPrefWidth(200);
        button2.setPrefHeight(30);
        button2.setPrefWidth(200);

        cb.getItems().addAll("Spanish", "English", "German", "Thai", "Chinese");
        cb.getSelectionModel().select(1);


        slider1.setMin(0);
        slider1.setMax(100);
        slider1.setValue(Main.audio.getSFXVol() * 100);
        slider1.setShowTickLabels(true);
        slider1.setShowTickMarks(true);
        slider1.setMajorTickUnit(5);
        slider1.setMinorTickCount(4);
        slider1.setBlockIncrement(1);
        slider1.setMinorTickCount(1);
        slider1.setMaxWidth(700);
        Tooltip tp = new Tooltip();
        tp.setWrapText(true);
        tp.setTextOverrun(OverrunStyle.ELLIPSIS);
        slider1.setTooltip(tp);
        slider1.setPrefHeight(80);
        slider1.setOnMouseClicked(e -> Main.audio.testSFXVol(slider1.getValue() / 100));
        slider1.setOnMousePressed(e -> Main.audio.testSFXVol(slider1.getValue() / 100));
        slider1.setOnMouseReleased(e -> Main.audio.testSFXVol(slider1.getValue() / 100));

        slider2.setMin(0);
        slider2.setMax(100);
        slider2.setValue(Main.audio.getBGMVol() * 100);
        slider2.setShowTickLabels(true);
        slider2.setShowTickMarks(true);
        slider2.setMajorTickUnit(50);
        slider2.setMinorTickCount(5);
        slider2.setBlockIncrement(1);
        slider2.setMaxWidth(700);
        slider2.setOnMouseClicked(e -> Main.audio.testBGMVol(slider2.getValue() / 100));
        slider2.setOnMousePressed(e -> Main.audio.testBGMVol(slider2.getValue() / 100));
        slider2.setOnMouseReleased(e -> Main.audio.testBGMVol(slider2.getValue() / 100));
        button1.setOnAction(event -> {
            Main.audio.setVolume();
            slider1.setValue(Main.audio.getSFXVol() * 100);
            slider2.setValue(Main.audio.getBGMVol() * 100);
            BackGroudPane.getChildren().remove(BackgroundLayout);
        });
        button2.setOnAction(event -> {
            try {
                BufferedReader FILE = new BufferedReader(new InputStreamReader(Scene_Setup.class.getResourceAsStream("/Controller/SETUP.dat")));
                String line1 = FILE.readLine();
                String line2 = FILE.readLine();
                FILE.close();
                String path = (new File("src/Controller/SETUP.dat")).getCanonicalPath();
                BufferedWriter FILE2 = new BufferedWriter(new FileWriter("src/Controller/SETUP.dat"));
                FILE2.write(line1 + "\n" + line2 + "\n" + (int) slider2.getValue() + "\n" + (int) slider1.getValue());
                FILE2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Main.audio.setVolume(slider2.getValue() / 100, slider1.getValue() / 100);
            BackGroudPane.getChildren().remove(BackgroundLayout);
        });
        return BackgroundLayout;
    }
}























