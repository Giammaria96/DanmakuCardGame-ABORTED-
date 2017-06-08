package Model;

import Controller.Main;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CharacterCard extends Card {
    private String Tittle;
    private String SpellTittle;
    private String SpellName;
    private String Spellcard;

    public CharacterCard(int ID) {
        super("Character", ID);
        this.ID = ID;
        String[] text = Main.lang.Lang.getCharacterText(ID);
        Tittle = text[0];
        Name = text[1];
        Description = text[2];
        SpellTittle = text[3];
        SpellName = text[4];
        Spellcard = text[5];
    }

    public static CharacterCard[] shuffle(CharacterCard[] toShuffle) {
        List<CharacterCard> CardList = Arrays.asList(toShuffle);
        Collections.shuffle(CardList);
        return CardList.toArray(new CharacterCard[CardList.size()]);
    }

    public static CharacterCard[] generateCharacterDeck() {
        CharacterCard[] Deck = new CharacterCard[24];
        for (int i = 0; i < 24; i++) {
            Deck[i] = new CharacterCard(i + 1);
        }
        Deck = shuffle(Deck);
        return Deck;
    }

    @Override
    public GridPane getView(double size_percentage, boolean bln) {
        GridPane gridPane = new GridPane();
        size_percentage /= 100;
        if (bln)
            try {
                String Path = (new File("src/Fonts/Danmaku.ttf")).getCanonicalPath();
                gridPane.setAlignment(Pos.CENTER);

                //<editor-fold defaultstate="collapsed" desc="ColumnConstraints">
                ColumnConstraints clm1 = new ColumnConstraints();
                ColumnConstraints clm2 = new ColumnConstraints();
                ColumnConstraints clm3 = new ColumnConstraints();
                clm1.setHgrow(Priority.SOMETIMES);
                clm1.setPrefWidth(302 * size_percentage);
                clm1.setMinWidth(302 * size_percentage);
                clm1.setMaxWidth(302 * size_percentage);
                clm2.setHgrow(Priority.SOMETIMES);
                clm2.setPrefWidth(255 * size_percentage);
                clm2.setMinWidth(255 * size_percentage);
                clm2.setMaxWidth(255 * size_percentage);
                clm2.setHalignment(HPos.CENTER);
                clm3.setHgrow(Priority.SOMETIMES);
                clm3.setPrefWidth(43 * size_percentage);
                clm3.setMinWidth(43 * size_percentage);
                clm3.setMaxWidth(43 * size_percentage);
                gridPane.getColumnConstraints().add(clm1);
                gridPane.getColumnConstraints().add(clm2);
                gridPane.getColumnConstraints().add(clm3);
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="RowConstraints">
                RowConstraints row1 = new RowConstraints();
                RowConstraints row2 = new RowConstraints();
                RowConstraints row3 = new RowConstraints();
                RowConstraints row4 = new RowConstraints();
                RowConstraints row5 = new RowConstraints();
                RowConstraints row6 = new RowConstraints();
                RowConstraints row7 = new RowConstraints();
                RowConstraints row8 = new RowConstraints();
                row1.setVgrow(Priority.SOMETIMES);
                row1.setPrefHeight(21 * size_percentage);
                row1.setMinHeight(21 * size_percentage);
                row1.setMaxHeight(21 * size_percentage);
                row2.setVgrow(Priority.SOMETIMES);
                row2.setPrefHeight(18 * size_percentage);
                row2.setMinHeight(18 * size_percentage);
                row2.setMaxHeight(18 * size_percentage);
                row3.setVgrow(Priority.SOMETIMES);
                row3.setPrefHeight(36 * size_percentage);
                row3.setMinHeight(36 * size_percentage);
                row3.setMaxHeight(36 * size_percentage);
                row4.setVgrow(Priority.SOMETIMES);
                row4.setPrefHeight(134 * size_percentage);
                row4.setMinHeight(134 * size_percentage);
                row4.setMaxHeight(134 * size_percentage);
                row5.setVgrow(Priority.SOMETIMES);
                row5.setPrefHeight(15 * size_percentage);
                row5.setMinHeight(15 * size_percentage);
                row5.setMaxHeight(15 * size_percentage);
                row6.setVgrow(Priority.SOMETIMES);
                row6.setPrefHeight(23 * size_percentage);
                row6.setMinHeight(23 * size_percentage);
                row6.setMaxHeight(23 * size_percentage);
                row7.setVgrow(Priority.SOMETIMES);
                row7.setPrefHeight(136 * size_percentage);
                row7.setMinHeight(136 * size_percentage);
                row7.setMaxHeight(136 * size_percentage);
                row8.setVgrow(Priority.SOMETIMES);
                row8.setPrefHeight(37 * size_percentage);
                row8.setMinHeight(37 * size_percentage);
                row8.setMaxHeight(37 * size_percentage);
                gridPane.getRowConstraints().add(row1);
                gridPane.getRowConstraints().add(row2);
                gridPane.getRowConstraints().add(row3);
                gridPane.getRowConstraints().add(row4);
                gridPane.getRowConstraints().add(row5);
                gridPane.getRowConstraints().add(row6);
                gridPane.getRowConstraints().add(row7);
                gridPane.getRowConstraints().add(row8);
                //</editor-fold>

                Text Name_Title = new Text();
                Text Name = new Text();
                Text Passive = new Text();
                Text Bomb_Title = new Text();
                Text Bomb_Name = new Text();
                Text Bomb_Desc = new Text();

                Name_Title.setStyle("-fx-alignment: center;");
                Name_Title.setText(this.Tittle);
                Name_Title.setFont(new Font("Times New Roman", 13 * size_percentage));
                Name_Title.setTextAlignment(TextAlignment.CENTER);
                Name.setStyle("-fx-alignment: center;");
                Name.setText(this.Name);
                Name.setFont(new Font("Times New Roman", 20.8 * size_percentage));
                Name.setTextAlignment(TextAlignment.CENTER);
                Font fon1 = Font.loadFont(new FileInputStream(new File(Path)), 14.10 * size_percentage);
                Passive.setFont(fon1);
                Passive.setText(this.Description);

                Bomb_Title.setText(this.SpellTittle);
                Bomb_Title.setStyle("-fx-alignment: center;");
                Bomb_Title.setFont(new Font("Times New Roman", 13 * size_percentage));
                Bomb_Title.setTextAlignment(TextAlignment.CENTER);

                Bomb_Name.setText(this.SpellName);
                Bomb_Name.setStyle("-fx-alignment: center;");
                Bomb_Name.setFont(new Font("Times New Roman", 15 * size_percentage));
                Bomb_Name.setTextAlignment(TextAlignment.CENTER);
                Font fon2 = Font.loadFont(new FileInputStream(new File(Path)), 14.10 * size_percentage);
                Bomb_Desc.setFont(fon2);
                Bomb_Desc.setText(this.Spellcard);
                Bomb_Desc.setX(2);

                BorderPane bp1 = new BorderPane();
                BorderPane bp2 = new BorderPane();
                bp1.setLeft(Passive);
                bp1.setAlignment(Passive, Pos.CENTER);
                bp2.setLeft(Bomb_Desc);
                bp2.setAlignment(Bomb_Desc, Pos.CENTER);
                gridPane.add(Name_Title, 1, 1);
                gridPane.add(Name, 1, 2);
                gridPane.add(bp1, 1, 3);
                gridPane.add(Bomb_Title, 1, 4);
                gridPane.add(Bomb_Name, 1, 5);
                gridPane.add(bp2, 1, 6);
                gridPane.setMaxWidth(600 * size_percentage);
                gridPane.setMinWidth(600 * size_percentage);
                gridPane.setPrefWidth(600 * size_percentage);
                gridPane.setMaxHeight(420 * size_percentage);
                gridPane.setMinHeight(420 * size_percentage);
                gridPane.setPrefHeight(420 * size_percentage);
                gridPane.setStyle("-fx-background-image: url(" + BGImage + ");" +
                        " -fx-background-color: transparent;" +
                        " -fx-background-position: center center;" +
                        " -fx-background-repeat: stretch;" +
                        " -fx-background-size: cover");
            } catch (IOException e) {
                e.printStackTrace();
            }
        else {
            gridPane.setMaxWidth(600 * size_percentage);
            gridPane.setMinWidth(600 * size_percentage);
            gridPane.setPrefWidth(600 * size_percentage);
            gridPane.setMaxHeight(420 * size_percentage);
            gridPane.setMinHeight(420 * size_percentage);
            gridPane.setPrefHeight(420 * size_percentage);
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
}
