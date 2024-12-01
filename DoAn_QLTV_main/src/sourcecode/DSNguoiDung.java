/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
    // Cần 2 đối só là mã SV cùng với tên File để đọc
    // Trước khi kiểm tra phải đọc File lấy data sau đó có thể dùng Foreach hoặc For normal
    public boolean kiemTraSV(String maSV, String tenFile) {
    docDuLieuTuFile(tenFile); 

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
    public boolean kiemTraGV(String maGV, String tenFile){
        docDuLieuTuFile(tenFile);
        for(NguoiDung nd : dsNguoiDung){
            if(nd instanceof GiangVien){
                GiangVien gv = (GiangVien) nd;
                if(gv.getMaGV().equals(maGV)) {
                    return true;
                }
            }
        }
        return false;
    }

// Khi thêm thì có thể set đối số ban đầu để khỏi dùng một mảng
// Do trả về đúng sai (kiemTraSV,GV) nên là dùng While để duyệt mà dùng While thì phải có biến để set khi nào dừng LOOP
public void themNguoiDung(NguoiDung nd) {
    boolean hopLe = false; 

    if (nd instanceof SinhVien) {
        SinhVien sv = (SinhVien) nd;
        while (!hopLe) {
            if (kiemTraSV(sv.getMaSV(), "nguoidung.txt")) {
                System.out.println("Mã sinh viên " + sv.getMaSV() + " đã tồn tại. Vui lòng nhập lại mã.");
                sv.nhap(); 
            } else {
                hopLe = true; // Do hàm if nếu như trùng thì hopLe = False, mà False While vẫn chạy thì ĐK ở trên.
            }
        }
    } else if (nd instanceof GiangVien) {
        GiangVien gv = (GiangVien) nd;
        while (!hopLe) {
            if (kiemTraGV(gv.getMaGV(), "nguoidung.txt")) {
                System.out.println("Mã giảng viên " + gv.getMaGV() + " đã tồn tại. Vui lòng nhập lại mã.");
                gv.nhap(); 
            } else {
                hopLe = true; 
            }
        }
    }

    // Thêm người dùng vào danh sách
    if (soLuong < dsNguoiDung.length) {
        dsNguoiDung[soLuong] = nd;
        soLuong++;
        ghiDuLieuRaFile("nguoidung.txt"); // Ghi ngay vào file
        System.out.println("Thêm thành công!");
    } else {
        System.out.println("Danh sách đã đầy!");
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
public void suaNguoiDung(String ma) {
    // Đọc dữ liệu từ file để cập nhật trạng thái mới nhất của danh sách người dùng
    docDuLieuTuFile("nguoidung.txt");

    // Kiểm tra nếu mã người dùng đã tồn tại trong danh sách
    for (int i = 0; i < soLuong; i++) {
        if ((dsNguoiDung[i] instanceof SinhVien && ((SinhVien) dsNguoiDung[i]).getMaSV().equals(ma)) ||
            (dsNguoiDung[i] instanceof GiangVien && ((GiangVien) dsNguoiDung[i]).getMaGV().equals(ma))) {
            
            System.out.println("Thông tin người dùng cần sửa:");
            dsNguoiDung[i].xuat();  // In ra thông tin người dùng cần sửa

            boolean hopLe = false;
            // Nếu mã người dùng trùng với mã trong danh sách, yêu cầu nhập lại mã
            while (!hopLe) {
                // Nhập thông tin mới
                System.out.println("Nhập thông tin mới cho người dùng:");
                dsNguoiDung[i].nhap();  // Gọi phương thức nhập để cập nhật thông tin mới

                // Kiểm tra lại mã người dùng sau khi sửa
                String maMoi = (dsNguoiDung[i] instanceof SinhVien) ?
                                ((SinhVien) dsNguoiDung[i]).getMaSV() : ((GiangVien) dsNguoiDung[i]).getMaGV();
                
                // Kiểm tra trùng mã với người dùng khác trong danh sách
                boolean maTrung = false;
                for (int j = 0; j < soLuong; j++) {
                    if (i != j && // Không kiểm tra chính nó
                        ((dsNguoiDung[j] instanceof SinhVien && ((SinhVien) dsNguoiDung[j]).getMaSV().equals(maMoi)) ||
                         (dsNguoiDung[j] instanceof GiangVien && ((GiangVien) dsNguoiDung[j]).getMaGV().equals(maMoi)))) {
                        maTrung = true;
                        break;
                    }
                }

                // Nếu mã trùng, yêu cầu nhập lại
                if (maTrung) {
                    System.out.println("Mã người dùng đã tồn tại, vui lòng nhập lại.");
                } else {
                    hopLe = true;  // Mã hợp lệ, thoát khỏi vòng lặp
                }
            }
            
            // Cập nhật lại dữ liệu vào file sau khi sửa
            ghiDuLieuRaFile("nguoidung.txt");
            System.out.println("Thông tin người dùng đã được sửa và lưu vào file.");
            return;
        }
    }
    
    System.out.println("Không tìm thấy người dùng với mã: " + ma);
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
    
    public void xoaNguoiDung(String ma) {
    for (int i = 0; i < soLuong; i++) {
        if ((dsNguoiDung[i] instanceof SinhVien && ((SinhVien) dsNguoiDung[i]).getMaSV().equals(ma)) ||
            (dsNguoiDung[i] instanceof GiangVien && ((GiangVien) dsNguoiDung[i]).getMaGV().equals(ma))) {
            
            dsNguoiDung[i].setDeleted(true); // Đánh dấu là đã xóa
            System.out.println("Xóa tạm thời thành công.");
            ghiDuLieuRaFile("nguoidung.txt"); // Cập nhật lại file
            return;
        }
    }
    System.out.println("Không tìm thấy người dùng với mã: " + ma);
}


public void khoiPhucNguoiDung(String ma) {
    for (int i = 0; i < soLuong; i++) {
        if ((dsNguoiDung[i] instanceof SinhVien && ((SinhVien) dsNguoiDung[i]).getMaSV().equals(ma)) ||
            (dsNguoiDung[i] instanceof GiangVien && ((GiangVien) dsNguoiDung[i]).getMaGV().equals(ma))) {
            
            dsNguoiDung[i].setDeleted(false); // Khôi phục trạng thái
            System.out.println("Khôi phục thành công.");
            ghiDuLieuRaFile("nguoidung.txt"); // Cập nhật lại file
            return;
        }
    }
    System.out.println("Không tìm thấy người dùng với mã: " + ma);
}





    public void hienThiDanhSachXoa() {
    System.out.println("Danh sách người dùng đã xóa tạm thời:");
    System.out.printf("| %-12s | %-20s | %-6s | %-8s |\n", "Mã", "Tên", "Khoa", "Năm sinh");
    System.out.println("---------------------------------------------------------------");
    boolean hasDeleted = false;

    for (int i = 0; i < soLuong; i++) {
        if (dsNguoiDung[i].isDeleted()) {
            hasDeleted = true;
            if (dsNguoiDung[i] instanceof SinhVien) {
                SinhVien sv = (SinhVien) dsNguoiDung[i];
                System.out.printf("| %-12s | %-20s | %-6s | %-8d |\n", sv.getMaSV(), sv.getTen(), sv.getKhoa(), sv.getNamSinh());
            } else if (dsNguoiDung[i] instanceof GiangVien) {
                GiangVien gv = (GiangVien) dsNguoiDung[i];
                System.out.printf("| %-12s | %-20s | %-6s | %-8d |\n", gv.getMaGV(), gv.getTen(), gv.getKhoa(), gv.getNamSinh());
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
    String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\HelloAll\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
        for (int i = 0; i < soLuong; i++) {
            writer.write(dsNguoiDung[i].toString());
            writer.newLine();
        }
        System.out.println("Ghi dữ liệu thành công vào file " + duongDan);
    } catch (IOException e) {
        System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
    }
}


public void docDuLieuTuFile(String tenFile) {
    String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\HelloAll\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;
    soLuong = 0; // Đặt lại số lượng người dùng trước khi đọc

    try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");
            if (parts.length >= 5) { // Đọc cả trạng thái isDeleted
                String ten = parts[0].split(": ")[1];
                String khoa = parts[1].split(": ")[1];
                int namSinh = Integer.parseInt(parts[2].split(": ")[1]);
                String ma = parts[3].split(": ")[1];
                boolean isDeleted = Boolean.parseBoolean(parts[4].split(": ")[1]);

                if (ma.startsWith("SV")) {
                    SinhVien sv = new SinhVien();
                    sv.setTen(ten);
                    sv.setKhoa(khoa);
                    sv.setNamSinh(namSinh);
                    sv.setMaSV(ma);
                    sv.setDeleted(isDeleted);
                    dsNguoiDung[soLuong++] = sv;
                } else if (ma.startsWith("GV")) {
                    GiangVien gv = new GiangVien();
                    gv.setTen(ten);
                    gv.setKhoa(khoa);
                    gv.setNamSinh(namSinh);
                    gv.setMaGV(ma);
                    gv.setDeleted(isDeleted);
                    dsNguoiDung[soLuong++] = gv;
                }
            }
        }
        System.out.println("Đọc dữ liệu thành công từ file " + duongDan);
    } catch (IOException e) {
        System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
    }
}

// Phương thức đếm tổng số người dùng
public int demTongNguoiDung() {
    return soLuong; // Số lượng người dùng hiện tại
}

// Phương thức đếm tổng số sinh viên
public int demTongSinhVien() {
    int dem = 0;
    for (int i = 0; i < soLuong; i++) {
        if (dsNguoiDung[i] instanceof SinhVien) {
            dem++;
        }
    }
    return dem;
}

// Phương thức đếm tổng số giảng viên
public int demTongGiangVien() {
    int dem = 0;
    for (int i = 0; i < soLuong; i++) {
        if (dsNguoiDung[i] instanceof GiangVien) {
            dem++;
        }
    }
    return dem;
}


}

