package DoAn_QLTV_main.src.sourcecode;
import java.util.Scanner;

public class ThongKe {
    private date d;  // Đối tượng date cho tháng và năm
    private int soLuongMuon; 
    private int soLuongTra;   
    private int soLuongPhieuMuon;  
    private int soLuongPhieuTra;  

    Scanner sc = new Scanner(System.in);

    public ThongKe() {
        d = new date();  // Khởi tạo đối tượng date mặc định
    }

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

    // Nhập thông tin tháng và năm từ tham số
    public void nhap(int thang, int nam) {
        d.setThang(thang);  // Set tháng
        d.setNam(nam);      // Set năm
        // Bạn có thể thêm logic thống kê tại đây nếu cần
    }

    @Override
    public String toString() {
        return "ThongKe [d=" + d + ", soLuongMuon=" + soLuongMuon + ", soLuongTra=" + soLuongTra + 
                ", soLuongPhieuMuon=" + soLuongPhieuMuon + ", soLuongPhieuTra=" + soLuongPhieuTra + "]";
    }
}
