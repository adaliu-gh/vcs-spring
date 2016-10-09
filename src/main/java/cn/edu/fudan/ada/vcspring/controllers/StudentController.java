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

    @Autowired
    private RegisterService registerService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("/{id}")
    public String login(@PathVariable("id") String id,@RequestParam(value="feedback",required=false,defaultValue="Welcome!") String feedback,Model model) {
        Student student=studentService.findById(id);
        List<Register> registers=registerService.findBySId(id);
        model.addAttribute("student",student);
        model.addAttribute("feedback",feedback);
        model.addAttribute("registers",registers);
        return "student";
    }

    @RequestMapping("/{id}/course")
    public String sCourseQuery(@PathVariable("id") String id, @RequestParam(value="cId",required=false,defaultValue="%" ) String cId, @RequestParam(value="cName",required=false, defaultValue="%") String cName, @RequestParam(value="iName",required=false,defaultValue="%")String iName, Model model){
        List<Course> courses=courseService.findByIdLikeAndNameLikeAndINameLike(cId,cName,iName);
        model.addAttribute("id",id);
        model.addAttribute("role","student");
        model.addAttribute("courses",courses);
        return "course";
    }

    @RequestMapping("/{id}/course/add")
    public String sAddCourse(@PathVariable("id") String sId, @RequestParam(value="cId") String cId, @RequestParam(value="cName") String cName,@RequestParam(value="iId")String iId, @RequestParam(value="iName")String iName, Model model){
       String feedback=registerService.addRegister(cId,cName,iId,iName,sId);
       model.addAttribute("id",sId);
       model.addAttribute("role","student");
       return "redirect:/student/"+sId+"?feedback="+feedback;
    }


    @RequestMapping("/{id}/course/delete")
    public String sDeleteCourse(@PathVariable("id") String sId, @RequestParam(value="cId") String cId, @RequestParam(value="cName") String cName,@RequestParam(value="iId")String iId, @RequestParam(value="iName")String iName, Model model){
        String feedback=registerService.deleteRegister(cId,cName,iId,iName,sId);
        model.addAttribute("id",sId);
        model.addAttribute("role","student");
        return "redirect:/student/"+sId+"?feedback="+feedback;
    }
}
