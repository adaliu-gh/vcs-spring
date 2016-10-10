package cn.edu.fudan.ada.vcspring.controllers;

import cn.edu.fudan.ada.vcspring.models.*;
import cn.edu.fudan.ada.vcspring.service.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/{id}")
    public String login(@PathVariable("id") String id,@RequestParam(value="feedback",required=false,defaultValue="Welcome!") String feedback,Model model) {
        Student student=studentService.findById(id);
        List<Register> registers=registerService.findByStudentId(id);
        model.addAttribute("student",student);
        model.addAttribute("feedback",feedback);
        model.addAttribute("registers",registers);
        return "student";
    }

    @RequestMapping("/{id}/course")
    public String sCourseQuery(@PathVariable("id") String id, @RequestParam(value="courseId",required=false,defaultValue="%" ) String courseId, @RequestParam(value="courseName",required=false, defaultValue="%") String courseName, @RequestParam(value="instructorName",required=false,defaultValue="%")String instructorName, Model model){
        List<Course> courses=courseService.findByConditions(courseId,courseName,instructorName);
        model.addAttribute("id",id);
        model.addAttribute("role","student");
        model.addAttribute("courses",courses);
        return "course";
    }

    @RequestMapping("/{id}/course/add")
    public String sAddCourse(@PathVariable("id") String studentId, @RequestParam(value="courseId") String courseId, @RequestParam(value="courseName") String courseName,@RequestParam(value="instructorId")String instructorId, @RequestParam(value="instructorName")String instructorName, Model model){
       String feedback=registerService.addRegister(courseId,courseName,instructorId,instructorName,studentId);
       model.addAttribute("id",studentId);
       model.addAttribute("role","student");
       return "redirect:/student/"+studentId+"?feedback="+feedback;
    }


    @RequestMapping("/{id}/course/delete")
    public String sDeleteCourse(@PathVariable("id") String studentId, @RequestParam(value="courseId") String courseId, @RequestParam(value="courseName") String courseName,@RequestParam(value="instructorId")String instructorId, @RequestParam(value="instructorName")String instructorName, Model model){
        String feedback=registerService.deleteRegister(courseId,courseName,instructorId,instructorName,studentId);
        model.addAttribute("id",studentId);
        model.addAttribute("role","student");
        return "redirect:/student/"+studentId+"?feedback="+feedback;
    }

    @Autowired
    private RegisterService registerService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;
}
