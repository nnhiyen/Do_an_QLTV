package DoAn_QLTV_main.src.sourcecode;

package eclip;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

		public class DsTheLoai{
		    private TheLoai[] dsTLoai;
		    private int soluongTLoai;
		
		public DsTheLoai(int kichThuoc){
		        dsTLoai = new TheLoai[kichThuoc];
		        soluongTLoai = 0;
		    }
		public boolean kiemTraTLoai(String ma, String tenFile) {
	    	docDuLieuTuFile(tenFile); 

	        for (int i = 0; i < soluongTLoai; i++) {
	            if (dsTLoai[i].getMaTLoai().equals(ma)) {
	                return true; 
	            }
	        }

	        return false;
	    }
		public void themTLoai(TheLoai tl) {
	        boolean hopLe = false; 
	        while (!hopLe) {
	            if (kiemTraTLoai(tl.getMaTLoai(), "theloai.txt")) {
	                System.out.println("Mã thể loại " + tl.getMaTLoai() + " đã tồn tại. Vui lòng nhập lại mã.");
	                tl.nhap(); 
	            } else {
	                hopLe = true;
	            }
	        }

	        if (soluongTLoai < dsTLoai.length) {
	            dsTLoai[soluongTLoai] = tl;
	            soluongTLoai++;
	            ghiDuLieuRaFile("theloai.txt"); // Ghi ngay vào file
	            System.out.println("Thêm thành công!");
	        } else {
	            System.out.println("Danh sách đã đầy!");
	        }
	    }

		public void suaTheLoai(String ma){
	    	// Đọc lại dữ liệu từ file để cập nhật danh sách tài liệu mới nhất
	    	    docDuLieuTuFile("theloai.txt");

	    	    for (int i = 0; i < soluongTLoai; i++) {
	    	        if (dsTLoai[i].getMaTLoai().equals(ma)) {
	    	            System.out.println("Thông tin thể loại cần sửa:");
	    	            dsTLoai[i].xuat();  // In ra thông tin thể loại cần sửa

	    	            boolean hopLe = false;
	    	            // Nếu mã thể loại trùng với mã trong danh sách, yêu cầu nhập lại mã
	    	            while (!hopLe) {
	    	                // Nhập thông tin mới
	    	                System.out.println("Nhập lại thông tin thể loại: ");
	    	                dsTLoai[i].nhap();  // Gọi phương thức nhập để cập nhật thông tin mới

	    	                // Lấy mã thể loại sau khi sửa
	    	                String maMoi = dsTLoai[i].getMaTLoai();

	    	                // Kiểm tra trùng mã với thể loại trong danh sách
	    	                boolean maTrung = false;
	    	                for (int j = 0; j < soluongTLoai; j++) {
	    	                    if (i != j && dsTLoai[j].getMaTLoai().equals(maMoi)) {  // Không kiểm tra chính nó
	    	                        maTrung = true;
	    	                        break;
	    	                    }
	    	                }

	    	                // Nếu mã trùng, yêu cầu nhập lại
	    	                if (maTrung) {
	    	                    System.out.println("Mã thể loại đã tồn tại, vui lòng nhập lại.");
	    	                } else {
	    	                    hopLe = true;  // Mã hợp lệ, thoát khỏi vòng lặp
	    	                }
	    	            }

	    	            // Cập nhật lại dữ liệu vào file sau khi sửa
	    	            ghiDuLieuRaFile("theloai.txt");
	    	            System.out.println("Sửa thành công.");
	    	            return;
	    	        }
	    	    }
	    	    
	    	    System.out.println("Không tìm thấy thể loại với mã: " + ma);
	    	}

     public void xoaTheLoai(String ma) {
         for (int i = 0; i < soluongTLoai; i++ ) {
             if (dsTLoai[i].getTenTLoai().equals(ma)) {
            	 dsTLoai[i].setDeleted(true);
            	 System.out.println("Xóa tạm thời thành công.");
            	 ghiDuLieuRaFile("theloai.txt"); 
            	 return;
             }
         }
         System.out.println("Không tìm thấy thể loại với mã "+ ma);
     }
     
     public void khoiPhucTheLoai(String ma){
         for (int i = 0; i < soluongTLoai; i++) {
             if (dsTLoai[i].getTenTLoai().equals(ma)){
            	 dsTLoai[i].setDeleted(false);
	             System.out.println("Khôi phục thành công.");
	             ghiDuLieuRaFile("theloai.txt");
	             return;
             }
         }
         System.out.println("Không tìm thấy thể loại với mã "+ ma);
     }
     
     public void hienThiDanhSachXoa() {
         System.out.println("Danh sách thể loại đã xóa tạm thời:");
         System.out.println("+---------------------------------------------------------+");
         System.out.println("|                 Thể Loại Đã Xóa Tạm Thời               |");
         System.out.println("+---------------------------------------------------------+");
         System.out.println("|    Mã thể loại    |         Tên          |    Tài liệu   |");
         System.out.println("+---------------------------------------------------------+");

         boolean hasDeleted = false;
         for (int i = 0; i < soluongTLoai; i++) {
             if (dsTLoai[i].isDeleted()) {
                 hasDeleted = true;
                 System.out.printf("| %-16s | %-20s | %-12s |\n",
                         dsTLoai[i].getMaTLoai(),
                         dsTLoai[i].getTenTLoai(),
                         dsTLoai[i].getTenTL());
             }
         }

         if (!hasDeleted) {
             System.out.println("|                  Không có thể loại nào                 |");
         }
         System.out.println("+---------------------------------------------------------+");
     }
     public void timKiemTLoai(String ma) {
         boolean found = false;

         for (int i = 0; i < soluongTLoai; i++) {
             if (dsTLoai[i].getMaTLoai().equals(ma)) {
                 System.out.println("+---------------------------------------------------------+");
                 System.out.println("|                    Thông Tin Thể loại                  |");
                 System.out.println("+---------------------------------------------------------+");
                 System.out.println("|    Mã thể loại    |         Tên          |    Tài liệu   |");
                 System.out.println("+---------------------------------------------------------+");
                 System.out.printf("| %-16s | %-20s | %-12s |\n",
                         dsTLoai[i].getMaTLoai(),
                         dsTLoai[i].getTenTLoai(),
                         dsTLoai[i].getTenTL());
                 System.out.println("+---------------------------------------------------------+");
                 found = true;
                 break;
             }
         }

         if (!found) {
             System.out.println("Không tìm thấy thể loại với mã: " + ma);
         }
     }
     
     public void hienThiDanhSach() {
         System.out.println("Danh sách tài liệu còn lại:");
         if (soluongTLoai == 0) {
             System.out.println("+---------------------------------------------------------+");
             System.out.println("|                  Danh sách trống                       |");
             System.out.println("+---------------------------------------------------------+");
             return;
         }

         System.out.println("+---------------------------------------------------------+");
         System.out.println("|                    Thông Tin Thể Loại                 |");
         System.out.println("+---------------------------------------------------------+");
         System.out.println("|    Mã Thể Loại    |         Tên          |    Tác Giả   |    Tài Liệu   |");
         System.out.println("+---------------------------------------------------------+");

         for (int i = 0; i < soluongTLoai; i++) {
             if (!dsTLoai[i].isDeleted()) {
                 System.out.printf("| %-16s | %-20s | %-12s | %-18s |\n",
                         dsTLoai[i].getMaTLoai(),
                         dsTLoai[i].getTenTLoai(),
                         dsTLoai[i].getTenTG(),
                         dsTLoai[i].getTenTL());
             }
         }
         System.out.println("+---------------------------------------------------------+");
     }
    
     public void ghiDuLieuRaFile(String tenFile) {
         String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\Do_an_QLTV-main\\Do_an_QLTV-main\\src\\sourcefile\\" + tenFile;

         try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
             for (int i = 0; i < soluongTLoai; i++) {
                 writer.write(dsTLoai[i].toString()); // Gọi phương thức toString() của TaiLieu
                 writer.newLine();
             }
             System.out.println("Ghi dữ liệu thành công vào file " + duongDan);
         } catch (IOException e) {
             System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
         }
     }

    private void docDuLieuTuFile(String tenFile){
    	String duongDan = "C:\\\\Users\\\\Admin\\\\Documents\\\\NetBeansProjects\\\\DOAN\\\\src\\\\DoAn_QLTV_main\\\\src\\\\sourcefile\\\\" + tenFile;
        soluongTLoai = 0;
    	
        try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length >= 4) { // Bao gồm các trường dữ liệu và trạng thái isDeleted
                    String maTLoai = parts[0].split(": ")[1];
                    String tenTLoai = parts[1].split(": ")[1];
                    String tenTG = parts[2].split(": ")[1];
                    String tenTL = parts[3].split(": ")[1];
                    boolean isDeleted = Boolean.parseBoolean(parts[4].split(": ")[1]);

                    // Tạo đối tượng TaiLieu
                    TheLoai tl = new TheLoai();
                    tl.setMaTLoai(maTLoai);
                    tl.setTenTLoai(tenTLoai);
                    tl.setTenTG(tenTG);
                    tl.setTenTL(tenTL);
                    tl.setDeleted(isDeleted);

                    // Thêm vào danh sách
                    dsTLoai[soluongTLoai++] = tl;
                }
            }
            System.out.println("Đọc dữ liệu thành công từ file " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        }
    }
}
