package java2.homework1;

public class Robot implements Mobile{
    private final double maxRunDistance;
    private final double maxJumpHigh;
    private String name;
    public Robot(String name, double distance,double high){
        maxJumpHigh = high;
        maxRunDistance = distance;
        this.name = name;
    }
    public void goJump(double bar) {
        if(bar < getMaxJumpHigh()){
            System.out.println("Робот " + getName() + " перепрыгнул стену в " + bar + " метров вверх!");
            return;
        }
        System.out.println("Робот не смог перепрыгнуть стену в " + bar + "метров. Роботы не прыгают!");
    };

    @Override
    public void goRun(double distance) {
        if(distance < getMaxRunDistance()){
            System.out.println("Робот " + getName() + " резво пробежал " + distance + " метров!");
            return;
        }
        System.out.println("Робот не смог пробежать " + distance + " метров. Здесь есть механик?!");
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
