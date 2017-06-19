package Controller;

        import Model.*;
        import Views.PopUps.PopUp_CharacterConfirmBox;
        import Views.Scenes.Scene_SelectCharacter;
        import javafx.scene.layout.Pane;

public class Controller_SelectCharacter {

    private DeckCard[] Deck;
    private RoleCard[] RoleDeck;
    private CharacterCard[] CharacterDeck;
    private final Player NullPlayer = new Player(new CharacterCard(1), new RoleCard(1), new int[]{});
    private CharacterCard card1;

    public Controller_SelectCharacter(DeckCard[] Deck, RoleCard[] RoleDeck, CharacterCard[] CharacterDeck) {
        CharacterCard card2;
        card1 = CharacterDeck[CharacterDeck.length - 1];
        card2 = CharacterDeck[CharacterDeck.length - 2];

        Scene_SelectCharacter scene = new Scene_SelectCharacter(
                card1,
                card2,
                RoleDeck[RoleDeck.length - 1]
        );

        this.Deck = Deck;
        this.RoleDeck = RoleDeck;
        this.CharacterDeck = CharacterDeck;
        Pane root = scene.getParent();

        scene.getCard1().setOnMouseClicked(e -> buttonFunction(card1));
        scene.getCard2().setOnMouseClicked(e -> buttonFunction(card2));
        NullPlayer.SetOnMouse__ViewZoom(root, scene.getCard1(), card1, true, /*Main.H / 2 / 420 * 100*/100);
        NullPlayer.SetOnMouse__ViewZoom(root, scene.getCard2(), card2, true, /*Main.H / 2 / 420 * 100*/100);
        NullPlayer.SetOnMouse__ViewZoom(root, scene.getCard3(), new RoleCard(RoleDeck[RoleDeck.length - 1].getID()), true, Main.H / 2 / 590 * 100);

        Main.setNewScene(scene);
    }



    private void buttonFunction(CharacterCard Card) {
        Boolean bln = PopUp_CharacterConfirmBox.display(Card);
        if (bln) {
            Battle.start(Deck, RoleDeck, CharacterDeck, Card == card1 ? 0 : 1);
        }
    }
}
