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
    private String instructorId;
    private String instructorName;
    private int capacity=2;
    private int margin=2;

    protected Course(){};

    public Course(String id, String name, String instructorId, String instructorName){
        this.id=id;
        this.name=name;
        this.instructorId=instructorId;
        this.instructorName=instructorName;
    }

    @Override
    public String toString(){
        return String.format("Course[id=%s, name=%S,instructorId=%s,instructorName=%s,capacity=%d,margin=%d]",id,name,instructorId,instructorName);
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getInstructorId(){
        return instructorId;
    }
    public String getInstructorName(){
        return instructorName;
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
