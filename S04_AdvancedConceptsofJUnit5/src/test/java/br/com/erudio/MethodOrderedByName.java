package br.com.erudio;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@Order(2)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedByName {

    @Test
    @Order(1)
    void testC() {
        System.out.println("Runnig Test C");
    }
    
    @Test
    @Order(2)
    void testD() {
        System.out.println("Runnig Test D");
    }
    
    @Test
    @Order(3)
    void testA() {
        System.out.println("Runnig Test A");
    }
    
    @Test
    @Order(4)
    void testB() {
        System.out.println("Runnig Test B");
    }
}