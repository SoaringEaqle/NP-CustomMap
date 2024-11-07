public class LocRet {
    private double relx;
    private double rely;
    private int numPlay;
    private double[] rel = new double[2];
    private double cenX;
    private double cenY;
    private int iter = 0;

    public LocRet(int numPlay){
        this.numPlay = numPlay;

    }

    public void LocIn(double x,double y)
    {
        relx = x;
        rely = y;

    }

    public void setCen(double[][] cords)
    {

        cenX = cords[iter][1];
        cenY = cords[iter][1];
    }
    public void upCen()
    {
        iter++;
    }
    public void reset()
    {
        iter=0;
    }

    public double LocPlX(int i)
    {
        double retx;
        switch (i) {
            case 1 -> retx = relx;
            case 2 -> retx = rely;
            case 3 -> retx = -relx;
            case 4 -> retx = -rely;
            case 5 -> retx = relx;
            case 6 -> retx = rely;
            case 7 -> retx = -relx;
            case 8 -> retx = -rely;
            default -> retx = relx;
        }
        return retx;

    }

    public double LocPlY(int i)
    {
        double rety;
        switch (i) {
            case 1 -> rety = rely;
            case 2 -> rety = relx;
            case 3 -> rety = rely;
            case 4 -> rety = relx;
            case 5 -> rety = -rely;
            case 6 -> rety = -relx;
            case 7 -> rety = -rely;
            case 8 -> rety = -relx;
            default -> rety = rely;
        }
        return rety;
    }

    public double LocCirX(int i)
    {
        double retx;
        double newang = ((2*Math.PI) * ((i-1)/numPlay))  + CircleHelp.retA(relx,rely,cenX,cenY);
        retx = CircleHelp.PtoCX(CircleHelp.retR(relx,rely,cenX,cenY),newang,cenX);
        return retx;
    }
    public double LocCirY(int i)
    {
        double rety;
        double newang = ((2*Math.PI) * ((i-1)/numPlay))  + CircleHelp.retA(relx,rely,cenX,cenY);
        rety = CircleHelp.PtoCY(CircleHelp.retR(relx,rely,cenX,cenY),newang,cenY);
        return rety;
    }




}
