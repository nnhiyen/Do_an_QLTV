package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TheLoai extends TaiLieu{
    private String theLoai;
    private String maTLoai;
    private DsTaiLieu dsTaiLieu;

    public TheLoai(){
    	super();
    }

    public TheLoai(String tenTL, String tenTG, String theLoai, String maTLoai){
        super(tenTL,tenTG, theLoai);
        this.maTLoai = maTLoai;
    }
    @Override
    public void nhap(){
        Scanner sc = new Scanner(System.in);

        super.nhap();
        
        System.out.print("Nhap ma the loai: ");
        maTLoai = sc.nextLine();

    }
    @Override
    public String maTL(){
        return maTLoai;
    }
    
    @Override
    public void xuat(){
        System.out.println("Ten the loai: " + theLoai);
        System.out.println("Ma the loai: " + maTLoai);
        System.out.println("Danh sach tai lieu thuoc the loai " + theLoai + ": ");
        if (dsTaiLieu.getSoLuongTaiLieu() == 0) {
            System.out.println("Không có tài liệu nào.");
        } else {
            dsTaiLieu.xuat_ds();
        }
    }
    public void themTaiLieu(TaiLieu taiLieu) {
        dsTaiLieu.themTL(taiLieu);
    }
    public String getTheLoai(){
        return theLoai;
    }
    public void setTheLoai(String theLoai){
        this.theLoai = theLoai;
    }

    public String getMaTLoai(){
        return maTLoai;
    }
    public void setMaTLoai(String maTLoai){
        this.maTLoai = maTLoai;
    }
}

