package Language;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Language {
    //<editor-fold defaultstate="collapsed" desc="Variable declaration">
    public Language Lang;
    public String
    Alice1,Alice2,Alice3,Alice4,Alice5,Alice6, Cirno1,Cirno2,Cirno3,Cirno4,Cirno5,Cirno6,
    Reimu1,Reimu2,Reimu3,Reimu4,Reimu5,Reimu6, Byaku1,Byaku2,Byaku3,Byaku4,Byaku5,Byaku6,
    Tensh1,Tensh2,Tensh3,Tensh4,Tensh5,Tensh6, China1,China2,China3,China4,China5,China6,
    Suika1,Suika2,Suika3,Suika4,Suika5,Suika6, Sakuy1,Sakuy2,Sakuy3,Sakuy4,Sakuy5,Sakuy6,
    Keine1,Keine2,Keine3,Keine4,Keine5,Keine6, Kappa1,Kappa2,Kappa3,Kappa4,Kappa5,Kappa6,
    Yuuka1,Yuuka2,Yuuka3,Yuuka4,Yuuka5,Yuuka6, Maria1,Maria2,Maria3,Maria4,Maria5,Maria6,
    Sanae1,Sanae2,Sanae3,Sanae4,Sanae5,Sanae6, Sator1,Sator2,Sator3,Sator4,Sator5,Sator6,
    Youmu1,Youmu2,Youmu3,Youmu4,Youmu5,Youmu6, Futo_1,Futo_2,Futo_3,Futo_4,Futo_5,Futo_6,
    Patch1,Patch2,Patch3,Patch4,Patch5,Patch6, Inaba1,Inaba2,Inaba3,Inaba4,Inaba5,Inaba6,
    Okuu_1,Okuu_2,Okuu_3,Okuu_4,Okuu_5,Okuu_6, Remil1,Remil2,Remil3,Remil4,Remil5,Remil6,
    Ayaya1,Ayaya2,Ayaya3,Ayaya4,Ayaya5,Ayaya6, Miko_1,Miko_2,Miko_3,Miko_4,Miko_5,Miko_6,
    Eirin1,Eirin2,Eirin3,Eirin4,Eirin5,Eirin6, Yukar1,Yukar2,Yukar3,Yukar4,Yukar5,Yukar6,

    Anti__1,Anti__2,Anti__3, Challe1,Challe2,Challe3, Exboss1,Exboss2,Exboss3, ExbosR1,ExbosR2,ExbosR3,
    Exmidb1,Exmidb2,Exmidb3, FinalB1,FinalB2,FinalB3, Heroin1,Heroin2,Heroin3, OTPart1,OTPart2,OTPart3,
    Partne1,Partne2,Partne3, Phanto1,Phanto2,Phanto3, Rival_1,Rival_2,Rival_3, STGBOS1,STGBOS2,STGBOS3,
    TPhant1,TPhant2,TPhant3,

    UP1___1,UP1___2, BOMB__1,BOMB__2, Caspca1,Caspca2, Focus_1,Focus_2,
    Graze_1,Graze_2, Grimoi1,Grimoi2, Kourin1,Kourin2, Lassho1,Lassho2,
    Laswor1,Laswor2, Maspla1,Maspla2, Melee_1,Melee_2, Mihakk1,Mihakk2,
    Party_1,Party_2, Power_1,Power_2, Sealaw1,Sealaw2, Shoot_1,Shoot_2,
    Sosusc1,Sosusc2, Spiatk1,Spiatk2, Stopwa1,Stopwa2, Sunabo1,Sunabo2,
    Tempes1,Tempes2, Voile_1,Voile_2, Borrow1,Borrow2,

    Crioffa1,Crioffa2, Crotohi1,Crotohi2,
    Endpart1,Endpart2, Eternig1,Eternig2,
    Fiimreq1,Fiimreq2, Grbawea1,Grbawea2,
    Grfawar1,Grfawar2, Overdri1,Overdri2,
    Reblhel1,Reblhel2, Saayblo1,Saayblo2,
    Scwerha1,Scwerha2, Sprsnow1,Sprsnow2,
    Unfaobj1,Unfaobj2, Votomak1,Votomak2,
    Wordesi1,Wordesi2, Lilwhit1,Lilwhit2,

    Yes,No,Confirm, chslang,conlang,RoleCar,MaDeCar,InciCar,CharCar,
    Heroine,StageBoss,ExtraBoss,Partner,AddLily, NofRolesError,
    CharacterChoice, step1,step2,step3,step4,step5,

    PlayerStats, infinite, ViewStats, EndTurn,
            Back, SandB, Exit, SandE,
            language;

    public String[] NPlayer;
    //</editor-fold>
    public Language(){
        String Langu;
        try{
            Langu = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/Controller/SETUP.dat"))).readLine();
        }
        catch(Exception e){
            Langu="English";
        }
        if      ("Spanish".equals(Langu))       Lang = new Spanish();
        else                                    Lang = new English();
    }
    //<editor-fold defaultstate="collapsed" desc="For Children usage ONLY">
    public  Language(String... List) {
        Alice1 = List[0];
        Alice2 = List[1];
        Alice3 = List[2];
        Alice4 = List[3];
        Alice5 = List[4];
        Alice6 = List[5];
        Cirno1 = List[6];
        Cirno2 = List[7];
        Cirno3 = List[8];
        Cirno4 = List[9];
        Cirno5 = List[10];
        Cirno6 = List[11];
        Reimu1 = List[12];
        Reimu2 = List[13];
        Reimu3 = List[14];
        Reimu4 = List[15];
        Reimu5 = List[16];
        Reimu6 = List[17];
        Byaku1 = List[18];
        Byaku2 = List[19];
        Byaku3 = List[20];
        Byaku4 = List[21];
        Byaku5 = List[22];
        Byaku6 = List[23];
        Tensh1 = List[24];
        Tensh2 = List[25];
        Tensh3 = List[26];
        Tensh4 = List[27];
        Tensh5 = List[28];
        Tensh6 = List[29];
        China1 = List[30];
        China2 = List[31];
        China3 = List[32];
        China4 = List[33];
        China5 = List[34];
        China6 = List[35];
        Suika1 = List[36];
        Suika2 = List[37];
        Suika3 = List[38];
        Suika4 = List[39];
        Suika5 = List[40];
        Suika6 = List[41];
        Sakuy1 = List[42];
        Sakuy2 = List[43];
        Sakuy3 = List[44];
        Sakuy4 = List[45];
        Sakuy5 = List[46];
        Sakuy6 = List[47];
        Keine1 = List[48];
        Keine2 = List[49];
        Keine3 = List[50];
        Keine4 = List[51];
        Keine5 = List[52];
        Keine6 = List[53];
        Kappa1 = List[54];
        Kappa2 = List[55];
        Kappa3 = List[56];
        Kappa4 = List[57];
        Kappa5 = List[58];
        Kappa6 = List[59];
        Yuuka1 = List[60];
        Yuuka2 = List[61];
        Yuuka3 = List[62];
        Yuuka4 = List[63];
        Yuuka5 = List[64];
        Yuuka6 = List[65];
        Maria1 = List[66];
        Maria2 = List[67];
        Maria3 = List[68];
        Maria4 = List[69];
        Maria5 = List[70];
        Maria6 = List[71];
        Sanae1 = List[72];
        Sanae2 = List[73];
        Sanae3 = List[74];
        Sanae4 = List[75];
        Sanae5 = List[76];
        Sanae6 = List[77];
        Sator1 = List[78];
        Sator2 = List[79];
        Sator3 = List[80];
        Sator4 = List[81];
        Sator5 = List[82];
        Sator6 = List[83];
        Youmu1 = List[84];
        Youmu2 = List[85];
        Youmu3 = List[86];
        Youmu4 = List[87];
        Youmu5 = List[88];
        Youmu6 = List[89];
        Futo_1 = List[90];
        Futo_2 = List[91];
        Futo_3 = List[92];
        Futo_4 = List[93];
        Futo_5 = List[94];
        Futo_6 = List[95];
        Patch1 = List[96];
        Patch2 = List[97];
        Patch3 = List[98];
        Patch4 = List[99];
        Patch5 = List[100];
        Patch6 = List[101];
        Inaba1 = List[102];
        Inaba2 = List[103];
        Inaba3 = List[104];
        Inaba4 = List[105];
        Inaba5 = List[106];
        Inaba6 = List[107];
        Okuu_1 = List[108];
        Okuu_2 = List[109];
        Okuu_3 = List[110];
        Okuu_4 = List[111];
        Okuu_5 = List[112];
        Okuu_6 = List[113];
        Remil1 = List[114];
        Remil2 = List[115];
        Remil3 = List[116];
        Remil4 = List[117];
        Remil5 = List[118];
        Remil6 = List[119];
        Ayaya1 = List[120];
        Ayaya2 = List[121];
        Ayaya3 = List[122];
        Ayaya4 = List[123];
        Ayaya5 = List[124];
        Ayaya6 = List[125];
        Miko_1 = List[126];
        Miko_2 = List[127];
        Miko_3 = List[128];
        Miko_4 = List[129];
        Miko_5 = List[130];
        Miko_6 = List[131];
        Eirin1 = List[132];
        Eirin2 = List[133];
        Eirin3 = List[134];
        Eirin4 = List[135];
        Eirin5 = List[136];
        Eirin6 = List[137];
        Yukar1 = List[138];
        Yukar2 = List[139];
        Yukar3 = List[140];
        Yukar4 = List[141];
        Yukar5 = List[142];
        Yukar6 = List[143];
        Anti__1 = List[144];
        Anti__2 = List[145];
        Anti__3 = List[146];
        Challe1 = List[147];
        Challe2 = List[148];
        Challe3 = List[149];
        Exboss1 = List[150];
        Exboss2 = List[151];
        Exboss3 = List[152];
        ExbosR1 = List[153];
        ExbosR2 = List[154];
        ExbosR3 = List[155];
        Exmidb1 = List[156];
        Exmidb2 = List[157];
        Exmidb3 = List[158];
        FinalB1 = List[159];
        FinalB2 = List[160];
        FinalB3 = List[161];
        Heroin1 = List[162];
        Heroin2 = List[163];
        Heroin3 = List[164];
        OTPart1 = List[165];
        OTPart2 = List[166];
        OTPart3 = List[167];
        Partne1 = List[168];
        Partne2 = List[169];
        Partne3 = List[170];
        Phanto1 = List[171];
        Phanto2 = List[172];
        Phanto3 = List[173];
        Rival_1 = List[174];
        Rival_2 = List[175];
        Rival_3 = List[176];
        STGBOS1 = List[177];
        STGBOS2 = List[178];
        STGBOS3 = List[179];
        TPhant1 = List[180];
        TPhant2 = List[181];
        TPhant3 = List[182];
        UP1___1 = List[183];
        UP1___2 = List[184];
        BOMB__1 = List[185];
        BOMB__2 = List[186];
        Caspca1 = List[187];
        Caspca2 = List[188];
        Focus_1 = List[189];
        Focus_2 = List[190];
        Graze_1 = List[191];
        Graze_2 = List[192];
        Grimoi1 = List[193];
        Grimoi2 = List[194];
        Kourin1 = List[195];
        Kourin2 = List[196];
        Lassho1 = List[197];
        Lassho2 = List[198];
        Laswor1 = List[199];
        Laswor2 = List[200];
        Maspla1 = List[201];
        Maspla2 = List[202];
        Melee_1 = List[203];
        Melee_2 = List[204];
        Mihakk1 = List[205];
        Mihakk2 = List[206];
        Party_1 = List[207];
        Party_2 = List[208];
        Power_1 = List[209];
        Power_2 = List[210];
        Sealaw1 = List[211];
        Sealaw2 = List[212];
        Shoot_1 = List[213];
        Shoot_2 = List[214];
        Sosusc1 = List[215];
        Sosusc2 = List[216];
        Spiatk1 = List[217];
        Spiatk2 = List[218];
        Stopwa1 = List[219];
        Stopwa2 = List[220];
        Sunabo1 = List[221];
        Sunabo2 = List[222];
        Tempes1 = List[223];
        Tempes2 = List[224];
        Voile_1 = List[225];
        Voile_2 = List[226];
        Borrow1 = List[227];
        Borrow2 = List[228];
        Crioffa1 = List[229];
        Crioffa2 = List[230];
        Crotohi1 = List[231];
        Crotohi2 = List[232];
        Endpart1 = List[233];
        Endpart2 = List[234];
        Eternig1 = List[235];
        Eternig2 = List[236];
        Fiimreq1 = List[237];
        Fiimreq2 = List[238];
        Grbawea1 = List[239];
        Grbawea2 = List[240];
        Grfawar1 = List[241];
        Grfawar2 = List[242];
        Overdri1 = List[243];
        Overdri2 = List[244];
        Reblhel1 = List[245];
        Reblhel2 = List[246];
        Saayblo1 = List[247];
        Saayblo2 = List[248];
        Scwerha1 = List[249];
        Scwerha2 = List[250];
        Sprsnow1 = List[251];
        Sprsnow2 = List[252];
        Unfaobj1 = List[253];
        Unfaobj2 = List[254];
        Votomak1 = List[255];
        Votomak2 = List[256];
        Wordesi1 = List[257];
        Wordesi2 = List[258];
        Lilwhit1 = List[259];
        Lilwhit2 = List[260];
        Yes = List[261];
        No = List[262];
        Confirm = List[263];
        chslang = List[264];
        conlang = List[265];
        RoleCar = List[266];
        MaDeCar = List[267];
        InciCar = List[268];
        CharCar = List[269];
        NPlayer = new String[]{List[270],List[271],List[272],List[273],List[274]};
        Heroine = List[275];
        StageBoss = List[276];
        ExtraBoss = List[277];
        Partner = List[278];
        AddLily = List[279];
        NofRolesError = List[280];
        CharacterChoice = List[281];
        step1 = List[282];
        step2 = List[283];
        step3 = List[284];
        step4 = List[285];
        step5 = List[286];
        PlayerStats = List[287];
        infinite = List[288];
        ViewStats = List[289];
        EndTurn = List[290];
        Back = List[291];
        SandB = List[292];
        Exit = List[293];
        SandE = List[294];
        language = List[295];
    }
    //</editor-fold>

    public void setNewLanguage(String Langu){
        if      ("Spanish".equals(Langu))       Lang = new Spanish();
        else                                    Lang = new English();
    }
    /**
     * @param ID The Id of a card
     * @return a String List with the text of a specific card
     */
    public String[] getRoleText(int ID){
        if (1 <=ID && ID<=1)   return new String[] {Anti__1,Anti__2,Anti__3};
        else if (2 <=ID && ID<=2)   return new String[] {Challe1,Challe2,Challe3};
        else if (3 <=ID && ID<=3)   return new String[] {Exboss1,Exboss2,Exboss3};
        else if (4 <=ID && ID<=4)   return new String[] {ExbosR1,ExbosR2,ExbosR3};
        else if (5 <=ID && ID<=5)   return new String[] {Exmidb1,Exmidb2,Exmidb3};
        else if (6 <=ID && ID<=6)   return new String[] {FinalB1,FinalB2,FinalB3};
        else if (7 <=ID && ID<=7)   return new String[] {Heroin1,Heroin2,Heroin3};
        else if (8 <=ID && ID<=8)   return new String[] {OTPart1,OTPart2,OTPart3};
        else if (9 <=ID && ID<=10)  return new String[] {Partne1,Partne2,Partne3};
        else if (11 <=ID && ID<=11) return new String[] {Phanto1,Phanto2,Phanto3};
        else if (12 <=ID && ID<=12) return new String[] {Rival_1,Rival_2,Rival_3};
        else if (13 <=ID && ID<=15) return new String[] {STGBOS1,STGBOS2,STGBOS3};
        else                        return new String[] {TPhant1,TPhant2,TPhant3};
    }
    public String[] getDeckText(int ID){
             if ( 1 <= ID && ID <=  2) return new String[] {UP1___1,UP1___2};
        else if ( 3 <= ID && ID <=  6) return new String[] {BOMB__1,BOMB__2};
        else if (       7 == ID      ) return new String[] {Caspca1,Caspca2};
        else if ( 8 <= ID && ID <= 10) return new String[] {Focus_1,Focus_2};
        else if (11 <= ID && ID <= 22) return new String[] {Graze_1,Graze_2};
        else if (23 <= ID && ID <= 24) return new String[] {Grimoi1,Grimoi2};
        else if (25 <= ID && ID <= 26) return new String[] {Kourin1,Kourin2};
        else if (      27 == ID      ) return new String[] {Lassho1,Lassho2};
        else if (      28 == ID      ) return new String[] {Laswor1,Laswor2};
        else if (      29 == ID      ) return new String[] {Maspla1,Maspla2};
        else if (      30 == ID      ) return new String[] {Melee_1,Melee_2};
        else if (      31 == ID      ) return new String[] {Mihakk1,Mihakk2};
        else if (      32 == ID      ) return new String[] {Party_1,Party_2};
        else if (33 <= ID && ID <= 38) return new String[] {Power_1,Power_2};
        else if (39 <= ID && ID <= 42) return new String[] {Sealaw1,Sealaw2};
        else if (43 <= ID && ID <= 66) return new String[] {Shoot_1,Shoot_2};
        else if (      67 == ID      ) return new String[] {Sosusc1,Sosusc2};
        else if (68 <= ID && ID <= 73) return new String[] {Spiatk1,Spiatk2};
        else if (      74 == ID      ) return new String[] {Stopwa1,Stopwa2};
        else if (75 <= ID && ID <= 76) return new String[] {Sunabo1,Sunabo2};
        else if (      77 == ID      ) return new String[] {Tempes1,Tempes2};
        else if (      78 == ID      ) return new String[] {Voile_1,Voile_2};
        else                           return new String[] {Borrow1,Borrow2};
    }
    public String[] getCharacterText(int ID){
        switch (ID){
            case 1 : return new String[]{Alice1,Alice2,Alice3,Alice4,Alice5,Alice6};
            case 2 : return new String[]{Cirno1,Cirno2,Cirno3,Cirno4,Cirno5,Cirno6};
            case 3 : return new String[]{Reimu1,Reimu2,Reimu3,Reimu4,Reimu5,Reimu6};
            case 4 : return new String[]{Byaku1,Byaku2,Byaku3,Byaku4,Byaku5,Byaku6};
            case 5 : return new String[]{Tensh1,Tensh2,Tensh3,Tensh4,Tensh5,Tensh6};
            case 6 : return new String[]{China1,China2,China3,China4,China5,China6};
            case 7 : return new String[]{Suika1,Suika2,Suika3,Suika4,Suika5,Suika6};
            case 8 : return new String[]{Sakuy1,Sakuy2,Sakuy3,Sakuy4,Sakuy5,Sakuy6};
            case 9 : return new String[]{Keine1,Keine2,Keine3,Keine4,Keine5,Keine6};
            case 10 : return new String[]{Kappa1,Kappa2,Kappa3,Kappa4,Kappa5,Kappa6};
            case 11 : return new String[]{Yuuka1,Yuuka2,Yuuka3,Yuuka4,Yuuka5,Yuuka6};
            case 12 : return new String[]{Maria1,Maria2,Maria3,Maria4,Maria5,Maria6};
            case 13 : return new String[]{Sanae1,Sanae2,Sanae3,Sanae4,Sanae5,Sanae6};
            case 14 : return new String[]{Sator1,Sator2,Sator3,Sator4,Sator5,Sator6};
            case 15 : return new String[]{Youmu1,Youmu2,Youmu3,Youmu4,Youmu5,Youmu6};
            case 16 : return new String[]{Futo_1,Futo_2,Futo_3,Futo_4,Futo_5,Futo_6};
            case 17 : return new String[]{Patch1,Patch2,Patch3,Patch4,Patch5,Patch6};
            case 18 : return new String[]{Inaba1,Inaba2,Inaba3,Inaba4,Inaba5,Inaba6};
            case 19 : return new String[]{Okuu_1,Okuu_2,Okuu_3,Okuu_4,Okuu_5,Okuu_6};
            case 20 : return new String[]{Remil1,Remil2,Remil3,Remil4,Remil5,Remil6};
            case 21 : return new String[]{Ayaya1,Ayaya2,Ayaya3,Ayaya4,Ayaya5,Ayaya6};
            case 22 : return new String[]{Miko_1,Miko_2,Miko_3,Miko_4,Miko_5,Miko_6};
            case 23 : return new String[]{Eirin1,Eirin2,Eirin3,Eirin4,Eirin5,Eirin6};
            default : return new String[]{Yukar1,Yukar2,Yukar3,Yukar4,Yukar5,Yukar6};
        }
    }
    public String[] getIncidentText(int ID){
        switch (ID){
            case 1  : return new String[] {Crioffa1, Crioffa2 };
            case 2  : return new String[] {Crotohi1, Crotohi2 };
            case 3  : return new String[] {Endpart1, Endpart2 };
            case 4  : return new String[] {Eternig1, Eternig2 };
            case 5  : return new String[] {Fiimreq1, Fiimreq2 };
            case 6  : return new String[] {Grbawea1, Grbawea2 };
            case 7  : return new String[] {Grfawar1, Grfawar2 };
            case 8  : return new String[] {Overdri1, Overdri2 };
            case 9  : return new String[] {Reblhel1, Reblhel2 };
            case 10 : return new String[] {Saayblo1, Saayblo2 };
            case 11 : return new String[] {Scwerha1, Scwerha2 };
            case 12 : return new String[] {Sprsnow1, Sprsnow2 };
            case 13 : return new String[] {Unfaobj1, Unfaobj2 };
            case 14 : return new String[] {Votomak1, Votomak2 };
            case 15 : return new String[] {Wordesi1, Wordesi2 };
            default : return new String[] {Lilwhit1, Lilwhit2 };
        }
    }
    public String[] getCDBBText(){
        return new String[] {RoleCar,MaDeCar,InciCar,CharCar};
    }

}
