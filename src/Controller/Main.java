package Controller;

import Language.Language;
import Views.Scene_Language;
import Views.Scene_Title;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main extends Application {

    public static Language lang = new Language();
    public static Double W;
    public static Double H;
    public static final Audio audio = new Audio();
    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    public static void setNewScene(Scene scene) {
        primaryStage.setScene(scene);
    }

    public static Task<Void> sleeper(int millis) {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep(millis);
                return null;
            }
        };
    }

    @Override
    public void start(Stage stg) throws Exception {
        primaryStage = new Stage();
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Danmaku!!");
        firstTime();
        primaryStage.show();
        H = primaryStage.getScene().getHeight();
        W = primaryStage.getScene().getWidth();
        primaryStage.setMinHeight(H + 38);
        primaryStage.setMaxHeight(H + 38);
        primaryStage.setMinWidth(W + 15);
        primaryStage.setMaxWidth(W + 15);
        audio.playBGM();
    }

    /**
     * Ask the user for choose a Language if it's the
     * first time using the app.
     *
     * @throws IOException This error may only happens if user modifies program files.
     */
    private void firstTime() throws IOException {
        BufferedReader FILE = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/Controller/SETUP.dat")));
        FILE.readLine();
        String Text = FILE.readLine();
        if ("0".equals(Text)) {
            setNewScene(Scene_Language.Scene());
        } else {
            setNewScene(Scene_Title.Scene());
        }
    }
}