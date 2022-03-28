import java.sql.SQLOutput;
import java.util.ArrayList;

public class WordsArrTest {
    public static void main(String[] args) {
        /*
        1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        Посчитать сколько раз встречается каждое слово.
         */
        //создаем массив слов прямо из текста задания :)
        String[] strArr = {"Массив","Массив","Строка","набор","должны","создать","встречаться","и","из","слов",
                            "найти","список","слов","из","массив","раз","раз","слово","каждое","сколько"};

        //загоняем все это в ArrayList<String> strList
        ArrayList<String> strList= new ArrayList<>(strArr.length);
        for(String str: strArr)
            strList.add(str);
        //создаем экземпляр класса StrArrayList
        StrArrayList arr = new StrArrayList(strList);
        //беспощадно выводим на печать
        System.out.println(arr);

        //создаем  книгу
        PhoneBook phoneBook = new PhoneBook();

        //создаем записи для книги
        PhoneBookItem item1 = new PhoneBookItem("Иванов");
        item1.setPhoneNumber("+7977223322");
        item1.setPhoneNumber("+7988223300");
        PhoneBookItem item2 = new PhoneBookItem("Cидорофф");
        item2.setPhoneNumber("+38 22345677");
        PhoneBookItem item3 = new PhoneBookItem("Уасечкинд");
        item3.setPhoneNumber("+835 123-33-2222");

        //вставляем записи в книгу
        phoneBook.set(item1);
        phoneBook.set(item2);
        phoneBook.set(item3);

        //ищем и печатаем запись
        PhoneBookItem foundItem = phoneBook.get("Иванов");
        System.out.println(foundItem);

        //печатаем всех!
        System.out.println(phoneBook);


    }
}
