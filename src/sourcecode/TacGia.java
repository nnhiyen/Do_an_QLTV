import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class TacGia{
    private String tenTG;
    private String maTG;
    private Date ngaySinh;
    private String diaChi;
    private DsTaiLieu[] dsTaiLieu;

    public TacGia() {}

    public TacGia(String tenTG, String maTG, Date ngaySinh, String diaChi, int kichThuoc){
        this.tenTG = tenTG;
        this.maTG = maTG;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.dsTaiLieu = new DsTaiLieu[kichThuoc];
    }

    public void nhap(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ten tac gia: ");
        tenTG = scanner.nextLine();

        System.out.print("Nhap ma tac gia: ");
        maTG = scanner.nextLine();

        System.out.print("Nhap ngay-thang-nam sinh tac gia (dd-MM-yyyy): ");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            ngaySinh = formatter.parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Ngay sinh khong hop le");
            ngaySinh = null;
        }

        System.out.print("Nhap dia chi tac gia: ");
        diaChi = scanner.nextLine();
        
        System.out.print("Nhap so luong toi da: ");
        int kichThuoc = Integer.parseInt(scanner.nextLine());
        dsTaiLieu = new DsTaiLieu[kichThuoc];
    }

    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return "Ten tac gia: " + tenTG + "\n" +
               "Ma tac gia: " + maTG + "\n" +
               "Ngay sinh: " + (ngaySinh != null ? formatter.format(ngaySinh) : "Khong co") + "\n" +
               "Dia chi tac gia: " + diaChi;
    }

    public void xuat(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Ten tac gia: " + tenTG);
        System.out.println("Ma tac gia: " + maTG);
        System.out.println("Ngay sinh: " + (ngaySinh != null ? formatter.format(ngaySinh) : "Khong co"));
        System.out.println("Dia chi tac gia: " + diaChi);
        System.out.println("Danh sach tac pham cua tac gia " + tenTG + ": ");
        if (dsTaiLieu != null){
            for (DsTaiLieu taiLieu : dsTaiLieu){
                if (taiLieu != null){
                    taiLieu.xuat_ds();
                }
            }
        } else{
            System.out.println("Khong co tai lieu nao.");
        }
    }

    public DsTaiLieu[] getDSTaiLieu(){
        return dsTaiLieu;
    }
    
    public String getTenTG(){
        return tenTG;
    }
    public void setTenTG(String tenTG){
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
}