package NCC_NXB;
import java.util.Scanner;

public class NhaCungCap {
    private String maNCC;
    private String ten;
    private String diaChi;
    private String sdt;
    Scanner nhap= new Scanner(System.in);

    public NhaCungCap(){
        //solg++;
    }

    public NhaCungCap(String maNhaCC, String ten, String diaChi, String sdt){
        this.maNCC= maNhaCC;
        this.ten= ten;
        this.diaChi= diaChi;
        this.sdt= sdt;
        //solg++;
    }

    public NhaCungCap(NhaCungCap ncc){
        this.maNCC= ncc.maNCC;
        this.ten= ncc.ten;
        this.diaChi= ncc.diaChi;
        this.sdt= ncc.sdt;
    }

    public String getMaNCC(){
        return maNCC;
    }

    public void setMaNCC(String maNCC){
        this.maNCC= maNCC;
    }

    public String getTen(){
        return ten;
    }

    public void setTen(String ten){
        this.ten= ten;
    }

    public String getDiaChi(){
        return diaChi;
    }

    public void setDiaChi(String diaChi){
        this.diaChi= diaChi;
    }

    public String getSdt(){
        return sdt;
    }

    public void setSdt(String sdt){
        this.sdt= sdt;
    }

    // static public int getSolg(){
    //     return solg;
    // }

    // static public void setSolg(int solg){
    //     NhaCungCap.solg= solg;
    // }

    // public String ktrasdt(String sdt){
    //     while(sdt.length() != 10 && sdt.charAt(0)!= '0'){
    //         System.out.println("So dien thoai khong hop le");
    //         sdt= nhap.nextLine();
    //     }
    //     return sdt;
    // }

    public void nhap(){
        System.out.print("Nhap ma nha cung cap: ");
        maNCC= nhap.nextLine();
        System.out.print("Nhap ten nha cung cap: ");
        ten= nhap.nextLine();
        System.out.print("Nhap dia chi nha cung cap: ");
        diaChi= nhap.nextLine();
        System.out.print("Nhap sdt nha cung cap: ");
        sdt= nhap.nextLine();
    }

    public void xuat(){
        System.out.printf("%10s", maNCC);
        System.out.printf("%20s", ten);
        System.out.printf("%20s", diaChi);
        System.out.printf("%15s\n", sdt);
    }

    public String toString(){
        return maNCC + ", " + ten + ", " + diaChi+ ", " + sdt;
    }
}
