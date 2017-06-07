package Model;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Card {
    protected int Season;
    private static Thread thread;
    protected int ID;
    protected String Type;
    protected String BGImage;
    protected String Name;
    protected String Description;

    public Card(String type, int ID) {
        Type = type;
        this.ID = ID;
        BGImage = "/images/" + Type + "/" + ID + ".png";
    }

    /**Return a Card as a GridPane
     * @param size_percentage scale to resize pane
     * @return Card GridPane
     */
    public GridPane getView(double size_percentage, boolean bln) {
        size_percentage /= 100;
        GridPane gridPane = new GridPane();
        if (bln)
            try {
                String Path = (new File("src/Fonts/Danmaku.ttf")).getCanonicalPath();
                gridPane.setAlignment(Pos.CENTER);
                ColumnConstraints clm1 = new ColumnConstraints();
                clm1.setHgrow(Priority.SOMETIMES);
                clm1.setMaxWidth(60 * size_percentage);
                clm1.setMinWidth(60 * size_percentage);
                clm1.setPrefWidth(60 * size_percentage);
                ColumnConstraints clm2 = new ColumnConstraints();
                clm2.setHgrow(Priority.SOMETIMES);
                clm2.setMaxWidth(320 * size_percentage);
                clm2.setMinWidth(320 * size_percentage);
                clm2.setPrefWidth(320 * size_percentage);
                clm2.setHalignment(HPos.CENTER);
                ColumnConstraints clm3 = new ColumnConstraints();
                clm3.setHgrow(Priority.SOMETIMES);
                clm3.setMaxWidth(34 * size_percentage);
                clm3.setMinWidth(34 * size_percentage);
                clm3.setPrefWidth(34 * size_percentage);
                RowConstraints row1 = new RowConstraints();
                RowConstraints row2 = new RowConstraints();
                RowConstraints row3 = new RowConstraints();
                RowConstraints row4 = new RowConstraints();
                RowConstraints row5 = new RowConstraints();
                row1.setVgrow(Priority.SOMETIMES);
                row2.setVgrow(Priority.SOMETIMES);
                row3.setVgrow(Priority.SOMETIMES);
                row4.setVgrow(Priority.SOMETIMES);
                row5.setVgrow(Priority.SOMETIMES);
                row1.setMaxHeight(22 * size_percentage);
                row1.setMinHeight(22 * size_percentage);
                row1.setPrefHeight(22 * size_percentage);
                row2.setMaxHeight(45 * size_percentage);
                row2.setMinHeight(45 * size_percentage);
                row2.setPrefHeight(45 * size_percentage);
                row3.setMaxHeight(283 * size_percentage);
                row3.setMinHeight(283 * size_percentage);
                row3.setPrefHeight(283 * size_percentage);
                row4.setMaxHeight(200 * size_percentage);
                row4.setMinHeight(200 * size_percentage);
                row4.setPrefHeight(200 * size_percentage);
                row5.setMaxHeight(40 * size_percentage);
                row5.setMinHeight(40 * size_percentage);
                row5.setPrefHeight(40 * size_percentage);
                gridPane.getColumnConstraints().add(clm1);
                gridPane.getColumnConstraints().add(clm2);
                gridPane.getColumnConstraints().add(clm3);
                gridPane.getRowConstraints().add(row1);
                gridPane.getRowConstraints().add(row2);
                gridPane.getRowConstraints().add(row3);
                gridPane.getRowConstraints().add(row4);
                gridPane.getRowConstraints().add(row5);

                Text Title = new Text();
                Title.setText(Name);
                Title.setFont(new Font("Times New Roman", 18.5 * size_percentage));
                Font fon = Font.loadFont(new FileInputStream(new File(Path)), 14.10 * size_percentage);
                Text Desc = new Text();
                Desc.setText(Description);
                Desc.setFont(fon);
                BorderPane bp = new BorderPane();
                bp.setLeft(Desc);
                bp.setAlignment(Desc, Pos.CENTER);
                gridPane.add(Title, 1, 1);
                gridPane.add(bp, 1, 3);
                gridPane.setMaxWidth(414 * size_percentage);
                gridPane.setMinWidth(414 * size_percentage);
                gridPane.setPrefWidth(414 * size_percentage);
                gridPane.setMaxHeight(590 * size_percentage);
                gridPane.setMinHeight(590 * size_percentage);
                gridPane.setPrefHeight(590 * size_percentage);
                gridPane.setStyle("-fx-background-image: url(" + BGImage + ");" +
                        " -fx-background-color: transparent;" +
                        " -fx-background-position: center center;" +
                        " -fx-background-repeat: stretch;" +
                        " -fx-background-size: cover");
            } catch (IOException e) {
                e.printStackTrace();
            }
        else {
            gridPane.setMaxWidth(414 * size_percentage);
            gridPane.setMinWidth(414 * size_percentage);
            gridPane.setPrefWidth(414 * size_percentage);
            gridPane.setMaxHeight(590 * size_percentage);
            gridPane.setMinHeight(590 * size_percentage);
            gridPane.setPrefHeight(590 * size_percentage);
            gridPane.setStyle("-fx-background-image: url('Images/" + Type + "/0.png');" +
                    " -fx-background-color: transparent;" +
                    " -fx-background-position: center center;" +
                    " -fx-background-repeat: stretch;" +
                    " -fx-background-size: cover");
        }
        return gridPane;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }


    public static void SetOnMouse__ViewZoom(Pane PatternPane, GridPane View, Card card, boolean bln, double size_percentage, Pos pos){
        View.setOnMouseEntered(e-> {
            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(1001);
                    }
                    catch (InterruptedException e) {
                        failed();
                    }
                    return null;
                }
            };
            sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    GridPane view = card.getView(size_percentage, bln);
                    PatternPane.getChildren().add(view);
                    StackPane.setAlignment(view,pos);
                }
            });
            thread = new Thread(sleeper);
            thread.start();
        });
        View.setOnMouseExited(e -> {
            try {
                thread.stop();
                if (PatternPane.getChildren().size() > 2)
                    PatternPane.getChildren().remove(1, PatternPane.getChildren().size());
                else if (PatternPane.getChildren().size() == 2)
                    PatternPane.getChildren().remove(1);
            }
            catch (NullPointerException error){}
        });



    }
}
