package DoAn_QLTV_main.src.sourcecode;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        } else{
            System.out.println("Danh sach day");
        }
     }

     public void suaTG(String maTG){
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
            }
        }
     }

     public void xoaTG(String maTG){
        for(int i =0; i<soluongTG; i++){
            if(dsTG[i].getMaTG().equals(maTG)){
                for(int j=i; j<soluongTG-1; j++){
                    dsTG[j]= dsTG[j+1];
                }
                dsTG[soluongTG-1]=null;
                soluongTG--;
                break;
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
        for(int i=0; i<soluongTG; i++){
            dsTG[i].xuat();
            System.out.println();
        }
    }
}
