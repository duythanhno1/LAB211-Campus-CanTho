/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JS.P0002_Long;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Duy Thanh
 */
public class Validation {
    private final static Scanner in = new Scanner(System.in);

    /**
     * check user input number limit
     * @param min value user input
     * @param max value user input
     * @return result min or max value to choose menu
     */
    public static int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * check user input 
     * @return result check user input 
     */
    public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.trim().isEmpty() || !result.matches("[a-zA-Z ]+[.]{0,1}[a-zA-Z0-9 ]+[.]{0,1}[a-zA-Z0-9 ]+[.]{0,1}")) {
                //System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    /**
     * check user input id
     * @return result check user input id from a-z and 0-9
     */
    public static String checkInputID() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.trim().isEmpty() || !result.matches("^[a-zA-Z0-9 ]+$")) {
                //System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    /**
     * check user input choose update and delete
     * @return result check user input 
     */
    public static String checkInput() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.trim().isEmpty() || !result.matches("^[a-zA-Z ]+$")) {
                //System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    /**
     * check user input choose update and delete
     * @return result check course user input is format 
     */
    public static String checkInputCourses() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.trim().isEmpty() || !result.matches("^[a-zA-Z.+/ ]+$")) {
                //System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    /**
     * check user input yes/ no
     * @return Check user input Y/y or N/n 
     */
    public static boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = checkInput();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }


    /**
     * check user input u / d
     * @return input to connect with function update and delete
     */
    public static boolean checkInputUD() {
        //loop until user input correct
        while (true) {
            String result = checkInput();
            //return true if user input u/U
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            //return false if user input d/D
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }


    /**
     * check user input course
     * @return input course is format java/.net/c/c++
     */
    public static String checkInputCourse() {
        //loop until user input correct
        while (true) {
            String result = checkInputCourses();
            //check input course in java/ .net/ c/c++
            if (result.equalsIgnoreCase("java")
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.err.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }


    /**
     * check student exist
     * @param ls list
     * @param id of student
     * @param studentName of student
     * @param semester of student
     * @param courseName of student
     * @return check exist student is list
     */
    public static boolean checkStudentExist(ArrayList<Student> ls, String id,
            String studentName, String semester, String courseName) {
        int size = ls.size();
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getId())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }

    /**
     * check report exist
     * @param lr list
     * @param name of student
     * @param course of student
     * @param total of student
     * @return check report student is list
     */
    public static boolean checkReportExist(ArrayList<Report> lr, String name,
            String course, int total) {
        for (Report report : lr) {
            if (name.equalsIgnoreCase(report.getStudentName())
                    && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }

    /**
     * check id and exist
     * @param ls list
     * @param id of student 
     * @param name of student 
     * @return if id has exist return false
     */
    public static boolean checkIdExist(ArrayList<Student> ls, String id, String name) {
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getId())
                    && !name.equalsIgnoreCase(student.getStudentName())) {
                return false;
            }
        }
        return true;
    }
        /**
     * check id and exist
     * @param ls list
     * @param id of student 
     * @return if id has exist return false
     */
    public static boolean checkIdExist1(ArrayList<Student> ls, String id) {
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getId())) {
                return false;
            }
        }
        return true;
    }
}
