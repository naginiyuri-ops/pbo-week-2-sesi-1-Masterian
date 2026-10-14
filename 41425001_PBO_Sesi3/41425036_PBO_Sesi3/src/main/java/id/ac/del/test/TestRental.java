/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.del.test;

import id.ac.del.rental.CorporateDiscount;
import id.ac.del.rental.Discountable;
import id.ac.del.rental.FlashSaleDiscount;
import id.ac.del.rental.MemberDiscount;
import id.ac.del.rental.VehicleRental;

/**
 *
 * @author Lenovo
 */

/*
Nama  : Masterian Lumbantoruan
NIM   : 41425001
Tugas : Pemrograman Berbasis Objek
 */


public class TestRental {
    public static void main(String[] args) {
        VehicleRental v = new VehicleRental("BK 1234 DEL", 250000);

        // Data tidak valid sekarang ditolak oleh setter
        v.setPlateNumber("");     // ditolak: plat kosong
        v.setRentalDays(-7);      // ditolak: hari negatif

        // Data valid
        v.setRentalDays(7);

        // Tipe referensi adalah interface, objeknya bisa diganti-ganti (polimorfisme)
        Discountable member = new MemberDiscount();
        Discountable flash = new FlashSaleDiscount();
        Discountable corporate = new CorporateDiscount();

        System.out.println("Tanpa diskon   : Rp" + v.getTotalCost(null));
        System.out.println("Member (10%)   : Rp" + v.getTotalCost(member));
        System.out.println("Flash Sale(25%): Rp" + v.getTotalCost(flash));
        System.out.println("Corporate (15%): Rp" + v.getTotalCost(corporate));
    }
}

/*
Diskusi : 
/*
1) Analisis Kompilasi dan Hak Akses (Access Modifiers)
i) Saat TestRental.java dikompilasi, baris manakah di antara Baris A, B, C, dan D yang akan memicu compile-time error 

Jawaban:
Baris yang error:
* Baris B (v.rentalRatePerDay = -500000;) status COMPILE ERROR
* Baris C (v.discountRate = 0.20;) status COMPILE ERROR
Penjelasan:
* public: Bebas diakses dari package mana saja (Baris A dan D lolos).
* protected: Terbatas hanya untuk package yang sama dan subclass (Baris B error).
* default: Terbatas hanya untuk package yang sama, luar package mutlak ditolak (Baris C error).
* private: Terbatas penuh hanya untuk kelas itu sendiri.

2) Kelemahan Integritas Data (Data Hiding & Validation)
i) Perhatikan Baris A dan Baris D. Walaupun Baris D memanggil metode setter, apa cacat logika yang masih terjadi pada method setRentalDays?

Jawaban:
Setter setRentalDays tidak memiliki validasi data defensif, sehingga nilai tidak masuk akal seperti angka negatif (-7) tetap disimpan ke variabel.


ii) Nilai total biaya yang dihasilkan bisa bernilai negatif. Mengapa hal ini bisa terjadi dan bagaimana cara merefaktor kelas VehicleRental agar data keuangannya aman dari korupsi data (data corruption)?

Jawaban:
* Penyebab: Nilai 'rentalDays' bernilai negatif atau diskon lebih dari 100% langsung dihitung tanpa filter.
* Solusi:
  1. Ubah seluruh atribut menjadi 'private'.
  2. Berikan validasi (nilai harus > 0) di constructor dan setter dengan melempar IllegalArgumentException jika salah.
  3. Bungkus hasil akhir perhitungan menggunakan 'Math.max(0.0, total)' agar nominal tidak pernah akan  negatif.

3) Penerapan Interface (Dependency Injection)
Jika Sistem ini akan dikembangkan untuk mendukung berbagai skema diskon 
(misalnya MemberDiscount,FlashSaleDiscount, dan CorporateDiscount):

i) Rancanglah kontrak interface Discountable yang memiliki metode calculateDiscount(double amount).

Jawaban:
package id.ac.del.rental;

public interface Discountable {
    double calculateDiscount(double amount);
}


Jawab :
1. Berhasil dikompilasi tanpa error.
2. File Discountable.class akan terbentuk di dalam package id.ac.del.rental.
3. Belum memberi efek apa-apa ke program utama 
    (TestRental dan VehicleRental) karena belum ada kelas yang memakai 
    (implement) antarmuka ini.


ii) Ubah dan tuliskan ulang kode metode getTotalCost() pada kelas VehicleRental agar menerima parameter bertipe antarmuka Discountable. Supaya perhitungan total biaya dapat langsung mengenali dan memotong harga sesuai dengan objek diskon yang dikirimkan dari kelas TestRental saat runtime (polimorfisme).

Jawaban:
public double getTotalCost(Discountable discount) {
    double subtotal = this.rentalRatePerDay * this.rentalDays;
    if (discount == null) {
        return Math.max(0.0, subtotal);
    }
    double total = subtotal - discount.calculateDiscount(subtotal);
    return Math.max(0.0, total);
}

Jawab : yangterjadi itu   /*
Baris lama v.getTotalCost() bakal langsung error merah karena sekarang 
wajib diisi data di dalam kurungnya. Supaya tidak error,
panggil dengan v.getTotalCost(null) jika tidak pakai diskon,
atau v.getTotalCost(amount  amount * 0.10) 
jika mau memberi potongan harga.

*/