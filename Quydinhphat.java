package PHAT;

import java.util.Scanner;

public class Phieuphat {
    private String Mapp;
    private String Madg;
    private String Manv;
    private Double Tongphat;

    public Phieuphat() {}

    public Phieuphat(String mapp, String madg, Double tongphat, String manv) {
        this.Mapp = mapp;
        this.Madg = madg;
        this.Tongphat = tongphat;
        this.Manv = manv;
    }

    public Phieuphat(Phieuphat s1) {
        this.Mapp = s1.Mapp;
        this.Madg = s1.Madg;
        this.Tongphat = s1.Tongphat;
        this.Manv = s1.Manv;
    }

    public String getMapp() { return Mapp; }
    public String getMadg() { return Madg; }
    public Double getTongphat() { return Tongphat; }
    public String getManv() { return Manv; }

    public void setMapp(String Mapp) { this.Mapp = Mapp; }
    public void setMadg(String Madg) { this.Madg = Madg; }
    public void setTongphat(Double Tongphat) { this.Tongphat = Tongphat; }
    public void setManv(String Manv) { this.Manv = Manv; }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã phiếu phạt: ");
        this.Mapp = scanner.nextLine();
        System.out.print("Nhập mã độc giả: ");
        this.Madg = scanner.nextLine();
        System.out.print("Nhập tổng phạt: ");
        this.Tongphat = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Nhập mã nhân viên: ");
        this.Manv = scanner.nextLine();
    }

    public void xuat() {
        System.out.println("Mã phiếu phạt: " + Mapp);
        System.out.println("Mã độc giả: " + Madg);
        System.out.println("Tổng phạt: " + Tongphat);
        System.out.println("Mã nhân viên: " + Manv);
    }
}
