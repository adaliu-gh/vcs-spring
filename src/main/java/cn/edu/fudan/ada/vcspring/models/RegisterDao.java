package cn.edu.fudan.ada.vcspring.models;

import java.util.*;
import org.springframework.data.repository.CrudRepository;

public interface RegisterDao extends CrudRepository<Register, Long>{
    List<Register> findByCId(String cId);
    List<Register> findBySId(String sId);
    List<Register> findByIId(String iId);
    Register findByCIdAndSId(String cId, String sId);
}
