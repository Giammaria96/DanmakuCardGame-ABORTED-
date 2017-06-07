package Language;

public class English extends Language{

//<editor-fold defaultstate="collapsed" desc="Text">
    //Note for translators
    // \n is use for make a newline
    // please be carefull with it
    //
    // #    = Action        Symbol
    // $    = Danmaku       Symbol
    // %    = Spellcard     Symbol
    // &    = Powerup       Symbol
    // [    = Autumn        Symbol
    // \\   = Summer        Symbol
    // ]    = Spring        Symbol
    // ^    = Winter        Symbol
    // {    = Healing       Symbol
    // |    = Item          Symbol
    // }    = Artifact      Symbol
    // ~    = Defense       Symbol
    // ¬    = Invocation    Symbol
    // @    = Reaction      Symbol
    // >    = Dodge         Symbol
    //
    //==========================================
    //================CHARACTERS================
    //==========================================
    //
private static final String
            Alice1 = "Seven-Colored Puppeteer",
            Alice2 = "ALICE MARGATROID",
            Alice3 = "Alice does not need to discard\n&Powerup cards when she loses life.\n\nDuring her turn, Alice may discard an\n|Item card from play to activate her\n%Spellcard. You can only activate one\n%Spellcard per round.",
            Alice4 = "War Sign",
            Alice5 = "\"Doll's War\"",
            Alice6 = "Reveal cards from the top of the deck\nuntil you reveal an |Item card, then\nput that card into play. Pull all other\ncards revealed this way into the\ndiscard pile.\n\nYou may attack a player in range.",
            Cirno1 = "Fairy of the Ice",
            Cirno2 = "CIRNO",
            Cirno3 = "Cirno has +2 Range.\n\nCirno cannot attack players at a \ndistance of 1 if there are two or more\nother players. She may still attack a\nplayer by going around the circle.",
            Cirno4 = "Freeze Sign",
            Cirno5 = "\"Perfect Freeze\"",
            Cirno6 = "Attack a player in range. They must\nskip their next turn.\n\nPlayers cannot skip two turns in a row,\nbut you may still target them.",
            Reimu1 = "Shrine Maiden of Paradise",
            Reimu2 = "HAKUREI REIMU",
            Reimu3 = "Players must discard an additional\ncard in order to play a >Dodge card\nagainst Reimu's attacks.",
            Reimu4 = "Spirit Sign",
            Reimu5 = "\"Fantasy Seal\"",
            Reimu6 = "Choose $Danmaku, >Dodge,\n¬Invocation, or |Item cards.\nUntil your next turn, players may not\n play cards of the chosen type.\n\nYou may attack a player in range.",
            Byaku1 = "The Sealed Great Magician",
            Byaku2 = "HIJIRI BYAKUREN",
            Byaku3 = "Whenever another player attacks,\nByakuren may discard a $Danmaku\ncard. If she does, she attacks the\nattacker, regardless of range.",
            Byaku4 = "Super Human",
            Byaku5 = "\"Hijiri Buakuren\"",
            Byaku6 = "You gain +5 Range and +5 Distance\nuntil your next turn.\n\nYou may attack a player in range.",
            Tensh1 = "Young Mistress of Bhavagra",
            Tensh2 = "HINANAWI TENSHI",
            Tensh3 = "Tenshi may draw an additional card\neach time she loses life.",
            Tensh4 = "Swordplay",
            Tensh5 = "\"Sword of Swagger\"",
            Tensh6 = "Gain 1 life. You cannot go above your max\nlife.\n\nChoose another player, regardless of range.\nStarting with that player, take turns\ndiscarding $Danmaku cards until one\nplayer passes. The player who passes loses 1\nlife. This does not count as an attack.",
            China1 = "Colorful Rainbow Gatekeeper",
            China2 = "HONG MEILING",
            China3 = "During other players' turns, Meiling's\n max hand size is 7.\n\nMeilig may choose to skip her turn.\nWhen Meiling skips her turn, she may\ndraw four cards. You cannot skip two\nturns in a row.",
            China4 = "Colorful Sign",
            China5 = "\"Extreme Color Typhoon\"",
            China6 = "Activate this when another player\nattacks.\n\nDraw two cards.\n\nAttack the attacker, regargless of\nrange.",
            Suika1 = "Free-Spirited Oni",
            Suika2 = "IBUKI SUIKA",
            Suika3 = "Suika has +1 Range.\n\nSuika can play one additional\n$Danmaku cards per round.",
            Suika4 = "Mist Sign",
            Suika5 = "\"Gathering and Dissipating\"",
            Suika6 = "Choose a number from 1 to 5. Until\nyour next turn, all players use that\n number as the distance to each other,\nignoring other modifiers.\n\nYou may attack a player in range.",
            Sakuy1 = "Perfect and Elegant Maid",
            Sakuy2 = "IZAYOI SAKUYA",
            Sakuy3 = "Sakuya can play two additional\n$Danmaku cards per round.",
            Sakuy4 = "Illusion World",
            Sakuy5 = "\"The World\"",
            Sakuy6 = "Activate this when any player is\nattacked.\n\nThat player avoids the attack. Attack\nthe attacker, regardless of range.\n\nThe current turn ends inmediately.",
            Keine1 = "History-Eating Half Beast",
            Keine2 = "KAMISHIRASAWA KEINE",
            Keine3 = "During Keine's draw step, she draws\nand additional card, then puts any\ncard from her hand on the top or the\nbottom of the deck.",
            Keine4 = "Ending Sign",
            Keine5 = "\"Phantasmal Emperor\"",
            Keine6 = "Activate this when another player\nplays an #Action card.\n\nCancel that card.\n\nYou may attack a player in range.",
            Kappa1 = "Aquatic Engineer",
            Kappa2 = "KAWASHIRO NITORI",
            Kappa3 = "Nitori has +1 Distance.\n\nOn her turn, Nitori may discard an\n|Item card to draw a card.",
            Kappa4 = "Water Sign",
            Kappa5 = "\"Kappa's Flash Flood\"",
            Kappa6 = "Choose a player. Until your next\n turn, their |Item cards have no\neffect.\n\nYou may attack that player if they are\nin range.",
            Yuuka1 = "Flower Master of the Four Seasons",
            Yuuka2 = "KAZAMI YUUKA",
            Yuuka3 = "When Yuuka damages another\nplayer, she may draw a card.",
            Yuuka4 = "Flower Sign",
            Yuuka5 = "\"The Reflowering of Gensokyo\"",
            Yuuka6 = "Attack all other players.",
            Maria1 = "Ordinary Magician",
            Maria2 = "KIRISAME MARISA",
            Maria3 = "During her draw step, Marisa may\nchoose to draw one less card. If she\ndoes, she may gain control of any\n|Item card in play.",
            Maria4 = "Love Sign",
            Maria5 = "\"Master Spark\"",
            Maria6 = "Attack a player in range.\nThis attack deals 1 damage, plus\n1 damage for each &Powerup card\nyou have in play.",
            Sanae1 = "Newbie Goddess of the Mountain",
            Sanae2 = "KOCHIYA SANAE",
            Sanae3 = "When Sanae plays a $Danmaku card,\nshe may look at the top card of the deck.\n\nIf she does, she may place that card\nback on the top of the deck, into the\ndiscard pile, or into another player's\nhand.",
            Sanae4 = "Miracle",
            Sanae5 = "\"Miracle Fruit\"",
            Sanae6 = "Choose a player in range. That player\nmust reveal their hand.\n\nAttack that player once, then attack\nthem once for each $Danmaku card\nrevealed this way beyond the first.",
            Sator1 = "The Girl Even the Evil Spirits Fear",
            Sator2 = "KOMEIJI SATORI",
            Sator3 = "When Satori is attacked, she may flip\nthe top card of the deck. If that card\nis a ^Winter, she avoids the attack.\n\nSatori may look at any player's hand\nonce per round.",
            Sator4 = "Recollection",
            Sator5 = "\"Terrifying Hypnotism\"",
            Sator6 = "Choose another player's character\nand activate their %Spell Card as if it\nwere your own. You may choose a\ndefeated player's character.",
            Youmu1 = "Half-Human Half-Phantom Gardener",
            Youmu2 = "KONPAKU YOUMU",
            Youmu3 = "When Youmu plays a $Danmaku\ncard, she may attack an additional\ndifferent player in range.",
            Youmu4 = "Hell Realm Sword",
            Youmu5 = "\"200 Yojana in One Slash\"",
            Youmu6 = "Until your next turn, all players are\nconsidered in range for you.\n\nAttack a player. Youmay also attack\nan additional different player.",
            Futo_1 = "Shikaisen from Acient Japan",
            Futo_2 = "MONONOBE NO FUTO",
            Futo_3 = "Futo does not need to discard\n&Powerup cards when she loses life.\n\nFuto may discard an |Item card in\nplay to avoid an attack.",
            Futo_4 = "Saint Girl",
            Futo_5 = "\"Oomonoimi's Dinner\"",
            Futo_6 = "You may choose two other players\nand force them to swap hands.\n\nYou may attack a player in range.",
            Patch1 = "The Unmoving Great Library",
            Patch2 = "PATCHOULI KNOWLEDGE",
            Patch3 = "Patchouli's max hand size 7.\n\nPatchouli starts the game with seven\ncards in her hand.",
            Patch4 = "Fire Water Wood Metal Earth Sign",
            Patch5 = "\"Philosopher's Stone\"",
            Patch6 = "Draw 2 cards.\n\nYou may attack a player in range.",
            Inaba1 = "Lunatic Moon Rabbit",
            Inaba2 = "REISEN UDONGEIN INABA",
            Inaba3 = "When a player avoid one of Reisen's\nattacks, Reisen may attack another,\ndifferent player in range.\n\nUse this ability only once per card\nplayed.",
            Inaba4 = "Pale Moon Illusion",
            Inaba5 = "\"Lunatic Red Eyes\"",
            Inaba6 = "Activate this when another player\nplays a $Danmaku card o activates\na %Spell Card.\n\nCancel that card. You may copy that\ncard with new targets.",
            Okuu_1 = "Scorching, Troublesome Divine Flame",
            Okuu_2 = "REIUJI UTSUHO",
            Okuu_3 = "During her turn; Utsuho may discard\ntwo cards to activate her %Spell\nCard.\n\nYou can only activate one %Spell\nCard per round.",
            Okuu_4 = "Atomic Fire",
            Okuu_5 = "\"Nuclear Excursion\"",
            Okuu_6 = "Choose a player in range.Attack that\nplayer three times.\n\nYou lose 1 life",
            Remil1 = "The Scarlet Devil",
            Remil2 = "REMILIA SCARLET",
            Remil3 = "When Remilia avoids an attack, she\nmay draw a card.",
            Remil4 = "Divine Spear",
            Remil5 = "\"Spear the Gungnir\"",
            Remil6 = "Attack a player regardless of range.\n\nThis cannot be canceled or avoidad.",
            Ayaya1 = "Traditional Reporter of Fantasy",
            Ayaya2 = "SHAMEIMARU AYA",
            Ayaya3 = "Aya may discard a $Danmaku card\nto cancel any $Danmaku card as it\nis being played.",
            Ayaya4 = "Whirlwind",
            Ayaya5 = "\"Wind God Girl\"",
            Ayaya6 = "Reveal the top five cards of the deck.\nPlace any $Danmaku cards revealed\nthis way into your hand and the rest\ninto the discard pile.\n\nYou may attack a player in range.",
            Miko_1 = "Shoutoku Taoist",
            Miko_2 = "TOYOSATOMIMI NO MIKO",
            Miko_3 = "During her turn, Miko may give another\nplayer any number of cards from her hand.\n\nWhenever Miko's hand is empty, she may\ninmediately activate her %Spell Card.\nYou can only activate one %Spell Card per\nround.",
            Miko_4 = "Secret Treasure",
            Miko_5 = "\"Armillary Sphere of Ikaruga-dera\"",
            Miko_6 = "Choose a player. That player must\ndiscard their hand and draw three\ncards.\n\nYou may attack a player in range.",
            Eirin1 = "Brain of the Moon",
            Eirin2 = "YAKOGORO EIRIN",
            Eirin3 = "Eirin may play @Reaction and\n|Item cards on behalf of other\nplayers.",
            Eirin4 = "Forbidden Arcanum",
            Eirin5 = "\"Hourai Elixir\"",
            Eirin6 = "Gain 1 life. You may have another\nplayer of your choice gain 1 life. You\ncannot go above your max life.\n\nYou may attack a player in range.",
            Yukar1 = "Youkai of Boundaries",
            Yukar2 = "YAKUMO YUKARI",
            Yukar3 = "When Yukari avoids an attack, she\nmay attack a player in range.",
            Yukar4 = "Evil Spirits",
            Yukar5 = "\"Yakumo Yukari's Spiriting Away\"",
            Yukar6 = "Choose any player. You may look at\ntheir hand, then take a card of your\nchoice from it, or take an |Item that\nplayer has in play.\n\nYou may attack that player if they are\n in range.",
            //
            //==========================================
            //===================ROLE===================
            //==========================================
            //
            Anti__1 = "STAGE BOSS",
            Anti__2 = "ANTI-HEROINE",
            Anti__3 = "Goal: Defeat the Heroine after at least\none other Stage Boss has been defeated.",
            Challe1 = "STAGE BOSS",
            Challe2 = "CHALLENGER",
            Challe3 = "\nGoal: Defeat the Heroine after the Extra\nBoss has been defeated.",
            Exboss1 = "EXTRA BOSS",
            Exboss2 = "EX BOSS",
            Exboss3 = "\nGoal: Defeat all Stage Bosses, then defeat\nthe Heroine.\n\nTrue Form: Any time during your turn, if\nat least one other player has been\ndefeated, you may reveal this role. If you\ndo, replace it with the EX Boss Revealed\nrole card and gain 1 life.",
            ExbosR1 = "EXTRA BOSS",
            ExbosR2 = "EX BOSS REVEALED",
            ExbosR3 = "\nGoal: Defeat all Stage Bosses, then defeat\nthe Heroine.\n\nFinal Form: You have +1 max life and\n+1 max hand size. Draw an extra card\n during your draw step.",
            Exmidb1 = "PARTNER / EXTRA BOSS",
            Exmidb2 = "EX MIDBOSS",
            Exmidb3 = "\nGoal: Defeat all Stage Bosses, then defeat the\nHeroine.\n\nSpecial: If the Extra Boss is defeated,\nreveal this card. You count as both an\nExtra Boss and a Partner for other\nplayers’ goals.",
            FinalB1 = "STAGE BOSS",
            FinalB2 = "FINAL BOSS",
            FinalB3 = "\nGoal: Defeat the Heroine after at least\none Partner has been defeated.",
            Heroin1 = "",
            Heroin2 = "HEROINE",
            Heroin3 = "\nStart with this role revealed.\n\nGoal: Defeat all Stage Bosses and Extra\nBosses.\n\nPlot Armor: You have +1 max life and\n+1 max hand size.",
            OTPart1 = "PARTNER",
            OTPart2 = "ONE TRUE PARTNER",
            OTPart3 = "\nGoal: Defeat all other Partners, Stage\nBosses and the Extra Boss. Protect the\nHeroine.\n\nShared Fate: When you are defeated, the\nHeroine must discard all |Item cards in\nplay, then choose up to two cards in her\nhand and discard the rest.",
            Partne1 = "",
            Partne2 = "PARTNER",
            Partne3 = "\nGoal: Defeat all Stage Bosses and the\nExtra Boss. Protect the Heroine.\n\nShared Fate: When you are defeated, the\nHeroine must discard all |Item cards in\nplay, then choose up to two cards in her\nhand and discard the rest.",
            Phanto1 = "EXTRA BOSS",
            Phanto2 = "PHANTOM BOSS",
            Phanto3 = "\nGoal: Defeat all Stage Bosses, then defeat\nthe Heroine.\n\nSinister Plan: At any time, if at least one\nother player has been defeated, you may\nreveal this role. If you do, replace it with\nthe True Phantom Boss role card and\ngain 1 life.",
            Rival_1 = "",
            Rival_2 = "RIVAL",
            Rival_3 = "\nGoal: Defeat the Heroine, then defeat all\nStage Bosses and Extra Bosses.\n\nSpecial: The game does not end the first\ntime the Heroine is defeated. When the\nHeroine is defeated, reveal this role, take\nHeroine role card, and gain 1 life.",
            STGBOS1 = "",
            STGBOS2 = "STAGE BOSS",
            STGBOS3 = "\nGoal: Defeat the Heroine.",
            TPhant1 = "EXTRA BOSS",
            TPhant2 = "TRUE PHANTOM BOSS",
            TPhant3 = "Goal: Defeat all Stage Bosses, then defeat\nthe Heroine.\n\nMastermind: You have +1 max life.\nAt the start of your turn you may resolve\nthe current incident. If you do, search the\nIncident deck for a card, shuffle it, then put\nthe chosen card on top of it.",
            //
            //==========================================
            //===================DECK===================
            //==========================================
            //
            UP1___1 = "1UP",
            UP1___2 = "Choose a player. That player gains 1\nlife. You cannot go above your max life.\n\n\n\n\nPlay this when any player is reduced to\n0 life.\nThat player returns to 1 life.",
            BOMB__1 = "BOMB",
            BOMB__2 = "Activate your %Spell Card.\n\nYou can only activate one %Spell Card\nper round.\n\n\nPlay this when another player plays \na $Danmaku card or activates their %Spell Card. \n\nCancel that card.",
            Caspca1 = "CAPTURE SPELL CARD",
            Caspca2 = "Choose another player and activate\ntheir character’s %Spell Card as if it were your\nown. You may choose a defeated player’s\ncharacter.\n\nYou can only activate one %Spell Card\nper round.",
            Focus_1 = "FOCUS",
            Focus_2 = "You have +2 Distance.\n\nYou can only activate one ~Defense card\nin play at a time.",
            Graze_1 = "GRAZE",
            Graze_2 = "Play this when you are attacked.\n\nYou avoid the attack.\n\nYou may discard a $Danmaku card to\nplay this on behalf of another player.",
            Grimoi1 = "GRIMOIRE",
            Grimoi2 = "Draw 2 cards.",
            Kourin1 = "KOURINDOU",
            Kourin2 = "As you play this card, you may discard\nany number of cards from your hand.\nDraw cards equal to the number of\ncards discarded this way plus one.",
            Lassho1 = "LASER SHOOT",
            Lassho2 = "Attack a player, regardless of range.\nThis attack cannot be avoided.\n\nBy default you can only play one\n$Danmaku card per round.",
            Laswor1 = "LAST WORLD",
            Laswor2 = "Attack all other players, regardless of\nrange.\n\nBy default you can only play one\n$Danmaku card per round.",
            Maspla1 = "MASTER PLAN",
            Maspla2 = "Resolve the current incident.\n\nThen, look at the top three cards of any\ndeck and place them on the top or\nbottom of that deck in any order.",
            Melee_1 = "MELEE",
            Melee_2 = "Attack a player, regardless of range.\n\nThis does not count against your\n$Danmaku card limit.\n\nThat player may then discard a\n$Danmaku card to copy this effect.",
            Mihakk1 = "MINI-HAKKERO",
            Mihakk2 = "You have +3 range.\n\nYou may discard two cards to activate\nyour %Spell Card.\n\nYou can only activate one %Spell Card\nper round. You can only have one\n}Artifact card in play at a time.",
            Party_1 = "PARTY",
            Party_2 = "Draw a card for each active player.\n\nThen, for each active player, choose\none card drawn this way and place it in\ntheir hand.\n\nThen draw a card.",
            Power_1 = "POWER",
            Power_2 = "You have +1 Range.\n\nYou can play one additional\n$Danmaku card each round.\n\nDiscard one &Powerup card whenever you\nlose life to an attack.",
            Sealaw1 = "SEAL AWAY",
            Sealaw2 = "Choose a player. You may force that\nplayer to discard an |Item card of\nyour choice that player controls.\n\nThen, attack that player if they are in\n range.\n\nBy default you can only play one $Danmaku\ncard per round.",
            Shoot_1 = "SHOOT!",
            Shoot_2 = "Attack a player in range.\n\nYou may discard $Danmaku cards to\ngive this attack +1 Range for each card\ndiscarded.\n\nBy default you can only play one\n$Danmaku card per round.",
            Sosusc1 = "SORCERER'S SUTRA SCROLL",
            Sosusc2 = "When you play this card, draw a card.\n\nDraw an extra card during your draw\nstep. Your max hand size is 7.\n\nYou can only have one }Artifact card\nin play at a time.",
            Spiatk1 = "SPIRITUAL ATTACK",
            Spiatk2 = "Activate your %Spell Card.\n\nYou can only activate one %Spell Card\nper round.",
            Stopwa1 = "STOPWATCH",
            Stopwa2 = "You have +1 Distance.\n\nYou can play two additional\n$Danmaku cards each round.\n\nYou can only have one }Artifact card\nin play at a time.",
            Sunabo1 = "SUPERNATURAL BORDER",
            Sunabo2 = "When you are attacked, flip the top\ncard of the deck. If it is a ]Spring or\n\\Summer card, you avoid that attack.\n\nYou can only have one ~Defense card\nin play at a time. Discard one &Powerup\ncard whenever you lose life to an attack.",
            Tempes1 = "TEMPEST",
            Tempes2 = "All players discard their hand and draw\nthree cards.",
            Voile_1 = "VOILE",
            Voile_2 = "Draw three cards, then place a card\nfrom your hand on top of the deck.",
            Borrow1 = "\"BORROW\"",
            Borrow2 = "Choose any |Item in play.\n\nYou gain control of that |Item.",
            //
            //==========================================
            //=================INCIDENT=================
            //==========================================
            //
            Crioffa1 = "CRISIS OF FAITH",
            Crioffa2 = "When this incident enters play, each\nplayer except the Heroine flips the top\ncard of the deck until someone flips an\ncard of the deck until someone flips an\n[Autumn.\n\nThat player permanently swaps getRoleText\ncards with the Heroine and gains 1 life.\n\nThen, resolve this incident.",
            Crotohi1 = "CROSSING TO HIGAN",
            Crotohi2 = "All players are considered in range,\nregardless of distance.\n\nResolution: A player is defeated.",
            Endpart1 = "ENDLESS PARTY",
            Endpart2 = "During your incident step, each player\ndraws one card.\n\nYou still take your draw step.\n\nResolution: The deck is reshuffled.",
            Eternig1 = "ETERNAL NIGHT",
            Eternig2 = "Players may play any number of\n$Danmaku cards each turn.\n\nCollect the top card of the deck during\nyour incident step.\n\nCollect any $Danmaku cards.\n\nResolution: Collect 12 cards.",
            Fiimreq1 = "FIVE IMPOSSIBLE REQUESTS",
            Fiimreq2 = "During your incident step, discard your\nhand and draw that many cards.\n\nYou still take your draw step.\n\nResolution: Collect 1 }Artifact card.",
            Grbawea1 = "GREAT BARRIER WEAKENING",
            Grbawea2 = "Draw your first card each turn from the\ndiscard pile. If the discard pile is empty,\ndraw from the deck instead.\n\nCards must be placed on the discard pile in\nthe order they are played.\n\nResolution: Collect 3 ¬Invocation cards.",
            Grfawar1 = "GREAT FAIRY WARS",
            Grfawar2 = "When this incident enters play, all other\nplayers must discard a $Danmaku card\nor lose 1 life.\n\nDuring your incident step, discard a\n$Danmaku card or lose 1 life.\n\nResolution: Collect 9 $Danmaku\ncards.",
            Overdri1 = "OVERDRIVE",
            Overdri2 = "You may pay 1 life to activate your\n%Spell Card.\n\nYou can only activate one %Spell Card per\nround.\n\nResolution: Collect 6 >Dodge cards.",
            Reblhel1 = "REKINDLE BLAZING HELL",
            Reblhel2 = "When this incident enters play, all players\ndraw up to their max hand size.\n\nDuring your incident step, draw up to your\nmax hand size.\n\nYou still take your draw step.\n\nResolution: Collect 6 \\Summer cards.",
            Saayblo1 = "SAIGYOU AYAKASHI BLOOMING",
            Saayblo2 = "Lose 1 life during your incident step.\n\nThis is not an attack.\n\nResolution: Collect 6 ^Winter cards.",
            Scwerha1 = "SCARLET WEATHER RHAPSODY",
            Scwerha2 = "During your incident step, flip the top card of the deck\nand perform an Action according to its season.\n\n]Spring: Swap hands with the player on your right.\n\n\\Summer: Draw one card.\n\n[Autumn: Swap hands with the player on your left.\n\n^Winter: Discard 1 card at random from your hand.\n\nResolution: Collect 2 cards of each season.",
            Sprsnow1 = "SPRING SNOW",
            Sprsnow2 = "Players cannot activate %Spell Cards.\n\nResolution: Collect 6 ]Spring cards.",
            Unfaobj1 = "UNDEFINED FANTASTIC OBJECT",
            Unfaobj2 = "During your incident step, reveal the top\n3 cards of the deck. You may choose a\n&Powerup, ¬Invocation, or {Healing\ncard from among these and add it to your\nhand.\n\nCollect all other cards revealed this way.\n\nResolution: Collect 12 cards.",
            Votomak1 = "VOYAGE TO MAKAI",
            Votomak2 = "Players cannot gain life. Players cannot be\nreturned to life.\n\nResolution: Collect 6 [Autumn cards.",
            Wordesi1 = "WORDLY DESIRE",
            Wordesi2 = "When this incident enters play, all players\ndiscard all |Item cards in play.\n\nIf a player would put an |Item card into\nplay, they discard it instead.\n\nResolution: Collect 4 |Item cards.",
            Lilwhit1 = "LILY WHITE",
            Lilwhit2 = "During your incident step, flip the top\ncard of the deck.\n\nIf it is a \\Summer, resolve this incident.\n\nIf it is a ]Spring, you lose 3 life.\n\nThis is not an attack.",
            //
            //==========================================
            //==================SYSTEM==================
            //==========================================
            //
            Yes = "YES",
            No  = "NO",
            Confirm = "Confirm",
            chslang = "Choose your language",
            conlang = "Set language to : ",
            RoleCar = "Role Cards",
            MaDeCar = "Main Deck Cards",
            InciCar = "Incident Cards",
            CharCar = "Character Cards",
            Heroine = "Heroines",
            StageBoss = "Stage Bosses",
            ExtraBoss = "Extra Bosses",
            Partner = "Partners",
            AddLily = "Add to the Incident Deck",
            NofRolesError = "You must select more roles",
            CharacterChoice = "Are you sure to choose this character card?",
            step1 = "Start of Turn",
            step2 = "Incident Step",
            step3 = "Draw Step",
            step4 = "Main Step",
            step5 = "Discard Step",
            PlayerStats =
                    "{Life                           : %s %n" +
                            "Range                          : %s %n" +
                            "Distance bonus             : %s %n" +
                            "Remaining $Danmaku: %s %n" +
                            "%%Spellcart Avaible       : %s %n" +
                            "Max Hand                     : %s",
            infinite = "Infinite",
            ViewStats = "View Stats",
            EndTurn = "End Turn",
            Back = "Back",
            SandB = "Save and Back",
            Exit = "Exit",
            SandE = "Save and Exit",
            language = "Language";

