package PhieuNhap;
import java.util.Scanner;

import Sach.DSSach;
import Sach.Sach;
import Validate.Validate;
//import PhieuNhap.DSChiTietPN;

public class ChiTietPhieuNhap {
    private String maPN;
    private String maSach;
    private int soLuong;
    private int donGia;
    private int thanhTien;
    Scanner nhap = new Scanner(System.in);

    public ChiTietPhieuNhap(){}

    public ChiTietPhieuNhap(String maPN,String maSach, int soLuong, int donGia){
        this.maPN = maPN;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia;
    }

    public ChiTietPhieuNhap(ChiTietPhieuNhap ctpn){
        this.maPN = ctpn.maPN;
        this.maSach = ctpn.maSach;
        this.soLuong = ctpn.soLuong;
        this.donGia = ctpn.donGia;
        this.thanhTien = ctpn.thanhTien;
    }

    public void nhap(){
        //Scanner nhap = new Scanner(System.in);
        //nhap.nextLine();
        // System.out.print("Nhap ma phieu nhap: ");
        // maPN = nhap.nextLine();
        // System.out.print("Nhap ma sach: ");
        // maSach = nhap.nextLine();
        System.out.print("Nhap so luong: ");
        soLuong = Integer.parseInt(nhap.nextLine());    
        DSSach dsSach = new DSSach();
        if (dsSach.isEmpty()) {
            dsSach.docFile();
        }
        // nếu sách chưa tồn tại trong kho
        Sach sach = dsSach.get(maSach);
        if (sach == null) {
            System.out.println("Sach khong co san trong kho");
            donGia = Validate.getNumber(nhap, "Nhap don gia moi: ");
        } else {
            donGia = sach.getDonGia();
        }
        setThanhTien(soLuong, donGia);
       // nhap.close();
    }

    public void xuat(){
        System.out.printf("%10s%10s%15s%10s%20s\n", maPN, maSach, donGia, soLuong, thanhTien);
    }

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }  
    
    public void setThanhTien(int soLuong, int donGia) {
        this.thanhTien = soLuong * donGia;
    }

    @Override 
    public String toString() {
        return maPN + ", " + maSach + ", " + soLuong + ", " + donGia + ", " + thanhTien;
    }
}