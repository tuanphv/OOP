package PhieuPhat;

import java.util.Scanner;

public class PhieuPhat {
    private String maPM;
    private String maPP;
    private String maDG;
    private String maNV;
    private int tongPhat;
    private DSChiTietPP dsChiTiet;

    public PhieuPhat() {
        this.dsChiTiet = new DSChiTietPP();
    }

    public PhieuPhat(String maPM, String maPP, String maDG, String maNV, int tongPhat) {
        this.maPM = maPM;
        this.maPP = maPP;
        this.maDG = maDG;
        this.maNV = maNV;
        this.tongPhat = tongPhat;
        this.dsChiTiet = new DSChiTietPP();
    }

    public PhieuPhat(PhieuPhat s1) {
        this.maPM = s1.maPM;
        this.maPP = s1.maPP;
        this.maDG = s1.maDG;
        this.maNV = s1.maNV;
        this.tongPhat = s1.tongPhat;
        this.dsChiTiet = new DSChiTietPP(s1.dsChiTiet);
    }

    public String getMaPM() {
        return maPM;
    }

    public String getMaPP() {
        return maPP;
    }

    public String getMaDG() {
        return maDG;
    }

    public String getMaNV() {
        return maNV;
    }

    public int getTongPhat() {
        return tongPhat;
    }

    public void setMaPP(String maPP) {
        this.maPP = maPP;
    }

    public void setMaDG(String maDG) {
        this.maDG = maDG;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setTongPhat(int tongPhat) {
        this.tongPhat = tongPhat;
    }

    public void setMaPM(String maPM) {
        this.maPM = maPM;
    }

    public void nhap() {
        Scanner cin = new Scanner(System.in); 
        System.out.print("Nhap ma phieu phat: ");
        this.maPP = cin.nextLine();
        System.out.print("Nhap ma doc gia: ");
        this.maDG = cin.nextLine();
        System.out.print("Nhap ma nhan vien: ");
        this.maNV = cin.nextLine();
        this.dsChiTiet = new DSChiTietPP();
        this.dsChiTiet.docFile();
        this.tongPhat = this.dsChiTiet.getTongPhat(this.maPP);
    }

    public void xuat() {
        System.out.println("Ma phieu phat: " + maPP);
        System.out.println("Ma doc gia: " + maDG);
        System.out.println("Ma nhan vien: " + maNV);
        System.out.println("Tong phat: " + tongPhat);
        System.out.println("Chi tiet phieu phat:");
        this.dsChiTiet.xuatKQ(this.dsChiTiet.getChiTietCuaPhieu(maPP));
    }

    public String toString() {
        return maPP + ", " + maDG + ", " + maNV + ", " + tongPhat;
    }

    public String[] toArray() {
        return new String[] { 
            maPM,        // Mã phiếu mượn
            maPP,        // Mã phiếu phạt
            maDG,        // Mã độc giả
            maNV,        // Mã nhân viên
            String.valueOf(tongPhat) // Tổng tiền phạt (chuyển sang chuỗi)
        };
    }
}
