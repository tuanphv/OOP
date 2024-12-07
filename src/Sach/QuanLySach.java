package Sach;
import java.util.Scanner;
import Format.ANSI;
import Validate.Validate;

public class QuanLySach {
    DSSach dsSach;
    public QuanLySach() {
        dsSach = new DSSach();
        if (dsSach.isEmpty()) {
            dsSach.docFile();
        }
    }

    public void hienThiMenu(Scanner in) {
        int chon = 0;
        do {
            System.out.println("");
            new ANSI(new String[]{"Menu Quan ly sach".toUpperCase()},
            new String[][]{
                {"1. Them sach"},
                {"2. Sua thong tin sach"},
                {"3. Xoa sach"},
                {"4. Tim kiem sach"},
                {"5. Hien thi danh sach sach"},
                {"6. Thoat"}}).printTable();
            chon = Validate.getChoice(in, 1, 6);
            switch (chon) {
                case 1:
                    dsSach.them();
                    break;
                case 2:
                    System.out.print("Nhap ma sach can sua: ");
                    String maSachSua = in.nextLine();
                    dsSach.edit(maSachSua);
                    break;
                case 3:
                    System.out.print("Nhap ma sach can xoa: ");
                    String maSachXoa = in.nextLine();
                    dsSach.remove(maSachXoa);
                    break;
                case 4:
                    menuTimKiem(dsSach, in);
                    break;
                case 5:
                    dsSach.xuat();
                    break;
                default:
                    System.out.println("Da thoat quan ly sach");
                    return;
            }
        } while (true);
    }

    public void menuTimKiem(DSSach dsSach, Scanner in) {
        int chonTim = 0;
        do {
            System.out.println("");
            new ANSI(new String[]{"Chon cach tim kiem".toUpperCase()},
            new String[][]{
                {"1. Tim theo ma sach"},
                {"2. Tim theo ten sach"},
                {"3. Tim theo nam xuat ban"},
                {"4. Tim theo khoang gia"},
                {"5. Thoat"}}).printTable();
            chonTim = Validate.getChoice(in, 1, 5);
            switch (chonTim) {
                case 1:
                    System.out.print("Nhap ma sach can tim: ");
                    String maSachTim = in.nextLine();
                    DSSach ds1 = new DSSach();
                    Sach kq = ds1.get(maSachTim);
                    if (kq!=null) kq.xuat();
                    else System.out.println("Khong tim thay sach");
                    break;
                case 2:
                    System.out.print("Nhap ten sach can tim: ");
                    String tenSach = in.nextLine();
                    DSSach.xuatKQTimKiem(dsSach.timTheoTenSach(tenSach));
                    break;
                case 3:
                    System.out.print("Nhap nam xuat ban can tim: ");
                    int namXB = Integer.parseInt(in.nextLine());
                    DSSach.xuatKQTimKiem(dsSach.timTheoNamXB(namXB));
                    break;
                case 4:
                    System.out.println("Nhap khoang gia can tim: ");
                    System.out.print("Tu:");
                    int giaMin = Integer.parseInt(in.nextLine());
                    System.out.print("Den:");
                    int giaMax = Integer.parseInt(in.nextLine());
                    DSSach.xuatKQTimKiem(dsSach.timTheoDonGia(giaMin, giaMax));
                    break;
                default:
                    System.out.println("Ket thuc tim kiem");
                    return;
            }
        } while (true);
    }
}
