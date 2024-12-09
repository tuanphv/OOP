package PhieuNhap;

import java.util.Scanner;

import Format.ANSI;
import Person.DSNhanVien;
import Sach.DSSach;
import Validate.Validate;
import NCC_NXB.DSNhaCC;

public class QuanLyPhieuNhap {
    DSPhieuNhap dspn= new DSPhieuNhap();
    DSChiTietPN dsctpn= new DSChiTietPN ();
    DSSach dssach= new DSSach();
    DSNhaCC dsncc= new DSNhaCC();
    DSNhanVien dsnv= new DSNhanVien();

    Scanner nhap= new Scanner(System.in);

    public QuanLyPhieuNhap(DSPhieuNhap dspn, DSChiTietPN dsctpn, DSSach dssach, DSNhanVien dsnv, DSNhaCC dsncc) {
        this.dspn=dspn;
        this.dsctpn= dsctpn;
        this.dssach=dssach;
        this.dsnv=dsnv;
        this.dsncc= dsncc;
    }
    
    public void hienThiMenu(){
        int chon;
        do{
            System.out.println("");
            new ANSI(new String[]{"Menu Quan ly phieu nhap".toUpperCase()},
            new String[][]{
                {"1. Quan ly phieu nhap"},
                {"2. Quan ly chi tiet phieu nhap"},
                {"3. Thoat"}}).printTable();
            chon = Validate.getChoice(nhap, 1, 3);
            switch(chon){
                case 1:
                    hienthiMenuPhieuNhap();
                    break;
                case 2:
                    hienthiMenuChiTietPhieuNhap();
                    break;
                case 3:
                    return;
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

            chon = Validate.getChoice(nhap, 1, 6);
            switch(chon){
                case 1:
                    System.out.println("Nhap ma phieu: ");
                    String maPN = nhap.nextLine();
                    System.out.println("Nhap ma NV: ");
                    String maNV = nhap.nextLine();
                    if(dsnv.indexOf(maNV)== -1){
                        System.out.println("Nhan vien chua co trong danh sach");
                        break;
                    }
                    System.out.println("Nhap ma NCC: ");
                    String maNCC = nhap.nextLine();
                    if(dsncc.indexOf(maNCC)== -1){
                        System.out.println("Nha cung cap chua co trong danh sach");
                        break;
                    }
                    dspn.them(maPN, maNV, maNCC); 
                    System.out.println("Nhap so chi tiet phieu muon them: ");
                    int n = Integer.parseInt(nhap.nextLine());
                    for(int i=0; i <n; i++){
                        System.out.println("Nhap ma sach de them vao chi tiet phieu: ");
                        String maSach = nhap.nextLine();
                        if(dssach.indexOf(maSach)== -1){
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
                    int tongTien= dsctpn.getTongTien(maPN);
                    dspn.setTongTien(maPN, tongTien);
                    break;

                case 2:
                    System.out.println("Nhap ma PN can sua");
                    maPN = nhap.nextLine();
                    System.out.println("Nhap ma PN moi: ");
                    String maPNsua= nhap.nextLine();
                    dspn.edit(maPN, maPNsua);
                    int tongTiensua= dsctpn.getTongTien(maPNsua);
                    dspn.setTongTien(maPNsua, tongTiensua);
                    break;
                    
                case 3:
                    System.out.println("Nhap ma PN can xoa");
                    String maPNCanXoa = nhap.nextLine();
                    dspn.remove(maPNCanXoa);
                    break;

                case 4:
                    hienThiMenuTimPhieuNhap();
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

    public void hienThiMenuTimPhieuNhap(){
        int chon;
        do{
            System.out.println("");
            new ANSI(new String[]{"Menu Quan ly phieu nhap".toUpperCase()},
            new String[][]{
                {"1. Tim phieu nhap theo maPN"},
                {"2. Tim phieu nhap theo maNV"},
                {"3. Tim phieu nhap theo maNCC"},
                {"4. Tim phieu nhap theo thoi gian"},
                {"5. Tim phieu nhap theo tong tien"},
                {"6. Thoat"}}).printTable();
            chon = Validate.getChoice(nhap, 1, 6);
            PhieuNhap[] kq=null;
            switch(chon){
                case 1:
                    System.out.println("Nhap ma PN can tim: ");
                    String maPN = nhap.nextLine();
                    kq= dspn.timTheoMaPN(maPN);
                    dspn.xuatKQTimKiem(kq);
                    break;
                case 2:
                    System.out.println("Nhap ma NV can tim: ");
                    String maNV = nhap.nextLine();
                    kq= dspn.timTheoMaNV(maNV);
                    dspn.xuatKQTimKiem(kq);
                    break;
                case 3:
                    System.out.println("Nhap maNCC can tim: ");
                    String maNCC = nhap.nextLine();
                    kq= dspn.timTheoMaNCC(maNCC);
                    dspn.xuatKQTimKiem(kq);
                    break;
                case 4:
                    System.out.println("Nhap tu ngay can tim: ");
                    String tuNgay = nhap.nextLine();
                    System.out.println("Nhap den ngay can tim: ");
                    String denNgay = nhap.nextLine();
                    kq= dspn.timtheoNgayNhap(tuNgay, denNgay);
                    dspn.xuatKQTimKiem(kq);
                    break;
                case 5:
                    System.out.println("Nhap tong tien tu: ");
                    int from = Integer.parseInt(nhap.nextLine());
                    System.out.println("Nhap tong tien den: ");
                    int to = Integer.parseInt(nhap.nextLine());
                    kq= dspn.timTheoTongTien(from, to);
                    dspn.xuatKQTimKiem(kq);
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
            new ANSI(new String[]{"Menu Quan ly chi tiet phieu nhap".toUpperCase()},
            new String[][]{
                {"1. Them chi tiet phieu nhap"},
                {"2. Sua thong tin chi tiet phieu nhap"},
                {"3. Xoa chi tiet phieu nhap"},
                {"4. Tim kiem chi tiet phieu nhap"},
                {"5. Hien thi danh sach chi tiet phieu nhap"},
                {"6. Thoat"}}).printTable();
            chon = Validate.getChoice(nhap, 1, 6);
            switch (chon) {
                case 1:
                    System.out.println("Nhap ma PN: ");
                    String maPNthem= nhap.nextLine();
                    if (dspn.indexOf(maPNthem)== -1){
                        System.out.println("Phieu nhap chua co trong danh sach");
                        break;
                    }
                    System.out.println("Nhap ma sach:");
                    String maSachthem= nhap.nextLine();
                    if(dssach.indexOf(maSachthem)== -1){
                        System.out.println("Sach khong ton tai");
                        break;
                    }
                    dsctpn.them(maPNthem, maSachthem, dssach);
                    int tongTien= dsctpn.getTongTien(maPNthem);
                    dspn.setTongTien(maPNthem, tongTien);
                    break;

                case 2:
                    System.out.println("Nhap ma PN: ");
                    String maPN= nhap.nextLine();
                    System.out.println("Nhap ma sach:");
                    String maSach= nhap.nextLine();
                    System.out.println("Nhap ma PN moi: ");
                    String maPNsua= nhap.nextLine();
                    dsctpn.edit( maPN, maSach, maPNsua, dssach);
                    if(dspn.get(maPN)!= null){
                        int tongTiensua= dsctpn.getTongTien(maPN);
                        dspn.setTongTien(maPN, tongTiensua);
                    }
                    int tongTiensua= dsctpn.getTongTien(maPNsua);
                    dspn.setTongTien(maPNsua, tongTiensua);
                    break;
                case 3:
                    System.out.println("Nhap ma PN: ");
                    String maPNxoa= nhap.nextLine();
                    System.out.println("Nhap ma sach: ");
                    String maSachxoa= nhap.nextLine();
                    dsctpn.remove(maPNxoa, maSachxoa);
                    int tongTienxoa= dsctpn.getTongTien(maPNxoa);
                    if(dspn.indexOf(maPNxoa)!= -1)
                        dspn.setTongTien(maPNxoa, tongTienxoa);
                    break;
                case 4:
                    hienThiMenuTimChiTietPhieuNhap();
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

    public void hienThiMenuTimChiTietPhieuNhap(){
        int chon;
        do{
            System.out.println("");
            new ANSI(new String[]{"Menu tim kiem chi tiet phieu nhap".toUpperCase()},
            new String[][]{
                {"1. Tim theo ma phieu nhap"},
                {"2. Tim theo ma sach"},
                {"3. Thoat"}}).printTable();
            chon = Validate.getChoice(nhap, 1, 3);
            switch (chon) {
                case 1:
                    System.out.println("Nhap ma phieu muon tim: ");
                    String maPN= nhap.nextLine();
                    dsctpn.xuatKQTimKiem(dsctpn.timTheoMaPN(maPN));
                    break;
                case 2:
                    System.out.println("Nhap ma sach muon tim: ");
                    String maSach= nhap.nextLine();
                    dsctpn.xuatKQTimKiem(dsctpn.timTheoMaSach(maSach));
                    break;
                case 3:
                    return;
            }
        }while(true);
    }
}
