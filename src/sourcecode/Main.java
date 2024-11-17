/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoAn_QLTV_main.src.sourcecode;
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
            System.out.println("7. Xóa người dùng");            
            System.out.println("8. Xóa người dùng");
            System.out.println("0. Thoát");
            System.out.print("Chọn tùy chọn: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

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
                    System.out.print("Nhập tên người dùng cần tìm: ");
                    String tenTimKiem = scanner.nextLine();
                    dsNguoiDung.timKiemNguoiDung(tenTimKiem);
                    break;
                case 6:
                    System.out.print("Nhập tên người dùng cần sửa: ");
                    String tenSua = scanner.nextLine();
                    dsNguoiDung.suaNguoiDung(tenSua);
                    break;
                case 7:
                    System.out.print("Nhập tên người dùng cần xóa: ");
                    String tenXoa = scanner.nextLine();
                    dsNguoiDung.xoaNguoiDung(tenXoa);
                    break;
                case 8:
                    System.out.print("Nhập mã sinh viên cần tìm: ");
                    int maSV = Integer.parseInt(scanner.nextLine());
                    // check lại
                    dsNguoiDung.timKiem(maSV);
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


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        DSNguoiDung quanLy = new DSNguoiDung(100);
//
//        int choice;
//        do {
//            System.out.println("=========== MENU QUẢN LÝ NGƯỜI DÙNG ===========");
//            System.out.println("1. Thêm người dùng");
//            System.out.println("2. Xuất danh sách người dùng");
//            System.out.println("0. Thoát");
//            System.out.print("Vui lòng chọn chức năng: ");
//            choice = sc.nextInt(); // Integer.parseINT(
//            sc.nextLine(); 
//
//            switch (choice) {
//                case 1:
//                    quanLy.themNguoiDung();
//                    break;
//                case 2:
//                    quanLy.xuatDanhSachNguoiDung(); 
//                    break;
//                case 0:
//                    System.out.println("Thoát chương trình.");
//                    break;
//                default:
//                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
//            }
//        } while (choice != 0);
//
//        sc.close(); 
//    }





