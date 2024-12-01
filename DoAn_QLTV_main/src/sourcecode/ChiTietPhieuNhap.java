package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class ChiTietPhieuNhap {
    private String maPN;
    private String maTL;
    private int soLuong;
    private double giaTien;
    private double thanhTien;
    private boolean isDeleted;

    public ChiTietPhieuNhap() {}

    public ChiTietPhieuNhap(String maPN, String maTL, int soLuong, double giaTien, double thanhTien) {
        this.maPN = maPN;
        this.maTL = maTL;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.thanhTien = thanhTien;
        this.isDeleted = false;
    }

    // Getter và Setter
    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        this.maTL = maTL;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    // Phương thức nhập thông tin
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã phiếu nhập: ");
        maPN = checkLoi.checkChuoiRong();
        System.out.print("Nhập mã tài liệu: ");
        maTL = checkLoi.checkChuoiRong();
        System.out.print("Nhập số lượng: ");
        soLuong = checkLoi.checkSoNguyen();
        System.out.print("Nhập giá tiền: ");
        giaTien = sc.nextDouble();
        thanhTien = soLuong * giaTien; // Tính thành tiền
    }

    // Phương thức xuất chi tiết phiếu nhập
    public void xuat() {
        String format = "| %-12s | %-20s | %-20s | %-20s | %-20s |\n";
        System.out.format(format, maPN, maTL, soLuong, giaTien, thanhTien);
    }

    @Override
    public String toString() {
        return "Mã phiếu nhập: " + maPN + ", Mã tài liệu: " + maTL + ", Số lượng: " + soLuong + ", Giá tiền: " + giaTien + ", Thành tiền: " + thanhTien + ", Trạng thái xóa: " + isDeleted;
    }
}
