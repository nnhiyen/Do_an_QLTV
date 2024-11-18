package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class MainTest {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        DSPhieuNhap dsPhieuNhap = new DSPhieuNhap(100);
        DSChiTietPhieuNhap dsChiTietPN = new DSChiTietPhieuNhap(100);
        boolean exit = false;

        while (!exit) {
            System.out.println("+-----------------------------+");
            System.out.println("|         Menu phieu nhap     |");
            System.out.println("+-----------------------------+");
            System.out.println("|1. Xem danh sach phieu nhap. |");
            System.out.println("|2. Tim phieu nhap.           |");
            System.out.println("|3. Tao phieu nhap.           |");
            System.out.println("|0. Thoat chuong trinh.       |");
            System.out.println("+-----------------------------+");
            System.out.print("Moi ban nhap lua chon: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    dsPhieuNhap.xemDanhSachPhieuNhap();
                    break;
                case 2:
                    System.out.print("Nhap ma phieu nhap can tim: ");
                    String maPN = sc.next();
                    PhieuNhap pn = dsPhieuNhap.timPhieuNhap(maPN);
                    if (pn != null) {
                        pn.xuatPN();
                    } else {
                        System.out.println("Không tìm thấy phiếu nhập.");
                    }
                    break;
                case 3:
                    PhieuNhap newPN = new PhieuNhap();
                    newPN.nhap();
                    dsPhieuNhap.themPhieuNhap(newPN);

                    boolean done = false;
                    while (!done) {
                        System.out.println("+-----------------------------+");
                        System.out.println("|   Menu chi tiet phieu nhap  |");
                        System.out.println("+-----------------------------+");
                        System.out.println("|1. Nhap san pham.            |");
                        System.out.println("|0. Hoan thanh.               |");
                        System.out.println("+-----------------------------+");
                        System.out.print("Moi ban nhap lua chon: ");
                        int ctChoice = sc.nextInt();
                        if (ctChoice == 1) {
                            ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
                            ctpn.nhap();
                            dsChiTietPN.themChiTietPhieuNhap(ctpn);
                        } else if (ctChoice == 0) {
                            done = true;
                            double tongTien = dsChiTietPN.tinhTongTien();
                            newPN.setTongTien(tongTien);
                            System.out.println("Tong tien: " + tongTien);
                        }
                    }
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
                    break;
            }
        }
    }
}
