public class TreedArray {
    public static void main(String[] args) {
        oneArrayWork();
        splitArrayWork();
    }

    public static void oneArrayWork(){
        final int  size = 10_000_000;
        float[] sourceArr = new float[size];
        /**
         * Запускаем последовательное измененеие значений массива
         * по формуле arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
         * Math.cos(0.4f + i / 2));
         * перед началом запускаем секундомер
         */
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            sourceArr[i] = (float)(sourceArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        System.out.println("Время перебора сплошного массива: " + (System.currentTimeMillis() - startTime) + " мc");
    }

    public static void splitArrayWork(){
        final int  size = 10_000_000;
        float[] sourceArr = new float[size];
        /**
         * разделяем массив на пополам
         */
        float[] leftHalf = new float[size/2];
        float[] rightHalf = new float[size/2];

        long startTime = System.currentTimeMillis();
        System.arraycopy(sourceArr, 0, leftHalf, 0, size/2);
        System.arraycopy(sourceArr, size/2, rightHalf, 0, size/2);
        /**
         * создаем объекты потоков для перебора левой и правой частей
         */
        Thread trLeft = new Thread(()->{
            for (int i = 0; i < size/2; i++) {
                leftHalf[i] = (float)(leftHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
        });
        Thread trRight = new Thread(()->{
            for (int i = 0; i < size/2; i++) {
                rightHalf[i] = (float)(rightHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
        });
        /**
         * запускаем потоки
         */
        trLeft.start();
        trRight.start();
        try {
            trLeft.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            trRight.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * собираем массив обратно
         */

        float[] mergedArray = new float[size];
        System.arraycopy(leftHalf, 0, mergedArray, 0, size/2);
        System.arraycopy(rightHalf, 0, mergedArray, size/2, size/2);
        System.out.println("Время перебора половинок массива: " + (System.currentTimeMillis() - startTime) + " мc");

    }

}
