package cn.edu.fudan.ada.vcspring.service;

import cn.edu.fudan.ada.vcspring.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterDao registerDao;

    @Autowired
    private StudentDao studentDao;

    @Transactional
    public Register insertNewRegister(String cId, String cName,String iId, String iName, String sId) {

        Register oldRegister=registerDao.findByCIdAndSId(cId,sId);
        if (oldRegister!=null){
            return oldRegister;
        }
        else {
            String sName=studentDao.findById(sId).getName();
            return registerDao.save(new Register(cId,cName,sId,sName,iId,iName));
        }
    }
}
