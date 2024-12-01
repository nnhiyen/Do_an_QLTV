package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class ThongKe {
    private date d;
    private int soluongNguoiDung;
    private int soluongTaiLieu;
    private int soluongPhieuNhap;
    private int soluongMuonTra;
    private boolean isDeleted;
    Scanner sc = new Scanner(System.in);

    public ThongKe() {
        this.isDeleted = false; // Mặc định là chưa bị xóa
    }

    public ThongKe(date d, int soluongNguoiDung, int soluongTaiLieu, int soluongPhieuNhap, int soluongMuonTra) {
        this.d = d;
        this.soluongNguoiDung = soluongNguoiDung;
        this.soluongTaiLieu = soluongTaiLieu;
        this.soluongPhieuNhap = soluongPhieuNhap;
        this.soluongMuonTra = soluongMuonTra;
        this.isDeleted = false; // Mặc định là chưa bị xóa
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void nhap() {
        d.nhapThangNam();
    }

    public void xuat() {
        String format = "| %-12s | %-20s | %-15s | %-15s | %-15s | %-15s |\n";
        System.out.format(format, d, soluongNguoiDung, soluongTaiLieu, soluongPhieuNhap, soluongMuonTra, isDeleted);
    }

    // Phương thức chuyển thống kê thành chuỗi (ghi vào file)
    @Override
    public String toString() {
        return "Ngày: " + d +
               ", Số lượng người dùng: " + soluongNguoiDung +
               ", Số lượng tài liệu: " + soluongTaiLieu +
               ", Số lượng phiếu nhập: " + soluongPhieuNhap +
               ", Số lượng mượn trả: " + soluongMuonTra +
               ", Trạng thái xóa: " + isDeleted;
    }
}
