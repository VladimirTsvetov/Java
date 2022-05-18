import java.util.ArrayList;

public abstract class Stage {
    private int distance;
    public abstract void go();

    public Stage(int distance,ArrayList<RacingCar> teamList) {
        this.distance = distance;
    }
}
