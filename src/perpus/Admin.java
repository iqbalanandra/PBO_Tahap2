/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpus;

import java.util.ArrayList;

/**
 *
 * @author Fuad.H
 */
public class Admin {
    private int id_admin;
    private String nama_admin;
    
    ArrayList<AnggotaPerpustakaan> add = new ArrayList<>();
    ArrayList<Buku> daftarbuku = new ArrayList<>();
    ArrayList<Notifikasi> aktivitas = new ArrayList<>();

    public Admin(int id_admin, String nama_admin) {
        this.id_admin = id_admin;
        this.nama_admin = nama_admin;
    }
    
    //MENGELOLA ANGGOTA
    public void addAnggota(String nama, int nomorAnggota, String alamat, String historyPeminjaman){
        AnggotaPerpustakaan anggota = new AnggotaPerpustakaan(nama, nomorAnggota, alamat, historyPeminjaman);
        add.add(anggota);
    }
    
    public void addAnggota(AnggotaPerpustakaan anggota){
        add.add(anggota);
    }
    
    public void removeAnggota(String nama){
        boolean ditemukan = false;
        for(AnggotaPerpustakaan value : add){
            if(value.getNama().contains(nama)){
                add.remove(value);
                System.out.println("Berhasil Menghapus " + value.getNama() + "\n");
                ditemukan = true;
                break;
            }
        }   
        if(!ditemukan){
            System.out.println("Anggota Tidak Ditemukan");
        }
    }
    
    //MENGELOLA BUKU
    public void addBuku(String judul, String pengarang, int nomorISBN, boolean statusKetersediaan){
        Buku daftar = new Buku(judul, pengarang, nomorISBN, statusKetersediaan);
        System.out.println("============================== Notifikasi ===============================");
        System.out.println("Buku Baru Telah Tersedia!");
        System.out.println("Judul     : " + judul);
        System.out.println("Pengarang : " + pengarang);
        System.out.println("");
        daftarbuku.add(daftar);
    }
    
    public void addBuku(Buku buku){
        daftarbuku.add(buku);
    }
    
    public void removeBuku(String Judul){
        for(Buku value : daftarbuku){
            if(value.getJudul().contains(Judul)){
                daftarbuku.remove(value);
            }
        }
    }
    
    public void tampilkanAnggota(){
        System.out.print("====================== Daftar Anggota LibraTech =========================");
        
        for(AnggotaPerpustakaan value : add){
            System.out.print("\nNama               : " + value.getNama());
            System.out.println("\nNomor              : "+value.getNomorAnggota());
            System.out.println("Alamat             : "+value.getAlamat());
            System.out.println("Riwayat Peminjaman : "+value.getHistoryPeminjaman());
        }
        System.out.println("=========================================================================\n");
    }
    
    
    
    public void aktivitas(){
        for(Notifikasi value : aktivitas){
            System.out.println("================================ Aktivitas ==============================\n");
            System.out.println(value.getNama() + "\nMeminjam " + " " + value.getId());
            System.out.println("Pada " + value.getWaktu());
            System.out.println("=========================================================================\n");
        }
    }
}
