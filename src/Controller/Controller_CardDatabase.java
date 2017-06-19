package Controller;

import Model.CharacterCard;
import Model.DeckCard;
import Model.IncidentCard;
import Model.RoleCard;
import Views.Scenes.Scene_CardDatabase;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.Objects;

public class Controller_CardDatabase {
    private Scene_CardDatabase scene;

    public Controller_CardDatabase(){
        scene = new Scene_CardDatabase();

        scene.getBackButton().setOnAction(e->backButton(false));
        scene.getRoleButton().setOnAction(e->roleButton());
        scene.getDeckButton().setOnAction(e->deckButton());
        scene.getIncidentButton().setOnAction(e->incidentButton());
        scene.getCharacterButton().setOnAction(e->characterButton());

        Main.setNewScene(scene);
    }

    private void backButton(boolean subView){
        if (subView)
            scene.getBackButton().setOnAction(e -> {
                scene.getRootPane().getChildren().remove(2);
                backButton(false);
            });
        else
            scene.getBackButton().setOnAction(e -> new Controller_Tittle());
    }
    private void roleButton() {
        ObservableList<Hyperlink> items = FXCollections.observableArrayList();
        backButton(true);
        Hyperlink[] links = new Hyperlink[80];
        scene.generateCardDeployer("Role");
        for (int i = 0; i < 16; i++) {
            links[i] = new Hyperlink();
            links[i].setText(Main.lang.Lang.getRoleText(i + 1)[1]);
            links[i].setFont(new Font("Times New Roman", 25));
            RoleCard c = new RoleCard(i + 1);
            links[i].setOnAction(e -> ChangeCard(
                    scene.getImageGridPane().getChildren().get(0),
                    c.getView(scene.getSizePercentage(), true),
                    scene.getImageGridPane()));
            if (i != 0)
                if (Objects.equals(Main.lang.Lang.getRoleText(i)[1], c.getName())) {
                    continue;
                }
            items.add(links[i]);
        }
        scene.setCardList(items);
    }
    private void deckButton() {
        ObservableList<Hyperlink> items = FXCollections.observableArrayList();
        backButton(true);
        Hyperlink[] links = new Hyperlink[80];
        scene.generateCardDeployer("Deck");
        for (int i = 0; i < 80; i++) {
            links[i] = new Hyperlink();
            links[i].setText(Main.lang.Lang.getDeckText(i + 1)[0]);
            links[i].setFont(new Font("Times New Roman", 25));
            DeckCard c = new DeckCard(i + 1);
            links[i].setOnAction(e -> ChangeCard(
                    scene.getImageGridPane().getChildren().get(0),
                    c.getView(scene.getSizePercentage(), true),
                    scene.getImageGridPane()));
            if (i != 0)
                if (Objects.equals(Main.lang.Lang.getDeckText(i)[0], c.getName())) {
                    continue;
                }
            items.add(links[i]);
        }
        scene.setCardList(items);
    }
    private void incidentButton() {
        ObservableList<Hyperlink> items = FXCollections.observableArrayList();
        backButton(true);
        Hyperlink[] links = new Hyperlink[80];
        scene.generateCardDeployer("Incident");
        for (int i = 0; i < 16; i++) {
            links[i] = new Hyperlink();
            links[i].setText(Main.lang.Lang.getIncidentText(i + 1)[0]);
            links[i].setFont(new Font("Times New Roman", 25));
            IncidentCard c = new IncidentCard(i + 1);
            links[i].setOnAction(e -> ChangeCard(
                    scene.getImageGridPane().getChildren().get(0),
                    c.getView(scene.getSizePercentage(), true),
                    scene.getImageGridPane()));
            items.add(links[i]);
        }
        scene.setCardList(items);
    }
    private void characterButton() {
        ObservableList<Hyperlink> items = FXCollections.observableArrayList();
        backButton(true);
        Hyperlink[] links = new Hyperlink[80];
        scene.generateCardDeployer("Character");
        for (int i = 0; i < 24; i++) {
            links[i] = new Hyperlink();
            links[i].setText(Main.lang.Lang.getCharacterText(i + 1)[1]);
            links[i].setFont(new Font("Times New Roman", 25));
            CharacterCard c = new CharacterCard(i + 1);
            links[i].setOnAction(e -> ChangeCard(
                    scene.getImageGridPane().getChildren().get(0),
                    c.getView(scene.getSizePercentage(), true),
                    scene.getImageGridPane()));
            items.add(links[i]);
        }
        scene.setCardList(items);
    }

    private void ChangeCard(Node OriginalCard, GridPane NewCard, StackPane CardDeployer) {
        scene.getRootPane().getChildren().add(new Pane());
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
                scene.getRootPane().getChildren().remove(3);
                CardDeployer.getChildren().remove(0, 2);
                CardDeployer.getChildren().add(NewCard);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        });
        tl.play();
    }
}
