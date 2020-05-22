//package com.example.demo.repository;
//
//import com.example.demo.entity.StuGrade;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.transaction.annotation.Transactional;
//
//@Transactional
//public interface UserRepository  extends JpaRepository<StuGrade,Integer> {
//
//    @Modifying
//    @Query("UPDATE StuGrade u SET u.grade = ?1 WHERE u.stuID = ?2 and u.stuName=?3")
//    public void updateStu(Float grade,String stuID,String stuName);
//}
