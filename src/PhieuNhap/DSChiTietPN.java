package PhieuNhap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

import Sach.DSSach;

public class DSChiTietPN {
    ChiTietPhieuNhap[] dsctpn= new ChiTietPhieuNhap[0];
    Scanner nhap= new Scanner(System.in);

    public int size(){
        return dsctpn.length;
    }

    public boolean isEmpty(){
        if(dsctpn.length == 0) return true;
        return false;
    }

    public void them(String maPN, String maSach, DSSach dsSach){
        ChiTietPhieuNhap ctpn= new ChiTietPhieuNhap();
        ctpn.setMaPN(maPN);
        ctpn.setMaSach(maSach);
        int donGia= dsSach.get(maSach).getDonGia();
        ctpn.setDonGia(donGia);
        ctpn.nhap(); //nhap so luong
        ctpn.setThanhTien(ctpn.getSoLuong(), ctpn.getDonGia());
        add(ctpn);
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
            if(dsctpn[i].getMaPN().equalsIgnoreCase(maPN) && dsctpn[i].getMaSach().equalsIgnoreCase(maSach)){
                return i;
            }
        }
        return -1;
    }

    public void add(ChiTietPhieuNhap ctpn){
        int solg= dsctpn.length;
        if (indexOf(ctpn.getMaPN(), ctpn.getMaSach()) != -1) {
            System.out.println("Đã tồn tại sách trong chi tiết phiếu nhập");
            return;
        }
        dsctpn= Arrays.copyOf(dsctpn, solg+1);
        dsctpn[solg]= ctpn;
    }

    public void edit(String maPN, String maSach, String maPNsua, DSSach dssach){
        if(get(maPN, maSach)== null){
            System.out.println("Chi tiet phieu chua co trong danh sach");
            return;
        }
        int index= indexOf(maPN, maSach);
        dsctpn[index].setMaPN(maPNsua);
        System.out.print("Nhap ma sach moi: ");
        String maSachSua= nhap.nextLine();
        dsctpn[index].setMaSach(maSachSua);
        // if(dssach.get(maSachSua)== null) {
        //     System.out.println("Sach moi khong ton tai trong danh sach");
        //     return;
        //}
        int donGia= dssach.get(maSachSua).getDonGia();
        dsctpn[index].setDonGia(donGia);
        dsctpn[index].nhap(); //nhap so luong
        dsctpn[index].setThanhTien(dsctpn[index].getSoLuong(), donGia);
    }

    public ChiTietPhieuNhap[] timTheoMaPN(String maPN){
        ChiTietPhieuNhap[] result= new ChiTietPhieuNhap[0];
        for(int i=0; i< dsctpn.length; i++){
            if(dsctpn[i].getMaPN().equalsIgnoreCase(maPN)){
                result= Arrays.copyOf(result, result.length+1);
                result[result.length-1]= dsctpn[i];
            }
        }
        return result;
    }

    public ChiTietPhieuNhap[] timTheoMaSach(String maSach){
        ChiTietPhieuNhap[] result= new ChiTietPhieuNhap[0];
        for(int i=0; i< dsctpn.length; i++){
            if(dsctpn[i].getMaPN().equalsIgnoreCase(maSach)){
                result= Arrays.copyOf(result, result.length+1);
                result[result.length-1]= dsctpn[i];
            }
        }
        return result;
    }

    public void xuatKQTimKiem(ChiTietPhieuNhap[] kq){
        if(kq.length==0){
            System.out.println("Khong tim thay kq");
            return;
        }
        tieude();
        for(int i=0; i< kq.length; i++){
            System.out.printf("%5d", i+1);
            kq[i].xuat();
        }
    }

    public int getTongTien(String maPN){ 
        int solg= dsctpn.length;
        int tongTien= 0;
        for(int i=0; i<solg; i++){
            if(dsctpn[i].getMaPN().equalsIgnoreCase(maPN))
                tongTien+= dsctpn[i].getThanhTien();
        }
        return tongTien;
    }

    public void remove(String maPN, String maSach){
        int solg= dsctpn.length;
        int index= indexOf(maPN, maSach);
        if (get(maPN, maSach) == null) {
            System.out.println("Chi tiet phieu chua co trong danh sach");
            return;
        }
        for (int i = index; i < solg - 1; i++) {
            dsctpn[i] = dsctpn[i + 1];
        }
        dsctpn= Arrays.copyOf(dsctpn, solg-1);
        System.out.println("Xoa thanh cong");
    }

    public void docFile(){
        try{
            BufferedReader br= new BufferedReader(new FileReader("./lib/ChiTietPhieuNhap.txt"));
            String line;
            line = br.readLine();
            while (line != null){
                String[] str= line.split(", ");
                ChiTietPhieuNhap ctpn= new ChiTietPhieuNhap(str[0], str[1], Integer.parseInt(str[2]), Integer.parseInt(str[3]));
                add(ctpn);
                line = br.readLine();
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
            BufferedWriter bw= new BufferedWriter(new FileWriter("./lib/ChiTietPhieuNhap.txt"));
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
            System.out.println("Doc file ChiTietPhieuNhap.txt thanh cong");
        }
    }

    public void tieude(){
        System.out.printf("%5s%10s%10s%15s%10s%20s\n", "STT", "Ma PN", "Ma Sach", "Don gia", "So luong", "Thanh tien");
    }

    public void hienthi(){
        int solg= dsctpn.length;
        tieude();
        for(int i=0; i<solg; i++)
            System.out.printf("%5s%10s%10s%15s%10s%20s\n", i+1, dsctpn[i].getMaPN(), dsctpn[i].getMaSach(), dsctpn[i].getDonGia(), dsctpn[i].getSoLuong(), dsctpn[i].getThanhTien());
    }
}
