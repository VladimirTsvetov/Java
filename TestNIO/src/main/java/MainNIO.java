import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;


public class MainNIO {
    public static void main(String[] args) throws IOException {
        printAllWordsInColumn();
    }
    public static void printAllWordsInColumn()throws IOException{
        Path dir = Path.of("src");
        // создаем объект типа File из абсолютного пути к его каталогу и имени файла
        //File file = new File(dir.toAbsolutePath() + "\\" + "7.txt");
        Files.lines(Path.of(dir.toAbsolutePath() + "\\" + "7.txt")) // используем статический метод lines() для построчного чтения
                .flatMap(str-> Stream.of(str.split("\\s+")))       // преобразуем в отдельные потоки (разделяем строки по знаку конца строки)
                .map(String::toLowerCase)
                .map(word->word.replaceAll("[^А-Яа-я\\d]+","")) // убираем все, кроме русских букв и цифр
                .filter(StringUtils::isNotBlank)                          // ну тут понятно
                .forEachOrdered(System.out::println);                     // для каждого элемента печатаем значение. Передаем ссылку на метод
        //System.out.println(dir.toAbsolutePath() + "\\" + "7.txt");

    }


}
