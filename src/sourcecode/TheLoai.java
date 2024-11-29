package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TheLoai{
    private String tenTLoai;
    private String maTLoai;
    private String maTL;
    private String tenTL;
    private String tenTG;
    private String maTG;
    private String tenNXB;
    private String maNXB;
    private DsTaiLieu dsTaiLieu;

    public TheLoai(){}

    public TheLoai(String tenTLoai, String maTLoai, String maTL, String tenTL,String maTG, String tenTG, String maNXB, String tenNXB){
    	this.tenTLoai = tenTLoai;
        this.maTLoai = maTLoai;
        this.maTL = maTL;
        this.tenTL = tenTL;
        this.maTG = maTG;
        this.tenTG = tenTG;
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ten the loai: ");
        tenTLoai = sc.nextLine();
        System.out.print("Nhap ma the loai: ");
        maTLoai = sc.nextLine();
        System.out.printf("Nhap ma tai lieu: ");
        maTL = sc.nextLine();
        System.out.printf("Nhap ten tai lieu: ");
        tenTL = sc.nextLine();
        System.out.printf("Nhap ma tac gia: ");
        maTG = sc.nextLine();
        System.out.printf("Nhap ten tac gia: ");
        tenTG = sc.nextLine();
        System.out.printf("Nhap ma nha xuat ban: ");
        maNXB = sc.nextLine();
        System.out.printf("Nhap ten nha xuat ban: ");
        tenNXB = sc.nextLine();
    }
    public boolean kiemTraThongTinHopLe() {
        return maTL != null && !maTL.isEmpty() &&
               tenTL != null && !tenTL.isEmpty() &&
               maTG != null && !maTG.isEmpty() &&
               tenTG != null && !tenTG.isEmpty() &&
               maTLoai != null && !maTLoai.isEmpty() &&	               
               tenTLoai != null && !tenTLoai.isEmpty() &&
               maNXB != null && !maNXB.isEmpty() &&
               tenNXB != null && !tenNXB.isEmpty();
    }
    @Override
    public String toString() {
    	return "Ten the loai" + tenTLoai+ "\n"+
    			"Ma the loai" + maTLoai+ "\n"+
    			"Ma tai lieu: "+ maTL+ "\n" +
        		"Ten tai lieu: "+ tenTL+ "\n"+
        		"Ma tac gia: "+ maTG+ "\n" +
        		"Ten tac gia: "+ tenTG+ "\n"+
        		"Ma nha xuat ban: "+ maNXB+ "\n"+
        		"Ten nha xuat ban: "+ tenNXB+ "\n";
    }

    public void xuat(){
        System.out.println(toString()+ "\n -----");
        System.out.println("Danh sach tai lieu thuoc the loai " + tenTLoai + ": ");
        if (dsTaiLieu.getSoLuongTaiLieu() == 0) {
            System.out.println("Tai lieu trong");
        } else {
            dsTaiLieu.xuat_ds();
        }
    }
    public void themTaiLieu(TaiLieu tl) {
        dsTaiLieu.themTL(tl);
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
    
    public String getMaTL(){
    	return maTL;
    }
    public void setMaTL(String maTL){
    	this.maTL = maTL;
    }
    public String getTenTL(){
        return tenTL;
    }
    public void setTenTL(String tenTL){
        this.tenTL = tenTL;
    }
    
    public String getMaTG(){
    	return maTG;
    }
    public void setMaTG(String maTG){
    	this.maTG = maTG;
    }
    public String getTenTG(){
        return tenTG;
    }
    public void setTenTG(String tenTG){
        this.tenTG = tenTG;
    }
    
    public String getMaNXB(){
    	return maNXB;
    }
    public void setMaNXB(String maNXB){
    	this.maNXB = maNXB;
    }
    public String getTenNXB(){
    	return tenNXB;
    }
    public void setTenNXB(String tenNXB){
    	this.tenNXB = tenNXB;
    }
    
    private boolean isDeleted;
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
