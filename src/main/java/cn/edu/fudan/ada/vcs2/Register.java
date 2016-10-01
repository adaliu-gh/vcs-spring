package cn.edu.fudan.ada.vcs2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Register{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String cId;
    private String cName;
    private String sId;
    private String sName;
    private String iId;
    private String iName;
    private int score;

    protected Register(){};

    public Register(String cId, String cName, String sId, String sName, String iId, String iName){
        this.cId=cId;
        this.cName=cName;
        this.sId=sId;
        this.sName=sName;
        this.iId=iId;
        this.iName=iName;
    }

    @Override
    public String toString(){
        return String.format("Register[id=%d, cId=%s, cName=%s, sId=%s, sName=%s, iId=%s,iName=%s,score=%d]",id,cId,cName,sId,sName,iId,iName,score);
    }
}
