import java.util.ArrayDeque;
import java.util.ArrayList;

public class Box <T extends Fruit>{
    private ArrayDeque<T> fruits;

    public Box() {
        fruits = new ArrayDeque<>();
    }
    //положить в коробку
    public void putFruit(T fruit){
         fruits.push(fruit);
    }
    //достать из коробки
    public T getFruit(){
        if(fruits.peek() != null)
            return fruits.pop();
        else
            return null;
    }
    public String toString(){
        String retStr = new String();
        for (T fruit : fruits) {
           retStr += fruit.toString() + '\n';
        }
        return retStr;
    }

    public float getNettoWeight(){
        float totalWeight = 0f;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public static int Compare(Box leftBox, Box secondBox){
        if((leftBox.getNettoWeight() - secondBox.getNettoWeight()) == 0)
            return 0;
        return ((leftBox.getNettoWeight() - secondBox.getNettoWeight())) < 0 ? -1: 1;
    }

    public boolean isEmpty(){
        return fruits.isEmpty();
    }

    public int size(){
        return fruits.size();
    }

}
