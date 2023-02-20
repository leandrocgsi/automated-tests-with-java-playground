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
class SimpleMathTestS03 {
    
    SimpleMath math;
    
    @BeforeAll
    static void setup() {
        System.out.println("Running @BeforeAll method");
    }
    
    @AfterAll
    static void cleanup() {
        System.out.println("Running @AfterAll method");
    }
    
    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
        System.out.println("Running @BeforeEach method");
    }
    
    @AfterEach
    void afterEachMethod() {
        math = new SimpleMath();
        System.out.println("Running @AfterEach method");
    }
    
    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @DisplayName("Test 6.2 + 2 = 8.2")
    @Test
    void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEigthDotTwo() {
        
        System.out.println("Test 6.2 + 2 = 8.2");
        
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        double expectedResult = 8.2D;
        
        Double result = math.sum(firstNumber, secondNumber);
        assertEquals(expectedResult, result,
            () -> firstNumber + "+" + secondNumber + " did not produce " + expectedResult + "!");
    }
    
    //@Disabled
    @DisplayName("Division by Zero")
    @Test
    void testSubtraction_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticExcetion() {
        System.out.println("Division by Zero");
        //fail();
        
        // given
        double firstNumber = 6.2D;
        double secondNumber = 0D;
        
        var expectedExceptionMessage = "Impossible to divide by zero";
        
        // when & then
        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
            //when
            math.division(firstNumber, secondNumber);
        }, () -> "Division by Zero should have throw an ArithmeticException");

        // then
        assertEquals(
            expectedExceptionMessage,
            actualException.getMessage(),
            () -> "Unexpected exception message!");
    }
    
    @DisplayName("Test 6.2 - 2 = 4.2")
    @Test
    void testSubtraction() {
        System.out.println("Test 6.2 - 2 = 4.2");
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        double expectedResult = 4.2D;
        
        Double result = math.subtraction(firstNumber, secondNumber);
        assertEquals(expectedResult, result,
            () -> firstNumber + "-" + secondNumber +" did not produce " + expectedResult+ "!");
    }
    
    @DisplayName("Test 6.2 * 2 = 12.4")
    @Test
    void testMultiplication() {
        System.out.println("Test 6.2 * 2 = 12.4");
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        double expectedResult = 12.4D;
        
        Double result = math.multiplication(firstNumber, secondNumber);
        assertEquals(expectedResult, result,
            () -> firstNumber + "*" + secondNumber + " did not produce " + expectedResult + "!");
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
    
    @DisplayName("Test (6.2 + 2) / 2 = 4.1")
    @Test
    void testMeam() {

        System.out.println("Test (6.2 + 2) / 2 = 4.1");
        
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        double expectedResult = 4.1D;
        
        Double result = math.mean(firstNumber, secondNumber);
        assertEquals(expectedResult, result,
            () -> "(" + firstNumber + "+" + secondNumber + ")/" + secondNumber + " did not produce " + expectedResult + "!");
    }
    
    @DisplayName("Test Square Root of 81 = 9")
    @Test
    void testSquareRoot() {

        System.out.println("Test Square Root of 81 = 9");
        
        double number = 81D;
        double expected = 9D;
        
        Double result = math.squareRoot(number);
        assertEquals(expected, result,
            () -> "Square Root of "+ number + " did not produce "+ expected + "!");
    }
    
    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @DisplayName("Test 6.2 + 2 = 8.2")
    @Test
    void testSum_When_XYZ_Should1() {
        // Given / Arrange
        
        // When / Act
        
        // Then / Assert
    }
    
    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @DisplayName("Test 6.2 + 2 = 8.2")
    @Test
    void testSum_When_XYZ_Should() {
        // Given / Arrange

        // When / Act

        // Then / Assert
    }
}