package br.com.erudio.powermock;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.com.erudio.powermock.utils.UtilityClass;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
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
        
        mockStatic(UtilityClass.class);
        when(UtilityClass.myStaticMethod(anyLong())).thenReturn(150);
        
        sut.methodCallingAStaticMethod();
    }
}