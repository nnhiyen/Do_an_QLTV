package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class TaiLieu{
	    private String maTL;
	    private String tenTL;
	    private TheLoai theLoai;
	    private TacGia tacGia;
		private String tenNXB;

		public TaiLieu(){}

	    public TaiLieu(String maTL, String tenTL, TheLoai theLoai, TacGia tacGia, String tenNXB){
	        this.maTL = maTL;
	        this.tenTL = tenTL;
	        this.theLoai = theLoai;
	        this.tacGia = tacGia;
			this.tenNXB = tenNXB;
	    }

	    public void nhap(){
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Nhap ma tai lieu: ");
	        maTL = scanner.nextLine();
	        System.out.print("Nhap ten tai lieu: ");
	        tenTL = scanner.nextLine();
	        theLoai = new TheLoai();
	        tacGia = new TacGia();
	        tacGia.nhap();
			System.out.print("Nhap ten nha xuat ban: ");
			tenNXB = scanner.nextLine();
	    }

	    public String toString(){
	        return "Ma tai lieu: " + maTL + "\n" +
	               "Ten tai lieu: " + tenTL + "\n" +
	               "The loai: " + theLoai.toString() + "\n" +
				   "Tac gia:" + tacGia.toString() + "\n" +
				   "Ten nha xuat ban: " + tenNXB ;
	    }

	    public void xuat(){
	        System.out.println("Ma tai lieu: " + maTL);
			System.out.println("Ten tai lieu: "+ tenTL);
			theLoai.xuat();
			tacGia.xuat();
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

	    public TheLoai getTheLoai() {
	        return theLoai;
	    }
	    public void setTheLoai(TheLoai theLoai) {
	        this.theLoai= theLoai;
	    }
	    
	    public TacGia getTacGia() {
	        return tacGia;
	    }
	    public void setTacGia(TacGia tacGia) {
	        this.tacGia = tacGia;
	    }

		public String getTenNXB(){
	        return tenNXB;
	    }
	    public void setTenNXB(String tenNXB){
	        this.tenNXB = tenNXB;
	    }
}
