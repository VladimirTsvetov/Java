public class Orange extends Fruit{
    @Override
    public float getWeight() {
        return weight;
    }

    private float weight;

    public Orange(float weight) {
        this.weight = weight;
    }
    public String toString(){
        return "апельсин весом " + weight + " кг";
    }
}
