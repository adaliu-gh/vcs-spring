package cn.edu.fudan.ada.vcspring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor{
    @Id
    private String id;
    private String name;

    protected Instructor(){};

    public Instructor(String id, String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString(){
        return String.format("Instructor[id=%s, name=%s]",id,name);
    }
}
