package roman;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RomanNumeralsTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testWithArgumentsAccessor(String roman, int arabic) {
        int i = new RomanNumerals(roman).fromRoman();
        assertEquals(arabic, i);
    }

    static Stream<Arguments> testDataProvider() {
        return Stream.of(
                arguments("I", 1),
                arguments("II", 2),
                arguments("IV", 4),
                arguments("V", 5),
                arguments("VII", 7),
                arguments("XIX", 19),
                arguments("XX", 20),
                arguments("L", 50),
                arguments("MCM",1900),
                arguments("MCMXII",1912)
                );
    }
}