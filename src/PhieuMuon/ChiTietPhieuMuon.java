package PhieuMuon;

import java.util.Scanner;

import Sach.DSSach;
import Sach.Sach;
import Validate.Ngay;
import Validate.Validate;

public class ChiTietPhieuMuon {
    private String maPhieuMuon;
    private String maSach;
    private int soLuong;
    private String hanTra;
    private String ngayTra;

    public ChiTietPhieuMuon() {
    }

    public ChiTietPhieuMuon(String maPhieuMuon, String maSach, int soLuong, String hanTra, String ngayTra) {
        this.maPhieuMuon = maPhieuMuon;
        this.hanTra = hanTra;
        this.ngayTra = ngayTra;
        this.maSach = maSach;
        this.maSach = maSach;
        this.soLuong = soLuong;
    }

    public ChiTietPhieuMuon(ChiTietPhieuMuon ctpm1) {
        this.maPhieuMuon = ctpm1.maPhieuMuon;
        this.hanTra = ctpm1.hanTra;
        this.ngayTra = ctpm1.ngayTra;
        this.maSach = ctpm1.maSach;
        this.soLuong = ctpm1.soLuong;
    }

    public String getMaPM() {
        return maPhieuMuon;
    }

    public String getHanTra() {
        return hanTra;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public String getMaSach() {
        return maSach;
    }

    public int getSoLSong() {
        return soLuong;
    }

    public void setMaPM(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public void setHanTra(String hanTra) {
        this.hanTra = hanTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void nhap(String maPM) {
        // lấy dữ liệu từ file
        DSSach dsSach = new DSSach();
        if (dsSach.isEmpty()) {
            dsSach.docFile();
        }
        Scanner nhap = new Scanner(System.in);
        maPhieuMuon = maPM;
        maSach = Validate.checkExist(nhap, "Nhap ma sach can muon: ", ">> Khong tim thay sach!", dsSach.getList(),
                Sach::getMaSach);
        Sach sach = dsSach.get(maSach);
        int max = sach.getSoLuong();
        soLuong = Validate.getSoLSong(nhap, "Nhap so luong: ", ">> Du lieu nhap vao phai la so!",
                ">> Vuot qua so luong toi da (" + max + ")!", max);
        sach.setSoLuong(sach.getSoLuong() - soLuong);
        hanTra = Validate.getDate(nhap, "Nhap han tra: ");
        // ngayTra sẽ được cập nhật sau khi sách được trả
        // ngayTra = Validate.getDate(nhap, "Nhap ngay tra:");
    }

    public void xuat() {
        System.out.println("Ma phieu muon: " + maPhieuMuon);
        System.out.println("Ma sach da muon: " + maSach);
        System.out.println("So luong: " + soLuong);
        System.out.println("Han phai tra sach: " + hanTra);
        if (ngayTra != null)
            System.out.println("Ngay tra sach: " + ngayTra);
    }

    public void traSach() {
        DSSach dsSach = new DSSach();
        Sach sach = dsSach.get(maSach);
        sach.setSoLuong(sach.getSoLuong() + soLuong);
        ngayTra = new Ngay().toString();
        if (new Ngay().compare(new Ngay(hanTra))<=0) {
            System.out.println("Tra sach thanh cong");
        } else {
            System.out.println("Da qua han tra sach. Vui long nhan phat!");
        }
    }
    
    @Override
    public String toString() {
        return maPhieuMuon + ", " + maSach + ", " + soLuong + ", " + hanTra + ", " + ngayTra;
    }

    public String[] toArray() {
        return new String[] { maPhieuMuon, maSach, String.valueOf(soLuong), hanTra, ngayTra };
    }
}
