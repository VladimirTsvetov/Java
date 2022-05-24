
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TrimArrayByNumberTest {

        private TrimArrayByNumber test;
        // тестируем boolean isTheSame(int[] checked, int mean1, int mean2)
        @BeforeEach
        public void init() {
            test = new TrimArrayByNumber();
        }

        @ParameterizedTest
        @MethodSource("dataForArrayOperation")
        public void testArrayOperation(Integer[] array, int trimNumber, Integer[] result) {
            Assertions.assertArrayEquals(result, test.TrimAfterNumber(array,trimNumber));

        }
        public static Stream<Arguments> dataForArrayOperation() {
            List<Arguments> out = new ArrayList<>();
            out.add(Arguments.arguments(new Integer[] { 1,2,3,4,5,4,7,8 }, 4, new Integer[]{1,2,3}));
            out.add(Arguments.arguments(new Integer[] { 1,2,3,0,5,-1,7,8 }, 4, new Integer[]{1,2,3})); //тут будет fail
            return out.stream();
        }

        @ParameterizedTest
        @MethodSource("dataForArrayTrimOperation")
        public void testArrayTrimOperation(Integer[] array, int trimNumber, Integer[] result) {
            Assertions.assertArrayEquals(result, test.TrimBeforNumber(array,trimNumber));
        }
        public static Stream<Arguments> dataForArrayTrimOperation() {
            List<Arguments> out = new ArrayList<>();
            out.add(Arguments.arguments(new Integer[] { 1,2,3,0,5,0,7,8 }, 4, new Integer[]{7,8})); // здесь будет fail
            out.add(Arguments.arguments(new Integer[] { 1,2,3,4,5,4,7,8 }, 4, new Integer[]{7,8}));
            return out.stream();
        }

        @Test
        public void testThrow(){
            Integer[] array = { 1,2,3,0,5,0,7,8 };
            //здесь вызовется исключение
            Assertions.assertThrows(RuntimeException.class,()->test.TrimBeforNumber(array,4));
        }



 }


