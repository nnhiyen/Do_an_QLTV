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

    Scanner sc = new Scanner(System.in);

    public NhaXuatBan() {}

    public NhaXuatBan(String maNXB, String tenNXB) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
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


    public void nhap() {
        System.out.print("Nhập mã nhà xuất bản: ");
        maNXB = sc.nextLine();
        System.out.print("Nhập tên nhà xuất bản: ");
        tenNXB = sc.nextLine();

    }

    @Override
    public String toString() {
        return maNXB + ", " + tenNXB;
    }
}
