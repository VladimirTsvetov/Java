import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CheckIsAllTheSameTest {
    private CheckIsAllTheSame test;
    // тестируем boolean isTheSame(int[] checked, int mean1, int mean2)
    @BeforeEach
    public void init() {
        test = new CheckIsAllTheSame();
    }

        @ParameterizedTest
        @MethodSource("dataForIsTheSameperation")
        public void testIsTheSameperation(int[] array, int first, int second, boolean result) {
        Assertions.assertEquals(result, test.isTheSame(array,first,second));
    }
    public static Stream<Arguments> dataForIsTheSameperation() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] { 1, 1, 1, 4 }, 1, 4, true));
        out.add(Arguments.arguments(new int[] { 1, 2, 3, 4 }, 1, 4, false));
        out.add(Arguments.arguments(new int[] { 1, 1, 1, 1 }, 1, 4, false));
        out.add(Arguments.arguments(new int[] { 4, 4, 4, 4 }, 1, 4, false));
        return out.stream();
    }
}