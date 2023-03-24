package br.com.erudio.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.erudio.service.CourseService;
import br.com.erudio.service.CourseServiceStub;

class CourseBusinessMockTest {

    @Test
    void testRetrieveCoursesRelatedToSpring() {
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);
        var filteredCourses = business
            .retrieveCoursesRelatedToSpring("Leandro");
        assertEquals(4, filteredCourses.size());
        
        // Do another assertions
    }
    
    @Test
    void testRetrieveCoursesRelatedToSpringUsingEmptyTitle() {
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);
        var filteredCourses = business
            .retrieveCoursesRelatedToSpring("Foo Bar");
        assertEquals(0, filteredCourses.size());
        
        // Do another assertions
    }

}