package cn.edu.fudan.ada.vcspring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course{
    @Id
    private String id;
    private String name;
    private String iId;
    private String iName;
    private int capacity=2;
    private int margin=2;

    protected Course(){};

    public Course(String id, String name, String iId, String iName){
        this.id=id;
        this.name=name;
        this.iId=iId;
        this.iName=iName;
    }

    @Override
    public String toString(){
        return String.format("Course[id=%s, name=%S,iId=%s,iName=%s,capacity=%d,margin=%d]",id,name,iId,iName);
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getIId(){
        return iId;
    }
    public String getIName(){
        return iName;
    }
    public int getCapacity(){
        return capacity;
    }
    public int getMargin(){
        return margin;
    }
    public void setMargin(int margin){
        this.margin=margin;
    }
}
