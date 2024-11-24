package DoAn_QLTV_main.src.sourcecode;

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
                return;
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
                return;
            }
        }
    }
    public void timkiemTL(String maTL) {
        boolean found = false;
        for (int i = 0; i < soluongTL; i++) {
            if (dsTL[i].getMaTL().equals(maTL)) {
                dsTL[i].xuat();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Tai lieu khong tim thay.");
        }
    }

    public void timkiemtheoTheLoai(String theLoai) {
        boolean found = false;
        for (int i = 0; i < soluongTL; i++) {
            if (dsTL[i].getTheLoai().equals(theLoai)) {
                dsTL[i].xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong co tai lieu nao thuoc the loai: " + theLoai);
        }
    }

    public void timkiemtheoTG(String tenTG) {
        boolean found = false;
        for (int i = 0; i < soluongTL; i++) {
            if (dsTL[i].getTenTG().equals(tenTG)) {
                dsTL[i].xuat();
                found = true;
            }
        }
        
    public void xuat_ds(){
    	if(soluongTL ==0) {
    		System.out.println("Danh sach rong");
    		return;
    	}
    	System.out.println("Danh sach tai lieu: ");
        for(int i = 0; i < soluongTL; i++){
            dsTL[i].xuat();
        }
    }
    
    public TaiLieu[] getDanhSachTaiLieu() {
        return dsTL;
    }

    public int getSoLuongTaiLieu() {
        return soluongTL;
    }
    
    private void ghiDuLieuRaFile(String tenFile){
    	String duongDan = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\DOAN\\src\\DoAn_QLTV_main\\src\\sourcefile\\" + tenFile;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(duongDan))) {
            for (int i = 0; i < soluongTL; i++) {
                writer.write(dsTL[i].toString());
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
                if (data.length == 5) {
                    TaiLieu tl = new TaiLieu();
                    TacGia tg = new TacGia();
                    TheLoai tloai = new TheLoai();
                    tl.setMaTL(data[0]);
                    tl.setTenTL(data[1]);
                    tloai.setTenTLoai(data[2]);
                    tl.setTheLoai(tloai);
                    tg.setTenTG(data[3]);
                    tl.setTacGia(tg);
                    tl.setTenNXB(data[4]);
                    
                    themTL(tl);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc từ file: " + e.getMessage());
        }
    }
}
