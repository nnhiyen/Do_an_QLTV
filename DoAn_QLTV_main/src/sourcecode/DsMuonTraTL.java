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
    DsTaiLieu dsTL = new DsTaiLieu(100);
    DSNguoiDung dsND = new DSNguoiDung(100);
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
    public boolean kiemTraMT(String maMT, String tenFile) {
        docDuLieuTuFile(tenFile); 

        for (int i = 0; i < soLuongMuonTra; i++) {
            if (dsMT[i].getMaMT().equals(maMT)) {
                return true; 
            }
        }

        return false;
    }
    
    public void themMT(MuonTraTL mttl) {
    if (kiemTraMT(mttl.getMaMT(), "muontra.txt")) {
        System.out.println("Mã mượn trả " + mttl.getMaMT() + " đã tồn tại. Vui lòng nhập lại mã.");
        mttl.nhap(); 
    }
    
    
    if (!dsTL.kiemTraMaTL(mttl.getMaTL())) {
        System.out.println("Mã tài liệu không tồn tại. Không thể thêm mượn trả.");
        return; 
    }
    
     if (!dsND.kiemTraMaND(mttl.getMaNguoiDung())) {
        System.out.println("Mã người dùng không tồn tại. Không thể thêm mượn trả.");
        return;
    }

    if (soLuongMuonTra < dsMT.length) {
        dsMT[soLuongMuonTra] = mttl;
        soLuongMuonTra++;
        ghiDuLieuRaFile("muontra.txt");  
    } else {
        System.out.println("Danh sách mượn trả đã đầy.");
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
    
    public void suaMuonTra(String maMT) {
    // Đọc lại dữ liệu từ file để cập nhật danh sách mượn trả mới nhất
    docDuLieuTuFile("muontra.txt");

    for (int i = 0; i < soLuongMuonTra; i++) {
        if (dsMT[i].getMaMT().equals(maMT)) {
            System.out.println("Thông tin mượn trả cần sửa:");
            dsMT[i].xuat(); // In ra thông tin mượn trả cần sửa

            boolean hopLe = false;
            while (!hopLe) {
                // Nhập thông tin mới
                System.out.println("Nhập lại thông tin mượn trả: ");
                dsMT[i].nhap();  

                // Lấy mã tài liệu sau khi sửa
                String maMoi = dsMT[i].getMaTL();

                // Kiểm tra trùng mã với tài liệu khác trong danh sách
                boolean maTrung = false;
                for (int j = 0; j < soLuongMuonTra; j++) {
                    if (i != j && dsMT[j].getMaMT().equals(maMoi)) {  
                        maTrung = true;
                        break;
                    }
                }

                // Nếu mã trùng, yêu cầu nhập lại
                if (maTrung) {
                    System.out.println("Mã mượn trả đã tồn tại, vui lòng nhập lại.");
                } else {
                    hopLe = true;  // Mã hợp lệ, thoát khỏi vòng lặp
                }
            }

            // Cập nhật lại dữ liệu vào file sau khi sửa
            ghiDuLieuRaFile("muontra.txt");
            System.out.println("Sửa thành công.");
            return;
        }
    }
    
    System.out.println("Không tìm thấy mượn trả với mã: " + maMT);
}
    public void TraSach(String maMT) {
    // Đọc lại danh sách mượn trả từ file để đảm bảo dữ liệu mới nhất
    docDuLieuTuFile("muontra.txt");

    // Duyệt qua danh sách để tìm mã mượn trả
    for (int i = 0; i < soLuongMuonTra; i++) {
        if (dsMT[i].getMaMT().equals(maMT)) { // Nếu tìm thấy mã mượn trả
            if (dsMT[i].isDeleted()) {
                System.out.println("Bản ghi đã bị xóa tạm thời, không thể cập nhật.");
                return;
            }
            if (dsMT[i].isDaTraTL()) {
                System.out.println("Tài liệu này đã được trả trước đó.");
                return;
            } else {
                // Cập nhật trạng thái trả
                dsMT[i].setDaTraTL(true);
                System.out.println("Cập nhật trạng thái: Đã trả tài liệu.");
                System.out.println("Thông tin sau cập nhật: " + dsMT[i]);

                // Ghi lại vào file sau khi thay đổi
                ghiDuLieuRaFile("muontra.txt");
                return;
            }
        }
    }
    System.out.println("Không tìm thấy mượn trả với mã: " + maMT);
}







    public void xoaMuonTra(String maMT) {
        for (int i = 0; i < soLuongMuonTra; i++) {
            if (dsMT[i].getMaMT().equals(maMT)) {
                dsMT[i].setDeleted(true);
                System.out.println("Xóa tạm thời thành công.");
                ghiDuLieuRaFile("muontra.txt"); // Cập nhật lại file
                return;
            }
        }
        System.out.println("Không tìm thấy mượn trả với mã: " + maMT);
    }

    public void khoiPhucMuonTra(String maMT) {
        for (int i = 0; i < soLuongMuonTra; i++) {
            if (dsMT[i].getMaMT().equals(maMT)) {
                dsMT[i].setDeleted(false);
                System.out.println("Khôi phục thành công.");
                ghiDuLieuRaFile("muontra.txt"); // Cập nhật lại file
                return;
            }
        }
        System.out.println("Không tìm thấy mượn trả với mã: " + maMT);
    }

    public void hienThiDanhSachXoa() {
    System.out.println("Danh sách mượn trả đã xóa tạm thời:");
    System.out.println("+-----------------------------------------------------------------------------------------------------+");
    System.out.println("| Mã mượn trả |  Mã tài liệu  | Ngày Mượn   | Ngày Trả   | Số lượng     | Đã trả tài liệu |");
    System.out.println("+-----------------------------------------------------------------------------------------------------+");

    boolean hasDeleted = false;
    for (int i = 0; i < soLuongMuonTra; i++) {
        if (dsMT[i].isDeleted()) {
            hasDeleted = true;
            System.out.printf("| %-11s | %-12s | %-11s | %-10s | %-12d | %-15s |\n",
                    dsMT[i].getMaMT(),
                    dsMT[i].getMaTL(),
                    dsMT[i].getNgayMuon().toFormattedString(),
                    dsMT[i].getNgayTra().toFormattedString(),
                    dsMT[i].getSoLuong(),
                    dsMT[i].isDaTraTL() ? "Đã trả" : "Chưa trả");
        }
    }

    if (!hasDeleted) {
        System.out.println("|                                   Không có mượn trả nào                                             |");
    }
    System.out.println("+-----------------------------------------------------------------------------------------------------+");
}



   public void timKiemMuonTra(String maMT) {
    boolean found = false;

    for (int i = 0; i < soLuongMuonTra; i++) {
        if (dsMT[i].getMaMT().equals(maMT) && !dsMT[i].isDeleted()) { // Kiểm tra xem mục có bị xóa hay không
            System.out.println("+-----------------------------------------------------------------------------------------------------+");
            System.out.println("| Mã mượn trả |  Mã tài liệu  | Ngày Mượn   | Ngày Trả   | Số lượng     | Đã trả tài liệu | Mã người dùng  |");
            System.out.println("+-----------------------------------------------------------------------------------------------------+");
            System.out.printf("| %-11s | %-12s | %-11s | %-10s | %-12d | %-15s | %-15s |\n",
                    dsMT[i].getMaMT(),
                    dsMT[i].getMaTL(),
                    dsMT[i].getNgayMuon().toFormattedString(),
                    dsMT[i].getNgayTra().toFormattedString(),
                    dsMT[i].getSoLuong(),
                    dsMT[i].isDaTraTL() ? "Đã trả" : "Chưa trả",
                    dsMT[i].getMaNguoiDung()); // Hiển thị mã người dùng
            System.out.println("+-----------------------------------------------------------------------------------------------------+");
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Không tìm thấy mượn trả với mã: " + maMT);
    }
}




    public void hienThiDanhSach() {
    System.out.println("Danh sách mượn trả còn lại:");
    if (soLuongMuonTra == 0) {
        System.out.println("+-----------------------------------------------------------------------------------------------------+");
        System.out.println("|                                       Danh sách trống                                               |");
        System.out.println("+-----------------------------------------------------------------------------------------------------+");
        return;
    }

    System.out.println("+---------------------------------------------------------------------------------------------------------+");
    System.out.println("| Mã mượn trả |  Mã tài liệu  | Ngày Mượn   | Ngày Trả   | Số lượng     | Đã trả tài liệu | Mã người dùng |");
    System.out.println("+---------------------------------------------------------------------------------------------------------+");

    for (int i = 0; i < soLuongMuonTra; i++) {
        if (!dsMT[i].isDeleted()) { // Chỉ hiển thị các bản ghi chưa bị xóa
            System.out.printf("| %-11s | %-13s | %-11s | %-10s | %-12d | %-15s | %-13s |\n",
                    dsMT[i].getMaMT(),
                    dsMT[i].getMaTL(),
                    dsMT[i].getNgayMuon().toFormattedString(),
                    dsMT[i].getNgayTra().toFormattedString(),
                    dsMT[i].getSoLuong(),
                    dsMT[i].isDaTraTL() ? "Đã trả" : "Chưa trả",
                    dsMT[i].getMaNguoiDung()); // Hiển thị mã người dùng
        }
    }
    System.out.println("+---------------------------------------------------------------------------------------------------------+");
}



    
    
    // BACKUP
//    public void hienThiDanhSach() {
//    System.out.println("Danh sách mượn trả:");
//    if (soLuongMuonTra == 0) {
//        System.out.println("+-------------------------------------------------------------------+");
//        System.out.println("|                       Danh sách trống                             |");
//        System.out.println("+-------------------------------------------------------------------+");
//        return;
//    }
//
//    System.out.println("+-------------------------------------------------------------------------------------------------------+");
//    System.out.println("| Mã Mượn Trả | Mã Tài Liệu | Mã Người Dùng |  Ngày Mượn  |  Ngày Trả   | Số Lượng | Trạng Thái  | Xóa  |");
//    System.out.println("+-------------------------------------------------------------------------------------------------------+");
//
//    for (int i = 0; i < soLuongMuonTra; i++) {
//        MuonTraTL mt = dsMT[i];
//        System.out.printf("| %-12s | %-12s | %-14s | %-11s | %-11s | %-9d | %-11s | %-5s |\n",
//                mt.getMaMT(),
//                mt.getMaTL(),
//                mt.getMaNguoiDung(),
//                mt.getNgayMuon().toFormattedString(),
//                mt.getNgayTra().toFormattedString(),
//                mt.getSoLuong(),
//                mt.isDaTraTL() ? "Đã trả" : "Chưa trả",
//                mt.isDeleted() ? "Đã xóa" : "Còn");
//    }
//    System.out.println("+-------------------------------------------------------------------------------------------------------+");
//}


   public void ghiDuLieuRaFile(String tenFile) {
    String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\HelloAll\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
        for (int i = 0; i < soLuongMuonTra; i++) {
            MuonTraTL mt = dsMT[i];
            writer.write(
                mt.getMaMT() + "," +
                mt.getMaTL() + "," +
                mt.getMaNguoiDung() + "," +
                formatDate(mt.getNgayMuon()) + "," +
                formatDate(mt.getNgayTra()) + "," +
                mt.getSoLuong() + "," +
                mt.isDaTraTL() + "," +
                mt.isDeleted());
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
    soLuongMuonTra = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
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

                MuonTraTL mt = new MuonTraTL(maMT, maTL, ngayMuon, ngayTra, soLuong, maNguoiDung);
                mt.setDaTraTL(isDaTraTL);
                mt.setDeleted(isDeleted);

                dsMT[soLuongMuonTra++] = mt;
            } else {
                System.out.println("Dòng dữ liệu không hợp lệ: " + line);
            }
        }
        System.out.println("Đọc dữ liệu thành công từ file " + duongDan);
    } catch (IOException e) {
        System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
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
public int demSoLuongDaTra() {
    int count = 0;
    for (int i = 0; i < soLuongMuonTra; i++) {
        if (dsMT[i].isDaTraTL()) {  // Nếu đã trả tài liệu
            count++;
        }
    }
    return count;
}

public int demSoLuongChuaTra() {
    int count = 0;
    for (int i = 0; i < soLuongMuonTra; i++) {
        if (!dsMT[i].isDaTraTL()) {  // Nếu chưa trả tài liệu
            count++;
        }
    }
    return count;
}


}
