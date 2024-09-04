package raisetech.student.management.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.student.management.data.StudentCourses;
import raisetech.student.management.data.StudentsCourses;
import raisetech.student.management.repository.StudentRepository;
import raisetech.student.management.data.Students;

@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Students> searchStudentList() {
   //ここで何かしらの処理を行う。
    return repository.search();
  }

 public List<StudentCourses> searchStudentsCourseList() {
   return repository.searchStudentsCourses();
 }
 }
