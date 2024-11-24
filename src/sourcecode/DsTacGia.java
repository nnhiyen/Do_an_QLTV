package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;
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
     public void themTG(TacGia tg){
        if(soluongTG < dsTG.length){
            dsTG[soluongTG] = tg;
            soluongTG++;
            ghiDuLieuRaFile("tacgia.txt");
        } else{
            System.out.println("Danh sach day");
        }
     }

     public void suaTG(String maTG){
    	 boolean found = false;
        for(int i=0; i<soluongTG; i++){
            if(dsTG[i].getMaTG().equals(maTG)){
                Scanner scanner = new Scanner(System.in);

                System.out.printf("Nhap ten tac gia: ");
                dsTG[i].setTenTG(scanner.nextLine());

                System.out.print("Nhap ngay-thang-nam sinh tac gia (dd-MM-yyyy): ");
		        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		        try {
		            dsTG[i].setNgaySinh(formatter.parse(scanner.nextLine()));
		        } catch (ParseException e) {
		            System.out.println("Ngay sinh khong hop le");
		        }
		
		        System.out.print("Nhap dia chi tac gia: ");
		        dsTG[i].setDiaChi(scanner.nextLine());
		        found = true;
                ghiDuLieuRaFile("tacgia.txt");
		        return;
            }
        }
     }

     public void xoaTG(String maTG){
    	 boolean found = false;
        for(int i =0; i<soluongTG; i++){
            if(dsTG[i].getMaTG().equals(maTG)){
                for(int j=i; j<soluongTG-1; j++){
                    dsTG[j]= dsTG[j+1];
                }
                dsTG[soluongTG-1]=null;
                soluongTG--;
                found = true;
                ghiDuLieuRaFile("tacgia.txt");
                return;
            }
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
    	String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
            for (int i = 0; i < soluongTG; i++) {
                writer.write(dsTG[i].toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }

    private void docDuLieuTuFile(String tenFile){
    	String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;
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
                        System.out.println("Ngày sinh không hợp lệ: " + data[2]);
                    }
                    tg.setDiaChi(data[3]);
                    themTG(tg);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc từ file: " + e.getMessage());
        }
    }
}
