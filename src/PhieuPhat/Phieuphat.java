package PhieuPhat;

import java.util.Scanner;

public class PhieuPhat {
    private String maPP;
    private String maDG;
    private String maNV;
    private int tongPhat;

    public PhieuPhat() {
    }

    public PhieuPhat(String maPP, String maDG, String maNV, int tongPhat) {
        this.maPP = maPP;
        this.maDG = maDG;
        this.maNV = maNV;
        this.tongPhat = tongPhat;
    }

    public PhieuPhat(PhieuPhat s1) {
        this.maPP = s1.maPP;
        this.maDG = s1.maDG;
        this.maNV = s1.maNV;
        this.tongPhat = s1.tongPhat;
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

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma phieu phat: ");
        this.maPP = scanner.nextLine();
        System.out.print("Nhap ma doc gia: ");
        this.maDG = scanner.nextLine();
        System.out.print("Nhap ma nhan vien: ");
        this.maNV = scanner.nextLine();
        scanner.close();
    }

    public void xuat() {
        System.out.println("Ma phieu phat: " + maPP);
        System.out.println("Ma doc gia: " + maDG);
        System.out.println("Ma nhan vien: " + maNV);
        System.out.println("Tong phat: " + tongPhat);
    }

    public void xuatChiTiet() {
        DSChiTietPhieuPhat dsChiTiet = new DSChiTietPhieuPhat();
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
