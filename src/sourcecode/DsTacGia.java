package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;
import java.util.Arrays;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DsTacGia{
    private TacGia[] dsTG;
    private int soluongTG;

    public DsTacGia(int kichThuoc){
        dsTG = new TacGia[kichThuoc];
        soluongTG = 0;
    }

     public boolean kiemTraMaTacGia(String maTG) {
        for (int i = 0; i < soluongTG; i++) {
            if (dsTG[i].getMaTG().equals(maTG)) {
                return true;  
            }
        }
        return false;
    }
    
     public void themTG(TacGia tg){
        if(soluongTG < dsTG.length){
            tg.nhap();
            while (!tg.kiemTraThongTinHopLe()) {
                System.out.println("Khong duoc de thong tin trong.");
                tg.nhap();
            }
	    while (kiemTraMaTacGia(tg.getMaTG())) { 
                System.out.println("Ma tai lieu bi trung. Vui long nhap lai.");
                tg.nhap();
            }
            soluongTG++;
            ghiDuLieuRaFile("tacgia1.txt");
		    System.out.println("Them thanh cong.");
        } else{
            System.out.println("Danh sach day");
        }
     }

     public void suaTG(String maTG){
    	 boolean found = false;
        for(int i=0; i<soluongTG; i++){
            if(dsTG[i].getMaTG().equals(maTG)){
                Scanner sc = new Scanner(System.in);

                System.out.printf("Nhap ten tac gia: ");
                dsTG[i].setTenTG(sc.nextLine());

                System.out.print("Nhap ngay-thang-nam sinh tac gia (dd-MM-yyyy): ");
		        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		        try {
		            dsTG[i].setNgaySinh(formatter.parse(sc.nextLine()));
		        } catch (ParseException e) {
		            System.out.println("Ngay sinh khong hop le");
		        }
		
		        System.out.print("Nhap dia chi tac gia: ");
		        dsTG[i].setDiaChi(sc.nextLine());
		        found = true;
                ghiDuLieuRaFile("tacgia1.txt");
    		    System.out.println("Sua thanh cong.");
		        return;
            }
        }
     }
  
     public void xoaTacGia(String tenTG) {
         for (int i = 0; i < soluongTG; i++ ) {
             if (dsTG[i].getTenTG().equals(tenTG)) {
            	 dsTG[i].setDeleted(true);
             }
             System.out.println("xoa tam thoi thanh cong.");
             ghiDuLieuRaFile("tacgia1.txt"); 
             return;
         }
         System.out.println("Khong tim thay tai lieu.");
     }
     
     public void khoiPhucTacGia(String tenTG){
         for (int i = 0; i < soluongTG; i++) {
             if (dsTG[i].getTenTG().equals(tenTG)){
            	 dsTG[i].setDeleted(false);
             }
             System.out.println("Khoi phuc thanh cong.");
             ghiDuLieuRaFile("tacgia1.txt");
             return;
         }
         System.out.println("Khong tim thay tai lieu.");
     }
     
     public void xuat_dsXoa() {
     	System.out.println("Danh sach tac gia xoa tam thoi:");
     	boolean hasDeleted = false;
     	
     	for(int i=0; i<soluongTG; i++) {
     		if(dsTG[i].isDeleted()) {
       			System.out.printf("Ten tac gia bi xoa tam thoi: "+ dsTG[i].getTenTG());
     			hasDeleted = true;
     		}
     	}
     	if(!hasDeleted) {
     		System.out.println("Khong co tai lieu nao bi xoa.");
     	}
     }
     
     public void timkiemTGtheoma(String maTG){
    	 boolean found = false;
    	 for(int i=0; i<soluongTG; i++){
            if(dsTG[i].getMaTG().equals(maTG)){
                dsTG[i].xuat();
                found = true;
            }
        }
    	 if (!found) {
             System.out.println("Khong tim thay tac gia voi ma: " + maTG);
         }
      }
     
     public void timkiemTGtheoten(String tenTG){
    	 boolean found = false;
    	 for(int i=0; i<soluongTG; i++){
            if(dsTG[i].getTenTG().equals(tenTG)){
                dsTG[i].xuat();
                found = true;
            }
        }
    	 if (!found) {
             System.out.println("Khong tim thay tac gia voi ten: " + tenTG);
         }
      }
    public void xuat_ds(){
        docDuLieuTuFile("tacgia1.txt");
    	if(soluongTG ==0) {
    		System.out.println("Danh sach rong");
    		return;
    	}
    	System.out.println("Danh sach tai lieu: ");
        for(int i = 0; i < soluongTG; i++){
            dsTG[i].xuat();
        }
    }
    
    private void ghiDuLieuRaFile(String tenFile){
    	String duongDan = "C:\\\\Users\\\\Admin\\\\Documents\\\\NetBeansProjects\\\\DOAN\\\\src\\\\DoAn_QLTV_main\\\\src\\\\sourcefile\\\\" + tenFile;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
            for (int i = 0; i < soluongTG; i++) {
                writer.write(dsTG[i].toString());
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
                if (data.length == 4) {
                    TacGia tg = new TacGia();
                    tg.setTenTG(data[0]);
                    tg.setMaTG(data[1]);
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        tg.setNgaySinh(formatter.parse(data[2]));
                    } catch (ParseException e) {
                        System.out.println("Ngay sinh khong hop le: " + data[2]);
                    }
                    tg.setDiaChi(data[3]);
                    themTG(tg);
                }
            }
            System.out.println("Doc file thanh cong");
        } catch (IOException e) {
            System.out.println("Loi khi doc tu file: " + e.getMessage());
        }
    }
}

