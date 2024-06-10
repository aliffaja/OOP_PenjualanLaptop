/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB10_Database;

/**
 *
 * @author Fauzan
 */
public class Laptop extends Pelanggan{
    //Class Anak
    //Atribut
    public String nama,nama_laptop;
    private String pembayaran;
    public double harga,jumlah_uang,kembalian;
    
    //Method
    public void dataNama(String nama){
        this.nama = nama;
    }
    public void dataNama_Laptop(String nama_laptop){
        this.nama_laptop = nama_laptop;
    }
    public void dataHarga(double harga){
        this.harga = harga;
    }
    public void dataJumlah_Uang(double jumlah_uang){
        this.jumlah_uang = jumlah_uang;
    }

    //Overriding
    @Override
    public String getNomer_hp() {
        return super.getNomer_hp();
    }

    @Override
    public String getAlamat() {
        return super.getAlamat();
    }

    @Override
    public void setNomer_hp(String nomer_hp) {
        super.setNomer_hp(nomer_hp);
    }

    @Override
    public void setAlamat(String alamat) {
        super.setAlamat(alamat);
    }
    
    

    //Setter
    public void setPembayaran(String pembayaran) {
        this.pembayaran = pembayaran;
    }
    
    
    //Method
    String cetakNama(){
        return nama;
    }
    String cetakNama_Laptop(){
        return nama_laptop;
    }
    double cetakHarga(){
        return harga;
    }
    double cetakJumlah_Uang(){
        return jumlah_uang;
    }

    double cetakKembalian(){
        kembalian = jumlah_uang - harga;
        return kembalian;
    }
    
    //Getter
    public String getPembayaran() {
        return pembayaran;
    }
    
}
