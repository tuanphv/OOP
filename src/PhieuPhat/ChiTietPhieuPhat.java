package PhieuPhat;

import java.util.Scanner;

import PhieuMuon.DSChiTietPM;
import Sach.Sach;
import Validate.Validate;

public class ChiTietPhieuPhat {
    private String Mapp;
    private String Masach;
    private String Maqd;
    private int Tienphat;

    public ChiTietPhieuPhat() {
    }

    public ChiTietPhieuPhat(String mapp, String masach, String maqd, int tienphat) {
        this.Mapp = mapp;
        this.Masach = masach;
        this.Maqd = maqd;
        this.Tienphat = tienphat;
    }

    public ChiTietPhieuPhat(ChiTietPhieuPhat s1) {
        this.Mapp = s1.Mapp;
        this.Masach = s1.Masach;
        this.Maqd = s1.Maqd;
        this.Tienphat = s1.Tienphat;
    }

    public String getMaPP() {
        return Mapp;
    }

    public String getMaSach() {
        return Masach;
    }

    public String getMaQD() {
        return Maqd;
    }

    public int getTienPhat() {
        return Tienphat;
    }

    public void setMaPP(String mapp) {
        this.Mapp = mapp;
    }

    public void setMaSach(String masach) {
        this.Masach = masach;
    }

    public void setMaQD(String maqd) {
        this.Maqd = maqd;
    }

    public void setTienPhat(int tienphat) {
        this.Tienphat = tienphat;
    }

    public void nhap(String maPP) {
        // từ danh sách chi tiết phiếu mượn lấy ra danh sách sách của phiếu mượn
        DSChiTietPM dsctpm = new DSChiTietPM();
        Sach[] sachs = dsctpm.getDSSach(maPP);
        Scanner scanner = new Scanner(System.in);
        this.Mapp = maPP;
        // kiểm tra sách có trong phiếu mượn hay không
        this.Masach = Validate.checkExist(scanner, "Nhap ma sach: ", "Ma sach khong ton tai", sachs, Sach::getMaSach);
        System.out.print("Nhập mã quy định: ");
        this.Maqd = scanner.nextLine();
        System.out.print("Nhập tiền phạt: ");
        this.Tienphat = Integer.parseInt(scanner.nextLine());
        scanner.close();
    }

    public void xuat() {
        System.out.println("Mã phiếu phạt: " + Mapp);
        System.out.println("Mã sách: " + Masach);
        System.out.println("Mã quy định: " + Maqd);
        System.out.println("Tiền phạt: " + Tienphat);
    }

    @Override
    public String toString() {
        return Mapp + ", " + Masach + ", " + Maqd + ", " + Tienphat;
    }

    public String[] toArray() {
        return new String[] { Mapp, Masach, Maqd, String.valueOf(Tienphat) };
    }
}
