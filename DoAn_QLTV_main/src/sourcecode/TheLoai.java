package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class TheLoai{
    private String tenTLoai;
    private String maTLoai;
    private boolean isDeleted;

    public TheLoai(){}

    public TheLoai(String tenTLoai, String maTLoai){
    	this.tenTLoai = tenTLoai;
        this.maTLoai = maTLoai;
        this.isDeleted = false;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ten the loai: ");
        tenTLoai = checkLoi.checkChuoiRong();
        System.out.print("Nhap ma the loai: ");
        maTLoai = checkLoi.checkMaTLoai();
    }

    @Override
    public String toString() {
    	return "Ten the loai: " + tenTLoai+
    			", Ma the loai: " + maTLoai+ ", Trạng thái xóa: " + isDeleted;
    }

    public void xuat(){
    	String format = "| %-12s | %-20s |\n";
        System.out.format(format, maTLoai, tenTLoai);
    }
    
    public String getTenTLoai(){
        return tenTLoai;
    }
    public void setTenTLoai(String theLoai){
        this.tenTLoai = theLoai;
    }

    public String getMaTLoai(){
        return maTLoai;
    }
    public void setMaTLoai(String maTLoai){
        this.maTLoai = maTLoai;
    }
    
    public boolean isDeleted() {
        return isDeleted;
    }
    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
