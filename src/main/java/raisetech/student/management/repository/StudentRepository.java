package raisetech.student.management.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.student.management.data.Students;
import raisetech.student.management.data.StudentCourses;

/**
 * 受講生情報を扱うリポジトリ。
 *
 * 全件検索や単一条件での検索、コース情報の検索が行えるクラスです。
 */

@Mapper
public interface StudentRepository {

  /**
   *全件検索します。
   *
   * @return全件検索した受講生情報の一覧
   */
  @Select("SELECT * FROM students")
  List<Students> search();

  @Select("SELECT * FROM students_courses")
  List<StudentCourses> searchStudentsCourses();

}
