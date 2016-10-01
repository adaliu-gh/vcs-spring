package cn.edu.fudan.ada.vcsSpring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course{
    @Id
    private String id;
    private String name;
    private String iId;
    private String iName;

    protected Course(){};

    public Course(String id, String name, String iId, String iName){
        this.id=id;
        this.name=name;
        this.iId=iId;
        this.iName=iName;
    }

    @Override
    public String toString(){
        return String.format("Course[id=%s, name=%S,iId=%s,iName=%s]",id,name,iId,iName);
    }
}
