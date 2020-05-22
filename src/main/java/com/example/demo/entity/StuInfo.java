package com.example.demo.entity;



//@Entity
//@Table(name = "tb_StuInfo")
public class StuInfo {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
//    @Column
    private String classID;
//    @Column
    private String className;
//    @Column
    private String stuID;
//    @Column
    private String stuName;
//    @Column
    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "StuInfo{" +
                "id=" + id +
                ", classID='" + classID + '\'' +
                ", className='" + className + '\'' +
                ", stuID='" + stuID + '\'' +
                ", stuName='" + stuName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
