/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
import java.util.*;

class Penyihir {
    public void ucapkanMantra() {
        System.out.println("Mengucapkan mantra dengan cara biasa.");
    }
}

class HarryPotter extends Penyihir {
    @Override
    public void ucapkanMantra() {
        System.out.println("Harry Potter mengucapkan mantra dengan tongkatnya yang unik.");
    }
}

class Hermione extends Penyihir {
    @Override
    public void ucapkanMantra() {
        System.out.println("Hermione mengucapkan mantra dengan tepat dan percaya diri.");
    }
}

// TUGAS: kelas RonWeasley mewarisi Penyihir dan meng-override ucapkanMantra()
class RonWeasley extends Penyihir {
    @Override
    public void ucapkanMantra() {
        System.out.println("Ron Weasley mengucapkan mantra Avadacadabra");
    }
}

public class DemoPenyihir {
    public static void main(String[] args) {
        Penyihir penyihir1 = new HarryPotter();
        Penyihir penyihir2 = new Hermione();
        Penyihir penyihir3 = new RonWeasley();

        penyihir1.ucapkanMantra();  
        penyihir2.ucapkanMantra(); 
        penyihir3.ucapkanMantra();
    }
}

//1.2 Method Overriding (DemoPenyihir.java)

//1. Jika tidak memakai @Override, apakah kode masih berjalan? 
//Masih berjalan dan hasilnya sama selama nama dan parameter method persis sama dengan induk. @Override hanyalah anotasi pengaman: jika kita salah ketik (misal ucapkanMantr()), compiler langsung memberi error. Tanpanya, method salah ketik dianggap method baru dan overriding diam-diam gagal (bug sulit dilacak).

//2. Keuntungan polymorphism di contoh ini? 
//Satu variabel bertipe Penyihir bisa menyimpan Harry, Hermione, atau Ron, dan ucapkanMantra() otomatis menjalankan versi milik objek aslinya. Kode pemanggil tidak perlu if/else per jenis penyihir, dan penyihir baru bisa ditambah tanpa mengubah kode yang sudah ada.