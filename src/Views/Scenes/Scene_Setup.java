package Views.Scenes;

import Controller.Main;
import Language.Language;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Scene_Setup extends Scene {

    private Language text;
    private static StackPane root;
    private Button button1,button2;
    private Slider slider1,slider2;
    private ComboBox<String> cb;

    public Scene_Setup() {
        super(rootLayout());
        text= Main.lang.Lang;
        initComponent();
    }

    private void initComponent() {
        root.setStyle("-fx-background-image: url('/images/BG/Background2.png\');" +
                " -fx-background-position: center center;" +
                " -fx-background-repeat: stretch;" +
                " -fx-background-size: stretch;");
        BorderPane Layout1 = new BorderPane();
        VBox Layout2 = new VBox(15);
        HBox Layout3 = new HBox(50);
        HBox Layout2_1 = new HBox(80);

        root.getChildren().add(Layout1);
        Layout1.setCenter(Layout2);
        Layout1.setBottom(Layout3);

        slider1 = new Slider();
        slider2 = new Slider();
        button1 = new Button(text.Exit);
        button2 = new Button(text.SandE);

        cb = new ComboBox<>();
        Layout2.getChildren().addAll(new Label("SFX Volume"), slider1, new Label(""), new Label("BGM Volume"), slider2, new Label(""), Layout2_1);
        Layout3.getChildren().addAll(button1, button2);
        Layout2_1.getChildren().addAll(new Label(text.language), cb);

        Layout2.setAlignment(Pos.CENTER);
        Layout3.setAlignment(Pos.CENTER);
        Layout2_1.setAlignment(Pos.CENTER);

        button1.setPrefHeight(30);
        button1.setPrefWidth(200);
        button2.setPrefHeight(30);
        button2.setPrefWidth(200);

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
        slider1.setPrefHeight(80);

        slider2.setMin(0);
        slider2.setMax(100);
        slider2.setValue(Main.audio.getBGMVol() * 100);
        slider2.setShowTickLabels(true);
        slider2.setShowTickMarks(true);
        slider2.setMajorTickUnit(50);
        slider2.setMinorTickCount(5);
        slider2.setBlockIncrement(1);
        slider2.setMaxWidth(700);
    }

    private static StackPane rootLayout(){
        root= new StackPane();
        return root;
    }




    public Button getExitButton() {
        return button1;
    }
    public Button getSaveButton() {
        return button2;
    }
    public Slider getSFXSlider() {
        return slider1;
    }
    public Slider getBGMSlider() {
        return slider2;
    }
    public ComboBox<String> getLanguageComboBox() {
        return cb;
    }

}
