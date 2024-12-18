package Person;

import Format.ANSI;
import Interface.IList;
import Validate.Validate;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DSNhanVien implements IList<NhanVien> {
    private NhanVien[] dsnv = new NhanVien[0];
    Scanner nhap = new Scanner(System.in);

    public int size() {
        return dsnv.length;
    }

    public boolean add(NhanVien nv) {
        int solg = dsnv.length;
        if (indexOf(nv.getMaNV()) != -1) {
            return false;
        }
        dsnv = Arrays.copyOf(dsnv, solg + 1);
        dsnv[solg] = nv;
        return true;
    }

    public void them(){
        NhanVien nv = new NhanVien();
        nv.nhap(nhap);
        while(add(nv) == false)
            System.out.println("Ma nhan vien da ton tai. Nhap lai");
            nv.nhap(nhap);
    }

    public void edit(String ma) {
        int index = indexOf(ma);
        if (index == -1)
            System.out.println("Khong tim thay nhan vien can sua");
        else {
            NhanVien nv = new NhanVien();
            nv.nhap(nhap);
            dsnv[index] = nv;
        }
    }

    public void remove(String ma) {
        int solg = dsnv.length;
        int index = indexOf(ma);
        if (index == -1)
            System.out.println("Khong tim thay nhan vien can xoa");
        else {
            for (int i = index; i < solg - 1; i++)
                dsnv[i] = dsnv[i + 1];
            dsnv = Arrays.copyOf(dsnv, solg - 1);
        }
    }

    public NhanVien get(String ma) {
        if (indexOf(ma) != -1)
            return dsnv[indexOf(ma)];
        return null;
    }

    public NhanVien[] timTheoKhoangLuong(int from, int to) {
        int solg = dsnv.length;
        NhanVien[] temp = new NhanVien[0];
        for (int i = 0; i < solg; i++)
            if (dsnv[i].getLuong() >= from && dsnv[i].getLuong() <= to) {
                int solg2 = temp.length;
                temp = Arrays.copyOf(temp, solg2 + 1);
                temp[solg2] = dsnv[i];
            }
        return temp;
    }

    public NhanVien[] timTheoGioiTinh(String gioiTinh) {
        int solg = dsnv.length;
        NhanVien[] temp = new NhanVien[0];
        for (int i = 0; i < solg; i++) {
            if (dsnv[i].getgioiTinh().equalsIgnoreCase(gioiTinh)) {
                int solg2 = temp.length;
                temp = Arrays.copyOf(temp, solg2 + 1);
                temp[solg2] = dsnv[i];
            }
        }
        return temp;
    }

    public NhanVien[] timTheoSDT(String sdt) {
        int solg = dsnv.length;
        NhanVien[] temp = new NhanVien[0];
        for (int i = 0; i < solg; i++) {
            if (dsnv[i].getSdtNV().equalsIgnoreCase(sdt)) {
                int solg2 = temp.length;
                temp = Arrays.copyOf(temp, solg2 + 1);
                temp[solg2] = dsnv[i];
            }
        }
        return temp;
    }

    public NhanVien[] timTheoChucVu(String chucVu) {
        int solg = dsnv.length;
        NhanVien[] temp = new NhanVien[0];
        for (int i = 0; i < solg; i++) {
            if (dsnv[i].getChucVu().equalsIgnoreCase(chucVu)) {
                int solg2 = temp.length;
                temp = Arrays.copyOf(temp, solg2 + 1);
                temp[solg2] = dsnv[i];
            }
        }
        return temp;
    }

    public NhanVien[] timTheoTen(String ten) {
        int solg = dsnv.length;
        NhanVien[] temp = new NhanVien[0];
        for (int i = 0; i < solg; i++) {
            if (dsnv[i].getTenNV().equalsIgnoreCase(ten)) {
                int solg2 = temp.length;
                temp = Arrays.copyOf(temp, solg2 + 1);
                temp[solg2] = dsnv[i];
            }
        }
        return temp;
    }

    public void tieude(){
        System.out.printf("%5s%10s%20s%20s%15s%10s%10s\n", "STT", "MaNv", "TenNV", "ChucVuNV", "SdtNv",
                    "GioiTinh", "Luong");
    }

    public void hienthi() {
        int solg= dsnv.length;
        String[] title = { "MaNV", "TenNV", "ChucVuNV", "SdtNV", "GioiTinh", "Luong" };
            String[][] data = new String[solg][];
            for (int i = 0; i < solg; i++) {
                data[i] = dsnv[i].toArray();
            }
            new ANSI(title, data).printTable();
    }

    public boolean isEmpty() {
        int solg = dsnv.length;
        if (solg == 0)
            return true;
        return false;
    }

    public void docFile() {
        try {
            FileReader fr = new FileReader("./lib/NhanVien.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split(", ");
                NhanVien nv = new NhanVien(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]), arr[4], arr[5]);
                add(nv);
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        } finally {
            System.out.println("Doc file NhanVien.txt thanh cong");
        }
    }

    public void ghiFile() {
        try {
            FileWriter fw = new FileWriter("./lib/NhanVien.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            String line;
            for (int i = 0; i < dsnv.length; i++) {
                line = dsnv[i].toString();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e);
        } finally {
            System.out.println("Ghi file NhanVien.txt thanh cong");
        }
    }

    public NhanVien[] timTheoMa(String ma) {
        int solg = dsnv.length;
        NhanVien[] temp = new NhanVien[0];
        for (int i = 0; i < solg; i++)
            if (dsnv[i].getMaNV().equals(ma)) {
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = dsnv[i];
            }
        return temp;
    }

    public void xuatKQ(NhanVien[] kq) {
        int solg = kq.length;
        if (solg == 0)
            System.out.println("Khong tim thay ket qua");
        else {
            String[] title = { "MaNV", "TenNV", "ChucVuNV", "SdtNV", "GioiTinh", "Luong" };
            String[][] data = new String[solg][];
            for (int i = 0; i < solg; i++) {
                data[i] = kq[i].toArray();
            }
            new ANSI(title, data).printTable();
        }
    }

    public void menu(Scanner nhap) {
        int input;
        do {
            new ANSI(new String[] { "Menu Quan ly nhan vien".toUpperCase() },
                    new String[][] {
                            { "1. Them nhan vien" },
                            { "2. Xoa nhan vien" },
                            { "3. Tim nhan vien theo ma" },
                            { "4. Tim nhan vien theo ten" },
                            { "5. Tim nhan vien theo chuc vu" },
                            { "6. Tim nhan vien theo sdt" },
                            { "7. Tim nhan vien theo gioi tinh" },
                            { "8. Tim nhan vien theo khoang luong" },
                            { "9. Sua thong tin nhan vien" },
                            { "10. Hien thi danh sach nhan vien" },
                            { "0. Thoat" }
                    }).printTable();
            input = Validate.getChoice(nhap, 0, 10);
            String text;
            switch (input) {
                case 1:
                    System.out.print("So nv muon them: ");
                    int solgthem = Integer.parseInt(nhap.nextLine());
                    for (int i = 0; i < solgthem; i++) {
                        NhanVien temp = new NhanVien();
                        temp.nhap(nhap);
                        add(temp);
                    }
                    break;
                case 2:
                    System.out.println("So nv muon xoa");
                    int solgxoa = Integer.parseInt(nhap.nextLine());
                    for (int i = 0; i < solgxoa; i++) {
                        System.out.println("Nhap ma nv can xoa");
                        String temp = nhap.nextLine();
                        remove(temp);
                    }
                    break;
                case 3:
                    System.out.println("Nhap ma nv can tim");
                    text = nhap.nextLine();
                    NhanVien[] kq = timTheoMa(text);
                    System.out.println("Co " + kq.length + " ketqua");
                    for (int i = 0; i < kq.length; i++)
                        kq[i].xuat();
                    break;
                case 4:
                    System.out.println("Nhap ten nv can tim");
                    text = nhap.nextLine();
                    xuatKQ(timTheoTen(text));
                    break;
                case 5:
                    System.out.println("Nhap chuc vu nv can tim");
                    text = nhap.nextLine();
                    xuatKQ(timTheoChucVu(text));
                    break;
                case 6:
                    System.out.println("Nhap sdt nv can tim");
                    text = nhap.nextLine();
                    xuatKQ(timTheoSDT(text));
                    break;
                case 7:
                    System.out.print("Nhap gioi tinh nv can tim: ");
                    text = nhap.nextLine();
                    xuatKQ(timTheoGioiTinh(text));
                    break;
                case 8:
                    System.out.println("Nhap khoang luong can tim");
                    int from = Integer.parseInt(nhap.nextLine());
                    int to = Integer.parseInt(nhap.nextLine());
                    xuatKQ(timTheoKhoangLuong(from, to));
                    break;
                case 9:
                    System.out.print("Nhap ma nhan vien muon sua: ");
                    String temp = nhap.nextLine();
                    edit(temp);
                    break;
                case 10:
                    hienthi();
                    break;
                default:
                    System.out.println("Thoat chuong trinh");
            }
        } while (true);
    }

    public int indexOf(String n) {
        int solg = dsnv.length;
        for (int i = 0; i < solg; i++)
            if (dsnv[i].getMaNV().equals(n))
                return i;
        return -1;
    }

}
