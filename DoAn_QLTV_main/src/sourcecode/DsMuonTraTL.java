package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DsMuonTraTL {
    private MuonTraTL[] dsMT;
    private int soLuongMuonTra;
    Scanner sc = new Scanner(System.in);

    public DsMuonTraTL(int kichThuoc) {
        dsMT = new MuonTraTL[kichThuoc];
        soLuongMuonTra = 0;
    }

    public MuonTraTL[] getDsMT() {
        return dsMT;
    }

    public int getSoLuongMuonTra() {
        return soLuongMuonTra;
    }

    public Scanner getSc() {
        return sc;
    }
    // thiếu hàm check
   

    public void themMT(MuonTraTL mt) {
        if (soLuongMuonTra < dsMT.length) {
            dsMT[soLuongMuonTra] = mt;
            soLuongMuonTra++;
            ghiDuLieuRaFile("muontra.txt"); // Ghi ngay vào file
            System.out.println("Thêm thành công!");
        } else {
            System.out.println("Danh sách mượn trả đã đầy!");
        }
    }

    public void setDsMT(MuonTraTL[] dsMT) {
        this.dsMT = dsMT;
    }

    public void setSoLuongMuonTra(int soLuongMuonTra) {
        this.soLuongMuonTra = soLuongMuonTra;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
    
    public void suaMuonTra(String maTL) {
    // Đọc lại dữ liệu từ file để cập nhật danh sách mượn trả mới nhất
    docDuLieuTuFile("muontra.txt");

    for (int i = 0; i < soLuongMuonTra; i++) {
        if (dsMT[i].getMaTL().equals(maTL)) {
            System.out.println("Thông tin mượn trả cần sửa:");
            dsMT[i].xuat(); // In ra thông tin mượn trả cần sửa

            boolean hopLe = false;
            // Nếu mã tài liệu trùng với mã trong danh sách, yêu cầu nhập lại mã
            while (!hopLe) {
                // Nhập thông tin mới
                System.out.println("Nhập lại thông tin tài liệu: ");
                dsMT[i].nhap();  // Gọi phương thức nhập để cập nhật thông tin mới

                // Lấy mã tài liệu sau khi sửa
                String maMoi = dsMT[i].getMaTL();

                // Kiểm tra trùng mã với tài liệu khác trong danh sách
                boolean maTrung = false;
                for (int j = 0; j < soLuongMuonTra; j++) {
                    if (i != j && dsMT[j].getMaTL().equals(maMoi)) {  // Không kiểm tra chính nó
                        maTrung = true;
                        break;
                    }
                }

                // Nếu mã trùng, yêu cầu nhập lại
                if (maTrung) {
                    System.out.println("Mã tài liệu đã tồn tại, vui lòng nhập lại.");
                } else {
                    hopLe = true;  // Mã hợp lệ, thoát khỏi vòng lặp
                }
            }

            // Cập nhật lại dữ liệu vào file sau khi sửa
            ghiDuLieuRaFile("tailieu.txt");
            System.out.println("Sửa thành công.");
            return;
        }
    }
    
    System.out.println("Không tìm thấy tài liệu với mã: " + maTL);
}


    public void xoaMuonTra(String maTL) {
        for (int i = 0; i < soLuongMuonTra; i++) {
            if (dsMT[i].getMaTL().equals(maTL)) {
                dsMT[i].setDeleted(true);
                System.out.println("Xóa tạm thời thành công.");
                ghiDuLieuRaFile("muontra.txt"); // Cập nhật lại file
                return;
            }
        }
        System.out.println("Không tìm thấy mượn trả với mã: " + maTL);
    }

    public void khoiPhucMuonTra(String maTL) {
        for (int i = 0; i < soLuongMuonTra; i++) {
            if (dsMT[i].getMaTL().equals(maTL)) {
                dsMT[i].setDeleted(false);
                System.out.println("Khôi phục thành công.");
                ghiDuLieuRaFile("muontra.txt"); // Cập nhật lại file
                return;
            }
        }
        System.out.println("Không tìm thấy mượn trả với mã: " + maTL);
    }

    public void hienThiDanhSachXoa() {
        System.out.println("Danh sách mượn trả đã xóa tạm thời:");
        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("|                           Thông Tin Mượn Trả Tài Liệu                 |");
        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("| Mã tài liệu |  Ngày Mượn  | Ngày Trả   | Số lượng |  Tên người dùng   |");

        boolean hasDeleted = false;
        for (int i = 0; i < soLuongMuonTra; i++) {
            if (dsMT[i].isDeleted()) {
                hasDeleted = true;
                System.out.printf("| %-11s | %-11s | %-10s | %-8d | %-17s |\n",
                        dsMT[i].getMaTL(),
                        dsMT[i].getNgayMuon().toFormattedString(),
                        dsMT[i].getNgayTra().toFormattedString(),
                        dsMT[i].getSoLuong(),
                        dsMT[i].getTenNguoiDung());
            }
        }

        if (!hasDeleted) {
            System.out.println("|                          Không có mượn trả nào                           |");
        }
        System.out.println("+------------------------------------------------------------------------ -----+");
    }

    public void timKiemMuonTra(String maTL) {
        boolean found = false;

        for (int i = 0; i < soLuongMuonTra; i++) {
            if (dsMT[i].getMaTL().equals(maTL)) {
                System.out.println("+-----------------------------------------------------------------------+");
                System.out.println("|                           Thông Tin Mượn Trả Tài Liệu                 |");
                System.out.println("+-----------------------------------------------------------------------+");
                System.out.println("| Mã tài liệu |  Ngày Mượn  | Ngày Trả   | Số lượng |  Tên người dùng   |");
                System.out.printf("| %-11s | %-11s | %-10s | %-8d | %-17s |\n",
                        dsMT[i].getMaTL(),
                        dsMT[i].getNgayMuon().toFormattedString(),
                        dsMT[i].getNgayTra().toFormattedString(),
                        dsMT[i].getSoLuong(),
                        dsMT[i].getTenNguoiDung());
                System.out.println("+-----------------------------------------------------------------------+");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy mượn trả với mã: " + maTL);
        }
    }

    public void hienThiDanhSach() {
        System.out.println("Danh sách mượn trả còn lại:");
        if (soLuongMuonTra == 0) {
            System.out.println("+-------------------------------------------------------------------+");
            System.out.println("|                       Danh sách trống                             |");
            System.out.println("+-------------------------------------------------------------------+");
            return;
        }

        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("|                           Thông Tin Mượn Trả Tài Liệu                 |");
        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("| Mã tài liệu |  Ngày Mượn  | Ngày Trả   | Số lượng |  Tên người dùng   |");

        for (int i = 0; i < soLuongMuonTra; i++) {
            if (!dsMT[i].isDeleted()) {
                System.out.printf("| %-11s | %-11s | %-10s | %-8d | %-17s |\n",
                        dsMT[i].getMaTL(),
                        dsMT[i].getNgayMuon().toFormattedString(),
                        dsMT[i].getNgayTra().toFormattedString(),
                        dsMT[i].getSoLuong(),
                        dsMT[i].getTenNguoiDung());
            }
        }
        System.out.println("+-----------------------------------------------------------------------+");
    }

   public void ghiDuLieuRaFile(String tenFile) {
    String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\HelloAll\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
        for (int i = 0; i < soLuongMuonTra; i++) {
            MuonTraTL mt = dsMT[i];
            writer.write(
                mt.getMaTL() + "," +
                mt.getTenNguoiDung() + "," +
                "Ngày mượn: " + formatDate(mt.getNgayMuon()) + "," +
                "Ngày trả: " + formatDate(mt.getNgayTra()) + "," +
                "Số lượng: " + mt.getSoLuong() + "," +
                mt.isDeleted()
            );
            writer.newLine();
        }
        System.out.println("Ghi dữ liệu thành công vào file " + duongDan);
    } catch (IOException e) {
        System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
    }
}

private String formatDate(date ngay) {
    return String.format("%02d/%02d/%d", ngay.getNgay(), ngay.getThang(), ngay.getNam());
}
    

   public void docDuLieuTuFile(String tenFile) {
    String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\HelloAll\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;
    soLuongMuonTra = 0; // Đặt lại số lượng mượn trả trước khi đọc

    try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 6) {
                String maTL = parts[0].trim();
                String tenNguoiDung = parts[1].trim();

                // Phân tích ngày tháng
                String ngayMuonStr = parts[2].replace("Ngày mượn: ", "").trim();
                String ngayTraStr = parts[3].replace("Ngày trả: ", "").trim();
                date ngayMuon = parseDate(ngayMuonStr);
                date ngayTra = parseDate(ngayTraStr);

                // Xử lý số lượng và trạng thái xóa
                int soLuong = Integer.parseInt(parts[4].replace("Số lượng: ", "").trim());
                boolean isDeleted = Boolean.parseBoolean(parts[5].trim());

                // Tạo đối tượng MuonTraTL
                MuonTraTL mt = new MuonTraTL(maTL, ngayMuon, ngayTra, soLuong, tenNguoiDung);
                mt.setDeleted(isDeleted);

                // Thêm vào danh sách
                dsMT[soLuongMuonTra++] = mt;
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


    
    
    
    
    

private date parseDate(String dateString) {
    try {
        String[] parts = dateString.split("/");
        if (parts.length == 3) {
            int ngay = Integer.parseInt(parts[0]);
            int thang = Integer.parseInt(parts[1]);
            int nam = Integer.parseInt(parts[2]);
            return new date(ngay, thang, nam);
        } else {
            throw new IllegalArgumentException("Ngày tháng năm không hợp lệ: " + dateString);
        }
    } catch (Exception e) {
        System.out.println("Lỗi khi phân tích ngày: " + dateString + " - " + e.getMessage());
        return null;
    }
}


}
