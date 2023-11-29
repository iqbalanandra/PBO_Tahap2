
package perpus;

public class TransaksiPengembalian {
    private String judul;
    private int idTransaksi;
    private String waktuPeminjaman;

    public TransaksiPengembalian(String judul, int idTransaksi, String waktuPeminjaman) {
        this.judul = judul;
        this.idTransaksi = idTransaksi;
        this.waktuPeminjaman = waktuPeminjaman;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    
    public int getIdTransaksi() {
        return idTransaksi;
    }

    

    public String getJudul() {
        return judul;
    }

    public String getWaktuPeminjaman() {
        return waktuPeminjaman;
    }
    
    public String toString(){
        return "Buku '" + this.judul +"' Id Transaksi " + this.idTransaksi;
    }
}
