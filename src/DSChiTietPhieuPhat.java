import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DSChiTietPhieuPhat implements IList<ChiTietPhieuPhat> {
    Scanner cin = new Scanner(System.in);
    private ChiTietPhieuPhat[] list = new ChiTietPhieuPhat[0];

    public DSChiTietPhieuPhat() {
    }

    public DSChiTietPhieuPhat(ChiTietPhieuPhat[] l1) {
        list = l1;
    }

}
