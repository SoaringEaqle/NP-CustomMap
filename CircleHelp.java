



public class CircleHelp {


    public static double[] CtoP(double x, double y, double cenX, double cenY)
    {
        double difX = x - cenX;
        double difY = y - cenY;
        double r = Math.sqrt((difX*difX + difY*difY));
        double angle = Math.atan2(difY,difY);
        double[] polar = {r,angle};
        return polar;
    }

    public static double[] PtoC(double r, double angle, double cenX, double cenY)
    {
        double difX = r * Math.cos(angle);
        double difY = r * Math.sin(angle);
        double x = difX + cenX;
        double y = difY + cenY;
        double[] cart = {x,y};
        return cart;
    }
    public static double PtoCX(double r, double angle, double cenX)
    {
        double difX = r * Math.cos(angle);

        //double x = difX + cenX;
        return difX;

    }
    public static double PtoCY(double r, double angle, double cenY)
    {
        double difY = r * Math.sin(angle);
        //double y = difY + cenY;
        return difY;
    }
    public static double retA(double x, double y, double cenX, double cenY)
    {
        double[] pol = CircleHelp.CtoP(x,y,cenX,cenY);
        return pol[1];
    }

    public static double retR(double x, double y, double cenX, double cenY)
    {
        double[] pol = CircleHelp.CtoP(x, y, cenX, cenY);
        return pol[0];
    }
}