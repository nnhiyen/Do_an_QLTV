package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DanhSachThongKe {
    // private ThongKe[] arr_tk;
    // private int soLuong;
    // Scanner sc = new Scanner(System.in);

    // public DanhSachThongKe(int kichThuoc) {
    //     arr_tk = new ThongKe[kichThuoc];
    //     soLuong = 0;
    // }

    // public void tangSoLuongNguoiDung(int thang, int nam, int sl) {
    //     for (int i = 0; i < soLuong; i++) {
    //         if (arr_tk[i].getD().getThang() == thang && arr_tk[i].getD().getNam() == nam) {
    //             arr_tk[i].setSoluongNguoiDung(arr_tk[i].getSoluongNguoiDung() + sl);
    //             return;
    //         }
    //     }
    //     if (soLuong < arr_tk.length) {
    //         ThongKe tk = new ThongKe(new date(thang, nam), sl, 0, 0, 0);
    //         arr_tk[soLuong++] = tk;
    //     } else {
    //         System.out.println("Danh sách thống kê đã đầy.");
    //     }
    // }

    // public void tangSoLuongTaiLieu(int thang, int nam, int sl) {
    //     for (int i = 0; i < soLuong; i++) {
    //         if (arr_tk[i].getD().getThang() == thang && arr_tk[i].getD().getNam() == nam) {
    //             arr_tk[i].setSoluongTaiLieu(arr_tk[i].getSoluongTaiLieu() + sl);
    //             return;
    //         }
    //     }
    //     if (soLuong < arr_tk.length) {
    //         ThongKe tk = new ThongKe(new date(thang, nam), 0, sl, 0, 0);
    //         arr_tk[soLuong++] = tk;
    //     } else {
    //         System.out.println("Danh sách thống kê đã đầy.");
    //     }
    // }

    // public void tangSoLuongPhieuNhap(int thang, int nam) {
    //     for (int i = 0; i < soLuong; i++) {
    //         if (arr_tk[i].getD().getThang() == thang && arr_tk[i].getD().getNam() == nam) {
    //             arr_tk[i].setSoluongPhieuNhap(arr_tk[i].getSoluongPhieuNhap() + 1);
    //             return;
    //         }
    //     }
    //     if (soLuong < arr_tk.length) {
    //         ThongKe tk = new ThongKe(new date(thang, nam), 0, 0, 1, 0);
    //         arr_tk[soLuong++] = tk;
    //     } else {
    //         System.out.println("Danh sách thống kê đã đầy.");
    //     }
    // }

    // public void tangSoLuongMuonTra(int thang, int nam, int sl) {
    //     for (int i = 0; i < soLuong; i++) {
    //         if (arr_tk[i].getD().getThang() == thang && arr_tk[i].getD().getNam() == nam) {
    //             arr_tk[i].setSoluongMuonTra(arr_tk[i].getSoluongMuonTra() + sl);
    //             return;
    //         }
    //     }
    //     if (soLuong < arr_tk.length) {
    //         ThongKe tk = new ThongKe(new date(thang, nam), 0, 0, 0, sl);
    //         arr_tk[soLuong++] = tk;
    //     } else {
    //         System.out.println("Danh sách thống kê đã đầy.");
    //     }
    // }

    // public void xuatDSTK(int thang, int nam) {
    //     System.out.println("+-----------------------------------------------------------------------------------------------+");
    //     System.out.println("|                                           Thống kê tháng                                        |");
    //     System.out.println("+-----------------------------------------------------------------------------------------------+");
    //     System.out.printf("| %-12s | %-20s | %-20s | %-20s | %-20s | %-15s |%n", "Ngày", "Số lượng người dùng", "Số lượng tài liệu", "Số lượng phiếu nhập", "Số lượng mượn trả", "Trạng thái xóa");
    //     System.out.println("+-----------------------------------------------------------------------------------------------+");

    //     boolean hasRecords = false;
    //     for (int i = 0; i < soLuong; i++) {
    //         if (arr_tk[i].getD().getThang() == thang && arr_tk[i].getD().getNam() == nam) {
    //             arr_tk[i].xuat();
    //             hasRecords = true;
    //         }
    //     }

    //     if (!hasRecords) {
    //         System.out.println("|                                 Không có giao dịch nào trong tháng                              |");
    //     }
    //     System.out.println("+-----------------------------------------------------------------------------------------------+");
    // }
    
    // public void ghiDuLieuRaFile(String tenFile) {
    //     String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\Do_an_QLTV-main\\Do_an_QLTV-main\\src\\sourcefile\\" + tenFile;

    //     try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
    //         for (int i = 0; i < soLuong; i++) {
    //             writer.write(arr_tk[i].toString()); // Gọi phương thức toString() của ThongKe
    //             writer.newLine();
    //         }
    //         System.out.println("Ghi dữ liệu thành công vào file " + duongDan);
    //     } catch (IOException e) {
    //         System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
    //     }
    // }

    // public void docDuLieuTuFile(String tenFile) {
    //     String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\Do_an_QLTV-main\\Do_an_QLTV-main\\src\\sourcefile\\" + tenFile;
    //     soLuong = 0; // Đặt lại số lượng thống kê trước khi đọc

    //     try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
    //         String line;
    //         while ((line = reader.readLine()) != null) {
    //             String[] parts = line.split(", ");
    //             date d = new date(Integer.parseInt(parts[0].split("=")[1]), Integer.parseInt(parts[1].split("=")[1]));
    //             int soluongNguoiDung = Integer.parseInt(parts[2].split("=")[1]);
    //             int soluongTaiLieu = Integer.parseInt(parts[3].split("=")[1]);
    //             int soluongPhieuNhap = Integer.parseInt(parts[4].split("=")[1]);
    //             int soluongMuonTra = Integer.parseInt(parts[5].split("=")[1]);
    //             boolean isDeleted = Boolean.parseBoolean(parts[6].split("=")[1].replace("]", ""));

    //             ThongKe tk = new ThongKe(d, soluongNguoiDung, soluongTaiLieu, soluongPhieuNhap, soluongMuonTra);
    //             tk.setDeleted(isDeleted);

    //             if (soLuong < arr_tk.length) {
    //                 arr_tk[soLuong++] = tk;
    //             } else {
    //                 System.out.println("Danh sách thống kê đã đầy.");
    //             }
    //         }
    //         System.out.println("Đọc dữ liệu thành công từ file " + duongDan);
    //     } catch (IOException e) {
    //         System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
    //     }
    // }
}
