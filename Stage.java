import java.util.ArrayList;

public abstract class Stage {
    public int distance;
    public boolean isFinish;

    public abstract void go(ArrayList<RacingCar> teamList);

    public Stage(int distance,boolean isFinish) {
        this.distance = distance;
        this.isFinish = isFinish;
    }
}
