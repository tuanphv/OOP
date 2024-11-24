import java.util.Scanner;

public class ChiTietPhieuNhap {
    private String maPN;
    private String maSach;
    private String soLuong;
    private String donGia;
    private double thanhTien= Double.parseDouble(soLuong) * Double.parseDouble(donGia);
    Scanner nhap = new Scanner(System.in);

    public ChiTietPhieuNhap(){}

    public ChiTietPhieuNhap(String maPN,String maSach, String soLuong, String donGia){
        this.maPN = maPN;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
        thanhTien = Double.parseDouble(soLuong) * Double.parseDouble(donGia);
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
        System.out.print("Nhap ma sach: ");
        maPN = nhap.nextLine();
        System.out.print("Nhap so luong: ");
        soLuong = ktraSo(nhap.nextLine());
        thanhTien = Double.parseDouble(soLuong) * Double.parseDouble(donGia);
    }

    public void xuat(){
        System.out.printf("%10s", maPN);
        System.out.printf("%10s", maSach);
        System.out.printf("%5s", soLuong);
        System.out.printf("%10s", donGia);
        System.out.printf("%10s", thanhTien);
    }

    public String getMaSach() {
        return maPN;
    }

    public void setMaSach(String maPN) {
        this.maPN = maPN;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
        thanhTien = Double.parseDouble(soLuong) * Double.parseDouble(donGia);
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
        thanhTien = Double.parseDouble(soLuong) * Double.parseDouble(donGia);
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public String getMaPN(){
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }
}