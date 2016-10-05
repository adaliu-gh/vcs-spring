package cn.edu.fudan.ada.vcspring.service;

import cn.edu.fudan.ada.vcspring.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("registerService")
public class RegisterService{

    @Transactional
    public String insertNewRegister(String cId, String cName,String iId, String iName, String sId) {

        Register oldRegister=registerDao.findByCIdAndSId(cId,sId);
        if (oldRegister!=null){
            return "You have already added this course!";
        }
        else {
            String sName=studentDao.findById(sId).getName();
            Register register= registerDao.save(new Register(cId,cName,sId,sName,iId,iName));
            return "Course added successfully!";
        }
    }

    public List<Register> findBySId(String sId) {
        return registerDao.findBySId(sId);
    }

    @Autowired
    private RegisterDao registerDao;

    @Autowired
    private StudentDao studentDao;

}
