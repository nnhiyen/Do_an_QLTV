package DoAn_QLTV_main.src.sourcecode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DSChiTietPhieuNhap {
    private ChiTietPhieuNhap[] dsChiTiet;
    private int soLuongCTPN;
    Scanner sc = new Scanner(System.in);

    public DSChiTietPhieuNhap(int kichThuoc) {
        dsChiTiet = new ChiTietPhieuNhap[kichThuoc];
        soLuongCTPN = 0;
    }

    public boolean kiemTraCTPN(String maPN, String tenFile) {
        docDuLieuTuFile(tenFile); 
    
        for (int i = 0; i < soLuongCTPN; i++) {
            if (dsChiTiet[i].getMaPN().equals(maPN)) {
                return true; 
            }
        }
    
        return false;
    }
    

    public void themChiTietPhieuNhap(ChiTietPhieuNhap ctpn) {
        boolean hopLe = false; 
        while (!hopLe) {
            if (kiemTraCTPN(ctpn.getMaPN(), "chitietphieunhap.txt")) {
                System.out.println("Mã phiếu nhập " + ctpn.getMaPN() + " đã tồn tại. Vui lòng nhập lại mã.");
                ctpn.nhap(); 
            } else {
                hopLe = true;
            }
        }
    
        if (soLuongCTPN < dsChiTiet.length) {
            dsChiTiet[soLuongCTPN] = ctpn;
            soLuongCTPN++;
            ghiDuLieuRaFile("chitietphieunhap.txt"); // Ghi ngay vào file
            System.out.println("Thêm chi tiết phiếu nhập thành công!");
        } else {
            System.out.println("Danh sách chi tiết phiếu nhập đã đầy.");
        }
    }
    
    
    
     
    
    public void suaChiTietPhieuNhap(String maPN) {
        // Đọc lại dữ liệu từ file để cập nhật danh sách chi tiết phiếu nhập mới nhất
        docDuLieuTuFile("chitietphieunhap.txt");
    
        for (int i = 0; i < soLuongCTPN; i++) {
            if (dsChiTiet[i].getMaPN().equals(maPN)) {
                System.out.println("Thông tin chi tiết phiếu nhập cần sửa:");
                dsChiTiet[i].xuat();  // In ra thông tin chi tiết phiếu nhập cần sửa
    
                boolean hopLe = false;
                // Nếu mã phiếu nhập trùng với mã trong danh sách, yêu cầu nhập lại mã
                while (!hopLe) {
                    // Nhập thông tin mới
                    System.out.println("Nhập lại thông tin chi tiết phiếu nhập: ");
                    dsChiTiet[i].nhap();  // Gọi phương thức nhập để cập nhật thông tin mới
    
                    // Lấy mã phiếu nhập sau khi sửa
                    String maMoi = dsChiTiet[i].getMaPN();
    
                    // Kiểm tra trùng mã với chi tiết phiếu nhập khác trong danh sách
                    boolean maTrung = false;
                    for (int j = 0; j < soLuongCTPN; j++) {
                        if (i != j && dsChiTiet[j].getMaPN().equals(maMoi)) {  // Không kiểm tra chính nó
                            maTrung = true;
                            break;
                        }
                    }
    
                    // Nếu mã trùng, yêu cầu nhập lại
                    if (maTrung) {
                        System.out.println("Mã phiếu nhập đã tồn tại, vui lòng nhập lại.");
                    } else {
                        hopLe = true;  // Mã hợp lệ, thoát khỏi vòng lặp
                    }
                }
    
                // Cập nhật lại dữ liệu vào file sau khi sửa
                ghiDuLieuRaFile("chitietphieunhap.txt");
                System.out.println("Sửa thành công.");
                return;
            }
        }
        
        System.out.println("Không tìm thấy chi tiết phiếu nhập với mã: " + maPN);
    }
    public void xoaChiTietPhieuNhap(String maPN) {
        for (int i = 0; i < soLuongCTPN; i++) {
            if (dsChiTiet[i].getMaPN().equals(maPN)) {
                dsChiTiet[i].setDeleted(true);
                System.out.println("Xóa tạm thời chi tiết phiếu nhập thành công.");
                ghiDuLieuRaFile("chitietphieunhap.txt"); // Cập nhật lại file
                return;
            }
        }
        System.out.println("Không tìm thấy chi tiết phiếu nhập với mã: " + maPN);
    }
    public void khoiPhucChiTietPhieuNhap(String maPN) {
        for (int i = 0; i < soLuongCTPN; i++) {
            if (dsChiTiet[i].getMaPN().equals(maPN)) {
                dsChiTiet[i].setDeleted(false);
                System.out.println("Khôi phục chi tiết phiếu nhập thành công.");
                ghiDuLieuRaFile("chitietphieunhap.txt"); // Cập nhật lại file
                return;
            }
        }
        System.out.println("Không tìm thấy chi tiết phiếu nhập với mã: " + maPN);
    }
    public void hienThiDanhSachXoa() {
        System.out.println("Danh sách chi tiết phiếu nhập đã xóa tạm thời:");
        System.out.println("+---------------------------------------------------------+");
        System.out.println("|                 Chi Tiết Phiếu Nhập Đã Xóa Tạm Thời    |");
        System.out.println("+---------------------------------------------------------+");
        System.out.println("|    Mã phiếu nhập   |    Mã tài liệu    |    Số lượng    |");
        System.out.println("+---------------------------------------------------------+");
    
        boolean hasDeleted = false;
        for (int i = 0; i < soLuongCTPN; i++) {
            if (dsChiTiet[i].isDeleted()) {
                hasDeleted = true;
                System.out.printf("| %-16s | %-16s | %-12d |\n",
                        dsChiTiet[i].getMaPN(),
                        dsChiTiet[i].getMaTL(),
                        dsChiTiet[i].getSoLuong());
            }
        }
    
        if (!hasDeleted) {
            System.out.println("|                  Không có chi tiết phiếu nhập nào                 |");
        }
        System.out.println("+---------------------------------------------------------+");
    }
    
    public void timKiemCTPN(String maPN) {
        boolean found = false;
    
        for (int i = 0; i < soLuongCTPN; i++) {
            if (dsChiTiet[i].getMaPN().equals(maPN)) {
                System.out.println("+---------------------------------------------------------+");
                System.out.println("|                    Thông Tin Chi Tiết Phiếu Nhập       |");
                System.out.println("+---------------------------------------------------------+");
                System.out.println("|    Mã phiếu nhập   |    Mã tài liệu    |    Số lượng    |");
                System.out.println("+---------------------------------------------------------+");
                System.out.printf("| %-16s | %-16s | %-12d |\n",
                        dsChiTiet[i].getMaPN(),
                        dsChiTiet[i].getMaTL(),
                        dsChiTiet[i].getSoLuong());
                System.out.println("+---------------------------------------------------------+");
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("Không tìm thấy chi tiết phiếu nhập với mã: " + maPN);
        }
    }
    public void hienThiDanhSach() {
        System.out.println("Danh sách chi tiết phiếu nhập còn lại:");
        if (soLuongCTPN == 0) {
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                  Danh sách trống                       |");
            System.out.println("+---------------------------------------------------------+");
            return;
        }
    
        System.out.println("+---------------------------------------------------------+");
        System.out.println("|                    Thông Tin Chi Tiết Phiếu Nhập       |");
        System.out.println("+---------------------------------------------------------+");
        System.out.println("|    Mã phiếu nhập   |    Mã tài liệu    |    Số lượng    |    Giá tiền    |    Thành tiền    |");
        System.out.println("+---------------------------------------------------------+");
    
        for (int i = 0; i < soLuongCTPN; i++) {
            if (!dsChiTiet[i].isDeleted()) {
                System.out.printf("| %-16s | %-16s | %-12d | %-12.2f | %-12.2f |\n",
                        dsChiTiet[i].getMaPN(),
                        dsChiTiet[i].getMaTL(),
                        dsChiTiet[i].getSoLuong(),
                        dsChiTiet[i].getGiaTien(),
                        dsChiTiet[i].getThanhTien());
            }
        }
        System.out.println("+---------------------------------------------------------+");
    }
    
    public void ghiDuLieuRaFile(String tenFile) {
        String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
            for (int i = 0; i < soLuongCTPN; i++) {
                writer.write(dsChiTiet[i].toString()); // Gọi phương thức toString() của ChiTietPhieuNhap
                writer.newLine();
            }
            System.out.println("Ghi dữ liệu thành công vào file " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
        }
    }
    public void docDuLieuTuFile(String tenFile) {
        String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;
        soLuongCTPN = 0; // Đặt lại số lượng chi tiết phiếu nhập trước khi đọc
    
        try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length >= 6) { // Bao gồm các trường dữ liệu và trạng thái isDeleted
                    String maPN = parts[0].split(": ")[1];
                    String maTL = parts[1].split(": ")[1];
                    int soLuong = Integer.parseInt(parts[2].split(": ")[1]);
                    double giaTien = Double.parseDouble(parts[3].split(": ")[1]);
                    double thanhTien = Double.parseDouble(parts[4].split(": ")[1]);
                    boolean isDeleted = Boolean.parseBoolean(parts[5].split(": ")[1]);
    
                    // Tạo đối tượng ChiTietPhieuNhap
                    ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
                    ctpn.setMaPN(maPN); 
                    ctpn.setMaTL(maTL); 
                    ctpn.setSoLuong(soLuong); 
                    ctpn.setGiaTien(giaTien); 
                    ctpn.setThanhTien(thanhTien);
                    ctpn.setDeleted(isDeleted);
    
                    // Thêm vào danh sách
                    dsChiTiet[soLuongCTPN++] = ctpn;
                }
            }
            System.out.println("Đọc dữ liệu thành công từ file " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        }
    }
}    
    

   
