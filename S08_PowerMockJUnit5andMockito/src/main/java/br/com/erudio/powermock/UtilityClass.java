package br.com.erudio.powermock;

public class UtilityClass {
    
    public static int myStaticMethod(long value) {
        // Some complex logic is done here...
        throw new RuntimeException(
            "I dont want to be executed. I will anyway be mocked out.");
    }
}