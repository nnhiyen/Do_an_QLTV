package DoAn_QLTV_main.src.sourcecode;
import java.util.Scanner;
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
     public void themTLoai(TheLoai tloai){
        if(soluongTLoai < dsTLoai.length){
            dsTLoai[soluongTLoai] = tloai;
            soluongTLoai++;
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
                ghiDuLieuRaFile("theloai.txt");
		        return;
            }
        }
     }

     public void xoaTLoai(String maTLoai){
    	 boolean found = false;
        for(int i =0; i<soluongTLoai; i++){
            if(dsTLoai[i].getMaTLoai().equals(maTLoai)){
                for(int j=i; j<soluongTLoai-1; j++){
                    dsTLoai[j]= dsTLoai[j+1];
                }
                dsTLoai[soluongTLoai-1]=null;
                soluongTLoai--;
                found = true;
                ghiDuLieuRaFile("theloai.txt");
                return;
            }
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
    	String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
            for (int i = 0; i < soluongTLoai; i++) {
                writer.write(dsTLoai[i].toString());
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
                if (data.length == 2) {
                    TheLoai tloai = new TheLoai();
                    tloai.setTenTLoai(data[0]);
                    tloai.setMaTLoai(data[1]);
                    themTLoai(tloai);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc từ file: " + e.getMessage());
        }
    }
}
