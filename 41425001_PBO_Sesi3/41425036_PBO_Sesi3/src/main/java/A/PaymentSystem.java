package A;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */

/*
Nama  : Masterian Lumbantoruan
NIM   : 41425001
Tugas : Pemrograman Berbasis Objek
 */

// Interface: kontrak yang harus dipenuhi semua metode pembayaran
interface PaymentMethod {
    // Konstanta biaya admin (di interface otomatis public static final)
    double TRANSACTION_FEE = 2500.0;

    // Method tanpa isi, wajib di-override oleh class yang mengimplementasikan
    void pay(double amount);
    String getPaymentDetails();
}

// Implementasi pembayaran lewat dompet digital
class EWalletPayment implements PaymentMethod {
    private String phoneNumber; // data privat (encapsulation)

    public EWalletPayment(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void pay(double amount) {
        // E-Wallet dikenakan biaya admin
        double total = amount + TRANSACTION_FEE;
        System.out.println("[E-Wallet " + phoneNumber + "] Pembayaran diproses: Rp" + amount
                + " (Biaya admin: Rp" + TRANSACTION_FEE + ") | Total: Rp" + total);
    }

    @Override
    public String getPaymentDetails() {
        return "Metode: E-Wallet (" + phoneNumber + ")";
    }
}

// Implementasi pembayaran lewat kartu kredit
class CreditCardPayment implements PaymentMethod {
    private String cardNumber; // data privat (encapsulation)

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        // Kartu kredit di contoh ini tidak memakai biaya admin
        System.out.println("[Credit Card " + cardNumber
                + "] Pembayaran berhasil diverifikasi sebesar: Rp" + amount);
    }

    @Override
    public String getPaymentDetails() {
        return "Metode: Kartu Kredit (" + cardNumber + ")";
    }
}

// Kelas utama
public class PaymentSystem {
    public static void main(String[] args) {
        // Variabel bertipe interface, objeknya berbeda-beda (polimorfisme)
        PaymentMethod payment1 = new EWalletPayment("08123456789");
        PaymentMethod payment2 = new CreditCardPayment("4111-XXXX-XXXX-1234");

        // Perintah yang sama (pay), perilaku berbeda sesuai objeknya
        payment1.pay(50000);
        payment2.pay(150000);
    }
}
