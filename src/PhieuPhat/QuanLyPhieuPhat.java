package PhieuPhat;

import Format.ANSI;
import PhieuMuon.DSChiTietPM;
import Validate.Validate;
import java.util.Scanner;

public class QuanLyPhieuPhat {
    private DSPhieuPhat dsPhieuPhat;
    private DSChiTietPP dsChiTietPP;

    public QuanLyPhieuPhat() {
        DSChiTietPM dsChiTietPM = new DSChiTietPM();
        dsChiTietPM.docFile();

        dsChiTietPP = new DSChiTietPP();
        if (dsChiTietPP.isEmpty()) {
            dsChiTietPP.docFile();
        }

        dsChiTietPP = new DSChiTietPP();
        if (dsChiTietPP.isEmpty()) {
            dsChiTietPP.docFile();
        }
    }

    public QuanLyPhieuPhat(DSPhieuPhat dsPhieuPhat, DSChiTietPP dsChiTietPP) {
        this.dsPhieuPhat = dsPhieuPhat;
        this.dsChiTietPP = dsChiTietPP;
    }

    public void hienThiMenu(Scanner scanner) {
        do {
            new ANSI(new String[] { "Menu Quan ly phieu Phat".toUpperCase() },
                    new String[][] {
                            { "1. Quan ly phieu Phat" },
                            { "2. Quan ly chi tiet phieu Phat" },
                            { "3. Thong ke Phieu Phat" },
                            { "4. Tro lai" }
                    }).printTable();
            int choice = Validate.getChoice(scanner, 1, 4);
            switch (choice) {
                case 1:
                    menuPhieuPhat(scanner);
                    break;
                case 2:
                    menuChiTietPhieuPhat(scanner);
                    break;
                case 3:
                    menuThongKePhat(scanner);
                    break;
                default:
                    System.out.println("Thoat Quan ly phieu Phat.");
                    return;
            }
        } while (true);
    }

