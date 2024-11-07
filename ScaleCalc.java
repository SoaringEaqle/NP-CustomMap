public class ScaleCalc {

    private double scale = 0.0625;//units per lightyear
    private double units;
    private double ltyr;



    public double ltyrPUnt(double lightyears)
    {
        units = lightyears * scale;
        return units;
    }

    public double maxRange(int level)
    {
        double maxRange1 = level + 4;
        return maxRange1;
    }

    public double maxRangeU(int level)
    {
        Double maxRange1 = this.maxRange(level);
        double maxRangeU1 = this.ltyrPUnt(maxRange1);
        return maxRangeU1;
    }

    public double unitPLy()
    {
        ltyr = this.units / scale;
        return ltyr;
    }

    public void setUnits(double units)
    {
        this.units = units;
    }

    public void setLtyr(double ltyr)
    {
        this.ltyr = ltyr;
    }

}
