package Views.PopUps;

import Controller.Main;
import Language.Language;
import Model.CharacterCard;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUp_CharacterConfirmBox {
    private static boolean answer = false;

    public static boolean display(CharacterCard card) {
        Stage PopUp = new Stage();
        PopUp.initModality(Modality.APPLICATION_MODAL);
        Language lang = Main.lang.Lang;

        VBox MainPane = new VBox(30);
        MainPane.setAlignment(Pos.CENTER);
        MainPane.setStyle("-fx-background-color: black");
        MainPane.setMinWidth(700);
        MainPane.setMinHeight(700);
        HBox ButtonBox = new HBox(60);
        ButtonBox.setAlignment(Pos.CENTER);

        Label label = new Label(lang.CharacterChoice);
        label.setFont(new Font("Times New Roman", 20));
        label.setStyle("-fx-text-fill: white");
        Button Byes = new Button(lang.Yes),
                Bno = new Button(lang.No);
        Byes.setPrefWidth(60);
        Bno.setPrefWidth(60);
        ButtonBox.getChildren().addAll(Byes, Bno);

        GridPane CardView = card.getView(100, true);
        CardView.setAlignment(Pos.CENTER);

        MainPane.getChildren().addAll(label, CardView, ButtonBox);
        Byes.setOnAction(e -> {
            answer = true;
            PopUp.close();
        });
        Bno.setOnAction(e -> {
            answer = false;
            PopUp.close();
        });
        PopUp.setScene(new Scene(MainPane));
        PopUp.showAndWait();
        return answer;
    }
}
