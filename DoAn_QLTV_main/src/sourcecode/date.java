package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class date {
    private int ngay;
    private int thang;
    private int nam;
    Scanner sc = new Scanner(System.in);

    public date() {
    }

    public date(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    public date(int thang, int nam) {
        this.thang = thang;
        this.nam = nam;
    }

    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int ktngay(int n, int m) {
        if (n < 1 || n > 31) {
            return 0;
        }
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            return n <= 30 ? 1 : 0;
        }
        if (m == 2) {
            boolean isLeapYear = (nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0);
            return n <= (isLeapYear ? 29 : 28) ? 1 : 0;
        }
        return 1;
    }

    public int ktthang(int n) {
        return (n >= 1 && n <= 12) ? 1 : 0;
    }

    public int ktnam(int n) {
        return (n >= 2000 && n <= 2100) ? 1 : 0;
    }

    public void nhap() {
        do {
            System.out.print("Nhap nam:");
            nam = checkLoi.checkSoNguyen();
            if (ktnam(nam) == 0) {
                System.out.println("Nam qua tre hoac qua som!");
            }
        } while (ktnam(nam) == 0);

        do {
            System.out.print("Nhap thang:");
            thang = checkLoi.checkSoNguyen();
            if (ktthang(thang) == 0) {
                System.out.println("Thang khong hop le!");
            }
        } while (ktthang(thang) == 0);

        do {
            System.out.print("Nhap ngay:");
            ngay = checkLoi.checkSoNguyen();
            if (ktngay(ngay, thang) == 0) {
                System.out.println("Ngay khong hop li!");
            }
        } while (ktngay(ngay, thang) == 0);
    }

    public void nhapThangNam() {
        do {
            System.out.print("Nhap nam:");
            nam = checkLoi.checkSoNguyen();
            if (ktnam(nam) == 0) {
                System.out.println("Nam qua tre hoac qua som!");
            }
        } while (ktnam(nam) == 0);

        do {
            System.out.print("Nhap thang:");
            thang = checkLoi.checkSoNguyen();
            if (ktthang(thang) == 0) {
                System.out.println("Thang khong hop le!");
            }
        } while (ktthang(thang) == 0);
    }
    
    public void parseNgay(String ngayNhapStr) {
        String[] parts = ngayNhapStr.split("/");
        this.ngay = Integer.parseInt(parts[0]);
        this.thang = Integer.parseInt(parts[1]);
        this.nam = Integer.parseInt(parts[2]);
    }

    @Override
    public String toString() {
        return "Ngay=" + ngay + ", Thang=" + thang + ", Nam=" + nam;
    }
}
