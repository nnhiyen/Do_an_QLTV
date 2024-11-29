package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TacGia{
	private String tenTG;
    private String maTG;
    private Date ngaySinh;
    private String diaChi;
    private DsTaiLieu dsTaiLieu;
    
    public TacGia(){}

    public TacGia(String tenTG,  String maTG, Date ngaySinh, String diaChi){
        this.tenTG = tenTG;
        this.maTG = maTG;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }
    public String getTenTG() {
    	return tenTG;
    }
    public void setTenTG(String tenTG) {
    	this.tenTG = tenTG;
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
	private boolean isDeleted;

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
	
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        
        System.out.printf("Nhap ten tac gia: ");
        tenTG = sc.nextLine();
        
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
    public boolean kiemTraThongTinHopLe() {
        if (maTG == null && maTG.isEmpty() &&
            tenTG == null && tenTG.isEmpty() &&
            diaChi == null && diaChi.isEmpty()) {
            return false;
        }
        if (ngaySinh == null) {
            return false;
        }
        Date currentDate = new Date();
        if (ngaySinh.after(currentDate)) {
            return false;  // Nếu ngày sinh sau ngày hiện tại, không hợp lệ
        }
        return true;
    }
    @Override
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return "Ten tac gia: " + tenTG + "\n" +
               "Ma tac gia: " + maTG + "\n" +
               "Ngay sinh: " + (ngaySinh != null ? formatter.format(ngaySinh) : "Khong co") + "\n" +
               "Dia chi tac gia: " + diaChi;
    }
    public void xuat(){
    	System.out.println(toString()+ "\n ----");
        System.out.println("Danh sach tac pham cua tac gia " + tenTG + ": ");
        if (dsTaiLieu.getSoLuongTaiLieu() == 0) {
            System.out.println("Tai lieu trong: ");
        } else {
            dsTaiLieu.xuat_ds();
        }
    }
} 
