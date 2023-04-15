package br.com.erudio.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.erudio.model.Person;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    private Person person;

    @BeforeEach
    public void setup(){
        person = new Person(
            "Leandro",
            "Costa",
            "leandro@erudio.com.br",
            "Uberlândia - Minas Gerais - Brasil",
            "Male"
        );
    }
    
    // JUnit test for save person operation
    @DisplayName("JUnit test for save person operation")
    @Test
    public void givenPersonObject_whenSave_thenReturnSavedPerson(){

        //given - precondition or setup
        /*
            "Leandro",
                "Costa",
                "leandro@erudio.com.br",
                "Uberlândia - Minas Gerais - Brasil",
                "Male"
            );
        */
        // when - action or the behavior that we are going test
        Person savedPerson = personRepository.save(person);

        // then - verify the output
        assertNotNull(savedPerson);
        assertTrue(savedPerson.getId() > 0);
    }

    // JUnit test for get all persons operation
    @DisplayName("JUnit test for get all persons operation")
    @Test
    public void givenPersonsList_whenFindAll_thenPersonsList(){
        // given - precondition or setup
        /*Person person = new Person(
            "Leandro",
            "Costa",
            "leandro@erudio.com.br",
            "Uberlândia - Minas Gerais - Brasil",
            "Male"
        );*/

        Person person1 = new Person("Johnny","Cash", "jcash@erudio.com.br",
                "Kingsland - Arkansas - U.S.A.",
                "Male");

        personRepository.save(person);
        personRepository.save(person1);

        // when -  action or the behavior that we are going test
        List<Person> personList = personRepository.findAll();

        // then - verify the output
        assertNotNull(personList);
        assertEquals(2, personList.size());

    }
    
    // JUnit test for get person by id operation
    @DisplayName("JUnit test for get person by id operation")
    @Test
    public void givenPersonObject_whenFindById_thenReturnPersonObject(){
        // given - precondition or setup
        /*Person person = new Person(
        "Leandro",
        "Costa",
        "leandro@erudio.com.br",
        "Uberlândia - Minas Gerais - Brasil",
        "Male"
        );*/
        personRepository.save(person);

        // when -  action or the behavior that we are going test
        Person recordedPerson = personRepository.findById(person.getId()).get();

        // then - verify the output
        assertNotNull(recordedPerson);
    }
    
    // JUnit test for get person by email operation
    @DisplayName("JUnit test for get person by email operation")
    @Test
    public void givenPersonEmail_whenFindByEmail_thenReturnPersonObject(){
        // given - precondition or setup
        /*Person person = new Person(
        "Leandro",
        "Costa",
        "leandro@erudio.com.br",
        "Uberlândia - Minas Gerais - Brasil",
        "Male"
        );*/
        personRepository.save(person);

        // when -  action or the behavior that we are going test
        Person personDB = personRepository.findByEmail(person.getEmail()).get();

        // then - verify the output
        assertNotNull(personDB);
    }
    
    // JUnit test for update person operation
    @DisplayName("JUnit test for update person operation")
    @Test
    public void givenPersonObject_whenUpdatePerson_thenReturnUpdatedPerson(){
        // given - precondition or setup
        /*Person person = new Person(
        "Leandro",
        "Costa",
        "leandro@erudio.com.br",
        "Uberlândia - Minas Gerais - Brasil",
        "Male"
        );*/
        personRepository.save(person);

        // when -  action or the behavior that we are going test
        Person savedPerson = personRepository.findById(person.getId()).get();
        savedPerson.setEmail("leonardo@erudio.com.br");
        savedPerson.setFirstName("Leonardo");
        Person updatedPerson =  personRepository.save(savedPerson);

        // then - verify the output
        assertEquals("leonardo@erudio.com.br", updatedPerson.getEmail());
        assertEquals("Leonardo", updatedPerson.getFirstName());
    }
    
    // JUnit test for delete person operation
    @DisplayName("JUnit test for delete person operation")
    @Test
    public void givenPersonObject_whenDelete_thenRemovePerson(){
        
        // given - precondition or setup
        /*Person person = new Person(
        "Leandro",
        "Costa",
        "leandro@erudio.com.br",
        "Uberlândia - Minas Gerais - Brasil",
        "Male"
        );*/
        personRepository.save(person);

        // when -  action or the behavior that we are going test
        personRepository.deleteById(person.getId());
        Optional<Person> personOptional = personRepository.findById(person.getId());

        // then - verify the output
        assertTrue(personOptional.isEmpty());
    }
    
    // JUnit test for custom query using JPQL with index
    @DisplayName("JUnit test for custom query using JPQL with index")
    @Test
    public void givenFirstNameAndLastName_whenFindByJPQL_thenReturnPersonObject(){
        
        // given - precondition or setup
        /*Person person = new Person(
        "Leandro",
        "Costa",
        "leandro@erudio.com.br",
        "Uberlândia - Minas Gerais - Brasil",
        "Male"
        );*/
        personRepository.save(person);
        String firstName = "Leandro";
        String lastName = "Costa";

        // when -  action or the behaviour that we are going test
        Person savedPerson = personRepository.findByJPQL(firstName, lastName);

        // then - verify the output
        assertNotNull(savedPerson);
    }
    
    // JUnit test for custom query using JPQL with Named params
    @DisplayName("JUnit test for custom query using JPQL with Named params")
    @Test
    public void givenFirstNameAndLastName_whenFindByJPQLNamedParams_thenReturnPersonObject(){
        // given - precondition or setup
        /*Person person = new Person(
        "Leandro",
        "Costa",
        "leandro@erudio.com.br",
        "Uberlândia - Minas Gerais - Brasil",
        "Male"
        );*/
        personRepository.save(person);
        String firstName = "Leandro";
        String lastName = "Costa";

        // when -  action or the behaviour that we are going test
        Person savedPerson = personRepository.findByJPQLNamedParams(firstName, lastName);

        // then - verify the output
        assertNotNull(savedPerson);
    }
}