    public void menuPhieuPhat(Scanner scanner) {
        int choice;
        do {
            new ANSI(new String[] { "Menu Quan ly phieu Phat".toUpperCase() },
                    new String[][] {
                            { "1. Them phieu Phat" },
                            { "2. Xoa phieu Phat" },
                            { "3. Xem thong tin phieu Phat" },
                            { "4. Xem tat ca phieu Phat" },
                            { "5. Sua phieu phat" },
                            { "6. Tro lai" }

                    }).printTable();

            choice = Validate.getChoice(scanner, 1, 6);

            switch (choice) {
                case 1:
                    dsPhieuPhat.them();
                    break;
                case 2:
                    System.out.println("nhap ma phieu phat can xoa: ");
                    String maPP = scanner.nextLine();
                    if (dsPhieuPhat.get(maPP) != null) {
                        dsPhieuPhat.remove(maPP);
                        System.out.println("da xoa phieu phat thanh cong.");
                    } else {
                        System.out.println("khong tim thay phieu phat nay.");
                    }
                    break;
                case 3:
                    System.out.println("nhap ma phieu phat can xem: ");
                    String maPPxem = scanner.nextLine();
                    PhieuPhat phieuphat = dsPhieuPhat.get(maPPxem);
                    if (phieuphat != null) {
                        phieuphat.xuat();
                    } else {
                        System.out.println("khong tim thay phieu phat co ma: " + maPPxem);
                    }
                    break;
                case 4:
                    System.out.println("Danh sach phieu phat: ");
                    dsPhieuPhat.xuat();
                    break;
                case 5:
                    System.out.println("Moi ban nhap ma phieu phat can sua: ");
                    String masua = scanner.nextLine();
                    if (dsPhieuPhat.get(masua) != null) {
                        dsPhieuPhat.edit(masua);
                    } else {
                        System.out.println("khong tim thay !!");
                    }
                    break;
                case 6:
                    System.out.println("Thoat Menu Quan ly phieu Phat.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (true);
    }

    private void menuChiTietPhieuPhat(Scanner scanner) {
        do {
            new ANSI(new String[] { "Menu Quan ly chi tiet phieu Phat".toUpperCase() },
                    new String[][] {
                            { "1. Xem chi tiet cua phieu phat" },
                            { "2. Hien thi toan bo chi tiet Phieu Phat" },
                            { "3. Them chi tiet phieu phat" },
                            { "4. Xoa tat ca chi tiet phieu phat cua phieu phat" },
                            { "5. Xoa mot chi tiet phieu phat cua phieu phat" },
                            { "6. Sua chi tiet phieu phat" },
                            { "7. Tro lai" }
                    }).printTable();
            int choice = Validate.getChoice(scanner, 1, 7);
            switch (choice) {

                case 1:
                    System.out.print("Nhap ma phieu phat muon xem chi tiet: ");
                    String maphieuphat = scanner.nextLine();
                    dsChiTietPP.xuatKQ(dsChiTietPP.timKiemMaPP(maphieuphat));
                    break;
                case 2:
                    dsChiTietPP.xuat();
                    break;
                case 3:
                    System.out.print("Nhap ma phieu phat can them chi tiet: ");
                    String maPP = scanner.nextLine();
                    dsChiTietPP.them(maPP);
                    break;
                case 4:
                    System.out.print("Nhap ma chi tiet phieu phat can xoa: ");
                    String maPPXoa = scanner.nextLine();
                    if (dsChiTietPP.indexOf(maPPXoa) != -1) {
                        dsChiTietPP.remove(maPPXoa);
                        System.out.println("Da xoa chi tiet phieu phat thanh cong.");
                    } else {
                        System.out.println("Khong tim thay chi tiet phieu phat nay.");
                    }
                    break;
                case 5:
                    System.out.print("Nhap ma chi tiet phieu phat can xoa: ");
                    String maCTPPXoa = scanner.nextLine();
                    System.out.print("Nhap ma sach can xoa: ");
                    String maSach = scanner.nextLine();
                    if (dsChiTietPP.indexOf(maCTPPXoa, maSach) != -1) {
                        dsChiTietPP.remove(maCTPPXoa, maSach);
                        System.out.println("Da xoa chi tiet phieu phat thanh cong.");
                    } else {
                        System.out.println("Khong tim thay chi tiet phieu phat nay.");
                    }
                    break;
                case 6:
                    System.out.print("Nhap ma chi tiet phieu phat can sua: ");
                    String maCTPPsua = scanner.nextLine();
                    String maSa = scanner.nextLine();
                    if (dsChiTietPP.indexOf(maCTPPsua, maSa) != -1) {
                        dsChiTietPP.edit(maCTPPsua, maSa);
                    } else {
                        System.out.println("Khong tim thay chi tiet phieu phat nay.");
                    }
                    break;
                default:
                    System.out.println("Thoát chương trình.");
                    return;
            }
        } while (true);
    }

    private void menuThongKePhat(Scanner scanner) {
        do {
            new ANSI(new String[] { "Menu thong ke phieu phat".toUpperCase() },
                    new String[][] {
                            { "1. Thong ke doc gia bi phat" },
                            { "2. Thong ke nhan vien lap phieu phat" },
                            { "3. So tien phat trung binh" },
                            { "4. Tong tien phat" },
                            { "5. Thong ke sach bi phat" },
                            { "6. Tro lai" }
                    }).printTable();
            int choice = Validate.getChoice(scanner, 1, 6);
            switch (choice) {
                case 1:
                    System.out.println("\nThong ke doc gia bi phat:");
                    dsPhieuPhat.thongKeDocGiaBiPhat().forEach(
                            (key, value) -> System.out.println("Ma doc gia: " + key + ", So lan bi phat: " + value));
                    break;
                case 2:
                    System.out.println("\nThong ke nhan vien lap phieu phat:");
                    dsPhieuPhat.thongKeNhanVienLapPhieuPhat().forEach((key, value) -> System.out
                            .println("Ma nhan vien: " + key + ", So phieu phat lap: " + value));
                    break;
                case 3:
                    System.out.println("\nSo tien phat trung binh: " + dsPhieuPhat.thongKeSoTienPhatTrungBinh());
                    break;
                case 4:
                    System.out.println("\nTong tien phat: " + dsPhieuPhat.thongKeTongTienPhat());
                    break;
                case 5:
                    System.out.println("Thong ke sach bi phat." + dsChiTietPP.thongkesachbiphat());
                    return;
                case 6:
                    System.out.println("Quay lai menu chinh.");
                    return;
                default:
                    System.out.println("Lua chon ko hop le!!.");
                    break;
            }
        } while (true);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyPhieuPhat quanLyPhieuPhat = new QuanLyPhieuPhat();
        quanLyPhieuPhat.hienThiMenu(scanner);
        scanner.close();
    }
}
