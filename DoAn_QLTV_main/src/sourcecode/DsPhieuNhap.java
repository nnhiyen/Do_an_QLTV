package DoAn_QLTV_main.src.sourcecode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DsPhieuNhap {
    private PhieuNhap[] dsPhieuNhap;
    private int soLuongPN;
    Scanner sc = new Scanner(System.in);
    DsNhaXuatBan dsNhaXuatBan = new DsNhaXuatBan(100);
    public DsPhieuNhap(int soLuong) {
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
    public boolean kiemTraMaPN(String maPN) {
    try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\thon\\Desktop\\New folder (6)\\Do_an_QLTV\\DoAn_QLTV_main\\src\\sourcefile\\phieunhap.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("Mã phiếu nhập: " + maPN + ",")) {
                return true;  
            }
        }
    } catch (IOException e) {
        System.out.println("Lỗi đọc file PN: " + e.getMessage());
    }
    return false; 
}

    // Thêm phiếu nhập (NEWWWWWW)
    public void themPhieuNhap(PhieuNhap pn) {
    if (kiemTraPN(pn.getMaPN(), "phieunhap.txt")) {
        System.out.println("Mã phiếu nhập " + pn.getMaPN() + " đã tồn tại. Vui lòng nhập lại mã.");
        pn.nhap();  // Gọi lại phương thức nhập nếu mã phiếu nhập đã tồn tại
    }

    
    if (!dsNhaXuatBan.kiemTraMaNXB(pn.getMaNXB())) {
        System.out.println("Mã NXB không hợp lệ. Không thể thêm phiếu nhập.");
        return; 
    }

    if (soLuongPN < dsPhieuNhap.length) {
        dsPhieuNhap[soLuongPN] = pn;
        soLuongPN++;
        ghiDuLieuRaFile("phieunhap.txt");  // Ghi vào file chỉ khi mọi thứ hợp lệ
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
            dsPhieuNhap[i].xuatPN();  // In ra thông tin phiếu nhập cần sửa

            boolean hopLe = false;
            // Nếu mã phiếu nhập trùng với mã trong danh sách, yêu cầu nhập lại mã
            while (!hopLe) {
                // Nhập lại thông tin phiếu nhập
                System.out.println("Hãy nhập lại thông tin phiếu nhập: ");
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
                    // Kiểm tra mã NXB sau khi sửa
                    if (!dsNhaXuatBan.kiemTraMaNXB(dsPhieuNhap[i].getMaNXB())) {
                        System.out.println("Mã NXB không hợp lệ. Không thể sửa phiếu nhập.");
                        return; // Dừng phương thức nếu mã NXB không hợp lệ
                    }
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

    System.out.println("+---------------------------------------------------+");
    System.out.println("| Ma phieu nhap |  ID nha xuat ban  | Ngay nhap     |");
    System.out.println("+---------------------------------------------------+");

    for (int i = 0; i < soLuongPN; i++) {
        // Chỉ hiển thị các phiếu nhập chưa bị xóa
        if (!dsPhieuNhap[i].isDeleted()) {
            PhieuNhap pn = dsPhieuNhap[i];
            String ngayNhapStr = pn.getNgayNhap().getNgay() + "/" + pn.getNgayNhap().getThang() + "/" + pn.getNgayNhap().getNam();
            System.out.printf("| %-13s | %-17s | %-13s |\n", pn.getMaPN(), pn.getMaNXB(), ngayNhapStr);
        }
    }

    System.out.println("+---------------------------------------------------+");
}


    // Tìm phiếu nhập theo mã và hiển thị thông tin
    public void timPhieuNhap(String maPN) {
    boolean timThay = false;

    for (int i = 0; i < soLuongPN; i++) {
        if (dsPhieuNhap[i].getMaPN().equals(maPN)) {
            // Hiển thị tiêu đề bảng
            System.out.println("+---------------------------------------------------+");
            System.out.println("| Ma phieu nhap |  ID nha xuat ban  | Ngay nhap     |");
            System.out.println("+---------------------------------------------------+");

            // Lấy thông tin phiếu nhập
            String ngayNhapStr = dsPhieuNhap[i].getNgayNhap().getNgay() + "/" +
                                 dsPhieuNhap[i].getNgayNhap().getThang() + "/" +
                                 dsPhieuNhap[i].getNgayNhap().getNam();
            System.out.printf("| %-13s | %-17s | %-13s |\n",
                              dsPhieuNhap[i].getMaPN(),
                              dsPhieuNhap[i].getMaNXB(),
                              ngayNhapStr);

            // Kết thúc bảng
            System.out.println("+---------------------------------------------------+");

            timThay = true;
            break; // Dừng tìm kiếm sau khi tìm thấy
        }
    }

    if (!timThay) {
        System.out.println("Không tìm thấy phiếu nhập với mã: " + maPN);
    }
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
    
    // Hiển thị danh sách nhà xuất bản đã xóa
    public void hienThiDanhSachXoa() {
        System.out.println("Danh sách phiếu nhập xóa tạm thời:");
        System.out.println("+---------------------------------------------------+");
        System.out.println("|             Phiếu nhập đã xóa tạm thời            |");
        System.out.println("+---------------------------------------------------+");
        System.out.println("| Ma phieu nhap |  ID nha xuat ban  | Ngay nhap     |");
        System.out.println("+---------------------------------------------------+");
    
        boolean hasDeleted = false;
        for (int i = 0; i < soLuongPN; i++) {
            if (dsPhieuNhap[i].isDeleted()) {
                hasDeleted = true;
                PhieuNhap pn = dsPhieuNhap[i];
                String ngayNhapStr = pn.getNgayNhap().getNgay() + "/" + pn.getNgayNhap().getThang() + "/" + pn.getNgayNhap().getNam();
                System.out.printf("| %-13s | %-17s | %-13s |\n", pn.getMaPN(), pn.getMaNXB(), ngayNhapStr);
            }
        }
    
        if (!hasDeleted) {
            System.out.println("|            Không có phiếu nhập nào             |");
        }
        System.out.println("+----------------------------------------------------+");
    }
    
    

    // Ghi dữ liệu ra file
    public void ghiDuLieuRaFile(String tenFile) {
        String duongDan = "C:\\Users\\nthon\\Desktop\\New folder (6)\\Do_an_QLTV\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
            for (int i = 0; i < soLuongPN; i++) {
                PhieuNhap pn = dsPhieuNhap[i];
                writer.write(
                    "Mã phiếu nhập: " + pn.getMaPN() + ", " +
                    "Mã NXB: " + pn.getMaNXB() + ", " +
                    "Ngày nhập: " + pn.getNgayNhap().getNgay() + "/" +
                    pn.getNgayNhap().getThang() + "/" +
                    pn.getNgayNhap().getNam() + ", " +
                    "Tổng tiền: " + pn.getTongTien() + ", " +
                    "Đã xóa: " + pn.isDeleted()
                );
                writer.newLine();
            }
            System.out.println("Ghi dữ liệu thành công vào file " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
        }
    }
    
    public void docDuLieuTuFile(String tenFile) {
        String duongDan = "C:\\Users\\nthon\\Desktop\\New folder (6)\\Do_an_QLTV\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;
        soLuongPN = 0;
    
        try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Loại bỏ chú thích trước khi xử lý
                line = line.replace("Mã phiếu nhập: ", "")
                           .replace("Mã NXB: ", "")
                           .replace("Ngày nhập: ", "")
                           .replace("Tổng tiền: ", "")
                           .replace("Đã xóa: ", "");
    
                String[] parts = line.split(", ");
                if (parts.length == 5) {
                    String maPN = parts[0].trim();
                    String maNXB = parts[1].trim();
    
                    String[] ngayThangNam = parts[2].trim().split("/");
                    int ngay = Integer.parseInt(ngayThangNam[0]);
                    int thang = Integer.parseInt(ngayThangNam[1]);
                    int nam = Integer.parseInt(ngayThangNam[2]);
                    date ngayNhap = new date(ngay, thang, nam);
    
                    double tongTien = Double.parseDouble(parts[3].trim());
                    boolean isDeleted = Boolean.parseBoolean(parts[4].trim());
    
                    PhieuNhap pn = new PhieuNhap(maPN, maNXB, tongTien, ngayNhap);
                    pn.setDeleted(isDeleted);
    
                    dsPhieuNhap[soLuongPN++] = pn;
                } else {
                    System.out.println("Dòng dữ liệu không hợp lệ: " + line);
                }
            }
            System.out.println("Đọc dữ liệu thành công từ file " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng số trong dữ liệu: " + e.getMessage());
        }
    }
    

}
