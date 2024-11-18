/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoAn_QLTV_main.src.sourcecode;
import java.util.Scanner;
/**
 *
 * @author Luong Thanh Tuan
 */
public class Menu implements IMenu {
    @Override
    public void menuQLND() {
        System.out.println("1. Thêm người dùng");
        System.out.println("2. Sửa thông tin người dùng");
        System.out.println("3. Xóa người dùng");
        System.out.println("4. Tìm kiếm người dùng");
        System.out.println("5. Hiển thị danh sách người dùng");
        System.out.println("0. Thoát");
    }

    // Phương thức để chọn các chức năng
    public int luaChon() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Chọn chức năng: ");
        return sc.nextInt();
    }
}
