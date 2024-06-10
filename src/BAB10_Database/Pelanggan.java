/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB10_Database;

/**
 *
 * @author Fauzan
 */
public class Pelanggan {
    //Class Induk
    private String alamat, nomer_hp;

    //Setter
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNomer_hp(String nomer_hp) {
        this.nomer_hp = nomer_hp;
    }

    //Getter
    public String getAlamat() {
        return alamat;
    }

    public String getNomer_hp() {
        return nomer_hp;
    }
}
