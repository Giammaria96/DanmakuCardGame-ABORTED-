package Views;

import Controller.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Scene_Language {
    private static Image ArabicImg = new Image("/images/Languages/Arabic.png");
    private static Image ChineseImg = new Image("/images/Languages/Chinese.png");
    private static Image EnglishImg = new Image("/images/Languages/English.png");
    private static Image FrenchImg = new Image("/images/Languages/French.png");
    private static Image GermanImg = new Image("/images/Languages/German.png");
    private static Image ItalianImg = new Image("/images/Languages/Italian.png");
    private static Image JapaneseImg = new Image("/images/Languages/Japanese.png");
    private static Image PortugueseImg = new Image("/images/Languages/Portuguese.png");
    private static Image RussianImg = new Image("/images/Languages/Russian.png");
    private static Image SpanishImg = new Image("/images/Languages/Spanish.png");
    private static Image TaiwaneseImg = new Image("/images/Languages/Taiwanese.png");
    private static Image ThaiImg = new Image("/images/Languages/Thai.png");
    private static Image VietnameseImg = new Image("/images/Languages/Vietnamese.png");

    public static Scene Scene() {
        ComboBox<String> list = new ComboBox<>();
        list.setItems(getList());
        list.getSelectionModel().select(1);
        list.setPrefWidth(140);
        list.setPrefHeight(20);


        StackPane BackgroundLayout = new StackPane();
        BackgroundLayout.setStyle("-fx-background-image: url('/images/BG/Background.png\');" +
                " -fx-background-position: center center;" +
                " -fx-background-repeat: stretch;" +
                " -fx-background-size: stretch;");

        HBox Layout = new HBox(15);
        Layout.setAlignment(Pos.CENTER);

        BackgroundLayout.getChildren().add(Layout);

        Button button = new Button(Main.lang.Lang.Confirm);

        button.setOnAction(e -> {
            Boolean bln = PopUp_ConfirmBox.display(Main.lang.Lang.conlang + list.getSelectionModel().getSelectedItem());
            if (bln) {
                Main.setNewScene(Scene_Title.Scene());
            }
        });
        Label label = new Label(Main.lang.Lang.chslang + " : ");
        label.setFont(new Font("Arial", 16));
        label.setTextFill(Color.web("#F0AA10"));

        Scene scene = new Scene(BackgroundLayout);
        Layout.getChildren().addAll(label, list, button);

        return scene;
    }

    private static ObservableList<String> getList() {
        /*Label Arabic = new Label("العربية", new ImageView(ArabicImg));
        Label Chinese = new Label("中文", new ImageView(ChineseImg));
        Label English = new Label("English", new ImageView(EnglishImg));
        Label French = new Label("français", new ImageView(FrenchImg));
        Label German = new Label("Deutsch", new ImageView(GermanImg));
        Label Italian = new Label("italiano", new ImageView(ItalianImg));
        Label Japanese = new Label("日本語", new ImageView(JapaneseImg));
        Label Portuguese = new Label("português", new ImageView(PortugueseImg));
        Label Russian = new Label("русский", new ImageView(RussianImg));
        Label Spanish = new Label("Español", new ImageView(SpanishImg));
        Label Taiwanese = new Label("漢語", new ImageView(TaiwaneseImg));
        Label Vietnamese = new Label("Việt", new ImageView(VietnameseImg));*/
        ObservableList<String> data = FXCollections.observableArrayList();

        data.addAll("Deutsch");
        data.addAll("English");
        data.addAll("Español");
        data.addAll("العربية");
        data.addAll("中文");
        data.addAll("français");
        data.addAll("italiano");
        data.addAll("日本語");
        data.addAll("ภาษาไทย");
        data.addAll("Việt");

        return data;
    }
}
