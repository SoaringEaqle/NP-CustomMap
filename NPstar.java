
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Objects;



public class NPstar {


    public static boolean randReward = true;
    protected static int startEcon = 10;
    protected static int startIndus = 5;
    protected static int startSci = 2;
    protected static int startShip = 10;




    public static void setRand(boolean t)
    {
        randReward = t;
    }

    public static void setStartInfrastructure(int econ, int indus, int sci)
    {
        startEcon = econ;
        startIndus = indus;
        startSci = sci;
    }

    public static void updateArray(JSONObject starin) throws JSONException {
        con.stars.put(starin.getInt("uid")-1,starin);
    }


    public static class starHash{
        public static JSONObject NPcap(int starNum, double x, double y, int puid) throws JSONException {
            int resource = 50;
            int econ = NPstar.startEcon;
            int indus = NPstar.startIndus;
            int sci = NPstar.startSci;
            int gate = 1;
            int ship = NPstar.startShip;
            int uid = starNum;

            String name = NameGen.nextName();


            JSONObject star = new JSONObject();
            star.put("uid",uid);
            star.put("name",name);
            star.put("x",x);
            star.put("y",y);
            star.put("resource",resource);
            star.put("economy",econ);
            star.put("industry",indus);
            star.put("science",sci);
            star.put("gate",gate);
            star.put("ship",ship);
            star.put("puid",puid);


            return star;
        }

        public static JSONObject NPclaimed(int starNum, double x, double y, int resource, int puid) throws JSONException {
            int econ = 0;
            int indus = 0;
            int sci = 0;


            int ship = NPstar.startShip;
            int gate = 0;


            String name = NameGen.nextName();
            int uid = starNum;

            JSONObject star = new JSONObject();
            star.put("uid",uid);
            star.put("name",name);
            star.put("x",x);
            star.put("y",y);
            star.put("resource",resource);
            star.put("economy",econ);
            star.put("industry",indus);
            star.put("science",sci);
            star.put("gate",gate);
            star.put("ship",ship);
            star.put("puid",puid);


            return star;
        }

        public static JSONObject NPNotclaimed(int starNum, double x, double y, int resource) throws JSONException {


            int econ = 0;
            int indus = 0;
            int sci = 0;


            int ship = 0;
            int gate = 0;



            if(NPstar.randReward) {
                int num = con.rand.nextInt(20);
                switch (num) {
                    case 1:
                        econ = 5;
                        break;
                    case 2:
                        indus = 2;
                        break;
                    case 3:
                        sci = 1;
                        break;
                    case 4:
                        ship = con.rand.nextInt(15);
                        break;
                    case 5:
                        gate = 1;
                        break;
                    default:
                        break;
                }
            }



            String name = NameGen.nextName();

            int uid = starNum;

            JSONObject star = new JSONObject();
            star.put("uid",uid);
            star.put("name",name);
            star.put("x",x);
            star.put("y",y);
            star.put("resource",resource);
            star.put("economy",econ);
            star.put("industry",indus);
            star.put("science",sci);
            star.put("gate",gate);
            star.put("ship",ship);

            return star;
        }
        public static void NPcust(int starNum)
        {
            int uid = starNum;
            System.out.print("Name (Type \"Random\" to randomly generate the name):");
            String name = con.inp.nextLine();
            if(name.equals("Random"))
            {
                name = NameGen.nextName();
            }
            System.out.print("x location: ");
            double x = con.inp.nextDouble();
            System.out.print("y location: ");
            double y = con.inp.nextDouble();

            System.out.print("resource value: ");
            int resource = con.inp.nextInt();

            System.out.print("economy: ");
            int econ = con.inp.nextInt();

            System.out.print("industry: ");
            int indus = con.inp.nextInt();

            System.out.print("science: ");
            int sci = con.inp.nextInt();

            System.out.print("Gate (0=false, 1=true): ");
            int gate = con.inp.nextInt();

            System.out.print("Starting Ships: ");
            int ship = con.inp.nextInt();

            System.out.print("puid (0 will return an unclaimed star): ");
            int puid = con.inp.nextInt();
            HashMap<String,String> star = new HashMap<String,String>();
            star.put("uid",Integer.toString(uid));
            star.put("name",name);
            star.put("x",Double.toString(x));
            star.put("y",Double.toString(y));
            star.put("resource",Integer.toString(resource));
            star.put("economy",Integer.toString(econ));
            star.put("industry",Integer.toString(indus));
            star.put("science",Integer.toString(sci));
            star.put("gate",Integer.toString(gate));
            star.put("ship",Integer.toString(ship));
        }


        public static String makeString(HashMap<String,String> star)
        {
            if (star.containsKey("puid"))
            {
                return "\t{\"uid\": " + star.get("uid") + ", \"name\": \"" + star.get("name") +"\", \"x\": "+ star.get("x")+", \"y\": "+star.get("y")+", \"r\": "+star.get("resource")+", \"g\": "+star.get("gate")+", \"e\": "+star.get("economy")+", \"i\": "+star.get("industry")+", \"s\": "+star.get("science")+", \"st\": "+star.get("ship")+", \"puid\": "+star.get("puid")+"},";
            }
            return "\t{\"uid\": " + star.get("uid") + ", \"name\": \"" + star.get("name") +"\", \"x\": "+ star.get("x")+", \"y\": "+star.get("y")+", \"r\": "+star.get("resource")+", \"g\": "+star.get("gate")+", \"e\": "+star.get("economy")+", \"i\": "+star.get("industry")+", \"s\": "+star.get("science")+", \"st\": "+star.get("ship")+"},";
        }
        public static double starX(JSONObject star) throws JSONException {
            double x = (double) star.get("x");
            return x;
        }
        public static double starY(JSONObject star) throws JSONException {
            double y = (double)star.get("y");
            return y;
        }


    }
    public static class StarObj {
        private int econ;
        private int indus;
        private int sci;
        private int resource;
        private int ships;
        private int gate;
        private int uid;
        private int puid;
        private double starx;
        private double stary;
        private String name;

