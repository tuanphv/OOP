package PhieuPhat;
import java.util.Scanner;

import Format.ANSI;

public class QuanLyPhieuPhat {
    private DSPhieuPhat dsPhieuPhat;
    private DSQuyDinhPhat dsQuyDinhPhat;

    public QuanLyPhieuPhat() {
        dsPhieuPhat = new DSPhieuPhat();
        dsQuyDinhPhat = new DSQuyDinhPhat();
    }

    public void hienThiMenu() {
        Scanner scanner = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("");
            new ANSI(new String[] {"Menu Quan Ly Phat"},
            new String[][]{
                {"1. Quan ly phieu phat"},
                {"2. Quan ly quy dinh phat"},
                {"3. Thoat"}
            }).printTable();
            System.out.print("Chon thao tac: ");
            
            luaChon = Integer.parseInt(scanner.nextLine());

            switch (luaChon) {
                case 1:
                    quanLyPhieuPhat(scanner);
                    break;
                case 2:
                    quanLyQuyDinhPhat(scanner);
                    break;
                case 3:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        } while (luaChon != 3);
    }

    private void quanLyPhieuPhat(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Quan Ly Phieu Phat ---");
            System.out.println("1. Doc du lieu tu file");
            System.out.println("2. Ghi du lieu vao file");
            System.out.println("3. Them phieu phat");
            System.out.println("4. Xoa phieu phat");
            System.out.println("5. Xem danh sach phieu phat");
            System.out.println("6. Quay lai");
            System.out.print("Chon thao tac: ");
            
            int luaChon = scanner.nextInt();
            scanner.nextLine();  // Xoa bo dem

            switch (luaChon) {
                case 1:
                    dsPhieuPhat.docFile();
                    System.out.println("Du lieu da duoc doc tu file.");
                    break;
                case 2:
                    dsPhieuPhat.ghiFile();
                    System.out.println("Du lieu da duoc ghi vao file.");
                    break;
                case 3:
                    Phieuphat phieuMoi = new Phieuphat();
                    phieuMoi.nhap();  // Nhap thong tin phieu phat moi
                    dsPhieuPhat.add(phieuMoi);
                    System.out.println("Phieu phat da duoc them.");
                    break;
                case 4:
                    System.out.print("Nhap ma phieu phat can xoa: ");
                    String maPPCanXoa = scanner.nextLine();
                    dsPhieuPhat.remove(maPPCanXoa);
                    break;
                case 5:
                    if (dsPhieuPhat.isEmpty()) {
                        System.out.println("Danh sach phieu phat rong.");
                    } else {
                        System.out.println("Danh sach phieu phat:");
                        for (int i = 0; i < dsPhieuPhat.size(); i++) {
                            dsPhieuPhat.getList()[i].xuat();
                        }
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        }
    }

    private void quanLyQuyDinhPhat(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Quan Ly Quy Dinh Phat ---");
            System.out.println("1. Doc du lieu tu file");
            System.out.println("2. Ghi du lieu vao file");
            System.out.println("3. Them quy dinh phat");
            System.out.println("4. Xoa quy dinh phat");
            System.out.println("5. Xem danh sach quy dinh phat");
            System.out.println("6. Quay lai");
            System.out.print("Chon thao tac: ");
            
            int luaChon = scanner.nextInt();
            scanner.nextLine();  // Xoa bo dem

            switch (luaChon) {
                case 1:
                    dsQuyDinhPhat.docFile();
                    System.out.println("Du lieu da duoc doc tu file.");
                    break;
                case 2:
                    dsQuyDinhPhat.ghiFile();
                    System.out.println("Du lieu da duoc ghi vao file.");
                    break;
                case 3:
                    Quydinhphat quyMoi = new Quydinhphat();
               quyMoi.Nhap();  // Nhap thong tin quy dinh phat moi
                 System.out.println("Quy dinh phat da duoc them.");
                    dsQuyDinhPhat.add(quyMoi);
                    System.out.println("Quy dinh phat da duoc them.");
                    break;
                case 4:
                    System.out.print("Nhap ma quy dinh phat can xoa: ");
                    String maQDCanXoa = scanner.nextLine();
                    dsQuyDinhPhat.remove(maQDCanXoa);
                    break;
                case 5:
                    if (dsQuyDinhPhat.isEmpty()) {
                        System.out.println("Danh sach quy dinh phat rong.");
                    } else {
                        System.out.println("Danh sach quy dinh phat:");
                        for (int i = 0; i < dsQuyDinhPhat.size(); i++) {
                     dsQuyDinhPhat.getList()[i].Xuat(); // Display the fine regulation
                        }
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        }
    }

    public static void main(String[] args) {
        QuanLyPhieuPhat menu = new QuanLyPhieuPhat();
        menu.hienThiMenu();
    }
}
