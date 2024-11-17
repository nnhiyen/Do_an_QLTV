package DoAn_QLTV_main.src.sourcecode;

public class SinhVien extends NguoiDung {
    private String maSinhVien;

    // Constructor mặc định
    public SinhVien() {}

    // Getter và Setter
    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    // Phương thức nhập thông tin Sinh Viên
    @Override
    public void nhap() {
        super.nhap(); // Gọi phương thức nhập của lớp cha
        sc.nextLine();
        System.out.print("Nhập mã sinh viên: ");
        maSinhVien = sc.nextLine();
    }

    // Phương thức xuất thông tin
    @Override
    public void xuat() {
        System.out.println("Thông tin sinh viên: " + toString());
    }

    // Phương thức toString
    @Override
    public String toString() {
        return super.toString() + ", Mã sinh viên: " + maSinhVien;
    }
}

