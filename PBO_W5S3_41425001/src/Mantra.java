/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

import java.util.*;

public class Mantra {
    // Method ucapkan() dengan satu parameter
    public void ucapkan(String namaMantra) {
        System.out.println("Mengucapkan mantra: " + namaMantra);
    }

    // Overload: method ucapkan() dengan dua parameter
    public void ucapkan(String namaMantra, int kekuatan) {
        System.out.println("Mengucapkan mantra: " + namaMantra + " dengan kekuatan " + kekuatan);
        if (kekuatan > 10) {
            System.out.println("Efek: Lawan terlempar!");
        } else {
            System.out.println("Efek: Senjata terlepas.");
        }
    }

    // Overload: method ucapkan() dengan tiga parameter
    public void ucapkan(String namaMantra, int kekuatan, String target) {
        System.out.println("Mengucapkan mantra: " + namaMantra + " dengan kekuatan " + kekuatan + " pada " + target);
        if (kekuatan > 10) {
            System.out.println("Efek: " + target + " terlempar!");
        } else {
            System.out.println("Efek: Senjata " + target + " terlepas.");
        }
    }

    public static void main(String[] args) {
        Mantra mantra = new Mantra();                    
        mantra.ucapkan("Expelliarmus");                    
        mantra.ucapkan("Expelliarmus", 5);                 
        mantra.ucapkan("Expelliarmus", 15, "Voldemort"); 
    }
}

// 1.1 Method Overloading (Mantra.java)

//1. Apa yang terjadi jika salah satu method overloading dihapus (misal yang dua parameter)? 
//Pemanggilan mantra.ucapkan("Expelliarmus", 5) menjadi compile error ("no suitable method found"), karena tidak ada lagi method dengan signature (String, int). Java memilih method berdasarkan jumlah dan tipe parameter saat kompilasi; jika tidak ada yang cocok, program tidak bisa dikompilasi.

//2. Bisakah overloading dengan urutan parameter berbeda? 
//Bisa. ucapkan(int kekuatan, String namaMantra) sah sebagai overload karena daftar tipe parameternya (int, String) berbeda dengan (String, int). Yang dibedakan adalah urutan tipe, bukan nama parameter. Catatan: hanya mengubah return type tidak cukup untuk overloading.
