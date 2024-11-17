package DoAn_QLTV_main.src.sourcecode;
import java.util.Scanner;
public abstract class NguoiDung {
    protected String ten;
    protected String khoa;
    protected int namHoc;
    public static Scanner sc = new Scanner(System.in);
    // Constructor mặc định
    public NguoiDung() {}

    // Getter và Setter
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public int getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
    }

    // Phương thức nhập thông tin chung
    public void nhap() {
        System.out.print("Nhập tên: ");
        ten = sc.nextLine();
        System.out.print("Nhập khoa: ");
        khoa = sc.nextLine();
        System.out.print("Nhập năm học: ");
        namHoc = sc.nextInt();
    }

    // Phương thức toString
    @Override
    public String toString() {
        return "Tên: " + ten + ", Khoa: " + khoa + ", Năm học: " + namHoc;
    }

    // Phương thức trừu tượng
    public abstract void xuat();
}