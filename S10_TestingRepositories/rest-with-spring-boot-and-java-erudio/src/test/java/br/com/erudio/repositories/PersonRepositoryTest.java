package br.com.erudio.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

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
        Person person = new Person(
                "Leandro",
                "Costa",
                "leandro@erudio.com.br",
                "Uberlândia - Minas Gerais - Brasil",
                "Male"
            );
        // when - action or the behavior that we are going test
        Person savedPerson = personRepository.save(person);

        // then - verify the output
        assertThat(savedPerson).isNotNull();
        assertThat(savedPerson.getId()).isGreaterThan(0);
    }

}
