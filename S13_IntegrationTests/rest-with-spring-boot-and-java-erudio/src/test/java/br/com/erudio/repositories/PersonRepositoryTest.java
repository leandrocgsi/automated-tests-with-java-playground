package br.com.erudio.repositories;

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

import br.com.erudio.integrationtests.testcontainers.AbstractIntegrationTest;
import br.com.erudio.model.Person;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PersonRepositoryTest extends AbstractIntegrationTest {

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
    
    @DisplayName("JUnit test for save person operation")
    @Test
    public void givenPersonObject_whenSave_thenReturnSavedPerson(){
        
        Person savedPerson = personRepository.save(person);
        
        assertNotNull(savedPerson);
        assertTrue(savedPerson.getId() > 0);
    }

    @DisplayName("JUnit test for get all persons operation")
    @Test
    public void givenPersonsList_whenFindAll_thenPersonsList(){

        Person person1 = new Person("Johnny","Cash", "jcash@erudio.com.br",
                "Kingsland - Arkansas - U.S.A.",
                "Male");

        personRepository.save(person);
        personRepository.save(person1);
        
        List<Person> personList = personRepository.findAll();
        
        assertNotNull(personList);
        assertEquals(2, personList.size());
    }
    
    @DisplayName("JUnit test for get person by id operation")
    @Test
    public void givenPersonObject_whenFindById_thenReturnPersonObject(){

        personRepository.save(person);

        Person recordedPerson = personRepository.findById(person.getId()).get();

        assertNotNull(recordedPerson);
    }
    
    @DisplayName("JUnit test for get person by email operation")
    @Test
    public void givenPersonEmail_whenFindByEmail_thenReturnPersonObject(){
        
        personRepository.save(person);

        Person personDB = personRepository.findByEmail(person.getEmail()).get();

        assertNotNull(personDB);
    }
    
    @DisplayName("JUnit test for update person operation")
    @Test
    public void givenPersonObject_whenUpdatePerson_thenReturnUpdatedPerson(){
        
        personRepository.save(person);

        Person savedPerson = personRepository.findById(person.getId()).get();
        savedPerson.setEmail("leonardo@erudio.com.br");
        savedPerson.setFirstName("Leonardo");
        Person updatedPerson =  personRepository.save(savedPerson);

        assertEquals("leonardo@erudio.com.br", updatedPerson.getEmail());
        assertEquals("Leonardo", updatedPerson.getFirstName());
    }
    
    @DisplayName("JUnit test for delete person operation")
    @Test
    public void givenPersonObject_whenDelete_thenRemovePerson(){

        personRepository.save(person);

        personRepository.deleteById(person.getId());
        Optional<Person> personOptional = personRepository.findById(person.getId());

        assertTrue(personOptional.isEmpty());
    }
    
    @DisplayName("JUnit test for custom query using JPQL with index")
    @Test
    public void givenFirstNameAndLastName_whenFindByJPQL_thenReturnPersonObject(){
        
        personRepository.save(person);
        String firstName = "Leandro";
        String lastName = "Costa";

        Person savedPerson = personRepository.findByJPQL(firstName, lastName);

        assertNotNull(savedPerson);
    }
    
    @DisplayName("JUnit test for custom query using JPQL with Named params")
    @Test
    public void givenFirstNameAndLastName_whenFindByJPQLNamedParams_thenReturnPersonObject(){

        personRepository.save(person);
        String firstName = "Leandro";
        String lastName = "Costa";

        Person savedPerson = personRepository.findByJPQLNamedParams(firstName, lastName);
        
        assertNotNull(savedPerson);
    }
    
    @DisplayName("JUnit test for custom query using native SQL with index")
    @Test
    public void givenFirstNameAndLastName_whenFindByNativeSQL_thenReturnPersonObject(){
        personRepository.save(person);

        Person savedPerson = personRepository.findByNativeSQL(person.getFirstName(), person.getLastName());
        
        assertNotNull(savedPerson);
    }
    
    @DisplayName("JUnit test for custom query using native SQL with named params")
    @Test
    public void givenFirstNameAndLastName_whenFindByNativeSQLNamedParams_thenReturnPersonObject(){
        
        personRepository.save(person);
        
        Person savedPerson = personRepository.findByNativeSQLNamed(person.getFirstName(), person.getLastName());

        assertNotNull(savedPerson);
    }
}