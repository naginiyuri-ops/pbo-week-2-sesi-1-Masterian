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


public class SmartAC implements Switchable, Connectable {

    private int suhu;         // derajat suhu (private)
    private boolean isOn;     // status sakelar (state)

    public SmartAC(int suhu) {
        this.suhu = suhu;
        this.isOn = false;    // awalnya mati
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("[AC Pintar] Dinyalakan pada suhu " + suhu + " C");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("[AC Pintar] Dimatikan.");
    }

    @Override
    public void connectToWifi(String ssid, String ipAddress) {
        // State management: tidak boleh konek WiFi kalau perangkat mati
        if (!isOn) {
            System.out.println("[Error] AC Pintar masih mati, "
                    + "nyalakan dulu sebelum terhubung ke WiFi!");
            return;
        }
        System.out.println("[WiFi Device] Terhubung ke jaringan: " + ssid
                + " (IP: " + ipAddress + ")");
    }
}
