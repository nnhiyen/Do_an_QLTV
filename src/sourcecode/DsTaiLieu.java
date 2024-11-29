package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

public class DsTaiLieu{
    private TaiLieu[] dsTL;
    private int soluongTL;
    private static final String maTLxxx = "^TL\\d{3}$";
    Scanner sc = new Scanner(System.in);
    
    public DsTaiLieu(int kichThuoc){
        dsTL = new TaiLieu[kichThuoc];
        soluongTL = 0;
    }
    
    public boolean kiemTraMaTaiLieu(String maTL) {
    	if (!Pattern.matches(maTLxxx, maTL)) {
            System.out.println("Mã tài liệu không hợp lệ. Định dạng đúng là 'TLxxx' (ví dụ: TL001,...).");
            return false;
        }
        for (int i = 0; i < soluongTL; i++) {
            if (dsTL[i].getMaTL().equals(maTL)) {
                return true;  
            }
        }
        return false;
    }
    
    public void themTaiLieu(TaiLieu tl){
        if (soluongTL < dsTL.length){
        	tl.nhap();
        	while (!tl.kiemTraThongTinHopLe()) {
                System.out.println("Khong duoc de thong tin trong.");
                tl.nhap();
            }
        	while (kiemTraMaTL(tl.getMaTL())) { 
                System.out.println("Ma tai lieu bi trung. Vui long nhap lai.");
                tl.nhap();
            }
		    dsTL[soluongTL] = tl;
		    soluongTL++;
		    ghiDuLieuRaFile("tailieu1.txt");
		    System.out.println("Them thanh cong.");
        } else {
            System.out.println("Danh sach day");
        }
    }
    
    public void suaTaiLieu(String maTL){
        for (int i=0; i<soluongTL; i++){
            if(dsTL[i].getMaTL().equals(maTL)){
                System.out.println("Nhap lai thong tin tai lieu: ");
                dsTL[i].nhap();
                ghiDuLieuRaFile("tailieu1.txt");
    		    System.out.println("Sua thanh cong.");
                return;
            }
        }
    }

    public void xoaTaiLieu(String tenTL) {
        for (int i = 0; i < soluongTL; i++ ) {
            if (dsTL[i].getTenTL().equals(tenTL)) {
            	dsTL[i].setDeleted(true);
            }
            System.out.println("xoa tam thoi thanh cong.");
            ghiDuLieuRaFile("tailieu1.txt"); 
            return;
        }
        System.out.println("Khong tim thay tai lieu.");
    }
    
    public void khoiPhucTaiLieu(String tenTL){
        for (int i = 0; i < soluongTL; i++) {
            if (dsTL[i].getTenTL().equals(tenTL)){
            	dsTL[i].setDeleted(false);
            }
            System.out.println("Khoi phuc thanh cong.");
            ghiDuLieuRaFile("tailieu1.txt");
            return;
        }
        System.out.println("Khong tim thay tai lieu.");
    }
    
    public void xuat_dsXoa() {
    	System.out.println("Danh sach tai lieu xoa tam thoi:");
    	boolean hasDeleted = false;
    	
    	for(int i=0; i<soluongTL; i++) {
    		if(dsTL[i].isDeleted()) {
    			System.out.printf("Ten tai lieu bi xoa tam thoi: "+ dsTL[i].getTenTL());
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
        	if(dsTL[i].getMaTL().equals(maTL)) {
        		dsTL[i].xuat();
        		found = true;
        	}
        }
        if (!found){
            System.out.println("Khong tim thay tai lieu voi ma: " + maTL);
        }
    }
    
    public void timKiemtheoTen(String tenTL) {
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
    public void xuat_ds() {
        docDuLieuTuFile("tailieu1.txt");
        if (soluongTL == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.println("Danh sach tai lieu: ");
        for (int i = 0; i < soluongTL; i++) {
            if (!dsTL[i].isDeleted()) {
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
    	if (soluongTL == 0) {
            System.out.println("Không có dữ liệu để ghi.");
            return;
        }
    	String duongDan = "C:\\eclip\\eclip\\eclip\\\\" + tenFile;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
            for (int i = 0; i < soluongTL; i++) {
                writer.write(dsTL[i].toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Loi khi ghi vao file: " + e.getMessage());
        }
    }
    public void docDuLieuTuFile(String tenFile) {
        String duongDan = "C:\\\\eclip\\\\eclip\\\\eclip\\\\\\\\" + tenFile;

        try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", "); 
                if (data.length >= 7) { 
                        TaiLieu tl = new TaiLieu();
                        tl.setMaTL(data[0]);
                        tl.setTenTL(data[1]);
                        tl.setMaTG(data[2]);
                        tl.setTenTG(data[3]);
                        tl.setMaTLoai(data[4]);
                        tl.setTenTLoai(data[5]);
                        tl.setMaNXB(data[6]);
                        tl.setTenNXB(data[7]);
                        themTL(tl);   
                }
            }
            System.out.println("Doc du lieu thanh cong tu file " + duongDan);
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }
}
