package DoAn_QLTV_main.src.sourcecode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DsThongKe {
    private ThongKe[] dsTK;
    private int soLuongTK;
    private final int MAX_THONG_KE = 100; // Kích thước tối đa của mảng
    
    // Đường dẫn cố định tới file
    private static final String FILE_PATH = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\DoAn_QLTV_main\\src\\sourcefile\\duLieuThongKe.txt";

    public DsThongKe() {
        dsTK = new ThongKe[MAX_THONG_KE];
        soLuongTK = 0;
        try {
            docDuLieuTuFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void docDuLieuTuFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null && soLuongTK < MAX_THONG_KE) {
                try {
                    String[] data = line.split(",");
                    if (data.length == 4) {
                        int kichThuocND = Integer.parseInt(data[0]);
                        int kichThuocTL = Integer.parseInt(data[1]);
                        int kichThuocPN = Integer.parseInt(data[2]);
                        int kichThuocMuon = Integer.parseInt(data[3]);
                        ThongKe thongKe = new ThongKe(kichThuocND, kichThuocTL, kichThuocPN, kichThuocMuon);
                        dsTK[soLuongTK] = thongKe;
                        soLuongTK++;
                    } else {
                        System.err.println("Lỗi đọc dữ liệu: Dòng không đủ thông tin.");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Lỗi đọc dữ liệu: " + e.getMessage());
                }
            }
        }
        if (soLuongTK == MAX_THONG_KE) {
            System.err.println("Cảnh báo: Đã đạt đến giới hạn số lượng thống kê. Không thể đọc thêm dữ liệu.");
        }
    }

    public void ghiDuLieuVaoFile() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (int i = 0; i < soLuongTK; i++) {
                ThongKe tk = dsTK[i];
                writer.write(tk.getSoLuongND() + "," + tk.getSoLuongTL() + "," + 
                             tk.getSoLuongPN() + "," + tk.getSoLuongMuon() + "\n");
            }
            System.out.println("Ghi dữ liệu thành công vào file " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Không thể ghi file: " + e.getMessage());
        }
    }

    public void themTK(ThongKe thongKe) {
        if (soLuongTK < MAX_THONG_KE) {
            dsTK[soLuongTK] = thongKe;
            soLuongTK++;
        } else {
            System.out.println("Danh sách thống kê đã đầy.");
        }
    }

    public void suaTK(int index) {
        if (index >= 0 && index < soLuongTK) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập số lượng người dùng mới:");
            int soLuongND = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng thừa

            System.out.println("Nhập số lượng tài liệu mới:");
            int soLuongTL = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng thừa

            System.out.println("Nhập số lượng phiếu nhập mới:");
            int soLuongPN = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng thừa

            System.out.println("Nhập số lượng mượn trả mới:");
            int soLuongMuon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng thừa

            ThongKe thongKeCanSua = dsTK[index];
            thongKeCanSua.setSoLuongND(soLuongND);
            thongKeCanSua.setSoLuongTL(soLuongTL);
            thongKeCanSua.setSoLuongPN(soLuongPN);
            thongKeCanSua.setSoLuongMuon(soLuongMuon);

            System.out.println("Đã cập nhật thông tin thống kê.");
        } else {
            System.out.println("Không tìm thấy thống kê với chỉ mục: " + index);
        }
    }

    public void xoaTK(int index) {
        if (index >= 0 && index < soLuongTK) {
            dsTK[index].setDaXoa(true);
            System.out.println("Đã xóa tạm thời thống kê với chỉ mục: " + index);
        } else {
            System.out.println("Không tìm thấy thống kê với chỉ mục: " + index);
        }
    }

    public void khoiPhucTK(int index) {
        if (index >= 0 && index < soLuongTK) {
            dsTK[index].setDaXoa(false);
            System.out.println("Đã khôi phục thống kê với chỉ mục: " + index);
        } else {
            System.out.println("Không tìm thấy thống kê với chỉ mục: " + index);
        }
    }

    public void timKiemTK(int index) {
        if (index >= 0 && index < soLuongTK) {
            ThongKe tk = dsTK[index];
            System.out.println("Thông tin thống kê:");
            System.out.println("- Mã thống kê: " + (index + 1));
            System.out.println("- Số lượng người dùng: " + tk.getSoLuongND());
            System.out.println("- Số lượng tài liệu: " + tk.getSoLuongTL());
            System.out.println("- Số lượng phiếu nhập: " + tk.getSoLuongPN());
            System.out.println("- Số lượng mượn trả: " + tk.getSoLuongMuon());
        } else {
            System.out.println("Không tìm thấy thống kê với chỉ mục: " + index);
        }
    }

    public void xuatDs() {
        System.out.println("Danh sách thống kê:");
        for (int i = 0; i < soLuongTK; i++) {
            ThongKe tk = dsTK[i];
            System.out.println("Thống kê " + (i + 1) + ":");
            System.out.println("- Số lượng người dùng: " + tk.getSoLuongND());
            System.out.println("- Số lượng tài liệu: " + tk.getSoLuongTL());
            System.out.println("- Số lượng phiếu nhập: " + tk.getSoLuongPN());
            System.out.println("- Số lượng mượn trả: " + tk.getSoLuongMuon());
        }
    }

    public void hienThiDanhSachXoa() {
        System.out.println("Danh sách thống kê đã xóa tạm thời:");
        boolean hasDeleted = false;
        for (int i = 0; i < soLuongTK; i++) {
            if (dsTK[i].isDaXoa()) {
                ThongKe tk = dsTK[i];
                System.out.println("Thống kê " + (i + 1) + ":");
                System.out.println("- Số lượng người dùng: " + tk.getSoLuongND());
                System.out.println("- Số lượng tài liệu: " + tk.getSoLuongTL());
                System.out.println("- Số lượng phiếu nhập: " + tk.getSoLuongPN());
                System.out.println("- Số lượng mượn trả: " + tk.getSoLuongMuon());
                hasDeleted = true;
            }
        }
        if (!hasDeleted) {
            System.out.println("Không có mục nào đã xóa tạm thời.");
        }
    }
}
