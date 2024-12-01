package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;

public class TacGia{
	private String tenTG;
    private String maTG;
    private date namSinh = new date();
    private boolean isDeleted;
    
    public TacGia(){}

    public TacGia(String tenTG,  String maTG, date namSinh, String diaChi){
        this.tenTG = tenTG;
        this.maTG = maTG;
        this.namSinh = namSinh;
        this.isDeleted = false; // Mặc định là chưa bị xóa
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

     public date getNamSinh(){
	    return namSinh;
    }
	public void setNamSinh(date namSinh){
        this.namSinh = namSinh;
    }
	
	public boolean isDeleted() {
        return isDeleted;
    }
    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
	
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        
        System.out.printf("Nhap ten tac gia: ");
        tenTG = checkLoi.checkChuoiRong();
        
        System.out.print("Nhap ma tac gia: ");
        maTG = checkLoi.checkMaTG();

        System.out.print("Nhap ngay-thang-nam sinh tac gia (dd-MM-yyyy): ");
        namSinh.nhap();
    }

    @Override
    public String toString(){
        return "Tên tác giả: " + tenTG +
               ", Mã tác giả: " + maTG +
               ", Năm sinh: " + namSinh;
    }
    public void xuat(){
    	String format = "| %-12s | %-20s | %-20s | %-20s |\n";
        System.out.format(format, maTG, tenTG, namSinh);
    }
}    
