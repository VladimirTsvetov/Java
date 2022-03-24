public class MyArrayDataException extends NumberFormatException{
    private int i;
    private int j;

    public MyArrayDataException(int i, int j) {

        this.i = i;
        this.j = j;
    }
    public String toString(){
        return "MyArrayDataException: wrong data type in source array[" + i + "]" + "[" + j + "]";
    }

}
