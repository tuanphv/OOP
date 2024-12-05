package Sach;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Format.ANSI;
import Validate.Validate;

public class Sach{
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
        System.out.print("Ma sach: ");
        maSach = in.nextLine();
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
        new ANSI(new String[]{"Thong tin sach"},
        new String[][]{
            {"Ma sach: " + maSach},
            {"Ten sach: " + tenSach},
            {"Ma nha xuat ban: " + maNXB},
            {"Ma tac gia: " + maTG},
            {"Nam xuat ban: " + namXB},
            {"Don gia: " + donGia},
            {"So luong: " + soLuong}}).printTable();
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
        return new String[]{maSach, tenSach, maNXB, maTG, String.valueOf(namXB), String.valueOf(donGia), String.valueOf(soLuong)}; 
    }
}