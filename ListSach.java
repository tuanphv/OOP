import java.util.Arrays;
import java.util.Scanner;

public class ListSach {
    Sach[] list;

    public ListSach() {
    }

    public ListSach(Sach[] l1) {
        this.list = Arrays.copyOf(l1, l1.length);
    }

    public ListSach(ListSach l1) {
        this.list = Arrays.copyOf(l1.list, l1.list.length);
    }

    public int checkUnique(Sach s) {
        int n = list.length;
        for (int i = 0; i < n; i++) {
            if (list[i].getMaSach().equals(s.getMaSach()))
                return i;
        }
        return -1;
    }

    Scanner in = new Scanner(System.in);

    public void nhap() {
        System.out.println("Nhap n:");
        int n = Integer.parseInt(in.nextLine());
        list = new Sach[n];
    }

    public void xuat() {
        System.out.printf("| %-10s | %-35s | %-15s | %-10s | %-6s | %-7s | %-8s | %-20s | %-15s |\n",
                "Ma sach",
                "Ten sach",
                "Ma nha xuat ban",
                "Ma tac gia",
                "Nam XB",
                "Don gia",
                "So luong",
                "The loai",
                "Tinh trang sach");
        for (Sach x : list) {
            System.out.printf("| %-10s | %-35s | %-15s | %-10s | %-6d | %-7d | %-8d | %-20s | %-15s |\n",
                    x.getMaSach(),
                    x.getTenSach(),
                    x.getMaNXB(),
                    x.getMaTG(),
                    x.getNamXB(),
                    x.getDonGia(),
                    x.getSoLuong(),
                    x.getTheLoai(),
                    x.getTinhTrang());
        }
    }

    public void addSach(Sach s1) {
        if (list == null)
            list = new Sach[0];
        int index = checkUnique(s1);
        if (index == -1) {
            int n = list.length;
            list = Arrays.copyOf(list, n + 1);
            list[n] = s1;
        } else {
            System.out.println("Da co sach trong thu vien");
            if (s1 == list[index])
                list[index].setSoLuong(s1.getSoLuong() + list[index].getSoLuong());
            else
                System.out.println("Thong tin sach sai!");
        }
    }
}
