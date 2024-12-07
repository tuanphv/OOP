package PhieuPhat;

import java.util.Scanner;

import Validate.Validate;

public class PhieuPhat {
    private String maPM;
    private String maPP;
    private String maDG;
    private String maNV;
    private int tongPhat;

    public PhieuPhat() {
    }

    public PhieuPhat(String maPM, String maPP, String maDG, String maNV, int tongPhat) {
        this.maPM = maPM;
        this.maPP = maPP;
        this.maDG = maDG;
        this.maNV = maNV;
        this.tongPhat = tongPhat;
    }

    public PhieuPhat(PhieuPhat s1) {
        this.maPM = s1.maPM;
        this.maPP = s1.maPP;
        this.maDG = s1.maDG;
        this.maNV = s1.maNV;
        this.tongPhat = s1.tongPhat;
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma phieu phat: ");
        this.maPP = scanner.nextLine();
        System.out.print("Nhap ma doc gia: ");
        this.maDG = scanner.nextLine();
        System.out.print("Nhap ma nhan vien: ");
        this.maNV = scanner.nextLine();
        int soLoi = Validate.getNumber(scanner, "Nhap so luong loi phai phat: ");
        DSChiTietPP dsChiTiet = new DSChiTietPP();
        for (int i = 0; i < soLoi; i++) {
            System.out.println("Nhap thong tin loi thu " + (i + 1));
            ChiTietPhieuPhat chiTiet = new ChiTietPhieuPhat();
            chiTiet.nhap(maPP);
            dsChiTiet.add(chiTiet);
        }
        scanner.close();
    }

    public void xuat() {
        System.out.println("Ma phieu phat: " + maPP);
        System.out.println("Ma doc gia: " + maDG);
        System.out.println("Ma nhan vien: " + maNV);
        System.out.println("Tong phat: " + tongPhat);
    }

    public void xuatChiTiet() {
        DSChiTietPP dsChiTiet = new DSChiTietPP();
        if (dsChiTiet.isEmpty()) {
            dsChiTiet.docFile();
        }
        System.out.println("Ma phieu phat: " + maPP);
        System.out.println("Ma doc gia: " + maDG);
        System.out.println("Ma nhan vien: " + maNV);
        dsChiTiet.xuatKQ(dsChiTiet.getChiTietCuaPhieu(maPP));
        System.out.println("Tong phat: " + tongPhat);
    }
    public String toString() {
        return maPP + ", " + maDG + ", " + maNV + ", " + tongPhat;
    }
}