        HashMap<String,String> star = new HashMap<String,String>();
        JSONObject starJ = new JSONObject();
        StarObj otherStar;

        public void setOtherStar(StarObj starObj){
            otherStar = starObj;
        }
        public void resetStarObj(HashMap<String,String> star)
        {
            uid = Integer.parseInt(star.get("uid"));
            name = star.get("name");
            starx = Double.parseDouble(star.get("x"));
            stary = Double.parseDouble(star.get("y"));
            resource = Integer.parseInt(star.get("resource"));
            econ = Integer.parseInt(star.get("economy"));
            indus = Integer.parseInt(star.get("industry"));
            sci = Integer.parseInt(star.get("science"));
            ships = Integer.parseInt(star.get("ship"));
            gate = Integer.parseInt(star.get("gate"));
            puid = Integer.parseInt(star.getOrDefault("puid","0"));

            this.star = star;

        }
        public void resetStarObj(JSONObject star) throws JSONException {
            uid = star.getInt("uid");
            name = star.getString("name");
            starx = star.getDouble("x");
            stary = star.getDouble("y");
            resource = star.getInt("resource");
            econ = star.getInt("economy");
            indus = star.getInt("industry");
            sci = star.getInt("science");
            ships = star.getInt("ship");
            gate = star.getInt("gate");
            puid = star.optInt("puid", 0);

            starJ = star;


        }
        public StarObj(int uid)
        {
            star = con.starList.get(uid-1);
            this.resetStarObj(star);

        }
        public StarObj(HashMap<String,String> star) {
            uid = Integer.parseInt(star.get("uid"));
            name = star.get("name");
            starx = Double.parseDouble(star.get("x"));
            stary = Double.parseDouble(star.get("y"));
            resource = Integer.parseInt(star.get("resource"));
            econ = Integer.parseInt(star.get("economy"));
            indus = Integer.parseInt(star.get("industry"));
            sci = Integer.parseInt(star.get("science"));
            ships = Integer.parseInt(star.get("ship"));
            gate = Integer.parseInt(star.get("gate"));
            puid = Integer.parseInt(star.getOrDefault("puid", "0"));

            this.star = star;
        }
        public StarObj(JSONObject star) throws JSONException {
            uid = star.getInt("uid");
            name = star.getString("name");
            starx = star.getDouble("x");
            stary = star.getDouble("y");
            resource = star.getInt("resource");
            econ = star.getInt("economy");
            indus = star.getInt("industry");
            sci = star.getInt("science");
            ships = star.getInt("ship");
            gate = star.getInt("gate");
            puid = star.optInt("puid", 0);


        }


        public void newName(){
            name = NameGen.newName();
        }

        public Object get(String key) throws JSONException {
            return starJ.get(key);
        }

        public JSONObject repackage() throws JSONException {
            starJ.put("uid",uid);
            starJ.put("name",name);
            starJ.put("x",starx);
            starJ.put("y",stary);
            starJ.put("resource",Integer.toString(resource));
            starJ.put("economy",Integer.toString(econ));
            starJ.put("industry",Integer.toString(indus));
            starJ.put("science",Integer.toString(sci));
            starJ.put("gate",Integer.toString(gate));
            starJ.put("ship",Integer.toString(ships));
            if(puid>0)
            {
                starJ.put("puid",puid);
            }


            return starJ;
        }



        public boolean equals(StarObj starin){
            if (uid == starin.uid && name.equals(starin.name) &&
            econ == starin.econ && indus == starin.indus && sci == starin.sci &&
            resource == starin.resource &&
            ships == starin.ships && gate == starin.gate &&
            puid == starin.puid &&
            starx == starin.starx && stary == starin.stary
            ){
                return true;
            }
            return false;
        }

        public boolean nameEqual(StarObj starin){
            if (uid != starin.uid && Objects.equals(name, starin.name))
            {
                return true;
            }
            return false;
        }

        public boolean cordsEqual(StarObj starin){
            if (uid != starin.uid && starx == starin.starx && stary == starin.stary)
            {
                return true;
            }
            return false;
        }
        public boolean nameEqual(){
            if ( name.equals(otherStar.name))
            {
                return true;
            }
            return false;
        }

        public boolean cordsEqual(){
            if (uid != otherStar.uid && starx == otherStar.starx && stary == otherStar.stary)
            {
                return true;
            }
            return false;
        }

    }

    public static class WHMaker {
        public static JSONArray hole(int uid1, int uid2) {
            JSONArray hole = new JSONArray();
            hole.put(uid1);
            hole.put(uid2);
            return hole;
        }


        public static String makeString(int uid1, int uid2) {
            String word = "\t[" + uid1 + ", " + uid2 + "],";
            return word;
        }

        public static String makeString(int[] hole) {
            String word = "\t[" + hole[0] + ", " + hole[1] + "],";
            return word;
        }
    }
}
