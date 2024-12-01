package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class ThongKe {
    private date d;
    private int soluongNguoiDung;
    private int soluongTaiLieu;
    private int soluongPhieuNhap;
    private int soluongMuonTra;
    Scanner sc = new Scanner(System.in);

    public ThongKe() {
    }

    public ThongKe(date d, int soluongNguoiDung, int soluongTaiLieu, int soluongPhieuNhap, int soluongMuonTra) {
        this.d = d;
        this.soluongNguoiDung = soluongNguoiDung;
        this.soluongTaiLieu = soluongTaiLieu;
        this.soluongPhieuNhap = soluongPhieuNhap;
        this.soluongMuonTra = soluongMuonTra;
    }

    public date getD() {
        return d;
    }

    public void setD(date d) {
        this.d = d;
    }

    public int getSoluongNguoiDung() {
        return soluongNguoiDung;
    }

    public void setSoluongNguoiDung(int soluongNguoiDung) {
        this.soluongNguoiDung = soluongNguoiDung;
    }

    public int getSoluongTaiLieu() {
        return soluongTaiLieu;
    }

    public void setSoluongTaiLieu(int soluongTaiLieu) {
        this.soluongTaiLieu = soluongTaiLieu;
    }

    public int getSoluongPhieuNhap() {
        return soluongPhieuNhap;
    }

    public void setSoluongPhieuNhap(int soluongPhieuNhap) {
        this.soluongPhieuNhap = soluongPhieuNhap;
    }

    public int getSoluongMuonTra() {
        return soluongMuonTra;
    }

    public void setSoluongMuonTra(int soluongMuonTra) {
        this.soluongMuonTra = soluongMuonTra;
    }

    public void nhap() {
        d.nhapThangNam();
    }

    @Override
    public String toString() {
        return "ThongKe [d=" + d + ", soluongNguoiDung=" + soluongNguoiDung + ", soluongTaiLieu=" + soluongTaiLieu +
                ", soluongPhieuNhap=" + soluongPhieuNhap + ", soluongMuonTra=" + soluongMuonTra + "]";
    }
}
