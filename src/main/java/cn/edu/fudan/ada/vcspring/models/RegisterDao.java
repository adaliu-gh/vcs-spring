package cn.edu.fudan.ada.vcspring.models;

import java.util.*;
import org.springframework.data.repository.CrudRepository;

public interface RegisterDao extends CrudRepository<Register, Long>{
    List<Register> findByCourseId(String courseId);
    List<Register> findByStudentId(String studentId);
    List<Register> findByInstructorId(String instructorId);
    Register findByCourseIdAndStudentId(String courseId, String studentId);
}
