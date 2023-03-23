package br.com.erudio.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.erudio.service.CourseService;
import br.com.erudio.service.CourseServiceStub;

class CourseBusinessStubTest {

    @Test
    void testRetrieveCoursesRelatedToSpring() {
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);
        var filteredCourses = business
            .retrieveCoursesRelatedToSpring("Spring");
        assertEquals(2, filteredCourses.size());
    }

}