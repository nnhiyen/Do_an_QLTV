package DoAn_QLTV_main.src.sourcecode;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class DSNhaXuatBan {
    private final NhaXuatBan[] dsNXB;
    private int soLuong;

    // Constructor
    public DSNhaXuatBan(int kichThuoc) {
        dsNXB = new NhaXuatBan[kichThuoc];
        soLuong = 0;
    }

    // Thêm nhà xuất bản
    public void themNXB(NhaXuatBan nxb) {
        if (soLuong < dsNXB.length) {
            dsNXB[soLuong] = nxb;
            soLuong++;
        } else {
            System.out.println("Danh sách nhà xuất bản đã đầy!");
        }
    }

    // Thêm nhiều nhà xuất bản
    public void themNNXB(int soLuongThem) {
        for (int i = 0; i < soLuongThem; i++) {
            System.out.println("Thêm nhà xuất bản thứ " + (i + 1) + ":");
            NhaXuatBan nxb = new NhaXuatBan();
            nxb.nhap();
            themNXB(nxb);
        }
    }

    // Kiểm tra sự tồn tại của nhà xuất bản dựa trên mã NXB
    private boolean tontaiNXB(String maNXB) {
        for (int i = 0; i < soLuong; i++) {
            if (dsNXB[i].getMaNXB().equals(maNXB)) {
                return true;
            }
        }
        return false;
    }

    // Sửa thông tin nhà xuất bản
    public void suaNXB(String maNXB) {
        if (!tontaiNXB(maNXB)) {
            System.out.println("Không tìm thấy nhà xuất bản.");
            return;
        }
        for (int i = 0; i < soLuong; i++) {
            if (dsNXB[i].getMaNXB().equals(maNXB)) {
                System.out.println("Sửa thông tin nhà xuất bản: ");
                dsNXB[i].nhap();
                return;
            }
        }
    }

    // Xóa nhà xuất bản
    public void xoaNXB(String maNXB) {
        for (int i = 0; i < soLuong; i++) {
            if (dsNXB[i].getMaNXB().equals(maNXB)) {
                for (int j = i; j < soLuong - 1; j++) {
                    dsNXB[j] = dsNXB[j + 1];
                }
                dsNXB[soLuong - 1] = null;
                soLuong--;
                System.out.println("Xóa nhà xuất bản thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy nhà xuất bản.");
    }

    // Tìm kiếm nhà xuất bản theo mã
    public void timkiemNXB(String maNXB) {
        for (int i = 0; i < soLuong; i++) {
            if (dsNXB[i].getMaNXB().equals(maNXB)) {
                dsNXB[i].xuat();
                return;
            }
        }
        System.out.println("Không tìm thấy nhà xuất bản.");
    }

    // Hiển thị danh sách nhà xuất bản
    public void hienThiDanhSach() {
        System.out.println("Danh sách nhà xuất bản:");
        if (soLuong == 0) {
            System.out.println("Danh sách trống.");
        } else {
            for (int i = 0; i < soLuong; i++) {
                dsNXB[i].xuat();
            }
        }
    }

    // Ghi dữ liệu ra file
    public void ghiDuLieuRaFile(String tenFile) {
        String duongDan = "C:\\Users\\nthon\\Documents\\NetBeansProjects\\DoAn_QLTV\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
            for (int i = 0; i < soLuong; i++) {
                writer.write(dsNXB[i].toString());
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
                if (parts.length >= 2) {
                    String maNXB = parts[0].split(": ")[1];
                    String tenNXB = parts[1].split(": ")[1];

                    NhaXuatBan nxb = new NhaXuatBan(maNXB, tenNXB);
                    themNXB(nxb);
                }
            }
            System.out.println("Đọc dữ liệu thành công từ file " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        }
    }
}

