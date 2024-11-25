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
                    muonTraTL.setNguoiDung(dsNguoiDung.timKiemNguoiDungTheoTen(tenNguoiDung)[0]);
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

    public boolean kiemTraNguoiDungDaMuon(String tenNguoiDung) { 
        for (int i = 0; i < soLuongMuonTra; i++) {
            if (dsMT[i].getTenNguoiDung().equals(tenNguoiDung)) { 
                return true; } 
        } return false; 
    }

    public void xoaMuon(String maTL) {
        for (int i = 0; i < soLuongMuonTra; i++) {
            if (dsMT[i].getMaTL().equals(maTL)) {
                dsMT[i].setDaXoa(true); // Đánh dấu mục này là đã xóa
                break;
            }
        }
    }

    public void khoiPhucMuon(String maTL) {
        for (int i = 0; i < soLuongMuonTra; i++) {
            if (dsMT[i].getMaTL().equals(maTL)) {
                dsMT[i].setDaXoa(false); // Khôi phục mục này
                break;
            }
        }
    }

    public void hienThiDanhSach() {
        for (int i = 0; i < soLuongMuonTra; i++) {
            if (!dsMT[i].isDaXoa()) {
                dsMT[i].xuat();
            }
        }
    }

    public void hienThiDanhSachXoa() {
        System.out.println("Danh sách mượn trả đã xóa tạm thời:");
        boolean hasDeleted = false; 
        
        for (int i = 0; i < soLuongMuonTra; i++) {
            if (dsMT[i].isDaXoa()) {
                dsMT[i].xuat();
                hasDeleted = true;
            }
        }
        
        if (!hasDeleted) {
            System.out.println("Không có mục nào đã xóa tạm thời.");
        }
    }
}
