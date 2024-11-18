package DoAn_QLTV_main.src.sourcecode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DSChiTietPN {
    private ChiTietPhieuNhap[] dsCT;
    private int soLuong;

    // Constructor
    public DSChiTietPN(int kichThuoc) {
        dsCT = new ChiTietPhieuNhap[kichThuoc];
        soLuong = 0;
    }

    // Thêm chi tiết phiếu nhập
    public void themCT(ChiTietPhieuNhap ct) {
        if (soLuong < dsCT.length) {
            dsCT[soLuong] = ct;
            soLuong++;
        } else {
            System.out.println("Danh sách đã đầy!");
        }
    }

    // Sửa chi tiết phiếu nhập
    public void suaCT(String maPhieu) {
        for (int i = 0; i < soLuong; i++) {
            if (dsCT[i].getMaPhieu().equals(maPhieu)) {
                dsCT[i].nhap();
                return;
            }
        }
        System.out.println("Không tìm thấy chi tiết phiếu nhập với mã phiếu: " + maPhieu);
    }

    // Xóa chi tiết phiếu nhập
    public void xoaCT(String maPhieu) {
        for (int i = 0; i < soLuong; i++) {
            if (dsCT[i].getMaPhieu().equals(maPhieu)) {
                for (int j = i; j < soLuong - 1; j++) {
                    dsCT[j] = dsCT[j + 1];
                }
                dsCT[soLuong - 1] = null;
                soLuong--;
                return;
            }
        }
        System.out.println("Không tìm thấy chi tiết phiếu nhập với mã phiếu: " + maPhieu);
    }

    // Tìm kiếm chi tiết phiếu nhập
    public void timKiemPN(String maPhieu) {
        for (int i = 0; i < soLuong; i++) {
            if (dsCT[i].getMaPhieu().equals(maPhieu)) {
                dsCT[i].xuat();
                return;
            }
        }
        System.out.println("Không tìm thấy chi tiết phiếu nhập với mã phiếu: " + maPhieu);
    }

    // Xuất danh sách chi tiết phiếu nhập
    public void xuat_ds() {
        for (int i = 0; i < soLuong; i++) {
            dsCT[i].xuat();
        }
    }

    // Đọc dữ liệu từ file
    public void docDuLieuTuFile() {
        // Sử dụng đường dẫn tương đối
        String duongDan = "chitietphieunhap.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length >= 5) {
                    String maPhieu = parts[0].split(": ")[1];
                    String maTL = parts[1].split(": ")[1];
                    int soLuong = Integer.parseInt(parts[2].split(": ")[1]);
                    double giaTien = Double.parseDouble(parts[3].split(": ")[1]);
                    double thanhTien = Double.parseDouble(parts[4].split(": ")[1]);

                    ChiTietPhieuNhap ct = new ChiTietPhieuNhap(maPhieu, maTL, soLuong, giaTien);
                    themCT(ct);
                }
            }
            System.out.println("Đọc dữ liệu thành công từ file " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        }
    }
}
