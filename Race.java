import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private ArrayList<Stage> stages;
    private ArrayList<RacingCar> teamList;

    public Race(ArrayList<RacingCar> teamList,Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        this.teamList = teamList;
    }

    public void startRace(){
        for(int i = 0; i < stages.size(); i++){
            stages.get(i).go(teamList);
        }
    }
}
