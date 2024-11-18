package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class TaiLieu{
	    private String maTL;
	    private String tenTL;
	    private String theLoai;
		private String maTG;
		private String tenTG;
		private String tenNXB;

		public TaiLieu(){}

	    public TaiLieu(String maTL, String tenTL, String theLoai, String maTG, String tenTG, String tenNXB){
	        this.maTL = maTL;
	        this.tenTL = tenTL;
	        this.theLoai = theLoai;
			this.maTG = maTG;
			this.tenTG = tenTG;
			this.tenNXB = tenNXB;
	    }

	    public void nhap(){
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Nhap ma tai lieu: ");
	        maTL = scanner.nextLine();
	        System.out.print("Nhap ten tai lieu: ");
	        tenTL = scanner.nextLine();
	        System.out.print("Nhap the loai: ");
	        theLoai = scanner.nextLine();
			System.out.print("Nhap ma tac gia: ");
			maTG = scanner.nextLine();
			System.out.print("Nhap ten tac gia: ");
			tenTG = scanner.nextLine();
			System.out.print("Nhap ten nha xuat ban: ");
			tenNXB = scanner.nextLine();
	    }

	    public String toString(){
	        return "Ma tai lieu: " + maTL + "\n" +
	               "Ten tai lieu: " + tenTL + "\n" +
	               "The loai: " + theLoai + "\n" +
				   "Ma tac gia: " + maTG + "\n" +
				   "Ten tac gia: " + tenTG + "\n" +
				   "Ten nha xuat ban: " + tenNXB ;
	    }

	    public void xuat(){
	        System.out.println("Ma tai lieu: " + maTL);
			System.out.println("Ten tai lieu: "+ tenTL);
			System.out.println("The loai: "+ theLoai);
			System.out.println("Ma tac gia: " + maTG);
			System.out.println("Ten tac gia: " + tenTG);
			System.out.println("Ten nha xuat ban: " + tenNXB);
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

	    public String getTheLoai(){
	        return theLoai;
	    }
	    public void setTheLoai(String theLoai){
	        this.theLoai = theLoai;
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

		public String getTenNXB(){
	        return tenNXB;
	    }
	    public void setTenNXB(String tenNXB){
	        this.tenNXB = tenNXB;
	    }
}
