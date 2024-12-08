package PhieuPhat;


import java.util.Scanner;
import Format.ANSI;
import Validate.Validate;
import Sach.DSSach;


public class QuanLyPhieuPhat {
    DSPhieuPhat dsPhieuPhat;

    public QuanLyPhieuPhat() {
        dsPhieuPhat = new DSPhieuPhat();
        if (dsPhieuPhat.isEmpty()) {
            dsPhieuPhat.docFile();
        }
    }

    public void hienThiMenu(Scanner in) {
        int chon = 0;
        do {
            hienThiMenuChinh();
            chon = Validate.getChoice(in, 1, 6);
            switch (chon) {
                case 1:
                    dsPhieuPhat.nhap();
                    break;
                case 2:
                    suaPhieuPhat(in);
                    break;
                case 3:
                    xoaPhieuPhat(in);
                    break;
                case 4:
                    menuTimKiem(dsPhieuPhat, in);
                    break;
                case 5:
                    dsPhieuPhat.xuat();
                    break;
                default:
                    System.out.println("Đã thoát quản lý phiếu phạt");
                    return;
            }
        } while (true);
    }

    private void hienThiMenuChinh() {
        System.out.println("");
        new ANSI(new String[]{"menu quan ly phieu phat".toUpperCase()},
            new String[][]{
                {"1. Thêm phiếu phạt"},
                {"2. Sửa thông tin phiếu phạt"},
                {"3. Xóa phiếu phạt"},
                {"4. Tìm kiếm phiếu phạt"},
                {"5. Hiển thị danh sách phiếu phạt"},
                {"6. Thoát"}}).printTable();
    }

    private void suaPhieuPhat(Scanner in) {
        System.out.print("Nhập mã phiếu phạt cần sửa: ");
        String maPPSua = in.nextLine();
        dsPhieuPhat.edit(maPPSua);
    }

    private void xoaPhieuPhat(Scanner in) {
        System.out.print("Nhập mã phiếu phạt cần xóa: ");
        String maPPXoa = in.nextLine();
        dsPhieuPhat.remove(maPPXoa);
    }

    public void menuTimKiem(DSPhieuPhat dsPhieuPhat, Scanner in) {
        int chonTim = 0;
        do {
            System.out.println("");
            new ANSI(new String[]{"Chọn cách tìm kiếm".toUpperCase()},
            new String[][]{
                {"1. Tìm theo mã phiếu phạt"},
                {"2. Tìm theo mã độc giả"},
                {"3. Tìm theo mã nhân viên"},
                {"4. Thoát"}}).printTable();
            chonTim = Validate.getChoice(in, 1, 4);
            switch (chonTim) {
                case 1:
                    timKiemTheoMaPhieuPhat(in);
                    break;
                case 2:
                    timKiemTheoMaDocGia(in);
                    break;
                case 3:
                    timKiemTheoMaNhanVien(in);
                    break;
                default:
                    System.out.println("Kết thúc tìm kiếm");
                    return;
            }
        } while (true);
    }

    private void timKiemTheoMaDocGia(Scanner in) {
        System.out.print("Nhập mã độc giả cần tìm: ");
        String maDG = in.nextLine();
        PhieuPhat[] phieuPhatDG = dsPhieuPhat.timKiemMaDocGia(maDG);
        DSSach.xuatKQTimKiem(phieuPhatDG);
    }

    private void timKiemTheoMaNhanVien(Scanner in) {
        System.out.print("Nhập mã nhân viên cần tìm: ");
        String maNV = in.nextLine();
        PhieuPhat[] phieuPhatNV = dsPhieuPhat.timKiemMaNV(maNV);
        DSSach.xuatKQTimKiem(phieuPhatNV);
    }
}
