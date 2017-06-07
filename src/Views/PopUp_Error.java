package Views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUp_Error {

    public static void display(String Message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.setWidth(400);
        window.setHeight(150);
        Label label = new Label(Message+"\n ");
        label.setFont(new Font("Arial", 16));


        Button Bok = new Button("Ok");
        Bok.setPrefWidth(75);
        Bok.setOnAction(e->window.close());

        VBox MainLayout = new VBox(10);
        HBox SecondaryLayout = new HBox(15);

        SecondaryLayout.getChildren().add(Bok);
        MainLayout.getChildren().addAll(label, SecondaryLayout);

        MainLayout.setAlignment(Pos.CENTER);
        SecondaryLayout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(MainLayout);
        window.setScene(scene);
        window.showAndWait();
    }
}
