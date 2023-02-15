package br.com.erudio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.erudio.math.SimpleMath;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTest {
	
	// test[System Under Test]_[Condition or State Change]_[Expected Result]
	@DisplayName("Test 6.2 + 2 = 8.2")
	@Test
	void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEigthDotTwo() {
		
		SimpleMath math = new SimpleMath();
		
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		double expectedResult = 8.2D;
		
		Double result = math.sum(firstNumber, secondNumber);
		assertEquals(expectedResult, result,
			() -> firstNumber + "+" + secondNumber + " did not produce " + expectedResult + "!");
	}
	
	@DisplayName("Division by Zero")
	@Test
	void testSubtraction_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticExcetion() {
		fail();
	}
	
	@DisplayName("Test 6.2 - 2 = 4.2")
	@Test
	void testSubtraction() {
		
		SimpleMath math = new SimpleMath();
		
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
		
		SimpleMath math = new SimpleMath();
		
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
		
		SimpleMath math = new SimpleMath();
		
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
		
		SimpleMath math = new SimpleMath();
		
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
		
		SimpleMath math = new SimpleMath();
		
		double number = 81D;
		double expected = 9D;
		
		Double result = math.squareRoot(number);
		assertEquals(expected, result,
			() -> "Square Root of "+ number + " did not produce "+ expected + "!");
	}
}