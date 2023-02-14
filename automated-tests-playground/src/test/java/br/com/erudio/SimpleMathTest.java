package br.com.erudio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.erudio.math.SimpleMath;

class SimpleMathTest {

    @Test
    void testDivision() {
    	
    	SimpleMath math = new SimpleMath();
        Double result = math.division(6.2D, 2D);
        assertEquals(3.1D, result);
    }

}
