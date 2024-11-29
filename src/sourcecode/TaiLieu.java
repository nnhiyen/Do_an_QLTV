package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class TaiLieu{
		private String maTL;
	    	private String tenTL;
	    	private String tenTG;
	    	private String maTG;
	    	private String tenTLoai;
	    	private String maTLoai;
	    	private String tenNXB;
	    	private String maNXB;
	
		public TaiLieu(){}

	    public TaiLieu(String maTL, String tenTL,String maTG, String tenTG,String maTLoai, String tenTLoai, String maNXB, String tenNXB){
	    	this.maTL = maTL;
	        this.tenTL = tenTL;
	        this.maTG = maTG;
	        this.tenTG = tenTG;
	        this.maTLoai = maTLoai;
	        this.tenTLoai = tenTLoai;
	        this.maNXB = maNXB;
	        this.tenNXB = tenNXB;
	    }

	    public void nhap(){
			Scanner sc = new Scanner(System.in);
			System.out.printf("Nhap ma tai lieu: ");
	        maTL = sc.nextLine();
	        System.out.printf("Nhap ten tai lieu: ");
	        tenTL = sc.nextLine();
	        System.out.printf("Nhap ma tac gia: ");
	        maTG = sc.nextLine();
	        System.out.printf("Nhap ten tac gia: ");
	        tenTG = sc.nextLine();
	        System.out.printf("Nhap ma the loai: ");
	        maTLoai = sc.nextLine();
	        System.out.printf("Nhap ten the loai: ");
	        tenTLoai= sc.nextLine();
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
	    public String toString(){
	        return 	"Ma tai lieu: "+ maTL+ "\n" +
	        		"Ten tai lieu: "+ tenTL+ "\n"+
	        		"Ma tac gia: "+ maTG+ "\n" +
	        		"Ten tac gia: "+ tenTG+ "\n"+
	        		"Ma the loai: "+ maTLoai+ "\n"+
	        		"The loai: "+ tenTLoai+ "\n"+
	        		"Ma nha xuat ban: "+ maNXB+ "\n"+
	        		"Ten nha xuat ban: "+ tenNXB+ "\n";
	    }

	    public void xuat(){
	    	System.out.println(toString()+ "\n -----------");
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

	    public String getMaTLoai(){
	    	return maTLoai;
	    }
	    public void setMaTLoai(String maTLoai){
	    	this.maTLoai = maTLoai;
	    }
	    public String getTenTLoai(){
	        return tenTLoai;
	    }
	    public void setTenTLoai(String tenTLoai){
	        this.tenTLoai= tenTLoai;
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
