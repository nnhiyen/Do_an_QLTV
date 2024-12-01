package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DsTaiLieu {
    
    private TaiLieu[] dsTL;
    private int soluongTL;
    Scanner sc = new Scanner(System.in);
    
    public DsTaiLieu(int kichThuoc) {
        dsTL = new TaiLieu[kichThuoc];
        soluongTL = 0;
    }
    
    public boolean kiemTraTL(String maTL, String tenFile) {
        docDuLieuTuFile(tenFile); 

        for (int i = 0; i < soluongTL; i++) {
            if (dsTL[i].getMaTL().equals(maTL)) {
                return true; 
            }
        }

        return false;
    }

    public void themTL(TaiLieu tl) {
        boolean hopLe = false; 
        while (!hopLe) {
            if (kiemTraTL(tl.getMaTL(), "tailieu.txt")) {
                System.out.println("Mã tài liệu " + tl.getMaTL() + " đã tồn tại. Vui lòng nhập lại mã.");
                tl.nhap(); 
            } else {
                hopLe = true;
            }
        }

        if (soluongTL < dsTL.length) {
            dsTL[soluongTL] = tl;
            soluongTL++;
            ghiDuLieuRaFile("tailieu.txt"); // Ghi ngay vào file
            System.out.println("Thêm thành công!");
        } else {
            System.out.println("Danh sách đã đầy!");
        }
    }

   

  public void suaTaiLieu(String maTL) {
    // Đọc lại dữ liệu từ file để cập nhật danh sách tài liệu mới nhất
    docDuLieuTuFile("tailieu.txt");

    for (int i = 0; i < soluongTL; i++) {
        if (dsTL[i].getMaTL().equals(maTL)) {
            System.out.println("Thông tin tài liệu cần sửa:");
            dsTL[i].xuat();  // In ra thông tin tài liệu cần sửa

            boolean hopLe = false;
            // Nếu mã tài liệu trùng với mã trong danh sách, yêu cầu nhập lại mã
            while (!hopLe) {
                // Nhập thông tin mới
                System.out.println("Nhập lại thông tin tài liệu: ");
                dsTL[i].nhap();  // Gọi phương thức nhập để cập nhật thông tin mới

                // Lấy mã tài liệu sau khi sửa
                String maMoi = dsTL[i].getMaTL();

                // Kiểm tra trùng mã với tài liệu khác trong danh sách
                boolean maTrung = false;
                for (int j = 0; j < soluongTL; j++) {
                    if (i != j && dsTL[j].getMaTL().equals(maMoi)) {  // Không kiểm tra chính nó
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


    public void xoaTaiLieu(String ma) {
        for (int i = 0; i < soluongTL; i++) {
            if (dsTL[i].getMaTL().equals(ma)) {
                dsTL[i].setDeleted(true);
                System.out.println("Xóa tạm thời thành công.");
                ghiDuLieuRaFile("tailieu.txt"); // Cập nhật lại file
                return;
            }
        }
        System.out.println("Không tìm thấy tài liệu với mã: " + ma);
    }

    public void khoiPhucTaiLieu(String ma) {
        for (int i = 0; i < soluongTL; i++) {
            if (dsTL[i].getMaTL().equals(ma)) {
                dsTL[i].setDeleted(false);
                System.out.println("Khôi phục thành công.");
                ghiDuLieuRaFile("tailieu.txt"); // Cập nhật lại file
                return;
            }
        }
        System.out.println("Không tìm thấy tài liệu với mã: " + ma);
    }

    public void hienThiDanhSachXoa() {
        System.out.println("Danh sách tài liệu đã xóa tạm thời:");
        System.out.println("+---------------------------------------------------------+");
        System.out.println("|                 Tài Liệu Đã Xóa Tạm Thời               |");
        System.out.println("+---------------------------------------------------------+");
        System.out.println("|    Mã tài liệu    |         Tên          |    Tác Giả   |");
        System.out.println("+---------------------------------------------------------+");

        boolean hasDeleted = false;
        for (int i = 0; i < soluongTL; i++) {
            if (dsTL[i].isDeleted()) {
                hasDeleted = true;
                System.out.printf("| %-16s | %-20s | %-12s |\n",
                        dsTL[i].getMaTL(),
                        dsTL[i].getTenTL(),
                        dsTL[i].getTenTG());
            }
        }

        if (!hasDeleted) {
            System.out.println("|                  Không có tài liệu nào                 |");
        }
        System.out.println("+---------------------------------------------------------+");
    }

    public void timKiemTL(String maTL) {
        boolean found = false;

        for (int i = 0; i < soluongTL; i++) {
            if (dsTL[i].getMaTL().equals(maTL)) {
                System.out.println("+---------------------------------------------------------+");
                System.out.println("|                    Thông Tin Tài Liệu                  |");
                System.out.println("+---------------------------------------------------------+");
                System.out.println("|    Mã tài liệu    |         Tên          |    Tác Giả   |");
                System.out.println("+---------------------------------------------------------+");
                System.out.printf("| %-16s | %-20s | %-12s |\n",
                        dsTL[i].getMaTL(),
                        dsTL[i].getTenTL(),
                        dsTL[i].getTenTG());
                System.out.println("+---------------------------------------------------------+");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy tài liệu với mã: " + maTL);
        }
    }

    public void hienThiDanhSach() {
        System.out.println("Danh sách tài liệu còn lại:");
        if (soluongTL == 0) {
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                  Danh sách trống                       |");
            System.out.println("+---------------------------------------------------------+");
            return;
        }

        System.out.println("+---------------------------------------------------------+");
        System.out.println("|                    Thông Tin Tài Liệu                  |");
        System.out.println("+---------------------------------------------------------+");
        System.out.println("|    Mã tài liệu    |         Tên          |    Tác Giả   |    Nhà xuất bản   |");
        System.out.println("+---------------------------------------------------------+");

        for (int i = 0; i < soluongTL; i++) {
            if (!dsTL[i].isDeleted()) {
                System.out.printf("| %-16s | %-20s | %-12s | %-18s |\n",
                        dsTL[i].getMaTL(),
                        dsTL[i].getTenTL(),
                        dsTL[i].getTenTG(),
                        dsTL[i].getTenNXB());
            }
        }
        System.out.println("+---------------------------------------------------------+");
    }

    public void ghiDuLieuRaFile(String tenFile) {
        String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\Do_an_QLTV-main\\Do_an_QLTV-main\\src\\sourcefile\\" + tenFile;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
            for (int i = 0; i < soluongTL; i++) {
                writer.write(dsTL[i].toString()); // Gọi phương thức toString() của TaiLieu
                writer.newLine();
            }
            System.out.println("Ghi dữ liệu thành công vào file " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
        }
    }

    public void docDuLieuTuFile(String tenFile) {
        String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\Do_an_QLTV-main\\Do_an_QLTV-main\\src\\sourcefile\\" + tenFile;
        soluongTL = 0; // Đặt lại số lượng tài liệu trước khi đọc

        try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length >= 5) { // Bao gồm các trường dữ liệu và trạng thái isDeleted
                    String maTL = parts[0].split(": ")[1];
                    String tenTL = parts[1].split(": ")[1];
                    String tenTG = parts[2].split(": ")[1];
                    String tenTLoai = parts[3].split(": ")[1];
                    String tenNXB = parts[4].split(": ")[1];
                    boolean isDeleted = Boolean.parseBoolean(parts[5].split(": ")[1]);

                    // Tạo đối tượng TaiLieu
                    TaiLieu tl = new TaiLieu();
                    tl.setMaTL(maTL);
                    tl.setTenTL(tenTL);
                    tl.setTenTG(tenTG);
                    tl.setTenTLoai(tenTLoai);
                    tl.setTenNXB(tenNXB);
                    tl.setDeleted(isDeleted);

                    // Thêm vào danh sách
                    dsTL[soluongTL++] = tl;
                }
            }
            System.out.println("Đọc dữ liệu thành công từ file " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        }
    }
}

