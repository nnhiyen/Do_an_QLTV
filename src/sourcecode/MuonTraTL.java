import java.util.Scanner;

public class MuonTraTL {
    private String maTL;
    private String ngayMuon;
    private String ngayTra;
    private int soLuong;

    public MuonTraTL() {
    }

    public String getMaTL() {
        return maTL;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setMaTL(String maTL) {
        this.maTL = maTL;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public MuonTraTL(String maTL, String ngayMuon, String ngayTra, int soLuong) {
        this.maTL = maTL;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.soLuong = soLuong;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã tài liệu: ");
        this.maTL = scanner.nextLine();
        System.out.print("Nhập ngày mượn: ");
        this.ngayMuon = scanner.nextLine();
        System.out.print("Nhập ngày trả: ");
        this.ngayTra = scanner.nextLine();
        System.out.print("Nhập số lượng: ");
        this.soLuong = scanner.nextInt();
    }

    public void xuat() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "MuonTraTL{" +
                "maTL='" + maTL + '\'' +
                ", ngayMuon='" + ngayMuon + '\'' +
                ", ngayTra='" + ngayTra + '\'' +
                ", soLuong=" + soLuong +
                '}';
    }
}
