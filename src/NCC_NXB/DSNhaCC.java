package NCC_NXB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import Interface.IList;

public class DSNhaCC implements IList<NhaCungCap> {
    private NhaCungCap[] dsncc = new NhaCungCap[0];
    Scanner nhap = new Scanner(System.in);

    public int size() {
        return dsncc.length;
    }

    public int indexOf(String ma) {
        int solg= dsncc.length;
        for (int i = 0; i < solg; i++)
            if (dsncc[i].getMaNCC().equals(ma))
                return i;
        return -1;
    }

    public NhaCungCap get(String ma) {
        int index = indexOf(ma);
        if (index != -1)
            return dsncc[index];
        return null;
    }

    public boolean add(NhaCungCap ncc) {
        int solg = dsncc.length;
        if (indexOf(ncc.getMaNCC()) != -1)  return false;
        dsncc = Arrays.copyOf(dsncc, solg + 1);
        dsncc[solg] = ncc;
        return true;
        
    }

    public boolean isEmpty() {
        if (dsncc.length == 0)
            return true;
        return false;
    }

    public void remove(String ma) {
        int solg = dsncc.length;
        int index = indexOf(ma);
        if (index == -1)
            System.out.println("Nha cung cap chua co trong danh sach");
        else {
            for (int i = index; i < solg - 1; i++)
                dsncc[i] = dsncc[i + 1];
            dsncc = Arrays.copyOf(dsncc, solg - 1);
        }
    }

    public void docFile() {
        try {
            FileReader fr = new FileReader("./lib/NhaCungCap.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                NhaCungCap ncc;
                String[] data = line.split(", ");
                ncc= new NhaCungCap(data[0], data[1], data[2], data[3]);
                add(ncc);
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Khong doc duoc file");
        } finally {
            System.out.println("Doc file NhaCungCap.txt thanh cong");
        }
    }

    public void ghiFile() {
        try {
            FileWriter fw = new FileWriter("./lib/NhaCungCap.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            String line;
            for(int i=0; i<dsncc.length; i++){
                line= dsncc[i].toString();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Khong ghi duoc file");
        } finally {
            System.out.println("Ghi file NhaCungCap.txt thanh cong");
        }
    }

    public NhaCungCap[] timTheoMa(String ma) {
        int solg = dsncc.length;
        NhaCungCap[] temp = new NhaCungCap[0];
        for (int i = 0; i < solg; i++)
            if (dsncc[i].getMaNCC().equals(ma)) {
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = dsncc[i];
            }
        return temp;
    }

    public NhaCungCap[] timTheoTen(String ten) {
        int solg = dsncc.length;
        NhaCungCap[] temp = new NhaCungCap[0];
        for (int i = 0; i < solg; i++)
            if (dsncc[i].getTen().equalsIgnoreCase(ten)) {
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = dsncc[i];
            }
        return temp;
    }

    public NhaCungCap[] timTheoDiaChi(String diaChi) {
        int solg = dsncc.length;
        NhaCungCap[] temp = new NhaCungCap[0];
        for (int i = 0; i < solg; i++)
            if (dsncc[i].getDiaChi().equalsIgnoreCase(diaChi)) {
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = dsncc[i];
            }
        return temp;
    }

    public NhaCungCap[] timTheoSdt(String sdt) {
        int solg = dsncc.length;
        NhaCungCap[] temp = new NhaCungCap[0];
        for (int i = 0; i < solg; i++)
            if (dsncc[i].getSdt().equalsIgnoreCase(sdt)) {
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = dsncc[i];
            }
        return temp;
    }

    public void tieude() {
        System.out.printf("%10s%20s%20s%15s\n", "Ma NCC", "Ten NCC", "Dia chi", "SDT");
    }

    public void hienthi() {
        int solg = dsncc.length;
        if (isEmpty())
            System.out.println("Danh sach rong");
        else {
            System.out.println("----------THONG TIN TOAN BO NHA CUNG CAP----------");
            System.out.printf("%5s", "STT");
            tieude();
            for (int i = 0; i < solg; i++) {
                System.out.printf("%5s", i);
                dsncc[i].xuat();
            }
        }
    }

    public void suaNCC(NhaCungCap ncc) {
        if (ncc == null)
            System.out.println("Nha cung cap khong co trong danh sach");
        else {
            System.out.println("Nhap thong tin sua");
            dsncc[indexOf(ncc.getMaNCC())].nhap();
        }
    }

    public void menu() {
        int input;
        do {
            System.out.println("----------QUAN LY NHA CUNG CAP----------");
            System.out.println("1. Them nha cung cap");
            System.out.println("2. Xoa nha cung cap");
            System.out.println("3. Tim nha cung cap theo ma");
            System.out.println("4. Tim nha cung cap theo ten");
            System.out.println("5. Tim nha cung cap theo sdt");
            System.out.println("6. Tim nha cung cap theo dia chi");
            System.out.println("7. Sua thong tin nha cung cap");
            System.out.println("8. Hien thi danh sach nha cung cap");
            System.out.println("0. Thoat");
            input = Integer.parseInt(nhap.nextLine());
            if (input == 1) {
                System.out.print("Nhap so luong nha cung cap muon them: ");
                int solg = Integer.parseInt(nhap.nextLine());
                for (int i = 0; i < solg; i++) {
                    NhaCungCap temp = new NhaCungCap();
                    temp.nhap();
                    add(temp);
                }
            }
            if (input == 2) {
                System.out.print("Nhap so luong nha cung cap muon xoa: ");
                int solg = Integer.parseInt(nhap.nextLine());
                for (int i = 0; i < solg; i++) {
                    System.out.print("Nhap ma nha cung cap muon xoa: ");
                    String temp = nhap.nextLine();
                    remove(temp);
                }
            }
            if (input == 3) {
                System.out.println("Nhap ma nha cung cap muon tim: ");
                String temp = nhap.nextLine();
                NhaCungCap[] kq = timTheoMa(temp);
                System.out.println("Co " + kq.length + " kq");
                for (int i = 0; i < kq.length; i++) {
                    tieude();
                    kq[i].xuat();
                }
            }
            if (input == 4) {
                System.out.println("Nhap ten nha cung cap muon tim: ");
                String temp = nhap.nextLine();
                NhaCungCap[] kq = timTheoTen(temp);
                System.out.println("Co " + kq.length + " kq");
                for (int i = 0; i < kq.length; i++) {
                    tieude();
                    kq[i].xuat();
                }
            }
            if (input == 5) {
                System.out.println("Nhap sdt nha cung cap muon tim: ");
                String temp = nhap.nextLine();
                NhaCungCap[] kq = timTheoSdt(temp);
                System.out.println("Co " + kq.length + " kq");
                for (int i = 0; i < kq.length; i++) {
                    tieude();
                    kq[i].xuat();
                }
            }
            if (input == 6) {
                System.out.println("Nhap dia chi nha cung cap muon tim: ");
                String temp = nhap.nextLine();
                NhaCungCap[] kq = timTheoDiaChi(temp);
                System.out.println("Co " + kq.length + " kq");
                for (int i = 0; i < kq.length; i++) {
                    tieude();
                    kq[i].xuat();
                }
            }
            if (input == 7) {
                System.out.println("Nhap ma nha cung cap muon sua: ");
                String temp = nhap.nextLine();
                suaNCC(get(temp));
            }
            if (input == 8) {
                hienthi();
            }
        } while (input != 0);
    }
}
