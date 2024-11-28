import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DSPN implements IList<PhieuNhap>{
    PhieuNhap[] dspn= new PhieuNhap[0];
    Scanner nhap= new Scanner(System.in);

    public int size(){
        return dspn.length;
    }

    public void add(PhieuNhap pn){
        int solg= dspn.length;
        if (indexOf(pn.getMaPN())!= -1)
            System.out.println("Da co phieu nhap trong danh sach");      
        else {
            dspn= Arrays.copyOf(dspn, solg+1);
            dspn[solg]=pn;
        }
    }

    public void remove(PhieuNhap pn){
        int solg= dspn.length;
        if(pn == null || indexOf(pn.getMaPN()) == -1)
            System.out.println("Phieu nhap chua co trong danh sach");
        else {
            for(int i=indexOf(pn.getMaPN()); i<solg -1; i++)
                dspn[i]= dspn[i+1];
            dspn= Arrays.copyOf(dspn, solg-1);
        }
    }

    public PhieuNhap get (String ma){
        if(indexOf(ma)!= -1) return dspn[indexOf(ma)];
        return null;
    }

    public boolean isEmpty(){
        int solg= dspn.length;
        if(solg ==0) return true;
        return false;
    }

    public int indexOf(String n){
        int solg= dspn.length;
        for (int i=0; i< solg; i++)
            if (dspn[i].getMaPN().equals(n))
                return i;
        return -1;
    }

    public void docFile(){
        try{
            FileReader fr= new FileReader("./lib/PN.txt");
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
            FileWriter fw= new FileWriter("./lib/PN.txt");
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

    public void suaPhieuNhap(PhieuNhap pn){
        if (pn== null){
            System.out.println("Phieu nhap khong ton tai");
            return;
        }
        int index= indexOf(pn.getMaPN());
        dspn[index].nhap();
    }

    public PhieuNhap[] timTheoMaPN(String ma){
        int solg= dspn.length;
        PhieuNhap[] temp= new PhieuNhap[0];
        for(int i=0; i < solg; i++)
            if(dspn[i].getMaPN().equals(ma)){
                temp= Arrays.copyOf(temp, temp.length+1);
                temp[temp.length-1]= dspn[i];
            }
        return temp;
    }

    public PhieuNhap[] timTheoMaNV(String ma){
        int solg= dspn.length;
        PhieuNhap[] temp= new PhieuNhap[0];
        for(int i=0; i < solg; i++)
            if(dspn[i].getMaNV().equals(ma)){
                temp= Arrays.copyOf(temp, temp.length+1);
                temp[temp.length-1]= dspn[i];
            }
        return temp;
    }

    public PhieuNhap[] timTheoMaNCC(String ma){
        int solg= dspn.length;
        PhieuNhap[] temp= new PhieuNhap[0];
        for(int i=0; i < solg; i++)
            if(dspn[i].getMaNCC().equals(ma)){
                temp= Arrays.copyOf(temp, temp.length+1);
                temp[temp.length-1]= dspn[i];
            }
        return temp;
    }

    public PhieuNhap[] timtheoNgayNhap(String from, String to){
        int solg= dspn.length;
        PhieuNhap[] kq= new PhieuNhap[0];
        String[] temp= from.split("/");
        int ngayBD = Integer.parseInt(temp[0]);
        int thangBD = Integer.parseInt(temp[1]);
        int namBD = Integer.parseInt(temp[2]);

        String[] temp1= to.split("/");
        int ngayKT = Integer.parseInt(temp1[0]);
        int thangKT = Integer.parseInt(temp1[1]);
        int namKT = Integer.parseInt(temp1[2]);

        for(int i=0; i< solg; i++){
            String[] temp2= dspn[i].getNgayNhap().split("/");
            int ngay = Integer.parseInt(temp2[0]);
            int thang = Integer.parseInt(temp2[1]);
            int nam = Integer.parseInt(temp2[2]);
            if(namBD <= nam && nam <= namKT){
                kq= Arrays.copyOf(kq, kq.length + 1);
                kq[kq.length-1] = dspn[i];
            } 
            else if( thangBD <= thang && thang <= thangKT){
                kq= Arrays.copyOf(kq, kq.length + 1);
                kq[kq.length-1] = dspn[i];
            } 
            else if (ngayBD  <= ngay && ngay <= ngayKT){
                kq= Arrays.copyOf(kq, kq.length + 1);
                kq[kq.length-1] = dspn[i];
            }
        }
        return kq;
   } 
   
    // public PhieuNhap[] thongkeTheoThang(int thang, int nam){
    //     PhieuNhap[] kq= new PhieuNhap[0];
    //     String from= "1/" + thang + "/" + nam;
    //     String to= "31/" + thang + "/" + nam;
    //     kq= timtheoNgayNhap(from, to);
    //     return kq;
    // }

    public PhieuNhap[] timtheoTongTien(int from, int to){
        int solg= dspn.length;
        PhieuNhap[] temp= new PhieuNhap[0];
        for(int i=0; i< solg; i++)
            if(Integer.parseInt(dspn[i].getTongtien()) >= from && Integer.parseInt(dspn[i].getTongtien()) <= to){
                temp= Arrays.copyOf(temp, temp.length+ 1);
                temp[temp.length-1]= dspn[i];
            }
        return temp;
    }

    public void tieude(){
        System.out.printf("%10s%20s%10s%10s%10s\n", "Ma PN", "Ngay nhap", "MaNV", "MaNCC", "Tong Tien");
    }

    public void hienthi(){
        int solg= dspn.length;
        if (isEmpty()) System.out.println("Danh sach rong");
        else{
            System.out.println("----------THONG TIN TOAN BO PHIEU NHAP----------");
            System.out.printf("%5s", "STT");
            tieude();
            for(int i=0; i <solg; i++){
                System.out.printf("%5s", i);
                dspn[i].xuat();
            }
        }
    }

    // public void menu(){
    //     int input;
    //     do{
    //         System.out.println("----------QUAN LY PHIEU NHAP----------");
    //         System.out.println("1. Them phieu nhap");
    //         System.out.println("2. Xoa phieu nhap");
    //         System.out.println("3. Tim phieu nhap theo maPN");
    //         System.out.println("4. Tim phieu nhap theo maNV");
    //         System.out.println("5. Tim phieu nhap theo maNCC");
    //         System.out.println("6. Tim phieu nhap theo thoi gian");
    //         System.out.println("7. Tim phieu nhap theo tong tien");
    //         System.out.println("8. Thong ke phieu nhap theo thang");
    //         System.out.println("9. Sua thong tin phieu nhap");
    //         System.out.println("10. Hien thi danh sach phieu nhap");
    //         System.out.println("0. Thoat");
    //         input = Integer.parseInt(nhap.nextLine());
    //         if(input== 1){
    //             System.out.print("Nhap so luong phieu nhap muon them: ");
    //             int solg= Integer.parseInt(nhap.nextLine());
    //             for(int i=0; i <solg; i++){
    //                 PhieuNhap temp= new PhieuNhap();
    //                 temp.nhap();
    //                 add(temp);
    //             }
    //         }
    //         if(input==2){
    //             System.out.print("Nhap so luong phieu nhap muon xoa: ");
    //             int solg= Integer.parseInt(nhap.nextLine());
    //             for(int i=0; i <solg; i++){
    //                 System.out.print("Nhap ma phieu nhap muon xoa: ");
    //                 String temp= nhap.nextLine();
    //                 remove(get(temp));
    //             }
    //         }
    //         if(input==3){
    //             System.out.println("Nhap ma phieu nhap muon tim: ");
    //             String temp= nhap.nextLine();
    //             PhieuNhap[] kq= timTheoMaPN(temp);
    //             System.out.println("Co " + kq.length + " kq");
    //             for(int i=0; i < kq.length; i++){
    //                 tieude();
    //                 kq[i].xuat();
    //             }
    //         }
    //         if(input==4){
    //             System.out.println("Nhap ma nhan vien lap phieu nhap muon tim: ");
    //             String temp= nhap.nextLine();
    //             PhieuNhap[] kq= timTheoMaNV(temp);
    //             System.out.println("Co " + kq.length + " kq");
    //             for(int i=0; i < kq.length; i++){
    //                 tieude();
    //                 kq[i].xuat();
    //             }
    //         }
    //         if(input==5){
    //             System.out.println("Nhap ma nha cung cap cua phieu nhap muon tim: ");
    //             String temp= nhap.nextLine();
    //             PhieuNhap[] kq= timTheoMaNCC(temp);
    //             System.out.println("Co " + kq.length + " kq");
    //             for(int i=0; i < kq.length; i++){
    //                 tieude();
    //                 kq[i].xuat();
    //             }
    //         }
    //         if(input==6){
    //             System.out.println("Nhap thoi gian tu: ");
    //             String from= ktraNgayNhap(nhap.nextLine());
    //             System.out.println("Nhap thoi gian den: ");
    //             String to= ktraNgayNhap(nhap.nextLine());
    //             PhieuNhap[] kq= timtheoNgayNhap(from, to);
    //             System.out.println("Co " + kq.length + " kq");
    //             for(int i=0; i < kq.length; i++){
    //                 tieude();
    //                 kq[i].xuat();
    //             }
    //         }
    //         if(input==7){
    //             System.out.println("Nhap tong tien muon tim: ");
    //             int from= Integer.parseInt(nhap.nextLine());
    //             int to= Integer.parseInt(nhap.nextLine());
    //             nhap.nextLine();
    //             PhieuNhap[] kq= timtheoTongTien(from, to);
    //             System.out.println("Co " + kq.length + " kq");
    //             for(int i=0; i < kq.length; i++){
    //                 tieude();
    //                 kq[i].xuat();
    //             }
    //         }
    //         if(input==8){
    //             System.out.println("Nhap nam muon thong ke: ");
    //             int nam= Integer.parseInt(nhap.nextLine());
    //             System.out.println("Nhap thang muon thong ke: ");
    //             int thang= Integer.parseInt(nhap.nextLine());
    //             PhieuNhap[] kq= thongkeTheoThang(thang, nam);
    //             System.out.println("Co " + kq.length + " phieu nhap");
    //             for(int i=0; i < kq.length; i++){
    //                 tieude();
    //                 kq[i].xuat();
    //             }
    //         }
    //         if(input==9){
    //             System.out.println("Nhap ma phieu muon sua: ");
    //             String temp= nhap.nextLine();
    //             suaPhieuNhap(get(temp));
    //         }
    //         if(input == 10){
    //             hienthi();
    //         }
    //     }
    //     while(input != 0);
    // }

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
}