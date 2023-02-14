package br.com.erudio;

import static org.junit.jupiter.api.Assertions.assertEquals;
 
import org.junit.jupiter.api.Test;

import br.com.erudio.math.SimpleMath;

class SimpleMathTest {
	
	@Test
	void testSum() {
		
		SimpleMath math = new SimpleMath();
		
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		double expectedResult = 8.2D;
		
		Double result = math.sum(firstNumber, secondNumber);
		assertEquals(expectedResult, result,
			() -> firstNumber + "+" + secondNumber + " did not produce " + expectedResult + "!");
	}
	
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