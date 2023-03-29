package br.com.erudio.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.erudio.service.CourseService;

class CourseBusinessMockBDDTest {
    
    CourseService mockService;
    List<String> courses;
    
    @BeforeEach
    void setup() {
        // Given / Arrange
        mockService = mock(CourseService.class);
        courses = Arrays.asList(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker");
    }
    
    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @DisplayName("Courses Related to Spring when Using a mock should Return a list with size 4")
    @Test
    void testCoursesRelatedToSpring_When_UsingAMock_Should_ReturnAListWithSize4() {
        
        // Given / Arrange
        given(mockService.retrieveCourses("Leandro")).willReturn(courses);
        CourseBusiness business = new CourseBusiness(mockService);
        
        // When / Act
        var filteredCourses = business
            .retrieveCoursesRelatedToSpring("Leandro");

        // Then / Assert
        assertThat(filteredCourses.size(), is(4));
    }
    
    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @DisplayName("Delete Courses Not Related to Spring Using Mockito Verify should call Method")
    @Test
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CallMethod() {
        
        // Given / Arrange
        given(mockService.retrieveCourses("Leandro")).willReturn(courses);
        CourseBusiness business = new CourseBusiness(mockService);
        
        // When / Act
        business
            .deleteCoursesNotRelatedToSpring("Leandro");

        // Then / Assert
        verify(mockService, atLeastOnce()).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
        verify(mockService).deleteCourse("Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#");
        verify(mockService, never()).deleteCourse("REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker");
        
        then(mockService).should().deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
        then(mockService).should(never()).deleteCourse("Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#");
        then(mockService).should(never()).deleteCourse("REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker");
    } 
    
    @Test
    void testRetrieveCoursesRelatedToSpring_withEmptyList() {

        // Given / Arrange
        List<String> courses = Arrays.asList();
        
        given(mockService.retrieveCourses("Leandro")).willReturn(courses);
        
        CourseBusiness business = new CourseBusiness(mockService);
        
        // When / Act
        var filteredCourses = business
            .retrieveCoursesRelatedToSpring("Leandro");

        // Then / Assert
        assertEquals(0, filteredCourses.size());
    }
}