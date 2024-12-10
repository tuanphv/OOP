package PhieuPhat;

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

    public String getMaPP() {
        return maPP;
    }

    public String getMaSach() {
        return maSach;
    }

    public int getTienPhat() {
        return tienPhat;
    }

    public void setMaPP(String maPP) {
        this.maPP = maPP;
    }

    public void setMaSach(String masach) {
        this.maSach = masach;
    }

    public void setTienPhat(int tienphat) {
        this.tienPhat = tienphat;
    }

    public void nhap(String maPP, Scanner scanner) {
        this.maPP = maPP;
        // kiểm tra sách có trong phiếu mượn hay không
        System.out.print("Nhap ma sach: ");
        this.maSach = scanner.nextLine();
        System.out.print("Nhap tien phat: ");
        this.tienPhat = Integer.parseInt(scanner.nextLine());
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
