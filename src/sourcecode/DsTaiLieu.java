package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DsTaiLieu{
    private TaiLieu[] dsTL;
    private int soluongTL;
    Scanner sc = new Scanner(System.in);
    
    public DsTaiLieu(int kichThuoc){
        dsTL = new TaiLieu[kichThuoc];
        soluongTL = 0;
    }
    
    public boolean kiemTraMaTL(String maTL) {
        for (int i = 0; i < soluongTL; i++) {
            if (dsTL[i].maTL().equals(maTL)) {
                return true;  
            }
        }
        return false;
    }
    
    public void themTL(TaiLieu tl){
        if (soluongTL < dsTL.length){
        	tl.nhap();
            dsTL[soluongTL] = tl;
            soluongTL++;
            ghiDuLieuRaFile("tailieu.txt");
        } else {
            System.out.println("Danh sach day");
        }
    }
    
    public void themNhieuTaiLieu(int soLuongThem, TaiLieu tl) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < soLuongThem; i++) {
            System.out.println("Thêm tài liệu thứ " + (i + 1) + ": ");
            tl.nhap();
            
            if (kiemTraMaTL(tl.maTL())) {
                System.out.println("Mã tài liệu " + tl.maTL() + " đã tồn tại. Vui lòng nhập mã khác.");
            } else {
                themTL(tl);
                System.out.println("Tài liệu " + tl.getTenTL() + " đã được thêm thành công.");
            }
        }
    }
    
    public void suaTL(String maTL){
        for (int i=0; i<soluongTL; i++){
            if(dsTL[i].maTL().equals(maTL)){
                System.out.println("Nhap lai thong tin tai lieu: ");
                dsTL[i].nhap();
                ghiDuLieuRaFile("tailieu.txt");
                return;
            }
        }
    }

    public void xoaTaiLieu(String tenTL) {
        for (int i = 0; i < soluongTL; i++) {
            if (dsTL[i].getTenTL().equals(tenTL)) {
            	TaiLieu tl= (TaiLieu) dsTL[i];
            	tl.setDeleted(true);
            }
            System.out.println("Xóa tạm thời thành công.");
            ghiDuLieuRaFile("tailieu.txt"); 
            return;
        }
        System.out.println("Không tìm thấy tài liệu.");
    }
    
    public void khoiPhucTaiLieu(String tenTL){
        for (int i = 0; i < soluongTL; i++) {
            if (dsTL[i].getTenTL().equals(tenTL)){
            	TaiLieu tl= (TaiLieu) dsTL[i];
            	tl.setDeleted(false);
            }
            System.out.println("Khôi phục thành công.");
            ghiDuLieuRaFile("tailieu.txt");
            return;
        }
        System.out.println("Không tìm thấy tài liệu.");
    }
    
    public void DsXoa() {
    	System.out.println("Danh sach tai lieu xoa tam thoi:");
    	boolean hasDeleted = false;
    	
    	for(int i=0; i<soluongTL; i++) {
    		TaiLieu tl = (TaiLieu) dsTL[i];
    		if(tl.isDeleted()) {
    			System.out.printf(tl.getTenTL());
    			hasDeleted = true;
    		}
    	}
    	if(!hasDeleted) {
    		System.out.println("Khong co tai lieu nao bi xoa.");
    	}
    }
    
    public void timKiemtheoMa(String maTL) {
        boolean found = false;
        for(int i=0; i<soluongTL; i++) {
        	TaiLieu tl= (TaiLieu) dsTL[i];
        	if(tl.maTL().equals(maTL)) {
        		tl.xuat();
        		found = true;
        	}
        }
        if (!found){
            System.out.println("Khong tim thay tai lieu voi ma: " + maTL);
        }
    }
    
    public void timKiemTheoTen(String tenTL) {
        boolean found = false;
        for (int i = 0; i < soluongTL; i++) {
            if (dsTL[i].getTenTL().equals(tenTL)) {
                dsTL[i].xuat();
                found = true;
            }
        }
        if (!found){
            System.out.println("Khong tim thay tai lieu voi ten: " + tenTL);
        }
    }
    public void xuat_ds(){
    	if(soluongTL ==0) {
    		System.out.println("Danh sach rong");
    		return;
    	}
    	System.out.println("Danh sach tai lieu: ");
        for(int i = 0; i < soluongTL; i++){
        	TaiLieu tl = (TaiLieu) dsTL[i];
        	if(!tl.isDeleted()) {
            dsTL[i].xuat();
        	}
        }
    }
    
    public TaiLieu[] getDanhSachTaiLieu() {
        return dsTL;
    }

    public int getSoLuongTaiLieu() {
        return soluongTL;
    }
    
    private void ghiDuLieuRaFile(String tenFile){
    	String duongDan = "C:\\\\Users\\\\Admin\\\\Documents\\\\NetBeansProjects\\\\DOAN\\\\src\\\\DoAn_QLTV_main\\\\src\\\\sourcefile\\\\" + tenFile;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
            for (int i = 0; i < soluongTL; i++) {
                writer.write(dsTL[i].toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Loi khi ghi vào file: " + e.getMessage());
        }
    }
    public void docDuLieuTuFile(String tenFile) {
        // Đường dẫn đầy đủ tới file
        String duongDan = "C:\\\\Users\\\\Admin\\\\Documents\\\\NetBeansProjects\\\\DOAN\\\\src\\\\DoAn_QLTV_main\\\\src\\\\sourcefile\\\\" + tenFile;

        try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", "); 
                if (parts.length >= 4) { 
                    String tenTL = parts[0].split(": ")[1];
                    String tenTG = parts[1].split(": ")[1];
                    String theLoai = parts[2].split(": ")[1];
                    String ma = parts[3];
                        TheLoai tl = new TheLoai();
                        tl.setTenTL(tenTL);
                        tl.setTenTG(tenTG);
                        tl.setTheLoai(theLoai);
                        tl.maTL();
                        themTL(tl);   
                }
            }
            System.out.println("Đọc dữ liệu thành công từ file " + duongDan);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        }
    }
}
