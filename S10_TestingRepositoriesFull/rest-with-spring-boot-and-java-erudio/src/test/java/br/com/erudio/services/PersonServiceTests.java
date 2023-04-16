package br.com.erudio.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;
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
public class PersonServiceTests {

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
        org.junit.jupiter.api.Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.create(person);
        });

        // then
        verify(repository, never()).save(any(Person.class));
    }

    // JUnit test for getAllPersons method
    @DisplayName("JUnit test for getAllPersons method")
    @Test
    public void givenPersonsList_whenGetAllPersons_thenReturnPersonsList(){
        // given - precondition or setup

        Person person1 = new Person(
                "Leonardo",
                "Costa",
                "leonardo@erudio.com.br",
                "Uberlândia - Minas Gerais - Brasil",
                "Male"
            );

        given(repository.findAll()).willReturn(List.of(person,person1));

        // when -  action or the behavior that we are going test
        List<Person> personList = service.findAll();

        // then - verify the output
        assertNotNull(personList);
        assertEquals(2, personList.size());
    }

    // JUnit test for getAllPersons method
    @DisplayName("JUnit test for getAllPersons method (negative scenario)")
    @Test
    public void givenEmptyPersonsList_whenGetAllPersons_thenReturnEmptyPersonsList(){
        // given - precondition or setup
        given(repository.findAll()).willReturn(Collections.emptyList());

        // when -  action or the behavior that we are going test
        List<Person> personList = service.findAll();

        // then - verify the output
        assertTrue(personList.isEmpty());
        assertEquals(0, personList.size());
    }

    // JUnit test for findById method
    @DisplayName("JUnit test for findById method")
    @Test
    public void givenPersonId_whenFindById_thenReturnPersonObject(){
        // given
        given(repository.findById(1L)).willReturn(Optional.of(person));

        // when
        Optional<Person> savedPerson = service.findById(person.getId());

        // then
        assertNotNull(savedPerson);

    }

    // JUnit test for updatePerson method
    @DisplayName("JUnit test for updatePerson method")
    @Test
    public void givenPersonObject_whenUpdatePerson_thenReturnUpdatedPerson(){
        // given - precondition or setup
        given(repository.findById(1L)).willReturn(Optional.of(person));
        
        person.setEmail("leonardo@erudio.com.br");
        person.setFirstName("Leonardo");
        
        given(repository.save(person)).willReturn(person);
        // when -  action or the behavior that we are going test
        Person updatedPerson = service.update(person);

        // then - verify the output
        assertEquals("leonardo@erudio.com.br", updatedPerson.getEmail());
        assertEquals("Leonardo", updatedPerson.getFirstName());
    }

    // JUnit test for deletePerson method
    @DisplayName("JUnit test for deletePerson method")
    @Test
    public void givenPersonId_whenDeletePerson_thenNothing(){
        // given - precondition or setup
        long id = 1L;


        given(repository.findById(1L)).willReturn(Optional.of(person));
        willDoNothing().given(repository).delete(person);

        // when -  action or the behavior that we are going test
        service.delete(id);

        // then - verify the output
        verify(repository, times(1)).delete(person);
    }
}
