package PhieuNhap;

import java.util.Scanner;

import Format.ANSI;
import Sach.DSSach;

public class QuanLyPhieuNhap {
    DSPhieuNhap dspn= new DSPhieuNhap();
    DSChiTietPN dsctpn= new DSChiTietPN ();
    DSSach dssach= new DSSach();

    Scanner nhap= new Scanner(System.in);

    public QuanLyPhieuNhap(DSPhieuNhap dspn, DSChiTietPN dsctpn, DSSach dssach) {
        this.dspn=dspn;
        this.dsctpn= dsctpn;
        this.dssach=dssach;
    }
    
    public void hienThiMenu(){
        int chon;
        do{
            System.out.println("");
            new ANSI(new String[]{"Menu Quan ly phieu nhap".toUpperCase()},
            new String[][]{
                {"1. Quan ly phieu nhap"},
                {"2. Quan ly chi tiet phieu nhap"}}).printTable();
            chon = Integer.parseInt(nhap.nextLine());
            switch(chon){
                case 1:
                    hienthiMenuPhieuNhap();
                case 2:
                    hienthiMenuChiTietPhieuNhap();
            }
        }
        while(true);
    }

    public void hienthiMenuPhieuNhap(){
        int chon;
        do{
            System.out.println("");
            new ANSI(new String[]{"Menu Quan ly phieu nhap".toUpperCase()},
            new String[][]{
                {"1. Them phieu nhap"},
                {"2. Sua thong tin phieu nhap"},
                {"3. Xoa phieu nhap"},
                {"4. Tim kiem phieu nhap"},
                {"5. Hien thi danh sach phieu nhap"},
                {"6. Thoat"}}).printTable();
            chon = Integer.parseInt(nhap.nextLine());
            switch(chon){
                case 1:
                    System.out.println("Nhap ma phieu: ");
                    String maPN = nhap.nextLine();
                    dspn.them(maPN);
                    System.out.println("Nhap so chi tiet phieu muon them: ");
                    int n = Integer.parseInt(nhap.nextLine());
                    for(int i=0; i <n; i++){
                        System.out.println("Nhap ma sach de them vao chi tiet phieu: ");
                        String maSach = nhap.nextLine();
                        if(dsctpn.checkBook(maSach, dssach)== false){
                            System.out.println("Sach khong ton tai. Nhap 1 de nhap sach moi, 2 de nhap lai chi tiet phieu");
                            int m= Integer.parseInt(nhap.nextLine());
                            switch (m) {
                                case 1:
                                    dssach.them();
                                    i--;
                                    break;
                                case 2:
                                    i--;
                                    break;
                            }
                        }
                        else{
                            dsctpn.them(maPN, maSach, dssach);
                        }
                    }
                    break;

                case 2:
                    break;
                    
                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    dspn.hienthi();
                    break;
                case 6:
                    return;
            }
        }
        while(true);
    }

    public void hienthiMenuChiTietPhieuNhap(){
        int chon;
        do{
            System.out.println("");
            new ANSI(new String[]{"Menu Quan ly chi phieu nhap".toUpperCase()},
            new String[][]{
                {"1. Them chi phieu nhap"},
                {"2. Sua thong tin chi phieu nhap"},
                {"3. Xoa chi phieu nhap"},
                {"4. Tim kiem chi phieu nhap"},
                {"5. Hien thi danh sach chi phieu nhap"},
                {"6. Thoat"}}).printTable();
            chon = Integer.parseInt(nhap.nextLine());
            switch (chon) {
                case 1:
                    
                    break;
            
                case 5:
                    dsctpn.hienthi();
                    break;
                case 6:
                    return;
            }
        }
        while(true);
    }
}
