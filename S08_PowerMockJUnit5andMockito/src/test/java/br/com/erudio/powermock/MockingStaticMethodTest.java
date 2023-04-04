package br.com.erudio.powermock;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.erudio.powermock.utils.UtilityClass;

@ExtendWith(MockitoExtension.class)
public class MockingStaticMethodTest {
    
    // Use a specific Extension
    // Initialize UtilityClass
    // Do your mocks
    
    @Mock
    Dependency dependency;
    
    @InjectMocks
    SystemUnderTest sut;

    @BeforeEach
    void setup() {
        // Given / Arrange
    }
    
    @Test
    void testMockingStaticMethod() {
        
        // Given / Arrange
        List<Integer> stats =  Arrays.asList(1,2,3);
        when(dependency.retrieveAllStats()).thenReturn(stats);
        
        when(UtilityClass.staticMethod(5)).thenReturn(127);
            
        // When / Act
        sut.methodCallingAStaticMethod();
        
        // Then / Assert 
    }
}