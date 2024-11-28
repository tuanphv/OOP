import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sach{
    private String maSach;
    private String tenSach;
    private String maNXB;
    private String maTG;
    private int namXB;
    private int donGia;
    private int soLuong;
    private String theLoai;

    public Sach() {
    }

    public Sach(String maSach, String tenSach, String maNXB, String maTG, int namXB, int donGia, int soLuong,
            String theLoai) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.maNXB = maNXB;
        this.maTG = maTG;
        this.namXB = namXB;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.theLoai = theLoai;
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
    }

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

    Scanner in = new Scanner(System.in);

    public void nhap() {
        System.out.println("Nhap thoong tin sach");
        System.out.print("Ma sach: ");
        maSach = in.nextLine();
        System.out.print("Ten sach: ");
        tenSach = in.nextLine();
        System.out.print("Ma nha xuat ban: ");
        maNXB = in.nextLine();
        System.out.print("Ma tac gia: ");
        maTG = in.nextLine();
        System.out.print("Nam xuat ban: ");
        namXB = Integer.parseInt(in.nextLine());
        System.out.print("Don gia: ");
        donGia = Integer.parseInt(in.nextLine());
        System.out.print("So luong sach: ");
        soLuong = Integer.parseInt(in.nextLine());
        System.out.print("The loai");
        theLoai = in.nextLine();
    }

    public void xuat() {
        System.out.println("<===== Thong tin sach =====>");
        System.out.printf("%-20s%s\n", "Ma sach:", maSach);
        System.out.printf("%-20s%s\n", "Ten sach:", tenSach);
        System.out.printf("%-20s%s\n", "Ma nha xuat ban:", maNXB); 
        System.out.printf("%-20s%s\n", "Ma tac gia:", maTG);
        System.out.printf("%-20s%d\n", "Nam xuat ban:", namXB);
        System.out.printf("%-20s%d\n", "Don gia:", donGia);
        System.out.printf("%-20s%d\n", "So luong:", soLuong);
        System.out.printf("%-20s%s\n", "The loai:", theLoai);
    }

    public void ghiFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./lib/sach.txt", true));
            writer.write(this.formatToString());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public String toString() {
        return String.format("%-10s%-35s%-10s%-12s%-8d%-9d%-10d%-20s", maSach, tenSach, maNXB, maTG, namXB, donGia,
                soLuong, theLoai);
    }

    public String formatToString() {
        return String.format("%s, %s, %s, %s, %d, %d, %d, %s", maSach, tenSach, maNXB, maTG, namXB, donGia, soLuong, theLoai);
    }
}