package com.example.demo.entity;



//@Entity
//@Table(name="tb_stu")
public class StuGrade {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
//    @Column
    private String stuID;
//    @Column
    private String stuName;
//    @Column
    private Float grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "info{" +
                "id=" + id +
                ", stuID='" + stuID + '\'' +
                ", stuName='" + stuName + '\'' +
                ", grade=" + grade +
                '}';
    }

}
