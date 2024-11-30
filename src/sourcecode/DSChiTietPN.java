/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoAn_QLTV_main.src.sourcecode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DSChiTietPhieuNhap {
    private ChiTietPhieuNhap[] dsChiTiet;
    
    private int soLuongCTPN;
    Scanner sc = new Scanner(System.in);

    public DSChiTietPhieuNhap(int kichThuoc) {
        dsChiTiet = new ChiTietPhieuNhap[kichThuoc];
        soLuongCTPN = 0;
    }

    public void themChiTietPhieuNhap(ChiTietPhieuNhap ctpn) {
        if (soLuongCTPN < dsChiTiet.length) {
            dsChiTiet[soLuongCTPN] = ctpn;
            soLuongCTPN++;
            ghiDuLieuRaFile("chitietphieunhap.txt");
            System.out.println("Thêm chi tiết phiếu nhập thành công!");
        } else {
            System.out.println("Danh sách chi tiết phiếu nhập đã đầy.");
        }
    }

    public void xuatDanhSachChiTiet() {
        System.out.println("+--------------------+----------+--------------+--------------+------------+");
        System.out.println("|    Mã phiếu nhập   | Mã tài liệu | Số lượng  | Giá tiền   | Thành tiền | Trạng thái |");
        System.out.println("+--------------------+----------+--------------+--------------+------------+");
        for (int i = 0; i < soLuongCTPN; i++) {
            dsChiTiet[i].xuatCTPN();
        }
        System.out.println("+--------------------+----------+--------------+--------------+------------+");
    }

    public double tinhTongTien() {
        double tongTien = 0;
        for (int i = 0; i < soLuongCTPN; i++) {
            tongTien += dsChiTiet[i].getThanhTien();
        }
        return tongTien;
    }

    public void xoaChiTietPhieuNhap(String maPN) {
        for (int i = 0; i < soLuongCTPN; i++) {
            if (dsChiTiet[i].getMaPN().equals(maPN)) {
                dsChiTiet[i].setDeleted(true);
                System.out.println("Xóa tạm thời chi tiết phiếu nhập thành công.");
                ghiDuLieuRaFile("chitietphieunhap.txt");
                return;
            }
        }
        System.out.println("Không tìm thấy chi tiết phiếu nhập với mã: " + maPN);
    }

    public void khoiPhucChiTietPhieuNhap(String maPN) {
        for (int i = 0; i < soLuongCTPN; i++) {
            if (dsChiTiet[i].getMaPN().equals(maPN)) {
                dsChiTiet[i].setDeleted(false);
                System.out.println("Khôi phục chi tiết phiếu nhập thành công.");
                ghiDuLieuRaFile("chitietphieunhap.txt");
                return;
            }
        }
        System.out.println("Không tìm thấy chi tiết phiếu nhập với mã: " + maPN);
    }

    public void hienThiDanhSachXoa() {
        System.out.println("Danh sách chi tiết phiếu nhập đã xóa tạm thời:");
        System.out.printf("| %-12s | %-12s | %-8s | %-12s | %-12s | %-8s |\n", "Mã phiếu nhập", "Mã tài liệu", "Số lượng", "Giá tiền", "Thành tiền", "Trạng thái");
        System.out.println("---------------------------------------------------------------");
        boolean hasDeleted = false;

        for (int i = 0; i < soLuongCTPN; i++) {
            if (dsChiTiet[i].isDeleted()) {
                hasDeleted = true;
                dsChiTiet[i].xuatCTPN();
            }
        }

        if (!hasDeleted) {
            System.out.println("Không có chi tiết phiếu nhập nào đã xóa tạm thời.");
        }
    }

    public void ghiDuLieuRaFile(String tenFile) {
        String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
            for (int i = 0; i < soLuongCTPN; i++) {
                writer.write(dsChiTiet[i].toString());
                writer.newLine();
            }
            System.out.println("Ghi dữ liệu thành công vào file " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
        }
    }

    public void docDuLieuTuFile(String tenFile) {
        String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;
        soLuongCTPN = 0; // Đặt lại số lượng chi tiết phiếu nhập trước khi đọc

        try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length >= 6) { // Đọc cả trạng thái isDeleted
                    String maPN = parts[0];
                    String maTL = parts[1];
                    int soLuong = Integer.parseInt(parts[2]);
                    double giaTien = Double.parseDouble(parts[3]);
                    double thanhTien = Double.parseDouble(parts[4]);
                    boolean isDeleted = Boolean.parseBoolean(parts[5]);

                    ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap(maPN, maTL, soLuong, giaTien, thanhTien);
                    ctpn.setDeleted(isDeleted);
                    dsChiTiet[soLuongCTPN++] = ctpn;
                }
            }
            System.out.println("Đọc dữ liệu thành công từ file " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        }
    }
}
