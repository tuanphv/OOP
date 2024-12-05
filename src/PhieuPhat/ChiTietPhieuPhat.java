package PhieuPhat;
import java.util.Scanner;

public class ChiTietPhieuPhat {
    private String Mapp;
    private String Masach;
    private String Maqd;
    private Double Tienphat;

    public ChiTietPhieuPhat() {
    }

    public ChiTietPhieuPhat(String mapp, String masach, String maqd, Double tienphat) {
        this.Mapp = mapp;
        this.Masach = masach;
        this.Maqd = maqd;
        this.Tienphat = tienphat;
    }

    public ChiTietPhieuPhat(ChiTietPhieuPhat s1) {
        this.Mapp = s1.Mapp;
        this.Masach = s1.Masach;
        this.Maqd = s1.Maqd;
        this.Tienphat = s1.Tienphat;
    }

    public String getMaPP() {
        return Mapp;
    }

    public String getMaSach() {
        return Masach;
    }

    public String getMaQD() {
        return Maqd;
    }

    public Double getTienPhat() {
        return Tienphat;
    }

    public void setMaPP(String mapp) {
        this.Mapp = mapp;
    }

    public void setMaSach(String masach) {
        this.Masach = masach;
    }

    public void setMaQD(String maqd) {
        this.Maqd = maqd;
    }

    public void setTienPhat(Double tienphat) {
        this.Tienphat = tienphat;
    }

    public void nhap() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập mã phiếu phạt: ");
            this.Mapp = scanner.nextLine();
            System.out.print("Nhập mã sách: ");
            this.Masach = scanner.nextLine();
            System.out.print("Nhập mã quy định: ");
            this.Maqd = scanner.nextLine();
            System.out.print("Nhập tiền phạt: ");
            this.Tienphat = Double.parseDouble(scanner.nextLine());
            scanner.close();
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Tiền phạt phải là số!");
            this.Tienphat = 0.0;
        }
    }

    public void xuat() {
        System.out.println("Mã phiếu phạt: " + Mapp);
        System.out.println("Mã sách: " + Masach);
        System.out.println("Mã quy định: " + Maqd);
        System.out.println("Tiền phạt: " + Tienphat);
    }

    @Override
    public String toString() {
        return Mapp + ", " + Masach + ", " + Maqd + ", " + Tienphat;
    }
}
