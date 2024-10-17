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

    public int findIndexById(String maSach) {
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
            Sach s = new Sach();
            s.nhap();
            while (findIndexById(s.getMaSach()) != -1) {
                System.out.println("Da co sach. Vui long nhap lai!");
                s.nhap();
            }
            sachList[i] = s;
        }
    }

    public void xuat() {
        System.out.println("\nTat ca sach");
        System.out.printf("%-10s%-35s%-10s%-12s%-8s%-9s%-10s%-20s%s\n",
                "Ma sach",
                "Ten sach",
                "Ma NXB",
                "Ma tac gia",
                "Nam XB",
                "Don gia",
                "So luong",
                "The loai",
                "Trang thai");
        for (Sach x : sachList) {
            Sach s1 = new Sach(x);
            System.out.println(s1);
        }
    }

    public void xuatTheoLoai() {
        System.out.println("\nSach giai tri:");
        System.out.printf("%-10s%-35s%-10s%-12s%-8s%-9s%-10s%-20s%-12s%s\n",
                "Ma sach", "Ten sach", "Ma NXB", "Ma tac gia", "Nam XB", "Don gia", "So luong", "The loai",
                "Trang thai", "Do tuoi");
        for (Sach x : sachList) {
            if (x instanceof SachGiaiTri)
                System.out.println(x);
        }
        System.out.println("\nSach hoc thuat:");
        System.out.printf("%-10s%-35s%-10s%-12s%-8s%-9s%-10s%-20s%-12s%-10s%s\n",
                "Ma sach", "Ten sach", "Ma NXB", "Ma tac gia", "Nam XB", "Don gia", "So luong", "The loai",
                "Trang thai", "Linh vuc", "Trinh do");
        for (Sach x : sachList) {
            if (x instanceof SachHocThuat)
                System.out.println(x);
        }
    }

    public void addSach(Sach s1) {
        int index = findIndexById(s1.getMaSach());
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
        int index = findIndexById(s1.getMaSach());
        if (index == -1)
            System.out.println("Khong tim thay sach!");
        else {
            System.arraycopy(sachList, index + 1, sachList, index, sachList.length - index - 1);
            sachList = Arrays.copyOf(sachList, sachList.length - 1);
        }
    }
}
