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

public class BankAccount {

    // Atribut private (encapsulation): tidak bisa diakses langsung dari luar class
    private String accountNumber;
    private double balance;

    // Constructor: mengisi nomor rekening dan saldo awal
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        // Validasi: saldo awal tidak boleh negatif
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Saldo awal tidak boleh negatif! Diatur ke 0.");
            this.balance = 0;
        }
    }

    // Getter nomor rekening
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter saldo
    public double getBalance() {
        return balance;
    }

    // Setor tunai: jumlah harus positif
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Setor berhasil: Rp" + amount);
        } else {
            System.out.println("Jumlah setoran harus lebih besar dari 0!");
        }
    }

    // Tarik tunai: jumlah harus valid dan tidak boleh melebihi saldo
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Jumlah penarikan tidak valid!");
        } else if (amount > this.balance) {
            System.out.println("Penarikan gagal: Saldo tidak mencukupi!");
        } else {
            this.balance -= amount;
            System.out.println("Tarik tunai berhasil: Rp" + amount);
        }
    }

    // Method main untuk menguji class
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", 500000);

        acc.deposit(-100000);   // ditolak: setoran negatif
        acc.withdraw(700000);   // gagal: melebihi saldo
        acc.withdraw(200000);   // berhasil

        System.out.println("Saldo akhir akun " + acc.getAccountNumber()
                + ": Rp" + acc.getBalance());
    }
}
    

