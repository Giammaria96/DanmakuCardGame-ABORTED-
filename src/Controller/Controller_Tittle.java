package Controller;

import Views.Scenes.Scene_Title;
import Views.Scenes.Scene_PlaySetup;
public class Controller_Tittle {

    public Controller_Tittle() {
        Scene_Title Scene = new Scene_Title();

        Scene.getNewGameButton().setOnAction(e-> NewGame());
        Scene.getMultiPlayerButton().setOnAction(e-> MultiPlayer());
        Scene.getHowToPlayButton().setOnAction(e-> howToPlay());
        Scene.getCardDatabaseButton().setOnAction(e-> CardDatabase());
        Scene.getSetupButton().setOnAction(e-> Setup());



        Main.setNewScene(Scene);
    }

    private void NewGame() {
        //TODO improve
        Main.setNewScene(Scene_PlaySetup.scene());
    }

    private void MultiPlayer() {
        // TODO all code here
    }

    private void howToPlay() {
        // TODO all code here
    }

    private void CardDatabase() {
        //TODO improve
        new Controller_CardDatabase();
    }

    private void Setup() {
        new Controller_Setup();
    }

}
