import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RacingPreparation extends Stage{
    private ArrayList<RacingCar> teamList;
    int distance;
    public RacingPreparation(int distance, ArrayList<RacingCar> teamList) {
        super(distance, teamList);
        this.teamList = teamList;
        this.distance = distance;
    }

    @Override
    public void go() {
        final int CAR_COUNT = teamList.size();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(CAR_COUNT);
        for (int i = 0; i < CAR_COUNT; i++) {
            int index = i;
            RacingCar car = teamList.get(i);
            new Thread(() -> {
                try {
                    System.out.println("Подготавливается гоночный номер  " + car.getRacingNumber());
                    Thread.sleep( distance + 500 * (int) (Math.random() * 10));
                    System.out.println("Гоночный номер " + car.getRacingNumber() +  " подготовился ");
                    cyclicBarrier.await(); // 4 3 2 1 0
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

}
