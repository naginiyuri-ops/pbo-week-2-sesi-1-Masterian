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


public class SmartLamp implements Switchable, Connectable {

    private int kecerahan;     // persentase kecerahan (private)
    private boolean isOn;      // status sakelar (state)

    public SmartLamp(int kecerahan) {
        this.kecerahan = kecerahan;
        this.isOn = false;     // awalnya mati
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("[Lampu Pintar] Dinyalakan dengan kecerahan "
                + kecerahan + "%");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("[Lampu Pintar] Dimatikan.");
    }

    @Override
    public void connectToWifi(String ssid, String ipAddress) {
        // State management: tidak boleh konek WiFi kalau perangkat mati
        if (!isOn) {
            System.out.println("[Error] Lampu Pintar masih mati, "
                    + "nyalakan dulu sebelum terhubung ke WiFi!");
            return;
        }
        System.out.println("[WiFi Device] Terhubung ke jaringan: " + ssid
                + " (IP: " + ipAddress + ")");
    }
}
