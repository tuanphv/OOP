import Format.ANSI;
import NCC_NXB.DSNhaCC;
import Person.DSDocGia;
import Person.DSNhanVien;
import Person.DSTacGia;
import PhieuMuon.DSChiTietPM;
import PhieuMuon.DSPhieuMuon;
import PhieuMuon.QuanLyPhieuMuon;
import PhieuNhap.DSChiTietPN;
import PhieuNhap.DSPhieuNhap;
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

    //DSPhieuPhat dsPhieuPhat = new DSPhieuPhat();
    //DSChiTietPP dsChiTietPP = new DSChiTietPP();

    DSDocGia dsDocGia = new DSDocGia();
    DSNhanVien dsNhanVien = new DSNhanVien();
    DSNhaCC dsNhaCC = new DSNhaCC();
    DSTacGia dsTacGia = new DSTacGia();
    public Menu() {
    }

    private void docFile() {
        dsSach.docFile();

        dsPhieuMuon.docFile();
        dsChiTietPM.docFile();

        dsPhieuNhap.docFile();
        dsChiTietPN.docFile();

        //dsPhieuPhat.docFile();
        //dsChiTietPP.docFile();

        dsDocGia.docFile();
        dsNhanVien.docFile();
        dsNhaCC.docFile();

        dsTacGia.docFile();
        
    }

    private void ghiFile() {
        dsSach.ghiFile();

        dsPhieuMuon.ghiFile();
        dsChiTietPM.ghiFile();

        dsPhieuNhap.ghiFile();
        dsChiTietPN.ghiFile();

        //dsPhieuPhat.ghiFile();
        //dsChiTietPP.ghiFile();

        dsTacGia.ghiFile();
        dsDocGia.ghiFile();
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
                            { "6. Quan ly doc gia"},
                            { "7. Thoat" }
                    }).printTable();
            int choice = Validate.getChoice(scanner, 1, 7);
            switch (choice) {
                case 1:
                    new QuanLySach().hienThiMenu(scanner);
                    break;
                case 2:
                    new QuanLyPhieuMuon(dsPhieuMuon, dsChiTietPM).hienThiMenu(scanner);
                    break;
                case 3:
                    //new QuanLyPhieuPhat(dsPhieuPhat, dsChiTietPP).hienThiMenu();
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
                    System.out.println("Thoat chuong trinh.");
                    ghiFile();
                    return;
                default:
                    System.out.println("Chon sai! Vui long chon lai");
                    break;
            }
        } while (true);
    }
}
