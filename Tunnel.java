import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Tunnel extends Stage{
    //, ArrayList<RacingCar> teamList
    public Tunnel(int distance,boolean isFinish) {
        super(distance,isFinish);
    }

    @Override
    public void go(ArrayList<RacingCar> teamList) {
        final int CAR_COUNT = teamList.size();
        Semaphore smp = new Semaphore(3);
        for (int i = 0; i < CAR_COUNT; i++) {
            RacingCar car = teamList.get(i);
            new Thread(() -> {
                try {
                    System.out.println("Гоночный номер " + car.getRacingNumber()  + " перед тоннелем");
                    smp.acquire();
                    System.out.println("Гоночный номер " + car.getRacingNumber()  + " проехал тоннелем");
                            Thread.sleep( distance/car.getSpeed()*1000 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    smp.release();
                }
            }).start();
        }

    }
}
