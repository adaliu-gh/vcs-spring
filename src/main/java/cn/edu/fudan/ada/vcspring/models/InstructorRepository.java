package cn.edu.fudan.ada.vcspring.models;

import java.util.*;
import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository extends CrudRepository<Instructor, String>{
    Instructor findById(String id);
    List<Instructor> findByName(String name);
}
