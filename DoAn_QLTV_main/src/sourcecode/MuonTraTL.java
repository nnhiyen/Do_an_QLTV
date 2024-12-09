package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class MuonTraTL {
    private String maMT;
    private String maTL;
    private date ngayMuon = new date();
    private date ngayTra = new date();
    private int soLuong;
    private String maNguoiDung; 
     private boolean isDaTraTL;
    private boolean isDeleted;

    public MuonTraTL() {
    }

    public MuonTraTL(String maMT, String maTL, date ngayMuon, date ngayTra, int soLuong, String maNguoiDung) {
        this.maMT= maMT;
        this.maTL = maTL;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.soLuong = soLuong;
        this.maNguoiDung = maNguoiDung;
        this.isDaTraTL= false; // false is chuaTra
        this.isDeleted = false; // Mặc định không bị xóa
    }

    // Getters và Setters
    public String getMaMT(){
        return maMT;
    }
    public void setMaMT(String maMT){
        this.maMT= maMT;
    }
    
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

    public String getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
    
    public boolean isDaTraTL() {
        return isDaTraTL;
    }

    public void setDaTraTL(boolean daTraTL) {
        this.isDaTraTL = daTraTL;
    }
    
    // Phương thức nhập thông tin với kiểm tra hợp lệ
    public void nhap() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhập mã mượn trả: ");
    maMT= checkLoi.checkMaMT();
    
    System.out.print("Nhập mã tài liệu: ");
    maTL = checkLoi.checkMaTaiLieu();

    System.out.println("Nhập ngày mượn:");
    ngayMuon.nhap(); // Sử dụng phương thức nhap() từ class date

    System.out.println("Nhập ngày trả:");
    ngayTra.nhapNgayTra(ngayMuon);
    // check số lượng 
    System.out.print("Nhập số lượng: ");
    soLuong = checkLoi.checkSoLuong();

    System.out.print("Nhập mã người dùng: ");
    maNguoiDung = checkLoi.checkMaND();
  
}
   
 
    // Phương thức hiển thị thông tin mượn trả tài liệu (xuất)
    public void xuat() {
    String format = "| %-10s | %-10s | %-10s | %-10s | %-10d | %-10s |\n"; 
    System.out.format(format, maMT, maTL, ngayMuon, ngayTra, soLuong, maNguoiDung);
}

    @Override
    public String toString() {
        return maMT + ", " + maTL + ", " + maNguoiDung + ", " +
               ngayMuon + ", " + ngayTra + ", " + soLuong + ", " +
               isDaTraTL + ", " + isDeleted;
    }

}
