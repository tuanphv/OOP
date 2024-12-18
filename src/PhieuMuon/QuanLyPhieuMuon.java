package PhieuMuon;

import Format.ANSI;
import Validate.Validate;
import java.util.Scanner;

public class QuanLyPhieuMuon {
    private DSPhieuMuon dsPhieuMuon;
    private DSChiTietPM dsChiTietPM;

    public QuanLyPhieuMuon() {
        dsPhieuMuon = new DSPhieuMuon();
        if (dsPhieuMuon.isEmpty()) {
            dsPhieuMuon.docFile();
        }
        dsChiTietPM = new DSChiTietPM();
        if (dsChiTietPM.isEmpty()) {
            dsChiTietPM.docFile();
        }
    }

    public QuanLyPhieuMuon(DSPhieuMuon dsPhieuMuon, DSChiTietPM dsChiTietPM) {
        this.dsPhieuMuon = dsPhieuMuon;
        this.dsChiTietPM = dsChiTietPM;
    }

    public void hienThiMenu(Scanner scanner) {
        do {
            new ANSI(new String[] { "Menu Quan ly phieu muon".toUpperCase() },
                    new String[][] {
                            { "1. Quan ly phieu muon" },
                            { "2. Quan ly chi tiet phieu muon" },
                            { "3. Thong ke sach da muon" },
                            { "4. Tro lai" }
                    }).printTable();
            int choice = Validate.getChoice(scanner, 1, 4);
            switch (choice) {
                case 1:
                    menuPhieuMuon(scanner);
                    break;
                case 2:
                    menuChiTietPhieuMuon(scanner);
                    break;
                case 3:
                    thongKeSachDaMuon(scanner);
                    break;
                default:
                    System.out.println("Thoat Quan ly phieu muon.");
                    return;
            }
        } while (true);
    }

    public void menuPhieuMuon(Scanner scanner) {
        int choice;
        do {
            new ANSI(new String[] { "Menu Quan ly phieu muon".toUpperCase() },
                    new String[][] {
                            { "1. Muon sach" },
                            { "2. Tra sach" },
                            { "3. Xem thong tin phieu muon" },
                            { "4. Xem thong tin phieu muon cua khach hang" },
                            { "5. Xem tat ca phieu muon" },
                            { "6. Xem phieu muon trong khoang thoi gian" },
                            { "7. Tro lai" }
                    }).printTable();
            choice = Validate.getChoice(scanner, 1, 7);

            switch (choice) {
                case 1:
                    dsPhieuMuon.them();
                    break;
                case 2:
                    System.out.println("Nhap ma phieu muon: ");
                    String maPhieuTra = scanner.nextLine();
                    System.out.println("Nhap ma sach can tra: ");
                    String maSach = scanner.nextLine();
                    dsChiTietPM.traSach(maPhieuTra, maSach);
                    break;
                case 3:
                    System.out.print("Nhap ma phieu muon can xem: ");
                    String maPhieuMuon = scanner.nextLine();
                    PhieuMuon phieuMuon = dsPhieuMuon.get(maPhieuMuon);
                    if (phieuMuon != null) {
                        phieuMuon.xuat();
                    } else {
                        System.out.println("Không tìm thấy phiếu mượn có mã " + maPhieuMuon);
                    }
                    break;
                case 4:
                    System.out.print("Nhap ma doc gia: ");
                    String maDocGia = scanner.nextLine();
                    dsPhieuMuon.xuatKQ(dsPhieuMuon.timKiemMaDocGia(maDocGia));
                    break;
                case 5:
                    dsPhieuMuon.xuat();
                    break;
                case 6:
                    System.out.print("Nhap ngay bat dau (dd/MM/yyyy): ");
                    String ngayBatDau = scanner.nextLine();
                    System.out.print("Nhap ngay ket thuc (dd/MM/yyyy): ");
                    String ngayKetThuc = scanner.nextLine();
                    dsPhieuMuon.xuatKQ(dsPhieuMuon.timTrongKhoangTG(ngayBatDau, ngayKetThuc));
                    break;
                default:
                    System.out.println("Thoat Menu Quan ly phieu muon.");
                    return;
            }
        } while (true);
    }

