package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DsMuonTraTL {
//     private MuonTraTL[] dsMT;
//     private int soLuongMuonTra;
//     Scanner sc = new Scanner(System.in);

//     public DsMuonTraTL(int kichThuoc) {
//         dsMT = new MuonTraTL[kichThuoc];
//         soLuongMuonTra = 0;
//     }

//     public MuonTraTL[] getDsMT() {
//         return dsMT;
//     }

//     public int getSoLuongMuonTra() {
//         return soLuongMuonTra;
//     }

//     public Scanner getSc() {
//         return sc;
//     }

//     public void themMT(MuonTraTL mt) {
//         if (soLuongMuonTra < dsMT.length) {
//             dsMT[soLuongMuonTra] = mt;
//             soLuongMuonTra++;
//             ghiDuLieuRaFile("muontra.txt"); // Ghi ngay vào file
//             System.out.println("Thêm thành công!");
//         } else {
//             System.out.println("Danh sách mượn trả đã đầy!");
//         }
//     }

//     public void setDsMT(MuonTraTL[] dsMT) {
//         this.dsMT = dsMT;
//     }

//     public void setSoLuongMuonTra(int soLuongMuonTra) {
//         this.soLuongMuonTra = soLuongMuonTra;
//     }

//     public void setSc(Scanner sc) {
//         this.sc = sc;
//     }
    
    

    
//     public void suaMuonTra(String maTL, DSNguoiDung dsNguoiDung, DsTaiLieu dsTaiLieu) {
//     // Đọc lại dữ liệu từ file để cập nhật danh sách mượn trả mới nhất
//     docDuLieuTuFile("muontra.txt");

//     for (int i = 0; i < soLuongMuonTra; i++) {
//         if (dsMT[i].getMaTL().equals(maTL)) {
//             System.out.println("Thông tin mượn trả cần sửa:");
//             dsMT[i].xuat(); // In ra thông tin mượn trả cần sửa

//             // Nhập thông tin mới
//             System.out.println("Nhập lại thông tin mượn trả: ");
//             dsMT[i].nhap(dsNguoiDung, dsTaiLieu); // Gọi phương thức nhập để cập nhật thông tin mới

//             // Cập nhật lại dữ liệu vào file sau khi sửa
//             ghiDuLieuRaFile("muontra.txt");
//             System.out.println("Sửa thành công.");
//             return;
//         }
//     }

//     System.out.println("Không tìm thấy mượn trả với mã: " + maTL);
// }


//     public void xoaMuonTra(String maTL) {
//         for (int i = 0; i < soLuongMuonTra; i++) {
//             if (dsMT[i].getMaTL().equals(maTL)) {
//                 dsMT[i].setDaXoa(true);
//                 System.out.println("Xóa tạm thời thành công.");
//                 ghiDuLieuRaFile("muontra.txt"); // Cập nhật lại file
//                 return;
//             }
//         }
//         System.out.println("Không tìm thấy mượn trả với mã: " + maTL);
//     }

//     public void khoiPhucMuonTra(String maTL) {
//         for (int i = 0; i < soLuongMuonTra; i++) {
//             if (dsMT[i].getMaTL().equals(maTL)) {
//                 dsMT[i].setDaXoa(false);
//                 System.out.println("Khôi phục thành công.");
//                 ghiDuLieuRaFile("muontra.txt"); // Cập nhật lại file
//                 return;
//             }
//         }
//         System.out.println("Không tìm thấy mượn trả với mã: " + maTL);
//     }

//     public void hienThiDanhSachXoa() {
//         System.out.println("Danh sách mượn trả đã xóa tạm thời:");
//         System.out.println("+--------------------------------------------------------------------------------+");
//         System.out.println("|                    Mượn Trả Tài Liệu Đã Xóa Tạm Thời                          |");
//         System.out.println("+--------------------------------------------------------------------------------+");
//         System.out.println("|    Mã tài liệu    |         Ngày Mượn     |   Ngày Trả   | Số lượng | Tên người dùng |");

//         boolean hasDeleted = false;
//         for (int i = 0; i < soLuongMuonTra; i++) {
//             if (dsMT[i].isDaXoa()) {
//                 hasDeleted = true;
//                 System.out.printf("| %-16s | %-18s | %-12s | %-9d | %-16s |\n",
//                         dsMT[i].getMaTL(),
//                         dsMT[i].getNgayMuon(),
//                         dsMT[i].getNgayTra(),
//                         dsMT[i].getSoLuong(),
//                         dsMT[i].getTenNguoiDung());
//             }
//         }

//         if (!hasDeleted) {
//             System.out.println("|                              Không có mượn trả nào                             |");
//         }
//         System.out.println("+--------------------------------------------------------------------------------+");
//     }

//     public void timKiemMuonTra(String maTL) {
//         boolean found = false;

//         for (int i = 0; i < soLuongMuonTra; i++) {
//             if (dsMT[i].getMaTL().equals(maTL)) {
//                 System.out.println("+--------------------------------------------------------------------------------+");
//                 System.out.println("|                         Thông Tin Mượn Trả Tài Liệu                            |");
//                 System.out.println("+--------------------------------------------------------------------------------+");
//                 System.out.println("|    Mã tài liệu    |         Ngày Mượn     |   Ngày Trả   | Số lượng | Tên người dùng |");
//                 System.out.println("+--------------------------------------------------------------------------------+");
//                 System.out.printf("| %-16s | %-18s | %-12s | %-9d | %-16s |\n",
//                         dsMT[i].getMaTL(),
//                         dsMT[i].getNgayMuon(),
//                         dsMT[i].getNgayTra(),
//                         dsMT[i].getSoLuong(),
//                         dsMT[i].getTenNguoiDung());
//                 System.out.println("+--------------------------------------------------------------------------------+");
//                 found = true;
//                 break;
//             }
//         }

//         if (!found) {
//             System.out.println("Không tìm thấy mượn trả với mã: " + maTL);
//         }
//     }

//     public void hienThiDanhSach() {
//         System.out.println("Danh sách mượn trả còn lại:");
//         if (soLuongMuonTra == 0) {
//             System.out.println("+--------------------------------------------------------------------------------+");
//             System.out.println("|                              Danh sách trống                                   |");
//             System.out.println("+--------------------------------------------------------------------------------+");
//             return;
//         }

//         System.out.println("+--------------------------------------------------------------------------------+");
//         System.out.println("|                           Thông Tin Mượn Trả Tài Liệu                           |");
//         System.out.println("+--------------------------------------------------------------------------------+");
//         System.out.println("|    Mã tài liệu    |         Ngày Mượn     |   Ngày Trả   | Số lượng | Tên người dùng |");

//         for (int i = 0; i < soLuongMuonTra; i++) {
//             if (!dsMT[i].isDaXoa()) {
//                 System.out.printf("| %-16s | %-18s | %-12s | %-9d | %-16s |\n",
//                         dsMT[i].getMaTL(),
//                         dsMT[i].getNgayMuon(),
//                         dsMT[i].getNgayTra(),
//                         dsMT[i].getSoLuong(),
//                         dsMT[i].getTenNguoiDung());
//             }
//         }
//         System.out.println("+--------------------------------------------------------------------------------+");
//     }

//     public void ghiDuLieuRaFile(String tenFile) {
//         String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\sourcefile\\" + tenFile;

//         try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
//             for (int i = 0; i < soLuongMuonTra; i++) {
//                 writer.write(dsMT[i].toString()); // Gọi phương thức toString() của MuonTraTL
//                 writer.newLine();
//             }
//             System.out.println("Ghi dữ liệu thành công vào file " + duongDan);
//         } catch (IOException e) {
//             System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
//         }
//     }

//     public void docDuLieuTuFile(String tenFile) {
//         String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\sourcefile\\" + tenFile;
//         soLuongMuonTra = 0; // Đặt lại số lượng mượn trả trước khi đọc

//         try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 String[] parts = line.split(", ");
//                 if (parts.length >= 5) { // Bao gồm các trường dữ liệu và trạng thái isDeleted
//                     String maTL = parts[0].split(": ")[1];
//                     date ngayMuon = parseDate(parts[1].split(": ")[1]);
//                     date ngayTra = parseDate(parts[2].split(": ")[1]);
//                     int soLuong = Integer.parseInt(parts[3].split(": ")[1]);
//                     String tenNguoiDung = parts[4].split(": ")[1];
//                     boolean isDeleted = Boolean.parseBoolean(parts[5].split(": ")[1]);

//                     // Tạo đối tượng MuonTraTL
//                     MuonTraTL mt = new MuonTraTL(maTL, ngayMuon, ngayTra, soLuong, tenNguoiDung);
//                     mt.setDaXoa(isDeleted);

//                     // Thêm vào danh sách
//                     dsMT[soLuongMuonTra++] = mt;
//                 }
//             }
//             System.out.println("Đọc dữ liệu thành công từ file " + duongDan);
//         } catch (IOException e) {
//             System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
//         }
//     }
    
    
    
    
    
//     public boolean kiemTraNguoiDungDaMuon(String tenNguoiDung) {
//     for (int i = 0; i < soLuongMuonTra; i++) {
//         if (dsMT[i].getTenNguoiDung().equals(tenNguoiDung) && dsMT[i].getNgayTra() == null) {
//             return true; // Người dùng đã mượn tài liệu và chưa trả
//         }
//     }
//     return false; // Người dùng chưa mượn tài liệu hoặc đã trả
// }


//     private date parseDate(String dateString) {
//         String[] parts = dateString.split("-");
//                 int ngay = Integer.parseInt(parts[0]);
//         int thang = Integer.parseInt(parts[1]);
//         int nam = Integer.parseInt(parts[2]);
//         return new date(ngay, thang, nam);
//     }
}
