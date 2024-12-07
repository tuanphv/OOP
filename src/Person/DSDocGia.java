package Person;
import java.io.IOException;
import java.util.Arrays;
import java.io.*;
import java.util.Scanner;

import Interface.IList;

public class DSDocGia implements IList<DocGia> {
    private DocGia[] dsDocGia = new DocGia[0];

    public DSDocGia() {
    }

    public DSDocGia(DocGia[] dsDocGia) {
        this.dsDocGia = dsDocGia;
    }

    public DSDocGia(DSDocGia ds) {
        this.dsDocGia = ds.dsDocGia;
    }
    
    public void nhapDanhSach() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng độc giả: ");
        int soLuong = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin độc giả thứ " + (i + 1) + ":");
            DocGia dg = new DocGia();
            dg.nhap();
            add(dg);
        }
        scanner.close();
    }

    public void xuatDanhSach() {
        for (DocGia dg : dsDocGia) {
            dg.xuat();
        }
    }
    
    public void docFile() {
        try {
            // Đọc file
            BufferedReader reader = new BufferedReader(new FileReader("./lib/DocGia.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] s = line.split(", ");
                int lastSpaceIndex = s[1].lastIndexOf(' ');
                String ho = s[1].substring(0, lastSpaceIndex);
                String ten = s[1].substring(lastSpaceIndex + 1);
                DocGia dg = new DocGia(s[0], ho, ten, s[2], s[3]);
                add(dg);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }

    public void ghiFile() {
        // Ghi file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./lib/DocGia.txt"));
            for (DocGia dg : dsDocGia) {
                writer.write(dg.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    public boolean add(DocGia dg) {
        int index = indexOf(dg.getMaDG());
        if (index == -1) { // nếu chưa có sách thì thêm
            int n = dsDocGia.length;
            dsDocGia = Arrays.copyOf(dsDocGia, n + 1);
            dsDocGia[n] = dg;
            return true;
        }
        return false;
    }

    public void edit(String ma) {
        int index = indexOf(ma);
        if (index == -1) {
            System.out.println("Không tìm thấy độc giả cần sửa");
        } else {
            DocGia dg = new DocGia();
            dg.setmaDG(ma);
            dg.nhap();
            dsDocGia[index] = dg;
        }
    }
    public void remove(String ma) {
        //
        int index = indexOf(ma);
        if (index == -1) {
            System.out.println("Không tìm thấy độc giả cần xóa");
        } else {
            int len = dsDocGia.length;
            System.arraycopy(dsDocGia, index + 1, dsDocGia, index, len - index - 1);
            dsDocGia = Arrays.copyOf(dsDocGia, len - 1);
        }
    }

    public int indexOf(String ma) {
        for (int i = 0; i < dsDocGia.length; i++) {
            if (dsDocGia[i].getMaDG().equals(ma)) {
                return i;
            }
        }
        return -1;
    }

    public DocGia get(String ma) {
        int index = indexOf(ma);
        if (index == -1) {
            return null;
        }
        return dsDocGia[index];
    }

    public boolean isEmpty() {
        return dsDocGia.length == 0;
    }

    public int size() {
        return dsDocGia.length;
    }

    public DocGia[] timTheoHoTen(String hoTen) {
        DocGia[] result = new DocGia[0];
        String data[] = hoTen.split(" ");
        for (DocGia dg : dsDocGia) {
            for (String s : data) {
                if (dg.getTenDG().contains(s) || dg.getHoDG().contains(s)) {
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = dg;
                    break;
                }
            }
        }
        return result;
    }
}
