package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class MuonTraTL {
    private String maTL;
    private String ngayMuon;
    private String ngayTra;
    private int soLuong;
    private String maNguoiDung; // Chỉ lưu mã người dùng
    private NguoiDung nguoiDung; // Thông tin người dùng (sau khi tìm thấy)

    public MuonTraTL() {}

    public MuonTraTL(String maTL, String ngayMuon, String ngayTra, int soLuong, String maNguoiDung) {
        this.maTL = maTL;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.soLuong = soLuong;
        this.maNguoiDung = maNguoiDung;
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

    public String getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void nhap(NguoiDung[] danhSachNguoiDung) {
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

        System.out.print("Nhập mã người dùng: ");
        this.maNguoiDung = scanner.nextLine();

        // Tìm kiếm thông tin người dùng dựa trên mã người dùng
        for (NguoiDung nd : danhSachNguoiDung) {
            if (nd.getTen().equalsIgnoreCase(this.maNguoiDung)) {
                this.nguoiDung = nd;
                break;
            }
        }

        if (this.nguoiDung == null) {
            System.out.println("Không tìm thấy người dùng với mã: " + this.maNguoiDung);
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
