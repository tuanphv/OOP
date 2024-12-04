package Person;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import Interface.IList;

public class DSNhanVien implements IList<NhanVien>{
    private NhanVien []dsnv= new NhanVien[0];
    Scanner nhap= new Scanner(System.in);

    public int size(){
        return dsnv.length;
    }

    public void add(NhanVien nv){
        int solg= dsnv.length;
        if (indexOf(nv.getMaNV())!= -1)
            System.out.println("Da co nhan vien trong danh sach");      
        else {
            dsnv= Arrays.copyOf(dsnv, solg+1);
            dsnv[solg]=nv;
        }
    }

    public void remove(NhanVien nv){
        int solg= dsnv.length;
        if(nv == null || indexOf(nv.getMaNV()) == -1)
            System.out.println("Nhan vien chua co trong danh sach");
        else {
            for(int i=indexOf(nv.getMaNV()); i<solg -1; i++)
                dsnv[i]= dsnv[i+1];
            dsnv= Arrays.copyOf(dsnv, solg-1);
        }
    }

    public NhanVien get (String ma){
        if(indexOf(ma)!= -1) return dsnv[indexOf(ma)];
        return null;
    }

    public NhanVien[] timTheoKhoangLuong(int from, int to){
        int solg= dsnv.length;
        NhanVien[] temp= new NhanVien [0];
        for(int i=0; i <solg; i++)
            if(Integer.parseInt(dsnv[i].getLuong()) >= from && Integer.parseInt(dsnv[i].getLuong()) <= to){
                int solg2= temp.length;
                temp= Arrays.copyOf(temp, solg2 +1);
                temp[solg2]= dsnv[i];
            }
        return temp;
    }

    public NhanVien[] timTheoGioiTinh(String gioiTinh){
        int solg= dsnv.length;
        NhanVien[] temp= new NhanVien [0];
        for(int i=0; i < solg; i++){
            if (dsnv[i].getgioiTinh().equalsIgnoreCase(gioiTinh)){
                int solg2= temp.length;
                temp= Arrays.copyOf(temp, solg2 +1);
                temp[solg2]= dsnv[i];
            }
        }
        return temp;
    }

    public NhanVien[] timTheoSDT(String sdt){
        int solg= dsnv.length;
        NhanVien[] temp= new NhanVien [0];
        for(int i=0; i < solg; i++){
            if (dsnv[i].getSdtNV().equalsIgnoreCase(sdt)){
                int solg2= temp.length;
                temp= Arrays.copyOf(temp, solg2 +1);
                temp[solg2]= dsnv[i];
            }
        }
        return temp;
    }

    public NhanVien[] timTheoChucVu(String chucVu){
        int solg= dsnv.length;
        NhanVien[] temp= new NhanVien [0];
        for(int i=0; i < solg; i++){
            if (dsnv[i].getChucVu().equalsIgnoreCase(chucVu)){
                int solg2= temp.length;
                temp= Arrays.copyOf(temp, solg2 +1);
                temp[solg2]= dsnv[i];
            }
        }
        return temp;
    }

    public NhanVien[] timTheoTen(String ten){
        int solg= dsnv.length;
        NhanVien[] temp= new NhanVien [0];
        for(int i=0; i < solg; i++){
            if (dsnv[i].getTenNV().equalsIgnoreCase(ten)){
                int solg2= temp.length;
                temp= Arrays.copyOf(temp, solg2 +1);
                temp[solg2]= dsnv[i];
            }
        }
        return temp;
    }

    public void suaNhanVien(NhanVien nv){
        if (nv== null){
            System.out.println("Nhan vien khong ton tai");
            return;
        }
        int index= indexOf(nv.getMaNV());
        dsnv[index].nhap();
    }

    public void hienthi(){
        System.out.println("----------THONG TIN TOAN BO NHAN VIEN----------");
        int solg= dsnv.length;
        if(isEmpty()) System.out.println("Danh sach rong");
        else{
            System.out.printf("%5s %10s %20s %20s %15s %10s %10s\n", "STT","MaNv", "TenNV", "ChucVuNV", "SdtNv", "GioiTinh", "Luong");
            for (int i=0; i< solg; i++){
                System.out.printf("%5s", i);
                dsnv[i].xuat();
            }
        }
    }

    public boolean isEmpty(){
        int solg= dsnv.length;
        if(solg ==0) return true;
        return false;
    }

