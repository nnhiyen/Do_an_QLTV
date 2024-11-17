/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoAn_QLTV_main.src.sourcecode;

/**
 *
 * @author Pham Thanh Binh
 */

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PhieuNhap {
    private String maPhieu;
    private String maTL;
    private String maNXB;
    private int soLuong;
    private double giaTien;
    private Date ngayNhap;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    // Constructor mặc định
    public PhieuNhap() {}

    // Getter và Setter
    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        this.maTL = maTL;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
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

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }


    public void nhap() {
    System.out.print("Nhập mã phiếu: ");
    maPhieu = NguoiDung.sc.nextLine(); // Sử dụng Scanner từ NguoiDung
    System.out.print("Nhập mã tài liệu: ");
    maTL = NguoiDung.sc.nextLine();
    System.out.print("Nhập mã nhà xuất bản: ");
    maNXB = NguoiDung.sc.nextLine();
    
    System.out.print("Nhập số lượng: ");
    while (!NguoiDung.sc.hasNextInt()) {
        System.out.print("Vui lòng nhập một số nguyên cho số lượng: ");
        NguoiDung.sc.next(); // bỏ qua đầu vào không phải số nguyên
    }
    soLuong = NguoiDung.sc.nextInt();
    
    System.out.print("Nhập giá tiền: ");
    while (!NguoiDung.sc.hasNextDouble()) {
        System.out.print("Vui lòng nhập một số cho giá tiền: ");
        NguoiDung.sc.next(); // bỏ qua đầu vào không phải số thực
    }
    giaTien = NguoiDung.sc.nextDouble();
    NguoiDung.sc.nextLine(); // làm sạch bộ đệm sau khi nhập số thực
    
    System.out.print("Nhập ngày nhập (dd/MM/yyyy): ");
    String ngayStr = NguoiDung.sc.nextLine();
    try {
        ngayNhap = dateFormat.parse(ngayStr);
    } catch (ParseException e) {
        System.out.println("Ngày nhập không hợp lệ, vui lòng nhập đúng định dạng dd/MM/yyyy.");
        ngayNhap = null;
    }
    }

  public void xuat() {
        System.out.println(toString());
    }

    // Phương thức toString để in thông tin phiếu nhập
    @Override
    public String toString() {
        String ngayNhapStr = (ngayNhap != null) ? dateFormat.format(ngayNhap) : "Chưa xác định";
        return "Mã phiếu: " + maPhieu + ", Mã tài liệu: " + maTL + ", Mã NXB: " + maNXB + 
               ", Số lượng: " + soLuong + ", Giá tiền: " + giaTien + ", Ngày nhập: " + ngayNhapStr;
    }

}



