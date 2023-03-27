package br.com.erudio.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ListTest {

    @Test
    public void mockingListSizeTest() {
        List list = mock(List.class);
        when(list.size()).thenReturn(10);
        assertEquals(10, list.size());
        assertEquals(10, list.size());
        assertEquals(10, list.size());
    }

    @Test
    public void mockingListSize_withMultipleReturnValues() {
        List list = mock(List.class);
        when(list.size()).thenReturn(10).thenReturn(20);
        assertEquals(10, list.size()); // First Call
        assertEquals(20, list.size()); // Second Call
    }

    @Test
    public void mockingListGet() {
        List<String> list = mock(List.class);
        when(list.get(0)).thenReturn("Erudio");
        assertEquals("Erudio", list.get(0));
        assertNull(list.get(1));
    }

    @Test
    public void mockingListGet_withAny() {
        List<String> list = mock(List.class);
        when(list.get(Mockito.anyInt())).thenReturn("Erudio");
        // If you are using argument matchers, all arguments
        // have to be provided by matchers.
        assertEquals("Erudio", list.get(0));
        assertEquals("Erudio", list.get(1));
    }
    
    @Test
    public void mockingList_throwAnException() {
        List<String> list = mock(List.class);
        when(list.get(Mockito.anyInt())).thenThrow(new RuntimeException("Foo Bar!!"));
        // If you are using argument matchers, all arguments
        // have to be provided by matchers.
        assertThrows(RuntimeException.class, () -> {
            list.get(0);
        }, () -> "Should have throw an RuntimeException");
    }
}