package cn.edu.fudan.ada.vcspring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="register")
public class Register{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String courseId;
    private String courseName;
    private String studentId;
    private String studentName;
    private String instructorId;
    private String instructorName;
    private int score=-1;

    protected Register(){};

    public Register(String courseId, String courseName, String studentId, String studentName, String instructorId, String instructorName){
        this.courseId=courseId;
        this.courseName=courseName;
        this.studentId=studentId;
        this.studentName=studentName;
        this.instructorId=instructorId;
        this.instructorName=instructorName;
    }

    @Override
    public String toString(){
        return String.format("Register[id=%d, courseId=%s, courseName=%s, studentId=%s, studentName=%s, instructorId=%s,instructorName=%s,score=%d]",id,courseId,courseName,studentId,studentName,instructorId,instructorName,score);
    }

    public String getCourseId(){
        return courseId;
    }
    public String getCourseName(){
        return courseName;
    }
    public String getStudentId(){
        return studentId;
    }
    public String getStudentName(){
        return studentName;
    }
    public String getInstructorId(){
        return instructorId;
    }
    public String getInstructorName(){
        return instructorName;
    }
    public int getScore(){
        return score;
    }
}
