package Views;


import Controller.Main;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.*;
import javafx.scene.*;

public class PopUp_ConfirmBox {

    private static Boolean answer=false;

    public static boolean display(String Message) {
        answer=false;

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.setWidth(400);
        window.setHeight(150);
        Label label = new Label(Message+"\n ");
        label.setFont(new Font("Arial", 16));


        Button Byes = new Button(Main.lang.Lang.Yes);
        Button Bno = new Button(Main.lang.Lang.No);
        Byes.setPrefWidth(75);
        Bno.setPrefWidth(75);
        Byes.setOnAction(e -> {answer=true;window.close();});
        Bno.setOnAction(e -> {answer=false;window.close();});

        VBox MainLayout = new VBox(10);
        HBox SecondaryLayout = new HBox(15);

        SecondaryLayout.getChildren().addAll(Byes, Bno);
        MainLayout.getChildren().addAll(label, SecondaryLayout);

        MainLayout.setAlignment(Pos.CENTER);
        SecondaryLayout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(MainLayout);
        window.setScene(scene);
        window.showAndWait();
        return answer;
    }
}
