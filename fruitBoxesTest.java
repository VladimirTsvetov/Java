import java.util.ArrayList;
import java.util.Arrays;

public class fruitBoxesTest {

    public static void main(String[] args) {
        //создали коробку для яблок, положили три яблока
        Box<Apple> appleBox = new Box<>();
        appleBox.putFruit(new Apple(0.12f));
        appleBox.putFruit(new Apple(0.25f));
        appleBox.putFruit(new Apple(0.26f));
        //проверяем - работает.
        System.out.println(appleBox);
        System.out.println("Вес коробки = " + appleBox.getNettoWeight() + " кг ");

        //создали коробку апельсинов
        Box<Orange> orangeBox = new Box<>();
        orangeBox.putFruit(new Orange(0.33f));
        orangeBox.putFruit(new Orange(0.44f));
        orangeBox.putFruit(new Orange(0.28f));
        //проверяем - работает.
        System.out.println(orangeBox);
        System.out.println("Вес коробки = " + orangeBox.getNettoWeight() + " кг ");

        //создаем коробку апельсинов
        Box<Orange> box2 = new Box<>();
        try {
            boxReload(box2,orangeBox);
            System.out.println("Успешно пересыпано " + box2.size() + " свежих апельсинов");
            System.out.println("Коробка - источник содержит " + orangeBox.size() + " апельсинов");
            System.out.println("Содержимое новой коробки: " + '\n');
            System.out.println(box2);

        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }

        //сравниваем коробки
        int comp = Box.Compare(orangeBox,appleBox);
        switch (comp){
            case 0:
                System.out.println("Коробки одинаковые!");
                break;
            case -1:
                System.out.println("Коробка с апельсинами легче");
                break;
            case 1:
                System.out.println("Корбка с апельсинами тяжелее");
                break;
        }

        Integer[] dest = {1,2,3,4,5,6,7};
        System.out.println("Печатаем исходный массив");
        for(Integer i:dest)
            System.out.print(i);

        System.out.println();
        System.out.println("Теперь обмененный массив");
        if(swapArrElem(dest))
            for(Integer i:dest)
                System.out.print(i);

        System.out.println();
        System.out.println("Теперь строки");
        // тоже своп
        String[] destStr = {"a","b","c","d"};
        for(String i:destStr)
            System.out.print(i);

        System.out.println();
        System.out.println("Теперь обмененный массив");
        if(swapArrElem(destStr))
            for(String i:destStr)
                System.out.print(i);

        //преобразуем массив строк в соттветствующий ArrayList
        System.out.println();
        System.out.println("Теперь проверяем создание ArrayList из массива. Берем массив строк, его не жалко)");
        try {
            ArrayList<String> strList = transformArrayToArrayList(destStr);
            System.out.println("Выводим его как лист");
            for (String s : strList) {
                System.out.print(s);
            }
        }catch(ArrayStoreException e){
            e.printStackTrace();
        }
    }
    /*
    1. Написать метод, который меняет два элемента массива местами (массив может быть любого
    ссылочного типа);
     */

    /**
     * параметризованный метод для задачи 1
     * @param dest
     * @param <T>
     * @return true if success or false else
     */
    public static <T> boolean  swapArrElem(T[] dest) {

        if (dest.length < 2) {
            System.out.println("недостаточно элементов в массиве!");
            return false;
        }
        else{
            for (int i = 0; i < dest.length-1; i+=2) {
                T tmp = dest[i];
                dest[i] = dest[i+1];
                dest[i+1] = tmp;
            }
        }
        return true;
    }

    /*
    2. Написать метод, который преобразует массив в ArrayList;
    */

    /**
     * параметризованный метод преобразования массива в ArrayList
     * @param dest
     * @param <T>
     * @return ArrayList
     */
    public static <T> ArrayList<T> transformArrayToArrayList(T[] dest){
        if(dest.length == 0)
            throw new ArrayStoreException();
        ArrayList<T> outList = new ArrayList<>(Arrays.asList(dest));
        return outList;
    }

    /*
    3. Задача:

        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
        Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
        Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются
        объекты, которые были в первой;
     */
    public static <T extends Fruit> void boxReload(Box<T> dest,Box<T> source){

       if(source.isEmpty()){
           throw new ArrayIndexOutOfBoundsException();
       }
       while(!source.isEmpty()){
            dest.putFruit(source.getFruit());
       };
    }
}
