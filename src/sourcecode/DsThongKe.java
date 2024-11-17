import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DsThongKe {
    private ThongKe[] dsTK;
    private int soLuongTK;

    public DsThongKe(int kichThuoc) {
        dsTK = new ThongKe[kichThuoc];
        soLuongTK = 0;
        try {
            docDuLieuTuFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void docDuLieuTuFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("duLieuThongKe.txt"));
        String line;
        while ((line = reader.readLine()) != null && soLuongTK < dsTK.length) {
            String[] data = line.split(",");
            if (data.length == 1) { // Assuming there's only one piece of data needed to initialize ThongKe
                ThongKe thongKe = new ThongKe(data[0]); // Adjust constructor as per actual data
                dsTK[soLuongTK] = thongKe;
                soLuongTK++;
            }
        }
        reader.close();
    }

    public void themTK(ThongKe thongKe) {
        if (soLuongTK < dsTK.length) {
            dsTK[soLuongTK] = thongKe;
            soLuongTK++;
        } else {
            System.out.println("Danh sách thống kê đã đầy.");
        }
    }

    public void suaTK(String maTK) {
        for (int i = 0; i < soLuongTK; i++) {
            if (dsTK[i].getMaTK().equals(maTK)) {
                // Cập nhật thông tin thống kê tại đây
                System.out.println("Nhập thông tin thống kê mới:");
                dsTK[i].nhap();
                System.out.println("Đã cập nhật thông tin thống kê.");
                return;
            }
        }
        System.out.println("Không tìm thấy thống kê với mã: " + maTK);
    }

    public void xoaTK(String maTK) {
        for (int i = 0; i < soLuongTK; i++) {
            if (dsTK[i].getMaTK().equals(maTK)) {
                for (int j = i; j < soLuongTK - 1; j++) {
                    dsTK[j] = dsTK[j + 1];
                }
                dsTK[soLuongTK - 1] = null;
                soLuongTK--;
                System.out.println("Đã xóa thống kê với mã: " + maTK);
                return;
            }
        }
        System.out.println("Không tìm thấy thống kê với mã: " + maTK);
    }

    public void timkiemTK(String maTK) {
        for (int i = 0; i < soLuongTK; i++) {
            if (dsTK[i].getMaTK().equals(maTK)) {
                dsTK[i].xuat();
                return;
            }
        }
        System.out.println("Không tìm thấy thống kê với mã: " + maTK);
    }

    public void xuat_ds() {
        for (int i = 0; i < soLuongTK; i++) {
            dsTK[i].xuat();
        }
    }
}
