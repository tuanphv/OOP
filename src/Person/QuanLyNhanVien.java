package Person;

import java.util.Scanner;
import Format.ANSI;

public class QuanLyNhanVien {
    DSNhanVien dsnv= new DSNhanVien();

    Scanner nhap= new Scanner(System.in);

    public QuanLyNhanVien(DSNhanVien dsnv) {
        this.dsnv=dsnv;
    }

    public void hienThiMenu(){
        int chon;
        do{
            System.out.println("");
            new ANSI(new String[]{"Menu Quan ly nhan vien".toUpperCase()},
            new String[][]{
                {"1. Them nhan vien"},
                {"2. Sua thong tin nhan vien"},
                {"3. Xoa nhan vien"},
                {"4. Tim kiem nhan vien"},
                {"5. Hien thi danh sach nhan vien"},
                {"6. Thoat"}}).printTable();
            chon = Integer.parseInt(nhap.nextLine());
            switch(chon){
                case 1:
                    dsnv.them();
                    break;
                case 2:
                    System.out.println("Nhap ma NV muon sua: ");
                    String maNV= nhap.nextLine();
                    dsnv.edit(maNV);
                    break;
                case 3:
                    System.out.println("Nhap ma NV muon xoa: ");
                    String maNVXoa= nhap.nextLine();
                    dsnv.remove(maNVXoa);
                    break;
                case 4:
                    hienThiMenuTimKiemNhanVien();
                    break;
                case 5:
                    dsnv.hienthi();
                    break;
                case 6:
                    return;
            }
        }while(true);
    }

    public void hienThiMenuTimKiemNhanVien(){
        int chon;
        do{
            System.out.println("");
            new ANSI(new String[]{"Menu tim kiem nhan vien".toUpperCase()},
            new String[][]{
                {"1. Tim theo ma NV"},
                {"2. Tim theo ten NV"},
                {"3. Tim theo gioi tinh NV"},
                {"4. Tim theo sdt NV"},
                {"5. Tim theo khoang luong NV"},
                {"6. Tim theo chuc vu NV"},
                {"7. Thoat"}}).printTable();
            chon = Integer.parseInt(nhap.nextLine());
            switch(chon){
                case 1:
                    System.out.println("Nhap ma NV can tim: ");
                    String maNVTK= nhap.nextLine();
                    NhanVien[] kqTKMaNV=dsnv.timTheoMa(maNVTK);
                    dsnv.xuatKQTimKiem(kqTKMaNV);
                    break;
                case 2:
                    System.out.println("Nhap ten NV can tim: ");
                    String tenNVTK= nhap.nextLine();
                    NhanVien[] kqTKTenNV=dsnv.timTheoTen(tenNVTK);
                    dsnv.xuatKQTimKiem(kqTKTenNV);
                    break;
                case 3:
                    System.out.println("Nhap gioi tinh NV can tim: ");
                    String gtNVTK= nhap.nextLine();
                    NhanVien[] kqTKGtNV=dsnv.timTheoGioiTinh(gtNVTK);
                    dsnv.xuatKQTimKiem(kqTKGtNV);
                    break;
                case 4:
                    System.out.println("Nhap sdt NV can tim: ");
                    String sdtNVTK= nhap.nextLine();
                    NhanVien[] kqTKSdtNV=dsnv.timTheoMa(sdtNVTK);
                    dsnv.xuatKQTimKiem(kqTKSdtNV);
                    break;
                case 5: 
                    System.out.println("Nhap khoang luong bat dau: ");
                    int from= Integer.parseInt(nhap.nextLine());
                    System.out.println("Nhap khoang luong ket thuc: ");
                    int to= Integer.parseInt(nhap.nextLine());
                    NhanVien[] kqTKLuongNV=dsnv.timTheoKhoangLuong(from, to);
                    dsnv.xuatKQTimKiem(kqTKLuongNV);
                    break;
                case 6:
                    System.out.println("Nhap chuc vu NV can tim: ");
                    String CvNVTK= nhap.nextLine();
                    NhanVien[] kqTKCvNV=dsnv.timTheoMa(CvNVTK);
                    dsnv.xuatKQTimKiem(kqTKCvNV);
                    break;
                case 7:
                    return;
            }
        }while(true);
    }
}
