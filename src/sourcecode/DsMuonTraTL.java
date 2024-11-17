public class DsMuonTraTL {
    private MuonTraTL[] dsMT;
    private int soLuongMuonTra;

    public void setDsMT(MuonTraTL[] dsMT) {
        this.dsMT = dsMT;
    }

    public void setSoLuongMuonTra(int soLuongMuonTra) {
        this.soLuongMuonTra = soLuongMuonTra;
    }

    public MuonTraTL[] getDsMT() {
        return dsMT;
    }

    public int getSoLuongMuonTra() {
        return soLuongMuonTra;
    }

    public DsMuonTraTL(int kichThuoc) {
        dsMT = new MuonTraTL[kichThuoc];
        soLuongMuonTra = 0;
    }

    public void themMuon(MuonTraTL muonTraTL) {
        if (soLuongMuonTra < dsMT.length) {
            dsMT[soLuongMuonTra] = muonTraTL;
            soLuongMuonTra++;
        } else {
            System.out.println("Danh sách mượn trả đã đầy.");
        }
    }

    public void xoaMuon(String maTL) {
        for (int i = 0; i < soLuongMuonTra; i++) {
            if (dsMT[i].getMaTL().equals(maTL)) {
                for (int j = i; j < soLuongMuonTra - 1; j++) {
                    dsMT[j] = dsMT[j + 1];
                }
                dsMT[soLuongMuonTra - 1] = null;
                soLuongMuonTra--;
                break;
            }
        }
    }

    public void hienThiDanhSach() {
        for (int i = 0; i < soLuongMuonTra; i++) {
            dsMT[i].xuat();
        }
    }

    public static void main(String[] args) {
        DsMuonTraTL dsMuonTraTL = new DsMuonTraTL(10);

        MuonTraTL muon1 = new MuonTraTL("TL001", "2024-11-01", "2024-11-10", 2);
        MuonTraTL muon2 = new MuonTraTL("TL002", "2024-11-05", "2024-11-15", 1);
        dsMuonTraTL.themMuon(muon1);
        dsMuonTraTL.themMuon(muon2);

        dsMuonTraTL.hienThiDanhSach();

        dsMuonTraTL.xoaMuon("TL001");

        dsMuonTraTL.hienThiDanhSach();
    }
}
