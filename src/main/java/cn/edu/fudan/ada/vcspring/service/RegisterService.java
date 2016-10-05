package cn.edu.fudan.ada.vcspring.service;

import cn.edu.fudan.ada.vcspring.models.*;
import java.util.List;


public interface RegisterService {
    public Register insertNewRegister(String cId, String cName, String iId, String iName, String sId);

    //public Register deleteOldRegister(String cId, String cName, String iId, String iName, String sId, String sName);

}
