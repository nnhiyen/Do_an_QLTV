package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class MuonTraTL {
    private String maTL;
    private date ngayMuon;
    private date ngayTra;
    private int soLuong;
    private String tenNguoiDung; // Chỉ lưu tên người dùng
    private NguoiDung nguoiDung; // Thông tin người dùng (sau khi tìm thấy)
    private boolean isDeleted;

    public MuonTraTL() {
    }

    public MuonTraTL(String maTL, date ngayMuon, date ngayTra, int soLuong, String tenNguoiDung) {
        this.maTL = maTL;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.soLuong = soLuong;
        this.tenNguoiDung = tenNguoiDung;
        this.isDeleted = false; // Mặc định không bị xóa
    }

    // Getters và Setters
    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        this.maTL = maTL;
    }

    public date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(date ngayTra) {
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

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
    
    // Phương thức nhập thông tin với kiểm tra hợp lệ
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã tài liệu: ");
        maTL = checkLoi.checkMaTaiLieu();
        System.out.println("Nhập ngày mượn: ");
        ngayMuon.nhap();
        System.out.println("Nhập ngày trả: ");
        ngayTra.nhap();
        System.out.print("Nhập số lượng: ");
        soLuong = checkLoi.checkSoLuong();
        scanner.nextLine(); // Đọc ký tự newline sau khi nhập số
        System.out.print("Nhập tên người dùng: ");
        tenNguoiDung = checkLoi.checkChuoiRong();
    }

    // Phương thức hiển thị thông tin mượn trả tài liệu (xuất)
    public void xuat() {
        String format = "| %-12s | %-20s | %-15s | %-15s | %-12s | %-12s |\n";
        System.out.format(format, maTL, tenNguoiDung, ngayMuon, ngayTra, soLuong);
    }

    // Phương thức chuyển mượn trả tài liệu thành chuỗi (ghi vào file)
    @Override
    public String toString() {
        return "Mã tài liệu: " + maTL +
               ", Tên người dùng: " + tenNguoiDung +
               ", Ngày mượn: " + ngayMuon +
               ", Ngày trả: " + ngayTra +
               ", Số lượng: " + soLuong + 
                ", Trạng thái xóa: " + isDeleted;
    }

}