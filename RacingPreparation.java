import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;


public class RacingPreparation {
    private ArrayList<RacingCar> teamList;
    public RacingPreparation(ArrayList<RacingCar> teamList) {
       this.teamList = teamList;
    }


    public void go() {

        final int CAR_COUNT = teamList.size();

        final CountDownLatch cdl = new CountDownLatch(CAR_COUNT);
        System.out.println("Начинаем подготовку к гонке");
        for (int i = 0; i < CAR_COUNT; i++) {
            RacingCar car = teamList.get(i);
            final int w = i;
            new Thread(() -> {
                try {
                    System.out.println("Гоночный номер " + car.getRacingNumber() + " начал подготовку");
                    Thread.sleep( 50 * (int) (Math.random() * 10));
                    cdl.countDown();
                    System.out.println("Гоночный номер " + car.getRacingNumber() + " Готов");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            cdl.await();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Подготовка завершена");
    }
}
