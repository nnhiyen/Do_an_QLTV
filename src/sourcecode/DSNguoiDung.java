
package DoAn_QLTV_main.src.sourcecode;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DSNguoiDung {
    private NguoiDung[] dsNguoiDung;
    private int soLuong;
Scanner sc = new Scanner(System.in);
    // Constructor
    public DSNguoiDung(int kichThuoc) {
        dsNguoiDung = new NguoiDung[kichThuoc];
        soLuong = 0;
    }

    // Thêm người dùng
    public void themNguoiDung(NguoiDung nd) {
        if (soLuong  < dsNguoiDung.length) {
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
                themNguoiDung(sv);
            } else if (loai == 2) {
                System.out.println("Thêm giảng viên thứ " + (i + 1) + ":");
                GiangVien gv = new GiangVien();
                gv.nhap();
                themNguoiDung(gv);
            } else {
                System.out.println("Lựa chọn không hợp lệ.");
                break; // Nếu loại không hợp lệ, thoát vòng lặp
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
    
    
    
    //if(dsTG.tacpham().equals(tacpham)) // nếu TG trùng tên mà các tác giả đó cùng viết một tác phẩm (check)

    // Sửa thông tin người dùng
    public void suaNguoiDung(String ten) {
    if (!tonTaiNguoiDung(ten)) {
        System.out.println("Không tìm thấy người dùng.");
        return;
    }
    for (int i = 0; i < soLuong; i++) {
        if (dsNguoiDung[i].getTen().equals(ten)) {
            System.out.println("Sửa thông tin người dùng: ");
            dsNguoiDung[i].nhap();
            return;
        }
    }
}
    public void timKiem(int maSV){
        for(int i=0; i< soLuong; i++){
            System.out.println("Nhập mã sinh viên cần tìm: ");
            maSV = Integer.parseInt(sc.nextLine());
            SinhVien sv = new SinhVien();
            if(sv.getMaSinhVien().equals(maSV)){
                    sv.xuat();
                    return;
                }else{
                    System.err.println("Mã sinh viên nhập không hợp lệ hoặc không tìm thấy");
                }
        }
    }

    // Xóa người dùng
    public void xoaNguoiDung(String ten) { // nên xóa tạm thời và cần thêm một chức năng hiện thị các người dùng đã bị xóa và chức năng cập nhật lại người dùng đã bị xóa
        for (int i = 0; i < soLuong; i++) {
            if (dsNguoiDung[i].getTen().equals(ten)) {
                for (int j = i; j < soLuong - 1; j++) {
                    dsNguoiDung[j] = dsNguoiDung[j + 1];
                }
                dsNguoiDung[soLuong - 1] = null;
                soLuong--;
                System.out.println("Xóa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy người dùng.");
    }

    // Tìm kiếm người dùng
    public void timKiemNguoiDung(String ten) {
        for (int i = 0; i < soLuong; i++) {
            if (dsNguoiDung[i].getTen().equals(ten)) {
                dsNguoiDung[i].xuat();
                return;
            }
        }
        System.out.println("Không tìm thấy người dùng.");
    }

    // Hiển thị danh sách người dùng
    public void hienThiDanhSach() {
    System.out.println("Danh sách người dùng:");
    if (soLuong == 0) {
        System.out.println("Danh sách trống.");
    } else {
        for (int i = 0; i < soLuong; i++) {
            dsNguoiDung[i].xuat();
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
            writer.write(dsNguoiDung[i].toString()); // Đảm bảo phương thức toString() được định nghĩa chính xác
            writer.newLine(); // Thêm dòng mới sau mỗi người dùng
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
            String[] parts = line.split(", "); // Giả định các trường được phân tách bằng ", "
            if (parts.length >= 4) { // Kiểm tra số lượng trường
                String ten = parts[0].split(": ")[1];
                String khoa = parts[1].split(": ")[1];
                int namHoc = Integer.parseInt(parts[2].split(": ")[1]);
                String ma = parts[3]; // Mã sinh viên hoặc giảng viên

                if (ma.startsWith("Mã sinh viên:")) {
                    SinhVien sv = new SinhVien();
                    sv.setTen(ten);
                    sv.setKhoa(khoa);
                    sv.setNamHoc(namHoc);
                    sv.setMaSinhVien(ma.split(": ")[1]);
                    themNguoiDung(sv);
                } else if (ma.startsWith("Mã giảng viên:")) {
                    GiangVien gv = new GiangVien();
                    gv.setTen(ten);
                    gv.setKhoa(khoa);
                    gv.setNamHoc(namHoc);
                    gv.setMaGiangVien(ma.split(": ")[1]);
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

