package br.com.erudio.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import br.com.erudio.service.CourseService;

class CourseBusinessMockBDDTest {
    
    CourseService mockService;
    
    @BeforeEach
    void setup() {
        mockService = mock(CourseService.class);
    }
    
    @Test
    void testRetrieveCoursesRelatedToSpring_usingAMock() {
        
        List<String> courses = Arrays.asList(
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
        
        when(mockService.retrieveCourses("Leandro")).thenReturn(courses);
        
        CourseBusiness business = new CourseBusiness(mockService);
        var filteredCourses = business
            .retrieveCoursesRelatedToSpring("Leandro");
        assertEquals(4, filteredCourses.size());
        
        // Do another assertions
    }
    
    @Test
    void testRetrieveCoursesRelatedToSpring_withEmptyList() {
        
        List<String> courses = Arrays.asList();
        
        when(mockService.retrieveCourses("Leandro")).thenReturn(courses);
        
        CourseBusiness business = new CourseBusiness(mockService);
        var filteredCourses = business
                .retrieveCoursesRelatedToSpring("Leandro");
        assertEquals(0, filteredCourses.size());
        
        // Do another assertions
    }
}