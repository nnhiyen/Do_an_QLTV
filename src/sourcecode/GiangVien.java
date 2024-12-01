package DoAn_QLTV_main.src.sourcecode;

public class GiangVien extends NguoiDung {
    private String maGV;

    // Constructor mặc định
    public GiangVien() {super();}
    // 
    public GiangVien(String ten, String khoa, int namSinh, String maGV){
        super(ten, khoa, namSinh);
        this.maGV=maGV;
    }
    // Getter và Setter
    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV=maGV;
    }

    // Phương thức nhập thông tin Giảng Viên
    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Nhập mã giảng viên: ");
        maGV = checkLoi.checkMaGV();
        
    }
    
    @Override
    public String maNguoiDung(){
        return  maGV;
    }
    
    @Override
    public void xuat() {
        String sv_format = "| %-18s | %-14s | %-4s | %-6d |%n";
    System.out.format(sv_format, getMaGV(), getTen(), getKhoa(), getNamSinh());
    }
    
   @Override
    public String toString() {
    return "Tên: " + getTen() + ", Khoa: " + getKhoa() + ", Năm sinh: " + getNamSinh() + ", Mã sinh viên: " + maNguoiDung() + ", Trạng thái xóa: " + isDeleted;
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

}
s
