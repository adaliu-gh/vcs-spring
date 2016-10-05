package cn.edu.fudan.ada.vcspring.controllers;

import cn.edu.fudan.ada.vcspring.models.*;
import cn.edu.fudan.ada.vcspring.service.*;
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
    private RegisterService registerService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("/student/{id}")
    public String login(@PathVariable("id") String id,Model model) {
        Student student=studentService.findById(id);
        model.addAttribute("student",student);
        return "student";
    }

    @RequestMapping("/student/{id}/register")
    public String sMyCourses(@PathVariable("id") String id, Model model){
        List<Register> registers=registerService.findBySId(id);
        model.addAttribute("id",id);
        model.addAttribute("registers",registers);
        return "register";
    }

    @RequestMapping("/student/{id}/course")
    public String sCourseQuery(@PathVariable("id") String id, @RequestParam(value="cId",required=false,defaultValue="%" ) String cId, @RequestParam(value="cName",required=false, defaultValue="%") String cName, @RequestParam(value="iName",required=false,defaultValue="%")String iName, Model model){
        List<Course> courses=courseService.findByIdLikeAndNameLikeAndINameLike(cId,cName,iName);
        model.addAttribute("id",id);
        model.addAttribute("role","student");
        model.addAttribute("courses",courses);
        return "course";
    }

    @RequestMapping("/student/{id}/course/add")
    public String sAddCourse(@PathVariable("id") String sId, @RequestParam(value="cId") String cId, @RequestParam(value="cName") String cName,@RequestParam(value="iId")String iId, @RequestParam(value="iName")String iName, Model model){
       String feedback=registerService.addRegister(cId,cName,iId,iName,sId);
       model.addAttribute("feedback",feedback);
       return "feedback";
    }


    @RequestMapping("/student/{id}/course/delete")
    public String sDeleteCourse(@PathVariable("id") String sId, @RequestParam(value="cId") String cId, @RequestParam(value="cName") String cName,@RequestParam(value="iId")String iId, @RequestParam(value="iName")String iName, Model model){
        String feedback=registerService.deleteRegister(cId,cName,iId,iName,sId);
        model.addAttribute("feedback",feedback);
        return "feedback";
    }
}
