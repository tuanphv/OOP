import java.util.Scanner;

public class Sach {
    // các thuộc tính
    private String maSach;
    private String tenSach;
    private String maNXB;
    private String maTG;
    private int namXB;
    private int donGia;
    private int soLuong;
    private String theLoai;
    private String trangThai;

    // các hàm thiết lập
    public Sach() {
    }

    public Sach(String maSach, String tenSach, String maNXB, String maTG, int namXB, int donGia, int soLuong,
            String theLoai, String trangThai) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.maNXB = maNXB;
        this.maTG = maTG;
        this.namXB = namXB;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.theLoai = theLoai;
        this.trangThai = trangThai;
    }

    public Sach(Sach s1) {
        this.maSach = s1.maSach;
        this.tenSach = s1.tenSach;
        this.maNXB = s1.maNXB;
        this.maTG = s1.maTG;
        this.namXB = s1.namXB;
        this.donGia = s1.donGia;
        this.soLuong = s1.soLuong;
        this.theLoai = s1.theLoai;
        this.trangThai = s1.trangThai;
    }

    // Các hàm get giá trị
    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public String getMaTG() {
        return maTG;
    }

    public int getNamXB() {
        return namXB;
    }

    public int getDonGia() {
        return donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    // Các hàm set giá trị
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public void setMaTG(String maTG) {
        this.maTG = maTG;
    }

    public void setNamXB(int namXB) {
        this.namXB = namXB;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    Scanner in = new Scanner(System.in);

    public void nhap() {
        maSach = in.nextLine();
        tenSach = in.nextLine();
        maNXB = in.nextLine();
        maTG = in.nextLine();
        namXB = Integer.parseInt(in.nextLine());
        donGia = Integer.parseInt(in.nextLine());
        soLuong = Integer.parseInt(in.nextLine());
        theLoai = in.nextLine();
        trangThai = in.nextLine();
    }

    public void xuat() {
        System.out.println("<===== Thong tin sach =====>");
        System.out.printf("%-25s%s\n", "Ma sach:", maSach);
        System.out.printf("%-25s%s\n", "Ten sach:", tenSach);
        System.out.printf("%-25s%s\n", "Ma nha xuat ban:", maNXB);
        System.out.printf("%-25s%s\n", "Ma tac gia:", maTG);
        System.out.printf("%-25s%d\n", "Nam xuat ban:", namXB);
        System.out.printf("%-25s%d\n", "Don gia:", donGia);
        System.out.printf("%-25s%d\n", "So luong:", soLuong);
        System.out.printf("%-25s%s\n", "The loai:", theLoai);
        System.out.printf("%-25s%s\n", "Tinh trang sach:", trangThai);
    }

    @Override
    public String toString() {
        return String.format("%-10s%-35s%-10s%-12s%-8d%-9d%-10d%-20s%-12s", maSach, tenSach, maNXB, maTG, namXB, donGia,
                soLuong, theLoai, trangThai);
    }
}