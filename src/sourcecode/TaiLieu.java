package DoAn_QLTV_main.src.sourcecode;

public class TaiLieu {
    private String maTL;
    private String tenTL;
    private String tenTG;
    private String tenTLoai;
    private String tenNXB;
    private boolean isDeleted;

    public TaiLieu() {
        // Constructor mặc định
    }

    public TaiLieu(String maTL, String tenTL, String tenTG, String tenTLoai, String tenNXB) {
        this.maTL = maTL;
        this.tenTL = tenTL;
        this.tenTG = tenTG;
        this.tenTLoai = tenTLoai;
        this.tenNXB = tenNXB;
        this.isDeleted = false; // Mặc định là chưa bị xóa
    }

    // Phương thức nhập thông tin tài liệu
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã tài liệu: ");
        maTL = checkLoi.checkMaTaiLieu(); // Giả sử có hàm kiểm tra mã hợp lệ
        System.out.print("Nhập tên tài liệu: ");
        tenTL = checkLoi.checkChuoiRong(); // Giả sử có hàm kiểm tra chuỗi rỗng
        System.out.print("Nhập tên tác giả: ");
        tenTG = checkLoi.checkChuoiRong();
        System.out.print("Nhập tên thể loại: ");
        tenTLoai = checkLoi.checkChuoiRong();
        System.out.print("Nhập tên nhà xuất bản: ");
        tenNXB = checkLoi.checkChuoiRong();
    }

    // Phương thức hiển thị thông tin tài liệu (xuất)
    public void xuat() {
        String format = "| %-12s | %-20s | %-20s | %-20s | %-20s |\n";
        System.out.format(format, maTL, tenTL, tenTG, tenTLoai, tenNXB);
    }

    // Phương thức chuyển tài liệu thành chuỗi (ghi vào file)
    @Override
    public String toString() {
        return "Mã tài liệu: " + maTL +
               ", Tên tài liệu: " + tenTL +
               ", Tên tác giả: " + tenTG +
               ", Tên thể loại: " + tenTLoai +
               ", Tên nhà xuất bản: " + tenNXB +
               ", Trạng thái xóa: " + isDeleted;
    }

    // Getter và Setter cho các thuộc tính
    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        this.maTL = maTL;
    }

    public String getTenTL() {
        return tenTL;
    }

    public void setTenTL(String tenTL) {
        this.tenTL = tenTL;
    }

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public String getTenTLoai() {
        return tenTLoai;
    }

    public void setTenTLoai(String tenTLoai) {
        this.tenTLoai = tenTLoai;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
