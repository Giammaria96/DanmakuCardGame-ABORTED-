package Views;

import Controller.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.*;


public class Scene_Setup {

    public static Scene scene() {
        StackPane BackgroundLayout = new StackPane();
        BackgroundLayout.setStyle("-fx-background-image: url('/images/BG/Background2.png\');" +
                " -fx-background-position: center center;" +
                " -fx-background-repeat: stretch;" +
                " -fx-background-size: stretch;");
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
            Main.setNewScene(Scene_Title.Scene());
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
            Main.setNewScene(Scene_Title.Scene());
            Main.audio.setVolume(slider2.getValue() / 100, slider1.getValue() / 100);
        });
        return new Scene(BackgroundLayout);
    }
}
