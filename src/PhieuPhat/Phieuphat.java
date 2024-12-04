package PhieuPhat;
import java.util.Scanner;

public class Phieuphat {
    private String Mapp;
    private String Madg;
    private String Manv;
    private Double Tongphat;

    public Phieuphat() {
    }

    public Phieuphat(String mapp, String madg, String manv, Double tongphat) {
        this.Mapp = mapp;
        this.Madg = madg;
        this.Manv = manv;
        this.Tongphat = tongphat;
    }

    public Phieuphat(Phieuphat s1) {
        this.Mapp = s1.Mapp;
        this.Madg = s1.Madg;
        this.Manv = s1.Manv;
        this.Tongphat = s1.Tongphat;
    }

    public String getMapp() {
        return Mapp;
    }

    public String getMadg() {
        return Madg;
    }

    public String getManv() {
        return Manv;
    }

    public Double getTongphat() {
        return Tongphat;
    }

    public void setMapp(String mapp) {
        this.Mapp = mapp;
    }

    public void setMadg(String madg) {
        this.Madg = madg;
    }

    public void setManv(String manv) {
        this.Manv = manv;
    }

    public void setTongphat(Double tongphat) {
        this.Tongphat = tongphat;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã phiếu phạt: ");
        this.Mapp = scanner.nextLine();
        System.out.print("Nhập mã độc giả: ");
        this.Madg = scanner.nextLine();
        System.out.print("Nhập mã nhân viên: ");
        this.Manv = scanner.nextLine();
        // nhập từng chi tiết phạt
        // System.out.print("Nhập tổng phạt: ");
        // this.Tongphat = scanner.nextDouble();
        scanner.close();
    }

    public void xuat() {
        System.out.println("Mã phiếu phạt: " + Mapp);
        System.out.println("Mã độc giả: " + Madg);
        System.out.println("Mã nhân viên: " + Manv);
        System.out.println("Tổng phạt: " + Tongphat);
    }
}
