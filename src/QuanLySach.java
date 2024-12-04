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
            new PrintTable(new String[]{"Menu Quan ly sach"},
            new String[][]{
                {"1. Them sach"},
                {"2. Sua thong tin sach"},
                {"3. Xoa sach"},
                {"4. Tim kiem sach"},
                {"5. Hien thi danh sach sach"},
                {"6. Thoat"}});
            System.out.print(PrintTable.formatText("Chon chuc nang: ", PrintTable.FG_COLOR.YELLOW, PrintTable.BG_COLOR.NONE, PrintTable.STYLE.BOLD));
            chon = Integer.parseInt(in.nextLine());
            switch (chon) {
                case 1:
                    dsSach.them();
                    break;
                case 2:
                    System.out.print("Nhap ma sach can sua: ");
                    String maSachSua = in.nextLine();
                    dsSach.suaSach(maSachSua);
                    break;
                case 3:
                    System.out.print("Nhap ma sach can xoa: ");
                    String maSachXoa = in.nextLine();
                    dsSach.remove(dsSach.get(maSachXoa));
                    break;
                case 4:
                    MenuTimKiem(dsSach, in);
                    break;
                case 5:
                    dsSach.xuat();
                    break;
                case 6:
                    System.out.println("Da thoat quan ly sach");
                    dsSach.ghiFile();
                    break;
                default:
                    System.out.println("Chon sai! Vui long chon lai");
                    break;
            }
        } while (chon != 6);
        in.close();
    }

    public void MenuTimKiem(DSSach dsSach, Scanner in) {
        int chonTim = 0;
        do {
            new PrintTable(new String[]{"Chon cach tim kiem"},
            new String[][]{
                {"1. Tim theo ma sach"},
                {"2. Tim theo ten sach"},
                {"3. Tim theo nam xuat ban"},
                {"4. Tim theo khoang gia"},
                {"5. Thoat"}});
            System.out.print("Chon chuc nang: ");
            chonTim = Integer.parseInt(in.nextLine());
            switch (chonTim) {
                case 1:
                    System.out.print("Nhap ma sach can tim: ");
                    String maSachTim = in.nextLine();
                    dsSach.get(maSachTim).xuat();
                    ;
                    break;
                case 2:
                    System.out.print("Nhap ten sach can tim: ");
                    String tenSach = in.nextLine();
                    new DSSach(dsSach.timTheoTenSach(tenSach)).xuat();
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
