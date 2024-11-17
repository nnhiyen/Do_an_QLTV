package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class MuonTraTL {
    private String maTL;
    private String ngayMuon;
    private String ngayTra;
    private int soLuong;
    private String tenNguoiDung; // Chỉ lưu tên người dùng
    private NguoiDung nguoiDung; // Thông tin người dùng (sau khi tìm thấy)

    public MuonTraTL() {}

    public MuonTraTL(String maTL, String ngayMuon, String ngayTra, int soLuong, String tenNguoiDung) {
        this.maTL = maTL;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.soLuong = soLuong;
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        this.maTL = maTL;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void nhap(DSNguoiDung dsNguoiDung) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã tài liệu: ");
        this.maTL = scanner.nextLine();
        System.out.print("Nhập ngày mượn: ");
        this.ngayMuon = scanner.nextLine();
        System.out.print("Nhập ngày trả: ");
        this.ngayTra = scanner.nextLine();
        System.out.print("Nhập số lượng: ");
        this.soLuong = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline sau khi nhập số

        System.out.print("Nhập tên người dùng: ");
        this.tenNguoiDung = scanner.nextLine();

        // Tìm kiếm thông tin người dùng dựa trên tên người dùng
        this.nguoiDung = dsNguoiDung.timKiemNguoiDung(this.tenNguoiDung);

        if (this.nguoiDung == null) {
            System.out.println("Không tìm thấy người dùng với tên: " + this.tenNguoiDung);
        }
    }

    public void xuat() {
        if (this.nguoiDung != null) {
            System.out.println(this);
        } else {
            System.out.println("Thông tin người dùng không hợp lệ. Không thể xuất thông tin mượn trả tài liệu.");
        }
    }

    @Override
    public String toString() {
        return "MuonTraTL{" +
                "maTL='" + maTL + '\'' +
                ", ngayMuon='" + ngayMuon + '\'' +
                ", ngayTra='" + ngayTra + '\'' +
                ", soLuong=" + soLuong +
                ", nguoiDung=" + nguoiDung +
                '}';
    }
}
