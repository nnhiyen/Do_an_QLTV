package qltv;

import java.util.Scanner;

public class ChiTietPhieuNhap {
    private String maPN;
    private String maTL;
    private int soLuong;
    private double giaTien;
    private double tongTien;
    private boolean deleted; // Trạng thái đã xóa

    // Constructor mặc định
    public ChiTietPhieuNhap() {
        this.deleted = false; // Mặc định không bị xóa
    }

    // Constructor property
    public ChiTietPhieuNhap(String maPN, String maTL, int soLuong, double giaTien) {
        this.maPN = maPN;
        this.maTL = maTL;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.tongTien = soLuong * giaTien;
        this.deleted = false; // Mặc định không bị xóa
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
        this.tongTien = this.soLuong * this.giaTien;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
        this.tongTien = this.soLuong * this.giaTien;
    }

    public double getTongTien() {
        return tongTien;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    // Phương thức nhập thông tin
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã phiếu: ");
        maPN = sc.nextLine();
        System.out.print("Nhập mã tài liệu: ");
        maTL = sc.nextLine();
        System.out.print("Nhập số lượng: ");
        soLuong = sc.nextInt();
        System.out.print("Nhập giá tiền: ");
        giaTien = sc.nextDouble();
        tongTien = soLuong * giaTien;
    }

    // Phương thức toString
    @Override
    public String toString() {
        return "Mã phiếu: " + maPN + ", Mã tài liệu: " + maTL + ", Số lượng: " + soLuong + ", Giá tiền: " + giaTien + ", Tổng tiền: " + tongTien + ", Đã xóa: " + (deleted ? "Đã xóa" : "Chưa xóa");
    }

    // Phương thức xuất thông tin
    public void xuat() {
        System.out.println(this.toString());
    }
}
