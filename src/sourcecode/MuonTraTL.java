package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class MuonTraTL {
    private String maTL;
    private date ngayMuon;
    private date ngayTra;
    private int soLuong;
    private String tenNguoiDung; // Chỉ lưu tên người dùng
    private NguoiDung nguoiDung; // Thông tin người dùng (sau khi tìm thấy)
    private boolean daXoa; // Trạng thái đã xóa

    public MuonTraTL() {
        this.daXoa = false; // Mặc định không bị xóa
    }

    public MuonTraTL(String maTL, date ngayMuon, date ngayTra, int soLuong, String tenNguoiDung) {
        this.maTL = maTL;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.soLuong = soLuong;
        this.tenNguoiDung = tenNguoiDung;
        this.daXoa = false; // Mặc định không bị xóa
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

    public boolean isDaXoa() {
        return daXoa;
    }

    public void setDaXoa(boolean daXoa) {
        this.daXoa = daXoa;
    }

    // Phương thức tìm kiếm người dùng theo tên
    public NguoiDung[] timKiemNguoiDungTheoTen(String tenNguoiDung, DSNguoiDung dsNguoiDung) {
        NguoiDung[] ketQua = new NguoiDung[dsNguoiDung.getSoLuong()];
        int soLuongTimThay = 0;
        for (int i = 0; i < dsNguoiDung.getSoLuong(); i++) {
            if (dsNguoiDung.getDsNguoiDung()[i].getTen().equalsIgnoreCase(tenNguoiDung)) {
                ketQua[soLuongTimThay++] = dsNguoiDung.getDsNguoiDung()[i];
            }
        }
        NguoiDung[] ketQuaChinhXac = new NguoiDung[soLuongTimThay];
        System.arraycopy(ketQua, 0, ketQuaChinhXac, 0, soLuongTimThay);
        return ketQuaChinhXac;
    }

    // Phương thức tìm kiếm người dùng theo mã
    public NguoiDung timKiemNguoiDungTheoMa(String maNguoiDung, DSNguoiDung dsNguoiDung) {
        for (int i = 0; i < dsNguoiDung.getSoLuong(); i++) {
            if (dsNguoiDung.getDsNguoiDung()[i] instanceof SinhVien) {
                SinhVien sv = (SinhVien) dsNguoiDung.getDsNguoiDung()[i];
                if (sv.getMaSV().equals(maNguoiDung)) {
                    return sv;
                }
            } else if (dsNguoiDung.getDsNguoiDung()[i] instanceof GiangVien) {
                GiangVien gv = (GiangVien) dsNguoiDung.getDsNguoiDung()[i];
                if (gv.getMaGV().equals(maNguoiDung)) {
                    return gv;
                }
            }
        }
        return null;
    }

    // Phương thức tìm kiếm tài liệu
    public TaiLieu timKiemTaiLieu(String maTL, DsTaiLieu dsTaiLieu) {
        for (int i = 0; i < dsTaiLieu.getSoluongTL(); i++) {
            TaiLieu taiLieu = dsTaiLieu.getDsTL()[i];
            if (taiLieu.getMaTL().equals(maTL)) {
                return taiLieu; // Tìm thấy tài liệu
            }
        }
        // Nếu không tìm thấy
        System.out.println("Không tìm thấy tài liệu với mã: " + maTL);
        return null;
    }

    // Phương thức nhập thông tin với kiểm tra hợp lệ
    public void nhap(DSNguoiDung dsNguoiDung, DsTaiLieu dsTaiLieu) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã tài liệu: ");
        this.maTL = checkLoi.checkMaTaiLieu();
        
        TaiLieu taiLieu = timKiemTaiLieu(this.maTL, dsTaiLieu);
        if (taiLieu == null) {
            System.out.println("Tài liệu không tồn tại, vui lòng nhập lại!");
            return;
        }

        System.out.println("Nhập ngày mượn: ");
        this.ngayMuon = new date();
        this.ngayMuon.nhap();
        System.out.println("Nhập ngày trả: ");
        this.ngayTra = new date();
        this.ngayTra.nhap();
        System.out.print("Nhập số lượng: ");
        this.soLuong = checkLoi.checkSoLuong();
        scanner.nextLine(); // Đọc ký tự newline sau khi nhập số

        System.out.print("Nhập tên người dùng: ");
        this.tenNguoiDung = checkLoi.checkChuoiRong();

        // Tìm kiếm thông tin người dùng dựa trên tên người dùng
        NguoiDung[] nguoiDungs = timKiemNguoiDungTheoTen(this.tenNguoiDung, dsNguoiDung);

        if (nguoiDungs == null || nguoiDungs.length == 0) {
            System.out.println("Không tìm thấy người dùng với tên: " + this.tenNguoiDung);
        } else if (nguoiDungs.length == 1) {
            this.nguoiDung = nguoiDungs[0];
        } else {
            System.out.println("Có nhiều người dùng với tên: " + this.tenNguoiDung);
            System.out.print("Vui lòng nhập mã giảng viên hoặc mã sinh viên: ");
            String maNguoiDung = checkLoi.checkMaSV(); // Giả sử người dùng là sinh viên hoặc giảng viên
            this.nguoiDung = timKiemNguoiDungTheoMa(maNguoiDung, dsNguoiDung);
        }
    }

    // Phương thức xuất thông tin
    public void xuat() {
        if (this.nguoiDung != null) {
            System.out.println("Thông tin mượn trả tài liệu:");
            System.out.println("Mã tài liệu: " + this.maTL);
            System.out.println("Ngày mượn: " + this.ngayMuon);
            System.out.println("Ngày trả: " + this.ngayTra);
            System.out.println("Số lượng: " + this.soLuong);
            System.out.println("Tên người dùng: " + this.tenNguoiDung);
            System.out.println("Thông tin người dùng: " + this.nguoiDung);
            System.out.println("Trạng thái đã xóa: " + (this.daXoa ? "Đã xóa" : "Chưa xóa"));
        } else {
            System.out.println("Thông tin người dùng không hợp lệ. Không thể xuất thông tin mượn trả tài liệu.");
        }
    }

    @Override
    public String toString() {
        return "MuonTraTL{" +
                "maTL='" + maTL + '\'' +
                ", ngayMuon=" + ngayMuon +
                ", ngayTra=" + ngayTra +
                ", soLuong=" + soLuong +
                ", nguoiDung=" + nguoiDung +
                ", daXoa=" + daXoa +
                '}';
    }
}
