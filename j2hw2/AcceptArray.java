public class AcceptArray {

    private Integer summ;
    private String[][] destArr;
    private int maxsize;

    public AcceptArray(int maxsize) {
        this.maxsize = maxsize;
        summ = new Integer(0);
    }

    /**
     * сбрасываем сумму в ноль
     */
    public void reSetSum(){
        if(summ != null)summ = 0;
    }

    /**
     * проверяем размер массива на соотвтетсвие
     * @param sourceArr
     * @return размер массива
     * @throws MyArraySizeException
     */
    private int checkArrSize(String[][] sourceArr) throws MyArraySizeException{
        int sizeofarr = 0;
        for(String[] arr: sourceArr)
            sizeofarr+=arr.length;
        if(sizeofarr != maxsize)
            throw new MyArraySizeException(sizeofarr);
        return sizeofarr;
    }

    /**
     * находим сумму всех элементов массива, если не соответствие типа,
     * то выбрасываем исключение
     * @param sourceArr
     * @return
     */
    public int summArray(String[][] sourceArr){
        try {
            int arrSize = checkArrSize(sourceArr);
        }
        catch (MyArraySizeException e){
            throw e;
        }
        //если массив нужного размера, то обрабатываем его
        int i = 0; //номер строки
        int j = 0; //номер столбца
        for(String[] strarr: sourceArr){
            for(String str: strarr){
                try{
                    summ+=Integer.parseInt(str);
                    ++j;
                }catch (NumberFormatException e){
                    throw new MyArrayDataException(i,j);
                }
            }
            ++i;
        }

        return summ.intValue();
    }
}
