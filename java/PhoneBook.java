import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String,PhoneBookItem> book;

    public PhoneBook() {
        book = new HashMap<>();
    }

    public void set(PhoneBookItem item){
        book.put(item.getName(),item);
    }
    public PhoneBookItem get(String name){
        if(book.containsKey(name))
            return book.get(name);
        else return null;
    }
    public String toString(){
        StringBuilder outstr = new StringBuilder();
        for(Map.Entry<String,PhoneBookItem> entry : book.entrySet()){
            outstr.append(entry.getValue().toString() + '\n');
        }
        return outstr.toString();
    }
}
