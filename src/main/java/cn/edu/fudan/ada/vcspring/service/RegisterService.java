package cn.edu.fudan.ada.vcspring.service;
import cn.edu.fudan.ada.vcspring.models.*;
import java.util.List;
public interface RegisterService{

    public String addRegister(String courseId, String courseName,String instructorId, String instructorName, String studentId);

    public String deleteRegister(String courseId, String courseName,String instructorId, String instructorName, String studentId);

    public List<Register> findByStudentId(String studentId);
}
