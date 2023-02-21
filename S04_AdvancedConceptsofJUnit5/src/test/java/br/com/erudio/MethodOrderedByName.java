package br.com.erudio;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class MethodOrderedByName {

    @Test
    void testC() {
        System.out.println("Runnig Test C");
    }
    
    @Test
    void testD() {
        System.out.println("Runnig Test D");
    }
    
    @Test
    void testA() {
        System.out.println("Runnig Test A");
    }
    
    @Test
    void testB() {
        System.out.println("Runnig Test B");
    }
}