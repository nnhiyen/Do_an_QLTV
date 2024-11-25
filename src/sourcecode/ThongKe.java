package DoAn_QLTV_main.src.sourcecode;

public class ThongKe {
    private NguoiDung[] dsND; // Danh sách người dùng
    private TaiLieu[] dsTL; // Danh sách tài liệu
    private PhieuNhap[] dsPN; // Danh sách phiếu nhập
    private MuonTraTL[] dsMuon; // Danh sách mượn trả tài liệu
    private int soLuongND; // Số lượng người dùng hiện tại
    private int soLuongTL; // Số lượng tài liệu hiện tại
    private int soLuongPN; // Số lượng phiếu nhập hiện tại
    private int soLuongMuon; // Số lượng mượn trả tài liệu hiện tại
    private boolean daXoa; // Trạng thái đã xóa

    // Constructor khởi tạo kích thước cho các danh sách
    public ThongKe(int kichThuocND, int kichThuocTL, int kichThuocPN, int kichThuocMuon) {
        dsND = new NguoiDung[kichThuocND];
        dsTL = new TaiLieu[kichThuocTL];
        dsPN = new PhieuNhap[kichThuocPN];
        dsMuon = new MuonTraTL[kichThuocMuon];
        soLuongND = 0;
        soLuongTL = 0;
        soLuongPN = 0;
        soLuongMuon = 0;
        this.daXoa = false; // Mặc định không bị xóa
    }

    // Phương thức thống kê số người dùng đã mượn tài liệu
   public void soNgMuonTL() { 
       int count = 0; 
       for (int i = 0; i < soLuongND; i++) { 
           if (dsMuonTraTL.kiemTraNguoiDungDaMuon(dsND[i].getTen())) {
               count++; 
           } 
       } System.out.println("Số người dùng mượn tài liệu: " + count); 
   }

    // Phương thức thống kê số tài liệu hiện đang được mượn
    public void soTLChoMuon() {
        int count = 0;
        for (int i = 0; i < soLuongMuon; i++) {
            if (dsMuon[i].getNgayTra() == null || dsMuon[i].getNgayTra().isEmpty()) {
                count++;
            }
        }
        System.out.println("Số tài liệu cho mượn: " + count);
    }

    // Phương thức in ra tổng số phiếu nhập
    public void tongPN() {
        System.out.println("Tổng số phiếu nhập: " + soLuongPN);
    }

    public void tongTienPhieuNhap() { 
        double total = 0; 
        (int i = 0; i < soLuongPN; i++) {
            total += dsPN[i].getTongTien();
        } 
        System.out.println("Tổng tiền phiếu nhập: " + total);
    }

    // Phương thức in ra tổng số người dùng
    public void tongND() {
        System.out.println("Tổng số người dùng: " + soLuongND);
    }

    // Phương thức in ra tổng số tài liệu
    public void tongTL() {
        System.out.println("Tổng số tài liệu: " + soLuongTL);
    }

    // Phương thức thêm người dùng vào danh sách
    public void themNguoiDung(NguoiDung nguoiDung) {
        if (soLuongND < dsND.length) {
            dsND[soLuongND] = nguoiDung;
            soLuongND++;
        } else {
            System.out.println("Danh sách người dùng đã đầy.");
        }
    }

    // Phương thức thêm tài liệu vào danh sách
    public void themTaiLieu(TaiLieu taiLieu) {
        if (soLuongTL < dsTL.length) {
            dsTL[soLuongTL] = taiLieu;
            soLuongTL++;
        } else {
            System.out.println("Danh sách tài liệu đã đầy.");
        }
    }

    // Phương thức thêm phiếu nhập vào danh sách
    public void themPhieuNhap(PhieuNhap phieuNhap) {
        if (soLuongPN < dsPN.length) {
            dsPN[soLuongPN] = phieuNhap;
            soLuongPN++;
        } else {
            System.out.println("Danh sách phiếu nhập đã đầy.");
        }
    }

    // Phương thức thêm mượn trả tài liệu vào danh sách
    public void themMuon(MuonTraTL muonTraTL) {
        if (soLuongMuon < dsMuon.length) {
            dsMuon[soLuongMuon] = muonTraTL;
            soLuongMuon++;
        } else {
            System.out.println("Danh sách mượn trả đã đầy.");
        }
    }

    // Các phương thức getter và setter cho các thuộc tính
    public NguoiDung[] getDsND() {
        return dsND;
    }

    public void setDsND(NguoiDung[] dsND) {
        this.dsND = dsND;
    }

    public TaiLieu[] getDsTL() {
        return dsTL;
    }

    public void setDsTL(TaiLieu[] dsTL) {
        this.dsTL = dsTL;
    }

    public PhieuNhap[] getDsPN() {
        return dsPN;
    }

    public void setDsPN(PhieuNhap[] dsPN) {
        this.dsPN = dsPN;
    }

    public MuonTraTL[] getDsMuon() {
        return dsMuon;
    }

    public void setDsMuon(MuonTraTL[] dsMuon) {
        this.dsMuon = dsMuon;
    }

    public int getSoLuongND() {
        return soLuongND;
    }

    public void setSoLuongND(int soLuongND) {
        this.soLuongND = soLuongND;
    }

    public int getSoLuongTL() {
        return soLuongTL;
    }

    public void setSoLuongTL(int soLuongTL) {
        this.soLuongTL = soLuongTL;
    }

    public int getSoLuongPN() {
        return soLuongPN;
    }

    public void setSoLuongPN(int soLuongPN) {
        this.soLuongPN = soLuongPN;
    }

    public int getSoLuongMuon() {
        return soLuongMuon;
    }

    public void setSoLuongMuon(int soLuongMuon) {
        this.soLuongMuon = soLuongMuon;
    }

    // Phương thức thống kê số người dùng đã xóa tạm thời
    public void soNDXoaTamThoi() {
        int count = 0;
        for (int i = 0; i < soLuongND; i++) {
            if (dsND[i].isDeleted()) {
                count++;
            }
        }
        System.out.println("Số người dùng đã xóa tạm thời: " + count);
    }

    // Phương thức thống kê số tài liệu đã xóa tạm thời
    public void soTLXoaTamThoi() {
        int count = 0;
        for (int i = 0; i < soLuongTL; i++) {
            if (dsTL[i].isDeleted()) {
                count++;
            }
        }
        System.out.println("Số tài liệu đã xóa tạm thời: " + count);
    }

    // Phương thức thống kê số phiếu nhập đã xóa tạm thời
    public void soPNXoaTamThoi() {
        int count = 0;
        for (int i = 0; i < soLuongPN; i++) {
            if (dsPN[i].isDeleted()) {
                count++;
            }
        }
        System.out.println("Số phiếu nhập đã xóa tạm thời: " + count);
    }

    // Phương thức thống kê số mượn trả tài liệu đã xóa tạm thời
    public void soMuonXoaTamThoi() {
        int count = 0;
        for (int i = 0; i < soLuongMuon; i++) {
            if (dsMuon[i].isDaXoa()) {
                count++;
            }
        }
        System.out.println("Số mượn trả tài liệu đã xóa tạm thời: " + count);
    }
}
