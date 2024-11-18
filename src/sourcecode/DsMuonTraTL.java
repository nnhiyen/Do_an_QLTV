package DoAn_QLTV_main.src.sourcecode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DsMuonTraTL {
    private MuonTraTL[] dsMT;
    private int soLuongMuonTra;

    public DsMuonTraTL(int kichThuoc) {
        dsMT = new MuonTraTL[kichThuoc];
        soLuongMuonTra = 0;
    }

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

    public void docDuLieuTuFile(DSNguoiDung dsNguoiDung) {
        String tenFile = "duLieuMuonTra.txt"; // Đọc dữ liệu từ file cố định
        try (BufferedReader reader = new BufferedReader(new FileReader(tenFile))) {
            String line;
            while ((line = reader.readLine()) != null && soLuongMuonTra < dsMT.length) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String maTL = data[0];
                    String ngayMuon = data[1];
                    String ngayTra = data[2];
                    int soLuong = Integer.parseInt(data[3]);
                    String tenNguoiDung = data[4];

                    MuonTraTL muonTraTL = new MuonTraTL(maTL, ngayMuon, ngayTra, soLuong, tenNguoiDung);
                    // Tìm kiếm thông tin người dùng và cập nhật vào đối tượng MuonTraTL
                    muonTraTL.setNguoiDung(dsNguoiDung.timKiemNguoiDung(tenNguoiDung));
                    themMuon(muonTraTL);
                }
            }
        } catch (IOException e) {
            System.out.println("Không thể đọc file: " + e.getMessage());
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
