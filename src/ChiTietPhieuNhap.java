import java.util.Scanner;

public class ChiTietPhieuNhap {
    
    private String maSach;
    private int soLuong;
    private int donGia;
    private double thanhTien= soLuong * donGia;


    public ChiTietPhieuNhap(){}

    public ChiTietPhieuNhap(String maSach,int soLuong, int donGia){
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
        thanhTien = soLuong * donGia;
    }

    public void nhap(){
        Scanner nhap = new Scanner(System.in);
        nhap.nextLine();
        System.out.print("Nhap ma sach: ");
        maSach = nhap.nextLine();
        System.out.print("Nhap so luong: ");
        soLuong = nhap.nextInt();
        System.out.print("Nhap don gia: ");
        donGia = nhap.nextInt();
        thanhTien = soLuong * donGia;
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
        thanhTien = soLuong * donGia;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
        thanhTien = soLuong * donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }   
}