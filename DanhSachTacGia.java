import java.util.Arrays;
import java.util.Scanner;

public class DanhSachTacGia {
    TacGia[] DSTG = new TacGia[0];

    public DanhSachTacGia() {
    }

    public DanhSachTacGia(TacGia[] DSTG) {
        this.DSTG = DSTG;
    }

    public DanhSachTacGia(DanhSachTacGia ds) {
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
            while (findIndexById(tg.getMaTG()) != -1) {
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

    public int findIndexById(String ma) {
        int n = DSTG.length;
        for (int i = 0; i < n; i++)
            if (DSTG[i].getMaTG().equals(ma))
                return i;
        return -1;
    }
}
