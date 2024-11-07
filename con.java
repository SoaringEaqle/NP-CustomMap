import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class con {
    public static Scanner inp = new Scanner(System.in);
    public static Random rand = new Random();
    public static ArrayList<HashMap<String,String>> starList = new ArrayList<>();
    public static ArrayList<String> wormList = new ArrayList<>();

    public static JSONObject main = new JSONObject();
    public static JSONArray stars = new JSONArray();
    public static JSONArray worms = new JSONArray();



    public static int min(int factor){
        switch (factor){
            case 1: return 1;
            case 2: return 3;
            case 3: return 5;
            case 4: return 7;
            case 5: return 10;
            default: return 3;
        }
    }
    public static int bound(int factor)
    {
        switch (factor){
            case 1: return 3;
            case 2: return 5;
            case 3: return 8;
            case 4: return 10;
            case 5: return 15;
            default: return 5;

        }
    }


}
