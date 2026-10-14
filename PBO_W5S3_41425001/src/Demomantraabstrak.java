/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
import java.util.*;

abstract class MantraAbstrak {
    private String nama;

    public MantraAbstrak(String nama) {
        this.nama = nama;
    }

    public abstract void efek();

    // Method konkret
    public void ucapkan() {
        System.out.println("Mengucapkan mantra: " + nama);
    }
}

class Expelliarmus extends MantraAbstrak {
    public Expelliarmus() {
        super("Expelliarmus");
    }

    @Override
    public void efek() {
        System.out.println("Efek: Melucuti senjata lawan.");
    }
}

class ExpectoPatronum extends MantraAbstrak {
    public ExpectoPatronum() {
        super("Expecto Patronum");
    }

    @Override
    public void efek() {
        System.out.println("Efek: Memanggil Patronus untuk melawan Dementor.");
    }
}

public class DemoMantraAbstrak {
    public static void main(String[] args) {
        MantraAbstrak mantra1 = new Expelliarmus();
        MantraAbstrak mantra2 = new ExpectoPatronum();

        mantra1.ucapkan();
        mantra1.efek();

        mantra2.ucapkan();
        mantra2.efek();
    }
}


//2.1 Abstract Class (DemoMantraAbstrak.java)

//1. Apa yang terjadi jika membuat objek MantraAbstrak langsung? 
//MantraAbstrak m = new MantraAbstrak("Test"); menghasilkan error kompilasi: MantraAbstrak is abstract; cannot be instantiated. Abstract class masih memiliki method yang belum diimplementasikan (efek()), sehingga objeknya tidak lengkap dan Java melarang pembuatannya.

//2. Mengapa perlu abstract class? Keuntungannya?

//-Memaksa semua subclass mengimplementasikan method penting (efek()) sehingga tidak ada mantra yang lupa punya efek.
//-Menyediakan kode bersama (atribut nama, method ucapkan()) agar tidak ditulis ulang (reuse).
//-Menjadi kontrak/kerangka yang jelas untuk hierarki class dan mendukung polymorphism.
//-Mencegah pembuatan objek yang terlalu umum dan tidak bermakna (mantra "tanpa jenis").