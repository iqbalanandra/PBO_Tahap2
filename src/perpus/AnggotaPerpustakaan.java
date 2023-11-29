
package perpus;
import java.util.ArrayList;

public class AnggotaPerpustakaan {
    private String nama;
    private int nomorAnggota;
    private String alamat;
    private String historyPeminjaman;

    
    private ArrayList<TransaksiPengembalian> daftarTransaksi = new ArrayList<>();
    private ArrayList<Buku> bukuPinjaman = new ArrayList<>();
    private StringBuilder rekapTransaksi = new StringBuilder();
    private TransaksiPeminjaman transaksi;
    private Admin admin;

    public AnggotaPerpustakaan(Admin admin, String nama, int nomorAnggota, String alamat, String historyPeminjaman, TransaksiPeminjaman transaksi) {
        this.admin = admin;
        this.nama = nama;
        this.nomorAnggota = nomorAnggota;
        this.alamat = alamat;
        this.historyPeminjaman = historyPeminjaman;
        this.transaksi = transaksi;

        // Memastikan admin tidak 'null' saat addAnggota
        if (admin != null) {
            admin.addAnggota(this);
        } else {
            System.out.println("Error: Admin is null in AnggotaPerpustakaan constructor");
        }
    }

    public void mencariKoleksiBuku(String judul) {
        boolean ditemukan = false;
        for (Buku value : admin.daftarbuku) {
            if (value.getJudul().contains(judul)) {
                System.out.println("Judul        : " + value.getJudul());
                System.out.println("Pengarang    : " + value.getPengarang());
                System.out.println("NomorISBN    : " + value.getNomorISBN());
                System.out.println("Ketersediaan : " + value.isStatusKetersediaan());
                System.out.println(" ");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println(judul + " Tidak Ditemukan");
        }
    }

    public void pinjamBuku(String judul) {
        StringBuilder pinjam = new StringBuilder();
        boolean ditemukan = false;

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\n                  PEMINJAMAN BUKU                ");
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        for (Buku value : admin.daftarbuku) {
            if (value.getJudul().equalsIgnoreCase(judul) && value.isStatusKetersediaan()) {
                pinjam.append("Peminjam          : " + nama).append("\nNomor Anggota     : " + nomorAnggota);
                pinjam.append("\nMeminjam Buku     : " + value.getJudul());
                bukuPinjaman.add(value);
                value.setStatusKetersediaan(false);
                ditemukan = true;
                rekapTransaksi.append(judul).append(", ");
                historyPeminjaman = rekapTransaksi.toString();
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Buku \"" + judul + "\" tidak tersedia atau sudah dipinjam.");
        } else {
            System.out.println(pinjam.toString());
        }
    }


    public void mengembalikanBuku(String judul, int durasiPengembalian) {
        boolean berhasil = false;
        for (Buku value : bukuPinjaman) {
            if (value.getJudul().equals(judul)) {
                value.setStatusKetersediaan(true);
                bukuPinjaman.remove(value);
                berhasil = true;
                break;
            }
        }
        if (berhasil) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\n                 PENGEMBALIAN BUKU               ");
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Nama             : " + nama + "\nID               : " + nomorAnggota);
            System.out.println("Berhasil Mengembalikan Buku " + judul);
            System.out.println("Waktu Peminjaman : " + transaksi.getWaktuPeminjaman());
            System.out.print("Durasi Peminjaman " + durasiPengembalian + " Hari\n");
        } else {
            System.out.println("Tidak Ada Buku Yang Sesuai!");
        }
    }

    public void tampilkanTransaksi() {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\n                  TOTAL TRANSAKSI                 ");
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Total Transaksi " + nama);
        System.out.print("Buku Yang Di Pinjam : \n");
        for (TransaksiPengembalian value : daftarTransaksi) {
            System.out.print(value.getJudul() + " " + value.getIdTransaksi());
            System.out.print(" Pada : " + value.getWaktuPeminjaman());
            System.out.println();
        }
    }

    public String getNama() {
        return nama;
    }

    public int getNomorAnggota() {
        return nomorAnggota;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getHistoryPeminjaman() {
        return historyPeminjaman;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNomorAnggota(int nomorAnggota) {
        this.nomorAnggota = nomorAnggota;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setHistoryPeminjaman(String historyPeminjaman) {
        this.historyPeminjaman = historyPeminjaman;
    }

    public int getTotalPinjaman() {
        return bukuPinjaman.size();
    }

    public void setTotalPinjaman(int totalPinjaman) {

    }

    public String toString() {
        return "Nama: " + this.nama + " Nomor Anggota: " + this.nomorAnggota;
    }
}
