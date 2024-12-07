package PhieuPhat;

import java.util.Scanner;

import Format.ANSI;
import Validate.Validate;

public class QuanLyPhieuPhat {
    private DSPhieuPhat dsPhieuPhat;
    private DSChiTietPP dsChiTietPP;
    private DSQuyDinhPhat dsQuyDinhPhat;

    public QuanLyPhieuPhat(DSPhieuPhat dsPhieuPhat, DSChiTietPP dsChiTietPP) {
        this.dsPhieuPhat = dsPhieuPhat;
        this.dsChiTietPP = dsChiTietPP;
        this.dsQuyDinhPhat = new DSQuyDinhPhat();
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
                            { "3. Quan ly quy dinh phat" },
                            { "4. Thoat" }
                    }).printTable();

            luaChon = Validate.getChoice(scanner, 1, 4);

            switch (luaChon) {
                case 1:
                    quanLyPhieuPhat(scanner);
                    break;
                case 2:
                    menuChiTietPhieuPhat(scanner);
                    break;
                case 3:
                    quanLyQuyDinhPhat(scanner);
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

    private void quanLyQuyDinhPhat(Scanner scanner) {
        while (true) {
            System.out.println("");
            new ANSI(new String[] { "Quan Ly Quy Dinh Phat" },
                    new String[][] {
                            { "1. Them quy dinh phat" },
                            { "2. Sua quy dinh phat" },
                            { "3. Xoa quy dinh phat" },
                            { "4. Xem danh sach quy dinh phat" },
                            { "5. Quay lai" }
                    }).printTable();

            int luaChon = Validate.getChoice(scanner, 1, 5);

            switch (luaChon) {
                case 1:
                    Quydinhphat quyMoi = new Quydinhphat();
                    quyMoi.Nhap(); // Nhap thong tin quy dinh phat moi
                    System.out.println("Quy dinh phat da duoc them.");
                    dsQuyDinhPhat.add(quyMoi);
                    System.out.println("Quy dinh phat da duoc them.");
                    break;
                case 2:
                    System.out.print("Nhap ma quy dinh phat can sua: ");
                    String maQDCanSua = scanner.nextLine();
                    dsQuyDinhPhat.edit(maQDCanSua);
                    break;
                case 3:
                    System.out.print("Nhap ma quy dinh phat can xoa: ");
                    String maQDCanXoa = scanner.nextLine();
                    dsQuyDinhPhat.remove(maQDCanXoa);
                    break;
                case 4:
                    if (dsQuyDinhPhat.isEmpty()) {
                        System.out.println("Danh sach quy dinh phat rong.");
                    } else {
                        System.out.println("Danh sach quy dinh phat:");
                        for (int i = 0; i < dsQuyDinhPhat.size(); i++) {
                            dsQuyDinhPhat.getList()[i].Xuat(); // Display the fine regulation
                        }
                    }
                    break;
                default:
                    System.out.println("Quay lai.");
                    return;
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
