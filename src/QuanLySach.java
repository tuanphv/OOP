import java.util.Scanner;

public class QuanLySach {
    public void Menu(DSSach dsSach) {
        Scanner in = new Scanner(System.in);
        int chon = 0;
        System.out.println("Quan ly sach");
        do {
            System.out.println("1. Them sach");
            System.out.println("2. Xoa sach");
            System.err.println("3. Tim sach");
            System.out.println("4. Hien thi danh sach sach");
            System.out.println("5. Thoat");
            System.out.println("Chon: ");
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
                    int chonTim = 0;
                    do {
                        System.out.println("Chon cach tim kiem");
                        System.out.println("1. Tim theo ten sach");
                        System.out.println("2. Tim theo ma sach");
                        System.out.println("3. Tim theo nam xuat ban");
                        System.out.println("4. Tim theo khoang gia");
                        System.out.println("5. Thoat");
                        System.out.println("Chon: ");
                        chonTim = Integer.parseInt(in.nextLine());
                        switch (chonTim) {
                            case 1:
                                System.out.println("Nhap ten sach can tim: ");
                                String tenSach = in.nextLine();
                                dsSach.timTheoTenSach(tenSach);
                                break;
                            case 2:
                                System.out.println("Nhap ma sach can tim: ");
                                String maSachTim = in.nextLine();
                                dsSach.get(maSachTim);
                                break;
                            case 3:
                                System.out.println("Nhap nam xuat ban can tim: ");
                                int namXB = Integer.parseInt(in.nextLine());
                                new DSSach(dsSach.timTheoNamXB(namXB)).xuat();;
                                break;
                            case 4:
                                System.out.println("Nhap khoang gia can tim: ");
                                int giaMin = Integer.parseInt(in.nextLine());
                                int giaMax = Integer.parseInt(in.nextLine());
                                new DSSach(dsSach.timTheoDonGia(giaMin, giaMax)).xuat();;
                                break;
                            case 5:
                                System.out.println("Ket thuc tim kiem");
                                break;
                            default:
                                System.out.println("Chon sai! Vui long chon lai");
                                break;
                        }
                    } while (chonTim!=5);
                    break;
                case 4:
                    dsSach.xuat();
                    break;
                case 5:
                    System.out.println("Ket thuc");
                    break;
                default:
                    System.out.println("Chon sai! Vui long chon lai");
                    break;
            }
        } while (chon == 5);
        in.close();
    }
}
