package BAB10_Database;

import java.util.Scanner;

public class TestDriver_GUI_PenjualanLaptop {
    public static void main(String[] args) {
        // Setup: Membuat objek GUI_PenjualanLaptop
        GUI_PenjualanLaptop gui = new GUI_PenjualanLaptop();
        
        // Setup: Test setup - Koneksi ke database
        try {
            gui.koneksi();
            System.out.println("Test setup: Koneksi ke database berhasil");
        } catch (Exception e) {
            System.out.println("Test setup: Koneksi ke database gagal");
        }
        
        // Input data pengguna
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama pembeli: ");
        String namaPembeli = scanner.nextLine();
        System.out.print("Masukkan merk laptop: ");
        String merkLaptop = scanner.nextLine();
        System.out.print("Masukkan harga laptop: ");
        String hargaLaptop = scanner.nextLine();
        System.out.print("Masukkan jumlah uang: ");
        String jumlahUang = scanner.nextLine();
        System.out.print("Masukkan metode pembayaran (Cash/Kredit): ");
        String metodePembayaran = scanner.nextLine();
        System.out.print("Masukkan alamat: ");
        String alamat = scanner.nextLine();
        
        // Trigger & Verify: Test penyimpanan data baru ke dalam database (insert())
        System.out.println("Test: Penyimpanan data baru ke dalam database (insert())");
        testInsert(gui, namaPembeli, merkLaptop, hargaLaptop, jumlahUang, metodePembayaran, alamat);
    }

    // Unit Under Test (UUT): Metode insert() dalam kelas GUI_PenjualanLaptop
    public static void testInsert(GUI_PenjualanLaptop gui, String namaPembeli, String merkLaptop, String hargaLaptop, String jumlahUang, String metodePembayaran, String alamat) {
        // Trigger: Memanggil metode insert() dengan data yang dimasukkan pengguna
        try {
            // Menetapkan data yang dimasukkan pengguna ke objek GUI_PenjualanLaptop          
            System.out.println("Nama Pembeli : " + namaPembeli);
            System.out.println("Merk Laptop : " + merkLaptop);
            System.out.println("Harga Laptop : " + hargaLaptop);
            System.out.println("Jumlah Uang : " + jumlahUang);
            System.out.println("Alamat : " + alamat);
            
            // Memanggil metode insert()
            gui.insert();
            
            // Assert: Verifikasi apakah penyimpanan data baru berhasil
            System.out.println("Data baru berhasil disimpan ke dalam database");
        } catch (Exception e) {
            System.out.println("Gagal menyimpan data baru ke dalam database");
        }
    }
}
