package PhieuNhap;

import Interface.IList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;

public class DSPhieuNhap implements IList<PhieuNhap> {
    PhieuNhap[] dspn = new PhieuNhap[0];
    Scanner nhap = new Scanner(System.in);

    public int size() {
        return dspn.length;
    }

    public boolean add(PhieuNhap pn) {
        int solg = dspn.length;
        if (indexOf(pn.getMaPN()) == -1) {
            dspn = Arrays.copyOf(dspn, solg + 1);
            dspn[solg] = pn;
            return true;
        }
        return false;
    }

    public void them(String maPN, String maNV, String maNCC){
        PhieuNhap pn = new PhieuNhap();
        pn.setMaPN(maPN);
        pn.setMaNV(maNV);
        pn.setMaNCC(maNCC);
        pn.nhap();//nhap ngay thang
        while(add(pn)== false){
            System.out.println("Ma phieu nhap da ton tai. Nhap lai:");
            maPN = nhap.nextLine();
            pn.setMaPN(maPN);
            pn.setMaNV(maNV);
            pn.setMaNCC(maNCC);
            pn.nhap();
        }
    }

    public void setTongTien(String maPN, int tongTien){
        int index= indexOf(maPN);
        dspn[index].setTongtien(tongTien);
    }

    public void remove(String ma) {
        int solg = dspn.length;
        int index = indexOf(ma);
        if (index == -1){
            System.out.println("Khong co phieu nhap trong danh sach");
            return;
        }
        else {
            for (int i = index; i < solg - 1; i++) {
                dspn[i] = dspn[i + 1];
            }
            dspn = Arrays.copyOf(dspn, solg-1);
            System.out.println("Da xoa phieu nhap");
        }
    }

    public PhieuNhap get(String ma) {
        if (indexOf(ma) != -1)
            return dspn[indexOf(ma)];
        return null;
    }

    public boolean isEmpty() {
        int solg = dspn.length;
        if (solg == 0)
            return true;
        return false;
    }

    public int indexOf(String n) {
        int solg = dspn.length;
        for (int i = 0; i < solg; i++)
            if (dspn[i].getMaPN().equals(n))
                return i;
        return -1;
    }

    public void edit(String MaPN, String maPNsua){
        if(indexOf(MaPN)==-1) {
            System.out.println("Khong co phieu nhap trong danh sach");
            return;
        }
        int index= indexOf(MaPN);
        dspn[index].setMaPN(maPNsua);
        System.out.println("Nhap ma Nv lap phieu: ");
        String MaNV = nhap.nextLine();
        dspn[index].setMaNV(MaNV);
        System.out.println("Nhap ma NCC lap phieu: ");
        String MaNCC = nhap.nextLine();
        dspn[index].setMaNCC(MaNCC);
        dspn[index].nhap();
    }

