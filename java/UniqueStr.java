public class UniqueStr {
    private String str;
    private int number;

    @Override
    public String toString() {
        return "Слово: " + str + " встречается " + number + " раз";
    }

    public String getStr() {
        return str;
    }

    public int getNumber() {
        return number;
    }

    public UniqueStr(String str, int number) {
        this.str = str;
        this.number = number;
    }
}
