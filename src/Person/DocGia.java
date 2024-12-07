package Person;

import java.util.Scanner;

public class DocGia extends Person {
    private String maDG;
    private String hoDG;
    private String tenDG;
    private String sdtDG;
    private String emailDG;

    public DocGia() {
    }

    public DocGia(String maDG, String hoDG, String tenDG, String sdtDG, String emailDG) {
        this.maDG = maDG;
        this.hoDG = hoDG;
        this.tenDG = tenDG;
        this.sdtDG = sdtDG;
        this.emailDG = emailDG;
    }

    public DocGia(DocGia dg1) {
        this.maDG = dg1.maDG;
        this.hoDG = dg1.hoDG;
        this.tenDG = dg1.tenDG;
        this.sdtDG = dg1.sdtDG;
        this.emailDG = dg1.emailDG;
    }

    public String getMaDG() {
        return maDG;
    }

    public String getHoDG() {
        return hoDG;
    }

    public String getTenDG() {
        return tenDG;
    }

    public String getSdtDG() {
        return sdtDG;
    }

    public String getEmailDG() {
        return emailDG;
    }

    public void setmaDG(String maDG) {
        this.maDG = maDG;
    }

    public void sethoDG(String hoDG) {
        this.hoDG = hoDG;
    }

    public void settenDG(String tenDG) {
        this.tenDG = tenDG;
    }

    public void setsdtDG(String sdtDG) {
        this.sdtDG = sdtDG;
    }

    public void setemailDG(String emailDG) {
        this.emailDG = emailDG;
    }

    public void nhap() {
        Scanner nhap = new Scanner(System.in);
        if (maDG == "" || maDG == null) {
            System.out.print("Nhap ma doc gia: ");
            maDG = nhap.nextLine();
        }
        System.out.print("Nhap ho doc gia: ");
        hoDG = nhap.nextLine();
        System.out.print("Nhap ten doc gia: ");
        tenDG = nhap.nextLine();
        System.out.print("Nhap so dien thoai doc gia: ");
        sdtDG = nhap.nextLine();
        System.out.print("Nhap email doc gia: ");
        emailDG = nhap.nextLine();
        nhap.close();
    }

    public void xuat() {
        System.out.println("Ma doc gia: " + maDG);
        System.out.println("Ho ten doc gia: " + hoDG + " " + tenDG);
        System.out.println("So dien thoai doc gia: " + sdtDG);
        System.out.println("Email doc gia:" + emailDG);
    }

    @Override
    public String toString() {
        return maDG + ", " + hoDG + " " + tenDG + ", " + sdtDG + ", " + emailDG;
    }
}
