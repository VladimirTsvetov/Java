import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class F1GPMonaco {
    public static void main(String[] args) {
        final int TEAM_COUNT = 6;
        ArrayList<RacingCar> racingTeam = new ArrayList<>();
        for(int i = 0; i < TEAM_COUNT; i++){
            racingTeam.add(new RacingCar((int)(Math.random()*300),i+1));
        }
        RacingPreparation racingPreparation = new RacingPreparation(racingTeam);
        racingPreparation.go();
        Race GPMonaco = new Race(racingTeam,new Road(60,false),new Tunnel(100,false),
                new Road(40,true));
        GPMonaco.startRace();
        System.out.println("Гонка завершена");


    }
}

