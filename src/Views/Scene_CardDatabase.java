package Views;

import Controller.Main;
import Model.CharacterCard;
import Model.DeckCard;
import Model.IncidentCard;
import Model.RoleCard;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Scene_CardDatabase {
    private static Button back;
    private static StackPane MainPane;

    public static Scene scene() {
        MainPane = new StackPane();
        MainPane.setAlignment(Pos.CENTER);
        Double sizeW = Main.W * 0.85 * 100 / 1100;
        Double sizeH = Main.H * 0.85 * 100 / 620;

        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        Double size_percentage = sizeW > sizeH ? sizeH / 100 : sizeW / 100;
        pane.setPrefSize(1100 * size_percentage, 620 * size_percentage);
        pane.setMinSize(1100 * size_percentage, 620 * size_percentage);
        pane.setMaxSize(1100 * size_percentage, 620 * size_percentage);

        pane.setStyle("-fx-background-image: url('/images/BG/Tile.png'); -fx-background-repeat: stretch; -fx-background-size: cover; -fx-background-color: transparent");
        MainPane.getChildren().add(pane);
        MainPane.setStyle("-fx-background-image: url('/images/BG/Background2.png\');" +
                " -fx-background-position: center center;" +
                " -fx-background-repeat: stretch; -fx-background-size: stretch");

        Scene scene = new Scene(MainPane);

        GridPane ButtonsPane = new GridPane();
        ButtonsPane.setStyle("-fx-cell-size: inherit");
        ButtonsPane.setAlignment(Pos.CENTER);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHalignment(HPos.CENTER);
        col1.setPrefWidth(pane.getPrefWidth() / 2 - 10);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHalignment(HPos.CENTER);
        col2.setPrefWidth(pane.getPrefWidth() / 2 - 10);
        RowConstraints row1 = new RowConstraints();
        row1.setValignment(VPos.CENTER);
        row1.setPrefHeight(pane.getPrefHeight() / 2);
        RowConstraints row2 = new RowConstraints();
        row2.setValignment(VPos.CENTER);
        row2.setPrefHeight(pane.getPrefHeight() / 2);
        ButtonsPane.getRowConstraints().addAll(row1, row2);
        ButtonsPane.getColumnConstraints().addAll(col1, col2);

        Button[] buttons = new Button[4];

        for (int i = 0; i < 4; i++) {
            buttons[i] = new Button();
            buttons[i].setStyle(" -fx-background-color: transparent;" +
                    " -fx-background-image: url('/images/Buttons/CDBB.png\');" +
                    " -fx-background-position: center center;" +
                    " -fx-background-repeat: stretch;" +
                    "-fx-background-size: stretch;");
            buttons[i].setMaxSize(400, 100);
            buttons[i].setMinSize(150, 100);
            buttons[i].setPrefSize(320, 100);
            buttons[i].setFont(new Font("Times New Roman", 30));
            buttons[i].setText(Main.lang.Lang.getCDBBText()[i]);
        }
        ButtonsPane.add(buttons[0], 0, 0);
        ButtonsPane.add(buttons[1], 1, 0);
        ButtonsPane.add(buttons[2], 0, 1);
        ButtonsPane.add(buttons[3], 1, 1);

        pane.getChildren().add(ButtonsPane);
        back = new Button("Back");
        back.setOnAction(e -> Main.setNewScene(Scene_Title.Scene()));
        MainPane.getChildren().add(back);
        StackPane.setAlignment(back, Pos.BOTTOM_LEFT);


        buttons[0].setOnAction(event -> MainPane.getChildren().add(Buttonf(pane.getPrefWidth(), pane.getPrefHeight(), "Role", 0)));
        buttons[1].setOnAction(event -> MainPane.getChildren().add(Buttonf(pane.getPrefWidth(), pane.getPrefHeight(), "Deck", 1)));
        buttons[2].setOnAction(event -> MainPane.getChildren().add(Buttonf(pane.getPrefWidth(), pane.getPrefHeight(), "Incident", 2)));
        buttons[3].setOnAction(event -> MainPane.getChildren().add(Buttonf(pane.getPrefWidth(), pane.getPrefHeight(), "Character", 3)));
        return scene;
    }

    private static GridPane Buttonf(double W, double H, String type, int b) {
        back.setOnAction(e -> {
            MainPane.getChildren().remove(2);
            back.setOnAction(f -> Main.setNewScene(Scene_Title.Scene()));
        });
        GridPane box = new GridPane();
        ColumnConstraints col = new ColumnConstraints();
        col.setHalignment(HPos.RIGHT);
        col.setPrefWidth(W / 2 - 14);
        ColumnConstraints co2 = new ColumnConstraints();
        co2.setHalignment(HPos.CENTER);
        co2.setPrefWidth(W / 2 - 14);
        box.getColumnConstraints().addAll(col, co2);
        box.setPrefSize(W, H);
        box.setMinSize(W, H);
        box.setMaxSize(W, H);
        box.setAlignment(Pos.CENTER);
        double sizeW;
        double sizeH;
        double size_percentage;
        ImageView img = new ImageView();
        if (b == 3) {
            sizeW = (W / 2 - 25) * 100 / 600;
            sizeH = (H - 25) * 100 / 420;
            size_percentage = sizeW > sizeH ? sizeH : sizeW;
            img.setFitHeight(420 * size_percentage / 100);
        } else {
            sizeW = (W / 2 - 40) * 100 / 420;
            sizeH = (H - 40) * 100 / 590;
            size_percentage = sizeW > sizeH ? sizeH : sizeW;
            img.setFitWidth(420 * size_percentage / 100);
        }
        box.setStyle("-fx-background-image: url('/images/BG/CDB.png'); -fx-background-repeat: stretch; -fx-background-size: cover; -fx-background-color: transparent");
        StackPane CardDeploy = new StackPane();

        CardDeploy.setAlignment(Pos.CENTER);


        GridPane imgp = new GridPane();
        imgp.add(img, 0, 0);
        img.setImage(new Image("Images/" + type + "/0.png"));
        img.setPreserveRatio(true);
        imgp.setRotationAxis(Rotate.Y_AXIS);
        CardDeploy.getChildren().add(img);
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        Hyperlink[] links = new Hyperlink[80];
        ListView<Hyperlink> list = new ListView<>();
        ObservableList<Hyperlink> items = FXCollections.observableArrayList();
        switch (b) {
            case 0:
                for (int i = 0; i < 16; i++) {
                    links[i] = new Hyperlink();
                    links[i].setText(Main.lang.Lang.getRoleText(i + 1)[1]);
                    links[i].setFont(new Font("Times New Roman", 25));
                    links[i].setPrefWidth(W / 2 - 50);
                    RoleCard c = new RoleCard(i + 1);
                    links[i].setOnAction(e -> ChangeCard(CardDeploy.getChildren().get(0), c.getView(size_percentage, true), CardDeploy));
                    if (i != 0)
                        if (Main.lang.Lang.getRoleText(i)[1] == c.getName()) {
                            continue;
                        }
                    items.add(links[i]);
                }
                break;
            case 2:
                for (int i = 0; i < 16; i++) {
                    links[i] = new Hyperlink();
                    links[i].setText(Main.lang.Lang.getIncidentText(i + 1)[0]);
                    links[i].setFont(new Font("Times New Roman", 25));
                    links[i].setPrefWidth(W / 2 - 50);
                    IncidentCard c = new IncidentCard(i + 1);
                    links[i].setOnAction(e -> ChangeCard(CardDeploy.getChildren().get(0), c.getView(size_percentage, true), CardDeploy));
                    items.add(links[i]);
                }
                break;
            case 1:
                for (int i = 0; i < 80; i++) {
                    links[i] = new Hyperlink();
                    links[i].setText(Main.lang.Lang.getDeckText(i + 1)[0]);
                    links[i].setFont(new Font("Times New Roman", 25));
                    links[i].setPrefWidth(W / 2 - 50);
                    DeckCard c = new DeckCard(i + 1);
                    links[i].setOnAction(e -> ChangeCard(CardDeploy.getChildren().get(0), c.getView(size_percentage, true), CardDeploy));
                    if (i != 0)
                        if (Main.lang.Lang.getDeckText(i)[0] == c.getName()) {
                            continue;
                        }
                    items.add(links[i]);
                }
                break;
            default:
                for (int i = 0; i < 24; i++) {
                    links[i] = new Hyperlink();
                    links[i].setText(Main.lang.Lang.getCharacterText(i + 1)[1]);
                    links[i].setFont(new Font("Times New Roman", 25));
                    links[i].setPrefWidth(W / 2 - 50);
                    CharacterCard c = new CharacterCard(i + 1);
                    links[i].setOnAction(e -> ChangeCard(CardDeploy.getChildren().get(0), c.getView(size_percentage, true), CardDeploy));
                    items.add(links[i]);
                }
        }
        list.setItems(items);
        list.setPrefSize(W / 2 - 20, H - 24);
        list.setMaxSize(W / 2 - 20, H - 24);
        list.setMinSize(W / 2 - 20, H - 24);
        list.getStylesheets().add("Views/list.CSS");
        box.add(CardDeploy, 0, 0);
        box.add(list, 1, 0);
        return box;
    }

    private static void ChangeCard(Node OriginalCard, GridPane NewCard, StackPane CardDeployer) {
        MainPane.getChildren().add(new Pane());
        OriginalCard.setRotationAxis(Rotate.Y_AXIS);
        KeyValue k0 = new KeyValue(OriginalCard.rotateProperty(), 0);
        KeyValue k1 = new KeyValue(OriginalCard.rotateProperty(), 90);
        NewCard.setRotationAxis(Rotate.Y_AXIS);
        NewCard.setRotate(-90);
        KeyValue k3 = new KeyValue(NewCard.rotateProperty(), -90);
        KeyValue k4 = new KeyValue(NewCard.rotateProperty(), 0);
        Timeline tl = new Timeline();
        KeyFrame keyFrame1 = new KeyFrame(Duration.ZERO, k0);
        KeyFrame keyFrame2 = new KeyFrame(new Duration(1000), k1, k3);
        KeyFrame keyFrame3 = new KeyFrame(new Duration(2000), k4);
        tl.getKeyFrames().addAll(keyFrame1, keyFrame2, keyFrame3);
        CardDeployer.getChildren().add(NewCard);
        tl.setOnFinished(event -> {
            try {
                MainPane.getChildren().remove(3);
                CardDeployer.getChildren().remove(0, 2);
                CardDeployer.getChildren().add(NewCard);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        });
        tl.play();
    }
}

