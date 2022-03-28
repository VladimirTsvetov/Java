import java.util.ArrayList;
//import java.util.HashSet;

public class StrArrayList {
    private ArrayList<UniqueStr> ustrArr;
    private ArrayList<String> strArr;
    private final int allWords;

    /**
     * Конструктор класа получает на вход ArrayList<String> strArrIn
     * Создает пустой ArrayList<UniqeString> ustrArr
     * вызывает SortArray() для обработки входного массива
     * @param strArrIn
     */
    public StrArrayList(ArrayList<String> strArrIn) {
        //создаем массив уникальных строк
        ustrArr = new ArrayList<>(strArrIn.size());
        strArr = (ArrayList<String>) strArrIn.clone();
        allWords = strArr.size();
        strArrIn.clear();
        SortArray();
    }

    /**
     * void SortArray() перебирает все строки входного массива
     * если слово уже встречалось, то оно удаляется из списка,
     * счетчик count увеличивается на 1
     */
    private void SortArray(){
        int count = 1;

        StringBuilder strTest = new StringBuilder();

        for(int i = 0; i < strArr.size();i++){
           strTest.append(strArr.get(i));
           for(int j = i+1; j < strArr.size();j++){
               if (strTest.toString().equals(strArr.get(j))){
                   strArr.remove(j);
                   ++count;
               }
           }
           ustrArr.add(new UniqueStr(strTest.toString(),count));
           count = 1;
           strTest.replace(0,strTest.length(),"");
         }
    }

    public String toString(){
        StringBuilder outstr = new StringBuilder();
        outstr.append("Список слов содержит: " + '\n');
        for(UniqueStr ustr: ustrArr) {
            if(ustr.getNumber() > 0)
                outstr.append(ustr.toString() + '\n');
        }
        outstr.append("Всего уникальных слов " + ustrArr.size() + " из " + allWords);
        return outstr.toString();
    }
}
