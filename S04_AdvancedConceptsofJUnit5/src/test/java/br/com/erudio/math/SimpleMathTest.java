package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

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
    //@MethodSource()
    /**
    @CsvSource({
        "Pelé, Football",
        "Senna, F1",
        "Keith Moon, ''"
    })
    
    @CsvSource({
        "6.2, 2, 3.1",
        "71, 14, 57",
        "18.3, 3.1, 14.9"
    })*/
    @CsvFileSource(resources = "/testDivision.csv")
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

    /*
    public static Stream<Arguments> testDivision() {
    //public static Stream<Arguments> testDivisionInputParameters() {
        return Stream.of(
            Arguments.of(6.2D, 2D, 3.1D),
            Arguments.of(71D, 14D, 57D),
            Arguments.of(18.3, 3.1D, 14,9D)
        );
    }
    */
}