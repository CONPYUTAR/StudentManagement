package raisetech.student.management.controller.convertar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentsCourses;
import raisetech.student.management.domain.StudentDetail;

@Component
public class StudentConverter {

   public List<StudentDetail> convertStudentDetails(List<Student> students,
      List<StudentsCourses> studentsCourses) {
    List<StudentDetail> studentDetails = new ArrayList<>();
    students.forEach(student -> {
      StudentDetail studentDetail = new StudentDetail();
      studentDetail.setStudent(student);

      List<StudentsCourses> convertStudentCourses = studentsCourses.stream()
          .filter(StudentCourses -> student.getId().equals(studentsCourses.getStudentId()))
          .collect(Collectors.toList());

      studentDetails.setStudentsCourses(convertStudentCourses);
      studentDetail.add(studentDetail);
    });
    return studentDetails;
  }
}
