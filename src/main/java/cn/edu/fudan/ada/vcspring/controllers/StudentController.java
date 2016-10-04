package cn.edu.fudan.ada.vcspring.controllers;

import cn.edu.fudan.ada.vcspring.models.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudentController {

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping("/student/{id}")
    public String login(@PathVariable("id") String id,Model model) {
        Student student=studentRepository.findById(id);
        model.addAttribute("student",student);
        return "student";
    }

    @RequestMapping("/student/{id}/register")
    public String sMyCourses(@PathVariable("id") String id, Model model){
        List<Register> registers=registerRepository.findBySId(id);
        model.addAttribute("id",id);
        model.addAttribute("registers",registers);
        return "register";
    }

    @RequestMapping("/student/{id}/course")
    public String sCourseQuery(@PathVariable("id") String id, @RequestParam(value="cId",required=false,defaultValue="%" ) String cId, @RequestParam(value="cName",required=false, defaultValue="%") String cName, @RequestParam(value="iName",required=false,defaultValue="%")String iName, Model model){
        List<Course> courses=courseRepository.findByIdLikeAndNameLikeAndINameLike(cId,cName,iName);
        model.addAttribute("id",id);
        model.addAttribute("role","student");
        model.addAttribute("courses",courses);
        return "course";
    }

}
