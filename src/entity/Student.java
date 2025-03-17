/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author jians
 */
public class Student implements Serializable {
    private String studentID;
    private String name;
    
    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name; 
    }
    
    public String getStudentID() {
        return studentID;
    }
    
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    
    public String getName() {
        return studentID;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Student ID: " + studentID + 
               "\nName: " + name;
    }
    
    
    
}
