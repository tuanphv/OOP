import java.util.Scanner;

public class ChiTietPhieuNhap {
    private String maPhieuNhap;
    private String maSach;
    private int soLuong;
    private int donGia;
    private double thanhTien= soLuong * donGia;


    public ChiTietPhieuNhap(){}

    public ChiTietPhieuNhap(String maPhieuNhap, String maSach,int soLuong, int donGia){
        this.maPhieuNhap = maPhieuNhap;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia;
    }

    public void nhap(){
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhap ma sach: ");
        maSach = nhap.nextLine();
        System.out.print("Nhap so luong: ");
        soLuong = Integer.parseInt(nhap.nextLine());    
        // đơn giá get từ danh sách sách theo mã sách
        // thành tiền = số lượng * đơn giá sẽ tính sau 
        // dùng constructor để tạo chi tiết phiếu nhập hoặc dùng hàm set để set giá trị cho các thuộc tính sau khi nhập
        nhap.close();
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

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }   

    public void tinhTien() {
        this.thanhTien = this.soLuong * this.donGia;
    }
}