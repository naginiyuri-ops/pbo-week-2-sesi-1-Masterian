/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B.Latihan1B.Latihan2B;

/**
 *
 * @author Lenovo
 */

/*
Nama  : Masterian Lumbantoruan
NIM   : 41425001
Tugas : Pemrograman Berbasis Objek
 */

public class Main {
    public static void main(String[] args) {
        SmartLamp lampu = new SmartLamp(80);
        SmartAC ac = new SmartAC(22);

        // Alur normal lampu: nyalakan, lalu hubungkan ke WiFi
        lampu.turnOn();
        lampu.connectToWifi("Rumah_Indah_5G", "192.168.1.50");

        // Alur normal AC: nyalakan, hubungkan ke WiFi, lalu matikan
        ac.turnOn();
        ac.connectToWifi("Rumah_Indah_5G", "192.168.1.51");
        ac.turnOff();
    }
}
