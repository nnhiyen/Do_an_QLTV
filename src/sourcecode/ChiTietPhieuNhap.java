/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class ChiTietPhieuNhap {
    private String maPN;
    private String maTL;
    private int soLuong;
    private double giaTien;
    private double thanhTien;
    private boolean isDeleted;
    public static Scanner sc = new Scanner(System.in);

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

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    // Phương thức nhập thông tin
    public void nhap() {
        System.out.print("Nhập mã phiếu nhập: ");
        maPN = sc.nextLine();
        System.out.print("Nhập mã tài liệu: ");
        maTL = sc.nextLine();
        System.out.print("Nhập số lượng: ");
        soLuong = sc.nextInt();
        System.out.print("Nhập giá tiền: ");
        giaTien = sc.nextDouble();
        thanhTien = soLuong * giaTien; // Tính thành tiền
    }

    // Phương thức xuất chi tiết phiếu nhập
    public void xuatCTPN() {
        System.out.printf("| %-12s | %-12s | %-8d | %-12.2f | %-12.2f | %-8s |\n", 
            maPN, maTL, soLuong, giaTien, thanhTien, isDeleted ? "Đã xóa" : "Hoạt động");
    }

    @Override
    public String toString() {
        return "Mã phiếu nhập: " + maPN + ", Mã tài liệu: " + maTL + ", Số lượng: " + soLuong + ", Giá tiền: " + giaTien + ", Thành tiền: " + thanhTien + ", Trạng thái xóa: " + isDeleted;
    }
}
