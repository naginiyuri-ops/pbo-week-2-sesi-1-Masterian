/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.del.rental;

/**
 *
 * @author Lenovo
 */

/*
Nama  : Masterian Lumbantoruan
NIM   : 41425001
Tugas : Pemrograman Berbasis Objek
 */


public class VehicleRental {

    // Semua atribut private (data hiding)
    private String plateNumber;
    private double rentalRatePerDay;
    private int rentalDays;

    // Constructor memvalidasi data awal
    public VehicleRental(String plateNumber, double rate) {
        setPlateNumber(plateNumber);
        setRentalRatePerDay(rate);
        this.rentalDays = 0; // awalnya belum ada hari sewa
    }

    // ===== Getter =====
    public String getPlateNumber() {
        return plateNumber;
    }

    public double getRentalRatePerDay() {
        return rentalRatePerDay;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    // ===== Setter dengan validasi =====
    public void setPlateNumber(String plateNumber) {
        // Plat nomor tidak boleh null atau kosong
        if (plateNumber == null || plateNumber.trim().isEmpty()) {
            System.out.println("[Error] Plat nomor tidak boleh kosong!");
            return; // tolak perubahan
        }
        this.plateNumber = plateNumber;
    }

    public void setRentalRatePerDay(double rate) {
        // Tarif harus positif
        if (rate <= 0) {
            System.out.println("[Error] Tarif per hari harus lebih dari 0!");
            return;
        }
        this.rentalRatePerDay = rate;
    }

    public void setRentalDays(int days) {
        // Hari sewa minimal 1
        if (days <= 0) {
            System.out.println("[Error] Lama sewa harus minimal 1 hari! (input: " + days + ")");
            return;
        }
        this.rentalDays = days;
    }

    /**
     * Menghitung total biaya dengan skema diskon yang dikirim dari luar.
     * Parameter bertipe interface, sehingga objek diskon apa pun
     * (MemberDiscount, FlashSaleDiscount, dst.) bisa dipakai (polimorfisme).
     */
    public double getTotalCost(Discountable discount) {
        double subtotal = rentalRatePerDay * rentalDays;

        // Jika tidak ada diskon, kembalikan harga normal
        if (discount == null) {
            return subtotal;
        }

        double potongan = discount.calculateDiscount(subtotal);

        // Potongan tidak boleh melebihi subtotal, sehingga total tidak pernah negatif
        potongan = Math.min(potongan, subtotal);

        return subtotal - potongan;
    }
}
