package DoAn_QLTV_main.src.sourcecode;

import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
/**
 *
 * @author Luong Thanh Tuan
 */
public class DSNguoiDung {
    private NguoiDung[] dsNguoiDung;
    private int soLuong;
Scanner sc = new Scanner(System.in);
    // Constructor
    public DSNguoiDung(int kichThuoc) {
        dsNguoiDung = new NguoiDung[kichThuoc];
        soLuong = 0;
    }
    
    // kiem tra trùng
    public boolean kiemTraSV(String maSV) {
    for (int i = 0; i < soLuong; i++) {
        if (dsNguoiDung[i] instanceof SinhVien) {
            SinhVien sv = (SinhVien) dsNguoiDung[i];
            if (sv.getMaSV().equals(maSV)) {
                return true; 
            }
        }
    }
    return false;
}

// Thêm người dùng
public void themNguoiDung(NguoiDung nd) {
    if (soLuong < dsNguoiDung.length) {
        dsNguoiDung[soLuong] = nd;
        soLuong++;
    } else {
        System.out.println("Danh sách đã đầy!");
    }
}

public void themNhieuNguoiDung(int loai, int soLuongThem) {
    for (int i = 0; i < soLuongThem; i++) {
        if (loai == 1) {
            System.out.println("Thêm sinh viên thứ " + (i + 1) + ":");
            SinhVien sv = new SinhVien();
            sv.nhap();

            // Kiểm tra mã sinh viên trùng
            if (kiemTraSV(sv.getMaSV())) {
                System.out.println("Mã sinh viên " + sv.getMaSV() + " đã tồn tại. Vui lòng nhập mã khác.");
            } else {
                themNguoiDung(sv); 
            }
            
        } else if (loai == 2) {
            System.out.println("Thêm giảng viên thứ " + (i + 1) + ":");
            GiangVien gv = new GiangVien();
            gv.nhap();
            themNguoiDung(gv);
        } else {
            System.out.println("Lựa chọn không hợp lệ.");
            break;
        }
    }
}

    private boolean tonTaiNguoiDung(String ten) {
    for (int i = 0; i < soLuong; i++) {
        if (dsNguoiDung[i].getTen().equals(ten)) {
            return true;
        }
    }
    return false;
}
    // Sửa thông tin người dùng
public void suaNguoiDung(String ten) {
    if (!tonTaiNguoiDung(ten)) {
        System.out.println("Không tìm thấy người dùng.");
        return;
    }
    for (int i = 0; i < soLuong; i++) {
        if (dsNguoiDung[i].getTen().equals(ten)) {
            System.out.println("Sửa thông tin người dùng: ");
            dsNguoiDung[i].nhap(); //
            ghiDuLieuRaFile("nguoidung.txt"); 
            System.out.println("Thông tin người dùng đã được sửa và lưu vào file.");
            return;
        }
    }
}
    // SEARCH SV
    boolean found = false;
    public void timKiemSV(String maSV){
        for(int i=0; i< soLuong; i++){
            if(dsNguoiDung[i] instanceof SinhVien){
                SinhVien sv = (SinhVien) dsNguoiDung[i];
                if(sv.getMaSV().equals(maSV)){
                System.out.println("+-------------------------------------------------------+");
                System.out.println("|                       SINH VIÊN                       |");
                System.out.println("+-------------------------------------------------------+");
                System.out.println("|    Mã sinh viên    |       Tên        | Khoa |Năm Sinh|");
                System.out.println("+-------------------------------------------------------+");
                sv.xuat();
                System.out.println("+-------------------------------------------------------+");
                found = true;
                break;
                }
            }
        }
        if(!found){
            System.err.println("Không tìm thấy sinh viên có mã này");
        }
    }
    // SEARCH GV
    public void timKiemGV(String maGV){
        for(int i=0; i < soLuong; i++){
            if(dsNguoiDung[i] instanceof GiangVien){
            GiangVien gv = (GiangVien) dsNguoiDung[i];
            if(gv.getMaGV().equals(maGV)){
                System.out.println("+-------------------------------------------------------+");
                System.out.println("|                       GIANG VIÊN                       |");
                System.out.println("+-------------------------------------------------------+");
                System.out.println("|    Mã sinh viên    |       Tên        | Khoa |Năm Sinh|");
                System.out.println("+-------------------------------------------------------+");
                gv.xuat();
                System.out.println("+-------------------------------------------------------+");
                found = true;
                break;
                }
            }
        }
        if(!found){
            System.err.println("Không tìm thấy giảng viên có mã này"); 
        }  
    }
    
    public void xoaNguoiDung(String ten) {
    for (int i = 0; i < soLuong; i++) {
        if (dsNguoiDung[i].getTen().equals(ten)) {
       
            if (dsNguoiDung[i] instanceof SinhVien) {
                SinhVien sv = (SinhVien) dsNguoiDung[i];
                sv.setDeleted(true);
            } else if (dsNguoiDung[i] instanceof GiangVien) {
                GiangVien gv = (GiangVien) dsNguoiDung[i];
                gv.setDeleted(true);
            }
            System.out.println("Xóa tạm thời thành công.");
            ghiDuLieuRaFile("nguoidung.txt"); 
            return;
        }
    }
    System.out.println("Không tìm thấy người dùng.");
}

public void khoiPhucNguoiDung(String ten) {
    for (int i = 0; i < soLuong; i++) {
        if (dsNguoiDung[i].getTen().equals(ten)) {
          
            if (dsNguoiDung[i] instanceof SinhVien) {
                SinhVien sv = (SinhVien) dsNguoiDung[i];
                sv.setDeleted(false); // Khôi phục SinhVien
            } else if (dsNguoiDung[i] instanceof GiangVien) {
                GiangVien gv = (GiangVien) dsNguoiDung[i];
                gv.setDeleted(false); 
            }
            System.out.println("Khôi phục thành công.");
            ghiDuLieuRaFile("nguoidung.txt");
            return;
        }
    }
    System.out.println("Không tìm thấy người dùng.");
}




