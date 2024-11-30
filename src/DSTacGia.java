import java.util.Arrays;
import java.util.Scanner;

public class DSTacGia {
    TacGia[] DSTG = new TacGia[0];

    public DSTacGia() {
    }

    public DSTacGia(TacGia[] DSTG) {
        this.DSTG = DSTG;
    }

    public DSTacGia(DSTacGia ds) {
        this.DSTG = ds.DSTG;
    }

    public void nhap() {
        System.out.println("Nhap so luong tac gia");
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int len = DSTG.length;
        DSTG = Arrays.copyOf(DSTG, len + n);
        System.out.println("Nhap thong tin cac tac gia");
        for (int i = len; i < n + len; i++) {
            TacGia tg = new TacGia();
            tg.nhap();
            while (timTheoMaTG(tg.getMaTG()) != -1) {
                System.out.println("Da co thong tin tac gia. Vui long nhap lai!");
                tg.nhap();
            }
            DSTG[i] = tg;
        }
        scan.close();
    }

    public void xuat() {
        System.out.println("\nDanh sach tac gia");
        System.out.printf("%-12s%-30s%-10s%-15s\n", "Ma tac gia", "Ten tac gia", "Ngay sinh", "Quoc gia");
        for (TacGia x : DSTG) {
            System.out.println(x);
        }
    }

    public int timTheoMaTG(String ma) {
        int n = DSTG.length;
        for (int i = 0; i < n; i++)
            if (DSTG[i].getMaTG().equals(ma))
                return i;
        return -1;
    }

    public void themTacGia(TacGia tg) {
        int index = timTheoMaTG(tg.getMaTG());
        if (index == -1) {
            int len = DSTG.length;
            DSTG = Arrays.copyOf(DSTG, len + 1);
            DSTG[len] = tg;
        } else {
            System.out.println("Thong tin tac gia da ton tai");
        }
    }

    public void xoaTacGia(TacGia tg) {
        int index = timTheoMaTG(tg.getMaTG());
        if (index == -1)
            System.out.println("Khong tim thay tac gia");
        else {
            int len = DSTG.length;
            System.arraycopy(DSTG, index + 1, DSTG, index, len - index - 1);
            DSTG = Arrays.copyOf(DSTG, len - 1);
        }
    }
}
