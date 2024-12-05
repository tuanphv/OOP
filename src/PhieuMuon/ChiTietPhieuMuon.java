package PhieuMuon;
import java.util.Scanner;
public class ChiTietPhieuMuon {
    private String maPhieuMuon;
    private String hanTra;
    private String ngayTra;
    private String maSach;
    private int soLuong;

    public ChiTietPhieuMuon() {
    }

    public ChiTietPhieuMuon(String maPhieuMuon, String hanTra, String ngayTra, String maSach, int soLuong) {
        this.maPhieuMuon= maPhieuMuon;
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


    public String getmaPhieuMuong() {
        return maPhieuMuon;
    }
    public String gethanTra(){
        return hanTra;
    }
    public String getngayTra(){
        return ngayTra;
    }
    public String getmaSach(){
        return maSach;
    }
    public int getsoLuong(){
        return soLuong;
    }



    public void setmaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }
    public void sethanTra (String hanTra){
        this.hanTra=  hanTra;
    }
    public void setngayTra (String ngayTra){
        this.ngayTra=ngayTra;
    }
    public void setmaSach(String maSach){
        this.maSach=maSach;
    }
    public void setsoLuong(int soLuong){
        this.soLuong=soLuong;
    }

    public void nhap() {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhap ma phieu muon: ");
        maPhieuMuon = nhap.nextLine();
        System.out.print("Nhap han tra sach:  ");
        hanTra = nhap.nextLine();
        System.out.print("Nhap ngay tra: ");
        ngayTra = nhap.nextLine();
        System.out.print("Nhap ma sach: ");
        maSach = nhap.nextLine();
        System.out.print("Nhap so luong: ");
        soLuong = nhap.nextInt();
        nhap.close();
    }

    
    public void xuat() {
        System.out.println("Ma phieu muon: " + maPhieuMuon);
        System.out.println("Ma doc gia: " + hanTra);
        System.out.println("Ngay muon: " + ngayTra);
        System.out.println("Ma nhap vien " + maSach);
        System.out.println("So luong: "+soLuong);
    }

    @Override
    public String toString() {
        return String.format("%-15s%-15s%-15s%-15s%-15s", maPhieuMuon, hanTra, ngayTra, maSach, soLuong);
    }

}
