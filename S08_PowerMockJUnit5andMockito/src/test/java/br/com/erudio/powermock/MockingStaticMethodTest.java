package br.com.erudio.powermock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
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
    
    @Test
    void testMockingStaticMethod() {
        
        // Given / Arrange
        List<Integer> stats =  Arrays.asList(1,2,3);
        when(dependency.retrieveAllStats()).thenReturn(stats);
        
        try (MockedStatic<UtilityClass> utilities = mockStatic(UtilityClass.class)) {
            utilities.when(() -> UtilityClass.staticMethod(5))
                .thenReturn(127);
            
            // When / Act
            int result = sut.methodCallingAStaticMethod();
            
            // Then / Assert 
            assertEquals(127, result);
        }
    }
}