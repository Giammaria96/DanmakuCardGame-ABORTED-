package Model;

import Controller.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DeckCard extends Card {
    private int Season;
    private boolean Action;
    private boolean Reaction;
    private boolean Healing;
    private boolean Invocation;
    private boolean Item;
    private boolean Defense;
    private boolean Graze;
    private boolean Danmaku;
    private boolean Artifact;
    private boolean Powerup;

    public DeckCard(int ID) {
        super("Deck", ID);
        this.ID = ID;
        String[] text = Main.lang.Lang.getDeckText(ID);
        BufferedReader FILE = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/Images/Deck/" + ID + ".dat")));
        try {
            Season = Integer.parseInt(FILE.readLine());
            Action = setCharacteristics(FILE.readLine());
            Reaction = setCharacteristics(FILE.readLine());
            Healing = setCharacteristics(FILE.readLine());
            Invocation = setCharacteristics(FILE.readLine());
            Item = setCharacteristics(FILE.readLine());
            Defense = setCharacteristics(FILE.readLine());
            Graze = setCharacteristics(FILE.readLine());
            Danmaku = setCharacteristics(FILE.readLine());
            Artifact = setCharacteristics(FILE.readLine());
            Powerup = setCharacteristics(FILE.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Name = text[0];
        Description = text[1];
    }

    public static DeckCard[] shuffle(DeckCard[] toShuffle) {
        List<DeckCard> CardList = Arrays.asList(toShuffle);
        Collections.shuffle(CardList);
        return CardList.toArray(new DeckCard[CardList.size()]);
    }

    public static DeckCard[] generateDeck() {
        DeckCard[] Deck = new DeckCard[80];
        for (int i = 0; i < 80; i++) {
            Deck[i] = new DeckCard(i + 1);
        }
        Deck = shuffle(Deck);
        return Deck;
    }

    private boolean setCharacteristics(String bln) {
        return Objects.equals("1", bln);
    }

    /**@return 0 = Autumn
     * 1 = Winter
     * 2 = Spring
     * 3 = Summer
     **/
    public int getSeason() {
        return Season;
    }

    public boolean isAction() {
        return Action;
    }

    public boolean isReaction() {
        return Reaction;
    }

    public boolean isHealing() {
        return Healing;
    }

    public boolean isInvocation() {
        return Invocation;
    }

    public boolean isItem() {
        return Item;
    }

    public boolean isDefense() {
        return Defense;
    }

    public boolean isGraze() {
        return Graze;
    }

    public boolean isDanmaku() {
        return Danmaku;
    }

    public boolean isArtifact() {
        return Artifact;
    }

    public boolean isPowerup() {
        return Powerup;
    }
}
