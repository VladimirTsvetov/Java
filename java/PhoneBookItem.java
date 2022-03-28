import java.util.ArrayList;

public class PhoneBookItem {
    private ArrayList<String> phoneNumber;
    private String name;
    private int itemCounter;

    public ArrayList<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.add(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhoneBookItem(String name) {
        this.name = name;
        this.itemCounter = 0;
        phoneNumber = new ArrayList<>(10);
    }
    public String toString(){
        return "номера абонента " + this.getName() + phoneNumber.toString();
    }
}
