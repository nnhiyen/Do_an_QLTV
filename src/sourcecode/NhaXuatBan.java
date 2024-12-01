/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoAn_QLTV_main.src.sourcecode;

/**
 *
 * @author Luong Thanh Tuan
 */

import java.util.Scanner;

public class NhaXuatBan {
    private String maNXB;
    private String tenNXB;
    private String diaChi;

    Scanner sc = new Scanner(System.in);

    public NhaXuatBan() {}

    public NhaXuatBan(String maNXB, String tenNXB, String diaChi) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.diaChi = diaChi;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNCC(String tenNXB) {
        this.tenNXB = tenNXB;
    }
    public String getDiaChi() {
        return maNXB;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã nhà xuất bản: ");
        maNXB = checkLoi.checkChuoiRong(); // Giả sử có hàm kiểm tra chuỗi rỗng
        System.out.print("Nhập tên nhà xuất bản: ");
        tenNXB = checkLoi.checkChuoiRong();
        System.out.print("Nhập địa chỉ nhà xuất bản: ");
        diaChi = checkLoi.checkChuoiRong();
    }

    @Override
    public String toString() {
        return "Mã NXB: " +maNXB + ", "+ "Tên NXB: " + tenNXB + "Địa chỉ: " + diaChi;
    }
}
