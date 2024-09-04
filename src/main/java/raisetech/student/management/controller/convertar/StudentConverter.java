package raisetech.student.management.controller.convertar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import raisetech.student.management.data.StudentCourses;
import raisetech.student.management.domain.StudentDetail;
import raisetech.student.management.service.StudentsCourses;

@Component
public class StudentConverter {

   public List<StudentDetail> convertStudentDetails(List<Student> students,
      List<StudentCourses> studentCourses) {
    list<StudentDetail> studentDetails = new ArrayList<>();
    students.forEach(student -> {
      StudentDetail studentDetail = new StudentDetail();
      studentDetail.setStudent(student);

      List<StudentsCourses> convertStudentCourses = studentCourses.stream()
          .filter(studentCourses -> student.getId().equals(studentCourses.getStudentId()))
          .collect(Collectors.toList());

      studentDetails.setStudentsCourses(convertStudentCourses);
      studentDetail.add(studentDetail);
    });
    return studentDetails;
  }
}
