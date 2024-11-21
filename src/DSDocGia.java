import java.io.IOException;
import java.util.Arrays;
import java.io.*;

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

    public void docFile() {
        try {
            // Đọc file
            BufferedReader reader = new BufferedReader(new FileReader("./lib/docgia.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] s = line.split(", ");
                DocGia dg = new DocGia(s[0], s[1], s[2], s[3], s[4], s[5]);
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
            BufferedWriter writer = new BufferedWriter(new FileWriter("./lib/docgia.txt"));
            for (DocGia dg : dsDocGia) {
                writer.write(dg.toFile());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    public void add(DocGia dg) {
        int index = indexOf(dg.getMaDG());
        if (index == -1) { // nếu chưa có sách thì thêm
            int n = dsDocGia.length;
            dsDocGia = Arrays.copyOf(dsDocGia, n + 1);
            dsDocGia[n] = dg;
        } else
            System.out.println("Đã tồn tại thông tin độc giả này");

    }

    public void remove(DocGia dg) {
        //
        int index = indexOf(dg.getMaDG());
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
}
