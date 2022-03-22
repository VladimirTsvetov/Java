package java2.homework1;

public class TheWall implements Prohibitive{

    private final double high;
    public TheWall(double high){
        this.high = high;
    }
    public double getWall(){
        return high;
    }
}
