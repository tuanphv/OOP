import java.util.Scanner;
public class TacGia {
    private String tenTacGia;
    private String namSinhTG;
    private String quocGiaTG;
    public TacGia(){}

    public TacGia(String tenTacGia,String namSinhTG,String quocGiaTG){
        this.tenTacGia=tenTacGia;
        this.namSinhTG=namSinhTG;
        this.quocGiaTG=quocGiaTG;

    }
    public TacGia(TacGia tg1){
        this.tenTacGia=tg1.tenTacGia;
        this.namSinhTG=tg1.namSinhTG;
        this.quocGiaTG=tg1.quocGiaTG;
    }


    public String gettenTacGia(){
        return tenTacGia;
    }
    public String getnamSinhTG(){
        return namSinhTG;
    }
    public String  getquoGiaTG(){
        return quocGiaTG;
    }


    public void settenTacGia(String tenTacGia){
        this.tenTacGia=tenTacGia;
    }
    public void setnamSinhTG(String namSinhTG){
        this.namSinhTG=namSinhTG;
    }
    public void setquocGiaTG(String quocGiaTG){
        this.quocGiaTG=quocGiaTG;
    }

    public void nhap(){
        Scanner nhap = new Scanner (System.in);
        System.out.print("Nhap ten tac gia: ");
        tenTacGia=nhap.nextLine();
        System.out.print("Nhap nam sinh tac gia: ");
        namSinhTG=nhap.nextLine();
        System.out.print("Nhap quoc gia tac gia: ");
        quocGiaTG=nhap.nextLine();

    }

    public void xuat(){
        System.out.println("Ten tac gia: "+tenTacGia);
        System.out.println("Nam sinh tac gia: "+namSinhTG);
        System.out.println("Quoc gia cua tac gia: "+quocGiaTG);
    }
}
