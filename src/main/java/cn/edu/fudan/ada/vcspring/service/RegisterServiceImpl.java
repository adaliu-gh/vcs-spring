package cn.edu.fudan.ada.vcspring.service;

import cn.edu.fudan.ada.vcspring.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService{

    @Transactional
    public String addRegister(String courseId, String courseName,String instructorId, String instructorName, String studentId) {

        Register oldRegister=registerDao.findByCourseIdAndStudentId(courseId,studentId);
        if (oldRegister!=null){
            return "You have already added this course!";
        }
        else {
            Course course=courseDao.findById(courseId);
            int margin=course.getMargin();
            if (margin==0){
                return "Sorry, capacity for this course is full!";
            }
            else{
                String sName=studentDao.findById(studentId).getName();
                Register register= registerDao.save(new Register(courseId,courseName,studentId,sName,instructorId,instructorName));
                course.setMargin(margin-1);
                courseDao.save(course);
                return "Course added successfully!";
            }
        }
    }

    @Transactional
    public String deleteRegister(String courseId, String courseName,String instructorId, String instructorName, String studentId) {

        Register oldRegister=registerDao.findByCourseIdAndStudentId(courseId,studentId);
        if (oldRegister==null){
            return "Sorry, you have NOT added this course!";
        }
        else {
            Course course=courseDao.findById(courseId);
            int margin=course.getMargin();
            registerDao.delete(oldRegister);
            course.setMargin(margin+1);
            courseDao.save(course);
            return "Course deleted successfully!";
        }
    }

    public List<Register> findByStudentId(String studentId) {
        return registerDao.findByStudentId(studentId);
    }

    @Autowired
    private RegisterDao registerDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private CourseDao courseDao;
}
