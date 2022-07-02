/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JS.P0002_Long;

/**
 *
 * @author Duy Thanh
 */
public class Student  implements Comparable<Student> {
    private String id; // id of student
    private String studentName; // name of student 
    private String semester; // semester of student
    private String courseName; // course name of student

    /**
     * Constructor
     */
    public Student() {
    }

    /**
     * Constructor
     * @param id of student from user
     * @param studentName of student from user
     * @param semester of student from user
     * @param courseName of student from user
     */
    public Student(String id, String studentName, String semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    /**
     *  get id
     * @return id getter
     */
    public String getId() {
        return id;
    }

    /**
     *  set id
     * @param id setter
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *  get student name
     * @return studentName getter
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * set student name
     * @param studentName setter
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     *  get Semester 
     * @return semester getter
     */
    public String getSemester() {
        return semester;
    }

    /**
     *  set semester 
     * @param semester setter
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     *  get course name
     * @return courseName getter
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * set course name
     * @param courseName setter
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public int compareTo(Student t) {
        return t.studentName.compareTo(this.studentName);
    }

    /**
     * Function print 
     */
    public void print() {
        System.out.printf("%-15s%-15s%-15s%-15s\n",id ,studentName, semester, courseName);
    }
}

class Report {

    private String studentName; // name of student
    private String courseName; // course of student 
    private int totalCourse; // total course of student 
    // constructer
    public Report() {
    }
    // create constructer
    public Report(String studentName, String courseName, int totalCourse) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }
    // get student name
    public String getStudentName() {
        return studentName;
    }
    // set student name
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    // get getCourseName
    public String getCourseName() {
        return courseName;
    }
    // set setCourseName
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    // get getTotalCourse
    public int getTotalCourse() {
        return totalCourse;
    }
    // set getTotalCourse
    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }
}
