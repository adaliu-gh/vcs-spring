package cn.edu.fudan.ada.vcspring.service;
import cn.edu.fudan.ada.vcspring.models.*;
import java.util.List;

public interface CourseService{

    public List<Course> findByConditions(String id,String name,String instructorName);
}
