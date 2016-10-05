package cn.edu.fudan.ada.vcspring.service;

import cn.edu.fudan.ada.vcspring.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentService")
public class StudentService{

    public Student findById(String id) {
        return studentDao.findById(id);
    }

    @Autowired
    private StudentDao studentDao;

}
