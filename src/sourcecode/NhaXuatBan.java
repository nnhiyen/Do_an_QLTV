package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class NhaXuatBan {
    private String maNXB;
    private String tenNXB;

    // Constructor mặc định
    public NhaXuatBan() {}

    // Constructor đầy đủ
    public NhaXuatBan(String maNXB, String tenNXB) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
    }

    // Getter và Setter
    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    // Nhập thông tin nhà xuất bản
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã nhà xuất bản: ");
        maNXB = sc.nextLine();
        System.out.print("Nhập tên nhà xuất bản: ");
        tenNXB = sc.nextLine();
    }

    // Xuất thông tin nhà xuất bản
    public void xuat() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Mã NXB: " + maNXB + ", Tên NXB: " + tenNXB;
    }
}
