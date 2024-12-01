package DoAn_QLTV_main.src.sourcecode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DsMuonTraTL {
    private MuonTraTL[] dsMT;
    private int soLuongMuonTra;
    
    // Đường dẫn cố định tới file
    private static final String FILE_PATH = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\DoAn_QLTV_main\\src\\sourcefile\\duLieuMuonTra.txt";

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
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
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
                    NguoiDung[] nguoiDungs = muonTraTL.timKiemNguoiDungTheoTen(tenNguoiDung, dsNguoiDung);
                    if (nguoiDungs == null || nguoiDungs.length == 0) {
                        System.out.println("Không tìm thấy người dùng với tên: " + tenNguoiDung);
                    } else if (nguoiDungs.length == 1) {
                        muonTraTL.setNguoiDung(nguoiDungs[0]);
                    } else {
                        System.out.println("Có nhiều người dùng với tên: " + tenNguoiDung);
                        System.out.print("Vui lòng nhập mã giảng viên hoặc mã sinh viên: ");
                        Scanner scanner = new Scanner(System.in);
                        String maNguoiDung = scanner.nextLine();
                        muonTraTL.setNguoiDung(muonTraTL.timKiemNguoiDungTheoMa(maNguoiDung, dsNguoiDung));
                    }
                    themMuon(muonTraTL);
                }
            }
            System.out.println("Đọc dữ liệu thành công từ file " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Không thể đọc file: " + e.getMessage());
        }
    }

    public void ghiDuLieuRaFile() {
        if (soLuongMuonTra == 0) {
            System.out.println("Không có dữ liệu để ghi.");
            return;
        }

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (int i = 0; i < soLuongMuonTra; i++) {
                MuonTraTL mt = dsMT[i];
                writer.write(mt.getMaTL() + "," + mt.getNgayMuon() + "," + mt.getNgayTra() + "," + 
                             mt.getSoLuong() + "," + mt.getTenNguoiDung() + "\n");
            }
            System.out.println("Ghi dữ liệu thành công vào file " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Không thể ghi file: " + e.getMessage());
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
                return true;
            }
        }
        return false;
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
