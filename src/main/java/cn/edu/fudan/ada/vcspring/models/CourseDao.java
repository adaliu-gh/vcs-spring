package cn.edu.fudan.ada.vcspring.models;

import java.util.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseDao extends CrudRepository<Course, String>{

    Course findById(String id);
    List<Course> findByName(String name);
    List<Course> findByIId(String iId);
    List<Course> findByIName(String iName);

    List<Course> findByIdLikeAndNameLikeAndINameLike(String cId,String cName,String iName);
}
