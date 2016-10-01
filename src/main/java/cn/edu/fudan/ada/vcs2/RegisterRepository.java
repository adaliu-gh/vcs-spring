package cn.edu.fudan.ada.vcs2;

import java.util.*;
import org.springframework.data.repository.CrudRepository;

public interface RegisterRepository extends CrudRepository<Register, Long>{
    List<Register> findByCId(String cId);
    List<Register> findBySId(String sId);
    List<Register> findByIId(String iId);
}
