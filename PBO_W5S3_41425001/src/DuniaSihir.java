/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
import java.util.*;

import java.util.ArrayList;
import java.util.List;

// Abstract class Mantra
abstract class Mantra {
    private String nama;

    public Mantra(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public abstract void efek();
}

class Expelliarmus extends Mantra {
    public Expelliarmus() {
        super("Expelliarmus");
    }

    @Override
    public void efek() {
        System.out.println("Melucuti senjata lawan!");
    }
}

class ExpectoPatronum extends Mantra {
    public ExpectoPatronum() {
        super("Expecto Patronum");
    }

    @Override
    public void efek() {
        System.out.println("Memanggil Patronus!");
    }
}

class Lumos extends Mantra {
    public Lumos() {
        super("Lumos");
    }

    @Override
    public void efek() {
        System.out.println("Menerangi ujung tongkat!");
    }
}

class Penyihir {
    private String nama;
    private List<Mantra> mantraList;

    public Penyihir(String nama) {
        this.nama = nama;
        this.mantraList = new ArrayList<>();
    }

    public void belajarMantra(Mantra mantra) {
        mantraList.add(mantra);
        System.out.println(nama + " belajar mantra: " + mantra.getNama());
    }

    public void ucapkanMantra(String namaMantra) {
        for (Mantra mantra : mantraList) {
            if (mantra.getNama().equals(namaMantra)) {
                System.out.println(nama + " mengucapkan: " + mantra.getNama());
                mantra.efek();
                return;
            }
        }
        System.out.println(nama + " belum belajar mantra " + namaMantra);
    }
}

public class DuniaSihir {
    public static void main(String[] args) {
        Penyihir harry = new Penyihir("Harry Potter");
        Mantra expelliarmus = new Expelliarmus();
        Mantra expectoPatronum = new ExpectoPatronum();

        harry.belajarMantra(expelliarmus);
        harry.belajarMantra(expectoPatronum);

        harry.ucapkanMantra("Expelliarmus");
        harry.ucapkanMantra("Expecto Patronum");
        harry.ucapkanMantra("Lumos"); // Harry belum belajar Lumos

        Mantra lumos = new Lumos();
        harry.belajarMantra(lumos);
        harry.ucapkanMantra("Lumos");
    }
}

//3.1 Kombinasi Polymorphism & Abstract Class (DuniaSihir.java)

//1. Bagaimana keduanya bekerja sama? 
//Abstract class Mantra mendefinisikan kontrak (getNama() dan efek()). Kelas Penyihir hanya bergantung pada tipe abstrak Mantra (di List<Mantra>). Saat mantra.efek() dipanggil, Java memilih implementasi sesuai objek aslinya (Expelliarmus, ExpectoPatronum, atau Lumos) lewat polymorphism. Abstract class menjamin semua mantra punya efek(), polymorphism memilih versi yang tepat saat runtime.

//2. Jika menambah mantra baru tanpa mengubah kelas Penyihir, apakah mudah? 
//Sangat mudah. Cukup buat class baru yang extends Mantra dan implementasikan efek(), lalu panggil penyihir.belajarMantra(new MantraBaru()). Kelas Penyihir tidak perlu diubah karena hanya mengenal tipe Mantra. Ini prinsip Open/Closed: terbuka untuk ekstensi, tertutup untuk modifikasi.
