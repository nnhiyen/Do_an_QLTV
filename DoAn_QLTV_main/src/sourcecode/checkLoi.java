/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoAn_QLTV_main.src.sourcecode;
import java.util.Scanner;

public class checkLoi {
    static Scanner sc = new Scanner(System.in);
    
    // kiểm tra năm sinh
    public static int checkNamSinhND(){
        int input = -1;
        while(true){
            try {
                input = Integer.parseInt(sc.nextLine().trim()); // ???
                if(input >=1964 && input <= 2006){
                    break;
                } else{
                    System.out.println("Năm sinh phải từ 1964 đến 2006. Vui lòng nhập lại.");
                }
            }catch (NumberFormatException e){
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập một số nguyên.");
            }
        }
        return input;
    }
    public static int checkNamSinhTG(){
        int input = -1;
        while(true){
            try {
                input = Integer.parseInt(sc.nextLine().trim()); // ???
                if(input >=1600 && input <= 2000){
                    break;
                } else{
                    System.out.println("Năm sinh phải từ 1600 đến 1900. Vui lòng nhập lại.");
                }
            }catch (NumberFormatException e){
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập một số nguyên.");
            }
        }
        return input;
    }
	
    
    public static String checkChuoiRong(){
        String input;
        while(true){
            input = sc.nextLine();
            if(input.trim().isEmpty()){
                System.out.println("Không được để trống, vui lòng nhập lại.");
            } else {
                break;
            }
        }
        return input;
    }
    
    public static String checkMaSV() {
        String maSV;
        while (true) {
            maSV = sc.nextLine();
            maSV = maSV.toUpperCase();
            // Kiểm tra độ dài mã sinh viên
            if (maSV.matches("SV" + "[0-9]{3}")) {
                return maSV;
            }else if(maSV.isEmpty()) {
                System.err.println("Mã sinh viên không được để trống. Vui lòng nhập lại.");
            }else {
                System.err.println("Mã sai định dạng. Ví dụ: SV001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }
    public static String checkMaND(){
        String maND;
        while(true){
            maND= sc.nextLine();
            maND= maND.toUpperCase();
            if(maND.matches("(GV|SV)" + "[0-9]{3}")){
                return maND;
            }else if(maND.isEmpty()){
                System.out.println("Mã người dùng không được để trống. Vui lòng nhập lại.");
            }else{
                System.out.println("Mã sai định dạng. Ví dụ: SV001 hoặc GV001");
            }
            System.out.println("Mời nhập lại: ");
        }
    }
    public static String checkMaGV() {
        String maGV;
        while (true) {
            maGV = sc.nextLine();
            maGV = maGV.toUpperCase();
            // Kiểm tra độ dài mã sinh viên
            if (maGV.matches("GV" + "[0-9]{3}")) {
                return maGV;
            }else if(maGV.isEmpty()) {
                System.err.println("Mã giảng viên không được để trống. Vui lòng nhập lại.");
            }else {
                System.err.println("Mã sai định dạng. Ví dụ: GV001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }
    public static String checkPN() {
        String maPN;
        while (true) {
            maPN = sc.nextLine();
            maPN = maPN.toUpperCase();
            // Kiểm tra độ dài mã sinh viên
            if (maPN.matches("PN" + "[0-9]{3}")) {
                return maPN;
            }else if(maPN.isEmpty()) {
                System.err.println("Mã phiếu nhập không được để trống. Vui lòng nhập lại.");
            }else {
                System.err.println("Mã sai định dạng. Ví dụ: PN001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }
    public static String checkMaMT() {
        String maMT;
        while (true) {
            maMT = sc.nextLine();
            maMT = maMT.toUpperCase();
            if (maMT.matches("MT" + "[0-9]{3}")) {
                return maMT;
            }else if(maMT.isEmpty()) {
                System.err.println("Mã mượn trả không được để trống. Vui lòng nhập lại.");
            }else {
                System.err.println("Mã sai định dạng. Ví dụ: MT001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }
    
    public static int checkSoNguyen(){
        int input;
        while(true){
            try{
                input = Integer.parseInt(sc.nextLine());
                return input;
            } catch (NumberFormatException exception){
                System.out.println("Kiểu dữ liệu không hợp lệ!");
            }
            System.out.print("Mời nhập lại: ");
        }
    }

    public static String checkMaTG() {
        String maTG;
        while (true) {
            maTG = sc.nextLine();
            maTG = maTG.toUpperCase();
            if(maTG.matches("TG" + "[0-9]{3}")){
                return maTG;
            }else if(maTG.isEmpty()){
                System.err.println("Mã tác giả không được để trống. Vui lòng nhập lại.");
            }else {
                System.err.println("Mã sai định dạng. Ví dụ: TG001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }
	
	public static String checkMaTLoai() {
        String maTLoai;
        while (true) {
            maTLoai = sc.nextLine();
            maTLoai = maTLoai.toUpperCase();
            if(maTLoai.matches("TL" + "[0-9]{3}")){
                return maTLoai;
            }else if(maTLoai.isEmpty()){
                System.err.println("Mã thể loại không được để trống. Vui lòng nhập lại.");
            }else {
                System.err.println("Mã sai định dạng. Ví dụ: TL001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }
    
    public static String checkMaNXB(){
        String input;
        while(true){
            input =sc.nextLine(); // bỏ đi khoảng trắng khi dùng String
            input = input.toUpperCase();
            if(input.matches("NXB" + "[0-9]{3}")){
                return input;
            }else {
                System.err.println("Mã sai định dạng. Ví dụ: NXB001");
            }
            System.out.print("Mời nhập lại");
        }
    }
    public static String checkMaPN() {
        String input;
        while (true) {
            input = sc.nextLine().toUpperCase(); // Chuyển chuỗi về chữ in hoa
            if (input.matches("PN" + "[0-9]{3}")) {  // Kiểm tra định dạng PNxxx
                return input;
            } else {
                System.err.println("Mã phiếu nhập sai định dạng. Ví dụ: PN001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }
    
    
//    public static String checkMaSV(){
//        chỉnh lại nếu như muốn xét mã như NXB
//    }
    public static String checkMaTaiLieu(){
        String input;
        while(true){
            input = sc.nextLine();
            input = input.toUpperCase();
            if(input.matches("TL" + "[0-9]{3}")){
                return input;
            }else {
                System.err.println("Mã sai định dạng. Ví dụ: TL001");
            }
            System.out.print("Mời nhập lại");
        }
    }
    
    public static int checkSoLuong(){
        int input;
        while(true){
            input = sc.nextInt();
            if(input <=0){
                System.err.println("Số lượng không hợp lệ");
            } else if(input >= 100) {
                System.err.println("Số lượng quá lớn");
            } else {
                return input;
            }
            System.out.print("Mời nhập lại: ");
        }
    }
}
