package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DsTheLoai{
    private TheLoai[] dsTLoai;
    private int soluongTLoai;

    public DsTheLoai(int kichThuoc){
        dsTLoai = new TheLoai[kichThuoc];
        soluongTLoai = 0;
    }
     public boolean kiemTraMaTheLoai(String maTLoai) {  	
		for (int i = 0; i < soluongTLoai; i++) {
		        if (dsTLoai[i].getMaTG().equals(maTLoai)) {
		        	return true;  
		        }
		}
		return false;
	}
     public void themTLoai(TheLoai tloai){
        if(soluongTLoai < dsTLoai.length){
            tloai.nhap();
            while (!tloai.kiemTraThongTinHopLe()) {
                System.out.println("Khong duoc de thong tin trong.");
                tloai.nhap();
            }
	    while (kiemTraMaTheLoai(tloai.getMaTL())) { 
                System.out.println("Ma the loai bi trung. Vui long nhap lai.");
                tloai.nhap();
            }
            soluongTLoai++;
            System.out.println("Them thanh cong.");
            ghiDuLieuRaFile("theloai.txt");
        } else{
            System.out.println("Danh sach day");
        }
     }

     public void suaTLoai(String maTLoai){
    	 boolean found = false;
        for(int i=0; i<soluongTLoai; i++){
            if(dsTLoai[i].getMaTLoai().equals(maTLoai)){
                Scanner scanner = new Scanner(System.in);

                System.out.printf("Nhap ten the loai: ");
                dsTLoai[i].setTenTLoai(scanner.nextLine());
		        found = true;
		        System.out.println("Sua thanh cong.");
                ghiDuLieuRaFile("theloai.txt");
		        return;
            }
        }
     }

     public void xoaTLoai(String tenTLoai) {
         for (int i = 0; i < soluongTLoai; i++ ) {
             if (dsTLoai[i].getTenTLoai().equals(tenTLoai)) {
            	 dsTLoai[i].setDeleted(true);
             }
             System.out.println("xoa tam thoi thanh cong.");
             ghiDuLieuRaFile("theloai1.txt"); 
             return;
         }
         System.out.println("Khong tim thay the loai.");
     }
     
     public void khoiPhucTheLoai(String tenTLoai){
         for (int i = 0; i < soluongTLoai; i++) {
             if (dsTLoai[i].getTenTLoai().equals(tenTLoai)){
            	 dsTLoai[i].setDeleted(false);
             }
             System.out.println("Khoi phuc thanh cong.");
             ghiDuLieuRaFile("theloai1.txt");
             return;
         }
         System.out.println("Khong tim thay the loai.");
     }
     
     public void xuat_dsXoa() {
     	System.out.println("Danh sach the loai xoa tam thoi:");
     	boolean hasDeleted = false;
     	
     	for(int i=0; i<soluongTLoai; i++) {
     		if(dsTLoai[i].isDeleted()) {
       			System.out.printf("Ten the loai bi xoa tam thoi: "+ dsTLoai[i].getTenTLoai());
     			hasDeleted = true;
     		}
     	}
     	if(!hasDeleted) {
     		System.out.println("Khong co the loai nao bi xoa.");
     	}
     }
     public void timkiemTLoaitheoma(String maTLoai){
    	 boolean found = false;
    	 for(int i=0; i<soluongTLoai; i++){
            if(dsTLoai[i].getMaTLoai().equals(maTLoai)){
                dsTLoai[i].xuat();
                found = true;
            }
        }
    	 if (!found) {
             System.out.println("Khong tim thay the loai voi ma: " + maTLoai);
         }
      }
     
     public void timkiemTLoaitheoten(String tenTLoai){
    	 boolean found = false;
    	 for(int i=0; i<soluongTLoai; i++){
            if(dsTLoai[i].getTenTLoai().equals(tenTLoai)){
                dsTLoai[i].xuat();
                found = true;
            }
        }
    	 if (!found) {
             System.out.println("Khong tim thay the loai voi ten: " + tenTLoai);
         }
      }
    public void xuat_ds(){
        docDuLieuTuFile("theloai1.txt");
    	if(soluongTLoai ==0) {
    		System.out.println("Danh sach rong");
    		return;
    	}
    	System.out.println("Danh sach the loai: ");
        for(int i = 0; i < soluongTLoai; i++){
            dsTLoai[i].xuat();
        }
    }
    
    private void ghiDuLieuRaFile(String tenFile){
    	String duongDan = "C:\\\\Users\\\\Admin\\\\Documents\\\\NetBeansProjects\\\\DOAN\\\\src\\\\DoAn_QLTV_main\\\\src\\\\sourcefile\\\\" + tenFile;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
            for (int i = 0; i < soluongTLoai; i++) {
                writer.write(dsTLoai[i].toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Loi khi ghi vao file: " + e.getMessage());
        }
    }

    private void docDuLieuTuFile(String tenFile){
    	String duongDan = "C:\\\\Users\\\\Admin\\\\Documents\\\\NetBeansProjects\\\\DOAN\\\\src\\\\DoAn_QLTV_main\\\\src\\\\sourcefile\\\\" + tenFile;
        try (BufferedReader reader = new BufferedReader(new FileReader(duongDan))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if (data.length >= 2) {
                    TheLoai tloai = new TheLoai();
                    tloai.setTenTLoai(data[0]);
                    tloai.setMaTLoai(data[1]);
                    tloai.setMaTL(data[2]);
                    tloai.setTenTL(data[3]);
                    tloai.setMaTG(data[4]);
                    tloai.setTenTG(data[5]);
                    tloai.setMaNXB(data[6]);
                    tloai.setTenNXB(data[7]);
                    themTLoai(tloai);
                }
            }
            System.out.println("Ghi file thanh cong");
        } catch (IOException e) {
            System.out.println("Loi khi Ä‘oc tu file: " + e.getMessage());
        }
    }
}
