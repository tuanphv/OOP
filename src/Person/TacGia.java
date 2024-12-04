package Person;
import java.util.Scanner;

public class TacGia {
    private String maTG;
    private String tenTG;
    private String namSinhTG;
    private String quocGiaTG;

    public TacGia() {
    }

    public TacGia(String maTG, String tenTG, String namSinhTG, String quocGiaTG) {
        this.maTG = maTG;
        this.tenTG = tenTG;
        this.namSinhTG = namSinhTG;
        this.quocGiaTG = quocGiaTG;

    }

    public TacGia(TacGia tg1) {
        this.maTG = tg1.maTG;
        this.tenTG = tg1.tenTG;
        this.namSinhTG = tg1.namSinhTG;
        this.quocGiaTG = tg1.quocGiaTG;
    }

    public String getMaTG() {
        return maTG;
    }

    public String getTenTG() {
        return tenTG;
    }

    public String getNSinhTG() {
        return namSinhTG;
    }

    public String getQGiaTG() {
        return quocGiaTG;
    }

    public void setMaTG(String maTG) {
        this.maTG = maTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public void setNSinhTG(String namSinhTG) {
        this.namSinhTG = namSinhTG;
    }

    public void setQGiaTG(String quocGiaTG) {
        this.quocGiaTG = quocGiaTG;
    }

    public void nhap() {
        Scanner nhap = new Scanner(System.in);
        System.out.println("Nhap thong tin tac gia");
        System.out.print("Ma tac gia: ");
        maTG = nhap.nextLine();
        System.out.print("Ho ten: ");
        tenTG = nhap.nextLine();
        System.out.print("Nam sinh: ");
        namSinhTG = nhap.nextLine();
        System.out.print("Quoc gia: ");
        quocGiaTG = nhap.nextLine();
        nhap.close();
    }

    public void xuat() {
        System.out.println("Ma tac gia: " + maTG);
        System.out.println("Ten tac gia: " + tenTG);
        System.out.println("Nam sinh: " + namSinhTG);
        System.out.println("Quoc gia: " + quocGiaTG);
    }

    @Override
    public String toString() {
        return String.format("%-12s%-30s%-10s%-15s", maTG, tenTG, namSinhTG, quocGiaTG);
    }
}
