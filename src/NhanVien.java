import java.util.Scanner;

public class NhanVien {
    private String maNV;
    private String tenNV;
    private String chucVu;
    private int luong;
    private String sdtNV;
    private String email;

    public NhanVien(){}

    public NhanVien (String maNV, String tenNV, String chucVu, int luong, String sdtNV, String email){
        this.maNV= maNV;
        this.tenNV= tenNV;
        this.chucVu= chucVu;
        this.luong= luong;
        this.sdtNV= sdtNV;
        this.email= email;
    }

    public NhanVien(NhanVien nv1){
        this.maNV= nv1.maNV;
        this.tenNV= nv1.tenNV;
        this.chucVu= nv1.chucVu;
        this.luong= nv1.luong;
        this.sdtNV= nv1.sdtNV;
        this.email= nv1.email;
    }

    public void copyNV(NhanVien nv1){
        maNV= nv1.maNV;
        tenNV= nv1.tenNV;
        chucVu= nv1.chucVu;
        luong= nv1.luong;
        email= nv1.email;
        sdtNV= nv1.sdtNV;
    }

    public String getMaNV(){
        return maNV;
    }

    public String getTenNV(){
        return tenNV;
    }

    public String getChucVu(){
        return chucVu;
    }

    public String getSdtNV(){
        return sdtNV;
    }

    public int getLuong(){
        return luong;
    }

    public String getEmail(){
        return email;
    }

    public void setTenNV(String tenNV){
        this.tenNV= tenNV;
    }

    public void setMaNV(String maNV){
        this.maNV= maNV;
    }

    public void setChucVu(String chucVu){
        this.chucVu= chucVu;
    }

    public void setLuong(int luong){
        this.luong= luong;
    }

    public void setSdtNV(String sdtNV){
        this.sdtNV= sdtNV;
    }

    public void setEmailNV(String email){
        this.email= email;
    }

    public void nhap(){
        Scanner nhap= new Scanner(System.in);
        System.out.print("Nhap ma nhan vien: ");
        nhap.nextLine();
        maNV= nhap.nextLine();
        System.out.print("Nhap ten nhan vien: ");
        tenNV= nhap.nextLine();
        System.out.print("Nhap chuc vu nhan vien: ");
        chucVu= nhap.nextLine();
        System.out.print("Nhap so dien thoai nhan vien: ");
        sdtNV= nhap.nextLine();
        System.out.print("Nhap email nhan vien: ");
        email= nhap.nextLine();
        System.out.print("Nhap luong nhan vien: ");
        luong= nhap.nextInt();
        nhap.close();
    }

    public void xuat(){
        System.out.print("Ma nhan vien: " + maNV + "\t");
        System.out.print("\tTen nhan vien: " + tenNV + "\t");
        System.out.println("\tChuc vu cua nhan vien: " + chucVu);
        System.out.print("\tSo dien thoai nhan vien: " + sdtNV + "\t");
        System.out.print("\tEmail nhan vien: " + email + "\t");
        System.out.println("\tLuong cua nhan vien: " + luong);
    }
}
