package DoAn_QLTV_main.src.sourcecode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    // Sửa phiếu nhập
    public void suaPhieuNhap(String maPN) {
        docDuLieuTuFile("phieunhap.txt");

        for (int i = 0; i < soLuongPN; i++) {
            if (dsPhieuNhap[i].getMaPN().equals(maPN)) {
                System.out.println("Thông tin phiếu nhập cần sửa:");
                dsPhieuNhap[i].xuatPN();  // In ra thông tin phiếu nhập cần sửa

                boolean hopLe = false;
                while (!hopLe) {
                    System.out.println("Hãy nhập lại thông tin phiếu nhập: ");
                    dsPhieuNhap[i].nhap();  // Gọi phương thức nhập để cập nhật thông tin mới

                    String maMoi = dsPhieuNhap[i].getMaPN();

                    boolean maTrung = false;
                    for (int j = 0; j < soLuongPN; j++) {
                        if (i != j && dsPhieuNhap[j].getMaPN().equals(maMoi)) {
                            maTrung = true;
                            break;
                        }
                    }

                    if (maTrung) {
                        System.out.println("Mã phiếu nhập đã tồn tại, vui lòng nhập lại.");
                    } else {
                        hopLe = true;
                    }
                }

                ghiDuLieuRaFile("phieunhap.txt");
                System.out.println("Sửa phiếu nhập thành công và lưu vào file.");
                return;
            }
        }

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
        return null;
    }

    // Xóa phiếu nhập
    public void xoaPhieuNhap(String maPN) {
        for (int i = 0; i < soLuongPN; i++) {
            if (dsPhieuNhap[i].getMaPN().equals(maPN)) {
                dsPhieuNhap[i].setDeleted(true); // Đánh dấu là đã xóa
                System.out.println("Xóa tạm thời phiếu nhập thành công.");
                ghiDuLieuRaFile("phieunhap.txt");
                return;
            }
        }
        System.out.println("Không tìm thấy phiếu nhập với mã: " + maPN);
    }

    // Khôi phục phiếu nhập
    public void khoiPhucPhieuNhap(String maPN) {
        for (int i = 0; i < soLuongPN; i++) {
            if (dsPhieuNhap[i].getMaPN().equals(maPN)) {
                dsPhieuNhap[i].setDeleted(false); // Khôi phục trạng thái
                System.out.println("Khôi phục phiếu nhập thành công.");
                ghiDuLieuRaFile("phieunhap.txt");
                return;
            }
        }
        System.out.println("Không tìm thấy phiếu nhập với mã: " + maPN);
    }

    // Hiển thị danh sách phiếu nhập đã xóa
    public void hienThiDanhSachXoa() {
        System.out.println("Danh sách phiếu nhập đã xóa tạm thời:");
        System.out.println("+---------------------------------------------------------+");
        System.out.println("|                 Phiếu Nhập Đã Xóa Tạm Thời              |");
        System.out.println("+---------------------------------------------------------+");
        System.out.println("|    Mã phiếu  |    Mã NXB    |   Ngày nhập   | Tổng tiền |");
        System.out.println("+---------------------------------------------------------+");

        boolean hasDeleted = false;
        
        for (int i = 0; i < soLuongPN; i++) {
            if (dsPhieuNhap[i].isDeleted()) {
                hasDeleted = true;
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
        String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\HelloAll\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;

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
    public void docDuLieuTuFile(String tenFile) {
        String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\HelloAll\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;
        soLuongPN = 0; // Đặt lại số lượng phiếu nhập trước khi đọc

        try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", "); // Phân tách theo dấu phẩy

                if (parts.length >= 5) { // Đảm bảo có đủ dữ liệu
                    String maPN = parts[0].split(": ")[1];
                    String maNXB = parts[1].split(": ")[1];
                    String ngayNhapStr = parts[2].split(": ")[1];
                    double tongTien = Double.parseDouble(parts[3].split(": ")[1]);
                    boolean isDeleted = Boolean.parseBoolean(parts[4].split(": ")[1]);

                    // Chuyển chuỗi ngày thành đối tượng 'date'
                    date ngayNhap = new date(); // Cần phải có một cách chuyển chuỗi ngày thành đối tượng 'date'
                    ngayNhap.parseNgay(ngayNhapStr); // Giả sử phương thức parseNgay() giúp chuyển chuỗi thành đối tượng 'date'

                    // Tạo đối tượng PhieuNhap và thêm vào danh sách
                    PhieuNhap pn = new PhieuNhap(maPN, maNXB, tongTien, ngayNhap);
                    pn.setDeleted(isDeleted); // Cập nhật trạng thái bị xóa
                    dsPhieuNhap[soLuongPN++] = pn; // Thêm vào danh sách
                }
            }
            System.out.println("Đọc dữ liệu thành công từ file: " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        }
    }
}