    public void docFile(){
        try{
            FileReader fr= new FileReader("./lib/NV.txt");
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
            FileWriter fw= new FileWriter("./lib/NV.txt");
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

    public NhanVien[] timTheoMa(String ma){
        int solg= dsnv.length;
        NhanVien[] temp= new NhanVien[0];
        for(int i=0; i < solg; i++)
            if(dsnv[i].getMaNV().equals(ma)){
                temp= Arrays.copyOf(temp, temp.length+1);
                temp[temp.length-1]= dsnv[i];
            }
        return temp;
    }

    public void menu(){
        int input;
        do{
            System.out.println("----------QUAN LY NHAN VIEN----------");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Xoa nhan vien");
            System.out.println("3. Tim nhan vien theo ma");
            System.out.println("4. Tim nhan vien theo ten");
            System.out.println("5. Tim nhan vien theo chuc vu");
            System.out.println("6. Tim nhan vien theo sdt");
            System.out.println("7. Tim nhan vien theo gioi tinh");
            System.out.println("8. Tim nhan vien theo khoang luong");
            System.out.println("9. Sua thong tin nhan vien");
            System.out.println("10. Hien thi danh sach nhan vien");
            System.out.println("0. Thoat");
            input= Integer.parseInt(nhap.nextLine());
            if(input ==1){
                System.out.print("So nv muon them: ");
                int solg= Integer.parseInt(nhap.nextLine());
                for(int i=0;i<solg;i++){
                    NhanVien temp= new NhanVien();
                    temp.nhap();
                    add(temp);
                }
            };
            if(input== 2){
                System.out.println("So nv muon xoa");
                int solg= Integer.parseInt(nhap.nextLine());
                for(int i=0;i<solg;i++){
                    System.out.println("Nhap ma nv can xoa");
                    String temp= nhap.nextLine();
                    remove(get(temp));
                }
            }
            if(input==3){
                System.out.println("Nhap ma nv can tim");
                String temp= nhap.nextLine();
                NhanVien[] kq= timTheoMa(temp);
                System.out.println("Co " + kq.length + " ketqua");
                for(int i=0; i <kq.length; i++)
                    kq[i].xuat();
            }
            if(input==4){
                System.out.println("Nhap ten nv can tim");
                String temp= nhap.nextLine();
                NhanVien[] kq= timTheoTen(temp);
                System.out.println("Co " + kq.length + " ketqua");
                for(int i=0; i <kq.length; i++)
                    kq[i].xuat();
            }
            if (input==5){
                System.out.println("Nhap chuc vu nv can tim");
                String temp= nhap.nextLine();
                NhanVien[] kq= timTheoChucVu(temp);
                System.out.println("Co " + kq.length + " ketqua");
                for(int i=0; i < kq.length; i++)
                    kq[i].xuat();
    
            }
            if (input==6){
                System.out.println("Nhap sdt nv can tim");
                String temp= nhap.nextLine();
                NhanVien[] kq= timTheoSDT(temp);
                System.out.println("Co " + kq.length + " ketqua");
                for(int i=0; i < kq.length; i++)
                    kq[i].xuat();
            }
            if(input==7){
                System.out.print("Nhap gioi tinh nv can tim: ");
                String temp= nhap.nextLine();
                NhanVien[] kq= timTheoGioiTinh(temp);
                System.out.println("Co " + kq.length + " ketqua");
                for(int i=0; i <kq.length; i++)
                    kq[i].xuat();
            }
            if(input==8){
                System.out.println("Nhap khoang luong can tim");
                int from= Integer.parseInt(nhap.nextLine());
                int to= Integer.parseInt(nhap.nextLine());
                NhanVien[] kq= timTheoKhoangLuong(from, to);
                System.out.println("Co " + kq.length + " ketqua");
                for(int i=0; i < kq.length; i++)
                    kq[i].xuat();
            }
            if(input==9){
                System.out.print("Nhap ma nhan vien muon sua: ");
                String temp= nhap.nextLine();
                NhanVien nv= get(temp);
                suaNhanVien(nv);
            }
            if(input==10){
                hienthi();
            }
        }
        while(input != 0);
    }

    public int indexOf(String n){
        int solg= dsnv.length;
        for (int i=0; i< solg; i++)
            if (dsnv[i].getMaNV().equals(n))
                return i;
        return -1;
    }

}
