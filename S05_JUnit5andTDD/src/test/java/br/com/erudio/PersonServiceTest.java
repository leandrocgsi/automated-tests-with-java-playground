package br.com.erudio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.erudio.model.Person;

public class PersonServiceTest {
    
    Person person;
    
    @BeforeEach
    void setup() {
        person = new Person
            ("Keith",
             "Moon",
             "kmoon@erudio.com.br",
             "Wembley - UK",
             "Male");
    }

    @DisplayName("When Create Person with Success Should Return a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {
        // Given / Arrange
        IPersonService service = new PersonService();
         
        // When / Act
        Person actual = service.createPerson(person);
        
        // Then / Assert
        assertNotNull(actual, () -> "The createPerson() should not have returned null!");
    }
    
    @DisplayName("When Create Person with Success Should Contains FirstName in Returned Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsFirstNameInReturnedPersonObject() {
        // Given / Arrange
        IPersonService service = new PersonService();
        
        // When / Act
        Person actual = service.createPerson(person);
        
        // Then / Assert
        assertEquals(person.getFirstName(), actual.getFirstName(), () -> "The Person FirstName is Incorrect");
        assertEquals(person.getLastName(), actual.getLastName(), () -> "The Person LastName is Incorrect");
        assertEquals(person.getAddress(), actual.getAddress(), () -> "The Person Address is Incorrect");
        assertEquals(person.getGender(), actual.getGender(), () -> "The Person Gender is Incorrect");
        assertEquals(person.getEmail(), actual.getEmail(), () -> "The Person e-Mail is Incorrect");
        assertNotNull(person.getId(), () -> "Person ID is Missing");
    }
    
    @DisplayName("When Create Person with null e-Mail Should throw Exception")
    @Test
    void testCreatePerson_WhithNullEMail_ShouldThrowIllegalArgumentException() {
        // Given / Arrange
        IPersonService service = new PersonService();
        person.setEmail(null);
        
        var expectedMessage = "The Person e-Mail is null or empty!";
        
        // When / Act & Then / Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> service.createPerson(person),
            () -> "Empty e-Mail should have cause an IllegalArgumentException!");
        
        // Then / Assert
        assertEquals(
            expectedMessage,
            exception.getMessage(),
            () -> "Exception error message is incorrect!");
    }
}