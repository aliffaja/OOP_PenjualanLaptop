/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB10_Database;

/**
 *
 * @author Fauzan
 */
public class Pembayaran extends Laptop {
    private String norek;
    double jmlBayar;
    
    //Setter
    public void setNorek(String norek) {
        this.norek = norek;
    }
    
    //Method
    public void dataJumlahBayar(double jmlBayar){
        this.jmlBayar = jmlBayar;
    }
    
    //Getter
    public String getNorek() {
        return norek;
    }

    @Override
    String cetakNama() {
        return super.cetakNama();
    }
    
    
    
    //Method
    double cetakJumlahBayar(){
        return jmlBayar;
    }
}
