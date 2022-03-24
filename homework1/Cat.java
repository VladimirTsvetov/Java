package java2.homework1;

public class Cat implements Mobile{
    private final double maxRunDistance;
    private final double maxJumpHigh;
    private String name;
    public Cat(String name, double distance,double high){
        maxJumpHigh = high;
        maxRunDistance = distance;
        this.name = name;
    }
    @Override
    public void goJump(double bar) {
        if(bar < getMaxJumpHigh()){
            System.out.println("Кот " + getName() + " перепрыгнул стену в " + bar + " метров вверх!");
            return;
        }
        System.out.println("Кот не смог перепрыгнуть стену в " + bar + "метров");
    };

    @Override
    public void goRun(double distance) {
        if(distance < getMaxRunDistance()){
            System.out.println("Кот " + getName() + " резво пробежал " + distance + " метров!");
            return;
        }
        System.out.println("Кот не смог пробежать " + distance + " метров. Здесь есть ветеринар?!");
    }

    public double getMaxRunDistance() {
        return maxRunDistance;
    }

    public double getMaxJumpHigh() {
        return maxJumpHigh;
    }

    public String getName() {
        return name;
    }

}
