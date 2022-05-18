import java.util.ArrayList;

public class F1GPMonaco {
    public static void main(String[] args) {
        final int TEAM_COUNT = 6;
        ArrayList<RacingCar> racingTeam = new ArrayList<>();
        for(int i = 0; i < TEAM_COUNT; i++){
            racingTeam.add(new RacingCar((int)Math.random()*300,i+1));
        }
        RacingPreparation racingPreparation = new RacingPreparation(100,racingTeam);
        racingPreparation.go();
    }
}
