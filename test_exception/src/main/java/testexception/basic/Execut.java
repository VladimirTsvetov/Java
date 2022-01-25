package testexception.basic;

public class Execut {
    public static int execution(int numerator,int denominator) throws MyException{

        if(numerator < 0)throw new MyException("Введено значение числителя меньше нуля");
        if(denominator == 0)throw new MyException("Введено значение знаменателя = 0");
        return numerator/denominator;
    }
}
