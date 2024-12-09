package PhieuPhat;

import PhieuMuon.DSChiTietPM;
import Sach.Sach;
import Validate.Validate;
import java.util.Scanner;

public class ChiTietPhieuPhat {
    private String maPP;
    private String maSach;
    private int tienPhat;

    public ChiTietPhieuPhat() {
    }

    public ChiTietPhieuPhat(String maPP, String masach, int tienphat) {
        this.maPP = maPP;
        this.maSach = masach;
        this.tienPhat = tienphat;
    }

    public ChiTietPhieuPhat(ChiTietPhieuPhat s1) {
        this.maPP = s1.maPP;
        this.maSach = s1.maSach;
        this.tienPhat = s1.tienPhat;
    }

    public String maPP() {
        return maPP;
    }

    public String getMaSach() {
        return maSach;
    }

    public int getTienPhat() {
        return tienPhat;
    }

    public void maPP(String maPP) {
        this.maPP = maPP;
    }

    public void setMaSach(String masach) {
        this.maSach = masach;
    }

    public void setTienPhat(int tienphat) {
        this.tienPhat = tienphat;
    }

    public void nhap(String maPP) {
        // từ danh sách chi tiết phiếu mượn lấy ra danh sách sách của phiếu mượn
        DSChiTietPM dsctpm = new DSChiTietPM();
        Sach[] sachs = dsctpm.getDSSach(maPP);
        Scanner scanner = new Scanner(System.in);
        this.maPP = maPP;
        // kiểm tra sách có trong phiếu mượn hay không
        this.maSach = Validate.checkExist(scanner, "Nhap ma sach: ", "Ma sach khong ton tai", sachs, Sach::getMaSach);
        System.out.print("Nhập tiền phạt: ");
        this.tienPhat = Integer.parseInt(scanner.nextLine());
        scanner.close();
    }

    public void xuat() {
        System.out.println("Mã phiếu phạt: " + maPP);
        System.out.println("Mã sách: " + maSach);
        System.out.println("Tiền phạt: " + tienPhat);
    }

    @Override
    public String toString() {
        return maPP + ", " + maSach + ", " + tienPhat;
    }

    public String[] toArray() {
        return new String[] { maPP, maSach, String.valueOf(tienPhat) };
    }
}
