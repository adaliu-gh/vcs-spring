package cn.edu.fudan.ada.vcspring.models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IdentityDao extends CrudRepository<Identity, String> {

    Identity findByIdAndPassword(String id, String password);
}
