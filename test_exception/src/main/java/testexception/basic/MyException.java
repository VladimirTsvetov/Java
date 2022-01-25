package testexception.basic;

public class MyException extends Throwable {
    private String errMsg;
    public MyException(String message){
        errMsg = message;
    }
    public String getErrMsg() {
        return errMsg;
    }
    public String toString(){
        return getErrMsg();
    }
}
