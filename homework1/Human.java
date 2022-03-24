package java2.homework1;

public class Human implements Mobile{

    private final double maxRunDistance;
    private final double maxJumpHigh;
    private String name;
    public Human(String name, double distance,double high){
        maxJumpHigh = high;
        maxRunDistance = distance;
        this.name = name;
    }
    public void goJump(double bar) {
        if(bar < getMaxJumpHigh()){
            System.out.println("Человек " + getName() + " перепрыгнул стену в " + bar + " метров вверх!");
            return;
        }
        System.out.println("Человек не смог перепрыгнуть стену в " + bar + "метров. Был пацан - нет пацана :(");
    };

    @Override
    public void goRun(double distance) {
        if(distance < getMaxRunDistance()){
            System.out.println("Человек " + getName() + " резво пробежал " + distance + " метров!");
            return;
        }
        System.out.println("Человече не смог пробежать " + distance + " метров. Здесь есть доктор?!");
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
