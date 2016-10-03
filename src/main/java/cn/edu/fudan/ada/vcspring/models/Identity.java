package cn.edu.fudan.ada.vcspring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="identity")
public class Identity {

    @Id
    private String id;
    private String password;
    private String role;

    protected Identity() {}

    public Identity(String id,String password, String role) {
        this.id=id;
        this.password = password;
        this.role=role;
    }

    @Override
    public String toString() {
        return String.format(
                             "Identity[id=%s,  password=%s, role=%s]",
                             id, password, role);
    }


    public String getId() {
        return id;
    }

    public String getPassword(){
        return password;
    }
    public String getRole(){
        return role;
    }
}
