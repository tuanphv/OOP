import Format.ANSI;
import NCC_NXB.DSNhaCC;
import NCC_NXB.DSNhaXuatBan;
import Person.DSDocGia;
import Person.DSNhanVien;
import Person.DSTacGia;
import Person.QuanLyNhanVien;
import PhieuMuon.DSChiTietPM;
import PhieuMuon.DSPhieuMuon;
import PhieuMuon.QuanLyPhieuMuon;
import PhieuNhap.DSChiTietPN;
import PhieuNhap.DSPhieuNhap;
import PhieuNhap.QuanLyPhieuNhap;
import Sach.DSSach;
import Sach.QuanLySach;
import Validate.Validate;
import java.util.Scanner;

public class Menu {
    DSSach dsSach = new DSSach();

    DSPhieuMuon dsPhieuMuon = new DSPhieuMuon();
    DSChiTietPM dsChiTietPM = new DSChiTietPM();

    DSPhieuNhap dsPhieuNhap = new DSPhieuNhap();
    DSChiTietPN dsChiTietPN = new DSChiTietPN();

    // DSPhieuPhat dsPhieuPhat = new DSPhieuPhat();
    // DSChiTietPP dsChiTietPP = new DSChiTietPP();

    DSDocGia dsDocGia = new DSDocGia();
    DSNhanVien dsNhanVien = new DSNhanVien();
    DSTacGia dsTacGia = new DSTacGia();
    DSNhaCC dsNhaCC = new DSNhaCC();
    DSNhaXuatBan dsNXB = new DSNhaXuatBan();

    public Menu() {
    }

    private void docFile() {
        dsSach.docFile();

        dsPhieuMuon.docFile();
        dsChiTietPM.docFile();

        dsPhieuNhap.docFile();
        dsChiTietPN.docFile();

        // dsPhieuPhat.docFile();
        // dsChiTietPP.docFile();

        dsDocGia.docFile();
        dsNhanVien.docFile();
        dsNhaCC.docFile();
        dsNXB.docFile();
        dsTacGia.docFile();

    }

    private void ghiFile() {
        dsSach.ghiFile();

        dsPhieuMuon.ghiFile();
        dsChiTietPM.ghiFile();

        dsPhieuNhap.ghiFile();
        dsChiTietPN.ghiFile();

        // dsPhieuPhat.ghiFile();
        // dsChiTietPP.ghiFile();
        dsNXB.ghiFile();
        dsTacGia.ghiFile();
        dsDocGia.ghiFile();
        dsNhanVien.ghiFile();
        dsNhaCC.ghiFile();
    }

    public void hienThiMenu() {
        docFile();
        do {
            Scanner scanner = new Scanner(System.in);
            new ANSI(new String[] { "Menu chinh".toUpperCase() },
                    new String[][] {
                            { "1. Quan ly sach" },
                            { "2. Quan ly phieu muon" },
                            { "3. Quan ly phieu nhap" },
                            { "4. Quan ly phieu phat" },
                            { "5. Quan ly tac gia" },
                            { "6. Quan ly doc gia" },
                            { "7. Quan ly nhan vien" },
                            { "8. Quan ly nha cung cap" },
                            { "9. Quan ly nha xuat ban" },
                            { "10. Thoat va luu file" }
                    }).printTable();
            int choice = Validate.getChoice(scanner, 1, 10);
            switch (choice) {
                case 1:
                    new QuanLySach().hienThiMenu(scanner);
                    break;
                case 2:
                    new QuanLyPhieuMuon(dsPhieuMuon, dsChiTietPM).hienThiMenu(scanner);
                    break;
                case 3:
                    new QuanLyPhieuNhap(dsPhieuNhap, dsChiTietPN, dsSach, dsNhanVien, dsNhaCC).hienThiMenu();
                    break;
                case 4:
                    // new MenuPhieuPhat(dsPhieuPhat, dsChiTietPP).hienThiMenu();
                    break;
                case 5:
                    dsTacGia.hienThiMenu(scanner);
                    break;
                case 6:
                    dsDocGia.hienThiMenu(scanner);
                    break;
                case 7:
                    dsNhanVien.menu();
                    break;
                case 8:
                    dsNhaCC.menu();
                    break;
                case 9:
                    dsNXB.menu(scanner);
                    break;
                default:
                    System.out.println("Thoat chuong trinh.");
                    ghiFile();
                    return;
            }
        } while (true);
    }
}
