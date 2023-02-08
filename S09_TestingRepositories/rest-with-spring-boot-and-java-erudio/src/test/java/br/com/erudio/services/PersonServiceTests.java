package br.com.erudio.services;

import static org.assertj.core.api.Assertions.assertThat;
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
    private PersonServices personService;

    private Person person;

    @BeforeEach
    public void setup(){
        //personRepository = Mockito.mock(PersonRepository.class);
        //personService = new PersonServiceImpl(personRepository);
        person = new Person(
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
        System.out.println(personService);

        // when -  action or the behavior that we are going test
        Person savedPerson = personService.create(person);

        System.out.println(savedPerson);
        // then - verify the output
        assertThat(savedPerson).isNotNull();
    }

    // JUnit test for savePerson method
    @DisplayName("JUnit test for savePerson method which throws exception")
    @Test
    public void givenExistingEmail_whenSavePerson_thenThrowsException(){
        // given - precondition or setup
        given(repository.findByEmail(person.getEmail()))
                .willReturn(Optional.of(person));

        System.out.println(repository);
        System.out.println(personService);

        // when -  action or the behavior that we are going test
        org.junit.jupiter.api.Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            personService.create(person);
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
        		"Ayrton",
        		"Senna",
        		"senna@erudio.com.br",
        		"Some Place in Brasil",
        		"Male"
    		);

        given(repository.findAll()).willReturn(List.of(person,person1));

        // when -  action or the behavior that we are going test
        List<Person> personList = personService.findAll();

        // then - verify the output
        assertThat(personList).isNotNull();
        assertThat(personList.size()).isEqualTo(2);
    }

    // JUnit test for getAllPersons method
    @DisplayName("JUnit test for getAllPersons method (negative scenario)")
    @Test
    public void givenEmptyPersonsList_whenGetAllPersons_thenReturnEmptyPersonsList(){
        // given - precondition or setup

        Person person1 = new Person(
        		"Ayrton",
        		"Senna",
        		"senna@erudio.com.br",
        		"Some Place in Brasil",
        		"Male"
    		);

        given(repository.findAll()).willReturn(Collections.emptyList());

        // when -  action or the behavior that we are going test
        List<Person> personList = personService.findAll();

        // then - verify the output
        assertThat(personList).isEmpty();
        assertThat(personList.size()).isEqualTo(0);
    }

    // JUnit test for getPersonById method
    @DisplayName("JUnit test for getPersonById method")
    @Test
    public void givenPersonId_whenGetPersonById_thenReturnPersonObject(){
        // given
        given(repository.findById(1L)).willReturn(Optional.of(person));

        // when
        Person savedPerson = personService.findById(person.getId());

        // then
        assertThat(savedPerson).isNotNull();

    }

    // JUnit test for updatePerson method
    @DisplayName("JUnit test for updatePerson method")
    @Test
    public void givenPersonObject_whenUpdatePerson_thenReturnUpdatedPerson(){
        // given - precondition or setup
        given(repository.save(person)).willReturn(person);
        person.setEmail("rstallman@erudio.com.br");
        person.setFirstName("Richard");
        // when -  action or the behavior that we are going test
        Person updatedPerson = personService.update(person);

        // then - verify the output
        assertThat(updatedPerson.getEmail()).isEqualTo("rstallman@erudio.com.br");
        assertThat(updatedPerson.getFirstName()).isEqualTo("Richard");
    }

    // JUnit test for deletePerson method
    @DisplayName("JUnit test for deletePerson method")
    @Test
    public void givenPersonId_whenDeletePerson_thenNothing(){
        // given - precondition or setup
        long personId = 1L;

        willDoNothing().given(repository).deleteById(personId);

        // when -  action or the behavior that we are going test
        personService.delete(personId);

        // then - verify the output
        verify(repository, times(1)).deleteById(personId);
    }
}
