import java.util.Scanner;

public class DsTaiLieu{
    private TaiLieu[] dsTL;
    private int soluongTL;
    
    public DsTaiLieu(int kichThuoc){
        dsTL = new TaiLieu[kichThuoc];
        soluongTL = 0;
    }
    
    public void themTL(TaiLieu tl){
        if (soluongTL < dsTL.length){
            dsTL[soluongTL] = tl;
            soluongTL++;
        } else {
            System.out.println("Danh sach day");
        }
    }

    public void suaTL(String maTL){
        for (int i=0; i<soluongTL; i++){
            if(dsTL[i].getMaTL().equals(maTL)){
                Scanner scanner = new Scanner(System.in);

                System.out.printf("Nhap ten tai lieu moi: ");
                dsTL[i].setTenTL(scanner.nextLine());

                System.out.printf("Nhap the loai moi: ");
                dsTL[i].setTheLoai(scanner.nextLine());

                System.out.printf("Nhap ma tac gia moi: ");
                dsTL[i].setMaTG(scanner.nextLine());

                System.out.printf("Nhap ten tac gia moi: ");
                dsTL[i].setTenTG(scanner.nextLine());
                break;
            }
        }
    }

    public void xoaTL(String maTL){
        for(int i= 0; i< soluongTL;i++){
            if(dsTL[i].getMaTL().equals(maTL)){
                for(int j=i; j< soluongTL-1; j++){
                    dsTL[j]= dsTL[j+1];
                }
                dsTL[soluongTL- 1]= null;
                soluongTL--;
                break;
            }
        }
    }
    public void timkiemTL(String maTL){
    	
    }
    public void xuat_ds(){
        for(int i = 0; i < soluongTL; i++){
            dsTL[i].xuat();
            System.out.println();
        }
    }
}