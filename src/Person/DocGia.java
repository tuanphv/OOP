package Person;

import java.util.Scanner;

public class DocGia extends Person {
    private String maDG;
    private String hotenDG;
    private String sdtDG;
    private String emailDG;

    public DocGia() {
    }

    public DocGia(String maDG, String hotenDG, String sdtDG, String emailDG) {
        this.maDG = maDG;
        this.hotenDG = hotenDG;
        this.sdtDG = sdtDG;
        this.emailDG = emailDG;
    }

    public DocGia(DocGia dg1) {
        this.maDG = dg1.maDG;
        this.hotenDG = dg1.hotenDG;
        this.sdtDG = dg1.sdtDG;
        this.emailDG = dg1.emailDG;
    }

    public String getMaDG() {
        return maDG;
    }

    public String getHoTenDG() {
        return hotenDG;
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

    public void sethoTenDG(String hotenDG) {
        this.hotenDG = hotenDG;
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
        System.out.print("Nhap ho ten doc gia: ");
        hotenDG = nhap.nextLine();
        System.out.print("Nhap so dien thoai doc gia: ");
        sdtDG = nhap.nextLine();
        System.out.print("Nhap email doc gia: ");
        emailDG = nhap.nextLine();
        nhap.close();
    }

    public void xuat() {
        System.out.println("Ma doc gia: " + maDG);
        System.out.println("Ho ten doc gia: " + hotenDG );
        System.out.println("So dien thoai doc gia: " + sdtDG);
        System.out.println("Email doc gia:" + emailDG);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", maDG, hotenDG, sdtDG, emailDG);
    }
    public String[] toArray() {
        return new String[] { maDG, hotenDG, sdtDG, emailDG };
    }
}
