package cn.edu.fudan.ada.vcspring.service;

import cn.edu.fudan.ada.vcspring.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService{

    public List<Course> findByConditions(String id,String name,String instructorName){
        return courseDao.findByIdLikeAndNameLikeAndInstructorNameLike(id,name,instructorName);
    }

    @Autowired
    private CourseDao courseDao;

}
