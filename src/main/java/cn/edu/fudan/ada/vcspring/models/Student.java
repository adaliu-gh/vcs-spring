package cn.edu.fudan.ada.vcspring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

    @Id
    private String id;
    private String name;

    protected Student() {}

    public Student(String id,String name) {
        this.id=id;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                             "Student[id=%s,  name='%s']",
                             id, name);
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
