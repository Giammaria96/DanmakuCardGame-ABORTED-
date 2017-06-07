package Views;

import Controller.Battle;
import Controller.Main;
import Model.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Scene_SelectCharacter {

    public static Scene scene(DeckCard[] Deck, RoleCard[] RoleDeck, CharacterCard[] CharacterDeck, IncidentCard[] IncidentDeck) {
        StackPane MainPane = new StackPane();
        MainPane.setAlignment(Pos.TOP_CENTER);
        double size = 1200 + 420 * 0.71186440678;
        double size_percentage = Main.W / size;
        Player Null = new Player(new CharacterCard(1), new RoleCard(1), new int[]{});
        MainPane.setPrefSize(Main.W, Main.W);
        ColumnConstraints col1 = new ColumnConstraints(600 * size_percentage, 600 * size_percentage, 600 * size_percentage),
                col2 = new ColumnConstraints(600 * size_percentage, 600 * size_percentage, 600 * size_percentage),
                col3 = new ColumnConstraints(420 * 0.71186440678 * size_percentage, 420 * 0.71186440678 * size_percentage, 420 * 0.71186440678 * size_percentage);
        GridPane CardDisplay = new GridPane();
        CardDisplay.setAlignment(Pos.BOTTOM_LEFT);
        size_percentage *= 100;
        GridPane card1 = CharacterDeck[CharacterDeck.length - 1].getView(size_percentage, true);
        GridPane card2 = CharacterDeck[CharacterDeck.length - 2].getView(size_percentage, true);
        GridPane card3 = RoleDeck[RoleDeck.length - 1].getView(size_percentage * 0.71186440678, true);
        Null.SetOnMouse__ViewZoom(MainPane, card1, new CharacterCard(CharacterDeck[CharacterDeck.length - 1].getID()), true, Main.H / 2 / 420 * 100);
        Null.SetOnMouse__ViewZoom(MainPane, card2, new CharacterCard(CharacterDeck[CharacterDeck.length - 2].getID()), true, Main.H / 2 / 420 * 100);
        Null.SetOnMouse__ViewZoom(MainPane, card3, new RoleCard(RoleDeck[RoleDeck.length - 1].getID()), true, Main.H / 2 / 590 * 100);
        CardDisplay.getColumnConstraints().addAll(col1, col2, col3);
        CardDisplay.add(card1, 0, 0);
        CardDisplay.add(card2, 1, 0);
        CardDisplay.add(card3, 2, 0);

        card1.setOnMouseClicked(e -> {
            Boolean bln = PopUp_CharacterConfirmBox.display(new CharacterCard(CharacterDeck[CharacterDeck.length - 1].getID()));
            if (bln) {
                Battle.start(Deck, IncidentDeck, RoleDeck, CharacterDeck, 0);
            }
        });
        card2.setOnMouseClicked(e -> {
            Boolean bln = PopUp_CharacterConfirmBox.display(new CharacterCard(CharacterDeck[CharacterDeck.length - 2].getID()));
            if (bln) {
                Battle.start(Deck, IncidentDeck, RoleDeck, CharacterDeck, 1);
            }
        });
        MainPane.getChildren().add(CardDisplay);
        StackPane.setAlignment(CardDisplay, Pos.BOTTOM_LEFT);
        return new Scene(MainPane);
    }
}
