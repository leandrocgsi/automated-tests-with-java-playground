package br.com.erudio;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

//@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class ArraysCompareTest {

    @Test
    void testArraysSort() {
        int[] numbers = {12,3,4,1};
        int[] expectedArray = {1,3,4,12};
        
        Arrays.sort(numbers);
        assertArrayEquals(numbers, expectedArray);
    }

    @Test
    //@Timeout(1)
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void testSortPerformance() {
        int array[] = {9,16,7,22};
        for (int i = 0; i < 100000000; i++) {
            array[0] = i;
            Arrays.sort(array);
        }
    }

}
