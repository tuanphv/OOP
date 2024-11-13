import java.util.Scanner;
public class PhieuMuon {
    private String maPhieuMuon;
    private String maDocGia;
    private String ngayMuon;
    private String maNhanVien;
    Scanner input = new Scanner(System.in);


    public PhieuMuon() {
    }

    public PhieuMuon(String maPhieuMuon, String maDocGia, String ngayMuon, String maNhanVien) {
        this.maPhieuMuon= maPhieuMuon;
        this.maDocGia = maDocGia;
        this.ngayMuon = ngayMuon;
        this.maNhanVien = maNhanVien;

    }

    public PhieuMuon(PhieuMuon pm1) {
        this.maPhieuMuon = pm1.maPhieuMuon;
        this.maDocGia = pm1.maDocGia;
        this.ngayMuon = pm1.ngayMuon;
        this.maNhanVien = pm1.maNhanVien;
    }


    public String getmaPhieuMuon() {
        return maPhieuMuon;
    }
    public String getmaDocGia(){
        return maDocGia;
    }
    public String getngayMuon(){
        return ngayMuon;
    }
    public String getmaNhanVien(){
        return maNhanVien;
    }



    public void setmaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }
    public void setmaDocGia (String maDocGia){
        this.maDocGia=  maDocGia;
    }
    public void setngayMuon (String ngayMuon){
        this.ngayMuon=ngayMuon;
    }
    public void setmaNhanVien(String maNhanVien){
        this.maNhanVien=maNhanVien;
    }

    public void nhap() {
        System.out.print("Nhap ma phieu muon: ");
        maPhieuMuon = input.nextLine();
        System.out.print("Nhap ma doc gia:  ");
        maDocGia = input.nextLine();
        System.out.print("Nhap ngay muon: ");
        ngayMuon = input.nextLine();
        System.out.print("Nhap ma nhan vien: ");
        maNhanVien = input.nextLine();
    }

    
    public void xuat() {
        System.out.printf("%-15s %-15s %-15s %-15s\n", maPhieuMuon, maDocGia, ngayMuon, maNhanVien);
    }
    


}
