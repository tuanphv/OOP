import java.util.Scanner;

public class Chitietphat {
    private String Mapp;
    private String Masach;
    private String Maqd;
    private Double Tienphat;

    public Chitietphat() {
    }

    public Chitietphat(String mapp, String masach, String maqd, Double tienphat) {
        this.Mapp = mapp;
        this.Masach = masach;
        this.Maqd = maqd;
        this.Tienphat = tienphat;
    }

    public Chitietphat(Chitietphat s1) {
        this.Mapp = s1.Mapp;
        this.Masach = s1.Masach;
        this.Maqd = s1.Maqd;
        this.Tienphat = s1.Tienphat;
    }

    public String getMapp() {
        return Mapp;
    }

    public String getMasach() {
        return Masach;
    }

    public String getMaqd() {
        return Maqd;
    }

    public Double getTienphat() {
        return Tienphat;
    }

    public void setMapp(String mapp) {
        this.Mapp = mapp;
    }

    public void setMasach(String masach) {
        this.Masach = masach;
    }

    public void setMaqd(String maqd) {
        this.Maqd = maqd;
    }

    public void setTienphat(Double tienphat) {
        this.Tienphat = tienphat;
    }

    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã phiếu phạt: ");
        this.Mapp = scanner.nextLine();
        System.out.print("Nhập mã sách: ");
        this.Masach = scanner.nextLine();
        System.out.print("Nhập mã quy định: ");
        this.Maqd = scanner.nextLine();
        System.out.print("Nhập tiền phạt: ");
        this.Tienphat = scanner.nextDouble();
        scanner.close();
    }

    public void Xuat() {
        System.out.println("Mã phiếu phạt: " + Mapp);
        System.out.println("Mã sách: " + Masach);
        System.out.println("Mã quy định: " + Maqd);
        System.out.println("Tiền phạt: " + Tienphat);
    }
}
