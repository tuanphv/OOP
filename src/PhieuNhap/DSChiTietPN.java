package PhieuNhap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DSChiTietPN {
    ChiTietPhieuNhap[] dsctpn= new ChiTietPhieuNhap[0];

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
    public ChiTietPhieuNhap[] get(String maPN){
        ChiTietPhieuNhap[] result= new ChiTietPhieuNhap[0];
        for(int i=0; i<dsctpn.length; i++){
            if(dsctpn[i].getMaPN().equals(maPN)){
                result= Arrays.copyOf(result, result.length+1);
                result[result.length-1]= dsctpn[i];
            }
        }
        return result;
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

    public void add(ChiTietPhieuNhap pn){
        int solg= dsctpn.length;
        if (indexOf(pn.getMaPN(), pn.getMaSach()) != -1) {
            System.out.println("Đã tồn tại sách trong chi tiết phiếu nhập");
            return;
        }
        dsctpn= Arrays.copyOf(dsctpn, solg+1);
        dsctpn[solg]= new ChiTietPhieuNhap(pn);
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
            BufferedReader br= new BufferedReader(new FileReader("./lib/CTPN.txt"));
            String line;
            while ((line = br.readLine() )!= null){
                String[] str= line.split(", ");
                ChiTietPhieuNhap ctpn= new ChiTietPhieuNhap(str[0], str[1], Integer.parseInt(str[2]), Integer.parseInt(str[3]));
                add(ctpn);
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
            BufferedWriter bw= new BufferedWriter(new FileWriter("./lib/CTPN.txt"));
            for(ChiTietPhieuNhap ctpn: dsctpn){
                bw.write(ctpn.toString());
                bw.newLine();
            }
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
