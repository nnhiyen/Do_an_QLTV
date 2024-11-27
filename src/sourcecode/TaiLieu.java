package DoAn_QLTV_main.src.sourcecode;

import java.utl.Scanner;

public abstract class TaiLieu{
	    private String tenTL;
	    private String tenTG;
	    private String theLoai;
		
		public TaiLieu(){}

	    public TaiLieu(String tenTL, String tenTG, String theLoai){
	        this.tenTL = tenTL;
	        this.tenTG = tenTG;
	        this.theLoai = theLoai;
	    }

	    public void nhap(){
			Scanner sc = new Scanner(System.in);
	        System.out.printf("Nhap ten tai lieu: ");
	        tenTL = sc.nextLine();
	        System.out.printf("Nhap ten tac gia: ");
	        tenTG = sc.nextLine();
	        System.out.printf("Nhap ten the loai");
	        theLoai= sc.nextLine();
	    }
	    @Override
	    public String toString(){
	        return "Ten tai lieu: " + tenTL + "\n" +
	        		"Ten tac gia: " + tenTG + "\n" +
	               "The loai: " + theLoai;
	    }

	    public void xuat(){
	    	System.out.println("Thông tin tai lieu " + toString());
	    }
	    
	    public abstract String maTL();

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

	    public String getTheLoai() {
	        return theLoai;
	    }
	    public void setTheLoai(String theLoai) {
	        this.theLoai= theLoai;
	    }
	    	    
	    private boolean isDeleted;

	    public boolean isDeleted() {
	        return isDeleted;
	    }

	    public void setDeleted(boolean deleted) {
	        isDeleted = deleted;
	    }
}
