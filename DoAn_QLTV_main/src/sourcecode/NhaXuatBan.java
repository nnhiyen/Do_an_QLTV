package DoAn_QLTV_main.src.sourcecode;

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

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã nhà xuất bản: ");
        maNXB = checkLoi.checkMaNXB(); // Giả sử có hàm kiểm tra chuỗi rỗng
        System.out.print("Nhập tên nhà xuất bản: ");
        tenNXB = checkLoi.checkChuoiRong();
        System.out.print("Nhập địa chỉ nhà xuất bản: ");
        diaChi = checkLoi.checkChuoiRong();
    }

    @Override
    public String toString() {
        return "Mã NXB: " +maNXB + ", "+ "Tên NXB: " + tenNXB + ", Địa chỉ: " + diaChi + ", Trạng thái xóa: " + isDeleted;
    }
    public void xuatNXB() {
        // Định dạng xuất thông tin ra màn hình
        String format = "| %-12s | %-20s | %-30s |\n";
        System.out.format("+----------------------------------------------------------+\n");
        System.out.format("|                   Thông tin Nhà Xuất Bản                 |\n");
        System.out.format("+----------------------------------------------------------+\n");
        System.out.format("| Mã NXB    | Tên NXB               | Địa chỉ nhà xuất bản |\n");
        System.out.format("+----------------------------------------------------------+\n");
        System.out.format(format, maNXB, tenNXB, diaChi);
        System.out.format("+----------------------------------------------------------+\n");
    }
// test
    private boolean isDeleted; // Thêm thuộc tính này

    // Constructor, getter, setter

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}

