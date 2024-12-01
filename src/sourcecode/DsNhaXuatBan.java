package DoAn_QLTV_main.src.sourcecode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class DsNhaXuatBan {
    private NhaXuatBan[] dsNXB;
    private int soLuong;

    // Constructor
    public DsNhaXuatBan(int kichThuoc) {
        dsNXB = new NhaXuatBan[kichThuoc];
        soLuong = 0;
    }

    // Kiểm tra sự tồn tại của nhà xuất bản dựa trên mã NXB
    private boolean tontaiNXB(String maNXB) {
        for (int i = 0; i < soLuong; i++) {
            if (dsNXB[i].getMaNXB().equals(maNXB)) {
                return true;
            }
        }
        return false;
    }

    // Thêm nhà xuất bản
    public void themNXB(NhaXuatBan nxb) {
        boolean hopLe = false;
        while (!hopLe) {
            if (tontaiNXB(nxb.getMaNXB())) {
                System.out.println("Mã nhà xuất bản " + nxb.getMaNXB() + " đã tồn tại. Vui lòng nhập lại mã.");
                nxb.nhap();  // Yêu cầu nhập lại thông tin
            } else {
                hopLe = true;  // Mã hợp lệ, tiếp tục thêm
            }
        }

        if (soLuong < dsNXB.length) {
            dsNXB[soLuong] = nxb;
            soLuong++;
            ghiDuLieuRaFile("nxb.txt");  // Ghi ngay vào file sau khi thêm
            System.out.println("Thêm nhà xuất bản thành công!");
        } else {
            System.out.println("Danh sách nhà xuất bản đã đầy!");
        }
    }

    // Thêm nhiều nhà xuất bản
    public void themNNXB(int soLuongThem) {
        for (int i = 0; i < soLuongThem; i++) {
            System.out.println("Thêm nhà xuất bản thứ " + (i + 1) + ":");
            NhaXuatBan nxb = new NhaXuatBan();
            nxb.nhap();
            themNXB(nxb);  // Gọi phương thức themNXB để thêm từng NXB
        }
    }

    // Sửa thông tin nhà xuất bản
    public void suaNXB(String maNXB) {
        // Đọc lại dữ liệu từ file để cập nhật danh sách nhà xuất bản mới nhất
        docDuLieuTuFile("nxb.txt");

        for (int i = 0; i < soLuong; i++) {
            if (dsNXB[i].getMaNXB().equals(maNXB)) {
                System.out.println("Thông tin nhà xuất bản cần sửa:");
                dsNXB[i].xuat();  // In ra thông tin nhà xuất bản cần sửa

                boolean hopLe = false;
                while (!hopLe) {
                    System.out.println("Nhập lại thông tin nhà xuất bản: ");
                    dsNXB[i].nhap();  // Gọi phương thức nhập để cập nhật thông tin mới

                    // Lấy mã nhà xuất bản sau khi sửa
                    String maMoi = dsNXB[i].getMaNXB();

                    // Kiểm tra trùng mã với nhà xuất bản khác trong danh sách
                    boolean maTrung = false;
                    for (int j = 0; j < soLuong; j++) {
                        if (i != j && dsNXB[j].getMaNXB().equals(maMoi)) {
                            maTrung = true;
                            break;
                        }
                    }

                    // Nếu mã trùng, yêu cầu nhập lại
                    if (maTrung) {
                        System.out.println("Mã nhà xuất bản đã tồn tại, vui lòng nhập lại.");
                    } else {
                        hopLe = true;  // Mã hợp lệ, thoát khỏi vòng lặp
                    }
                }

                // Cập nhật lại dữ liệu vào file sau khi sửa
                ghiDuLieuRaFile("nxb.txt");
                System.out.println("Sửa thành công.");
                return;
            }
        }

        System.out.println("Không tìm thấy nhà xuất bản với mã: " + maNXB);
    }

    // Xóa nhà xuất bản
    public void xoaNXB(String maNXB) {
        for (int i = 0; i < soLuong; i++) {
            if (dsNXB[i].getMaNXB().equals(maNXB)) {
                for (int j = i; j < soLuong - 1; j++) {
                    dsNXB[j] = dsNXB[j + 1];  // Dịch chuyển các phần tử còn lại lên
                }
                dsNXB[soLuong - 1] = null;
                soLuong--;
                ghiDuLieuRaFile("nxb.txt");  // Cập nhật lại file
                System.out.println("Xóa nhà xuất bản thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy nhà xuất bản.");
    }

    // Tìm kiếm nhà xuất bản theo mã
    public void timkiemNXB(String maNXB) {
        boolean found = false;

        for (int i = 0; i < soLuong; i++) {
            if (dsNXB[i].getMaNXB().equals(maNXB)) {
                System.out.println("+---------------------------------------------------------+");
                System.out.println("|                 Thông Tin Nhà Xuất Bản                  |");
                System.out.println("+---------------------------------------------------------+");
                System.out.println("|  Mã NXB  |        Tên Nhà Xuất Bản            | Địa Chỉ |");
                System.out.println("+---------------------------------------------------------+");
                System.out.printf("| %-12s | %-40s | %-30s |\n",
                        dsNXB[i].getMaNXB(),
                        dsNXB[i].getTenNXB(),
                        dsNXB[i].getDiaChi());
                System.out.println("+---------------------------------------------------------+");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy nhà xuất bản với mã: " + maNXB);
        }
    }

    // Hiển thị danh sách nhà xuất bản
    public void hienThiDanhSach() {
        System.out.println("Danh sách nhà xuất bản:");
        if (soLuong == 0) {
            System.out.println("Danh sách trống.");
        } else {
            for (int i = 0; i < soLuong; i++) {
                dsNXB[i].xuat();
            }
        }
    }

    // Ghi dữ liệu ra file
    public void ghiDuLieuRaFile(String tenFile) {
        String duongDan = "C:\\Users\\nthon\\Documents\\NetBeansProjects\\DoAn_QLTV\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
            for (int i = 0; i < soLuong; i++) {
                writer.write(dsNXB[i].toString());  // Gọi phương thức toString() của NhaXuatBan
                writer.newLine();
            }
            System.out.println("Ghi dữ liệu thành công vào file " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
        }
    }

    // Đọc dữ liệu từ file
    public void docDuLieuTuFile(String tenFile) {
        String duongDan = "C:\\Users\\nthon\\Documents\\NetBeansProjects\\DoAn_QLTV\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;
        soLuong = 0;  // Đặt lại số lượng nhà xuất bản trước khi đọc

        try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length >= 3) {
                    String maNXB = parts[0].split(": ")[1];
                    String tenNXB = parts[1].split(": ")[1];
                    String diaChi = parts[2].split(": ")[1];

                    NhaXuatBan nxb = new NhaXuatBan(maNXB, tenNXB, diaChi);
                    dsNXB[soLuong++] = nxb;  // Thêm vào danh sách
                }
            }
            System.out.println("Đọc dữ liệu thành công từ file " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        }
    }
}
