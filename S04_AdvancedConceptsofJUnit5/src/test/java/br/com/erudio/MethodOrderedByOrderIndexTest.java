package br.com.erudio;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

//@Order(3)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedByOrderIndexTest {
    
    StringBuilder completed = new StringBuilder("");
    
    @AfterEach
    void afterEach() {
        System.out.println("The state of instance is: " + completed);
    }

    @Test
    @Order(1)
    void testC() {
        System.out.println("Runnig Test C");
        completed.append("1");
    }
    
    @Test
    @Order(2)
    void testD() {
        System.out.println("Runnig Test D");
        completed.append("2");
    }
    
    @Test
    @Order(3)
    void testA() {
        System.out.println("Runnig Test A");
        completed.append("3");
    }
    
    @Test
    @Order(4)
    void testB() {
        System.out.println("Runnig Test B");
        completed.append("4");
    }
}