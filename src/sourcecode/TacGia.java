package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TacGia extends TaiLieu{
	private String tenTG;
    private String maTG;
    private Date ngaySinh;
    private String diaChi;
    private DsTaiLieu dsTaiLieu;
    
    public TacGia(){
    	super();
    	}

    public TacGia(String tenTL, String theLoai, String tenTG,  String maTG, Date ngaySinh, String diaChi){
        super(tenTL, theLoai, tenTG);
        this.maTG = maTG;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public String getMaTG(){
        return maTG;
    }
    public void setMaTG(String maTG){
        this.maTG = maTG;
    }

     public Date getNgaySinh(){
	    return ngaySinh;
    }
	public void setNgaySinh(Date ngaySinh){
        this.ngaySinh = ngaySinh;
    }

     public String getDiaChi(){
	    return diaChi;
    }
	public void setDiaChi(String diaChi){
        this.diaChi = diaChi;
    }
	
	@Override
	public String maTL() {
		return maTG;
	}
	@Override
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        
        super.nhap();
        
        System.out.print("Nhap ma tac gia: ");
        maTG = sc.nextLine();

        System.out.print("Nhap ngay-thang-nam sinh tac gia (dd-MM-yyyy): ");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            ngaySinh = formatter.parse(sc.nextLine());
        } catch (ParseException e) {
            System.out.println("Ngay sinh khong hop le");
            ngaySinh = null;
        }

        System.out.print("Nhap dia chi tac gia: ");
        diaChi = sc.nextLine();
    }
    @Override
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return "Ten tac gia: " + tenTG + "\n" +
               "Ma tac gia: " + maTG + "\n" +
               "Ngay sinh: " + (ngaySinh != null ? formatter.format(ngaySinh) : "Khong co") + "\n" +
               "Dia chi tac gia: " + diaChi;
    }
    @Override	
    public void xuat(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Ten tac gia: " + tenTG);
        System.out.println("Ma tac gia: " + maTG);
        System.out.println("Ngay sinh: " + (ngaySinh != null ? formatter.format(ngaySinh) : "Khong co"));
        System.out.println("Dia chi tac gia: " + diaChi);
        System.out.println("Danh sach tac pham cua tac gia " + tenTG + ": ");
        if (dsTaiLieu.getSoLuongTaiLieu() == 0) {
            System.out.println("Không có tài liệu nào.");
        } else {
            dsTaiLieu.xuat_ds();
        }
    }
} 
