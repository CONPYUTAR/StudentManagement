package raisetech.student.management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import raisetech.student.management.controller.convertar.StudentConverter;
import raisetech.student.management.data.StudentsCourses;
import raisetech.student.management.data.Student;
import raisetech.student.management.service.StudentService;
import raisetech.student.management.domain.StudentDetail;

@Controller
public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  @GetMapping("/studentList")
  public String getStudentList(Model model) {
    List<Student> students = service.searchStudentList();
    List<StudentsCourses> studentCourses = service.searchStudentsCourseList();

    List<StudentDetail> studentDetails = converter.convertStudentDetails(students, studentCourses);

    model.addAttribute("studentList", studentDetails);
    return "studentList";
  }

  @GetMapping("/studentsCourseList")
  public List<StudentsCourses> getStudentsCourseList() {
    return service.searchStudentsCourseList();
  }
}
