package PhieuNhap;
import java.util.Scanner;

public class ChiTietPhieuNhap {
    private String maPN;
    private String maSach;
    private int soLuong;
    private int donGia;
    private double thanhTien= soLuong * donGia;
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

    public String ktraSo(String so){
        while(true){
            try{
                Integer.parseInt(so);
                return so;
            }
            catch(NumberFormatException e){
                System.out.print("So khong hop le. Nhap lai");
                so= nhap.nextLine();
            }
        }
    }

    public void nhap(){
        Scanner nhap = new Scanner(System.in);
        nhap.nextLine();
        System.out.print("Nhap ma sach: ");
        maPN = nhap.nextLine();
        System.out.print("Nhap so luong: ");
        soLuong = Integer.parseInt(nhap.nextLine());    
        // đơn giá get từ danh sách sách theo mã sách
        // thành tiền = số lượng * đơn giá sẽ tính sau 
        // dùng constructor để tạo chi tiết phiếu nhập hoặc dùng hàm set để set giá trị cho các thuộc tính sau khi nhập
        nhap.close();
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

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }  
    
    @Override 
    public String toString() {
        return maPN + ", " + maSach + ", " + soLuong + ", " + donGia;
    }
}