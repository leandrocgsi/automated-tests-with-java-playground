package br.com.erudio.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServicesTest {

    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonServices service;

    private Person person;

    @BeforeEach
    public void setup(){
        //personRepository = Mockito.mock(PersonRepository.class);
        //personService = new PersonServiceImpl(personRepository);
        person = new Person(
                1L,
                "Leandro",
                "Costa",
                "leandro@erudio.com.br",
                "Uberlândia - Minas Gerais - Brasil",
                "Male"
            );
    }

    // JUnit test for savePerson method
    @DisplayName("JUnit test for savePerson method")
    @Test
    public void givenPersonObject_whenSavePerson_thenReturnPersonObject(){
        // given - precondition or setup
        given(repository.findByEmail(person.getEmail()))
                .willReturn(Optional.empty());

        given(repository.save(person)).willReturn(person);

        System.out.println(repository);
        System.out.println(service);

        // when -  action or the behavior that we are going test
        Person savedPerson = service.create(person);

        System.out.println(savedPerson);
        // then - verify the output
        assertNotNull(savedPerson);
    }
    
 // JUnit test for savePerson method
    @DisplayName("JUnit test for savePerson method which throws exception")
    @Test
    public void givenExistingEmail_whenSavePerson_thenThrowsException(){
        // given - precondition or setup
        given(repository.findByEmail(person.getEmail()))
                .willReturn(Optional.of(person));

        System.out.println(repository);
        System.out.println(service);

        // when -  action or the behavior that we are going test
        assertThrows(ResourceNotFoundException.class, () -> {
            service.create(person);
        });

        // then
        verify(repository, never()).save(any(Person.class));
    }
}
