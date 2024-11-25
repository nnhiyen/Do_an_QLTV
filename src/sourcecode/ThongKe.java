/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qltv;
import java.util.Scanner;
/**
 *
 * @author Luong Thanh Tuan
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DSNguoiDung dsNguoiDung = new DSNguoiDung(100);

        while (true) {
            System.out.println("=== Quản lý người dùng ===");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Ghi dữ liệu ra file");
            System.out.println("3. Đọc dữ liệu từ file");
            System.out.println("4. Hiển thị danh sách người dùng");
            System.out.println("5. Tìm kiếm người dùng");
            System.out.println("6. Sửa thông tin người dùng");
            System.out.println("7. Xóa hoặc khôi phục");
            System.out.println("8. Dữ liệu đã xóa");
            System.out.println("0. Thoát");
            System.out.print("Chọn tùy chọn: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự newline

            switch (option) {
                case 1:
                    System.out.print("Nhập số lượng người dùng muốn thêm: ");
                    int soLuongThem = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < soLuongThem; i++) {
                        System.out.print("Nhập loại người dùng (1: Sinh viên, 2: Giảng viên) cho người dùng thứ " + (i + 1) + ": ");
                        int loai = scanner.nextInt();
                        scanner.nextLine();
                        if (loai == 1) {
                            SinhVien sv = new SinhVien();
                            sv.nhap();
                            dsNguoiDung.themNguoiDung(sv);
                        } else if (loai == 2) {
                            GiangVien gv = new GiangVien();
                            gv.nhap();
                            dsNguoiDung.themNguoiDung(gv);
                        } else {
                            System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                            i--;
                        }
                    }
                    break;
                case 2:
                    dsNguoiDung.ghiDuLieuRaFile("nguoidung.txt");
                    break;
                case 3:
                    dsNguoiDung.docDuLieuTuFile("nguoidung.txt");
                    break;
                case 4:
                    dsNguoiDung.hienThiDanhSach();
                    break;
                case 5:
                    int loai = 0;
                    while (loai != 1 && loai != 2) {
                        System.out.print("Chọn loại người dùng cần tìm (1: Sinh viên, 2: Giảng viên): ");
                        loai = Integer.parseInt(scanner.nextLine());
                        if (loai == 1) {
                            String msv = "";
                            while (msv.trim().isEmpty()) {
                                System.out.print("Nhập mã sinh viên cần tìm: ");
                                msv = scanner.nextLine();
                                if (msv.trim().isEmpty()) {
                                    System.err.println("Mã sinh viên không được bỏ trống. Vui lòng nhập lại.");
                                }
                            }
                            dsNguoiDung.timKiemSV(msv);
                        } else if (loai == 2) {
                            String mgv = "";
                            while (mgv.trim().isEmpty()) {
                                System.out.print("Nhập mã giảng viên cần tìm: ");
                                mgv = scanner.nextLine();
                                if (mgv.trim().isEmpty()) {
                                    System.err.println("Mã giảng viên không được bỏ trống. Vui lòng nhập lại.");
                                }
                            }
                            dsNguoiDung.timKiemGV(mgv);
                        } else {
                            System.err.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                        }
                    }
                    break;
                case 6:
                    System.out.print("Nhập tên người dùng cần sửa: ");
                    String tenSua = scanner.nextLine();
                    dsNguoiDung.suaNguoiDung(tenSua);
                    break;
                case 7:
                    // Tạo menu con cho Xóa tạm thời và Khôi phục
                    System.out.println("=== Chọn hành động xóa ===");
                    System.out.println("1. Xóa tạm thời");
                    System.out.println("2. Khôi phục người dùng đã xóa");
                    System.out.println("3. Quay lại");
                    System.out.print("Chọn tùy chọn: ");
                    int subOption = scanner.nextInt();
                    scanner.nextLine(); // Đọc bỏ ký tự newline

                    switch (subOption) {
                        case 1:
                            System.out.print("Nhập tên người dùng cần xóa tạm thời: ");
                            String tenXoa = scanner.nextLine();
                            dsNguoiDung.xoaNguoiDung(tenXoa);  // Xóa tạm thời
                            break;
                        case 2:
                            System.out.print("Nhập tên người dùng cần khôi phục: ");
                            String tenKhoiPhuc = scanner.nextLine();
                            dsNguoiDung.khoiPhucNguoiDung(tenKhoiPhuc);  // refund
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;
                case 8:
                    dsNguoiDung.hienThiDanhSachXoa();  
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}
