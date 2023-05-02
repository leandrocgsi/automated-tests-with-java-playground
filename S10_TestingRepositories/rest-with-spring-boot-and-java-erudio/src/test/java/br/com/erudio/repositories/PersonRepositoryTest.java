package br.com.erudio.repositories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
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
    //@DisplayName("JUnit test for save person operation")
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

        Person person1 = new Person("Ayrton","Senna", "senna@erudio.com.br",
                "Uberlândia - Minas Gerais - Brasil",
                "Male");

        personRepository.save(person);
        personRepository.save(person1);

        // when -  action or the behaviour that we are going test
        List<Person> personList = personRepository.findAll();

        // then - verify the output
        assertThat(personList).isNotNull();
        assertThat(personList.size()).isEqualTo(2);

    }
}
