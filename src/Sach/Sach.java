package Sach;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Validate.Validate;

public class Sach {
    private String maSach;
    private String tenSach;
    private String maNXB;
    private String maTG;
    private int namXB;
    private int donGia;
    private int soLuong;

    public Sach() {
    }

    public Sach(String maSach, String tenSach, String maNXB, String maTG, int namXB, int donGia, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.maNXB = maNXB;
        this.maTG = maTG;
        this.namXB = namXB;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public Sach(Sach s1) {
        this.maSach = s1.maSach;
        this.tenSach = s1.tenSach;
        this.maNXB = s1.maNXB;
        this.maTG = s1.maTG;
        this.namXB = s1.namXB;
        this.donGia = s1.donGia;
        this.soLuong = s1.soLuong;
    }

    public String getMaSach() {
        return this.maSach;
    }

    public String getTenSach() {
        return this.tenSach;
    }

    public String getMaNXB() {
        return this.maNXB;
    }

    public String getMaTG() {
        return this.maTG;
    }

    public int getNamXB() {
        return this.namXB;
    }

    public int getDonGia() {
        return this.donGia;
    }

    public int getSoLuong() {
        return this.soLuong;
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

    Scanner in = new Scanner(System.in);

    public void nhap() {
        System.out.println("Nhap thong tin sach");
        maSach = Validate.checkNotExist(in, "Ma sach: ", ">> Ma sach da ton tai!", new DSSach().getList(),
                Sach::getMaSach);
        System.out.print("Ten sach: ");
        tenSach = in.nextLine();
        System.out.print("Ma nha xuat ban: ");
        maNXB = in.nextLine();
        System.out.print("Ma tac gia: ");
        maTG = in.nextLine();
        namXB = Validate.getNumber(in, "Nam xuat ban: ");
        donGia = Validate.getNumber(in, "Don gia: ");
        soLuong = Validate.getNumber(in, "So luong: ");
    }

    public void xuat() {
        System.out.printf("%-20s%s\n", "Ma sach:", maSach);
        System.out.printf("%-20s%s\n", "Ten sach:", tenSach);
        System.out.printf("%-20s%s\n", "Ma NXB:", maNXB);
        System.out.printf("%-20s%s\n", "Ma TG:", maTG);
        System.out.printf("%-20s%d\n", "Nam XB:", namXB);
        System.out.printf("%-20s%d\n", "Don gia:", donGia);
        System.out.printf("%-20s%d\n", "So luong:", soLuong);
    }

    public void ghiFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./lib/sach.txt", true));
            writer.write(this.toString());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %d, %d, %d", maSach, tenSach, maNXB, maTG, namXB, donGia, soLuong);
    }

    public String[] toArray() {
        return new String[] { maSach, tenSach, maNXB, maTG, String.valueOf(namXB), String.valueOf(donGia),
                String.valueOf(soLuong) };
    }
}