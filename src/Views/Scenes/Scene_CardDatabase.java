package Views.Scenes;

import Controller.Controller_Tittle;
import Controller.Main;
import Language.Language;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;

public class Scene_CardDatabase extends Scene {
    private static StackPane root;
    private Button[] buttons = new Button[4];
    private Button back;
    private Language text;
    private GridPane_cardDisplayer cardDeployer;
    private double W,H;

    public Scene_CardDatabase() {
        super(root());
        text = Main.lang.Lang;
        initComponent();
    }
    private void initComponent(){
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-image: url('/images/BG/Background2.png\');" +
                " -fx-background-position: center center;" +
                " -fx-background-repeat: stretch; -fx-background-size: stretch");
        Double sizeW = Main.W * 0.85 * 100 / 1100;
        Double sizeH = Main.H * 0.85 * 100 / 620;

        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        Double size_percentage = sizeW > sizeH ? sizeH / 100 : sizeW / 100;
        this.W = 1100 * size_percentage;
        this.H = 620 * size_percentage;
        pane.setPrefSize(W,H );
        pane.setMinSize(W, H);
        pane.setMaxSize(W, H);

        pane.setStyle("-fx-background-image: url('/images/BG/Tile.png'); -fx-background-repeat: stretch; -fx-background-size: cover; -fx-background-color: transparent");
        root.getChildren().add(pane);

        GridPane ButtonsPane = new GridPane();
        ButtonsPane.setStyle("-fx-cell-size: inherit");
        ButtonsPane.setAlignment(Pos.CENTER);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHalignment(HPos.CENTER);
        col1.setPrefWidth(pane.getPrefWidth() / 2 - 10);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHalignment(HPos.CENTER);
        col2.setPrefWidth(pane.getPrefWidth() / 2 - 10);
        RowConstraints row1 = new RowConstraints();
        row1.setValignment(VPos.CENTER);
        row1.setPrefHeight(pane.getPrefHeight() / 2);
        RowConstraints row2 = new RowConstraints();
        row2.setValignment(VPos.CENTER);
        row2.setPrefHeight(pane.getPrefHeight() / 2);
        ButtonsPane.getRowConstraints().addAll(row1, row2);
        ButtonsPane.getColumnConstraints().addAll(col1, col2);

        for (int i = 0; i < 4; i++) {
            buttons[i] = new Button(text.getCDBBText()[i]);
            buttons[i].setStyle(" -fx-background-color: transparent;" +
                    " -fx-background-image: url('/images/Buttons/CDBB.png\');" +
                    " -fx-background-position: center center;" +
                    " -fx-background-repeat: stretch;" +
                    "-fx-background-size: stretch;");
            buttons[i].setMaxSize(400, 100);
            buttons[i].setMinSize(150, 100);
            buttons[i].setPrefSize(320, 100);
            buttons[i].setFont(new Font("Times New Roman", 30));
        }
        ButtonsPane.add(buttons[0], 0, 0);
        ButtonsPane.add(buttons[1], 1, 0);
        ButtonsPane.add(buttons[2], 0, 1);
        ButtonsPane.add(buttons[3], 1, 1);

        pane.getChildren().add(ButtonsPane);
        back = new Button("Back");
        back.setOnAction(e -> new Controller_Tittle());
        root.getChildren().add(back);
        StackPane.setAlignment(back, Pos.BOTTOM_LEFT);

    }
    private static Parent root(){
        root=new StackPane();
        return root;
    }






    public Pane getRootPane(){
        return root;
    }
    public void generateCardDeployer( String type){
        cardDeployer= new GridPane_cardDisplayer(
                W,
                H,
                type);
        root.getChildren().add(cardDeployer);
    }
    public void setCardList(ObservableList<Hyperlink> list){
        cardDeployer.setCardList(list);
    }
    public Button getBackButton(){
        return back;
    }
    public Button getRoleButton(){
        return buttons[0];
    }
    public Button getDeckButton(){
        return buttons[1];
    }
    public Button getIncidentButton(){
        return buttons[2];
    }
    public Button getCharacterButton(){
        return buttons[3];
    }
    public double getSizePercentage(){
        return cardDeployer.getSize_percentage();
    }
    public StackPane getImageGridPane(){
        return cardDeployer.getImgPane();
    }
}







class GridPane_cardDisplayer extends GridPane{
    private double size_percentage;
    private StackPane CardDeploy;
    private double W,H;
    GridPane_cardDisplayer(double W, double H, String type){
        this.W = W;
        this.H = H;
        ColumnConstraints col = new ColumnConstraints();
        col.setHalignment(HPos.RIGHT);
        col.setPrefWidth(W / 2 - 14);
        ColumnConstraints co2 = new ColumnConstraints();
        co2.setHalignment(HPos.CENTER);
        co2.setPrefWidth(W / 2 - 14);
        getColumnConstraints().addAll(col, co2);
        setPrefSize(W, H);
        setMinSize(W, H);
        setMaxSize(W, H);
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-image: url('/images/BG/CDB.png');" +
                " -fx-background-repeat: stretch;" +
                " -fx-background-size: cover;" +
                " -fx-background-color: transparent");

        CardDeploy = new StackPane();

        CardDeploy.setAlignment(Pos.CENTER);



        double sizeW;
        double sizeH;
        ImageView img = new ImageView();
        if ("Character".equals(type)) {
            sizeW = (W / 2 - 25) * 100 / 600;
            sizeH = (H - 25) * 100 / 420;
            size_percentage = sizeW > sizeH ? sizeH : sizeW;
            img.setFitHeight(420 * size_percentage / 100);
        } else {
            sizeW = (W / 2 - 40) * 100 / 420;
            sizeH = (H - 40) * 100 / 590;
            size_percentage = sizeW > sizeH ? sizeH : sizeW;
            img.setFitWidth(420 * size_percentage / 100);
        }


        GridPane imgPane = new GridPane();
        imgPane.add(img, 0, 0);
        img.setImage(new Image("Images/" + type + "/0.png"));
        img.setPreserveRatio(true);
        imgPane.setRotationAxis(Rotate.Y_AXIS);
        CardDeploy.getChildren().add(img);

        add(CardDeploy, 0, 0);

    }

    void setCardList(ObservableList<Hyperlink> listItem){
        ListView<Hyperlink> List = new ListView<>();
        ObservableList<Hyperlink> items = FXCollections.observableArrayList();
        items.addAll(listItem);
        List.getStylesheets().add("Views/list.CSS");
        List.setItems(items);
        List.setPrefSize(W / 2 - 20, H - 24);
        List.setMaxSize(W / 2 - 20, H - 24);
        List.setMinSize(W / 2 - 20, H - 24);
        add(List, 1, 0);
    }
    StackPane getImgPane(){
        return CardDeploy;
    }
    double getSize_percentage(){
        return size_percentage;
    }
}
