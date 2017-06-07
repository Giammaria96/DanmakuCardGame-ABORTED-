package Views;

import Model.Card;
import Model.DeckCard;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Point3D;
import javafx.scene.PointLight;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class StackPane_Shuffling {
    private Timeline tl;
    private StackPane pane = new StackPane(), pane2 = new StackPane();
    private KeyValue[] PosKeys, RotKeys;
    private KeyFrame[] frames;

    public StackPane_Shuffling(Card[] deck){

        pane.setStyle("-fx-background-color: transparent;");
        pane.getChildren().add(pane2);

        pane2.setStyle("-fx-background-color: rgba(0,0,0,0.33);");
        pane2.setRotationAxis(new Point3D(1,0.01,0.1));
        pane2.setRotate(70);
        pane2.setMaxSize(700,600);

        PosKeys = new KeyValue[deck.length];
        RotKeys = new KeyValue[deck.length];
        frames = new KeyFrame[deck.length];

        for (int i=0; i<deck.length;i++)
        {
            Card Card = deck[i];
            GridPane CardView = Card.getView(70,false);
            pane2.getChildren().add(CardView);
            CardView.setRotationAxis(new Point3D(0.0,i%2==0?0.02:-0.02,1));
            CardView.setRotate(90);
            CardView.setTranslateX(i%2==0||i==0?250:-250);
            CardView.setTranslateZ(i*6);
            CardView.setEffect(new DropShadow());
            PosKeys[i] = new KeyValue(CardView.translateXProperty(),0);
            RotKeys[i] = new KeyValue(CardView.rotationAxisProperty(), Rotate.Z_AXIS);
            frames[i] = new KeyFrame(Duration.millis(1360/deck.length*(i+1)),PosKeys[i],RotKeys[i]);
        }

        tl = new Timeline(frames);
    }

    public Timeline getTimeline() {
        return tl;
    }

    public StackPane getPane() {
        return pane;
    }
}
