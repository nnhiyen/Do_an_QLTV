import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
        docDuLieuTuFile();
    }

    private void docDuLieuTuFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("duLieuMuonTra.txt"))) {
            String line;
            while ((line = reader.readLine()) != null && soLuongMuonTra < dsMT.length) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    MuonTraTL muonTraTL = new MuonTraTL(data[0], data[1], data[2], Integer.parseInt(data[3]));
                    dsMT[soLuongMuonTra] = muonTraTL;
                    soLuongMuonTra++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
