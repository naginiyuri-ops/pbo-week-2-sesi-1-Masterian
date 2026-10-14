/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B.Latihan1B;

/**
 *
 * @author Lenovo
 */

/*
Nama  : Masterian Lumbantoruan
NIM   : 41425001
Tugas : Pemrograman Berbasis Objek
 */

public class StudentGrade {

    // Semua atribut private (encapsulation)
    private final String nim;      // final: tidak bisa diubah setelah dibuat
    private final String nama;     // final: tidak bisa diubah setelah dibuat
    private double nilaiKuis;
    private double nilaiUTS;
    private String gradeHuruf;     // read-only: hanya punya getter

    // Constructor: NIM dan Nama hanya diisi sekali di sini
    public StudentGrade(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.nilaiKuis = 0.0;
        this.nilaiUTS = 0.0;
        this.gradeHuruf = hitungGradeHuruf(); // grade awal dari nilai 0
        System.out.println("[Registrasi] Berhasil mendaftarkan mahasiswa: "
                + nim + " - " + nama);
    }

    // Getter NIM dan Nama (tanpa setter -> read-only)
    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public double getNilaiKuis() {
        return nilaiKuis;
    }

    public double getNilaiUTS() {
        return nilaiUTS;
    }

    // Getter gradeHuruf (tanpa setter -> tidak bisa diubah dari luar)
    public String getGradeHuruf() {
        return gradeHuruf;
    }

    // Setter nilai kuis dengan validasi rentang 0.0 - 100.0
    public void setNilaiKuis(double nilai) {
        if (nilai < 0.0 || nilai > 100.0) {
            System.out.println("[Error] Nilai kuis tidak valid: " + nilai
                    + " (Harus antara 0 - 100)");
            return; // tolak perubahan
        }
        this.nilaiKuis = nilai;
        this.gradeHuruf = hitungGradeHuruf(); // update grade otomatis
        System.out.println("[Update] Nilai kuis berhasil diubah menjadi: " + nilai);
    }

    // Setter nilai UTS dengan validasi rentang 0.0 - 100.0
    public void setNilaiUTS(double nilai) {
        if (nilai < 0.0 || nilai > 100.0) {
            System.out.println("[Error] Nilai UTS tidak valid: " + nilai
                    + " (Harus antara 0 - 100)");
            return; // tolak perubahan
        }
        this.nilaiUTS = nilai;
        this.gradeHuruf = hitungGradeHuruf(); // update grade otomatis
        System.out.println("[Update] Nilai UTS berhasil diubah menjadi: " + nilai);
    }

    // Menghitung nilai akhir: 40% Kuis + 60% UTS
    public double hitungNilaiAkhir() {
        return (0.4 * nilaiKuis) + (0.6 * nilaiUTS);
    }

    // Method internal private: menentukan grade huruf dari nilai akhir
    private String hitungGradeHuruf() {
        double akhir = hitungNilaiAkhir();
        if (akhir >= 85) {
            return "A";
        } else if (akhir >= 70) {
            return "B";
        } else if (akhir >= 55) {
            return "C";
        } else if (akhir >= 40) {
            return "D";
        } else {
            return "E";
        }
    }

    // Mencetak laporan hasil studi
    public void cetakLaporan() {
        System.out.println("=== KARTU HASIL STUDI ===");
        System.out.println("NIM        : " + nim);
        System.out.println("Nama       : " + nama);
        System.out.println("Nilai Kuis : " + nilaiKuis);
        System.out.println("Nilai UTS  : " + nilaiUTS);
        System.out.println("Nilai Akhir: " + hitungNilaiAkhir());
        System.out.println("Grade      : " + gradeHuruf);
    }
}