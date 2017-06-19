package Views.Scenes;

import Controller.Controller_SelectCharacter;
import Controller.Controller_Tittle;
import Controller.Main;
import Language.Language;
import Model.CharacterCard;
import Model.DeckCard;
import Model.IncidentCard;
import Model.RoleCard;
import Views.PopUps.PopUp_Error;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Scene_PlaySetup {
    private static final Button back = new Button("Back");

    public static Scene scene() {
        Language lang;
        lang = Main.lang.Lang;
        back.setOnAction(e -> new Controller_Tittle());
        StackPane mainPane = new StackPane();
        mainPane.setAlignment(Pos.CENTER);
        mainPane.getChildren().add(back);
        StackPane.setAlignment(back, Pos.BOTTOM_LEFT);
        Double sizeW = Main.W * 0.85 * 100 / 1100;
        Double sizeH = Main.H * 0.85 * 100 / 620;

        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        Double size_percentage = sizeW > sizeH ? sizeH / 100 : sizeW / 100;
        pane.setPrefSize(1100 * size_percentage, 620 * size_percentage);
        pane.setMinSize(1100 * size_percentage, 620 * size_percentage);
        pane.setMaxSize(1100 * size_percentage, 620 * size_percentage);

        pane.setStyle("-fx-background-image: url('/images/BG/Tile.png'); -fx-background-repeat: stretch; -fx-background-size: cover; -fx-background-color: transparent");
        mainPane.getChildren().add(pane);
        mainPane.setStyle("-fx-background-image: url('/images/BG/Background2.png\');" +
                " -fx-background-position: center center;" +
                " -fx-background-repeat: stretch; -fx-background-size: stretch");
        HBox Hbox = new HBox(5);
        pane.getChildren().add(Hbox);
        VBox Vbox = new VBox(25);
        Vbox.setAlignment(Pos.CENTER);

        ComboBox<String> boxPlayers = new ComboBox<>();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        String[] t = lang.NPlayer;


        observableList.addAll(t[0], t[1], t[2], t[3], t[4]);
        boxPlayers.setItems(observableList);
        boxPlayers.getSelectionModel().select(0);
        CheckBox cb_Heroine = new CheckBox(lang.Heroin2 + "   "), //4
                cb_Rival = new CheckBox(lang.Rival_2 + "   "), //8

                cb_Partner1 = new CheckBox(lang.Partne2 + "   "), //5
                cb_Partner2 = new CheckBox(lang.Partne2 + "   "), //5
                cb_Ex_Mid_Boss = new CheckBox(lang.Exmidb2 + "   "), //5
                cb_One_True_Partner = new CheckBox(lang.OTPart2 + "   "), //7

                cb_Stage_Boss1 = new CheckBox(lang.STGBOS2 + "   "), //4
                cb_Stage_Boss2 = new CheckBox(lang.STGBOS2 + "   "), //4
                cb_Stage_Boss3 = new CheckBox(lang.STGBOS2 + "   "), //4
                cb_Final_Boss = new CheckBox(lang.FinalB2 + "   "), //5
                cb_AntiHeroine = new CheckBox(lang.Anti__2 + "   "), //5
                cb_Challenger = new CheckBox(lang.Challe2 + "   "); //5

        RadioButton tb_Ex_Boss = new RadioButton(lang.Exboss2), //4
                tb_Phantom_Boss = new RadioButton(lang.Phanto2); //4

        ToggleButton LilyWhite = new ToggleButton(lang.Lilwhit1 + ": " + lang.AddLily);
        LilyWhite.setSelected(true);
        final ToggleGroup Group = new ToggleGroup();
        tb_Ex_Boss.setSelected(true);
        tb_Ex_Boss.setToggleGroup(Group);
        tb_Phantom_Boss.setToggleGroup(Group);

        cb_Heroine.setSelected(true);
        cb_Heroine.setDisable(true);
        cb_Rival.setDisable(true);
        cb_Rival.setSelected(false);

        cb_Partner1.setDisable(true);
        cb_Partner2.setDisable(true);
        cb_Ex_Mid_Boss.setDisable(true);
        cb_One_True_Partner.setDisable(true);

        cb_Stage_Boss1.setSelected(true);
        cb_Stage_Boss1.setDisable(true);
        cb_Stage_Boss2.setSelected(true);
        cb_Stage_Boss2.setDisable(true);
        cb_Stage_Boss3.setSelected(false);
        cb_Stage_Boss3.setDisable(true);
        cb_Final_Boss.setDisable(true);
        cb_AntiHeroine.setDisable(true);
        cb_Challenger.setDisable(true);
        final CheckBox[] PartnerCheckboxes = new CheckBox[]{cb_Partner1, cb_Partner2, cb_Ex_Mid_Boss, cb_One_True_Partner};
        final CheckBox[] StageBossesCheckboxes = new CheckBox[]{cb_Stage_Boss1, cb_Stage_Boss2, cb_Stage_Boss3, cb_Final_Boss, cb_AntiHeroine, cb_Challenger};
        boxPlayers.setOnAction(e -> {
            int Option = boxPlayers.getSelectionModel().getSelectedIndex();
            switch (Option) {
                case 0:
                    cb_Rival.setSelected(false);

                    cb_Partner1.setDisable(true);
                    cb_Partner1.setSelected(false);
                    cb_Partner2.setDisable(true);
                    cb_Partner2.setSelected(false);
                    cb_Ex_Mid_Boss.setDisable(true);
                    cb_Ex_Mid_Boss.setSelected(false);
                    cb_One_True_Partner.setDisable(true);
                    cb_One_True_Partner.setSelected(false);

                    cb_Stage_Boss1.setSelected(true);
                    cb_Stage_Boss1.setDisable(true);
                    cb_Stage_Boss2.setSelected(true);
                    cb_Stage_Boss2.setDisable(true);
                    cb_Stage_Boss3.setSelected(false);
                    cb_Stage_Boss3.setDisable(true);
                    cb_Final_Boss.setSelected(false);
                    cb_Final_Boss.setDisable(true);
                    cb_AntiHeroine.setSelected(false);
                    cb_AntiHeroine.setDisable(true);
                    cb_Challenger.setSelected(false);
                    cb_Challenger.setDisable(true);
                    break;
                case 1:
                    cb_Rival.setSelected(false);

                    cb_Partner1.setDisable(false);
                    cb_Partner1.setSelected(false);
                    cb_Partner2.setDisable(false);
                    cb_Partner2.setSelected(false);
                    cb_Ex_Mid_Boss.setDisable(false);
                    cb_Ex_Mid_Boss.setSelected(false);
                    cb_One_True_Partner.setDisable(true);
                    cb_One_True_Partner.setSelected(false);
                    setOnActions(PartnerCheckboxes, 1);

                    cb_Stage_Boss1.setSelected(true);
                    cb_Stage_Boss1.setDisable(false);
                    cb_Stage_Boss2.setSelected(true);
                    cb_Stage_Boss2.setDisable(false);
                    cb_Stage_Boss3.setSelected(false);
                    cb_Stage_Boss3.setDisable(false);
                    cb_Final_Boss.setSelected(false);
                    cb_Final_Boss.setDisable(false);
                    cb_AntiHeroine.setSelected(false);
                    cb_AntiHeroine.setDisable(false);
                    cb_Challenger.setSelected(false);
                    cb_Challenger.setDisable(false);
                    setOnActions(StageBossesCheckboxes, 2);
                    break;
                case 2:
                    cb_Rival.setSelected(false);

                    cb_Partner1.setDisable(false);
                    cb_Partner1.setSelected(false);
                    cb_Partner2.setDisable(false);
                    cb_Partner2.setSelected(false);
                    cb_Ex_Mid_Boss.setDisable(false);
                    cb_Ex_Mid_Boss.setSelected(false);
                    cb_One_True_Partner.setDisable(true);
                    cb_One_True_Partner.setSelected(false);
                    setOnActions(PartnerCheckboxes, 1);

                    cb_Stage_Boss1.setSelected(true);
                    cb_Stage_Boss1.setDisable(false);
                    cb_Stage_Boss2.setSelected(true);
                    cb_Stage_Boss2.setDisable(false);
                    cb_Stage_Boss3.setSelected(false);
                    cb_Stage_Boss3.setDisable(false);
                    cb_Final_Boss.setSelected(false);
                    cb_Final_Boss.setDisable(false);
                    cb_AntiHeroine.setSelected(false);
                    cb_AntiHeroine.setDisable(false);
                    cb_Challenger.setSelected(false);
                    cb_Challenger.setDisable(false);
                    setOnActions(StageBossesCheckboxes, 3);
                    break;
                case 3:
                    cb_Rival.setSelected(false);

                    cb_Partner1.setDisable(false);
                    cb_Partner1.setSelected(false);
                    cb_Partner2.setDisable(false);
                    cb_Partner2.setSelected(false);
                    cb_Ex_Mid_Boss.setDisable(false);
                    cb_Ex_Mid_Boss.setSelected(false);
                    cb_One_True_Partner.setDisable(false);
                    cb_One_True_Partner.setSelected(false);
                    setOnActions(PartnerCheckboxes, 2);

                    cb_Stage_Boss1.setSelected(true);
                    cb_Stage_Boss1.setDisable(false);
                    cb_Stage_Boss2.setSelected(true);
                    cb_Stage_Boss2.setDisable(false);
                    cb_Stage_Boss3.setSelected(false);
                    cb_Stage_Boss3.setDisable(false);
                    cb_Final_Boss.setSelected(false);
                    cb_Final_Boss.setDisable(false);
                    cb_AntiHeroine.setSelected(false);
                    cb_AntiHeroine.setDisable(false);
                    cb_Challenger.setSelected(false);
                    cb_Challenger.setDisable(false);
                    setOnActions(StageBossesCheckboxes, 3);
                    break;
                case 4:
                    cb_Rival.setSelected(true);

                    cb_Partner1.setDisable(false);
                    cb_Partner1.setSelected(false);
                    cb_Partner2.setDisable(false);
                    cb_Partner2.setSelected(false);
                    cb_Ex_Mid_Boss.setDisable(false);
                    cb_Ex_Mid_Boss.setSelected(false);
                    cb_One_True_Partner.setDisable(false);
                    cb_One_True_Partner.setSelected(false);
                    setOnActions(PartnerCheckboxes, 2);

                    cb_Stage_Boss1.setSelected(true);
                    cb_Stage_Boss1.setDisable(false);
                    cb_Stage_Boss2.setSelected(true);
                    cb_Stage_Boss2.setDisable(false);
                    cb_Stage_Boss3.setSelected(false);
                    cb_Stage_Boss3.setDisable(false);
                    cb_Final_Boss.setSelected(false);
                    cb_Final_Boss.setDisable(false);
                    cb_AntiHeroine.setSelected(false);
                    cb_AntiHeroine.setDisable(false);
                    cb_Challenger.setSelected(false);
                    cb_Challenger.setDisable(false);
                    setOnActions(StageBossesCheckboxes, 3);
            }
        });
        GridPane Table = new GridPane();
        Table.add(new Text(Main.lang.Lang.Heroine), 0, 0);
        Table.add(new Text(Main.lang.Lang.Partner), 1, 0);
        Table.add(new Text(Main.lang.Lang.StageBoss), 2, 0);
        Table.add(new Text(Main.lang.Lang.ExtraBoss), 3, 0);
        Table.add(cb_Heroine, 0, 1);
        Table.add(cb_Rival, 0, 2);
        Table.add(cb_Partner1, 1, 1);
        Table.add(cb_Partner2, 1, 2);
        Table.add(cb_Ex_Mid_Boss, 1, 3);
        Table.add(cb_One_True_Partner, 1, 4);
        Table.add(cb_Stage_Boss1, 2, 1);
        Table.add(cb_Stage_Boss2, 2, 2);
        Table.add(cb_Stage_Boss3, 2, 3);
        Table.add(cb_Final_Boss, 2, 4);
        Table.add(cb_Challenger, 2, 5);
        Table.add(cb_AntiHeroine, 2, 6);
        Table.add(tb_Ex_Boss, 3, 1);
        Table.add(tb_Phantom_Boss, 3, 2);


        Button Play = new Button("Play");
        Table.setAlignment(Pos.CENTER);
        Hbox.getChildren().addAll(boxPlayers, Vbox);
        Vbox.getChildren().addAll(Table, LilyWhite, Play);
        LilyWhite.setSelected(true);
        Hbox.setScaleX(1.2);
        Hbox.setScaleY(1.2);
        Hbox.setAlignment(Pos.CENTER);

        Play.setOnAction(e -> {
            int NofPlayer = 4 + boxPlayers.getSelectionModel().getSelectedIndex();
            int NofSelectedRoles = NofPlayer == 8 ? 3 : 2;
            for (CheckBox checkbox : PartnerCheckboxes) {
                if (checkbox.isSelected())
                    NofSelectedRoles++;
            }
            for (CheckBox checkbox : StageBossesCheckboxes) {
                if (checkbox.isSelected())
                    NofSelectedRoles++;
            }
            if (NofPlayer == NofSelectedRoles) {
                int[] Roles = new int[NofPlayer];
                int i = 1;
                if (cb_AntiHeroine.isSelected()) {
                    Roles[i] = 1;
                    i++;
                }
                if (cb_Challenger.isSelected()) {
                    Roles[i] = 2;
                    i++;
                }
                if (tb_Ex_Boss.isSelected()) {
                    Roles[i] = 3;
                    i++;
                }
                if (cb_Ex_Mid_Boss.isSelected()) {
                    Roles[i] = 5;
                    i++;
                }
                if (cb_Final_Boss.isSelected()) {
                    Roles[i] = 6;
                    i++;
                }
                Roles[0] = 7;
                if (cb_One_True_Partner.isSelected()) {
                    Roles[i] = 8;
                    i++;
                }
                if (cb_Partner1.isSelected()) {
                    Roles[i] = 9;
                    i++;
                }
                if (cb_Partner2.isSelected()) {
                    Roles[i] = 10;
                    i++;
                }
                if (tb_Phantom_Boss.isSelected()) {
                    Roles[i] = 11;
                    i++;
                }
                if (cb_Rival.isSelected()) {
                    Roles[i] = 12;
                    i++;
                }
                if (cb_Stage_Boss1.isSelected()) {
                    Roles[i] = 13;
                    i++;
                }
                if (cb_Stage_Boss2.isSelected()) {
                    Roles[i] = 14;
                    i++;
                }
                if (cb_Stage_Boss3.isSelected()) {
                    Roles[i] = 15;
                }
                CharacterCard[] CharacterDeck = CharacterCard.generateCharacterDeck();
                DeckCard[] Deck = Model.DeckCard.generateDeck();
                IncidentCard.setLilyWhite(LilyWhite.isSelected());
                RoleCard[] RoleDeck = RoleCard.generateRoleCardDeck(Roles);
                new Controller_SelectCharacter(Deck, RoleDeck, CharacterDeck);
            } else {
                PopUp_Error.display(lang.NofRolesError);
            }
        });
        return new Scene(mainPane);
    }

    private static void setOnActions(CheckBox[] CheckBoxes, int limit) {
        for (CheckBox checkBox : CheckBoxes)
            checkBox.setOnAction(ev -> {
                boolean limitReached;
                if (checkBox.isSelected()) {
                    int selected = 0;
                    for (CheckBox checkBox2 : CheckBoxes)
                        if (checkBox2.isSelected())
                            selected++;
                    limitReached = limit < selected;
                    if (limitReached)
                        checkBox.setSelected(false);
                    else
                        checkBox.setSelected(true);
                }
            });
    }
}
