package DoAn_QLTV_main.src.sourcecode;
import java.util.Scanner;

public class ThongKe {
    date d = new date();
    private int soLuongMuon; 
    private int soLuongTra;   
    private int soLuongPhieuMuon;  
    private int soLuongPhieuTra;  

    Scanner sc = new Scanner(System.in);

    public ThongKe() {}

    public ThongKe(date d, int soLuongMuon, int soLuongTra, int soLuongPhieuMuon, int soLuongPhieuTra) {
        this.d = d;
        this.soLuongMuon = soLuongMuon;
        this.soLuongTra = soLuongTra;
        this.soLuongPhieuMuon = soLuongPhieuMuon;
        this.soLuongPhieuTra = soLuongPhieuTra;
    }

    // Getters và setters
    public date getD() { return d; }
    public void setD(date d) { this.d = d; }
    public int getSoLuongMuon() { return soLuongMuon; }
    public void setSoLuongMuon(int soLuongMuon) { this.soLuongMuon = soLuongMuon; }
    public int getSoLuongTra() { return soLuongTra; }
    public void setSoLuongTra(int soLuongTra) { this.soLuongTra = soLuongTra; }
    public int getSoLuongPhieuMuon() { return soLuongPhieuMuon; }
    public void setSoLuongPhieuMuon(int soLuongPhieuMuon) { this.soLuongPhieuMuon = soLuongPhieuMuon; }
    public int getSoLuongPhieuTra() { return soLuongPhieuTra; }
    public void setSoLuongPhieuTra(int soLuongPhieuTra) { this.soLuongPhieuTra = soLuongPhieuTra; }

    // Nhập thông tin tháng và năm
    public void nhap() {
        d.nhapThangNam();  // Gọi hàm nhập tháng và năm
    }

    @Override
    public String toString() {
        return "ThongKe [d=" + d + ", soLuongMuon=" + soLuongMuon + ", soLuongTra=" + soLuongTra + 
                ", soLuongPhieuMuon=" + soLuongPhieuMuon + ", soLuongPhieuTra=" + soLuongPhieuTra + "]";
    }
}
