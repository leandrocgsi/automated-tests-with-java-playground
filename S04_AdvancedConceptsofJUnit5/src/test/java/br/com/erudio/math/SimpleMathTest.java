package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTest {
    
    SimpleMath math;
    
    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
    }

    @DisplayName("Test double subtraction [firstNumber, secondNumber, expectedResult]")
    //@Test
    @ParameterizedTest
    //@MethodSource("testDivisionInputParameters")
    @MethodSource()
    void testDivision(
            double firstNumber,
            double secondNumber,
            double expectedResult) {
        
        System.out.println("Test " + firstNumber +
                " / " + secondNumber + " = " + expectedResult + "");
        
        Double result = math.division(firstNumber, secondNumber);
        assertEquals(expectedResult, result, 100D,
            () -> firstNumber + "/" + secondNumber + " did not produce " + expectedResult + "!");
    }

    public static Stream<Arguments> testDivision() {
    //public static Stream<Arguments> testDivisionInputParameters() {
        return Stream.of(
            Arguments.of(6.2D, 2D, 3.1D),
            Arguments.of(71D, 14D, 57D),
            Arguments.of(18.3, 3.1D, 14,9D)
        );
    }
}