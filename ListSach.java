import java.util.Arrays;
import java.util.Scanner;

public class ListSach {
    Sach[] sachList;

    public ListSach() {
    }

    public ListSach(Sach[] l1) {
        this.sachList = Arrays.copyOf(l1, l1.length);
    }

    public ListSach(ListSach l1) {
        this.sachList = Arrays.copyOf(l1.sachList, l1.sachList.length);
    }

    public int findIndex(String maSach) {
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
            sachList[i].nhap();
            while (findIndex(sachList[i].getMaSach()) != -1) {
                System.out.println("Da co sach vui long nhap lai!");
                sachList[i].nhap();
            }
        }
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
        for (Sach x : sachList) {
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
        if (sachList == null)
            sachList = new Sach[0];
        int index = findIndex(s1.getMaSach());
        if (index == -1) {
            int n = sachList.length;
            sachList = Arrays.copyOf(sachList, n + 1);
            sachList[n] = s1;
        } else {
            System.out.println("Da co sach trong thu vien");
            if (s1 == sachList[index])
                sachList[index].setSoLuong(s1.getSoLuong() + sachList[index].getSoLuong());
            else
                System.out.println("Thong tin sach sai!");
        }
    }

    public void updateSach(Sach s1) {
    }

    public void deleteSach(Sach s1) {
        int index = findIndex(s1.getMaSach());
        if (index == -1)
            System.out.println("Khong tim thay sach!");
        else {
            System.arraycopy(sachList, index + 1, sachList, index, sachList.length - index - 1);
            sachList = Arrays.copyOf(sachList, sachList.length - 1);
        }
    }
}
