public class MyArraySizeException extends ArrayIndexOutOfBoundsException{
    private int sizeArray;

    public MyArraySizeException(int sizeArray) {
        this.sizeArray = sizeArray;
    }
    public String toString(){
        return "MyArraySizeException: несоответствующий размер массива == " + sizeArray;
    }
}
