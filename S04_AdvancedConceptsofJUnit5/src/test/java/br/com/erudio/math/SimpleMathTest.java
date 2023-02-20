package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTest {
    
    SimpleMath math;
    
    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
        System.out.println("Running @BeforeEach method");
    }

    @DisplayName("Test 6.2 / 2 = 3.1")
    @Test
    void testDivision() {
        System.out.println("Test 6.2 / 2 = 3.1");
        
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        double expectedResult = 3.1D;
        
        Double result = math.division(firstNumber, secondNumber);
        assertEquals(expectedResult, result,
            () -> firstNumber + "/" + secondNumber + " did not produce " + expectedResult + "!");
    }

}