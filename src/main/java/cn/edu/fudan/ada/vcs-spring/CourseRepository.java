package cn.edu.fudan.ada.vcsSpring;

import java.util.*;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{
    Course findById(String id);
    List<Course> findByName(String name);
    List<Course> findByIId(String iId);
    List<Course> findByIName(String iName);
}
