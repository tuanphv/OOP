package Person;
import Format.ANSI;
import Interface.IList;
import Validate.Validate;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DSDocGia implements IList<DocGia> {
    private static DocGia[] dsdg = new DocGia[0];
    Scanner nhap = new Scanner(System.in);

    public DSDocGia() {
    }

    public DSDocGia(DocGia[] ds) {
        dsdg = ds;
    }

    public DocGia[] getList() {
        return dsdg;
    }

   public void nhap() {
        System.out.print("Nhap so luong phieu muon: ");
        int n = Integer.parseInt(nhap.nextLine());
        dsdg = new DocGia[n];
        for (int i = 0; i < n; i++) {
            dsdg[i] = new DocGia();
            dsdg[i].nhap();
            System.out.println("-------------------------");
        }
    }

    public void xuat() {
        String[] header = { "Ma Doc Gia", "Ten Doc Gia", "So Dien Thoai", "Email" };
        String[][] data = new String[dsdg.length][];
        for (int i = 0; i < dsdg.length; i++) {
            data[i] = dsdg[i].toArray();
        }
        new ANSI(header, data).printTable();
    }

    
   
    public void docFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./lib/DocGia.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                DocGia dg = new DocGia(data[0], data[1], data[2], data[3]);
                add(dg);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e);
        } finally {
            if (dsdg.length == 0) {
                System.out.println("Khong co du lieu");
            } else {
                System.out.println("Doc file TacGia.txt thanh cong");
            }
        }
    }


    public void ghiFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./lib/DocGia.txt"));
            for (DocGia dg : dsdg) {
                bw.write(dg.toString());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Loi ghi file: " + e);
        }

    }

    public boolean isEmpty() {
        return dsdg.length == 0;
    }

    public int size() {
        return dsdg.length;
    }

    public DocGia get(String ma) {
        for (DocGia dg : dsdg) {
            if (dg.getMaDG().equals(ma)) {
                return dg;
            }
        }
        return null;
    }

    //#region thêm
    public void them() {
        DocGia dg = new DocGia();
        dg.nhap();
        boolean result = add(dg);
        while (result == false) {
            System.out.println("Ma doc gia da ton tai, vui long nhap lai");
            dg.nhap();
            result = add(dg);
        }
        System.out.println("Them tac gia thanh cong");
        
        ghiFile();
    }
    

    public boolean add(DocGia dg) {
        int n = dsdg.length;
        if (indexOf(dg.getMaDG()) == -1) {
            dsdg = Arrays.copyOf(dsdg, n + 1);
            dsdg[n] = dg;
            return true;
        }
        return false;
    }
    public int indexOf(String ma) {
        for (int i = 0; i < dsdg.length; i++) {
            if (dsdg[i].getMaDG().equals(ma)) {
                return i;
            }
        }
        return -1;
    }


    //#region sửa
    public void edit(String masua) {
        int vitri = indexOf(masua);
        if (vitri == -1) {
            System.out.println("Khong tim thay doc gia can sua! ");
        } else {
            System.out.print("Nhap ten doc gia: ");
            String tendg = nhap.nextLine();
            dsdg[vitri].sethoTenDG(tendg);
            System.out.print("Nhap so dien thoai: ");
            String sdt = nhap.nextLine();
            dsdg[vitri].setsdtDG(sdt);
            System.out.print("Nhap email : ");
            String email = nhap.nextLine();
            dsdg[vitri].setemailDG(email);

        }
    }



    //#region xóa
    public void remove(String maxoa) {
        int vitri = indexOf(maxoa);
        if (vitri == -1) {
            System.out.println("Khong tim thay ma doc gia can xoa");
        } else {
            for (int i = vitri; i < dsdg.length - 1; i++) {
                dsdg[i] = dsdg[i + 1];
            }
            dsdg = Arrays.copyOf(dsdg, dsdg.length - 1);
        }
    }



    //#region tìm kiếm
    public void xuatKQ(DocGia[] result) {
        if (result.length == 0) {
            System.out.println("Khong tim thay ket qua");
        } else {
            String[] header = { "Ma Doc Gia", "Ten Doc Gia", "So Dien Thoai", "Email" };
            String[][] data = new String[result.length][];
            for (int i = 0; i < result.length; i++) {
                data[i] = result[i].toArray();
            }
            new ANSI(header, data).printTable();
        }
    }


    public DocGia timKiemMaDocGia() {
        System.out.print("Nhap ma doc gia can tim: ");
        String matim = nhap.nextLine();

        for (DocGia dg : dsdg) {
            if (dg.getMaDG().equals(matim)) {
                return dg;
            }
        }

        System.out.println("Khong tim thay ma phieu muon can tim");
        return null;
    }
    public DocGia[] timKiemTenDocGia() {
        System.out.print("Nhap ten doc gia can tim: ");
        String tentim = nhap.nextLine();
        DocGia[] result = new DocGia[0];
    
        for (DocGia dg : dsdg) {
            // Tách họ và tên
            String[] hoTen = dg.getHoTenDG().split(" ");  // Giả sử họ tên cách nhau bởi dấu cách
            String ten = hoTen[hoTen.length - 1];  // Lấy tên (từ cuối cùng)
    
            if (ten.toLowerCase().contains(tentim.toLowerCase())) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = dg;
            }
        }
        return result;
    }
    
    public DocGia[] timKiemHoVaTenDocGia(){
        System.out.print ("Nhap ten doc gia can tim: ");
        String tentim =  nhap.nextLine();
        DocGia[] result = new DocGia[0];

        for (DocGia dg : dsdg) {
            if (dg.getHoTenDG().toLowerCase().contains(tentim.toLowerCase())) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = dg;
            }
        }
        return result;
    }

    public DocGia[] timKiemTheoSoDienThoai() {
        System.out.print("Nhap so dien thoai can tim: ");
        String sdtim = nhap.nextLine();
        DocGia[] result = new DocGia[0];

        for (DocGia dg : dsdg) {
            if (dg.getSdtDG().equals(sdtim)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = dg;
            }
        }
    
        return result;
    }

    public DocGia[] timKiemTheoEmail() {
        System.out.print("Nhap so email can tim: ");
        String emailtim = nhap.nextLine();
        DocGia[] result = new DocGia[0];

        for (DocGia dg : dsdg) {
            if (dg.getSdtDG().equals(emailtim)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = dg;
            }
        }
    
        return result;
    }
    public void hienThiMenu(Scanner scanner) {
        do {
            new ANSI(new String[] { "Menu Quan ly doc gia".toUpperCase() },
                    new String[][] {
                            { "1. Hien thi danh sach" },
                            { "2. Them doc gia" },
                            { "3. Sua thong tin doc gia" },
                            { "4. Xoa doc gia" },
                            { "5. Tim kiem theo ma doc gia" },
                            { "6. Tim kiem theo ho va ten doc gia" },
                            { "7. Tim kiem theo ten doc gia" },
                            { "8. Tim kiem theo so dien thoai doc gia" },
                            { "9. Tim kiem theo email doc gia" },
                            { "10. Tro lai" }
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
                    System.out.print("Nhap ma doc gia can sua: ");
                    String maSua = scanner.nextLine();
                    edit(maSua);
                    break;
                case 4:
                    System.out.print("Nhap ma doc gia can xoa: ");
                    String maXoa = scanner.nextLine();
                    remove(maXoa);
                    break;
                case 5:
                    DocGia dgTim = timKiemMaDocGia();
                    if (dgTim != null) {
                        String[] header = { "Ma Doc Gia", "Ten Doc Gia", "So Dien Thoai", "Email" };
                        String[][] data = { dgTim.toArray() };
                        new ANSI(header, data).printTable();
                    }
                    break;
                case 6:
                    DocGia[] dgtimhovaten = timKiemHoVaTenDocGia();
                    xuatKQ(dgtimhovaten);
                    break;
                case 7:
                    DocGia[] dgtimten = timKiemTenDocGia();
                    xuatKQ(dgtimten);
                    break;
                case 8:
                    DocGia[] dgtimtheosdt = timKiemTheoSoDienThoai();
                    xuatKQ(dgtimtheosdt);
                    break;
                case 9:
                    DocGia[] dgtimtheoemail = timKiemTenDocGia();
                    xuatKQ(dgtimtheoemail);
                    break;
                case 10:
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
        DSDocGia dsdg = new DSDocGia();
        dsdg.hienThiMenu(scanner);
    }

}
