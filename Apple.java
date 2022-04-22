public class Apple extends Fruit{
    @Override
    public float getWeight() {
        return weight;
    }

    private float weight;

    public Apple(float weight) {
        this.weight = weight;
    }
    public String toString(){
        return "яблоко весом " + weight + " кг";
    }
}
