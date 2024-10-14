



import java.awt.geom.Point2D;

import java.util.Random;
import java.util.Scanner;


public class NPmapGen2 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Random rand = new Random();
        // number of players
        System.out.print("Number of players:");
        int numPl = inp.nextInt();
        // total stars per player
        System.out.print("Number of stars per player:");
        int starPl = inp.nextInt();
        //staring stars per player
        System.out.print("Number of starting stars per player:");
        int startStarPl = inp.nextInt() ;
        double starx;
        double stary;
        double radius;
        double theta;
        int starnum = 1;
        int arrayAdd = 0;
        int res;
        LocRet locRet = new LocRet(numPl);


    //Capital Gen
        //r,angle points
        double homerad = (rand.nextDouble() * 5);
        double homeang = (rand.nextDouble() * ((Math.PI *2)/numPl));
        double homex;
        double homey;
        String[] home = new String[numPl];
        double [][] homexy = new double[numPl][4];
        for(int plNum = 1; plNum <= numPl; plNum++)
        {
            homeang += (2*Math.PI) /numPl;
            homex = CircleHelp.PtoCX(homerad,homeang,0);
            homey = CircleHelp.PtoCY(homerad,homeang,0);
            home[arrayAdd] = NPstar.NPcap(starnum, homex, homey, plNum);
            homexy[arrayAdd][0] = starnum;
            homexy[arrayAdd][1]= homex;
            homexy[arrayAdd][2] = homey;
            homexy[arrayAdd][3] = plNum;
            starnum++;
            arrayAdd++;
        }
        arrayAdd = 0;

    //Claimed Stars
        String[] claimed = new String[numPl*(startStarPl-1)];
        double [][] claimedxy = new double[numPl*(startStarPl-1)][4];
        for(int i = 0; i < startStarPl-1; i++) {
            radius = Math.abs(rand.nextDouble(0.01, 0.25));
            theta = rand.nextDouble() * 2.0 * Math.PI;
            locRet.setCen(homexy);
            res = 35 + (int) (rand.nextGaussian() * 10.0);
            for (int plNum = 1; plNum <= numPl; plNum++) {
                starx = CircleHelp.PtoCX(radius, theta, homexy[plNum - 1][1]) + homexy[plNum - 1][1];
                stary = CircleHelp.PtoCY(radius, theta, homexy[plNum - 1][2]) + homexy[plNum - 1][2];
                //locRet.LocIn(starx, stary);
                claimed[arrayAdd] = NPstar.NPclaimed(starnum, starx, stary, res, plNum);
                claimedxy[arrayAdd][1] = starx;
                claimedxy[arrayAdd][2] = stary;
                claimedxy[arrayAdd][0] = starnum;
                claimedxy[arrayAdd][3] = plNum;
                arrayAdd++;
                starnum++;
                locRet.upCen();

            }
            locRet.reset();
        }

        arrayAdd = 0;

        int notClaimednum = starPl - startStarPl;
        String[] notclaimed = new String[numPl*(notClaimednum)];
        double [][] notclaimedxy = new double[numPl*(notClaimednum)][3];
        for(int i = 0; i < notClaimednum * numPl; i++) {
            radius = Math.abs(rand.nextDouble()*numPl*2);
            theta = rand.nextDouble() * 2.0 * Math.PI;
            starx = CircleHelp.PtoCX(radius, theta, 0);
            stary = CircleHelp.PtoCY(radius, theta, 0);
            locRet.LocIn(starx, stary);
            res = 35 + (int) (rand.nextGaussian() * 10.0);


            notclaimed[arrayAdd] = NPstar.NPNotclaimed(starnum, starx, stary, res);
            notclaimedxy[arrayAdd][1] = starx;
            notclaimedxy[arrayAdd][2] = stary;
            notclaimedxy[arrayAdd][0] = starnum;
            arrayAdd++;
            starnum++;
        }
        arrayAdd = 0;

        System.out.print("Number of Wormholes:");
        int worm = inp.nextInt();
        int error = 0;
        Point2D.Double point1 = new Point2D.Double();
        int uid1;
        int uid2;
        double[] sub = new double[3];
        String[] wormhole = new String[worm];
        Point2D.Double point2 = new Point2D.Double();
        while(arrayAdd < worm)
        {
            uid1 = rand.nextInt(1,numPl*notClaimednum);
            sub = notclaimedxy[uid1-1];
            point1.setLocation(sub[1],sub[2]);
            uid2 = rand.nextInt(1,numPl*notClaimednum);
            sub = notclaimedxy[uid2-1];
            point2.setLocation(sub[1],sub[2]);
            if (point1.distance(point2) > 1.0)
            {
                wormhole[arrayAdd] = WHMaker.make(uid1, uid2);
                arrayAdd++;
            }
            else if(error < 8)
            {
                error++;
            }
            else if(error == 8)
            {
                wormhole[arrayAdd] = "8 attempts: Error";
                arrayAdd++;
                error = 0;
            }

        }



        System.out.println("{\"stars\":[");
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
        System.out.print("]");


        System.out.println(", \n\"wormholes\":[");
        for(String i : wormhole)
        {
            System.out.println(i);
        }
        System.out.print("]");


        System.out.println("}");

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
}
