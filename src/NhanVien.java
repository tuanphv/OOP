import java.util.Scanner;

public class NhanVien {
    private String maNV;
    private String tenNV;
    private String chucVu;
    private String luong;
    private String sdtNV;
    private String gioiTinh;
    Scanner nhap= new Scanner(System.in);

    public NhanVien(){}

    public NhanVien (String maNV, String tenNV, String chucVu, String luong, String sdtNV, String gioiTinh){
        this.maNV= maNV;
        this.tenNV= tenNV;
        this.chucVu= chucVu;
        this.luong= luong;
        this.sdtNV= sdtNV;
        this.gioiTinh= gioiTinh;
    }

    public NhanVien(NhanVien nv1){
        this.maNV= nv1.maNV;
        this.tenNV= nv1.tenNV;
        this.chucVu= nv1.chucVu;
        this.luong= nv1.luong;
        this.sdtNV= nv1.sdtNV;
        this.gioiTinh= nv1.gioiTinh;
    }

    public void copyNV(NhanVien nv1){
        maNV= nv1.maNV;
        tenNV= nv1.tenNV;
        chucVu= nv1.chucVu;
        luong= nv1.luong;
        gioiTinh= nv1.gioiTinh;
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

    public String getLuong(){
        return luong;
    }

    public String getgioiTinh(){
        return gioiTinh;
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

    public void setLuong(String luong){
        this.luong= luong;
    }

    public void setSdtNV(String sdtNV){
        this.sdtNV= sdtNV;
    }

    public void setgioiTinhNV(String gioiTinh){
        this.gioiTinh= gioiTinh;
    }

    public String ktraSdt(String sdt){
        while(sdt.length()!=10 && sdt.charAt(0)!=0){
            System.out.println("So dien thoai khong hop le");
            sdt= nhap.nextLine();
        }
            return sdt;
    }

    public String ktraGioiTinh(String gioiTinh){
        while(!gioiTinh.equalsIgnoreCase("nam") && !gioiTinh.equalsIgnoreCase("nu")){
                System.out.println("Gioi tinh khong hop le. Nhap lai");
                gioiTinh= nhap.nextLine();
            }
        return gioiTinh;
    }

    public void nhap(){
        System.out.print("Nhap ma nhan vien: ");
        maNV= nhap.nextLine();
        System.out.print("Nhap ten nhan vien: ");
        tenNV= nhap.nextLine();
        System.out.print("Nhap chuc vu nhan vien: ");
        chucVu= nhap.nextLine();
        System.out.print("Nhap so dien thoai nhan vien (sdt VN): ");
        sdtNV= ktraSdt(nhap.nextLine());
        System.out.print("Nhap gioi tinh nhan vien: ");
        gioiTinh= ktraGioiTinh(nhap.nextLine());
        System.out.print("Nhap luong nhan vien: ");
        luong= nhap.nextLine();
    }

    public void xuat(){
        System.out.printf("%10s %20s %20s %15s %10s %10s\n", maNV, tenNV, chucVu, sdtNV, gioiTinh, luong);
    }
}
