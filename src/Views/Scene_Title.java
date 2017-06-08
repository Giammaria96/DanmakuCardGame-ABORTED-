package Views;

import Controller.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import static java.awt.Font.BOLD;

public class Scene_Title {

    public static Scene Scene() {

        StackPane BackgroundLayout = new StackPane();
        BackgroundLayout.setStyle("-fx-background-image: url('/images/BG/Background2.png\');" +
                " -fx-background-position: center center;" +
                " -fx-background-repeat: stretch; -fx-background-size: stretch");

        VBox Layout_Column = new VBox(35);
        Layout_Column.setAlignment(Pos.CENTER);
        BackgroundLayout.getChildren().addAll(Layout_Column);

        HBox LB1 = new HBox(20);
        HBox LB2 = new HBox(20);
        HBox LB3 = new HBox(20);
        HBox LB4 = new HBox(20);
        HBox LB5 = new HBox(20);
        LB1.setAlignment(Pos.CENTER);
        LB2.setAlignment(Pos.CENTER);
        LB3.setAlignment(Pos.CENTER);
        LB4.setAlignment(Pos.CENTER);
        LB5.setAlignment(Pos.CENTER);
        Layout_Column.getChildren().addAll(new Label(), LB1, LB2, LB3, LB4, LB5);


        Button BNew_Game = new Button("New Game");
        Button BMP = new Button("NetPlay");
        BMP.setDisable(true);
        Button BHowTo = new Button("How to play");
        Button CDB = new Button("Card Database");
        Button BSetup = new Button("Configuration");

        BNew_Game.setPrefWidth(250);
        BMP.setPrefWidth(250);
        BHowTo.setPrefWidth(250);
        CDB.setPrefWidth(250);
        BSetup.setPrefWidth(250);
        BNew_Game.setPrefHeight(40);
        BMP.setPrefHeight(40);
        BHowTo.setPrefHeight(40);
        CDB.setPrefHeight(40);
        BSetup.setPrefHeight(40);
        BNew_Game.setFont(new Font("Comic Sans MS", BOLD));
        BMP.setFont(new Font("Comic Sans MS", BOLD));
        BHowTo.setFont(new Font("Comic Sans MS", BOLD));
        CDB.setFont(new Font("Comic Sans MS", BOLD));
        BSetup.setFont(new Font("Comic Sans MS", BOLD));
        BNew_Game.setStyle("-fx-text-fill: blueviolet; -fx-font-size: 30; -fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; -fx-background-image: url('/images/Buttons/MMB.png')");
        BMP.setStyle("-fx-text-fill: blueviolet; -fx-font-size: 30; -fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; -fx-background-image: url('/images/Buttons/MMB.png')");
        BHowTo.setStyle("-fx-text-fill: blueviolet; -fx-font-size: 30; -fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; -fx-background-image: url('/images/Buttons/MMB.png')");
        CDB.setStyle("-fx-text-fill: blueviolet; -fx-font-size: 30; -fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; -fx-background-image: url('/images/Buttons/MMB.png')");
        BSetup.setStyle("-fx-text-fill: blueviolet; -fx-font-size: 30; -fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; -fx-background-image: url('/images/Buttons/MMB.png\')");
        BNew_Game.setOnAction(e -> Main.setNewScene(Scene_PlaySetup.scene()));
        CDB.setOnAction(e -> Main.setNewScene(Scene_CardDatabase.scene()));
        BSetup.setOnAction(e -> Main.setNewScene(Scene_Setup.scene()));


        LB1.getChildren().addAll(BNew_Game, new Label("  "));
        LB2.getChildren().addAll(new Label("  "), BMP);
        LB3.getChildren().addAll(BHowTo, new Label("  "));
        LB4.getChildren().addAll(new Label("  "), CDB);
        LB5.getChildren().addAll(BSetup, new Label("  "));

        return new Scene(BackgroundLayout);
    }
}
