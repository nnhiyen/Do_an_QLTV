package DoAn_QLTV_main.src.sourcecode;

public class ChiTietPhieuNhap {
    private String maPhieu;
    private String maTL;
    private int soLuong;
    private double giaTien;
    private double thanhTien;

    // Constructor mặc định
    public ChiTietPhieuNhap() {}

    // Constructor property
    public ChiTietPhieuNhap(String maPhieu, String maTL, int soLuong, double giaTien) {
        this.maPhieu = maPhieu;
        this.maTL = maTL;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.thanhTien = soLuong * giaTien;
    }

    // Getter và Setter
    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        this.maTL = maTL;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        this.thanhTien = this.soLuong * this.giaTien;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
        this.thanhTien = this.soLuong * this.giaTien;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    // Phương thức nhập thông tin
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã phiếu: ");
        maPhieu = sc.nextLine();
        System.out.print("Nhập mã tài liệu: ");
        maTL = sc.nextLine();
        System.out.print("Nhập số lượng: ");
        soLuong = sc.nextInt();
        System.out.print("Nhập giá tiền: ");
        giaTien = sc.nextDouble();
        thanhTien = soLuong * giaTien;
    }

    // Phương thức toString
    @Override
    public String toString() {
        return "Mã phiếu: " + maPhieu + ", Mã tài liệu: " + maTL + ", Số lượng: " + soLuong + ", Giá tiền: " + giaTien + ", Thành tiền: " + thanhTien;
    }

    // Phương thức xuất thông tin
    public void xuat() {
        System.out.println(this.toString());
    }
}
