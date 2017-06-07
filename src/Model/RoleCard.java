package Model;

import Controller.Main;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static javafx.geometry.HPos.CENTER;

public class RoleCard extends Card {
    private String Tittle;
    private boolean revealed = false;

    public RoleCard(int ID) {
        super("Role", ID);
        String[] text = Main.lang.Lang.getRoleText(ID);
        Tittle = text[0];
        Name = text[1];
        Description = text[2];
        if (ID == 7)
            revealed=true;
    }

    @Override
    public GridPane getView(double size_percentage, boolean bln) {
        size_percentage/=100;
        GridPane gridPane = new GridPane();
        if (bln || this.isRevealed())
        try {
            String Path = (new File("src/Fonts/Danmaku.ttf")).getCanonicalPath();
            BorderPane bp = new BorderPane();
            //<editor-fold defaultstate="collapsed" desc="ColumnConstraints">
            ColumnConstraints col1 = new ColumnConstraints();
            ColumnConstraints col2 = new ColumnConstraints();
            ColumnConstraints col3 = new ColumnConstraints();
            col1.setMaxWidth(43*size_percentage);
            col1.setMinWidth(43*size_percentage);
            col1.setPrefWidth(43*size_percentage);
            col2.setPrefWidth(357*size_percentage);
            col2.setMaxWidth(357*size_percentage);
            col2.setMinWidth(357*size_percentage);
            col2.setHalignment(CENTER);
            col3.setMinWidth(19*size_percentage);
            col3.setMaxWidth(19*size_percentage);
            col3.setPrefWidth(19*size_percentage);
            gridPane.getColumnConstraints().add(col1);
            gridPane.getColumnConstraints().add(col2);
            gridPane.getColumnConstraints().add(col3);
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="RowConstraints">
            RowConstraints row1 = new RowConstraints();
            RowConstraints row2 = new RowConstraints();
            RowConstraints row3 = new RowConstraints();
            RowConstraints row4 = new RowConstraints();
            RowConstraints row5 = new RowConstraints();
            RowConstraints row6 = new RowConstraints();
            row1.setMaxHeight(22*size_percentage);
            row1.setMinHeight(22*size_percentage);
            row1.setPrefHeight(22*size_percentage);
            row2.setMaxHeight(18*size_percentage);
            row2.setMinHeight(18*size_percentage);
            row2.setPrefHeight(18*size_percentage);
            row3.setMaxHeight(26*size_percentage);
            row3.setMinHeight(26*size_percentage);
            row3.setPrefHeight(26*size_percentage);
            row4.setMaxHeight(294*size_percentage);
            row4.setMinHeight(294*size_percentage);
            row4.setPrefHeight(294*size_percentage);
            row5.setMaxHeight(190*size_percentage);
            row5.setMinHeight(190*size_percentage);
            row5.setPrefHeight(190*size_percentage);
            row6.setMaxHeight(48*size_percentage);
            row6.setMinHeight(48*size_percentage);
            row6.setPrefHeight(48*size_percentage);
            gridPane.getRowConstraints().add(row1);
            gridPane.getRowConstraints().add(row2);
            gridPane.getRowConstraints().add(row3);
            gridPane.getRowConstraints().add(row4);
            gridPane.getRowConstraints().add(row5);
            gridPane.getRowConstraints().add(row6);

            //</editor-fold>

            Text Tittle = new Text();
            Text Name = new Text();
            Text Desc = new Text();
            Tittle.setText(this.Tittle);
            Name.setText(this.Name);
            Desc.setText(Description);
            Font fon = Font.loadFont(new FileInputStream(new File(Path)), 16.10*size_percentage);
            Tittle.setFont(new Font("Times New Roman",14*size_percentage));
            Name.setFont(new Font("Times New Roman",26*size_percentage));
            Desc.setFont(fon);
            bp.setLeft(Desc);
            bp.setAlignment(Desc, Pos.CENTER_LEFT);
            gridPane.add(Tittle,1,1);
            gridPane.add(Name,1,2);
            gridPane.add(bp,1,4);
            gridPane.setMaxSize(419*size_percentage,598*size_percentage);
            gridPane.setMinSize(419*size_percentage,598*size_percentage);
            gridPane.setPrefSize(419*size_percentage,598*size_percentage);
            gridPane.setStyle("-fx-background-image: url("+BGImage+");"+
                    " -fx-background-color: transparent;"+
                    " -fx-background-position: center center;"+
                    " -fx-background-repeat: stretch;"+
                    " -fx-background-size: cover");
        } catch (IOException e) {
            e.printStackTrace();
        }
        else{
            gridPane.setMaxWidth(419 * size_percentage);
            gridPane.setMinWidth(419 * size_percentage);
            gridPane.setPrefWidth(419 * size_percentage);
            gridPane.setMaxHeight(598 * size_percentage);
            gridPane.setMinHeight(598 * size_percentage);
            gridPane.setPrefHeight(598 * size_percentage);
            gridPane.setStyle("-fx-background-image: url('Images/"+Type+"/0.png');" +
                    " -fx-background-color: transparent;" +
                    " -fx-background-position: center center;" +
                    " -fx-background-repeat: stretch;" +
                    " -fx-background-size: cover");
        }
        return gridPane;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public static RoleCard[] shuffle(RoleCard[] toShuffle) {
        List<RoleCard> CardList = Arrays.asList(toShuffle);
        Collections.shuffle(CardList);
        return CardList.toArray(new RoleCard[CardList.size()]);
    }

    public static RoleCard[] generateRoleCardDeck(int[] Roles){
        RoleCard[] Deck = new RoleCard[Roles.length];
        for (int i = 0; i < Roles.length; i++) {
            Deck[i] = new RoleCard(Roles[i]);
        }
        Deck = shuffle(Deck);
        return Deck;
    }
}
