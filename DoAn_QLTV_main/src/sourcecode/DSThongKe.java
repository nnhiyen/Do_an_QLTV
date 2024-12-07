package DoAn_QLTV_main.src.sourcecode;


public class DSThongKe {
    // Danh sách thống kê
    private ThongKe[] arr_tk = new ThongKe[100];  // Mảng để lưu các thống kê
    private int size = 0;  // Số lượng thống kê hiện có

    public void tangSoLuongMuon(int thang, int nam, int sl) {
        for (int i = 0; i < size; i++) {
            if (arr_tk[i].getD().getThang() == thang && arr_tk[i].getD().getNam() == nam) {
                arr_tk[i].setSoLuongMuon(arr_tk[i].getSoLuongMuon() + sl);
                return;
            }
        }
        ThongKe tk = new ThongKe();
        tk.getD().setThang(thang);
        tk.getD().setNam(nam);
        tk.setSoLuongMuon(sl);
        arr_tk[size++] = tk;
    }

    public void tangSoLuongTra(int thang, int nam, int sl) {
        for (int i = 0; i < size; i++) {
            if (arr_tk[i].getD().getThang() == thang && arr_tk[i].getD().getNam() == nam) {
                arr_tk[i].setSoLuongTra(arr_tk[i].getSoLuongTra() + sl);
                return;
            }
        }
        ThongKe tk = new ThongKe();
        tk.getD().setThang(thang);
        tk.getD().setNam(nam);
        tk.setSoLuongTra(sl);
        arr_tk[size++] = tk;
    }

    public void tangSoLuongPhieuMuon(int thang, int nam) {
        for (int i = 0; i < size; i++) {
            if (arr_tk[i].getD().getThang() == thang && arr_tk[i].getD().getNam() == nam) {
                arr_tk[i].setSoLuongPhieuMuon(arr_tk[i].getSoLuongPhieuMuon() + 1);
                return;
            }
        }
        ThongKe tk = new ThongKe();
        tk.getD().setThang(thang);
        tk.getD().setNam(nam);
        tk.setSoLuongPhieuMuon(1);
        arr_tk[size++] = tk;
    }

    public void tangSoLuongPhieuTra(int thang, int nam) {
        for (int i = 0; i < size; i++) {
            if (arr_tk[i].getD().getThang() == thang && arr_tk[i].getD().getNam() == nam) {
                arr_tk[i].setSoLuongPhieuTra(arr_tk[i].getSoLuongPhieuTra() + 1);
                return;
            }
        }
        ThongKe tk = new ThongKe();
        tk.getD().setThang(thang);
        tk.getD().setNam(nam);
        tk.setSoLuongPhieuTra(1);
        arr_tk[size++] = tk;
    }

    public void xuatDSTK(int thang, int nam) {
        for (int i = 0; i < size; i++) {
            if (arr_tk[i].getD().getThang() == thang && arr_tk[i].getD().getNam() == nam) {
                String tGian_format = "| Thong ke thang %-2s-%-4s | %n";
                String muon_format = "| So luong tai lieu muon: %-3s | %n";
                String tra_format = "| So luong tai lieu tra: %-3s  | %n";
                String phieuMuon_format = "| Tong so phieu muon: %-3s | %n";
                String phieuTra_format = "| Tong so phieu tra: %-3s  | %n";

                System.out.println("+-------------------------------+");
                System.out.format(tGian_format, arr_tk[i].getD().getThang(), arr_tk[i].getD().getNam());
                System.out.println("+-------------------------------+");
                System.out.format(muon_format, arr_tk[i].getSoLuongMuon());
                System.out.format(tra_format, arr_tk[i].getSoLuongTra());
                System.out.format(phieuMuon_format, arr_tk[i].getSoLuongPhieuMuon());
                System.out.format(phieuTra_format, arr_tk[i].getSoLuongPhieuTra());
                System.out.println("+-------------------------------+");
                return;
            }
        }
        System.out.println("Khong co giao dich vao " + thang + "/" + nam);
    }
// cần file thống kê
}
