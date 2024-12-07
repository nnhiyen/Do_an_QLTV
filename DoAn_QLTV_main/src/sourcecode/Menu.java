package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class Menu implements IMenu {
    DSNguoiDung dsNguoiDung = new DSNguoiDung(100);
    DSChiTietPhieuNhap dsChiTiet = new DSChiTietPhieuNhap(100);
    DsTaiLieu dsTaiLieu = new DsTaiLieu(100);
    DsTacGia dsTacGia = new DsTacGia(50);
    DsTheLoai dsTheLoai = new DsTheLoai(50);
    DsMuonTraTL dsMuonTraTL = new DsMuonTraTL(100);
    DSThongKe dsThongKe = new DSThongKe();
    DsNhaXuatBan dsNXB = new DsNhaXuatBan(50);
    DsPhieuNhap dsPhieuNhap = new DsPhieuNhap(100);  
    Scanner scanner = new Scanner(System.in);

    @Override
    public void menuMain() {
        int luaChon;
        do {
            System.out.println("+----------------------------------+");
            System.out.println("|          Hệ Thống Thư Viện       |");
            System.out.println("+----------------------------------+");
            System.out.println("|1. Quản Lý Người Dùng             |");
            System.out.println("|2. Quản Lý Tài Liệu               |");
            System.out.println("|3. Quản Lý Mượn Trả               |");
            System.out.println("|4. Quản Lý Phiếu Nhập             |");
            System.out.println("|5. Chi Tiết Phiếu Nhập            |");
            System.out.println("|6. Thống Kê                       |");
            System.out.println("|7. Nhà Xuất Bản                   |");
            System.out.println("|8. Quản Lý Tác Giả                |");
            System.out.println("|9. Quản Lý Thể Loại               |");
            System.out.println("|0. Thoát                          |");
            System.out.println("+----------------------------------+");
            System.out.print("Vui lòng nhập lựa chọn của bạn: ");
            luaChon = luaChon();
            System.out.println("===================================================");

            switch (luaChon) {
                case 1:
                    menuQLND();
                    break;
                case 2:
                    menuQLTL();
                    break;
                case 3:
                    menuQLMTTL();
                    break;
                case 4:
                    menuQLPN();
                    break;
                case 5:
                    menuCTPN();
                    break;
                case 6:
                    menuTK();
                    break;
                case 7:
                    menuNXB();
                    break;
                case 8:
                    menuTacGia();
                    break;
                case 9:
                    menuTheLoai();
                    break;
                case 0:
                    System.out.println("Đang thoát...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } while (luaChon != 0);
    }



    @Override
    public void menuQLND() {
        while (true) {
            System.out.println("=== Quản lý người dùng ===");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Ghi dữ liệu ra file");
            System.out.println("3. Đọc dữ liệu từ file");
            System.out.println("4. Hiển thị danh sách người dùng");
            System.out.println("5. Tìm kiếm người dùng");
            System.out.println("6. Sửa thông tin người dùng");
            System.out.println("7. Xóa hoặc khôi phục");
            System.out.println("8. Dữ liệu đã xóa");
            System.out.println("0. Thoát");
            System.out.print("Chọn tùy chọn: ");
            int option = luaChon();
            scanner.nextLine(); // Đọc bỏ ký tự newline

            switch (option) {
                case 1:
                    System.out.print("Nhập số lượng người dùng muốn thêm: ");
                    int soLuongThem = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < soLuongThem; i++) {
                        System.out.print("Nhập loại người dùng (1: Sinh viên, 2: Giảng viên) cho người dùng thứ " + (i + 1) + ": ");
                        int loai = scanner.nextInt();
                        scanner.nextLine();
                        if (loai == 1) {
                            SinhVien sv = new SinhVien();
                            sv.nhap();
                            dsNguoiDung.themNguoiDung(sv);
                        } else if (loai == 2) {
                            GiangVien gv = new GiangVien();
                            gv.nhap();
                            dsNguoiDung.themNguoiDung(gv);
                        } else {
                            System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                            i--;
                        }
                    }
                    break;
                case 2:
                    dsNguoiDung.ghiDuLieuRaFile("nguoidung.txt");
                    break;
                case 3:
                    dsNguoiDung.docDuLieuTuFile("nguoidung.txt");
                    break;
                case 4:
                    dsNguoiDung.hienThiDanhSach();
                    break;
                    case 5:
    String maNguoiDung = "";
    while (maNguoiDung.trim().isEmpty()) {
        System.out.print("Nhập mã người dùng cần tìm: ");
        maNguoiDung = scanner.nextLine();
        maNguoiDung = maNguoiDung.toUpperCase();
        if (maNguoiDung.trim().isEmpty()) {
            System.err.println("Mã người dùng không được bỏ trống. Vui lòng nhập lại.");
        }
    }
    dsNguoiDung.timKiemNguoiDung(maNguoiDung);
    break;
//                case 5:
//                    int loai = 0;
//                    while (loai != 1 && loai != 2) {
//                        System.out.print("Chọn loại người dùng cần tìm (1: Sinh viên, 2: Giảng viên): ");
//                        loai = Integer.parseInt(scanner.nextLine());
//                        if (loai == 1) {
//                            String msv = "";
//                            while (msv.trim().isEmpty()) {
//                                System.out.print("Nhập mã sinh viên cần tìm: ");
//                                msv = scanner.nextLine();
//                                if (msv.trim().isEmpty()) {
//                                    System.err.println("Mã sinh viên không được bỏ trống. Vui lòng nhập lại.");
//                                }
//                            }
//                            dsNguoiDung.timKiemSV(msv);
//                        } else if (loai == 2) {
//                            String mgv = "";
//                            while (mgv.trim().isEmpty()) {
//                                System.out.print("Nhập mã giảng viên cần tìm: ");
//                                mgv = scanner.nextLine();
//                                if (mgv.trim().isEmpty()) {
//                                    System.err.println("Mã giảng viên không được bỏ trống. Vui lòng nhập lại.");
//                                }
//                            }
//                            dsNguoiDung.timKiemGV(mgv);
//                        } else {
//                            System.err.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
//                        }
//                    }
//                    break;
                case 6:
                    System.out.print("Nhập mã người dùng cần sửa: "); //check
                    String maSua = scanner.nextLine();
                    maSua = maSua.toUpperCase();
                    dsNguoiDung.suaNguoiDung(maSua);
                    break;
                case 7:
                    // Tạo menu con cho Xóa tạm thời và Khôi phục
                    System.out.println("=== Chọn hành động xóa ===");
                    System.out.println("1. Xóa tạm thời");
                    System.out.println("2. Khôi phục người dùng đã xóa");
                    System.out.println("3. Quay lại");
                    System.out.print("Chọn tùy chọn: ");
                    int subOption = scanner.nextInt();
                    scanner.nextLine(); // Đọc bỏ ký tự newline

                    switch (subOption) {
                        case 1:
                            System.out.print("Nhập mã người dùng cần xóa tạm thời: ");
                            String maXoa = scanner.nextLine();
                            maXoa = maXoa.toUpperCase();
                            dsNguoiDung.xoaNguoiDung(maXoa);  // Xóa tạm thời
                            break;
                        case 2:
                            System.out.print("Nhập mã người dùng cần khôi phục: ");
                            String tenKhoiPhuc = scanner.nextLine();
                            tenKhoiPhuc= tenKhoiPhuc.toUpperCase();
                            dsNguoiDung.khoiPhucNguoiDung(tenKhoiPhuc);  // Khôi phục
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;
                case 8:
                    dsNguoiDung.hienThiDanhSachXoa();  
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    @Override
    public void menuQLTL() {
        int luaChon;
        do {
            System.out.println("=== Quản lý Tài Liệu ===");
            System.out.println("1. Thêm tài liệu");
            System.out.println("2. Ghi dữ liệu ra file");
            System.out.println("3. Đọc dữ liệu từ file");
            System.out.println("4. Hiển thị danh sách tài liệu");
            System.out.println("5. Tìm kiếm tài liệu");
            System.out.println("6. Sửa thông tin tài liệu");
            System.out.println("7. Xóa hoặc khôi phục");
            System.out.println("8. Dữ liệu đã xóa");
            System.out.println("9. Quản lý Thể Loại");
            System.out.println("10. Quản lý Tác Giả");
            System.out.println("0. Thoát");
            System.out.print("Chọn tùy chọn: ");
            luaChon = luaChon();
            scanner.nextLine(); // Consume newline
            System.out.println("===================================================");

            switch (luaChon) {
                case 1:
                    TaiLieu taiLieu = new TaiLieu();
                    taiLieu.nhap();
                    dsTaiLieu.themTL(taiLieu);
                    break;
                case 2:
                    dsTaiLieu.ghiDuLieuRaFile("tailieu.txt");
                    break;
                case 3:
                    dsTaiLieu.docDuLieuTuFile("tailieu.txt");
                    break;
                case 4:
                    dsTaiLieu.hienThiDanhSach();
                    break;
                case 5:
                    System.out.print("Nhập mã tài liệu cần tìm: ");
                    String maTLTim = scanner.nextLine();
                    maTLTim= maTLTim.toUpperCase();
                    dsTaiLieu.timKiemTL(maTLTim);
                    break;
                case 6:
                    System.out.print("Nhập mã tài liệu cần sửa: ");
                    String maTL = scanner.nextLine();
                    maTL= maTL.toUpperCase();
                    dsTaiLieu.suaTaiLieu(maTL);
                    break;
                case 7:
                    System.out.println("=== Chọn hành động xóa ===");
                    System.out.println("1. Xóa tạm thời");
                    System.out.println("2. Khôi phục tài liệu đã xóa");
                    System.out.println("3. Quay lại");
                    System.out.print("Chọn tùy chọn: ");
                    int subOption = scanner.nextInt();
                    scanner.nextLine();

                    switch (subOption) {
                        case 1:
                            System.out.print("Nhập mã tài liệu cần xóa tạm thời: ");
                            String maTLXoa = scanner.nextLine();
                            maTLXoa= maTLXoa.toUpperCase();
                            dsTaiLieu.xoaTaiLieu(maTLXoa);
                            break;
                        case 2:
                            System.out.print("Nhập mã tài liệu cần khôi phục: ");
                            String maTLKhoiPhuc = scanner.nextLine();
                            maTLKhoiPhuc= maTLKhoiPhuc.toUpperCase();
                            dsTaiLieu.khoiPhucTaiLieu(maTLKhoiPhuc);
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;
                case 8:
                    dsTaiLieu.hienThiDanhSachXoa();
                    break;
                case 9:
                    menuTheLoai(); // Quản lý Thể Loại
                    break;
                case 10:
                    menuTacGia(); // Quản lý Tác Giả
                    break;
                case 0:
                    System.out.println("Thoát...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (luaChon != 0);
    }

    
    //Menu quản lí mượn trả
    @Override
public void menuQLMTTL() {
    while (true) {
        System.out.println("=== Quản lý mượn trả tài liệu ===");
        System.out.println("1. Thêm mượn trả");
        System.out.println("2. Ghi dữ liệu ra file");
        System.out.println("3. Đọc dữ liệu từ file");
        System.out.println("4. Hiển thị danh sách mượn trả");
        System.out.println("5. Tìm kiếm mượn trả");
        System.out.println("6. Sửa thông tin mượn trả");
        System.out.println("7. Xóa hoặc khôi phục");
        System.out.println("8. Dữ liệu đã xóa");
        System.out.println("0. Thoát");
        System.out.print("Chọn tùy chọn: ");
        int option = luaChon();
        scanner.nextLine(); // Đọc bỏ ký tự newline

        switch (option) {
            case 1:
                MuonTraTL ctpn = new MuonTraTL();
                    ctpn.nhap();
                    dsMuonTraTL.themMT(ctpn);
            case 2:
                dsMuonTraTL.ghiDuLieuRaFile("muontra.txt");
                break;
            case 3:
                dsMuonTraTL.docDuLieuTuFile("muontra.txt");
                break;
            case 4:
                dsMuonTraTL.hienThiDanhSach();
                break;
            case 5:
                System.out.print("Nhập mã tài liệu cần tìm: ");
                    String maTLTim = scanner.nextLine();
                    maTLTim= maTLTim.toUpperCase();
                    dsMuonTraTL.timKiemMuonTra(maTLTim);
                    break;
            case 6:
                System.out.print("Nhập mã mượn trả cần sửa: ");
                String maSua = scanner.nextLine();
                maSua= maSua.toUpperCase();
                for (MuonTraTL mt : dsMuonTraTL.getDsMT()) {
                    if (mt.getMaTL().equals(maSua)) {
                        dsMuonTraTL.suaMuonTra(maSua);
                        return;
                    }
                }
                break;
            case 7:
                // Tạo menu con cho Xóa tạm thời và Khôi phục
                System.out.println("=== Chọn hành động xóa ===");
                System.out.println("1. Xóa tạm thời");
                System.out.println("2. Khôi phục mượn trả đã xóa");
                System.out.println("3. Quay lại");
                System.out.print("Chọn tùy chọn: ");
                int subOption = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ ký tự newline

                switch (subOption) {
                    case 1:
                        System.out.print("Nhập mã mượn trả cần xóa tạm thời: ");
                        String maXoa = scanner.nextLine();
                        maXoa= maXoa.toUpperCase();
                        dsMuonTraTL.xoaMuonTra(maXoa);
                        break;
                    case 2:
                        System.out.print("Nhập mã mượn trả cần khôi phục: ");
                        String maKhoiPhuc = scanner.nextLine();
                        maKhoiPhuc= maKhoiPhuc.toUpperCase();
                        dsMuonTraTL.khoiPhucMuonTra(maKhoiPhuc);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
                break;
            case 8:
                dsMuonTraTL.hienThiDanhSachXoa();
                break;
            case 0:
                System.out.println("Thoát chương trình.");
                return;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }
}

    // Menu quản lý phiếu nhập
   // Menu quản lý phiếu nhập
public void menuQLPN() {
    int option;
    do {
        System.out.println("=== Quản lý Phiếu Nhập ===");
        System.out.println("1. Thêm phiếu nhập");
        System.out.println("2. Ghi dữ liệu ra file");
        System.out.println("3. Đọc dữ liệu từ file");
        System.out.println("4. Hiển thị danh sách phiếu nhập");
        System.out.println("5. Tìm kiếm phiếu nhập");
        System.out.println("6. Sửa thông tin phiếu nhập");
        System.out.println("7. Xóa hoặc khôi phục");
        System.out.println("8. Dữ liệu đã xóa");
        System.out.println("0. Thoát");
        System.out.print("Chọn tùy chọn: ");
        option = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("===================================================");

        switch (option) {
            case 1:
                PhieuNhap pn = new PhieuNhap();
                pn.nhap();
                dsPhieuNhap.themPhieuNhap(pn);
                break;
            case 2:
                dsPhieuNhap.ghiDuLieuRaFile("phieunhap.txt");
                break;
            case 3:
                dsPhieuNhap.docDuLieuTuFile("phieunhap.txt");
                break;
            case 4:
                dsPhieuNhap.xemDanhSachPhieuNhap();
                break;
            case 5:
                System.out.print("Nhập mã phiếu nhập cần tìm: ");
                String maPNTim = scanner.nextLine();
                maPNTim= maPNTim.toUpperCase();
                dsPhieuNhap.timPhieuNhap(maPNTim);
                break;
            case 6:
                System.out.print("Nhập mã phiếu nhập cần sửa: ");
                String maSua = scanner.nextLine();
                maSua= maSua.toUpperCase();
                dsPhieuNhap.suaPhieuNhap(maSua);
                break;
            case 7:
                System.out.println("=== Chọn hành động xóa ===");
                System.out.println("1. Xóa tạm thời");
                System.out.println("2. Khôi phục phiếu nhập đã xóa");
                System.out.println("3. Quay lại");
                System.out.print("Chọn tùy chọn: ");
                int subOption = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (subOption) {
                    case 1 -> {
                        System.out.print("Nhập mã phiếu nhập cần xóa tạm thời: ");
                        String maXoa = scanner.nextLine();
                        maXoa= maXoa.toUpperCase();
                        dsPhieuNhap.xoaPhieuNhap(maXoa);
                }
                    case 2 -> {
                        System.out.print("Nhập mã phiếu nhập cần khôi phục: ");
                        String maKhoiPhuc = scanner.nextLine();
                        maKhoiPhuc= maKhoiPhuc.toUpperCase();
                        dsPhieuNhap.khoiPhucPhieuNhap(maKhoiPhuc);
                }
                    case 3 -> System.out.println("Quay lại menu trước.");
                    default -> System.out.println("Lựa chọn không hợp lệ.");
                }
                break;

            case 8:
                
                break;
            case 0:
                System.out.println("Thoát chương trình.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    } while (option != 0);
}


    // Menu quản lý chi tiết phiếu nhập
   public void menuCTPN() {
        int option;
        do {
            System.out.println("=== Quản lý Chi Tiết Phiếu Nhập ===");
            System.out.println("1. Thêm chi tiết phiếu nhập");
            System.out.println("2. Ghi dữ liệu ra file");
            System.out.println("3. Đọc dữ liệu từ file");
            System.out.println("4. Hiển thị danh sách chi tiết phiếu nhập");
            System.out.println("5. Tìm kiếm chi tiết phiếu nhập");
            System.out.println("6. Sửa thông tin chi tiết phiếu nhập");
            System.out.println("7. Xóa hoặc khôi phục");
            System.out.println("8. Dữ liệu đã xóa");
            System.out.println("0. Thoát");
            System.out.print("Chọn tùy chọn: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("===================================================");
    
            switch (option) {
                case 1:
                    ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
                    ctpn.nhap();
                    dsChiTiet.themChiTietPhieuNhap(ctpn);
                    break;
                case 2:
                    dsChiTiet.ghiDuLieuRaFile("chitietphieunhap.txt");
                    break;
                case 3:
                    dsChiTiet.docDuLieuTuFile("chitietphieunhap.txt");
                    break;
                case 4:
                    dsChiTiet.hienThiDanhSach();
                    break;
                case 5:
                    System.out.print("Nhập mã phiếu nhập cần tìm: ");
                    String maPNTim = scanner.nextLine();
                    maPNTim= maPNTim.toUpperCase();
                    dsChiTiet.timKiemCTPN(maPNTim);

                    break;
                case 6:
                    System.out.print("Nhập mã chi tiết phiếu nhập cần sửa: ");
                    String maSua = scanner.nextLine();
                    maSua= maSua.toUpperCase();
                    dsChiTiet.suaChiTietPhieuNhap(maSua);
                    break;
                case 7:
                    System.out.println("=== Chọn hành động xóa ===");
                    System.out.println("1. Xóa tạm thời");
                    System.out.println("2. Khôi phục chi tiết phiếu nhập đã xóa");
                    System.out.println("3. Quay lại");
                    System.out.print("Chọn tùy chọn: ");
                    int subOption = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                
                    switch (subOption) {
                        case 1:
                            System.out.print("Nhập mã chi tiết phiếu nhập cần xóa tạm thời: ");
                            String maXoa = scanner.nextLine();
                            maXoa= maXoa.toUpperCase();
                            dsChiTiet.xoaChiTietPhieuNhap(maXoa);
                            break;
                        case 2:
                            System.out.print("Nhập mã chi tiết phiếu nhập cần khôi phục: ");
                            String maKhoiPhuc = scanner.nextLine();
                            maKhoiPhuc= maKhoiPhuc.toUpperCase();
                            dsChiTiet.khoiPhucChiTietPhieuNhap(maKhoiPhuc);
                            break;
                        case 3:
                            System.out.println("Quay lại menu trước.");
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.");
                            break;
                    }
                    break;
                case 8:
                    dsChiTiet.hienThiDanhSachXoa();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (option != 0);
    }
    // Menu quản lý nhà xuất bản
    public void menuNXB() {
        int luaChon;
        do {
            System.out.println("=== Quản lý Nhà Xuất Bản ===");
            System.out.println("1. Thêm nhà xuất bản");
            System.out.println("2. Ghi dữ liệu ra file");
            System.out.println("3. Đọc dữ liệu từ file");
            System.out.println("4. Hiển thị danh sách nhà xuất bản");
            System.out.println("5. Tìm kiếm nhà xuất bản");
            System.out.println("6. Sửa thông tin nhà xuất bản");
            System.out.println("7. Xóa hoặc khôi phục");
            System.out.println("8. Dữ liệu đã xóa");
            System.out.println("0. Thoát");
            System.out.print("Chọn tùy chọn: ");
            luaChon = luaChon();
            scanner.nextLine(); // Consume newline
            System.out.println("===================================================");
    
            switch (luaChon) {
                case 1:
                    NhaXuatBan nxb = new NhaXuatBan();
                    nxb.nhap();
                    dsNXB.themNXB(nxb);
                    break;
                case 2:
                    dsNXB.ghiDuLieuRaFile("nxb.txt");
                    break;
                case 3:
                    dsNXB.docDuLieuTuFile("nxb.txt");
                    break;
                case 4:
                    dsNXB.hienThiDanhSach();
                    break;
                case 5:
                    System.out.print("Nhập mã nhà xuất bản cần tìm: ");
                    String maNXBTim = scanner.nextLine();
                    maNXBTim= maNXBTim.toUpperCase();
                    dsNXB.timkiemNXB(maNXBTim);
                    break;
                case 6:
                    System.out.print("Nhập mã nhà xuất bản cần sửa: ");
                    String maSua = scanner.nextLine();
                    maSua= maSua.toUpperCase();
                    dsNXB.suaNXB(maSua);
                    break;
                case 7:
                    System.out.println("=== Chọn hành động xóa ===");
                    System.out.println("1. Xóa tạm thời");
                    System.out.println("2. Khôi phục nhà xuất bản đã xóa");
                    System.out.println("3. Quay lại");
                    System.out.print("Chọn tùy chọn: ");
                    int subOption = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
    
                    switch (subOption) {
                        case 1:
                            System.out.print("Nhập mã nhà xuất bản cần xóa tạm thời: ");
                            String maXoa = scanner.nextLine();
                            maXoa= maXoa.toUpperCase();
                            dsNXB.xoaNXB(maXoa);
                            break;
                        case 2:
                            System.out.print("Nhập mã nhà xuất bản cần khôi phục: ");
                            String maKhoiPhuc = scanner.nextLine();
                            maKhoiPhuc= maKhoiPhuc.toUpperCase();
                            /*chưa có dsNXB.khoiPhucNXB(maKhoiPhuc);/*/
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;
                case 8:
                     /*chưa có dsNXB.hienThiDanhSach();*/
                    break;
                case 0:
                    System.out.println("Thoát...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (luaChon != 0);
    }
    
    // Menu thống kê
    public void menuTK() {
    int luaChon;
    do {
        System.out.println("+----------------------------------------------+");
        System.out.println("|                 Menu thống kê                |");
        System.out.println("+----------------------------------------------+");
        System.out.println("|1. Thống kê tổng số người dùng                |");
        System.out.println("|2. Thong ke giao dich dien ra trong 1 thang   |");
        System.out.println("|0. Thoát chương trình.                        |");
        System.out.println("+----------------------------------------------+");
        System.out.println("Mời bạn nhập lựa chọn: ");
        luaChon = scanner. nextInt();  // Hoặc dùng checkLoi.checkLuaChon() 

        System.out.println("===================================================");
        switch (luaChon) {
            case 1:
                System.out.println("Tổng số người dùng hiện có là: " + dsNguoiDung.demTongNguoiDung());
                System.out.println("Trong đó:");
                System.out.println("Tổng số sinh viên hiện có là: " + dsNguoiDung.demTongSinhVien());
                System.out.println("Tổng số giảng viên hiện có là: " + dsNguoiDung.demTongGiangVien());
                break;
           case 2:
                ThongKe tk = new ThongKe();
                tk.nhap();
                dsThongKe.xuatDSTK(tk.getD().getThang(), tk.getD().getNam());
                break;
            case 0:
                System.out.println("Thoát chương trình...");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                break;
        }
    } while (luaChon != 0);
}

    // Menu quản lý tác giả
public void menuTacGia() {
    int luaChon;
    do {
        System.out.println("=== Quản lý Tác Giả ===");
        System.out.println("1. Thêm tác giả");
        System.out.println("2. Ghi dữ liệu ra file");
        System.out.println("3. Đọc dữ liệu từ file");
        System.out.println("4. Hiển thị danh sách tác giả");
        System.out.println("5. Tìm kiếm tác giả");
        System.out.println("6. Sửa thông tin tác giả");
        System.out.println("7. Xóa hoặc khôi phục");
        System.out.println("8. Dữ liệu đã xóa");
        System.out.println("0. Thoát");
        System.out.print("Chọn tùy chọn: ");
        luaChon = luaChon();
        scanner.nextLine(); // Consume newline
        System.out.println("===================================================");

        switch (luaChon) {
            case 1:
                TacGia tacGia = new TacGia();
                tacGia.nhap();
                dsTacGia.themTG(tacGia);
                break;
            case 2:
                dsTacGia.ghiDuLieuRaFile("tacgia.txt");
                break;
            case 3:
                dsTacGia.docDuLieuTuFile("tacgia.txt");
                break;
            case 4:
                dsTacGia.hienThiDanhSach();
                break;
            case 5:
                System.out.print("Nhập mã tác giả cần tìm: ");
                String maTGTim = scanner.nextLine();
                maTGTim= maTGTim.toUpperCase();
                dsTacGia.timKiemTG(maTGTim);
                break;
            case 6:
                System.out.print("Nhập mã tác giả cần sửa: ");
                String maSua = scanner.nextLine();
                maSua= maSua.toUpperCase();
                dsTacGia.suaTacGia(maSua);
                break;
            case 7:
                System.out.println("=== Chọn hành động xóa ===");
                System.out.println("1. Xóa tạm thời");
                System.out.println("2. Khôi phục tác giả đã xóa");
                System.out.println("3. Quay lại");
                System.out.print("Chọn tùy chọn: ");
                int subOption = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (subOption) {
                    case 1:
                        System.out.print("Nhập mã tác giả cần xóa tạm thời: ");
                        String maXoa = scanner.nextLine();
                        maXoa= maXoa.toUpperCase();
                        dsTacGia.xoaTacGia(maXoa);
                        break;
                    case 2:
                        System.out.print("Nhập mã tác giả cần khôi phục: ");
                        String maKhoiPhuc = scanner.nextLine();
                        maKhoiPhuc= maKhoiPhuc.toUpperCase();
                        dsTacGia.khoiPhucTacGia(maKhoiPhuc);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
                break;
            case 8:
                dsTacGia.hienThiDanhSachXoa();
                break;
            case 0:
                System.out.println("Thoát...");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    } while (luaChon != 0);
}

    
   // Menu quản lý thể loại
public void menuTheLoai() {
    int luaChon;
    do {
        System.out.println("=== Quản lý Thể Loại ===");
        System.out.println("1. Thêm thể loại");
        System.out.println("2. Ghi dữ liệu ra file");
        System.out.println("3. Đọc dữ liệu từ file");
        System.out.println("4. Hiển thị danh sách thể loại");
        System.out.println("5. Tìm kiếm thể loại");
        System.out.println("6. Sửa thông tin thể loại");
        System.out.println("7. Xóa hoặc khôi phục");
        System.out.println("8. Dữ liệu đã xóa");
        System.out.println("0. Thoát");
        System.out.print("Chọn tùy chọn: ");
        luaChon = luaChon();
        scanner.nextLine(); // Consume newline
        System.out.println("===================================================");

        switch (luaChon) {
            case 1:
                TheLoai theLoai = new TheLoai();
                theLoai.nhap();
                dsTheLoai.themTLoai(theLoai);
                break;
            case 2:
                dsTheLoai.ghiDuLieuRaFile("theloai.txt");
                break;
            case 3:
                dsTheLoai.docDuLieuTuFile("theloai.txt");
                break;
            case 4:
                dsTheLoai.hienThiDanhSach();
                break;
            case 5:
                System.out.print("Nhập mã thể loại cần tìm: ");
                String maTLoaiTim = scanner.nextLine();
                maTLoaiTim= maTLoaiTim.toUpperCase();
                dsTheLoai.timKiemTLoai(maTLoaiTim);
                break;
            case 6:
                System.out.print("Nhập mã thể loại cần sửa: ");
                String maSua = scanner.nextLine();
                maSua= maSua.toUpperCase();
                dsTheLoai.suaTheLoai(maSua);
                break;
            case 7:
                System.out.println("=== Chọn hành động xóa ===");
                System.out.println("1. Xóa tạm thời");
                System.out.println("2. Khôi phục thể loại đã xóa");
                System.out.println("3. Quay lại");
                System.out.print("Chọn tùy chọn: ");
                int subOption = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (subOption) {
                    case 1:
                        System.out.print("Nhập mã thể loại cần xóa tạm thời: ");
                        String maXoa = scanner.nextLine();
                        maXoa= maXoa.toUpperCase();
                        dsTheLoai.xoaTheLoai(maXoa);
                        break;
                    case 2:
                        System.out.print("Nhập mã thể loại cần khôi phục: ");
                        String maKhoiPhuc = scanner.nextLine();
                        maKhoiPhuc= maKhoiPhuc.toUpperCase();
                        dsTheLoai.khoiPhucTheLoai(maKhoiPhuc);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
                break;
            case 8:
                dsTheLoai.hienThiDanhSachXoa();
                break;
            case 0:
                System.out.println("Thoát...");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    } while (luaChon != 0);
}



public int luaChon() {
    System.out.print("Chọn chức năng: ");
    while (!scanner.hasNextInt()) {
        System.out.print("Lựa chọn không hợp lệ. Vui lòng nhập số: ");
        scanner.next();
    }
    return scanner.nextInt();
}
}
