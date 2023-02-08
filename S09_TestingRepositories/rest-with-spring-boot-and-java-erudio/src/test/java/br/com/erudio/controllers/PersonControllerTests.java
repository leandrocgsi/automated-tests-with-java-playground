package br.com.erudio.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;

@WebMvcTest
public class PersonControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonServices service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenPersonObject_whenCreatePerson_thenReturnSavedPerson() throws Exception{

        // given - precondition or setup
        Person person = Person.builder()
                .firstName("Leandro")
                .lastName("Costa")
                .email("leandro@erudio.com.br")
                .build();
        given(service.create(any(Person.class)))
                .willAnswer((invocation)-> invocation.getArgument(0));

        // when - action or behavior that we are going test
        ResultActions response = mockMvc.perform(post("/api/persons")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(person)));

        // then - verify the result or output using assert statements
        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName",
                        is(person.getFirstName())))
                .andExpect(jsonPath("$.lastName",
                        is(person.getLastName())))
                .andExpect(jsonPath("$.email",
                        is(person.getEmail())));

    }

    // JUnit test for Get All persons REST API
    @Test
    public void givenListOfPersons_whenGetAllPersons_thenReturnPersonsList() throws Exception{
        // given - precondition or setup
        List<Person> listOfPersons = new ArrayList<>();
        listOfPersons.add(Person.builder().firstName("Leandro").lastName("Costa").email("leandro@erudio.com.br").build());
        listOfPersons.add(Person.builder().firstName("Tony").lastName("Stark").email("tony@gmail.com").build());
        given(service.getAllPersons()).willReturn(listOfPersons);

        // when -  action or the behavior that we are going test
        ResultActions response = mockMvc.perform(get("/api/persons"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfPersons.size())));

    }

    // positive scenario - valid person id
    // JUnit test for GET person by id REST API
    @Test
    public void givenPersonId_whenGetPersonById_thenReturnPersonObject() throws Exception{
        // given - precondition or setup
        long personId = 1L;
        Person person = Person.builder()
                .firstName("Leandro")
                .lastName("Costa")
                .email("leandro@erudio.com.br")
                .build();
        given(service.findById(personId)).willReturn(Optional.of(person));

        // when -  action or the behavior that we are going test
        ResultActions response = mockMvc.perform(get("/api/persons/{id}", personId));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstName", is(person.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(person.getLastName())))
                .andExpect(jsonPath("$.email", is(person.getEmail())));

    }

    // negative scenario - valid person id
    // JUnit test for GET person by id REST API
    @Test
    public void givenInvalidPersonId_whenGetPersonById_thenReturnEmpty() throws Exception{
        // given - precondition or setup
        long personId = 1L;
        Person person = Person.builder()
                .firstName("Leandro")
                .lastName("Costa")
                .email("leandro@erudio.com.br")
                .build();
        given(service.findById(personId)).willReturn(Optional.empty());

        // when -  action or the behavior that we are going test
        ResultActions response = mockMvc.perform(get("/api/persons/{id}", personId));

        // then - verify the output
        response.andExpect(status().isNotFound())
                .andDo(print());

    }
    // JUnit test for update person REST API - positive scenario
        @Test
        public void givenUpdatedPerson_whenUpdatePerson_thenReturnUpdatePersonObject() throws Exception{
            // given - precondition or setup
            long personId = 1L;
            Person savedPerson = Person.builder()
                    .firstName("Leandro")
                    .lastName("Costa")
                    .email("leandro@erudio.com.br")
                    .build();

            Person updatedPerson = Person.builder()
                    .firstName("Ayrton")
                    .lastName("Senna")
                    .email("senna@erudio.com.br")
                    .build();
            given(service.findById(personId)).willReturn(Optional.of(savedPerson));
            given(service.update(any(Person.class)))
                    .willAnswer((invocation)-> invocation.getArgument(0));

            // when -  action or the behavior that we are going test
            ResultActions response = mockMvc.perform(put("/api/persons/{id}", personId)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content(objectMapper.writeValueAsString(updatedPerson)));


            // then - verify the output
            response.andExpect(status().isOk())
                    .andDo(print())
                    .andExpect(jsonPath("$.firstName", is(updatedPerson.getFirstName())))
                    .andExpect(jsonPath("$.lastName", is(updatedPerson.getLastName())))
                    .andExpect(jsonPath("$.email", is(updatedPerson.getEmail())));
        }

    // JUnit test for update person REST API - negative scenario
    @Test
    public void givenUpdatedPerson_whenUpdatePerson_thenReturn404() throws Exception{
        // given - precondition or setup
        long personId = 1L;
        Person savedPerson = Person.builder()
                .firstName("Leandro")
                .lastName("Costa")
                .email("leandro@erudio.com.br")
                .build();

        Person updatedPerson = Person.builder()
                .firstName("Ayrton")
                .lastName("Senna")
                .email("senna@erudio.com.br")
                .build();
        given(service.findById(personId)).willReturn(Optional.empty());
        given(service.update(any(Person.class)))
                .willAnswer((invocation)-> invocation.getArgument(0));

        // when -  action or the behavior that we are going test
        ResultActions response = mockMvc.perform(put("/api/persons/{id}", personId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedPerson)));

        // then - verify the output
        response.andExpect(status().isNotFound())
                .andDo(print());
    }

// JUnit test for delete person REST API
    @Test
    public void givenPersonId_whenDeletePerson_thenReturn200() throws Exception{
        // given - precondition or setup
        long personId = 1L;
        willDoNothing().given(service).delete(personId);

        // when -  action or the behavior that we are going test
        ResultActions response = mockMvc.perform(delete("/api/persons/{id}", personId));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print());
    }
}
