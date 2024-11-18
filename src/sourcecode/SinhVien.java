package DoAn_QLTV_main.src.sourcecode;

public class SinhVien extends NguoiDung {
    private String maSV;

    // Constructor mặc định
    public SinhVien() { super();}
    // Constructor property
    public SinhVien(String ten, String khoa, int namSinh, String maSV){
        super(ten, khoa, namSinh);
        this.maSV=maSV;
    }
    // Getter và Setter
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV= maSV;
    }

    // Phương thức nhập thông tin Sinh Viên
    @Override
    public void nhap() {
        super.nhap(); // Gọi phương thức nhập của lớp cha
        System.out.print("Nhập mã sinh viên: ");
        maSV = checkLoi.checkMaSV();
    }

    @Override
    public String maNguoiDung(){
        return  maSV;
    }
    
    @Override
    public void xuat() {
        String sv_format = "| %-18s | %-14s | %-4s | %-6d |%n";
    System.out.format(sv_format, getMaSV(), getTen(), getKhoa(), getNamSinh());
    }
    
    @Override
    public String toString() {
    return "Tên: " + getTen() + ", Khoa: " + getKhoa() + ", Năm sinh: " + getNamSinh() + ", Mã sinh viên: " + maNguoiDung();
    }


}