    public void hienThiDanhSachXoa() {
    System.out.println("Danh sách người dùng đã xóa tạm thời:");
    
    boolean hasDeleted = false; 
    
    for (int i = 0; i < soLuong; i++) {
        if (dsNguoiDung[i] instanceof SinhVien) {
            SinhVien sv = (SinhVien) dsNguoiDung[i];
            if (sv.isDeleted()) {
                System.out.printf("| %-12s | %-20s | %-6s | %-8d |\n", sv.getMaSV(), sv.getTen(), sv.getKhoa(), sv.getNamSinh());
                hasDeleted = true;
            }
        } else if (dsNguoiDung[i] instanceof GiangVien) {
            GiangVien gv = (GiangVien) dsNguoiDung[i];
            if (gv.isDeleted()) {
                System.out.printf("| %-12s | %-20s | %-6s | %-8d |\n", gv.getMaGV(), gv.getTen(), gv.getKhoa(), gv.getNamSinh());
                hasDeleted = true;
            }
        }
    }
    
    if (!hasDeleted) {
        System.out.println("Không có người dùng nào đã xóa tạm thời.");
    }
}






    // Hiển thị danh sách người dùng
    public void hienThiDanhSach() {
    System.out.println("Danh sách người dùng còn lại:");

    if (soLuong == 0) {
        System.out.println("Danh sách trống.");
    } else {
        boolean isSV = false;
        boolean isGV = false;

        // Kiểm tra có sinh viên hay giảng viên không
        for (int i = 0; i < soLuong; i++) {
            if (dsNguoiDung[i] instanceof SinhVien) {
                isSV = true;
            } else if (dsNguoiDung[i] instanceof GiangVien) {
                isGV = true;
            }
        }

     
        if (isSV) {
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                   Thông tin sinh viên:                  |");
            System.out.println("+---------------------------------------------------------+");
            System.out.println("| Mã sinh viên |         Tên          |  Khoa  | Năm sinh |");
            System.out.println("|--------------|----------------------|--------|----------|");
            for (int i = 0; i < soLuong; i++) {
                if (dsNguoiDung[i] instanceof SinhVien) {
                    SinhVien sv = (SinhVien) dsNguoiDung[i];
                    // Kiểm tra xem sinh viên có bị xóa tạm thời không
                    if (!sv.isDeleted()) {
                        System.out.printf("| %-12s | %-20s | %-6s | %-8d |\n", sv.getMaSV(), sv.getTen(), sv.getKhoa(), sv.getNamSinh());
                    }
                }
            }
            System.out.println("+---------------------------------------------------------+");
        }

      
        if (isGV) {
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                   Thông tin giảng viên:                  |");
            System.out.println("+---------------------------------------------------------+");
            System.out.println("| Mã giảng viên |         Tên          |  Khoa  | Năm sinh |");
            System.out.println("|---------------|----------------------|--------|----------|");
            for (int i = 0; i < soLuong; i++) {
                if (dsNguoiDung[i] instanceof GiangVien) {
                    GiangVien gv = (GiangVien) dsNguoiDung[i];
                   
                    if (!gv.isDeleted()) {
                        System.out.printf("| %-12s | %-20s | %-6s | %-8d |\n", gv.getMaGV(), gv.getTen(), gv.getKhoa(), gv.getNamSinh());
                    }
                }
            }
            System.out.println("+---------------------------------------------------------+");
        }
    }
}

    
    

    
    public void ghiDuLieuRaFile(String tenFile) {
    if (soLuong == 0) {
        System.out.println("Không có dữ liệu để ghi.");
        return;
    }

    // Đường dẫn đầy đủ tới file
    String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
        for (int i = 0; i < soLuong; i++) {
            if (!dsNguoiDung[i].isDeleted()) { 
                writer.write(dsNguoiDung[i].toString()); 
                writer.newLine();
            }
        }
        System.out.println("Ghi dữ liệu thành công vào file " + duongDan);
    } catch (IOException e) {
        System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
    }
}

public void docDuLieuTuFile(String tenFile) {
    // Đường dẫn đầy đủ tới file
    String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;

    try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", "); 
            if (parts.length >= 4) { 
                String ten = parts[0].split(": ")[1];
                String khoa = parts[1].split(": ")[1];
                int namSinh = Integer.parseInt(parts[2].split(": ")[1]); // check
                String ma = parts[3]; // Mã sinh viên hoặc giảng viên

                if (ma.startsWith("Mã sinh viên:")) {
                    SinhVien sv = new SinhVien();
                    sv.setTen(ten);
                    sv.setKhoa(khoa);
                    sv.setNamSinh(namSinh);
                    sv.setMaSV(ma.split(": ")[1]);
                    themNguoiDung(sv);
                } else if (ma.startsWith("Mã giảng viên:")) {
                    GiangVien gv = new GiangVien();
                    gv.setTen(ten);
                    gv.setKhoa(khoa);
                    gv.setNamSinh(namSinh);
                    gv.setMaGV(ma.split(": ")[1]);
                    themNguoiDung(gv);
                }
            }
        }
        System.out.println("Đọc dữ liệu thành công từ file " + duongDan);
    } catch (IOException e) {
        System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
    }
}

}

