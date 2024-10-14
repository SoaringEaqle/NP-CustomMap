import java.util.Random;
public class NPstar {

    static Random rand = new Random();
    public static boolean randReward = true;

    public static void setRand(boolean t)
    {
        randReward = t;
    }

    public static String NPcap(int starNum, double x, double y, int puid) {


        int resource = 50;
        int econ = 10;
        int indus = 5;
        int sci = 2;
        int gate = 1;
        int ship = 10;
        int uid = starNum;
        String name = NameGen.nextName();

        return "\t{\"uid\": " + uid + ", \"name\": \"" + name +"\", \"x\": "+ x+", \"y\": "+y+", \"r\": "+resource+", \"g\": "+gate+", \"e\": "+econ+", \"i\": "+indus+", \"s\": "+sci+", \"st\": "+ship+", \"puid\": "+puid+"},";
    }

    public static String NPclaimed(int starNum, double x, double y, int resource, int puid) {
        int econ = 0;
        int indus = 0;
        int sci = 0;


        int ship = 10;
        int gate = 0;



        int uid = starNum;
        String name = NameGen.nextName();

        return "\t{\"uid\": " + uid + ", \"name\": \"" + name +"\", \"x\": "+ x+", \"y\": "+y+", \"r\": "+resource+", \"g\": "+gate+", \"e\": "+econ+", \"i\": "+indus+", \"s\": "+sci+", \"st\": "+ship+", \"puid\": "+puid+"},";
    }

    public static String NPNotclaimed(int starNum, double x, double y, int resource) {




        int econ = 0;
        int indus = 0;
        int sci = 0;


        int ship = 0;
        int gate = 0;

        if(randReward) {
            int num = rand.nextInt(20);
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
                    ship = rand.nextInt(15);
                    break;
                case 5:
                    gate = 1;
                    break;
                default:
                    break;
            }
        }

        int uid = starNum;
        String name = NameGen.nextName();
        return "\t{\"uid\": " + uid + ", \"name\": \"" + name +"\", \"x\": "+ x+", \"y\": "+y+", \"r\": "+resource+", \"g\": "+gate+", \"e\": "+econ+", \"i\": "+indus+", \"s\": "+sci+", \"st\": "+ship+"},";
    }


}
