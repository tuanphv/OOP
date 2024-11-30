import java.util.Scanner;

public class QuanLySach {
    public QuanLySach(DSSach dsSach) {
        Menu(dsSach);
    }

    public void Menu(DSSach dsSach) {
        if (dsSach.isEmpty()) {
            dsSach = new DSSach();
            dsSach.docFile();
        }
        Scanner in = new Scanner(System.in);
        int chon = 0;
        do {
            System.out.println("\n<==== Menu Quan ly sach ====>");
            System.out.println("1. Them sach vao thu vien");
            System.out.println("2. Xoa sach khoi thu vien");
            System.err.println("3. Tim sach");
            System.out.println("4. Hien thi danh sach sach");
            System.out.println("5. Thoat");
            System.out.print("Chon chuc nang: ");
            chon = Integer.parseInt(in.nextLine());
            switch (chon) {
                case 1:
                    dsSach.them();
                    break;
                case 2:
                    System.out.println("Nhap ma sach can xoa: ");
                    String maSachXoa = in.nextLine();
                    dsSach.remove(dsSach.get(maSachXoa));
                    break;
                case 3:
                    MenuTimKiem(dsSach, in);
                    break;
                case 4:
                    dsSach.xuat();
                    break;
                case 5:
                    System.out.println("Da thoat quan ly sach");
                    dsSach.ghiFile();
                    break;
                default:
                    System.out.println("Chon sai! Vui long chon lai");
                    break;
            }
        } while (chon != 5);
        in.close();
    }

    public void MenuTimKiem(DSSach dsSach, Scanner in) {
        int chonTim = 0;
        do {
            System.out.println("\n<==== Chon cach tim kiem ====>");
            System.out.println("1. Tim theo ten sach");
            System.out.println("2. Tim theo ma sach");
            System.out.println("3. Tim theo nam xuat ban");
            System.out.println("4. Tim theo khoang gia");
            System.out.println("5. Thoat");
            System.out.print("Chon chuc nang: ");
            chonTim = Integer.parseInt(in.nextLine());
            switch (chonTim) {
                case 1:
                    System.out.print("Nhap ten sach can tim: ");
                    String tenSach = in.nextLine();
                    DSSach kqua = new DSSach(dsSach.timTheoTenSach(tenSach));
                    if (kqua.isEmpty())
                        System.out.println("Khong tim thay sach");
                    else
                        kqua.xuat();
                    break;
                case 2:
                    System.out.print("Nhap ma sach can tim: ");
                    String maSachTim = in.nextLine();
                    dsSach.get(maSachTim).xuat();;
                    break;
                case 3:
                    System.out.print("Nhap nam xuat ban can tim: ");
                    int namXB = Integer.parseInt(in.nextLine());
                    new DSSach(dsSach.timTheoNamXB(namXB)).xuat();
                    break;
                case 4:
                    System.out.println("Nhap khoang gia can tim: ");
                    System.out.print("Tu:");
                    int giaMin = Integer.parseInt(in.nextLine());
                    System.out.print("Den:");
                    int giaMax = Integer.parseInt(in.nextLine());
                    new DSSach(dsSach.timTheoDonGia(giaMin, giaMax)).xuat();
                    break;
                case 5:
                    System.out.println("Ket thuc tim kiem");
                    break;
                default:
                    System.out.println("Chon sai! Vui long chon lai");
                    break;
            }
        } while (chonTim != 5);
    }
}
