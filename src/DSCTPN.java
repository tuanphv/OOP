import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DSCTPN {
    ChiTietPhieuNhap[] dsctpn= new ChiTietPhieuNhap[0];
    Scanner nhap= new Scanner(System.in);

    public int size(){
        return dsctpn.length;
    }

    public boolean isEmpty(){
        if(dsctpn.length == 0) return true;
        return false;
    }

    public ChiTietPhieuNhap get(String maPN, String maSach){
        if(indexOf(maPN, maSach) != -1) return dsctpn[indexOf(maPN, maSach)];
        return null;
    }

    public int indexOf(String maPN, String maSach){
        int solg= dsctpn.length;
        for(int i=0; i<solg; i++){
            if(dsctpn[i].getMaPN().equals(maPN) && dsctpn[i].getMaSach().equals(maSach)){
                return i;
            }
        }
        return -1;
    }

    public void add(String maPN, String maSach, String soLuong, String donGia){
        int solg= dsctpn.length;
        if (indexOf(maPN, maSach) != -1) {
            System.out.println("Chi tiet phieu da ton tai");
            return;
        }
        dsctpn= Arrays.copyOf(dsctpn, solg+1);
        dsctpn[solg]= new ChiTietPhieuNhap(maPN, maSach, soLuong, donGia);
    }

    public void remove(ChiTietPhieuNhap ctpn){
        int solg= dsctpn.length;
        String maPN= ctpn.getMaPN();
        String maSach= ctpn.getMaSach();
        if (get(maPN, maSach) == null) {
            System.out.println("Chi tiet phieu chua co trong danh sach");
            return;
        }
        for(int i=indexOf(maPN, maSach); i<solg -1; i++)
            dsctpn[i]= dsctpn[i+1];
        dsctpn= Arrays.copyOf(dsctpn, solg-1);
    }

    public void docFile(){
        try{
            FileReader fr= new FileReader("./lib/CTPN.txt");
            BufferedReader br= new BufferedReader(fr);
            String line= br.readLine();
            while (line != null){
                System.out.println(line);
                line= br.readLine();
            }
            br.close();
        }
        catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
        finally{
            System.out.println("Da doc file xong");
        }
    }

    public void ghiFile(){
        try {
            FileWriter fw= new FileWriter("./lib/CTPN.txt");
            BufferedWriter bw= new BufferedWriter(fw);
            String line;
            line= nhap.nextLine();
            bw.write(line);
            bw.newLine();
            bw.close();
        }
        catch(IOException e){
            System.out.println("Loi khi ghi file: " + e);
        }
        finally{
            System.out.println("Da ghi file xong");
        }
    }

    public void tieude(){
        
    }

    public void hienthi(){

    }
}