    protected static final String[] NPlayer = new String[]{"4 Players","5 Players","6Players","7 Players","8 Players"};


    //</editor-fold>

    public English(){
        super(Alice1,Alice2,Alice3,Alice4,Alice5,Alice6,Cirno1,Cirno2,Cirno3,Cirno4,Cirno5,Cirno6,Reimu1,Reimu2,Reimu3,Reimu4,Reimu5,Reimu6,Byaku1,Byaku2,Byaku3,Byaku4,Byaku5,Byaku6,Tensh1,Tensh2,Tensh3,Tensh4,Tensh5,Tensh6,China1,China2,China3,China4,China5,China6,Suika1,Suika2,Suika3,Suika4,Suika5,Suika6,Sakuy1,Sakuy2,Sakuy3,Sakuy4,Sakuy5,Sakuy6,Keine1,Keine2,Keine3,Keine4,Keine5,Keine6,Kappa1,Kappa2,Kappa3,Kappa4,Kappa5,Kappa6,Yuuka1,Yuuka2,Yuuka3,Yuuka4,Yuuka5,Yuuka6,Maria1,Maria2,Maria3,Maria4,Maria5,Maria6,Sanae1,Sanae2,Sanae3,Sanae4,Sanae5,Sanae6,Sator1,Sator2,Sator3,Sator4,Sator5,Sator6,Youmu1,Youmu2,Youmu3,Youmu4,Youmu5,Youmu6,Futo_1,Futo_2,Futo_3,Futo_4,Futo_5,Futo_6,Patch1,Patch2,Patch3,Patch4,Patch5,Patch6,Inaba1,Inaba2,Inaba3,Inaba4,Inaba5,Inaba6,Okuu_1,Okuu_2,Okuu_3,Okuu_4,Okuu_5,Okuu_6,Remil1,Remil2,Remil3,Remil4,Remil5,Remil6,Ayaya1,Ayaya2,Ayaya3,Ayaya4,Ayaya5,Ayaya6,Miko_1,Miko_2,Miko_3,Miko_4,Miko_5,Miko_6,Eirin1,Eirin2,Eirin3,Eirin4,Eirin5,Eirin6,Yukar1,Yukar2,Yukar3,Yukar4,Yukar5,Yukar6,Anti__1,Anti__2,Anti__3,Challe1,Challe2,Challe3,Exboss1,Exboss2,Exboss3,ExbosR1,ExbosR2,ExbosR3,Exmidb1,Exmidb2,Exmidb3,FinalB1,FinalB2,FinalB3,Heroin1,Heroin2,Heroin3,OTPart1,OTPart2,OTPart3,Partne1,Partne2,Partne3,Phanto1,Phanto2,Phanto3,Rival_1,Rival_2,Rival_3,STGBOS1,STGBOS2,STGBOS3,TPhant1,TPhant2,TPhant3,UP1___1,UP1___2,BOMB__1,BOMB__2,Caspca1,Caspca2,Focus_1,Focus_2,Graze_1,Graze_2,Grimoi1,Grimoi2,Kourin1,Kourin2,Lassho1,Lassho2,Laswor1,Laswor2,Maspla1,Maspla2,Melee_1,Melee_2,Mihakk1,Mihakk2,Party_1,Party_2,Power_1,Power_2,Sealaw1,Sealaw2,Shoot_1,Shoot_2,Sosusc1,Sosusc2,Spiatk1,Spiatk2,Stopwa1,Stopwa2,Sunabo1,Sunabo2,Tempes1,Tempes2,Voile_1,Voile_2,Borrow1,Borrow2,Crioffa1,Crioffa2,Crotohi1,Crotohi2,Endpart1,Endpart2,Eternig1,Eternig2,Fiimreq1,Fiimreq2,Grbawea1,Grbawea2,Grfawar1,Grfawar2,Overdri1,Overdri2,Reblhel1,Reblhel2,Saayblo1,Saayblo2,Scwerha1,Scwerha2,Sprsnow1,Sprsnow2,Unfaobj1,Unfaobj2,Votomak1,Votomak2,Wordesi1,Wordesi2,Lilwhit1,Lilwhit2,Yes,No,Confirm,chslang,conlang
        ,RoleCar,MaDeCar,InciCar,CharCar, NPlayer[0],NPlayer[1],NPlayer[2],NPlayer[3],NPlayer[4],
        Heroine, StageBoss, ExtraBoss, Partner, AddLily, NofRolesError, CharacterChoice, step1, step2, step3, step4, step5, PlayerStats,infinite,ViewStats,EndTurn,
                Back,SandB,Exit,SandE,language);
    }
}










