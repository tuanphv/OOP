import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DSSach implements IList<Sach> {
    Scanner in = new Scanner(System.in);
    Sach[] sachList = new Sach[0];

    public DSSach() {
    }

    public DSSach(Sach[] l1) {
        this.sachList = l1;
    }

    public DSSach(DSSach l1) {
        this.sachList = l1.sachList;
    }

    public int indexOf(String maSach) {
        int n = sachList.length;
        for (int i = 0; i < n; i++) {
            if (sachList[i].getMaSach().equals(maSach))
                return i;
        }
        return -1;
    }
    public void docFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./lib/sach.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] s = line.split(", ");
                switch (s[0]) {
                    case "0":
                        SachGiaiTri sgt = new SachGiaiTri(s[1], s[2], s[3], s[4], Integer.parseInt(s[5]), Integer.parseInt(s[6]), Integer.parseInt(s[7]), s[8], Integer.parseInt(s[9]));
                        add(sgt);
                        break;                        
                    case "1":
                        SachHocThuat sht = new SachHocThuat(s[1], s[2], s[3], s[4], Integer.parseInt(s[5]), Integer.parseInt(s[6]), Integer.parseInt(s[7]), s[8], s[9], s[10]);
                        add(sht);
                        break;
                    default:
                        System.out.println("Loi doc file");
                        break;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Loi doc file " + e.getMessage());
        } finally {
            System.out.println("Doc file thanh cong");
        }
    }
    public void ghiFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./lib/sach.txt"));
            for (Sach s : sachList) {
                writer.write(s.toFile());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Loi ghi file " + e.getMessage());
        } finally {
            System.out.println("Ghi file thanh cong");
        }
    }

    public void nhap() {
        System.out.println("Nhap n:");
        int n = Integer.parseInt(in.nextLine());
        sachList = new Sach[n];
        for (int i = 0; i < n; i++) {
            int chon;
            Sach s = new Sach();
            do {
                System.out.println("Chon loai sach: 1. Sach hoc thuat, 2. Sach giai tri");
                chon = Integer.parseInt(in.nextLine());
                if (chon != 1 && chon != 2)
                    System.out.println("Chon sai! Vui long chon lai");
            } while (chon != 1 && chon != 2);
            switch (chon) {
                case 1:
                    s = new SachHocThuat();
                    break;
                case 2:
                    s = new SachGiaiTri();
                    break;
            }
            s.nhap();
            while (indexOf(s.getMaSach()) != -1) {
                System.out.println("Da co sach. Vui long nhap lai!");
                s.nhap();
            }
            sachList[i] = s;
        }
    }

    public void xuat() {
        System.out.println("\nTat ca sach");
        for (Sach x : sachList) {
            x.xuat();
        }
    }

    public void xuatTheoLoai() {
        System.out.println("\nSach giai tri:");
        System.out.printf("%-10s%-35s%-10s%-12s%-8s%-9s%-10s%-20s%s\n",
                "Ma sach", "Ten sach", "Ma NXB", "Ma tac gia", "Nam XB", "Don gia", "So luong", "The loai", "Do tuoi");
        for (Sach x : sachList) {
            if (x instanceof SachGiaiTri)
                System.out.println(x);
        }
        System.out.println("\nSach hoc thuat:");
        System.out.printf("%-10s%-35s%-10s%-12s%-8s%-9s%-10s%-20s%-20s%s\n",
                "Ma sach", "Ten sach", "Ma NXB", "Ma tac gia", "Nam XB", "Don gia", "So luong", "The loai",
                "Linh vuc nghien cuu", "Trinh do");
        for (Sach x : sachList) {
            if (x instanceof SachHocThuat)
                System.out.println(x);
        }
    }

    public void add(Sach s1) {
        int index = indexOf(s1.getMaSach());
        if (index == -1) {
            int n = sachList.length;
            sachList = Arrays.copyOf(sachList, n + 1);
            sachList[n] = s1;
        } else {
            System.out.println("Da co sach trong thu vien");
        }
    }

    public void suaSach(Sach s1) {
        int index = indexOf(s1.getMaSach());
        sachList[index].setTenSach(s1.getTenSach());
        sachList[index].setMaNXB(s1.getMaNXB());
        sachList[index].setMaTG(s1.getMaTG());
        sachList[index].setNamXB(s1.getNamXB());
        sachList[index].setDonGia(s1.getDonGia());
        sachList[index].setSoLuong(s1.getSoLuong());
        sachList[index].setTheLoai(s1.getTheLoai());
    }

    public void remove(Sach s1) {
        int index = indexOf(s1.getMaSach());
        if (index == -1)
            System.out.println("Khong tim thay sach!");
        else {
            int len = sachList.length;
            System.arraycopy(sachList, index + 1, sachList, index, len - index - 1);
            sachList = Arrays.copyOf(sachList, len - 1);
        }
    }

    public Sach get(String maSach) {
        int index = indexOf(maSach);
        if (index == -1)
            return null;
        return sachList[index];
    }

    public boolean isEmpty() {
        return sachList.length == 0;
    }
    
    public Sach[] timTheoMaTacGia(String maTacGia) {
        Sach[] result = new Sach[0];
        for (Sach s : sachList) {
            if (s.getMaTG().equals(maTacGia)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = s;
            }
        }
        return result;
    }
    public Sach[] timTheoNamXB(int namXB) {
        Sach[] result = new Sach[0];
        for (Sach s : sachList) {
            if (s.getNamXB() == namXB) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = s;
            }
        }
        return result;
    }
    public Sach[] timTheoTheLoai(String theLoai) {
        Sach[] result = new Sach[0];
        for (Sach s : sachList) {
            if (s.getTheLoai().equals(theLoai)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = s;
            }
        }
        return result;
    }
    public Sach[] timTheoDonGia(int from, int to) {
        Sach[] result = new Sach[0];
        for (Sach s : sachList) {
            if (s.getDonGia() <= to && s.getDonGia() >= from) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = s;
            }
        }
        return result;
    }
    public Sach[] timTheoTenSach(String tenSach) {
        Sach[] result = new Sach[0];
        for (Sach s : sachList) {
            if (s.getTenSach().contains(tenSach)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = s;
            }
        }
        return result;
    }
    public Sach[] timTheoDoTuoi(int tuoi) {
        Sach[] result = new Sach[0];
        for (Sach s : sachList) {
            if (s instanceof SachGiaiTri) {
                SachGiaiTri sgt = (SachGiaiTri) s;
                if (sgt.getDoTuoi() == tuoi) {
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = s;
                }
            }
        }
        return result;
    }
    public Sach[] timTheoLinhVuc(String linhVuc) {
        Sach[] result = new Sach[0];
        for (Sach s : sachList) {
            if (s instanceof SachHocThuat) {
                SachHocThuat sht = (SachHocThuat) s;
                if (sht.getLinhVucNC().contains(linhVuc)) {
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = s;
                }
            }
        }
        return result;
    }
    public Sach[] timTheoTrinhDo(String trinhDo) {
        Sach[] result = new Sach[0];
        for (Sach s : sachList) {
            if (s instanceof SachHocThuat) {
                SachHocThuat sht = (SachHocThuat) s;
                if (sht.getTrinhDo().contains(trinhDo)) {
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = s;
                }
            }
        }
        return result;
    }
}
