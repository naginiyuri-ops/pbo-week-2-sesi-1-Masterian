/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo_week_2_sesi_1;

/**
 *
 * @author LENOVO
 */
// Class
class Demo {
    int a, b;
    Demo(int a, int b){ this.a=a; this.b=b; }
    int addition(){ return a+b; }
}

// String
String s1 = "Hello";
String s2 = new String("Java");

// Array
int[] arr = {1, 2, 3};
double[] arr2 = {1.1, 2.2};

// Interface
interface Operasi {
    int tambah(int a,int b);
}
class Kalkulator implements Operasi {
    public int tambah(int a,int b){ return a+b; }
}
