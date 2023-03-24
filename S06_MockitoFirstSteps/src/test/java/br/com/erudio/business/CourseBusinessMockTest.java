package br.com.erudio.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import br.com.erudio.service.CourseService;

class CourseBusinessMockTest {
    @Test
    void testRetrieveCoursesRelatedToSpring_usingAMock() {
        CourseService mockService = mock(CourseService.class);
        CourseBusiness business = new CourseBusiness(mockService);
        var filteredCourses = business
            .retrieveCoursesRelatedToSpring("Leandro");
        assertEquals(4, filteredCourses.size());
        
        // Do another assertions
    }


}