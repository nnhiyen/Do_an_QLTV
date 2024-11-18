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

import java.util.Scanner;

public class DSPhieuNhap {
    private PhieuNhap[] dsPhieuNhap;
    private int soLuongPN;
    Scanner sc = new Scanner(System.in);

    public DSPhieuNhap(int soLuong) {
        dsPhieuNhap = new PhieuNhap[soLuong];
        soLuongPN = 0;
    }

    public void themPhieuNhap(PhieuNhap pn) {
        if (soLuongPN < dsPhieuNhap.length) {
            dsPhieuNhap[soLuongPN] = pn;
            soLuongPN++;
        } else {
            System.out.println("Danh sách phiếu nhập đã đầy.");
        }
    }

    public void xemDanhSachPhieuNhap() {
        if (soLuongPN == 0) {
            System.out.println("Danh sách phiếu nhập rỗng.");
            return;
        }

        System.out.println("+--------------------------------------------------+");
        System.out.println("| Ma phieu nhap |  ID nha xuat ban  |   Ngay nhap  |");
        System.out.println("+--------------------------------------------------+");
        for (int i = 0; i < soLuongPN; i++) {
            System.out.println("| " + dsPhieuNhap[i].getMaPN() + "          | " + dsPhieuNhap[i].getMaNXB() + "           | " + dsPhieuNhap[i].getNgayNhap());
        }
        System.out.println("+--------------------------------------------------+");
    }

    public PhieuNhap timPhieuNhap(String maPN) {
        for (int i = 0; i < soLuongPN; i++) {
            if (dsPhieuNhap[i].getMaPN().equals(maPN)) {
                return dsPhieuNhap[i];
            }
        }
        return null;
    }
}

