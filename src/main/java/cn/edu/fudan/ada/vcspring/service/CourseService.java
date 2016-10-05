package cn.edu.fudan.ada.vcspring.service;

import cn.edu.fudan.ada.vcspring.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("courseService")
public class CourseService{

    public List<Course> findByIdLikeAndNameLikeAndINameLike(String cId,String cName,String iName){
        return courseDao.findByIdLikeAndNameLikeAndINameLike(cId,cName,iName);
    }

    @Autowired
    private CourseDao courseDao;

}
