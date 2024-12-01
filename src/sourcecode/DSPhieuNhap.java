package DoAn_QLTV_main.src.sourcecode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DSPhieuNhap {
    private PhieuNhap[] dsPhieuNhap;
    private int soLuongPN;
    Scanner sc = new Scanner(System.in);

    public DSPhieuNhap(int soLuong) {
        dsPhieuNhap = new PhieuNhap[soLuong];
        soLuongPN = 0;
    }

    // Kiểm tra mã phiếu nhập có tồn tại trong file hay không
    public boolean kiemTraPN(String maPN, String tenFile) {
        docDuLieuTuFile(tenFile);

        for (int i = 0; i < soLuongPN; i++) {
            if (dsPhieuNhap[i].getMaPN().equals(maPN)) {
                return true; // Nếu mã phiếu nhập đã tồn tại
            }
        }
        return false; // Nếu không tìm thấy mã phiếu nhập
    }

    // Thêm phiếu nhập
    public void themPhieuNhap(PhieuNhap pn) {
        boolean hopLe = false;

        while (!hopLe) {
            if (kiemTraPN(pn.getMaPN(), "PhieuNhap.txt")) {
                System.out.println("Mã phiếu nhập " + pn.getMaPN() + " đã tồn tại. Vui lòng nhập lại mã.");
                pn.nhap(); // Nhập lại nếu mã bị trùng
            } else {
                hopLe = true; // Khi mã hợp lệ
            }
        }

        if (soLuongPN < dsPhieuNhap.length) {
            dsPhieuNhap[soLuongPN] = pn; // Gán phiếu nhập vào mảng
            soLuongPN++;
        } else {
            System.out.println("Danh sách phiếu nhập đã đầy.");
        }
    }
    public void suaPhieuNhap(String maPN) {
        // Đọc lại dữ liệu từ file để cập nhật danh sách phiếu nhập mới nhất
        docDuLieuTuFile("phieunhap.txt");
    
        // Duyệt qua danh sách phiếu nhập
        for (int i = 0; i < soLuongPN; i++) {
            // Nếu tìm thấy phiếu nhập với mã maPN
            if (dsPhieuNhap[i].getMaPN().equals(maPN)) {
                System.out.println("Thông tin phiếu nhập cần sửa:");
                dsPhieuNhap[i].xuat();  // In ra thông tin phiếu nhập cần sửa
    
                boolean hopLe = false;
                // Nếu mã phiếu nhập trùng với mã trong danh sách, yêu cầu nhập lại mã
                while (!hopLe) {
                    // Nhập lại thông tin phiếu nhập
                    System.out.println("Nhập lại thông tin phiếu nhập: ");
                    dsPhieuNhap[i].nhap();  // Gọi phương thức nhập để cập nhật thông tin mới
    
                    // Lấy mã phiếu nhập sau khi sửa
                    String maMoi = dsPhieuNhap[i].getMaPN();
    
                    // Kiểm tra trùng mã với phiếu nhập khác trong danh sách
                    boolean maTrung = false;
                    for (int j = 0; j < soLuongPN; j++) {
                        if (i != j && dsPhieuNhap[j].getMaPN().equals(maMoi)) {  // Không kiểm tra chính nó
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
                ghiDuLieuRaFile("phieunhap.txt");
                System.out.println("Sửa phiếu nhập thành công và lưu vào file.");
                return;
            }
        }
    
        // Nếu không tìm thấy phiếu nhập với mã maPN
        System.out.println("Không tìm thấy phiếu nhập với mã: " + maPN);
    }
    
    // Xem danh sách phiếu nhập
    public void xemDanhSachPhieuNhap() {
        if (soLuongPN == 0) {
            System.out.println("Danh sách phiếu nhập rỗng.");
            return;
        }

        System.out.println("+--------------------------------------------------+");
        System.out.println("| Ma phieu nhap |  ID nha xuat ban  |   Ngay nhap  |");
        System.out.println("+--------------------------------------------------+");
        for (int i = 0; i < soLuongPN; i++) {
            System.out.println("| " + dsPhieuNhap[i].getMaPN() + "| " + dsPhieuNhap[i].getMaNXB() + "| " + dsPhieuNhap[i].getNgayNhap());
        }
        System.out.println("+--------------------------------------------------+");
    }

    // Tìm phiếu nhập theo mã
    public PhieuNhap timPhieuNhap(String maPN) {
        for (int i = 0; i < soLuongPN; i++) {
            if (dsPhieuNhap[i].getMaPN().equals(maPN)) {
                return dsPhieuNhap[i];
            }
        }
        return null; // Nếu không tìm thấy
    }

    public void xoaPhieuNhap(String maPN) {
        for (int i = 0; i < soLuongPN; i++) {
            if (dsPhieuNhap[i].getMaPN().equals(maPN)) {
                dsPhieuNhap[i].setDeleted(true); // Đánh dấu là đã xóa
                System.out.println("Xóa tạm thời phiếu nhập thành công.");
                ghiDuLieuRaFile("phieunhap.txt"); // Cập nhật lại file
                return;
            }
        }
        System.out.println("Không tìm thấy phiếu nhập với mã: " + maPN);
    }

    public void khoiPhucPhieuNhap(String maPN) {
        for (int i = 0; i < soLuongPN; i++) {
            if (dsPhieuNhap[i].getMaPN().equals(maPN)) {
                dsPhieuNhap[i].setDeleted(false); // Khôi phục trạng thái
                System.out.println("Khôi phục phiếu nhập thành công.");
                ghiDuLieuRaFile("phieunhap.txt"); // Cập nhật lại file
                return;
            }
        }
        System.out.println("Không tìm thấy phiếu nhập với mã: " + maPN);
    }
    public void hienThiDanhSachXoa() {
        System.out.println("Danh sách phiếu nhập đã xóa tạm thời:");
        System.out.println("+---------------------------------------------------------+");
        System.out.println("|                 Phiếu Nhập Đã Xóa Tạm Thời              |");
        System.out.println("+---------------------------------------------------------+");
        System.out.println("|    Mã phiếu  |    Mã NXB    |   Ngày nhập   | Tổng tiền |");
        System.out.println("+---------------------------------------------------------+");
    
        boolean hasDeleted = false;
        
        // Duyệt qua danh sách phiếu nhập
        for (int i = 0; i < soLuongPN; i++) {
            if (dsPhieuNhap[i].isDeleted()) {
                hasDeleted = true;
                // Hiển thị thông tin phiếu nhập đã xóa
                System.out.printf("| %-12s | %-15s | %-12s | %-10.2f |\n", 
                    dsPhieuNhap[i].getMaPN(),
                    dsPhieuNhap[i].getMaNXB(),
                    dsPhieuNhap[i].getNgayNhap(),
                    dsPhieuNhap[i].getTongTien());
            }
        }
    
        if (!hasDeleted) {
            System.out.println("|                  Không có phiếu nhập nào               |");
        }
        System.out.println("+---------------------------------------------------------+");
    }
    
    
        

    // Ghi dữ liệu ra file
    public void ghiDuLieuRaFile(String tenFile) {
        String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
            for (int i = 0; i < soLuongPN; i++) {
                writer.write(dsPhieuNhap[i].toString());
                writer.newLine();
            }
            System.out.println("Ghi dữ liệu thành công vào file " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
        }
    }

    // Đọc dữ liệu từ file
// Đọc dữ liệu từ file
public void docDuLieuTuFile(String tenFile) {
    String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;
    soLuongPN = 0; // Đặt lại số lượng phiếu nhập trước khi đọc

    try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
        String line;
        while ((line = reader.readLine()) != null) { // Đọc từng dòng
            String[] parts = line.split(", "); // Tách dữ liệu theo dấu ", "
            if (parts.length >= 5) { // Đảm bảo đủ thông tin
                String maPN = parts[0];
                String maNXB = parts[1];
                String ngayNhapStr = parts[2];
                double tongTien = Double.parseDouble(parts[3]);
                boolean isDeleted = Boolean.parseBoolean(parts[4]); // Chuyển chuỗi sang boolean

                date ngayNhap = date.fromString(ngayNhapStr); // Chuyển chuỗi ngày sang đối tượng date
                PhieuNhap pn = new PhieuNhap(maPN, maNXB, tongTien, ngayNhap); // Khởi tạo phiếu nhập
                pn.setDeleted(isDeleted); // Đặt trạng thái isDeleted
                dsPhieuNhap[soLuongPN++] = pn; // Thêm vào danh sách
            }
        }
        System.out.println("Đọc dữ liệu thành công từ file: " + duongDan);
    } catch (IOException e) {
        System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
    }
}

}
