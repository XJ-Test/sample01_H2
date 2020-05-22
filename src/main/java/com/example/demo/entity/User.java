package com.example.demo.entity;

/**
 * @author Raymond
 * @create 2020-05-04-22:53
 */
public class User {
    //    @Id
    //    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //    @Column
    private String userID;
    //    @Column
    private String userName;
    //    @Column
    private String userPwd;

    public Integer getId() {
        return id;
    }
    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }
}
