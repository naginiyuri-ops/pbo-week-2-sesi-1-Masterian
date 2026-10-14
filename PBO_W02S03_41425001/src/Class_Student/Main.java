/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_Student;

/**
 *
 * @author LENOVO
 */


class Student {
    int id;
    String n;

    public Student (int id, String n) {
        this.id = id;
        this.n = n;
    }
}
public class Main {
    public static void main(String[] args) {
    
        Student sl new Student (10, "Alice");
        
        System.out.println(sl.id);
        System.out.println(sl.n);
    }
}
