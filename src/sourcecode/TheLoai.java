package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TheLoai{
    private String tenTLoai;
    private String maTLoai;
    private String tenTL;
    private String tenTG;
    private String tenNXB;
    private boolean isDeleted;

    public TheLoai(){}

    public TheLoai(String tenTLoai, String maTLoai, String tenTL, String tenTG, String tenNXB){
    	this.tenTLoai = tenTLoai;
        this.maTLoai = maTLoai;
        this.tenTL = tenTL;
        this.tenTG = tenTG;
        this.tenNXB = tenNXB;
        this.isDeleted = false;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ten the loai: ");
        tenTLoai = checkLoi.checkChuoiRong();
        System.out.print("Nhap ma the loai: ");
        maTLoai = checkLoi.checkMaTLoai();
        System.out.printf("Nhap ten tai lieu: ");
        tenTL = checkLoi.checkChuoiRong();
        System.out.printf("Nhap ten tac gia: ");
        tenTG = checkLoi.checkChuoiRong();
        System.out.printf("Nhap ten nha xuat ban: ");
        tenNXB = checkLoi.checkChuoiRong();
    }

    @Override
    public String toString() {
    	return ", Ten the loai" + tenTLoai+
    			", Ma the loai" + maTLoai+
        		", Ten tai lieu: "+ tenTL+
        		", Ten tac gia: "+ tenTG+
        		", Ten nha xuat ban: "+ tenNXB;
    }

    public void xuat(){
    	String format = "| %-12s | %-20s | %-20s | %-20s | %-20 |\n";
        System.out.format(format, maTLoai, tenTLoai, tenTL, tenTG, tenNXB);
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
    
    public String getTenTL(){
        return tenTL;
    }
    public void setTenTL(String tenTL){
        this.tenTL = tenTL;
    }
    
    public String getTenTG(){
        return tenTG;
    }
    public void setTenTG(String tenTG){
        this.tenTG = tenTG;
    }
    
    public String getTenNXB(){
    	return tenNXB;
    }
    public void setTenNXB(String tenNXB){
    	this.tenNXB = tenNXB;
    }
    
    public boolean isDeleted() {
        return isDeleted;
    }
    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
