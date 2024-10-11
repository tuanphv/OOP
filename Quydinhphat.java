package PHAT;

import java.util.Scanner;

public class Quydinhphat {
    private String Maqd;
    private String Noidung;
    private Double Mucphat;

    public Quydinhphat() {}

    public Quydinhphat(String maqd, String noidung, Double mucphat) {
        this.Maqd = maqd;
        this.Noidung = noidung;
        this.Mucphat = mucphat;
    }

    public Quydinhphat(Quydinhphat s1) {
        this.Maqd = s1.Maqd;
        this.Noidung = s1.Noidung;
        this.Mucphat = s1.Mucphat;
    }

    public String getMaqd() { return Maqd; }
    public String getNoidung() { return Noidung; }
    public Double getMucphat() { return Mucphat; }

    public void setMaqd(String maqd) { this.Maqd = maqd; }
    public void setNoidung(String noidung) { this.Noidung = noidung; }
    public void setMucphat(Double mucphat) { this.Mucphat = mucphat; }

    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã quy định: ");
        this.Maqd = scanner.nextLine();
        System.out.print("Nhập nội dung: ");
        this.Noidung = scanner.nextLine();
        System.out.print("Nhập mức phạt: ");
        this.Mucphat = scanner.nextDouble();
    }

    public void Xuat() {
        System.out.println("Mã quy định: " + Maqd);
        System.out.println("Nội dung: " + Noidung);
        System.out.println("Mức phạt: " + Mucphat);
    }
}
