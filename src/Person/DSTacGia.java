package Person;
import Format.ANSI;
import Interface.IList;
import Validate.Validate;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class DSTacGia implements IList<TacGia>  {
    private static TacGia[] dstg = new TacGia[0];
    Scanner nhap = new Scanner(System.in);

    public DSTacGia() {
    }

    public DSTacGia(TacGia[] ds) {
        dstg = ds;
    }

    public TacGia[] getList() {
        return dstg;
    }

    public void nhap() {
        System.out.print("Nhap so luong tac gia: ");
        int n = Integer.parseInt(nhap.nextLine());
        dstg = new TacGia[n];
        for (int i = 0; i < n; i++) {
            dstg[i] = new TacGia();
            dstg[i].nhap();
            System.out.println("-------------------------");
        }
    }

    public void xuat() {
        String[] header = { "Ma Tac Gia", "Ten Tac Gia", "Ngay Sinh", "Quoc Gia" };
        String[][] data = new String[dstg.length][];
        for (int i = 0; i < dstg.length; i++) {
            data[i] = dstg[i].toArray();
        }
        new ANSI(header, data).printTable();
    }

    public void docFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./lib/TacGia.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                TacGia tg = new TacGia(data[0], data[1], data[2], data[3]);
                add(tg);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e);
        } finally {
            if (dstg.length == 0) {
                System.out.println("Khong co du lieu");
            } else {
                System.out.println("Doc file TacGia.txt thanh cong");
            }
        }
    }


    public void ghiFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./lib/TacGia.txt"));
            for (TacGia tg : dstg) {
                bw.write(tg.toString());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Loi ghi file: " + e);
        }

    }


    public boolean isEmpty() {
        return dstg.length == 0;
    }

    public int size() {
        return dstg.length;
    }

    public TacGia get(String ma) {
        for (TacGia tg : dstg) {
            if (tg.getMaTG().equals(ma)) {
                return tg;
            }
        }
        return null;
    }




    public void them() {
        TacGia tg = new TacGia();
        tg.nhap();
        boolean result = add(tg);
        while (result == false) {
            System.out.println("Ma tac gia da ton tai, vui long nhap lai");
            tg.nhap();
            result = add(tg);
        }
        System.out.println("Them tac gia thanh cong");
        
        ghiFile();
    }
    

    public boolean add(TacGia tg) {
        int n = dstg.length;
        if (indexOf(tg.getMaTG()) == -1) {
            dstg = Arrays.copyOf(dstg, n + 1);
            dstg[n] = tg;
            return true;
        }
        return false;
    }

    public int indexOf(String maTG) {
        for (int i = 0; i < dstg.length; i++) {
            if (dstg[i].getMaTG().equals(maTG)) {
                return i;
            }
        }
        return -1;
    }
    
    // #region Sửa
    public void edit(String masua) {
        int vitri = indexOf(masua);
        if (vitri == -1) {
            System.out.println("Khong tim thay tac gia can sua! ");
        } else {
            System.out.print("Nhap ten tac gia: ");
            String tentg = nhap.nextLine();
            dstg[vitri].setTenTG(tentg);
            System.out.print("Nhap ngay sinh: ");
            String ngaysinh = nhap.nextLine();
            dstg[vitri].setNSinhTG(ngaysinh);
            System.out.print("Nhap quoc gia : ");
            String quocgia = nhap.nextLine();
            dstg[vitri].setQGiaTG(quocgia);

        }
    }


    // #region Xoá
    public void remove(String maxoa) {
        int vitri = indexOf(maxoa);
        if (vitri == -1) {
            System.out.println("Khong tim thay ma tac gia can xoa");
        } else {
            for (int i = vitri; i < dstg.length - 1; i++) {
                dstg[i] = dstg[i + 1];
            }
            dstg = Arrays.copyOf(dstg, dstg.length - 1);
        }
    }




     // #region Tìm kiếm
     public void xuatKQ(TacGia[] result) {
        if (result.length == 0) {
            System.out.println("Khong tim thay ket qua");
        } else {
            String[] header = { "Ma Tac Gia", "Ten Tac Gia", "Ngay Sinh", "Quoc Gia" };
            String[][] data = new String[result.length][];
            for (int i = 0; i < result.length; i++) {
                data[i] = result[i].toArray();
            }
            new ANSI(header, data).printTable();
        }
    }


    public TacGia timKiemMaTacGia() {
        System.out.print("Nhap ma tac gia can tim: ");
        String matim = nhap.nextLine();

        for (TacGia tg : dstg) {
            if (tg.getMaTG().equals(matim)) {
                return tg;
            }
        }

        System.out.println("Khong tim thay ma phieu muon can tim");
        return null;
    }

    public TacGia[] timKiemTenTacGia(){
        System.out.print ("Nhap ten tac gia can tim: ");
        String tentim =  nhap.nextLine();
        TacGia[] result = new TacGia[0];

        for (TacGia tg : dstg) {
            if (tg.getTenTG().toLowerCase().contains(tentim.toLowerCase())) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = tg;
            }
        }
        return result;
    }

    public TacGia[] timKiemNamSinhTacGia() {
        System.out.print("Nhap nam sinh tac gia can tim: ");
        String namTim = nhap.nextLine();
        TacGia[] result = new TacGia[0];
        try {
            int nam = Integer.parseInt(namTim);
            if (nam > 2024 || nam < 0) {
                System.out.println("Nam tim khong hop le");
                return result; 
            }
        } catch (NumberFormatException e) {
            System.out.println("Vui long nhap nam sinh hop le!");
            return result;  
        }
    
        for (TacGia tg : dstg) {
            if (tg.getNSinhTG().contains(namTim)) {  
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = tg;
            }
        }
    
        return result;
    }
    
    
    public TacGia[] timKiemQuocGiaTacGia() {
        System.out.print("Nhap quoc gia tac gia can tim: ");
        String quocGiaTim = nhap.nextLine();
        TacGia[] result = new TacGia[0];
        for (TacGia tg : dstg) {
            if (tg.getQGiaTG().toLowerCase().contains(quocGiaTim.toLowerCase())) {  
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = tg;
            }
        }
    
        return result;
    }
    

    public void hienThiMenu(Scanner scanner) {
        do {
            new ANSI(new String[] { "Menu Quan ly tac gia".toUpperCase() },
                    new String[][] {
                            { "1. Hien thi danh sach" },
                            { "2. Them tac gia" },
                            { "3. Sua thong tin tac gia" },
                            { "4. Xoa tac gia" },
                            { "5. Tim kiem theo ma tac gia" },
                            { "6. Tim kiem theo ten tac gia" },
                            { "7. Tim kiem theo nam sinh tac gia" },
                            { "8. Tim kiem theo quoc gia tac gia" },
                            { "9. Tro lai" }
                    }).printTable();
            int choice = Validate.getChoice(scanner, 1, 10);
            switch (choice) {
                case 1:
                    xuat();
                    break;
                case 2:
                    them();
                    break;
                case 3:
                    System.out.print("Nhap ma tac gia can sua: ");
                    String maSua = scanner.nextLine();
                    edit(maSua);
                    break;
                case 4:
                    System.out.print("Nhap ma tac gia can xoa: ");
                    String maXoa = scanner.nextLine();
                    remove(maXoa);
                    break;
                case 5:
                    TacGia tgTim = timKiemMaTacGia();
                    if (tgTim != null) {
                        String[] header = { "Ma Tac Gia", "Ten Tac Gia", "Ngay Sinh", "Quoc Gia" };
                        String[][] data = { tgTim.toArray() };
                        new ANSI(header, data).printTable();
                    }
                    break;
                case 6:
                    TacGia[] tgtim = timKiemTenTacGia();
                    xuatKQ(tgtim);
                    break;

                case 7:
                    TacGia[] tgtimtheonam = timKiemNamSinhTacGia();
                    xuatKQ(tgtimtheonam);
                    break;
                case 8:
                    TacGia[] tgtimtheoqg = timKiemQuocGiaTacGia();
                    xuatKQ(tgtimtheoqg);
                    break;
                case 9:
                    System.out.println("Thoat chuong trinh.");
                    ghiFile();
                    return;
                default:
                    System.out.println("Chon sai! Vui long chon lai");
                    break;
            }   
        } while (true);
    }
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        DSTacGia dstg = new DSTacGia();
        dstg.hienThiMenu(scanner);
    }


}


