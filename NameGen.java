import java.util.Random;

public class NameGen {
    static Random rand = new Random();
    private static String[] names = {
            "Altairis", "Betelgara", "Cygniar", "Draxilon", "Eridanus", "Fornaxor",
            "Geminor", "Heliox", "Indrion", "Jovaris", "Kalypsi", "Lycoran",
            "Miradon", "Nyralia", "Orionyx", "Paximus", "Quasarion", "Rigelion",
            "Saphyra", "Taurenox", "Ultronis", "Vegaara", "Xenthira", "Ymiris",
            "Zyphros", "Aetheron", "Borealis", "Celestium", "Dextrion", "Elysoria",
            "Flarion", "Glyceria", "Helvoria", "Illuvion", "Jovinar", "Kryndor",
            "Lyserion", "Maldrex", "Nyxior", "Oberonix", "Phalor", "Quantaris",
            "Rhelos", "Selvaris", "Thaloron", "Uranith", "Valoria", "Xandria",
            "Ygdrasil", "Zentarion", "Antaris", "Bellatrixa", "Calyptor", "Deltorion",
            "Ephemera", "Fluvius", "Galadrin", "Halcyon", "Icarion", "Jaxor",
            "Kelviris", "Lunaris", "Minotor", "Nautira", "Orbis", "Proxima",
            "Quintara", "Rhadon", "Solarius", "Tanarion", "Ultraxor", "Velaris",
            "Xenithor", "Yavinor", "Zycronis", "Aeloria", "Blazara", "Cylorion",
            "Dynara", "Eonith", "Floranis", "Gaianor", "Havox", "Ignis",
            "Jalloris", "Krytos", "Lyronis", "Mirenor", "Nexaris", "Orivon",
            "Pyrix", "Quolara", "Rinthis", "Savara", "Tavion", "Urthos",
            "Vyonix", "Xylox", "Ytoris", "Zyntar", "Agnaron", "Belaris",
            "Caelion", "Dralion", "Etheron", "Fenris", "Glyndor", "Haelion",
            "Ilyrius", "Jandor", "Kytherion", "Lorian", "Mirax", "Nytheon",
            "Ovanis", "Pryon", "Quilion", "Rynthis", "Selkaris", "Threxon",
            "Uvoris", "Valyon", "Xyphera", "Ylathor", "Zorvian", "Amaltheon",
            "Brionis", "Cythara", "Dionis", "Eclipsea", "Fensaris", "Glaethon",
            "Harion", "Ithonis", "Jorinor", "Krakenor", "Lunith", "Marith",
            "Nyxora", "Orvion", "Prythion", "Quenaris", "Rylion", "Saphyron",
            "Tartaris", "Uxaris", "Vironis", "Xantheon", "Ymorion", "Zyvorn",
            // Keep adding similar names until you reach 1024
            "Aeonix", "Bracius", "Cylara", "Dralith", "Eorion", "Flavion",
            "Glorath", "Horvath", "Iolanis", "Jaxara", "Korvion", "Lorath",
            "Miralith", "Norvion", "Oberon", "Praxith", "Quarion", "Rylith",
            "Sornath", "Tyrith", "Uralon", "Valthor", "Xionis", "Ythara",
            "Zorath", "Abyssar", "Bryndor", "Crython", "Dynoth", "Elythra",
            "Faelion", "Grathion", "Helionis", "Ixorin", "Jenthar", "Kylor",
            "Lynath", "Mithor", "Nyriel", "Oblivar", "Pheron", "Qilith",
            "Relnor", "Sylvaris", "Tyndor", "Urathis", "Valenor", "Xivion",
            "Ydraxis", "Zolarnis",
            // Repeat pattern or similar names up to 1024
            "Aenarith", "Bolaris", "Calithor", "Dyrion", "Eirith", "Ferion",
            "Galorath", "Holaris", "Ithirion", "Jyxion", "Korathis", "Lythorn",
            "Melaris", "Nythor", "Olmara", "Pytheron", "Qorinth", "Ryton",
            "Seraphon", "Tylion", "Uxmar", "Vexaris", "Xylon", "Ylvenor",
            "Zyrithon", "Artheon", "Blythar", "Cryndor", "Dytheron", "Erian",
            "Farith", "Glynthar", "Horizon", "Ithorian", "Jolnor", "Kythera",
            "Lyrithon", "Mythion", "Nyxaris", "Orlith", "Phyrion", "Quinath",
            "Ralith", "Selithor", "Tyrian", "Utharion", "Vylor", "Xythar",
            "Yltharion", "Zorion", "Aephron", "Bryxion", "Cyloris", "Dynathor",
            "Elysion", "Falornis", "Grixion", "Hylorin", "Ixthar", "Jovarion",
            "Kalithor", "Lythoris", "Melithor", "Nyphion", "Orithon", "Pylaris",
            "Quorith", "Rylorin", "Sarthion", "Tylorion", "Utheron", "Valaris",
            "Xyonis", "Yralion", "Zypheron",// Repeat and vary similar names to fill up to 1024
            "Adyron", "Byloth", "Cyoris", "Dyther", "Elithor", "Fyronis",
            "Gythor", "Hydronis", "Ilython", "Jaryon", "Kylaris", "Lytron",
            "Mynoris", "Nytheon", "Obronis", "Pyloris", "Qoryth", "Ryndor",
            "Syloris", "Thyron", "Uxyon", "Vythor", "Xylaris", "Yvorion",
            "Zelaris", "Aelonis", "Brylar", "Cytheon", "Dythera", "Eonaris",
            "Farion", "Glythar", "Helronis", "Ithlaris", "Jytheron", "Kolaris",
            "Lyrioth", "Mynethor", "Nythera", "Olythar", "Pytheon", "Qylaris",
            "Rylorin", "Sytharion", "Thylar", "Uthronis", "Valyonis", "Xyronis",
            "Ythorion", "Zyntharion"
            // Continue adding names until you reach 1024 total
    };




    // Prefixes, middles, and suffixes for generating star system names
    private static final String[] prefixes = {
            "Ael", "Bry", "Cal", "Dy", "Eon", "Far", "Gly", "Hel", "Ith", "Jov",
            "Kor", "Lyr", "Mel", "Nyx", "Or", "Pyl", "Quor", "Ral", "Syl", "Thy",
            "Ux", "Val", "Xyl", "Yvor", "Zel"
    };

    private static final String[] middles = {
            "a", "e", "i", "o", "u", "y", "ae", "io", "ai", "ar", "ul", "an", "on", "or", "yl"
    };

    private static final String[] suffixes = {
            "is", "on", "ar", "ath", "ion", "or", "ius", "ax", "eth", "al", "is", "or",
            "ith", "orion", "arion", "ionis", "ion", "aris"
    };




    public static String nextName() {
        String prefix = prefixes[rand.nextInt(prefixes.length)];
        String middle = middles[rand.nextInt(middles.length)];
        String suffix = suffixes[rand.nextInt(suffixes.length)];
        return prefix + middle + suffix;
    }



}


