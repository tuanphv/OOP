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
                        { "1. Them phieu Phat" },
                        { "2. Xoa phieu Phat" },
                        { "3. Xem thong tin phieu Phat" },
                        { "4. Xem tat ca phieu Phat" },
                        { "5. Tro lai" }
                }).printTable();

        choice = Validate.getChoice(scanner, 1, 5);

        switch (choice) {
            case 1:
                dsPhieuPhat.them();
            break;
            case 2:
               System.out.println("Nhập mã phiếu phạt muốn xóa: ");
               String maPP = scanner.nextLine();
               if (dsPhieuPhat.get(maPP) != null) {
               dsPhieuPhat.remove(maPP);
               System.out.println("Đã xóa phiếu phạt thành công.");
               } else {
               System.out.println("Không tìm thấy phiếu phạt này.");
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
                  ChiTietPhieuPhat newCTPP = new ChiTietPhieuPhat();
                  System.out.println("Nhập thông tin chi tiết phiếu phạt:");
                  newCTPP.nhap(scanner.nextLine()); 
                  if (dsChiTietPP.add(newCTPP)) {
                  System.out.println("Thêm chi tiết phiếu phạt thành công.");
                  } else {
                  System.out.println("Chi tiết phiếu phạt đã tồn tại!");
                  }
                break;

                case 2:
                    System.out.println("Chức năng đang phát triển.");
                    break;
                case 3:
                    System.out.println("Moi ban nhap ma phieu phat de xem chi tiet phieu phat: ");
                    String maphieuphat = scanner.nextLine();
                    ChiTietPhieuPhat ctpp = dsChiTietPP.get(maphieuphat);

                    if (ctpp != null) {
                        ctpp.xuat();
                    }
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
