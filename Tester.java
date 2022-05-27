import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Set;

public class Tester {
    public static void start(Class<?> tClass) {
        int beforeCount = 0;
        int afterCount = 0;
        DistanceConverter dc = null;
        HashMap<Integer, String> methodNames = new HashMap<>();

        try {
            dc = (DistanceConverter) tClass.getConstructor().newInstance();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        Method[] methods = tClass.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            try {
                methods[i] = tClass.getDeclaredMethod(methods[i].getName(), double.class);
                if (methods[i].isAnnotationPresent(BeforeSuite.class)) {
                    if (beforeCount != 0) throw new RuntimeException("BeforeSuit calling twice");
                    else {
                        methodNames.put(0, methods[i].getName());
                        beforeCount++;
                    }
                }
                if (methods[i].isAnnotationPresent(AfterSuite.class)) {
                    if (afterCount != 0) throw new RuntimeException("BeforeSuit calling twice");
                    else {
                        methodNames.put(11, methods[i].getName());
                        afterCount++;
                    }
                }
                if (methods[i].isAnnotationPresent(Test.class)) {
                    methodNames.put(i+1, methods[i].getName());
                }

            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        //*******************************************************************
        Set<Integer> keySet= methodNames.keySet();
        Integer[] indexes = keySet.toArray(new Integer[keySet.size()]);


        for (int i = 0; i < methodNames.size(); i++){
            try {
                String name = methodNames.get(indexes[i]);
                Method meth = tClass.getDeclaredMethod(name, double.class);
                System.out.println(name + "= " + meth.invoke(dc, 5.0));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
