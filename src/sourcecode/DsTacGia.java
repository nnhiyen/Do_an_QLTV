package DoAn_QLTV_main.src.sourcecode;

package eclip;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DsTacGia{
    private TacGia[] dsTG;
    private int soluongTG;

    public DsTacGia(int kichThuoc){
        dsTG = new TacGia[kichThuoc];
        soluongTG = 0;
    }
    public boolean kiemTraTG(String maTG, String tenFile) {
    	docDuLieuTuFile(tenFile); 

        for (int i = 0; i < soluongTG; i++) {
            if (dsTG[i].getMaTG().equals(maTG)) {
                return true; 
            }
        }

        return false;
    }
    
    public void themTG(TacGia tg) {
        boolean hopLe = false; 
        while (!hopLe) {
            if (kiemTraTG(tg.getMaTG(), "tacgia.txt")) {
                System.out.println("Mã tác giả " + tg.getMaTG() + " đã tồn tại. Vui lòng nhập lại mã.");
                tg.nhap(); 
            } else {
                hopLe = true;
            }
        }

        if (soluongTG < dsTG.length) {
            dsTG[soluongTG] = tg;
            soluongTG++;
            ghiDuLieuRaFile("tacgia.txt"); // Ghi ngay vào file
            System.out.println("Thêm thành công!");
        } else {
            System.out.println("Danh sách đã đầy!");
        }
    }

     public void suaTacGia(String maTG){
    	// Đọc lại dữ liệu từ file để cập nhật danh sách tài liệu mới nhất
    	    docDuLieuTuFile("tacgia.txt");

    	    for (int i = 0; i < soluongTG; i++) {
    	        if (dsTG[i].getMaTG().equals(maTG)) {
    	            System.out.println("Thông tin tác giả cần sửa:");
    	            dsTG[i].xuat();  // In ra thông tin tác giả cần sửa

    	            boolean hopLe = false;
    	            // Nếu mã thể loại trùng với mã trong danh sách, yêu cầu nhập lại mã
    	            while (!hopLe) {
    	                // Nhập thông tin mới
    	                System.out.println("Nhập lại thông tin tác giả: ");
    	                dsTG[i].nhap();  // Gọi phương thức nhập để cập nhật thông tin mới

    	                // Lấy mã thể loại sau khi sửa
    	                String maMoi = dsTG[i].getMaTG();

    	                // Kiểm tra trùng mã với thể loại khác trong danh sách
    	                boolean maTrung = false;
    	                for (int j = 0; j < soluongTG; j++) {
    	                    if (i != j && dsTG[j].getMaTG().equals(maMoi)) {  // Không kiểm tra chính nó
    	                        maTrung = true;
    	                        break;
    	                    }
    	                }

    	                // Nếu mã trùng, yêu cầu nhập lại
    	                if (maTrung) {
    	                    System.out.println("Mã tác giả đã tồn tại, vui lòng nhập lại.");
    	                } else {
    	                    hopLe = true;  // Mã hợp lệ, thoát khỏi vòng lặp
    	                }
    	            }

    	            // Cập nhật lại dữ liệu vào file sau khi sửa
    	            ghiDuLieuRaFile("tacgia.txt");
    	            System.out.println("Sửa thành công.");
    	            return;
    	        }
    	    }
    	    
    	    System.out.println("Không tìm thấy tác giả với mã: " + maTG);
    	}
  
     public void xoaTacGia(String ma) {
         for (int i = 0; i < soluongTG; i++ ) {
             if (dsTG[i].getTenTG().equals(ma)) {
            	 dsTG[i].setDeleted(true);
            	 System.out.println("xóa tạm thời thành công.");
            	 ghiDuLieuRaFile("tacgia.txt"); 
            	 return;
             }
         }
         System.out.println("Không tìm thấy tác giả với mã " + ma);
     }
     
     public void khoiPhucTacGia(String ma){
         for (int i = 0; i < soluongTG; i++) {
             if (dsTG[i].getTenTG().equals(ma)){
            	 dsTG[i].setDeleted(false);
             System.out.println("Khôi phục thành công.");
             ghiDuLieuRaFile("tacgia.txt");
             return;
             }
         }
         System.out.println("Không tìm thấy tác giả với mã " + ma);
     }
     
     public void hienThiDanhSachXoa() {
         System.out.println("Danh sách tác  giả đã xóa tạm thời:");
         System.out.println("+---------------------------------------------------------+");
         System.out.println("|                 Tác Giả Đã Xóa Tạm Thời               |");
         System.out.println("+---------------------------------------------------------+");
         System.out.println("|    Mã tác giả   |         Tên          |    Năm sinh   |");
         System.out.println("+---------------------------------------------------------+");

         boolean hasDeleted = false;
         for (int i = 0; i < soluongTG; i++) {
             if (dsTG[i].isDeleted()) {
                 hasDeleted = true;
                 System.out.printf("| %-16s | %-20s | %-12s |\n",
                         dsTG[i].getMaTG(),
                         dsTG[i].getTenTG(),
                         dsTG[i].getNamSinh());
             }
         }

         if (!hasDeleted) {
             System.out.println("|                  Không có tác giả nào                 |");
         }
         System.out.println("+---------------------------------------------------------+");
     }
     
     public void timKiemTG(String maTG) {
         boolean found = false;

         for (int i = 0; i < soluongTG; i++) {
             if (dsTG[i].getMaTG().equals(maTG)) {
                 System.out.println("+---------------------------------------------------------+");
                 System.out.println("|                    Thông Tin Tác Giả                  |");
                 System.out.println("+---------------------------------------------------------+");
                 System.out.println("|    Mã tác giả    |         Tên          |    Năm Sinh   |");
                 System.out.println("+---------------------------------------------------------+");
                 System.out.printf("| %-16s | %-20s | %-12s |\n",
                         dsTG[i].getMaTG(),
                         dsTG[i].getTenTG(),
                         dsTG[i].getNamSinh());
                 System.out.println("+---------------------------------------------------------+");
                 found = true;
                 break;
             }
         }

         if (!found) {
             System.out.println("Không tìm thấy tác giả với mã: " + maTG);
         }
     }
     
     public void hienThiDanhSach() {
         System.out.println("Danh sách tài liệu còn lại:");
         if (soluongTG == 0) {
             System.out.println("+---------------------------------------------------------+");
             System.out.println("|                  Danh sách trống                       |");
             System.out.println("+---------------------------------------------------------+");
             return;
         }

         System.out.println("+---------------------------------------------------------+");
         System.out.println("|                    Thông Tin Tác Giả                  |");
         System.out.println("+---------------------------------------------------------+");
         System.out.println("|    Mã tác giả    |         Tên          |    Năm sinh  |    Địa chỉ   |");
         System.out.println("+---------------------------------------------------------+");

         for (int i = 0; i < soluongTG; i++) {
             if (!dsTG[i].isDeleted()) {
                 System.out.printf("| %-16s | %-20s | %-12s | %-18s |\n",
                         dsTG[i].getMaTG(),
                         dsTG[i].getTenTG(),
                         dsTG[i].getNamSinh(),
                         dsTG[i].getDiaChi());
             }
         }
         System.out.println("+---------------------------------------------------------+");
     }
    
     public void ghiDuLieuRaFile(String tenFile) {
         String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\Do_an_QLTV-main\\Do_an_QLTV-main\\src\\sourcefile\\" + tenFile;

         try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
             for (int i = 0; i < soluongTG; i++) {
                 writer.write(dsTG[i].toString()); // Gọi phương thức toString() của TacGia
                 writer.newLine();
             }
             System.out.println("Ghi dữ liệu thành công vào file " + duongDan);
         } catch (IOException e) {
             System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
         }
     }

    private void docDuLieuTuFile(String tenFile){
    	String duongDan = "C:\\\\Users\\\\Admin\\\\Documents\\\\NetBeansProjects\\\\DOAN\\\\src\\\\DoAn_QLTV_main\\\\src\\\\sourcefile\\\\" + tenFile;
    	soluongTG = 0;
    	
    	try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length >= 5) { // Bao gồm các trường dữ liệu và trạng thái isDeleted
                    String maTG = parts[0].split(": ")[1];
                    String tenTG = parts[1].split(": ")[1];
                    String namSinh = parts[2].split(": ")[1];
                    String diaChi = parts[3].split(": ")[1];
                    boolean isDeleted = Boolean.parseBoolean(parts[4].split(": ")[1]);

                    // Tạo đối tượng TaiLieu
                    TacGia tg = new TacGia();
                    
                    tg.setMaTG(maTG);
                    tg.setTenTG(tenTG);
                    tg.setNamSinh(namSinh);
                    tg.setDiaChi(diaChi);
                    tg.setDeleted(isDeleted);

                    // Thêm vào danh sách
                    dsTG[soluongTG++] = tg;
                }
            }
            System.out.println("Đọc dữ liệu thành công từ file " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        }
    }
}