    private void menuChiTietPhieuMuon(Scanner scanner) {
        do {
            new ANSI(new String[] { "Menu Quan ly chi tiet phieu muon".toUpperCase() },
                    new String[][] {
                            { "1. Them chi tiet phieu muon" },
                            { "2. Xoa chi tiet phieu muon" },
                            { "3. Xem chi tiet phieu muon" },
                            { "4. Hien thi toan bo chi tiet" },
                            { "5. Tro lai" }
                    }).printTable();
            int choice = Validate.getChoice(scanner, 1, 5);
            switch (choice) {
                case 1:
                    System.out.print("Nhap ma phieu muon muon them chi tiet: ");
                    String maPM = scanner.nextLine();
                    dsChiTietPM.them(maPM);
                    break;
                case 2:
                    System.out.print("Nhap ma phieu muon can xoa chi tiet: ");
                    String maPMXoa = scanner.nextLine();
                    System.out.print("Nhap ma sach can xoa: ");
                    String maSach = scanner.nextLine();
                    dsChiTietPM.xoa(maPMXoa, maSach);
                    break;
                case 3:
                    System.out.println("Nhap ma phieu muon can xem chi tiet: ");
                    String maPMXem = scanner.nextLine();
                    dsChiTietPM.xuatKQ(dsChiTietPM.timTheoMaPM(maPMXem));
                    break;
                case 4:
                    dsChiTietPM.xuat();
                    break;
                default:
                    System.out.println("Thoát chương trình.");
                    return;
            }
        } while (true);
    }
    
   private void thongKeSachDaMuon(Scanner scanner) {
    do {
        new ANSI(new String[] { "MENU THONG KE".toUpperCase() },
                new String[][] {
                        { "1. Thong ke sach theo ngay" },
                        { "2. Thong ke sach theo thang" },
                        { "3. Thong ke sach theo quy" },
                        { "4. Thong ke sach theo nam" },
                        { "5. Tro lai" }
                }).printTable();
        int choice = Validate.getChoice(scanner, 1, 5);
        switch (choice) {
            case 1:
                thongKeSachTheoNgayMenu(scanner);
                break;
            case 2:
                thongKeSachTheoThangMenu(scanner);
                break;
            case 3:
                thongKeSachTheoQuyMenu(scanner);
                break;
            case 4:
                thongKeSachTheoNamMenu(scanner);
                break;
            default:
                System.out.println("Thoát chương trình.");
                return;
        }
    } while (true);
}

private void thongKeSachTheoNgayMenu(Scanner scanner) {
    System.out.print("Nhap ngay can xem (dd/MM/yyyy): ");
    String ngayCanXem = scanner.nextLine();
    dsChiTietPM.thongKeSachTheoNgay(ngayCanXem);
}

private void thongKeSachTheoThangMenu(Scanner scanner) {
    System.out.print("Nhap thang (1-12): ");
    int thang = scanner.nextInt();
    System.out.print("Nhap nam: ");
    int nam = scanner.nextInt();
    scanner.nextLine();  // Đọc dấu enter còn sót lại
    dsChiTietPM.thongKeSachTheoThang(thang, nam);
}

private void thongKeSachTheoQuyMenu(Scanner scanner) {
    System.out.print("Nhap quy (1-4): ");
    int quy = scanner.nextInt();
    System.out.print("Nhap nam: ");
    int nam = scanner.nextInt();
    scanner.nextLine();  // Đọc dấu enter còn sót lại
    dsChiTietPM.thongKeSachTheoQuy(quy, nam);
}

private void thongKeSachTheoNamMenu(Scanner scanner) {
    System.out.print("Nhap nam can xem: ");
    int nam = scanner.nextInt();
    scanner.nextLine();  // Đọc dấu enter còn sót lại
    dsChiTietPM.thongKeSachTheoNam(nam);
}

    // private void thongKeSachDaMuon(Scanner scanner) {
    //     int nam = Validate.getNumber(scanner, "Nhap nam can thong ke: ");
    //     thongKeSachDaMuon(nam);
    // }

    // public void thongKeSachDaMuon(int nam) {
    //     int[] quy = new int[4];
    //     for (ChiTietPhieuMuon ctpm : dsChiTietPM.getList()) {
    //         // lấy ngày mượn từ mã phiếu mượn
    //         Ngay ngayMuon = new Ngay(dsPhieuMuon.get(ctpm.getMaPM()).getNgayMuon());
    //         if (ngayMuon.getYear() == nam) {
    //             quy[ngayMuon.getQuy() - 1] += ctpm.getSoLuong();
    //         }
    //     }
    //     String[] header = { "Quy", "So luong sach da muon" };
    //     String[][] data = new String[4][2];
    //     for (int i = 0; i < 4; i++) {
    //         data[i][0] = "Quy " + (i + 1);
    //         data[i][1] = String.valueOf(quy[i]);
    //     }
    //     new ANSI(header, data).printTable();
    //     ANSI.pause();
    // }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyPhieuMuon quanLyPhieuMuon = new QuanLyPhieuMuon();
        quanLyPhieuMuon.hienThiMenu(scanner);
        scanner.close();
    }
}
