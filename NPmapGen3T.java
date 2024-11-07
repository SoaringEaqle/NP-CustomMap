import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;



public class NPmapGen3T {
    public static void main(String[] args) throws JSONException {

        // number of players
        System.out.print("Number of players:");
        int numPl = con.inp.nextInt();
        // total stars per player
        System.out.print("Number of stars per player:");
        int starPl = con.inp.nextInt();
        //staring stars per player
        System.out.print("Number of starting stars per player:");
        int startStarPl = con.inp.nextInt();

        System.out.print("Random exploration rewards(true/false): ");
        NPstar.randReward = con.inp.nextBoolean();

        System.out.print("Star distance factor(1-5): ");
        int dFactor = con.inp.nextInt();

        System.out.print("Home star distance factor(1-5): ");
        int hdFactor = con.inp.nextInt();

        System.out.print("Special Game modes(true/false): ");
        boolean adv = con.inp.nextBoolean();
        String gModes ="";
        if(adv)
        {
            System.out.println("Each of the following map settings is assigned a number. " +
                    "When prompted, input the numbers of all values as one integer.");
            System.out.println("1) Central Wormhole: All home stars are connected to one central star that players fight over.");
            System.out.println("2) Two Rings: Players are split into two rings with 1 player on the inside to every 2-3 players on the outside.");
            System.out.println("3) Rings: All stars are formed into rings around the home stars. The number of rings will be specified later.");
            con.inp.nextLine();
            gModes = con.inp.nextLine();

        }

        double starx;
        double stary;
        double radius;
        double theta;
        int starnum = 1;

        int res;




    //Capital Gen
        //r,angle points
        double homerad = (con.rand.nextDouble(con.min(hdFactor),con.bound(hdFactor)));
        double homeang = (con.rand.nextDouble() * ((Math.PI *2)/numPl));
        double homex;
        double homey;


        for(int plNum = 1; plNum <= numPl; plNum++)
        {

            homex = CircleHelp.round4(CircleHelp.PtoCX(homerad,homeang,0));
            homey = CircleHelp.round4(CircleHelp.PtoCY(homerad,homeang,0));

            con.stars.put(NPstar.starHash.NPcap(starnum, homex, homey, plNum));
            homeang += (2*Math.PI) /numPl;
            starnum++;

        }

    //Claimed Stars

        for(int i = 0; i < startStarPl-1; i++) {
            radius = Math.abs(con.rand.nextDouble(0.01, 0.25));
            theta = con.rand.nextDouble() * 2.0 * Math.PI;

            res = 35 + (int) (con.rand.nextGaussian() * 10.0);
            for (int plNum = 1; plNum <= numPl; plNum++) {
                starx = CircleHelp.round4(CircleHelp.PtoCX(radius, theta, NPstar.starHash.starX(con.stars.getJSONObject(plNum-1))));
                stary = CircleHelp.round4(CircleHelp.PtoCY(radius, theta, NPstar.starHash.starY(con.stars.getJSONObject(plNum-1))));

                con.stars.put(NPstar.starHash.NPclaimed(starnum, starx, stary, res, plNum));


                starnum++;


            }

        }


        System.out.print("Even unclaimed stars(true/false): ");

        boolean even = con.inp.nextBoolean();
        int notClaimednum = starPl - startStarPl;
        if (even){
            for(int i = 0; i < notClaimednum; i++) {
                radius = Math.abs(con.rand.nextDouble()*numPl*2);
                theta = con.rand.nextDouble() * 2.0 * Math.PI/numPl;
                res = 35 + (int) (con.rand.nextGaussian() * 10.0);
                for(int plNum = 1; plNum <= numPl;plNum++) {
                    starx = CircleHelp.round4(CircleHelp.PtoCX(radius, theta, 0));
                    stary = CircleHelp.round4(CircleHelp.PtoCY(radius, theta, 0));
                    con.stars.put(NPstar.starHash.NPNotclaimed(starnum, starx, stary, res));
                    theta += (2.0*Math.PI)/numPl;
                    starnum++;
                }
            }

        }
        else {


            for (int i = 0; i < notClaimednum * numPl; i++) {
                radius = Math.abs(con.rand.nextDouble() * numPl * 2);
                theta = con.rand.nextDouble() * 2.0 * Math.PI;
                starx = CircleHelp.round4(CircleHelp.PtoCX(radius, theta, 0));
                stary = CircleHelp.round4(CircleHelp.PtoCY(radius, theta, 0));
                res = 35 + (int) (con.rand.nextGaussian() * 10.0);

                con.stars.put(NPstar.starHash.NPNotclaimed(starnum, starx, stary, res));


                starnum++;
            }

        }

        if(gModes.contains("1"))
        {
            starx = 0;
            stary = 0;
            res = 60;
            con.stars.put(NPstar.starHash.NPNotclaimed(starnum, starx, stary, res));
        }
        System.out.print("Number of Wormholes:");
        int worm = con.inp.nextInt();

        int error = 0;
        Point2D.Double point1 = new Point2D.Double();
        int uid1;
        int uid2;
        JSONObject sub;

        Point2D.Double point2 = new Point2D.Double();
        while(con.worms.length() < worm)
        {
            uid1 = con.rand.nextInt(1,numPl*starPl);
            sub = con.stars.getJSONObject(uid1-1);
            point1.setLocation(NPstar.starHash.starX(sub),NPstar.starHash.starY(sub));
            uid2 = con.rand.nextInt(1,numPl*starPl);
            sub = con.stars.getJSONObject(uid2-1);
            point2.setLocation(NPstar.starHash.starX(sub),NPstar.starHash.starY(sub));
            int repeats = 0;
            if (point1.distance(point2) > 1.0)
            {
                con.worms.put(NPstar.WHMaker.hole(uid1,uid2));

            }
            else if(error < 8)
            {
                error++;
            }
            else if(error == 8)
            {
                con.worms.put("8 attempts: Error");

                error = 0;
            }
            System.out.println(repeats + " repetitions of wormholes");


        }
        if(gModes.contains("1"))
        {
            for (int plNum = 1; plNum <= numPl; plNum++)
            {
                con.wormList.add(NPstar.WHMaker.makeString(plNum, starnum));
            }
        }

        System.out.println("test for repeats (true/false): ");
        boolean check = con.inp.nextBoolean();
        if(check){
            JSONObject starHash = con.stars.getJSONObject(0);
            NPstar.StarObj star1 = new NPstar.StarObj(starHash);
            NPstar.StarObj starComp = new NPstar.StarObj(starHash);
            int namerep = 0;
            int cordRep = 0;
            for(int i = 0; i < con.stars.length(); i++){

                star1.resetStarObj(con.stars.getJSONObject(i));
                int num = 0;
                while(num < con.starList.size()){
                    starComp.resetStarObj(con.starList.get(num));
                    num++;
                    if(!star1.equals(starComp) && star1.nameEqual(starComp)){
                        System.out.println("Name of star " + star1.get("uid") +" was the same name as " + star1.get("uid") + " of " +  star1.get("name"));
                        namerep++;
                        star1.newName();
                        star1.repackage();
                        num = 0;
                    }
                    if(!star1.equals(starComp) && star1.cordsEqual(starComp)){
                        System.out.println("Cords of star " + star1.get("uid") +" is the same cords as star" + starComp.get("uid") + " at " +  star1.get("x")+"," + star1.get("y"));
                        cordRep++;

                        star1.repackage();
                        num = 0;
                    }


                }

            }


            System.out.println("Names were repeated " + namerep + " times");
            System.out.println("Cords were repeated " + cordRep + " times");


        }
        /*System.out.println("{\"stars\":[");
        for(String i : home)
        {
            System.out.println(i);
        }
        for (String i : claimed)
        {
            System.out.println(i);
        }
        for (String i : notclaimed)
        {
            System.out.println(i);
        }
        for(HashMap<String,String> i : con.starList)
        {
            System.out.println(NPstar.starHash.makeString(i));
        }

        System.out.print("]");*/




        /*System.out.println(", \n\"wormholes\":[");
        for(String i : con.wormList)
        {
            System.out.println(i);
        }
        System.out.print("]");


        System.out.println("}");*/
        con.main.put("stars",con.stars);
        con.main.put("wormholes",con.worms);

        System.out.println(con.main);


        //todo add renderer
        /*
        Drawhelp g = new Drawhelp();

        Graphics g = new Gr
        Rectangle2D.Double rect = new Rectangle2D.Double();
        for(String i ; homexy)
        {
            rect.setRect(homexy[arrayAdd][1],
                    homexy[arrayAdd][2],
                    homexy[arrayAdd][1],
                    homexy[arrayAdd][2]);
            rect.draw

        }
        */
    }
    public class AdvSet{

    }


}
