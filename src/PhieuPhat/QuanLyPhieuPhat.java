package PhieuPhat;

import Format.ANSI;
import Validate.Validate;
import java.util.Scanner;

public class QuanLyPhieuPhat {
    private DSPhieuPhat dsPhieuPhat;
    private DSChiTietPP dsChiTietPP;

    public QuanLyPhieuPhat() {
        dsPhieuPhat = new DSPhieuPhat();
        if (dsPhieuPhat.isEmpty()) {
            dsPhieuPhat.docFile();
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
                    System.out.println("chuc nang phat trien sau");
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
                        { "1. Xem thong tin phieu Phat" },
                        { "2. Xem tat ca phieu Phat" },
                        { "3. Tro lai" }
                }).printTable();

        choice = Validate.getChoice(scanner, 1, 3);

        switch (choice) {
            case 1:
               
                break;
            case 2:
                
                break;
            case 3:
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
                            { "1. Them chi tiet phieu Phat" },
                            { "2. Xoa chi tiet phieu Phat" },
                            { "3. Xem chi tiet phieu Phat" },
                            { "4. Hien thi toan bo chi tiet Phieu Phat" },
                            { "5. Tro lai" }
                    }).printTable();
            int choice = Validate.getChoice(scanner, 1, 5);
            switch (choice) {
                case 1:
                    
                    break;
                case 2:
                    System.out.println("Chức năng đang phát triển.");
                    break;
                case 3:
                    System.out.println("Chức năng đang phát triển.");
                    break;
                case 4:
                    dsChiTietPP.xuat();
                    break;
                default:
                    System.out.println("Thoát chương trình.");
                    return;
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
