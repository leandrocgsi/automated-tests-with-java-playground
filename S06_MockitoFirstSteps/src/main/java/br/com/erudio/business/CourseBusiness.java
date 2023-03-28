package br.com.erudio.business;

import java.util.ArrayList;
import java.util.List;

import br.com.erudio.service.CourseService;

// CourseBusiness = SUT System Under Test
public class CourseBusiness {
    
    // CourseService is a Dependency
    private CourseService courseService;

    CourseBusiness(CourseService courseService) {
        this.courseService = courseService;
    }

    public List<String> retrieveCoursesRelatedToSpring(String student) {
        var filteredCourses = new ArrayList<String>();
        if("Foo Bar".equals(student)) return filteredCourses;
        var allCourses = courseService.retrieveCourses(student);
        for (String course : allCourses) {
            if (course.contains("Spring")) {
                filteredCourses.add(course);
            }
        }
        return filteredCourses;
    }
    
    public void deleteCoursesNotRelatedToSpring(String student) {
        var allCourses = courseService.retrieveCourses(student);
        for (String course : allCourses) {
            if (!course.contains("Spring")) {
                courseService.deleteCourse(course); 
            }
        }
    }
}