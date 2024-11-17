package DoAn_QLTV_main.src.sourcecode;


import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DSPhieuNhap {
    private final PhieuNhap[] dsPhieuNhap;
    private int soLuong;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    // Constructor
    public DSPhieuNhap(int kichThuoc) {
        dsPhieuNhap = new PhieuNhap[kichThuoc];
        soLuong = 0;
    }

    // Thêm phiếu nhập
    public void themPN(PhieuNhap pn) {
        if (soLuong < dsPhieuNhap.length) {
            dsPhieuNhap[soLuong] = pn;
            soLuong++;
        } else {
            System.out.println("Danh sách phiếu nhập đã đầy!");
        }
    }

    // Thêm nhiều phiếu nhập
    public void themNPN(int soLuongThem) {
        for (int i = 0; i < soLuongThem; i++) {
            System.out.println("Thêm phiếu nhập thứ " + (i + 1) + ":");
            PhieuNhap pn = new PhieuNhap();
            pn.nhap();
            themPN(pn);
        }
    }

    // Kiểm tra sự tồn tại của phiếu nhập dựa trên mã phiếu
    private boolean tontaiPN(String maPhieu) {
        for (int i = 0; i < soLuong; i++) {
            if (dsPhieuNhap[i].getMaPhieu().equals(maPhieu)) {
                return true;
            }
        }
        return false;
    }

    // Sửa thông tin phiếu nhập
    public void suaPN(String maPhieu) {
        if (!tontaiPN(maPhieu)) {
            System.out.println("Không tìm thấy phiếu nhập.");
            return;
        }
        for (int i = 0; i < soLuong; i++) {
            if (dsPhieuNhap[i].getMaPhieu().equals(maPhieu)) {
                System.out.println("Sửa thông tin phiếu nhập: ");
                dsPhieuNhap[i].nhap();
                return;
            }
        }
    }

    // Xóa phiếu nhập
    public void xoaPN(String maPhieu) {
        for (int i = 0; i < soLuong; i++) {
            if (dsPhieuNhap[i].getMaPhieu().equals(maPhieu)) {
                for (int j = i; j < soLuong - 1; j++) {
                    dsPhieuNhap[j] = dsPhieuNhap[j + 1];
                }
                dsPhieuNhap[soLuong - 1] = null;
                soLuong--;
                System.out.println("Xóa phiếu nhập thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy phiếu nhập.");
    }

    // Tìm kiếm phiếu nhập theo mã phiếu
    public void timkiemPN(String maPhieu) {
        for (int i = 0; i < soLuong; i++) {
            if (dsPhieuNhap[i].getMaPhieu().equals(maPhieu)) {
                dsPhieuNhap[i].xuat();
                return;
            }
        }
        System.out.println("Không tìm thấy phiếu nhập.");
    }

    // Hiển thị danh sách phiếu nhập
    public void hienThiDanhSach() {
        System.out.println("Danh sách phiếu nhập:");
        if (soLuong == 0) {
            System.out.println("Danh sách trống.");
        } else {
            for (int i = 0; i < soLuong; i++) {
                dsPhieuNhap[i].xuat();
            }
        }
    }

    // Ghi dữ liệu ra file
    public void ghiDuLieuRaFile(String tenFile) {
        if (soLuong == 0) {
            System.out.println("Không có dữ liệu để ghi.");
            return;
        }

        String duongDan = "C:\\Users\\nthon\\Documents\\NetBeansProjects\\DoAn_QLTV\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
            for (int i = 0; i < soLuong; i++) {
                writer.write(dsPhieuNhap[i].toString());
                writer.newLine();
            }
            System.out.println("Ghi dữ liệu thành công vào file " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
        }
    }

    // Đọc dữ liệu từ file
    public void docDuLieuTuFile(String tenFile) {
        String duongDan = "C:\\Users\\nthon\\Documents\\NetBeansProjects\\DoAn_QLTV\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;

        try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length >= 6) { // Kiểm tra số lượng trường
                    String maPhieu = parts[0].split(": ")[1];
                    String maTL = parts[1].split(": ")[1];
                    String maNXB = parts[2].split(": ")[1];
                    int soLuong = Integer.parseInt(parts[3].split(": ")[1]);
                    double giaTien = Double.parseDouble(parts[4].split(": ")[1]);
                    Date ngayNhap = dateFormat.parse(parts[5].split(": ")[1]);

                    PhieuNhap pn = new PhieuNhap();
                    pn.setMaPhieu(maPhieu);
                    pn.setMaTL(maTL);
                    pn.setMaNXB(maNXB);
                    pn.setSoLuong(soLuong);
                    pn.setGiaTien(giaTien);
                    pn.setNgayNhap(ngayNhap);
                    themPN(pn);
                }
            }
            System.out.println("Đọc dữ liệu thành công từ file " + duongDan);
        } catch (IOException | ParseException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        }
    }
}

