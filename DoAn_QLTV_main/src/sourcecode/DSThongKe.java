package DoAn_QLTV_main.src.sourcecode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DSThongKe {
    private ThongKe[] arr_tk = new ThongKe[10];  // Sức chứa ban đầu là 10
    private int size = 0;  // Số lượng mục hiện tại
    DsMuonTraTL dsMTTL= new DsMuonTraTL(100);
    // Phương thức tăng số lượng mượn
    public void tangSoLuongMuon(int thang, int nam, int sl) {
        for (int i = 0; i < size; i++) {
            if (arr_tk[i].getD().getThang() == thang && arr_tk[i].getD().getNam() == nam) {
                arr_tk[i].setSoLuongMuon(arr_tk[i].getSoLuongMuon() + sl);
                return;
            }
        }
        if (size == arr_tk.length) {
            resizeArray();
        }
        ThongKe tk = new ThongKe();
        tk.getD().setThang(thang);
        tk.getD().setNam(nam);
        tk.setSoLuongMuon(sl);
        arr_tk[size++] = tk;
    }

    // Phương thức tăng số lượng trả
    public void tangSoLuongTra(int thang, int nam, int sl) {
        for (int i = 0; i < size; i++) {
            if (arr_tk[i].getD().getThang() == thang && arr_tk[i].getD().getNam() == nam) {
                arr_tk[i].setSoLuongTra(arr_tk[i].getSoLuongTra() + sl);
                return;
            }
        }
        if (size == arr_tk.length) {
            resizeArray();
        }
        ThongKe tk = new ThongKe();
        tk.getD().setThang(thang);
        tk.getD().setNam(nam);
        tk.setSoLuongTra(sl);
        arr_tk[size++] = tk;
    }

    // Phương thức thay đổi kích thước mảng khi đầy
    private void resizeArray() {
        ThongKe[] newArray = new ThongKe[arr_tk.length * 2];
        System.arraycopy(arr_tk, 0, newArray, 0, arr_tk.length);
        arr_tk = newArray;
    }

    // Phương thức đọc dữ liệu từ file muontra.txt và thực hiện thống kê
    public void thongKeMuonTra() {
    String filePath = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\HelloAll\\src\\DoAn_QLTV_main\\src\\sourcefile\\muontra.txt";
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 8) {
                String maMT = parts[0].trim();
                String maTL = parts[1].trim();
                String maNguoiDung = parts[2].trim();
                date ngayMuon = parseDate(parts[3].trim());
                date ngayTra = parseDate(parts[4].trim());
                int soLuong = Integer.parseInt(parts[5].trim());
                boolean isDaTraTL = Boolean.parseBoolean(parts[6].trim());
                boolean isDeleted = Boolean.parseBoolean(parts[7].trim());

                System.out.println("Ngày mượn: " + ngayMuon + ", Ngày trả: " + ngayTra);  // Thêm dòng kiểm tra này

                if (!isDeleted) {
                    if (!isDaTraTL) {
                        tangSoLuongMuon(ngayMuon.getThang(), ngayMuon.getNam(), soLuong);
                    } else {
                        tangSoLuongTra(ngayTra.getThang(), ngayTra.getNam(), soLuong);
                    }
                }
            }
        }
    } catch (IOException e) {
        System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
    }
}


    // Phương thức xuất thống kê
    public void xuatDSTK(int thang, int nam) {
        for (int i = 0; i < size; i++) {
            if (arr_tk[i].getD().getThang() == thang && arr_tk[i].getD().getNam() == nam) {
                String tGian_format = "| Thong ke thang %-2s-%-4s | %n";
                String muon_format = "| So luong tai lieu muon: %-3s | %n";
                String tra_format = "| So luong tai lieu tra: %-3s  | %n";
                String phieuMuon_format = "| Tong so phieu muon: %-3s | %n";
                String phieuTra_format = "| Tong so phieu tra: %-3s  | %n";
                int soLuongDaTra = dsMTTL.demSoLuongDaTra();  // Đếm số lượng tài liệu đã trả
                int soLuongChuaTra = dsMTTL.demSoLuongChuaTra();  // Đếm số lượng tài liệu chưa trả

                System.out.println("+-------------------------------+");
                System.out.format(tGian_format, arr_tk[i].getD().getThang(), arr_tk[i].getD().getNam());
                System.out.println("+-------------------------------+");
                System.out.format(muon_format, arr_tk[i].getSoLuongMuon());
                System.out.format(tra_format, arr_tk[i].getSoLuongTra());
                System.out.format(phieuMuon_format, arr_tk[i].getSoLuongPhieuMuon());
                System.out.format(phieuTra_format, arr_tk[i].getSoLuongPhieuTra());
                System.out.format("| So luong tai lieu da tra: %-3s | %n", soLuongDaTra);
                System.out.format("| So luong tai lieu chua tra: %-3s | %n", soLuongChuaTra);
                System.out.println("+-------------------------------+");
                return;
            }
        }
        System.out.println("Khong co giao dich vao " + thang + "/" + nam);
    }

    // Phương thức chuyển đổi chuỗi ngày tháng năm thành đối tượng date
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
