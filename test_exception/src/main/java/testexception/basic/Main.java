package testexception.basic;

public class Main {
    public static void main(String[] args) {

        int res;
        try{
            res= Execut.execution(10,0);
            System.out.println("Бла-бла-бла");  //это не будет напечатано
        }
        catch(ArithmeticException ex){
            System.out.println("Сработало исключение " + ex.toString());
            res = 0;
        }
        catch (MyException ex){
            System.out.println("Сработало исключение " + ex.toString());
            res = 0;
        }
        finally {
            System.out.println(" Финальный блок ");
        }

        System.out.println(res);
    }
}
