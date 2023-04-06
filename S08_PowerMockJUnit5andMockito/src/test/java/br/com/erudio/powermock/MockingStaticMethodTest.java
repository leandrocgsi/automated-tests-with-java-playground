package br.com.erudio.powermock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.erudio.powermock.utils.UtilityClass;

@ExtendWith(MockitoExtension.class)
public class MockingStaticMethodTest {
    
    // Use a specific Extension
    // Initialize UtilityClass
    // Do your mocks
    
    @Mock
    Dependency dependency;
    
    //@InjectMocks
    SystemUnderTest sut;
    
    @BeforeEach
    public void setup() {
        sut = new SystemUnderTest();
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void testMockingStaticMethod() {
        
        // Given / Arrange
        List<Integer> stats =  Arrays.asList(1,2,3);
        when(dependency.retrieveAllStats()).thenReturn(stats);
        
        try (MockedStatic<UtilityClass> mockedStatic = mockStatic(UtilityClass.class, Mockito.RETURNS_MOCKS)) {
            mockedStatic.when(() -> UtilityClass.myStaticMethod(5))
                .thenReturn(12);
            
            // When / Act
            int result = sut.methodCallingAStaticMethod();
            
            // Then / Assert 
            assertEquals(12, result);
        }
    }
}