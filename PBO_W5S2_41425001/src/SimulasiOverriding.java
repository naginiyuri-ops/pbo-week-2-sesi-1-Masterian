/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
class KurirReguler {
    protected String nama;

    public KurirReguler(String nama) {
        this.nama = nama;
    }

    public void kirimBarang(String alamat) {
        System.out.println(nama + " mengantar paket ke " + alamat + " lewat jalur darat menembus kemacetan.");
    }
}

class KurirDrone extends KurirReguler {
    private String idDrone;

    public KurirDrone(String nama, String idDrone) {
        super(nama);
        this.idDrone = idDrone;
    }

    @Override
    public void kirimBarang(String alamat) {
        System.out.println("Unit Drone [" + idDrone + "] operator " + nama +
                " terbang mengantar paket langsung ke koordinat: " + alamat);
    }
}

public class SimulasiOverriding {
    public static void main(String[] args) {
        System.out.println("=== INI METHOD OVERRIDING ===");

        KurirReguler k1 = new KurirReguler("Budi");

        KurirReguler k2 = new KurirDrone("Arka", "DRN-01");

        k1.kirimBarang("Jl. Sudirman No. 10");
        k2.kirimBarang("Gedung Graha Lt. 5");
    }
}

/*
 1. Setelah @Override dihapus dan nama method diubah menjadi kirimbarang
    (b kecil), output k2.kirimBarang("Gedung Graha Lt. 5") adalah:
      Arka mengantar paket ke Gedung Graha Lt. 5 lewat jalur darat menembus kemacetan.
    Jadi berubah menjadi JALUR DARAT, bukan udara. kirimbarang dianggap
    method baru (bukan override), dan karena k2 bertipe KurirReguler, yang
    terpanggil adalah kirimBarang milik parent.

 2. Setelah @Override dikembalikan di atas method yang salah ketik, error:
      error: method does not override or implement a method from a supertype

 3. Fungsi @Override bagi programmer:
    Memberi tahu compiler bahwa method ini dimaksudkan untuk menimpa method
    parent. Compiler lalu memeriksa apakah method itu benar-benar ada di
    parent dengan signature yang sama. Jika ada typo atau parameter berbeda,
    error muncul saat kompilasi, bukan menjadi bug tersembunyi saat program
    berjalan. Anotasi ini juga membuat kode lebih mudah dibaca.
 */
