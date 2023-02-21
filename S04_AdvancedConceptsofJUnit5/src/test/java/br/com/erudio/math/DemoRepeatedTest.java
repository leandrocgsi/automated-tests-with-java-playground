package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class DemoRepeatedTest {

    SimpleMath math;

    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
        System.out.println("Running @BeforeEach method");
    }
    
    @RepeatedTest(value = 3, name = "{displayName}. Repetition "
        + "{currentRepetition} of {totalRepetitions}")
    @DisplayName("Division by Zero")
    void testSubtraction_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticExcetion(
            RepetitionInfo repetitionInfo,
            TestInfo testInfo
        ) { 
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
        System.out.println(
            "Repetition N° " + repetitionInfo.getCurrentRepetition() +
             " of " + repetitionInfo.getTotalRepetitions());
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
}

