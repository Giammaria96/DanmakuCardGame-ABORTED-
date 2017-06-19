package Controller;

import Language.Language;
import Views.Scenes.Scene_Setup;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import org.jetbrains.annotations.Contract;

import java.io.*;

public class Controller_Setup {
    private final Slider slider1, slider2;
    private final ComboBox<String> cb;

    public Controller_Setup() {
        Scene_Setup scene = new Scene_Setup();

        slider1 = scene.getSFXSlider();
        slider2 = scene.getBGMSlider();
        cb = scene.getLanguageComboBox();
        slider1.setOnMouseClicked(e -> Main.audio.testSFXVol(slider1.getValue() / 100));
        slider1.setOnMousePressed(e -> Main.audio.testSFXVol(slider1.getValue() / 100));
        slider1.setOnMouseReleased(e -> Main.audio.testSFXVol(slider1.getValue() / 100));
        slider2.setOnMouseClicked(e -> Main.audio.testBGMVol(slider2.getValue() / 100));
        slider2.setOnMousePressed(e -> Main.audio.testBGMVol(slider2.getValue() / 100));
        slider2.setOnMouseReleased(e -> Main.audio.testBGMVol(slider2.getValue() / 100));
        cb.getItems().addAll(createList());
        cb.getSelectionModel().select(Language.SelectedLanguage);

        scene.getExitButton().setOnAction(e->exit());
        scene.getSaveButton().setOnAction(e->saveExit());

        Main.setNewScene(scene);
    }


    @Contract(pure = true)
    private String[] createList() {
        return Language.availableLanguages;
    }

    private void saveExit() {
        try {
            BufferedReader FILE = new BufferedReader(new InputStreamReader(Scene_Setup.class.getResourceAsStream("/Controller/SETUP.dat")));
            String line1 = cb.getSelectionModel().getSelectedItem();
            FILE.readLine();
            String line2 = FILE.readLine();
            String line3 = (int) slider2.getValue()+"";
            String line4 = (int) slider1.getValue()+"";
            FILE.close();
            BufferedWriter FILE2 = new BufferedWriter(new FileWriter("src/Controller/SETUP.dat"));
            FILE2.write(line1 + "\n" + line2 + "\n" + line3 + "\n" + line4);
            FILE2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.setNewLanguage(cb.getSelectionModel().getSelectedItem());
        Main.audio.setVolume(slider2.getValue() / 100, slider1.getValue() / 100);
        new Controller_Tittle();
    }

    private void exit() {
        Main.audio.setVolume();
        new Controller_Tittle();
    }
}
