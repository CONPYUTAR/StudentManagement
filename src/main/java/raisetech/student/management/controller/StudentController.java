package raisetech.student.management.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.student.management.controller.convertar.StudentConverter;
import raisetech.student.management.data.StudentCourses;
import raisetech.student.management.data.Students;
import raisetech.student.management.domain.StudentDetail;
import raisetech.student.management.service.StudentService;
import raisetech.student.management.service.StudentsCourses;

@RestController
public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  @GetMapping("/studentList")
  public List<StudentDetail> getStudentList() {
    List<Students> students = service.searchStudentList();
    List<StudentCourses> studentCourses = service.searchStudentsCourseList();

    return converter.convertStudentDetails(students, studentCourses);
  }

  @GetMapping("/studentsCourseList")
  public List<StudentsCourses> getStudentsCourseList() {
    return service.searchStudentsCourseList();
  }
}
