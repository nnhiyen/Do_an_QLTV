package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class MuonTraTL {
    private String maTL;
    private String ngayMuon;
    private String ngayTra;
    private int soLuong;
    private String tenNguoiDung; // Chỉ lưu tên người dùng
    private NguoiDung nguoiDung; // Thông tin người dùng (sau khi tìm thấy)
    private boolean daXoa; // Trạng thái đã xóa

    public MuonTraTL() {}

    public MuonTraTL(String maTL, String ngayMuon, String ngayTra, int soLuong, String tenNguoiDung) {
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

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
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

    // Phương thức nhập thông tin
    public void nhap(DSNguoiDung dsNguoiDung) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã tài liệu: ");
        this.maTL = scanner.nextLine();
        System.out.print("Nhập ngày mượn: ");
        this.ngayMuon = scanner.nextLine();
        System.out.print("Nhập ngày trả: ");
        this.ngayTra = scanner.nextLine();
        System.out.print("Nhập số lượng: ");
        this.soLuong = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline sau khi nhập số

        System.out.print("Nhập tên người dùng: ");
        this.tenNguoiDung = scanner.nextLine();

        // Tìm kiếm thông tin người dùng dựa trên tên người dùng
        NguoiDung[] nguoiDungs = timKiemNguoiDungTheoTen(this.tenNguoiDung, dsNguoiDung);

        if (nguoiDungs == null || nguoiDungs.length == 0) {
            System.out.println("Không tìm thấy người dùng với tên: " + this.tenNguoiDung);
        } else if (nguoiDungs.length == 1) {
            this.nguoiDung = nguoiDungs[0];
        } else {
            System.out.println("Có nhiều người dùng với tên: " + this.tenNguoiDung);
            System.out.print("Vui lòng nhập mã giảng viên hoặc mã sinh viên: ");
            String maNguoiDung = scanner.nextLine();
            this.nguoiDung = timKiemNguoiDungTheoMa(maNguoiDung, dsNguoiDung);
        }
    }

    // Phương thức xuất thông tin
    public void xuat() {
        if (this.nguoiDung != null) {
            System.out.println(this);
        } else {
            System.out.println("Thông tin người dùng không hợp lệ. Không thể xuất thông tin mượn trả tài liệu.");
        }
    }

    @Override
    public String toString() {
        return "MuonTraTL{" +
                "maTL='" + maTL + '\'' +
                ", ngayMuon='" + ngayMuon + '\'' +
                ", ngayTra='" + ngayTra + '\'' +
                ", soLuong=" + soLuong +
                ", nguoiDung=" + nguoiDung +
                ", daXoa=" + daXoa +
                '}';
    }
}
