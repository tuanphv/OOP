import java.util.Scanner;

public class PhieuNhapHang {
    private String maPhieuNhap;
    private String ngayNhap;
    private String maNhanVien;
    private String maNhaCCap;
    private int tongTien;

    public PhieuNhapHang() {
    }

    public PhieuNhapHang(String maPhieuNhap, String ngayNhap, String maNhanVien, String maNhaCCap, int tongTien) {
        this.maPhieuNhap = maPhieuNhap;
        this.ngayNhap = ngayNhap;
        this.maNhanVien = maNhanVien;
        this.maNhaCCap = maNhaCCap;
        this.tongTien = tongTien;
    }

    public PhieuNhapHang(PhieuNhapHang pnh) {
        this.maPhieuNhap = pnh.maPhieuNhap;
        this.ngayNhap = pnh.ngayNhap;
        this.maNhanVien = pnh.maNhanVien;
        this.maNhaCCap = pnh.maNhaCCap;
        this.tongTien = pnh.tongTien;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaNhaCCap() {
        return maNhaCCap;
    }

    public void setMaNhaCCap(String maNhaCCap) {
        this.maNhaCCap = maNhaCCap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma phieu nhap: ");
        this.maPhieuNhap = sc.nextLine();
        System.out.println("Nhap ngay nhap: ");
        this.ngayNhap = sc.nextLine();
        System.out.println("Nhap ma nhan vien: ");
        this.maNhanVien = sc.nextLine();
        System.out.println("Nhap ma nha cung cap: ");
        this.maNhaCCap = sc.nextLine();
        System.out.println("Nhap tong tien: ");
        this.tongTien = Integer.parseInt(sc.nextLine());
        sc.close();
    }

    public void xuat() {
        System.out.println("Ma phieu nhap: " + this.maPhieuNhap);
        System.out.println("Ngay nhap: " + this.ngayNhap);
        System.out.println("Ma nhan vien: " + this.maNhanVien);
        System.out.println("Ma nha cung cap: " + this.maNhaCCap);
        System.out.println("Tong tien: " + this.tongTien);
    }

    public String toFile() {
        return this.maPhieuNhap + ", " + this.ngayNhap + ", " + this.maNhanVien + ", " + this.maNhaCCap + ", "
                + this.tongTien;
    }
}
