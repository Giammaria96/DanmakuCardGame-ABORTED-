package Views.Scenes;

import Controller.Main;
import Model.Card;
import Model.CharacterCard;
import Model.RoleCard;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Scene_SelectCharacter extends Scene {

    private CharacterCard card1, card2;
    private Card card3;
    private static StackPane root;
    private GridPane GridCard1,GridCard2,GridCard3;

    public Scene_SelectCharacter(CharacterCard card1, CharacterCard card2, RoleCard card3) {
        super(root());
        this.card1=card1;
        this.card2=card2;
        this.card3=card3;
        initComponent();
    }

    private void initComponent() {
        root.setAlignment(Pos.TOP_CENTER);
        double size = 1200D + 420D * 0.71186440678;
        double size_percentage = Main.W / size;
        root.setPrefSize(Main.W, Main.W);
        ColumnConstraints col1 = new ColumnConstraints(600 * size_percentage, 600 * size_percentage, 600 * size_percentage),
                col2 = new ColumnConstraints(600 * size_percentage, 600 * size_percentage, 600 * size_percentage),
                col3 = new ColumnConstraints(420 * 0.71186440678 * size_percentage, 420 * 0.71186440678 * size_percentage, 420 * 0.71186440678 * size_percentage);

        GridCard1 = card1.getView(size_percentage*100, true);
        GridCard2 = card2.getView(size_percentage*100, true);
        GridCard3 = card3.getView(size_percentage*100* 0.71186440678, true);

        GridPane CardDisplay = new GridPane();
        CardDisplay.setAlignment(Pos.BOTTOM_LEFT);
        CardDisplay.getColumnConstraints().addAll(col1, col2, col3);
        CardDisplay.add(GridCard1, 0, 0);
        CardDisplay.add(GridCard2, 1, 0);
        CardDisplay.add(GridCard3, 2, 0);
        boolean add = root.getChildren().add(CardDisplay);
        StackPane.setAlignment(CardDisplay, Pos.BOTTOM_LEFT);
    }

    private static Parent root(){
        root = new StackPane();
        return root;
    }


    public Pane getParent(){return root;}
    public GridPane getCard1() {
        return GridCard1;
    }
    public GridPane getCard2() {
        return GridCard2;
    }
    public GridPane getCard3() {
        return GridCard3;
    }
}
