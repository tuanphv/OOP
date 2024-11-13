import java.util.Arrays;
import java.util.Scanner;

public class ListSach {
    Sach[] sachList = new Sach[0];

    public ListSach() {
    }

    public ListSach(Sach[] l1) {
        this.sachList = l1;
    }

    public ListSach(ListSach l1) {
        this.sachList = l1.sachList;
    }

    public int timTheoMaSach(String maSach) {
        int n = sachList.length;
        for (int i = 0; i < n; i++) {
            if (sachList[i].getMaSach().equals(maSach))
                return i;
        }
        return -1;
    }

    Scanner in = new Scanner(System.in);

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
            while (timTheoMaSach(s.getMaSach()) != -1) {
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

    public void themSach(Sach s1) {
        int index = timTheoMaSach(s1.getMaSach());
        if (index == -1) {
            int n = sachList.length;
            sachList = Arrays.copyOf(sachList, n + 1);
            sachList[n] = s1;
        } else {
            System.out.println("Da co sach trong thu vien");
        }
    }

    public void themSoLuongSach(String maSach, int soLuong) {
        int index = timTheoMaSach(maSach);
        if (index != -1)
            sachList[index].setSoLuong(sachList[index].getSoLuong() + soLuong);
        else
            System.out.println("Ma sach sai!");
    }

    public void suaSach(Sach s1) {
        int index = timTheoMaSach(s1.getMaSach());
        sachList[index].setTenSach(s1.getTenSach());
        sachList[index].setMaNXB(s1.getMaNXB());
        sachList[index].setMaTG(s1.getMaTG());
        sachList[index].setNamXB(s1.getNamXB());
        sachList[index].setDonGia(s1.getDonGia());
        sachList[index].setSoLuong(s1.getSoLuong());
        sachList[index].setTheLoai(s1.getTheLoai());
    }

    public void xoaSach(Sach s1) {
        int index = timTheoMaSach(s1.getMaSach());
        if (index == -1)
            System.out.println("Khong tim thay sach!");
        else {
            int len = sachList.length;
            System.arraycopy(sachList, index + 1, sachList, index, len - index - 1);
            sachList = Arrays.copyOf(sachList, len - 1);
        }
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
