package DoAn_QLTV_main.src.sourcecode;
import java.util.Scanner;
public abstract class NguoiDung {
    private String ten;
    private String khoa;
    private int namSinh;
    public static Scanner sc = new Scanner(System.in);
    // Constructor mặc định
    public NguoiDung() {}
    // Constructor property
    public NguoiDung(String ten, String khoa, int namSinh){
        this.ten=ten;
        this.khoa=khoa;
        this.namSinh=namSinh;
    }
    // Getter và Setter
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }
    
    
    // test
    private boolean isDeleted; // Thêm thuộc tính này

    // Constructor, getter, setter

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    // Phương thức nhập thông tin chung
    public void nhap() {
        System.out.print("Nhập tên: ");
        ten = checkLoi.checkChuoiRong();
        System.out.print("Nhập khoa: ");
        khoa = checkLoi.checkChuoiRong();
        System.out.print("Nhập năm sinh:");
        namSinh = checkLoi.checkNamSinh();
    }

    // Phương thức toString
    @Override
    public String toString() {
    return "Tên: " + ten + ", Khoa: " + khoa + ", Năm sinh: " + namSinh + ", Trạng thái xóa: " + isDeleted;
    }


    // Phương thức trừu tượng
    public abstract String maNguoiDung();
    
    public void xuat(){
        System.out.println("Thông tin người dùng " + toString());
    }  
}
