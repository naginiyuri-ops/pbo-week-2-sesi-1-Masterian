/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;
import java.util.List;

// Abstract class: kerangka semua mantra perlindungan
abstract class MantraPerlindungan {
    private String nama;
    protected boolean aktif = false; // status mantra (boleh diakses subclass)

    public MantraPerlindungan(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public boolean isAktif() {
        return aktif;
    }

    // Setiap mantra punya cara aktivasi & penonaktifan sendiri
    public abstract void aktifkan();
    public abstract void nonaktifkan();
}

// Protego: perisai pelindung
class Protego extends MantraPerlindungan {
    public Protego() {
        super("Piertotum Locomotor");
    }

    @Override
    public void aktifkan() {
        aktif = true;
        System.out.println("Menghidupkan patung-patung batu dan baju zirah kuno di seluruh kastil");
    }

    @Override
    public void nonaktifkan() {
        aktif = false;
        System.out.println("Menghentikan patung-patung batu dan baju zirah kuno di seluruh kastil");
    }
}

class Fidelius extends MantraPerlindungan {
    private String secretKeeper; // nama penyihir penjaga rahasia
    private String rahasia;      // rahasia yang dilindungi

    public Fidelius(String secretKeeper, String rahasia) {
        super("Protego Totalum");
        this.secretKeeper = secretKeeper;
        this.rahasia = rahasia;
    }

    @Override
    public void aktifkan() {
        // Tanpa secret keeper, mantra tidak bisa diaktifkan
        if (secretKeeper == null || secretKeeper.isEmpty()) {
            System.out.println("Protego Totalum GAGAL diaktifkan: butuh secret keeper!");
            return;
        }
        aktif = true;
        System.out.println("Protego Totalum! " + secretKeeper + " menjadi Secret Keeper dari: " + rahasia);
    }

    @Override
    public void nonaktifkan() {
        aktif = false;
        System.out.println("Fidelius dinonaktifkan. Rahasia '" + rahasia + "' tidak lagi tersembunyi.");
    }
}

class MantraAntiApparition extends MantraPerlindungan {
    private String area;

    public MantraAntiApparition(String area) {
        super("Repello Muggletum");
        this.area = area;
    }

    @Override
    public void aktifkan() {
        aktif = true;
        System.out.println("Repello Muggletum : tidak ada yang bisa ber-apparate di " + area + "!");
    }

    @Override
    public void nonaktifkan() {
        aktif = false;
        System.out.println("Repello Muggletum di " + area + " dinonaktifkan.");
    }
}

// Menampung banyak mantra perlindungan (bertipe abstract -> polymorphism)
class SistemPertahanan {
    private List<MantraPerlindungan> daftarMantra = new ArrayList<>();

    public void tambahMantra(MantraPerlindungan mantra) {
        daftarMantra.add(mantra);
        System.out.println("Mantra " + mantra.getNama() + " ditambahkan ke sistem pertahanan.");
    }

    public void aktifkanSemuaMantra() {
        System.out.println("\n=== Mengaktifkan semua mantra ===");
        for (MantraPerlindungan m : daftarMantra) {
            m.aktifkan(); // versi aktifkan() sesuai jenis mantra
        }
    }

    public void nonaktifkanSemuaMantra() {
        System.out.println("\n=== Menonaktifkan semua mantra ===");
        for (MantraPerlindungan m : daftarMantra) {
            m.nonaktifkan();
        }
    }
}

public class sistempertahananhogwarts {
    public static void main(String[] args) {
        SistemPertahanan hogwarts = new SistemPertahanan();

        hogwarts.tambahMantra(new Protego());
        hogwarts.tambahMantra(new Fidelius("Ginny", "Lokasi rumah keluarga Potter"));
        hogwarts.tambahMantra(new MantraAntiApparition("Kastil Hogwarts"));
        hogwarts.tambahMantra(new Fidelius("", "Ruang Kebutuhan")); // tanpa secret keeper -> gagal

        hogwarts.aktifkanSemuaMantra();
        hogwarts.nonaktifkanSemuaMantra();
    }
}
