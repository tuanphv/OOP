package PhieuMuon;

import java.util.Scanner;

import Format.ANSI;
import Validate.Validate;

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
                            { "3. Tro lai" }
                    }).printTable();
            int choice = Validate.getChoice(scanner, 1, 3);
            switch (choice) {
                case 1:
                    menuPhieuMuon(scanner);
                    break;
                case 2:
                    menuChiTietPhieuMuon(scanner);
                    System.out.println("Chức năng đang phát triển.");
                    break;
                default:
                    System.out.println("Thoát chương trình.");
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
                            { "6. Tro lai" }
                    }).printTable();
            choice = Validate.getChoice(scanner, 1, 6);

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
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
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
                            { "4. Tro lai" }
                    }).printTable();
            int choice = Validate.getChoice(scanner, 1, 4);
            switch (choice) {
                case 1:
                    System.out.print("Nhap ma phieu muon muon them chi tiet: ");
                    String maPM = scanner.nextLine();
                    dsChiTietPM.them(maPM);
                    break;
                case 2:
                    System.out.println("Chức năng đang phát triển.");
                    break;
                case 3:
                    System.out.println("Chức năng đang phát triển.");
                    break;
                default:
                    System.out.println("Thoát chương trình.");
                    return;
            }
        } while(true);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyPhieuMuon quanLyPhieuMuon = new QuanLyPhieuMuon();
        quanLyPhieuMuon.hienThiMenu(scanner);
        scanner.close();
    }
}
