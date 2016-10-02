package cn.edu.fudan.ada.vcsSpring;

import java.util.*;
import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository extends CrudRepository<Instructor, String>{
    Instructor findById(String id);
    List<Instructor> findByName(String name);
}
