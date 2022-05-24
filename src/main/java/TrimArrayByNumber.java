import java.util.ArrayList;
import java.util.Arrays;
/*
Написать метод, которому в качестве аргумента передается не пустой одномерный
целочисленный массив. Метод должен вернуть новый массив, который получен путем
вытаскивания из исходного массива элементов, идущих после последней четверки. Входной
массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить
RuntimeException.
 */

/*
Пишем 2 метода: первый режет массив перед последней 4, второй после первой. Вдруг когда пригодится
 */
public class TrimArrayByNumber {

    public TrimArrayByNumber() {

    }

    /**
     *
     * @param intArr входной массив Integer
     * @param trimNumber число, весь массив до которого отрезаем/ если числа нет, то бросаем исключение
     * @return возвращаем массив Integer.
     */
    public Integer[] TrimBeforNumber(Integer[] intArr, int trimNumber){
        ArrayList<Integer>tmpList = new ArrayList<>();
        ArrayList<Integer> toDelete = new ArrayList<>();
        tmpList.addAll(0, Arrays.asList(intArr));

        int indexOfLast4 = tmpList.lastIndexOf(trimNumber);
        if(indexOfLast4 < 0)throw new RuntimeException();
        else{
            for(int i = 0; i < indexOfLast4; i++){
                toDelete.add(tmpList.get(i));
            }
            tmpList.removeAll(toDelete);
            return tmpList.toArray(new Integer[tmpList.size()]);
        }
    }
    /**
     *
     * @param intArr входной массив Integer
     * @param trimNumber число, весь массив после которого отрезаем/ если числа нет, то бросаем исключение
     * @return возвращаем массив Integer.
     */

    public Integer[] TrimAfterNumber(Integer[] intArr, int trimNumber){
        ArrayList<Integer>intList = new ArrayList<>();
        intList.addAll(0, Arrays.asList(intArr));

        ArrayList<Integer> toDelete = new ArrayList<>();

        int indexOf4 = intList.indexOf(trimNumber);
        if(indexOf4 < 0)throw new RuntimeException();
        else{
            for(int i = indexOf4; i < intList.size(); i++){
                toDelete.add(intList.get(i));
            }
            intList.removeAll(toDelete);
            return intList.toArray(new Integer[intList.size()]);
        }
    }
}
