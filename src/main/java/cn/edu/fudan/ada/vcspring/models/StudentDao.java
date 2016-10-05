package cn.edu.fudan.ada.vcspring.models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StudentDao extends CrudRepository<Student, Long> {

    List<Student> findByName(String name);
    Student findById(String id);
}
