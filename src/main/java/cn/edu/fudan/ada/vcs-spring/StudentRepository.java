package cn.edu.fudan.ada.vcsSpring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByName(String name);
    Student findById(String id);
}