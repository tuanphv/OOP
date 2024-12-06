package PhieuPhat;

import java.util.Scanner;

import Format.ANSI;

public class QuanLyPhieuPhat {
    private DSPhieuPhat dsPhieuPhat;
    private DSQuyDinhPhat dsQuyDinhPhat;

    public QuanLyPhieuPhat() {
        dsPhieuPhat = new DSPhieuPhat();
        dsQuyDinhPhat = new DSQuyDinhPhat();
        if (dsPhieuPhat.isEmpty()) {
            dsPhieuPhat.docFile();
        }
        if (dsQuyDinhPhat.isEmpty()) {
            dsQuyDinhPhat.docFile();
        }
    }

    public void hienThiMenu() {
        Scanner scanner = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("");
            new ANSI(new String[] { "Menu Quan Ly Phat" },
                    new String[][] {
                            { "1. Quan ly phieu phat" },
                            { "2. Quan ly quy dinh phat" },
                            { "3. Thoat" }
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
            System.out.println("");
            new ANSI(new String[] { "Quan Ly Phieu Phat" },
                    new String[][] { 
                            { "1. Them phieu phat" },
                            { "2. Sua phieu phat" },
                            { "3. Xoa phieu phat" },
                            { "4. Xem phieu phat cu the"},
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
            System.out.print("Chon thao tac: ");

            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Xoa bo dem

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
                case 5:
                    System.out.println("Quay lai.");
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
