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
    @Override
    public double goJump(double bar) {
        //System.out.println("робот " + getName() + " прыгнул на " + getMaxJumpHigh() + " метров вверх!");
        return bar - getMaxJumpHigh();
    };

    @Override
    public double goRun(double distance) {
        //System.out.println("робо " + getName() + " пробежал " + getMaxRunDistance() + " метров!");
        return distance - getMaxRunDistance();
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
