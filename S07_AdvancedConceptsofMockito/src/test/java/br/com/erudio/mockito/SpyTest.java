package br.com.erudio.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class SpyTest {

    @Test
    void test() {
        // List<String> mockArrayList = mock(ArrayList.class);
        List<String> mockArrayList = spy (ArrayList.class);
        assertEquals(0, mockArrayList.size());
        
        when(mockArrayList.size()).thenReturn(5);
        mockArrayList.add("Foo Bar");
        assertEquals(5, mockArrayList.size());
        
    }

}
