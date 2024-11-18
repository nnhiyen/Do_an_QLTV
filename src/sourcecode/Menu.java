package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class Menu implements IMenu {
    private DSChiTietPN dsChiTietPN;

    public Menu() {
        dsChiTietPN = new DSChiTietPN(100); // Giả sử kích thước tối đa là 100
    }

    @Override
    public void hienThiMenu() {
        System.out.println("1. Thêm chi tiết phiếu nhập");
        System.out.println("2. Sửa chi tiết phiếu nhập");
        System.out.println("3. Xóa chi tiết phiếu nhập");
        System.out.println("4. Tìm kiếm chi tiết phiếu nhập");
        System.out.println("5. Xuất danh sách chi tiết phiếu nhập");
        System.out.println("0. Thoát");
    }

    @Override
    public void xuLyLuaChon(int luaChon) {
        Scanner sc = new Scanner(System.in);
        switch (luaChon) {
            case 1:
                ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
                ct.nhap();
                dsChiTietPN.themCT(ct);
                break;
            case 2:
                System.out.print("Nhập mã phiếu cần sửa: ");
                String maPhieuSua = sc.nextLine();
                dsChiTietPN.suaCT(maPhieuSua);
                break;
            case 3:
                System.out.print("Nhập mã phiếu cần xóa: ");
                String maPhieuXoa = sc.nextLine();
                dsChiTietPN.xoaCT(maPhieuXoa);
                break;
            case 4:
                System.out.print("Nhập mã phiếu cần tìm: ");
                String maPhieuTim = sc.nextLine();
                dsChiTietPN.timKiemPN(maPhieuTim);
                break;
            case 5:
                dsChiTietPN.xuat_ds();
                break;
            case 0:
                System.out.println("Thoát chương trình.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                break;
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        int luaChon;
        do {
            menu.hienThiMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = sc.nextInt();
            sc.nextLine(); // Consume newline
            menu.xuLyLuaChon(luaChon);
        } while (luaChon != 0);
    }
}
