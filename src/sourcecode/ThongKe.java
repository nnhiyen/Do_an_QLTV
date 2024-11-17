public class ThongKe {
    private NguoiDung[] dsND;
    private TaiLieu[] dsTL;
    private PhieuNhap[] dsPN;
    private MuonTraTL[] dsMuon;
    private int soLuongND;
    private int soLuongTL;
    private int soLuongPN;
    private int soLuongMuon;

    public ThongKe(int kichThuocND, int kichThuocTL, int kichThuocPN, int kichThuocMuon) {
        dsND = new NguoiDung[kichThuocND];
        dsTL = new TaiLieu[kichThuocTL];
        dsPN = new PhieuNhap[kichThuocPN];
        dsMuon = new MuonTraTL[kichThuocMuon];
        soLuongND = 0;
        soLuongTL = 0;
        soLuongPN = 0;
        soLuongMuon = 0;
    }

    public void soNgMuonTL() {
        int count = 0;
        for (int i = 0; i < soLuongND; i++) {
            if (dsND[i].daMuonTL()) {
                count++;
            }
        }
        System.out.println("Số người dùng mượn tài liệu: " + count);
    }

    public void soTLChoMuon() {
        int count = 0;
        for (int i = 0; i < soLuongMuon; i++) {
            if (dsMuon[i].getNgayTra() == null || dsMuon[i].getNgayTra().isEmpty()) {
                count++;
            }
        }
        System.out.println("Số tài liệu cho mượn: " + count);
    }

    public void soTLNhap() {
        int count = 0;
        for (int i = 0; i < soLuongPN; i++) {
            count += dsPN[i].getTongTien();
        }
        System.out.println("Số tài liệu nhập: " + count);
    }

    public void tongPN() {
        System.out.println("Tổng số phiếu nhập: " + soLuongPN);
    }

    public void tongND() {
        System.out.println("Tổng số người dùng: " + soLuongND);
    }

    public void tongTL() {
        System.out.println("Tổng số tài liệu: " + soLuongTL);
    }

    public void themNguoiDung(NguoiDung nguoiDung) {
        if (soLuongND < dsND.length) {
            dsND[soLuongND] = nguoiDung;
            soLuongND++;
        } else {
            System.out.println("Danh sách người dùng đã đầy.");
        }
    }

    public void themTaiLieu(TaiLieu taiLieu) {
        if (soLuongTL < dsTL.length) {
            dsTL[soLuongTL] = taiLieu;
            soLuongTL++;
        } else {
            System.out.println("Danh sách tài liệu đã đầy.");
        }
    }

    public void themPhieuNhap(PhieuNhap phieuNhap) {
        if (soLuongPN < dsPN.length) {
            dsPN[soLuongPN] = phieuNhap;
            soLuongPN++;
        } else {
            System.out.println("Danh sách phiếu nhập đã đầy.");
        }
    }

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
}
