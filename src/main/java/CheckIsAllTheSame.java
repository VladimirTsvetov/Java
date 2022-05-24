import java.util.ArrayList;
import java.util.Arrays;
/*проверяем массив на соответствие условию:
    Если в нем нет хоть одной четверки или единицы, то метод вернет false;
    [ 1 1 1 4 4 1 4 4 ] -> true
    [ 1 1 1 1 1 1 ] -> false
    [ 4 4 4 4 ] -> false
    [ 1 4 4 1 1 4 3 ] -> false
*/

public class  CheckIsAllTheSame {


    public CheckIsAllTheSame() {

    }

    public boolean isTheSame(int[] checked, int mean1, int mean2){
        int count1 = 0;
        int count2 = 0;
        if(mean1 == mean2)return false;
        for(int t: checked) {
            if((t == mean1 || t == mean2) == false)return false;
            if(t == mean1)count1++;
            else count2++;
        }
        if(count1 == checked.length || count2 == checked.length)return false;
        return true;
    }


}
