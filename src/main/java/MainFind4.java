import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class MainFind4 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        //ArrayList<Integer> trimList = new ArrayList<>();
        //ArrayList<Integer> trimAfter = new ArrayList<>();

        Integer[] arr = {1,2,3,4,5,4,7,8};
        int[] arr14 = {4,1,4,4,1,4,4,4};

        System.out.print("Mассив до стрижки: ");
        for(Integer i: arr)System.out.print(i + ", ");
        System.out.println();

        TrimArrayByNumber trmArr = new TrimArrayByNumber();
        //отрезаем и выкидываем часть массива перед последней 4
        try {
            Integer[] trimList = trmArr.TrimBeforNumber(arr,4);
            System.out.print("Mассив после последней 4: ");
            for(Integer i: trimList)System.out.print(i + ", ");
            System.out.println();

        }catch (RuntimeException e){
            System.out.println("Нет 4, совсем нет!");
            System.out.println(e.getStackTrace());
        }

        //отрезаем  и выкидываем массив после первой 4
        try {
            Integer[] trimAfter = trmArr.TrimAfterNumber(arr,4);
            System.out.print("Mассив до первой 4: ");
            for(Integer i: trimAfter)System.out.print(i + ", ");
            System.out.println();
        }catch(RuntimeException e){
            System.out.println("Нет 4, совсем нет!");
            System.out.println(e.getStackTrace());
        }
        /*проверяем массив на соответствие условию:
            Если в нем нет хоть одной четверки или единицы, то метод вернет false;
            на самом деле можно проверять два любых не равных дург другу инта :)
         */
        int mean1 = 1;
        int mean2 = 4;
        CheckIsAllTheSame checkIsAllTheSame = new CheckIsAllTheSame();
        System.out.println("Проверяем массив: на соответствие условию");
        boolean res = checkIsAllTheSame.isTheSame(arr14,mean1,mean2);
        System.out.println("Результат проверки = " + res);


    }
}
