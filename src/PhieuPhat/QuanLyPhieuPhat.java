package PhieuPhat;

import Format.ANSI;
import Validate.Validate;
import java.util.Scanner;

public class QuanLyPhieuPhat {
    private DSPhieuPhat dsPhieuPhat;
    private DSChiTietPP dsChiTietPP;

    public QuanLyPhieuPhat(DSPhieuPhat dsPhieuPhat, DSChiTietPP dsChiTietPP) {
        this.dsPhieuPhat = dsPhieuPhat;
        this.dsChiTietPP = dsChiTietPP;
    }

    public void hienThiMenu() {
        Scanner scanner = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("");
            new ANSI(new String[] { "Menu Quan Ly Phat" },
                    new String[][] {
                            { "1. Quan ly phieu phat" },
                            { "2. Quan ly chi tiet phieu phat" },
                            { "3. Thoat" }
                    }).printTable();

            luaChon = Validate.getChoice(scanner, 1, 4);

            switch (luaChon) {
                case 1:
                    quanLyPhieuPhat(scanner);
                    break;
                case 2:
                    menuChiTietPhieuPhat(scanner);
                    break;
                default:
                    System.out.println("Thoat chuong trinh.");
                    return;
            }
        } while (true);
    }

    private void quanLyPhieuPhat(Scanner scanner) {
        while (true) {
            System.out.println("");
            new ANSI(new String[] { "Quan Ly Phieu Phat" },
                    new String[][] {
                            { "1. Them phieu phat" },
                            { "2. Sua phieu phat" },
                            { "3. Xoa phieu phat" },
                            { "4. Xem phieu phat cu the" },
                            { "5. Xem danh sach phieu phat" },
                            { "6. Quay lai" } })
                    .printTable();
            System.out.print("Chon thao tac: ");

            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Xoa bo dem

            switch (luaChon) {
                case 1:
                    PhieuPhat phieuMoi = new PhieuPhat();
                    phieuMoi.nhap(); // Nhap thong tin phieu phat moi
                    dsPhieuPhat.add(phieuMoi);
                    System.out.println("Phieu phat da duoc them.");
                    break;
                case 2:
                    System.out.print("Nhap ma phieu phat can sua: ");
                    String maPPCanSua = scanner.nextLine();
                    dsPhieuPhat.edit(maPPCanSua);
                    break;
                case 3:
                    System.out.print("Nhap ma phieu phat can xoa: ");
                    String maPPCanXoa = scanner.nextLine();
                    dsPhieuPhat.remove(maPPCanXoa);
                    break;
                case 4:
                    System.out.print("Nhap ma phieu phat can xem: ");
                    String maPPCanXem = scanner.nextLine();
                    PhieuPhat phieuCanXem = dsPhieuPhat.get(maPPCanXem);
                    if (phieuCanXem != null) {
                        phieuCanXem.xuatChiTiet();
                    } else {
                        System.out.println("Khong tim thay phieu phat co ma " + maPPCanXem);
                    }
                    break;
                case 5:
                    dsPhieuPhat.xuat();
                    break;
                case 6:
                    System.out.println("Quay lai.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        }
    }

    private void menuChiTietPhieuPhat(Scanner scanner) {
        while (true) {
            System.out.println("");
            new ANSI(new String[] { "Menu Chi Tiet Phieu Phat" },
                    new String[][] {
                            { "1. Them chi tiet phieu phat" },
                            { "2. Sua chi tiet phieu phat" },
                            { "3. Xoa chi tiet phieu phat" },
                            { "4. Xem danh sach chi tiet phieu phat" },
                            { "5. Quay lai" } })
                    .printTable();
            int luaChon = Validate.getChoice(scanner, 1, 5);
            switch (luaChon) {
                case 1:
                    String maPP = Validate.checkExist(scanner, "Nhap ma phieu phat can them chi tiet: ",
                            ">> Ma phieu phat khong ton tai!", dsPhieuPhat.getList(), PhieuPhat::getMaPP);
                    dsChiTietPP.them(maPP);
                    break;
                case 2: case 3: case 4:
                    System.out.println("Chuc nang chua ho tro.");
                    break;
                default:
                    return;
            }
        }
    }
}
