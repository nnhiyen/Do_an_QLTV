package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

class TheLoai{
    private String tenTLoai;
    private String maTLoai;
    private DsTaiLieu dsTaiLieu;

    public TheLoai(){}

    public TheLoai(String tenTLoai, String maTLoai){
        this.tenTLoai = tenTLoai;
        this.maTLoai = maTLoai;
    }

    public void nhap(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ten theloai: ");
        tenTLoai = scanner.nextLine();

        System.out.print("Nhap ma the loai: ");
        maTLoai = scanner.nextLine();

    }
    @Override
    public String toString(){
        return "Ten the loai: " + tenTLoai + "\n" +
               "Ma the loai: " + maTLoai;
    }

    public void xuat(){
        System.out.println("Ten the loai: " + tenTLoai);
        System.out.println("Ma the loai: " + maTLoai);
        System.out.println("Danh sach tai lieu thuoc the loai " + tenTLoai + ": ");
        if (dsTaiLieu.getSoLuongTaiLieu() == 0) {
            System.out.println("Không có tài liệu nào.");
        } else {
            dsTaiLieu.xuat_ds();
        }
    }
    public void themTaiLieu(TaiLieu taiLieu) {
        dsTaiLieu.themTL(taiLieu);
    }
    public String getTenTLoai(){
        return tenTLoai;
    }
    public void setTenTLoai(String tenTLoai){
        this.tenTLoai = tenTLoai;
    }

    public String getMaTLoai(){
        return maTLoai;
    }
    public void setMaTLoai(String maTLoai){
        this.maTLoai = maTLoai;
    }
}
