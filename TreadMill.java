package java2.homework1;

public class TreadMill implements Prohibitive{
    private final double distance;
    public TreadMill(){
        this.distance = 1000;
    }
    public TreadMill(double distance){
        this.distance = distance;
    }
    public double getWall(){
        return distance;
    }


}
