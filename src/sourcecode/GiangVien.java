package DoAn_QLTV_main.src.sourcecode;

public class GiangVien extends NguoiDung {
    private String maGiangVien;

    // Constructor mặc định
    public GiangVien() {}

    // Getter và Setter
    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    // Phương thức nhập thông tin Giảng Viên
    @Override
    public void nhap() {
        super.nhap(); // Gọi phương thức nhập của lớp cha
        sc.nextLine();
        System.out.print("Nhập mã giảng viên: ");
        maGiangVien = sc.nextLine();
    }

    // Phương thức xuất thông tin
    @Override
    public void xuat() {
        System.out.println("Thông tin giảng viên: " + toString());
    }

    // Phương thức toString
    @Override
    public String toString() {
        return super.toString() + ", Mã giảng viên: " + maGiangVien;
    }
}
