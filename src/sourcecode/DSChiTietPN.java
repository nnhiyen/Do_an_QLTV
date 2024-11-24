package DoAn_QLTV_main.src.sourcecode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
    public void suaCT(String maPN) {
        for (int i = 0; i < soLuong; i++) {
            if (dsCT[i].getMaPN().equals(maPN)) {
                dsCT[i].nhap();
                ghiDuLieuRaFile("chitietphieunhap.txt");
                System.out.println("Thông tin chi tiết phiếu nhập đã được sửa và lưu vào file.");
                return;
            }
        }
        System.out.println("Không tìm thấy chi tiết phiếu nhập với mã phiếu: " + maPN);
    }

    // Xóa tạm thời chi tiết phiếu nhập
    public void xoaCT(String maPN) {
        for (int i = 0; i < soLuong; i++) {
            if (dsCT[i].getMaPN().equals(maPN)) {
                dsCT[i].setDeleted(true); // Xóa tạm thời chi tiết phiếu nhập
                ghiDuLieuRaFile("chitietphieunhap.txt");
                System.out.println("Xóa tạm thời thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy chi tiết phiếu nhập với mã phiếu: " + maPN);
    }

    // Khôi phục chi tiết phiếu nhập
    public void khoiPhucCT(String maPN) {
        for (int i = 0; i < soLuong; i++) {
            if (dsCT[i].getMaPN().equals(maPN)) {
                dsCT[i].setDeleted(false); // Khôi phục chi tiết phiếu nhập
                ghiDuLieuRaFile("chitietphieunhap.txt");
                System.out.println("Khôi phục thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy chi tiết phiếu nhập với mã phiếu: " + maPN);
    }

    // Hiển thị danh sách đã xóa tạm thời
    public void hienThiDanhSachXoa() {
        System.out.println("Danh sách chi tiết phiếu nhập đã xóa tạm thời:");
        boolean hasDeleted = false;

        for (int i = 0; i < soLuong; i++) {
            if (dsCT[i].isDeleted()) {
                System.out.printf("| %-12s | %-20s | %-6d | %-8.2f | %-8.2f |\n",
                        dsCT[i].getMaPN(), dsCT[i].getMaTL(), dsCT[i].getSoLuong(), dsCT[i].getGiaTien(), dsCT[i].getTongTien());
                hasDeleted = true;
            }
        }

        if (!hasDeleted) {
            System.out.println("Không có chi tiết phiếu nhập nào đã xóa tạm thời.");
        }
    }

    // Hiển thị danh sách chi tiết phiếu nhập
    public void hienThiDanhSach() {
        System.out.println("Danh sách chi tiết phiếu nhập còn lại:");

        if (soLuong == 0) {
            System.out.println("Danh sách trống.");
        } else {
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|  Mã phiếu   |      Mã tài liệu      |  Số lượng | Giá tiền | Tổng tiền |");
            System.out.println("+--------------|-----------------------|------------|-------------|--------------+");
            for (int i = 0; i < soLuong; i++) {
                if (!dsCT[i].isDeleted()) {
                    System.out.printf("| %-12s | %-20s | %-10d | %-10.2f | %-10.2f |\n",
                            dsCT[i].getMaPN(), dsCT[i].getMaTL(), dsCT[i].getSoLuong(), dsCT[i].getGiaTien(), dsCT[i].getTongTien());
                }
            }
            System.out.println("+---------------------------------------------------------+");
        }
    }

    // Ghi dữ liệu vào file
    public void ghiDuLieuRaFile(String tenFile) {
        // Đường dẫn đầy đủ tới file
        String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
            for (int i = 0; i < soLuong; i++) {
                writer.write(dsCT[i].toString());
                writer.newLine();
            }
            System.out.println("Ghi dữ liệu thành công vào file " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
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
                    ChiTietPhieuNhap ct = parseChiTietPhieuNhap(parts);
                    themCT(ct);
                }
            }
            System.out.println("Đọc dữ liệu thành công từ file " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        }
    }

    // Phương thức phân tích chi tiết phiếu nhập từ chuỗi
    private ChiTietPhieuNhap parseChiTietPhieuNhap(String[] parts) {
        String maPN = parts[0].split(": ")[1];
        String maTL = parts[1].split(": ")[1];
        int soLuong = Integer.parseInt(parts[2].split(": ")[1]);
        double giaTien = Double.parseDouble(parts[3].split(": ")[1]);
        return new ChiTietPhieuNhap(maPN, maTL, soLuong, giaTien);
    }
}
