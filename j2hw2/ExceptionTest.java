public class ExceptionTest {
    public static void main(String[] args) {
        //правильный массив
        String[][] intArr = {{"1","2","3","4"},
                             {"5","6","7","8"},
                             {"9","0","1","2"},
                             {"9","8","7","6"}};
        //кривой массив
        String[][] brokenArr = {{"1","2","3","4"},
                                {"5","6","буэ","8"},
                                {"9","0","1","2"},
                                {"9","8","7","6"}};
        //несоразмерный массив
        String[][] unsizebleArr = {{"1","2","3"},
                                    {"5","6","5"},
                                    {"9","0","1"},
                                    {"9","8","7"}};
        //создаем объект
        AcceptArray accept = new AcceptArray(16);
        try {
            System.out.println("Сумма элементов массива равна " + accept.summArray(intArr));
        }catch (MyArrayDataException e){
            System.out.println(e);
        }catch (MyArraySizeException e){
            System.out.println(e);
        }finally {
            System.out.println("Работает!");
        }
        //сбрасываем сумму
        accept.reSetSum();
        //передаем кривой массив
        try {
            System.out.println(accept.summArray(brokenArr));
        }catch (MyArrayDataException e){
            System.out.println(e);
        }catch (MyArraySizeException e){
            System.out.println(e);
        }finally {
            System.out.println("Работает!");
        }
        //сбрасываем сумму
        accept.reSetSum();
        //передаем массив неправильного размера
        try {
            System.out.println(accept.summArray(unsizebleArr));
        }catch (MyArrayDataException e){
            System.out.println(e);
        }catch (MyArraySizeException e){
            System.out.println(e);
        }finally {
            System.out.println("Работает!");
        }

    }
}
