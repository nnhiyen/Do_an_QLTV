package DoAn_QLTV_main.src.sourcecode;
import java.util.Scanner;

public class PhieuNhap {
    private String maPN;
    private String maNXB;
    private double tongTien;
    private static int cntmaPN = 1;
    private date ngayNhap = new date();
    private boolean isDeleted; 
    
    Scanner sc = new Scanner(System.in);
    
    // Contructor mặc định
    public PhieuNhap(){   }


    // Constructor
    public PhieuNhap(String maPN, String maNXB, double tongTien, date ngayNhap){
        this.maNXB = maNXB;
        this.maPN= maPN;
        this.tongTien= tongTien;
        this.ngayNhap= ngayNhap;
        this.isDeleted = false; // Mặc định là chưa bị xóa

    
        if (maPN == null || maPN.isEmpty()) {
            if (cntmaPN < 10) {
                this.maPN = "PN00" + cntmaPN;
            } else if (cntmaPN < 100) {
                this.maPN = "PN0" + cntmaPN;
            } else {
                this.maPN = "PN" + cntmaPN;
            }
            cntmaPN++;
        }
    }
    
    
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
    
    public String getMaPN(){
        return maPN;
    }
    public void setMaPN(String maPN){
        this.maPN= maPN;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    public static void giamIdPN(){
        cntmaPN --;
    }
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ngày tạo phiếu nhập: ");
        ngayNhap = checkLoi.checkDate();
        System.out.print("Nhập mã nhà xuất bản:");
        maNXB = checkLoi.checkMaNXB();
    }
    
    public void xuatPN() {
        String mapn_format = "| Ma phieu nhap: %-11s | %n";
        String date_format = "| Ngay nhap   : %-12s | %n";
        String nhaxuatban_format = "| ID nha cung cap: %-9s |%n";

        System.out.println("+----------------------------+");
        System.out.format(mapn_format, maPN);
        System.out.format(date_format, ngayNhap);
        System.out.format(nhaxuatban_format, maNXB);
        System.out.println("+----------------------------+");

    }

    @Override
    public String toString() {
        return maPN + ", " + maNXB + ", " + ngayNhap + ", " + tongTien + ", " + isDeleted;
    }
    
}
