package roman;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumeralsTest {

    @ParameterizedTest
    @MethodSource("testNumeralsSource")
    void testNumerals(String roman, int arabic) {
        RomanNumeral num = new RomanNumeral(roman);
        assertEquals(arabic, num.toInt());
    }

    private static Stream<Arguments> testNumeralsSource() {
        return Stream.of(
                Arguments.of("I", 1),
                Arguments.of("II", 2),
                Arguments.of("III", 3),
                Arguments.of("IV", 4),
                Arguments.of("V", 5),
                Arguments.of("VI", 6),
                Arguments.of("IIX", 8),
                Arguments.of("VIII", 8),
                Arguments.of("IX", 9),
                Arguments.of("X", 10),
                Arguments.of("L", 50),
                Arguments.of("XXC", 80),
                Arguments.of("LXXX", 80),
                Arguments.of("C", 100),
                Arguments.of("D", 500),
                Arguments.of("M", 1000),
                Arguments.of("MDCCCCLXXXIIII", 1984),
                Arguments.of("MMXX", 2020)
        );
    }
}