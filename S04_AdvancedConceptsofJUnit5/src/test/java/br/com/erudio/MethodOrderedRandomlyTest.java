package br.com.erudio;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@Order(1)
@TestMethodOrder(MethodOrderer.Random.class)
public class MethodOrderedRandomlyTest {

    @Test
    void testA() {
        System.out.println("Runnig Test A");
    }
    
    @Test
    void testB() {
        System.out.println("Runnig Test B");
    }
    
    @Test
    void testC() {
        System.out.println("Runnig Test C");
    }
    
    @Test
    void testD() {
        System.out.println("Runnig Test D");
    }
}