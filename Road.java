import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;


public class Road extends Stage{
    private volatile int position = 0;
    //, ArrayList<RacingCar> teamList
    public Road(int distance, boolean isFinish) {
        super(distance, isFinish);
    }
    @Override
    public void go(ArrayList<RacingCar> teamList) {
        final int CAR_COUNT = teamList.size();

        final CountDownLatch cdl = new CountDownLatch(CAR_COUNT);

        for (int i = 0; i < CAR_COUNT; i++) {
            RacingCar car = teamList.get(i);

            new Thread(() -> {
                try {
                    System.out.println("Гоночный номер " + car.getRacingNumber() + " начал этап " + distance
                                    + " км");
                    Thread.sleep( distance/car.getSpeed() * 1000);
                    cdl.countDown();
                    System.out.println("Гоночный номер " + car.getRacingNumber() + " Закончил этап " +
                           distance +  " км");
                    ++position;
                    if(position == 1 && isFinish)
                        System.out.println("Встречайте победителя " + "Гоночный номер " + car.getRacingNumber());
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
    }
}
