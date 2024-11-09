import java.util.Scanner;
public class NhaXuatBan {
    private String maNXB;
    private String namThanhLap;
    private String quocGia;
    private String diaChiNXB;
    private String emailNXB;
    public NhaXuatBan(){}

    public NhaXuatBan(String maNXB,String namThanhLap,String quocGia,String diaChiNXB,String emailNXB){
        this.maNXB=maNXB;
        this.namThanhLap=namThanhLap;
        this.quocGia=quocGia;
        this.diaChiNXB=diaChiNXB;
        this.emailNXB=emailNXB;

    }
    public NhaXuatBan(NhaXuatBan nxb1){
        this.maNXB=nxb1.maNXB;
        this.namThanhLap=nxb1.namThanhLap;
        this.quocGia=nxb1.quocGia;
        this.diaChiNXB=nxb1.diaChiNXB;
        this.emailNXB=nxb1.emailNXB;
    }

    public String getmaNXB(){
        return maNXB;
    }
    public String getnamThanhLap(){
        return namThanhLap;
    }
    public String getquocGia(){
        return quocGia;
    }
    public String getdiaChiNXB(){
        return diaChiNXB;
    }
    public String getemailNXB(){
        return emailNXB;
    }

    
    public void setmaNXB(String maNXB){
        this.maNXB=maNXB;
    }
    public void setnamThanhLap(String namThanhLap){
        this.namThanhLap=namThanhLap;
    }
    public void setquocGia(String quocGia){
        this.quocGia=quocGia;
    }
    public void setdiaChiNXB(String diaChiNXB){
        this.diaChiNXB=diaChiNXB;
    }
    public void setemailNXB(String emailNXB){
        this.emailNXB=emailNXB;
    }

    public void nhap(){
        Scanner nhap= new Scanner(System.in);
        System.out.print("Nhap ma nha xuat ban: ");
        maNXB= nhap.nextLine();
        System.out.print("Nhap nam thanh lap: ");
        namThanhLap= nhap.nextLine();
        System.out.print("Nhap quoc gia: ");
        quocGia= nhap.nextLine();
        System.out.print("Nhap dia chi nha xuat ban: ");
        diaChiNXB= nhap.nextLine();
        System.out.print("Nhap email nha xuat ban: ");
        emailNXB= nhap.nextLine();
        nhap.close();
    }

    public void xuat(){
        System.out.println("Ma nha xuat ban: " + maNXB );
        System.out.println("Nam thanh lap: " + namThanhLap );
        System.out.println("Quoc gia: " + quocGia);
        System.out.println("Dia chi nha xuat ban: " + diaChiNXB );
        System.out.println("Email nha xuat ban: " + emailNXB );
    }
}
