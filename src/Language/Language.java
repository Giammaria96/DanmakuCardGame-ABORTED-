package Language;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Language {

    //<editor-fold defaultstate="collapsed" desc="Variable declaration">
    public Language Lang;
    public String
            Alice1, Alice2, Alice3, Alice4, Alice5, Alice6, Cirno1, Cirno2, Cirno3, Cirno4, Cirno5, Cirno6,
            Reimu1, Reimu2, Reimu3, Reimu4, Reimu5, Reimu6, Byaku1, Byaku2, Byaku3, Byaku4, Byaku5, Byaku6,
            Tensh1, Tensh2, Tensh3, Tensh4, Tensh5, Tensh6, China1, China2, China3, China4, China5, China6,
            Suika1, Suika2, Suika3, Suika4, Suika5, Suika6, Sakuy1, Sakuy2, Sakuy3, Sakuy4, Sakuy5, Sakuy6,
            Keine1, Keine2, Keine3, Keine4, Keine5, Keine6, Kappa1, Kappa2, Kappa3, Kappa4, Kappa5, Kappa6,
            Yuuka1, Yuuka2, Yuuka3, Yuuka4, Yuuka5, Yuuka6, Maria1, Maria2, Maria3, Maria4, Maria5, Maria6,
            Sanae1, Sanae2, Sanae3, Sanae4, Sanae5, Sanae6, Sator1, Sator2, Sator3, Sator4, Sator5, Sator6,
            Youmu1, Youmu2, Youmu3, Youmu4, Youmu5, Youmu6, Futo_1, Futo_2, Futo_3, Futo_4, Futo_5, Futo_6,
            Patch1, Patch2, Patch3, Patch4, Patch5, Patch6, Inaba1, Inaba2, Inaba3, Inaba4, Inaba5, Inaba6,
            Okuu_1, Okuu_2, Okuu_3, Okuu_4, Okuu_5, Okuu_6, Remil1, Remil2, Remil3, Remil4, Remil5, Remil6,
            Ayaya1, Ayaya2, Ayaya3, Ayaya4, Ayaya5, Ayaya6, Miko_1, Miko_2, Miko_3, Miko_4, Miko_5, Miko_6,
            Eirin1, Eirin2, Eirin3, Eirin4, Eirin5, Eirin6, Yukar1, Yukar2, Yukar3, Yukar4, Yukar5, Yukar6,

    Anti__1, Anti__2, Anti__3, Challe1, Challe2, Challe3, Exboss1, Exboss2, Exboss3, ExbosR1, ExbosR2, ExbosR3,
            Exmidb1, Exmidb2, Exmidb3, FinalB1, FinalB2, FinalB3, Heroin1, Heroin2, Heroin3, OTPart1, OTPart2, OTPart3,
            Partne1, Partne2, Partne3, Phanto1, Phanto2, Phanto3, Rival_1, Rival_2, Rival_3, STGBOS1, STGBOS2, STGBOS3,
            TPhant1, TPhant2, TPhant3,

    UP1___1, UP1___2, BOMB__1, BOMB__2, Caspca1, Caspca2, Focus_1, Focus_2,
            Graze_1, Graze_2, Grimoi1, Grimoi2, Kourin1, Kourin2, Lassho1, Lassho2,
            Laswor1, Laswor2, Maspla1, Maspla2, Melee_1, Melee_2, Mihakk1, Mihakk2,
            Party_1, Party_2, Power_1, Power_2, Sealaw1, Sealaw2, Shoot_1, Shoot_2,
            Sosusc1, Sosusc2, Spiatk1, Spiatk2, Stopwa1, Stopwa2, Sunabo1, Sunabo2,
            Tempes1, Tempes2, Voile_1, Voile_2, Borrow1, Borrow2,

    Crioffa1, Crioffa2, Crotohi1, Crotohi2,
            Endpart1, Endpart2, Eternig1, Eternig2,
            Fiimreq1, Fiimreq2, Grbawea1, Grbawea2,
            Grfawar1, Grfawar2, Overdri1, Overdri2,
            Reblhel1, Reblhel2, Saayblo1, Saayblo2,
            Scwerha1, Scwerha2, Sprsnow1, Sprsnow2,
            Unfaobj1, Unfaobj2, Votomak1, Votomak2,
            Wordesi1, Wordesi2, Lilwhit1, Lilwhit2,

    Yes, No, Confirm, chslang, conlang, RoleCar, MaDeCar, InciCar, CharCar,
            Heroine, StageBoss, ExtraBoss, Partner, AddLily, NofRolesError,
            CharacterChoice, step1, step2, step3, step4, step5,

    PlayerStats, infinite, ViewStats, EndTurn,
            Back, SandB, Exit, SandE,
            language,NewGame,NetPlay,HowToPlay,CardDatabase,Configuration;

    public String[] NPlayer = new String[5];

    //</editor-fold>

    public static String[] availableLanguages = new String[]{
            "English",
            "Español"
    };
    public static String SelectedLanguage = "English";
    public Language() {
        try {
            SelectedLanguage = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/Controller/SETUP.dat"))).readLine();
        } catch (Exception e) {
            SelectedLanguage = "English";
        }
        if ("Español".equals(SelectedLanguage)) Lang = new Spanish();
        else Lang = new English();
    }

    public Language(String languageName){
        SelectedLanguage = languageName;
        if ("Español".equals(SelectedLanguage))
            Lang = new Spanish();
        else
            Lang = new English();
    }

    //<editor-fold defaultstate="collapsed" desc="For Children usage ONLY">
    public Language(String... List) {
        int i=0;
        Alice1 = List[i++];
        Alice2 = List[i++];
        Alice3 = List[i++];
        Alice4 = List[i++];
        Alice5 = List[i++];
        Alice6 = List[i++];
        Cirno1 = List[i++];
        Cirno2 = List[i++];
        Cirno3 = List[i++];
        Cirno4 = List[i++];
        Cirno5 = List[i++];
        Cirno6 = List[i++];
        Reimu1 = List[i++];
        Reimu2 = List[i++];
        Reimu3 = List[i++];
        Reimu4 = List[i++];
        Reimu5 = List[i++];
        Reimu6 = List[i++];
        Byaku1 = List[i++];
        Byaku2 = List[i++];
        Byaku3 = List[i++];
        Byaku4 = List[i++];
        Byaku5 = List[i++];
        Byaku6 = List[i++];
        Tensh1 = List[i++];
        Tensh2 = List[i++];
        Tensh3 = List[i++];
        Tensh4 = List[i++];
        Tensh5 = List[i++];
        Tensh6 = List[i++];
        China1 = List[i++];
        China2 = List[i++];
        China3 = List[i++];
        China4 = List[i++];
        China5 = List[i++];
        China6 = List[i++];
        Suika1 = List[i++];
        Suika2 = List[i++];
        Suika3 = List[i++];
        Suika4 = List[i++];
        Suika5 = List[i++];
        Suika6 = List[i++];
        Sakuy1 = List[i++];
        Sakuy2 = List[i++];
        Sakuy3 = List[i++];
        Sakuy4 = List[i++];
        Sakuy5 = List[i++];
        Sakuy6 = List[i++];
        Keine1 = List[i++];
        Keine2 = List[i++];
        Keine3 = List[i++];
        Keine4 = List[i++];
        Keine5 = List[i++];
        Keine6 = List[i++];
        Kappa1 = List[i++];
        Kappa2 = List[i++];
        Kappa3 = List[i++];
        Kappa4 = List[i++];
        Kappa5 = List[i++];
        Kappa6 = List[i++];
        Yuuka1 = List[i++];
        Yuuka2 = List[i++];
        Yuuka3 = List[i++];
        Yuuka4 = List[i++];
        Yuuka5 = List[i++];
        Yuuka6 = List[i++];
        Maria1 = List[i++];
        Maria2 = List[i++];
        Maria3 = List[i++];
        Maria4 = List[i++];
        Maria5 = List[i++];
        Maria6 = List[i++];
        Sanae1 = List[i++];
        Sanae2 = List[i++];
        Sanae3 = List[i++];
        Sanae4 = List[i++];
        Sanae5 = List[i++];
        Sanae6 = List[i++];
        Sator1 = List[i++];
        Sator2 = List[i++];
        Sator3 = List[i++];
        Sator4 = List[i++];
        Sator5 = List[i++];
        Sator6 = List[i++];
        Youmu1 = List[i++];
        Youmu2 = List[i++];
        Youmu3 = List[i++];
        Youmu4 = List[i++];
        Youmu5 = List[i++];
        Youmu6 = List[i++];
        Futo_1 = List[i++];
        Futo_2 = List[i++];
        Futo_3 = List[i++];
        Futo_4 = List[i++];
        Futo_5 = List[i++];
        Futo_6 = List[i++];
        Patch1 = List[i++];
        Patch2 = List[i++];
        Patch3 = List[i++];
        Patch4 = List[i++];
        Patch5 = List[i++];
        Patch6 = List[i++];
        Inaba1 = List[i++];
        Inaba2 = List[i++];
        Inaba3 = List[i++];
        Inaba4 = List[i++];
        Inaba5 = List[i++];
        Inaba6 = List[i++];
        Okuu_1 = List[i++];
        Okuu_2 = List[i++];
        Okuu_3 = List[i++];
        Okuu_4 = List[i++];
        Okuu_5 = List[i++];
        Okuu_6 = List[i++];
        Remil1 = List[i++];
        Remil2 = List[i++];
        Remil3 = List[i++];
        Remil4 = List[i++];
        Remil5 = List[i++];
        Remil6 = List[i++];
        Ayaya1 = List[i++];
        Ayaya2 = List[i++];
        Ayaya3 = List[i++];
        Ayaya4 = List[i++];
        Ayaya5 = List[i++];
        Ayaya6 = List[i++];
        Miko_1 = List[i++];
        Miko_2 = List[i++];
        Miko_3 = List[i++];
        Miko_4 = List[i++];
        Miko_5 = List[i++];
        Miko_6 = List[i++];
        Eirin1 = List[i++];
        Eirin2 = List[i++];
        Eirin3 = List[i++];
        Eirin4 = List[i++];
        Eirin5 = List[i++];
        Eirin6 = List[i++];
        Yukar1 = List[i++];
        Yukar2 = List[i++];
        Yukar3 = List[i++];
        Yukar4 = List[i++];
        Yukar5 = List[i++];
        Yukar6 = List[i++];
        Anti__1 = List[i++];
        Anti__2 = List[i++];
        Anti__3 = List[i++];
        Challe1 = List[i++];
        Challe2 = List[i++];
        Challe3 = List[i++];
        Exboss1 = List[i++];
        Exboss2 = List[i++];
        Exboss3 = List[i++];
        ExbosR1 = List[i++];
        ExbosR2 = List[i++];
        ExbosR3 = List[i++];
        Exmidb1 = List[i++];
        Exmidb2 = List[i++];
        Exmidb3 = List[i++];
        FinalB1 = List[i++];
        FinalB2 = List[i++];
        FinalB3 = List[i++];
        Heroin1 = List[i++];
        Heroin2 = List[i++];
        Heroin3 = List[i++];
        OTPart1 = List[i++];
        OTPart2 = List[i++];
        OTPart3 = List[i++];
        Partne1 = List[i++];
        Partne2 = List[i++];
        Partne3 = List[i++];
        Phanto1 = List[i++];
        Phanto2 = List[i++];
        Phanto3 = List[i++];
        Rival_1 = List[i++];
        Rival_2 = List[i++];
        Rival_3 = List[i++];
        STGBOS1 = List[i++];
        STGBOS2 = List[i++];
        STGBOS3 = List[i++];
        TPhant1 = List[i++];
        TPhant2 = List[i++];
        TPhant3 = List[i++];
        UP1___1 = List[i++];
        UP1___2 = List[i++];
        BOMB__1 = List[i++];
        BOMB__2 = List[i++];
        Caspca1 = List[i++];
        Caspca2 = List[i++];
        Focus_1 = List[i++];
        Focus_2 = List[i++];
        Graze_1 = List[i++];
        Graze_2 = List[i++];
        Grimoi1 = List[i++];
        Grimoi2 = List[i++];
        Kourin1 = List[i++];
        Kourin2 = List[i++];
        Lassho1 = List[i++];
        Lassho2 = List[i++];
        Laswor1 = List[i++];
        Laswor2 = List[i++];
        Maspla1 = List[i++];
        Maspla2 = List[i++];
        Melee_1 = List[i++];
        Melee_2 = List[i++];
        Mihakk1 = List[i++];
        Mihakk2 = List[i++];
        Party_1 = List[i++];
        Party_2 = List[i++];
        Power_1 = List[i++];
        Power_2 = List[i++];
        Sealaw1 = List[i++];
        Sealaw2 = List[i++];
        Shoot_1 = List[i++];
        Shoot_2 = List[i++];
        Sosusc1 = List[i++];
        Sosusc2 = List[i++];
        Spiatk1 = List[i++];
        Spiatk2 = List[i++];
        Stopwa1 = List[i++];
        Stopwa2 = List[i++];
        Sunabo1 = List[i++];
        Sunabo2 = List[i++];
        Tempes1 = List[i++];
        Tempes2 = List[i++];
        Voile_1 = List[i++];
        Voile_2 = List[i++];
        Borrow1 = List[i++];
        Borrow2 = List[i++];
        Crioffa1 = List[i++];
        Crioffa2 = List[i++];
        Crotohi1 = List[i++];
        Crotohi2 = List[i++];
        Endpart1 = List[i++];
        Endpart2 = List[i++];
        Eternig1 = List[i++];
        Eternig2 = List[i++];
        Fiimreq1 = List[i++];
        Fiimreq2 = List[i++];
        Grbawea1 = List[i++];
        Grbawea2 = List[i++];
        Grfawar1 = List[i++];
        Grfawar2 = List[i++];
        Overdri1 = List[i++];
        Overdri2 = List[i++];
        Reblhel1 = List[i++];
        Reblhel2 = List[i++];
        Saayblo1 = List[i++];
        Saayblo2 = List[i++];
        Scwerha1 = List[i++];
        Scwerha2 = List[i++];
        Sprsnow1 = List[i++];
        Sprsnow2 = List[i++];
        Unfaobj1 = List[i++];
        Unfaobj2 = List[i++];
        Votomak1 = List[i++];
        Votomak2 = List[i++];
        Wordesi1 = List[i++];
        Wordesi2 = List[i++];
        Lilwhit1 = List[i++];
        Lilwhit2 = List[i++];
        Yes = List[i++];
        No = List[i++];
        Confirm = List[i++];
        chslang = List[i++];
        conlang = List[i++];
        RoleCar = List[i++];
        MaDeCar = List[i++];
        InciCar = List[i++];
        CharCar = List[i++];
        NPlayer = new String[]{List[i++],List[i++],List[i++],List[i++],List[i++]};
        Heroine = List[i++];
        StageBoss = List[i++];
        ExtraBoss = List[i++];
        Partner = List[i++];
        AddLily = List[i++];
        NofRolesError = List[i++];
        CharacterChoice = List[i++];
        step1 = List[i++];
        step2 = List[i++];
        step3 = List[i++];
        step4 = List[i++];
        step5 = List[i++];
        PlayerStats = List[i++];
        infinite = List[i++];
        ViewStats = List[i++];
        EndTurn = List[i++];
        Back = List[i++];
        SandB = List[i++];
        Exit = List[i++];
        SandE = List[i++];
        language = List[i++];
        NewGame = List[i++];
        NetPlay = List[i++];
        HowToPlay = List[i++];
        CardDatabase = List[i++];
        Configuration = List[i++];

    }
    //</editor-fold>

    public void setNewLanguage(String Langu) {
        if ("Spanish".equals(Langu)) Lang = new Spanish();
        else Lang = new English();
    }

    /**
     * @param ID The Id of a card
     * @return a String List with the text of a specific card
     */
    public String[] getRoleText(int ID) {
        if (1 <= ID && ID <= 1) return new String[]{Anti__1, Anti__2, Anti__3};
        else if (2 <= ID && ID <= 2) return new String[]{Challe1, Challe2, Challe3};
        else if (3 <= ID && ID <= 3) return new String[]{Exboss1, Exboss2, Exboss3};
        else if (4 <= ID && ID <= 4) return new String[]{ExbosR1, ExbosR2, ExbosR3};
        else if (5 <= ID && ID <= 5) return new String[]{Exmidb1, Exmidb2, Exmidb3};
        else if (6 <= ID && ID <= 6) return new String[]{FinalB1, FinalB2, FinalB3};
        else if (7 <= ID && ID <= 7) return new String[]{Heroin1, Heroin2, Heroin3};
        else if (8 <= ID && ID <= 8) return new String[]{OTPart1, OTPart2, OTPart3};
        else if (9 <= ID && ID <= 10) return new String[]{Partne1, Partne2, Partne3};
        else if (11 <= ID && ID <= 11) return new String[]{Phanto1, Phanto2, Phanto3};
        else if (12 <= ID && ID <= 12) return new String[]{Rival_1, Rival_2, Rival_3};
        else if (13 <= ID && ID <= 15) return new String[]{STGBOS1, STGBOS2, STGBOS3};
        else return new String[]{TPhant1, TPhant2, TPhant3};
    }

    public String[] getDeckText(int ID) {
        if (1 <= ID && ID <= 2) return new String[]{UP1___1, UP1___2};
        else if (3 <= ID && ID <= 6) return new String[]{BOMB__1, BOMB__2};
        else if (7 == ID) return new String[]{Caspca1, Caspca2};
        else if (8 <= ID && ID <= 10) return new String[]{Focus_1, Focus_2};
        else if (11 <= ID && ID <= 22) return new String[]{Graze_1, Graze_2};
        else if (23 <= ID && ID <= 24) return new String[]{Grimoi1, Grimoi2};
        else if (25 <= ID && ID <= 26) return new String[]{Kourin1, Kourin2};
        else if (27 == ID) return new String[]{Lassho1, Lassho2};
        else if (28 == ID) return new String[]{Laswor1, Laswor2};
        else if (29 == ID) return new String[]{Maspla1, Maspla2};
        else if (30 == ID) return new String[]{Melee_1, Melee_2};
        else if (31 == ID) return new String[]{Mihakk1, Mihakk2};
        else if (32 == ID) return new String[]{Party_1, Party_2};
        else if (33 <= ID && ID <= 38) return new String[]{Power_1, Power_2};
        else if (39 <= ID && ID <= 42) return new String[]{Sealaw1, Sealaw2};
        else if (43 <= ID && ID <= 66) return new String[]{Shoot_1, Shoot_2};
        else if (67 == ID) return new String[]{Sosusc1, Sosusc2};
        else if (68 <= ID && ID <= 73) return new String[]{Spiatk1, Spiatk2};
        else if (74 == ID) return new String[]{Stopwa1, Stopwa2};
        else if (75 <= ID && ID <= 76) return new String[]{Sunabo1, Sunabo2};
        else if (77 == ID) return new String[]{Tempes1, Tempes2};
        else if (78 == ID) return new String[]{Voile_1, Voile_2};
        else return new String[]{Borrow1, Borrow2};
    }

    public String[] getCharacterText(int ID) {
        switch (ID) {
            case 1:
                return new String[]{Alice1, Alice2, Alice3, Alice4, Alice5, Alice6};
            case 2:
                return new String[]{Cirno1, Cirno2, Cirno3, Cirno4, Cirno5, Cirno6};
            case 3:
                return new String[]{Reimu1, Reimu2, Reimu3, Reimu4, Reimu5, Reimu6};
            case 4:
                return new String[]{Byaku1, Byaku2, Byaku3, Byaku4, Byaku5, Byaku6};
            case 5:
                return new String[]{Tensh1, Tensh2, Tensh3, Tensh4, Tensh5, Tensh6};
            case 6:
                return new String[]{China1, China2, China3, China4, China5, China6};
            case 7:
                return new String[]{Suika1, Suika2, Suika3, Suika4, Suika5, Suika6};
            case 8:
                return new String[]{Sakuy1, Sakuy2, Sakuy3, Sakuy4, Sakuy5, Sakuy6};
            case 9:
                return new String[]{Keine1, Keine2, Keine3, Keine4, Keine5, Keine6};
            case 10:
                return new String[]{Kappa1, Kappa2, Kappa3, Kappa4, Kappa5, Kappa6};
            case 11:
                return new String[]{Yuuka1, Yuuka2, Yuuka3, Yuuka4, Yuuka5, Yuuka6};
            case 12:
                return new String[]{Maria1, Maria2, Maria3, Maria4, Maria5, Maria6};
            case 13:
                return new String[]{Sanae1, Sanae2, Sanae3, Sanae4, Sanae5, Sanae6};
            case 14:
                return new String[]{Sator1, Sator2, Sator3, Sator4, Sator5, Sator6};
            case 15:
                return new String[]{Youmu1, Youmu2, Youmu3, Youmu4, Youmu5, Youmu6};
            case 16:
                return new String[]{Futo_1, Futo_2, Futo_3, Futo_4, Futo_5, Futo_6};
            case 17:
                return new String[]{Patch1, Patch2, Patch3, Patch4, Patch5, Patch6};
            case 18:
                return new String[]{Inaba1, Inaba2, Inaba3, Inaba4, Inaba5, Inaba6};
            case 19:
                return new String[]{Okuu_1, Okuu_2, Okuu_3, Okuu_4, Okuu_5, Okuu_6};
            case 20:
                return new String[]{Remil1, Remil2, Remil3, Remil4, Remil5, Remil6};
            case 21:
                return new String[]{Ayaya1, Ayaya2, Ayaya3, Ayaya4, Ayaya5, Ayaya6};
            case 22:
                return new String[]{Miko_1, Miko_2, Miko_3, Miko_4, Miko_5, Miko_6};
            case 23:
                return new String[]{Eirin1, Eirin2, Eirin3, Eirin4, Eirin5, Eirin6};
            default:
                return new String[]{Yukar1, Yukar2, Yukar3, Yukar4, Yukar5, Yukar6};
        }
    }

    public String[] getIncidentText(int ID) {
        switch (ID) {
            case 1:
                return new String[]{Crioffa1, Crioffa2};
            case 2:
                return new String[]{Crotohi1, Crotohi2};
            case 3:
                return new String[]{Endpart1, Endpart2};
            case 4:
                return new String[]{Eternig1, Eternig2};
            case 5:
                return new String[]{Fiimreq1, Fiimreq2};
            case 6:
                return new String[]{Grbawea1, Grbawea2};
            case 7:
                return new String[]{Grfawar1, Grfawar2};
            case 8:
                return new String[]{Overdri1, Overdri2};
            case 9:
                return new String[]{Reblhel1, Reblhel2};
            case 10:
                return new String[]{Saayblo1, Saayblo2};
            case 11:
                return new String[]{Scwerha1, Scwerha2};
            case 12:
                return new String[]{Sprsnow1, Sprsnow2};
            case 13:
                return new String[]{Unfaobj1, Unfaobj2};
            case 14:
                return new String[]{Votomak1, Votomak2};
            case 15:
                return new String[]{Wordesi1, Wordesi2};
            default:
                return new String[]{Lilwhit1, Lilwhit2};
        }
    }

    public String[] getCDBBText() {
        return new String[]{RoleCar, MaDeCar, InciCar, CharCar};
    }

}
