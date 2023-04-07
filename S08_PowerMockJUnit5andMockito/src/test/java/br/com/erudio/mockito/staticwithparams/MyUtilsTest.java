package br.com.erudio.mockito.staticwithparams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class MyUtilsTest {

    @Test
    void shouldMockStaticMethod() {

        try (MockedStatic<MyUtils> mockedStatic = Mockito.mockStatic(MyUtils.class)) {

            mockedStatic.when(() -> MyUtils.getWelcomeMessage(eq("Erudio"), anyBoolean())).thenReturn("Howdy Erudio!");

            String result = MyUtils.getWelcomeMessage("Erudio", false);

            assertEquals("Howdy Erudio!", result);
        }
    }
}