    public void docFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./lib/PhieuNhap.txt"));
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split(", ");
                PhieuNhap pn = new PhieuNhap(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]));
                add(pn);
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        } finally {
            System.out.println("Doc file PhieuNhap.txt thanh cong");
        }
    }

    public void ghiFile() {
        try {
            FileWriter fw = new FileWriter("./lib/PhieuNhap.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            String line;
            for(int i=0; i<dspn.length; i++){
                line= dspn[i].toString();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e);
        } finally {
            System.out.println("Ghi file PhieuNhap.txt thanh cong");
        }
    }

    public void suaPhieuNhap(PhieuNhap pn) {
        if (pn == null) {
            System.out.println("Phieu nhap khong ton tai");
            return;
        }
        int index = indexOf(pn.getMaPN());
        dspn[index].nhap();
    }

    public PhieuNhap[] timTheoMaPN(String ma) {
        int solg = dspn.length;
        PhieuNhap[] temp = new PhieuNhap[0];
        for (int i = 0; i < solg; i++)
            if (dspn[i].getMaPN().equals(ma)) {
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = dspn[i];
            }
        return temp;
    }

    public PhieuNhap[] timTheoMaNV(String ma) {
        int solg = dspn.length;
        PhieuNhap[] temp = new PhieuNhap[0];
        for (int i = 0; i < solg; i++)
            if (dspn[i].getMaNV().equals(ma)) {
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = dspn[i];
            }
        return temp;
    }

    public PhieuNhap[] timTheoMaNCC(String ma) {
        int solg = dspn.length;
        PhieuNhap[] temp = new PhieuNhap[0];
        for (int i = 0; i < solg; i++)
            if (dspn[i].getMaNCC().equals(ma)) {
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = dspn[i];
            }
        return temp;
    }

    public PhieuNhap[] timtheoNgayNhap(String from, String to) {
        
        int solg = dspn.length;
        PhieuNhap[] kq= new PhieuNhap[0];
        DateTimeFormatter formater= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ngayBD;
        LocalDate ngayKT;
        while (true){
            try{
                ngayBD= LocalDate.parse(from, formater);
                ngayKT= LocalDate.parse(to, formater);
                break;
            }
            catch(DateTimeParseException e){
                System.out.println("Loi ngay thang, nhap lai(dd/MM/yyyy): ");
                System.out.println("Tu ngay: ");from= nhap.nextLine();
                System.out.println("Den ngay: ");to= nhap.nextLine();
            }
        }
        for (int i = 0; i < solg; i++) {
            LocalDate ngay= LocalDate.parse(dspn[i].getNgayNhap(), formater);
            if((ngayBD.isEqual(ngay) || ngayBD.isBefore(ngay)) && (ngayKT.isEqual(ngay) || ngayKT.isAfter(ngay))){
                kq= Arrays.copyOf(kq, kq.length+1);
                kq[kq.length-1]= dspn[i];
            }
        }
        return kq;
    }

    // public PhieuNhap[] thongkeTheoThang(int thang, int nam){
    // PhieuNhap[] kq= new PhieuNhap[0];
    // String from= "1/" + thang + "/" + nam;
    // String to= "31/" + thang + "/" + nam;
    // kq= timtheoNgayNhap(from, to);
    // return kq;
    // }

    public PhieuNhap[] timTheoTongTien(int from, int to) {
        int solg = dspn.length;
        PhieuNhap[] temp = new PhieuNhap[0];
        for (int i = 0; i < solg; i++)
            if (dspn[i].getTongtien() >= from && dspn[i].getTongtien() <= to) {
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = dspn[i];
            }
        return temp;
    }

    public void tieude() {
        System.out.printf("%5s%10s%20s%10s%10s%10s\n","STT", "Ma PN", "Ngay nhap", "MaNV", "MaNCC", "Tong Tien");
    }

    public void hienthi() {
        int solg = dspn.length;
        if (isEmpty())
            System.out.println("Danh sach rong");
        else {
            
            for (int i = 0; i < solg; i++) {
                System.out.printf("%5s", i);
                dspn[i].xuat();
            }
        }
    }

    public void xuatKQTimKiem(PhieuNhap[] kq) {
        if (kq == null) {
            System.out.println("Khong tim thay phieu nhap nao");
            return;
        }
        tieude();
        int solg = kq.length;
        for (int i = 0; i < solg; i++) {
            System.out.printf("%5s", i);
            kq[i].xuat();
        }
    }

    
    // public void menu(){
    // int input;
    // do{
    // System.out.println("----------QUAN LY PHIEU NHAP----------");
    // System.out.println("1. Them phieu nhap");
    // System.out.println("2. Xoa phieu nhap");
    // System.out.println("3. Tim phieu nhap theo maPN");
    // System.out.println("4. Tim phieu nhap theo maNV");
    // System.out.println("5. Tim phieu nhap theo maNCC");
    // System.out.println("6. Tim phieu nhap theo thoi gian");
    // System.out.println("7. Tim phieu nhap theo tong tien");
    // System.out.println("8. Thong ke phieu nhap theo thang");
    // System.out.println("9. Sua thong tin phieu nhap");
    // System.out.println("10. Hien thi danh sach phieu nhap");
    // System.out.println("0. Thoat");
    // input = Integer.parseInt(nhap.nextLine());
    // if(input== 1){
    // System.out.print("Nhap so luong phieu nhap muon them: ");
    // int solg= Integer.parseInt(nhap.nextLine());
    // for(int i=0; i <solg; i++){
    // PhieuNhap temp= new PhieuNhap();
    // temp.nhap();
    // add(temp);
    // }
    // }
    // if(input==2){
    // System.out.print("Nhap so luong phieu nhap muon xoa: ");
    // int solg= Integer.parseInt(nhap.nextLine());
    // for(int i=0; i <solg; i++){
    // System.out.print("Nhap ma phieu nhap muon xoa: ");
    // String temp= nhap.nextLine();
    // remove(get(temp));
    // }
    // }
    // if(input==3){
    // System.out.println("Nhap ma phieu nhap muon tim: ");
    // String temp= nhap.nextLine();
    // PhieuNhap[] kq= timTheoMaPN(temp);
    // System.out.println("Co " + kq.length + " kq");
    // for(int i=0; i < kq.length; i++){
    // tieude();
    // kq[i].xuat();
    // }
    // }
    // if(input==4){
    // System.out.println("Nhap ma nhan vien lap phieu nhap muon tim: ");
    // String temp= nhap.nextLine();
    // PhieuNhap[] kq= timTheoMaNV(temp);
    // System.out.println("Co " + kq.length + " kq");
    // for(int i=0; i < kq.length; i++){
    // tieude();
    // kq[i].xuat();
    // }
    // }
    // if(input==5){
    // System.out.println("Nhap ma nha cung cap cua phieu nhap muon tim: ");
    // String temp= nhap.nextLine();
    // PhieuNhap[] kq= timTheoMaNCC(temp);
    // System.out.println("Co " + kq.length + " kq");
    // for(int i=0; i < kq.length; i++){
    // tieude();
    // kq[i].xuat();
    // }
    // }
    // if(input==6){
    // System.out.println("Nhap thoi gian tu: ");
    // String from= ktraNgayNhap(nhap.nextLine());
    // System.out.println("Nhap thoi gian den: ");
    // String to= ktraNgayNhap(nhap.nextLine());
    // PhieuNhap[] kq= timtheoNgayNhap(from, to);
    // System.out.println("Co " + kq.length + " kq");
    // for(int i=0; i < kq.length; i++){
    // tieude();
    // kq[i].xuat();
    // }
    // }
    // if(input==7){
    // System.out.println("Nhap tong tien muon tim: ");
    // int from= Integer.parseInt(nhap.nextLine());
    // int to= Integer.parseInt(nhap.nextLine());
    // nhap.nextLine();
    // PhieuNhap[] kq= timtheoTongTien(from, to);
    // System.out.println("Co " + kq.length + " kq");
    // for(int i=0; i < kq.length; i++){
    // tieude();
    // kq[i].xuat();
    // }
    // }
    // if(input==8){
    // System.out.println("Nhap nam muon thong ke: ");
    // int nam= Integer.parseInt(nhap.nextLine());
    // System.out.println("Nhap thang muon thong ke: ");
    // int thang= Integer.parseInt(nhap.nextLine());
    // PhieuNhap[] kq= thongkeTheoThang(thang, nam);
    // System.out.println("Co " + kq.length + " phieu nhap");
    // for(int i=0; i < kq.length; i++){
    // tieude();
    // kq[i].xuat();
    // }
    // }
    // if(input==9){
    // System.out.println("Nhap ma phieu muon sua: ");
    // String temp= nhap.nextLine();
    // suaPhieuNhap(get(temp));
    // }
    // if(input == 10){
    // hienthi();
    // }
    // }
    // while(input != 0);
    // }
}
