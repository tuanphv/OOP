package PhieuNhap;
import java.util.Scanner;

import Validate.Validate;

public class PhieuNhap {
    private String maPN;
    private String ngayNhap;
    private String maNV;
    private String maNCC;
    private int tongTien;
    Scanner nhap= new Scanner(System.in);

    public PhieuNhap() {}
    public PhieuNhap(String maPN, String ngayNhap, String maNV, String maNCC, int tongTien){
        this.maNCC = maNCC;
        this.maPN = maPN;
        this.ngayNhap = ngayNhap;
        this.tongTien= tongTien;
        this.maNV = maNV;
    }

    public PhieuNhap(PhieuNhap pn){
        this.maNCC = pn.maNCC;
        this.maPN = pn.maPN;
        this.ngayNhap = pn.ngayNhap;
        this.maNV = pn.maNV;
        this.tongTien = pn.tongTien;
    }

    public void setMaPN(String maPN){
        this.maPN = maPN;
    }

    public void setNgayNhap(String ngayNhap){
        this.ngayNhap = ngayNhap;
    }

    public void setMaNV(String maNV){
        this.maNV = maNV;
    }

    public void setMaNCC(String maNCC){
        this.maNCC = maNCC;
    }

    public void setTongtien(int tongTien){
        this.tongTien = tongTien;
    }

    public String getMaPN(){
        return maPN;
    }

    public String getNgayNhap(){
        return ngayNhap;
    }

    public String getMaNV(){
        return maNV;
    }

    public String getMaNCC(){
        return maNCC;
    }

    public int getTongtien(){
        return tongTien;
    }

    public void nhap(){
        // System.out.print("Nhap ma phieu nhap: ");
        // maPN = nhap.nextLine();
        ngayNhap = Validate.getDate(nhap, "Nhap ngay nhap hang: ");
        // System.out.print("Nhap ma nhan vien: ");
        // maNV = nhap.nextLine();
        // System.out.print("Nhap ma nha cung cap: ");
        // maNCC = nhap.nextLine();
    }

    public void xuat(){
        System.out.printf("%10s%20s%10s%10s%10s\n", maPN, ngayNhap, maNV, maNCC, tongTien);
    }

    public static void main(String[] args) {
        PhieuNhap pn = new PhieuNhap();
        pn.nhap();
        pn.xuat();
    }
}
