package PhieuNhap;
import java.util.Scanner;

public class PhieuNhap {
    private String maPN;
    private String ngayNhap;
    private String maNV;
    private String maNCC;
    private String tongtien;
    Scanner nhap= new Scanner(System.in);

    public PhieuNhap() {}
    public PhieuNhap(String maPN, String ngayNhap, String maNV, String maNCC){
        this.maNCC = maNCC;
        this.maPN = maPN;
        this.ngayNhap = ngayNhap;
        this.maNV = maNV;
    }

    public PhieuNhap(PhieuNhap pn){
        this.maNCC = pn.maNCC;
        this.maPN = pn.maPN;
        this.ngayNhap = pn.ngayNhap;
        this.maNV = pn.maNV;
        this.tongtien = pn.tongtien;
    }

    public String ktraNgayNhap(String ngayNhap){
        String regex= "^\\d{1,2}/\\d{1,2}/\\d{4}$";
        while(true){
            if(ngayNhap.matches(regex)){
                String[] temp= ngayNhap.split("/");
                int ngay = Integer.parseInt(temp[0]);
                int thang = Integer.parseInt(temp[1]);
                int nam = Integer.parseInt(temp[2]);
                
                if(ngay> 0 && ngay <32 && thang >0 && thang < 13 && nam > 0 && nam < 2025)
                    if (ngay <31 && (thang == 4 || thang ==6 || thang == 9 || thang == 11) )
                        return ngayNhap;
                    else if(ngay < 32 && (thang ==1 || thang ==3 || thang== 5 || thang ==7 || thang == 8 || thang== 10 || thang== 12))
                        return ngayNhap;
                    else if ((ngay < 29 && thang ==2) || ngay < 30 && thang== 2 && ((nam %4==0 && nam %100 !=0) || nam% 400== 0))
                        return ngayNhap;
            }
            System.out.print("Ngay nhap khong hop le. Nhap lai: ");
            ngayNhap= nhap.nextLine();
        }
    }

    public void setMaPN(String maPN){
        this.maPN = maPN;
    }

    public void setNgayNhap(String ngayNhap){
        this.ngayNhap = ktraNgayNhap(ngayNhap);
    }

    public void setMaNV(String maNV){
        this.maNV = maNV;
    }

    public void setMaNCC(String maNCC){
        this.maNCC = maNCC;
    }

    public void setTongtien(String tongtien){
        this.tongtien = tongtien;
    }

    public String getMaPN(){
        return maPN;
    }

    public String getNgayNhap(){
        return ngayNhap;
    }

    public String getMaNV(){
        return maNV;
    }

    public String getMaNCC(){
        return maNCC;
    }

    public String getTongtien(){
        return tongtien;
    }

    public void nhap(){
        System.out.print("Nhap ma phieu nhap: ");
        maPN = nhap.nextLine();
        System.out.print("Nhap ngay nhap (dd/mm/yyyy): ");
        ngayNhap = ktraNgayNhap(nhap.nextLine());
        System.out.print("Nhap ma nhan vien: ");
        maNV = nhap.nextLine();
        System.out.print("Nhap ma nha cung cap: ");
        maNCC = nhap.nextLine();
    }

    public void xuat(){
        System.out.printf("%10s%20s%10s%10s%10s\n", maPN, ngayNhap, maNV, maNCC, tongtien);
    }
}
