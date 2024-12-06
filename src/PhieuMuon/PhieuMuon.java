package PhieuMuon;

import java.util.Scanner;

import Validate.Ngay;
import Validate.Validate;

public class PhieuMuon {
    private String maPhieuMuon;
    private String maNhanVien;
    private String maDocGia;
    private String ngayMuon;

    public PhieuMuon() {
    }

    public PhieuMuon(String maPhieuMuon, String maNhanVien, String maDocGia, String ngayMuon) {
        this.maPhieuMuon = maPhieuMuon;
        this.maNhanVien = maNhanVien;
        this.maDocGia = maDocGia;
        this.ngayMuon = ngayMuon;

    }

    public PhieuMuon(PhieuMuon pm1) {
        this.maPhieuMuon = pm1.maPhieuMuon;
        this.maDocGia = pm1.maDocGia;
        this.ngayMuon = pm1.ngayMuon;
        this.maNhanVien = pm1.maNhanVien;
    }

    public String getMaPM() {
        return maPhieuMuon;
    }

    public String getMaDG() {
        return maDocGia;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public String getMaNV() {
        return maNhanVien;
    }

    public void setMaPM(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public void setMaDG(String maDocGia) {
        this.maDocGia = maDocGia;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public void setMaNV(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void nhap() {
        Scanner input = new Scanner(System.in);
        maPhieuMuon = Validate.checkNotExist(input, "Nhap ma phieu muon: ",
                ">> Phieu muon da ton tai! Vui long nhap ma khac", (new DSPhieuMuon()).getList(), PhieuMuon::getMaPM);
        System.out.print("Nhap ma nhan vien: ");
        maNhanVien = input.nextLine();
        System.out.print("Nhap ma doc gia:  ");
        maDocGia = input.nextLine();
        ngayMuon = new Ngay().toString();
        System.out.println("Ngay lap phieu muon: " + ngayMuon);
        System.out.print("Nhap so luong chi tiet: ");
        int n = Validate.getNumber(input, maDocGia);
        DSChiTietPM dsChiTietPM = new DSChiTietPM();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap chi tiet thu " + (i + 1));
            dsChiTietPM.them(maPhieuMuon);
        }
    }

    public void xuat() {
        System.out.println("Ma phieu muon: " + maPhieuMuon);
        System.out.println("Ma nhan vien: " + maNhanVien);
        System.out.println("Ma doc gia: " + maDocGia);
        System.out.println("Ngay muon: " + ngayMuon);
    }

    @Override
    public String toString() {
        return maPhieuMuon + ", " + maNhanVien + ", " + maDocGia + ", " + ngayMuon;
    }

    public String[] toArray() {
        return new String[] { maPhieuMuon, maNhanVien, maDocGia, ngayMuon };
    }
}
