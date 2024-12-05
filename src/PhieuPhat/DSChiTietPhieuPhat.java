package PhieuPhat;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner; // Importing Arrays class

import Interface.IList;

public class DSChiTietPhieuPhat implements IList<ChiTietPhieuPhat> {
    private ChiTietPhieuPhat[] list = new ChiTietPhieuPhat[100];  // Fixed-size array
    private int size = 0; // Track the number of elements

    public DSChiTietPhieuPhat() {}
    
    // Read data from ChiTietPhieuPhat.txt and store in array
    public void docFile() {
        try (Scanner scanner = new Scanner(new File("./lib/ChiTietPhieuPhat.txt"))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(", ");
                if (data.length < 4) {
                    System.out.println("Warning: Skipping line due to insufficient data: " + Arrays.toString(data));
                    continue; // Skip this line
                }
                String mapp = data[0];
                String masach = data[1];
                String maqd = data[2];
                Double tienphat = Double.parseDouble(data[3]);

                ChiTietPhieuPhat chiTiet = new ChiTietPhieuPhat(mapp, masach, maqd, tienphat);

                // Expand array to add new object
                if (size >= list.length) {
                    ChiTietPhieuPhat[] newList = new ChiTietPhieuPhat[list.length * 2];
                    System.arraycopy(list, 0, newList, 0, list.length);
                    list = newList;
                }
                list[size++] = chiTiet; // Add new object and increment size
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    // Write data to ChiTietPhieuPhat.txt
    public void ghiFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("./lib/ChiTietPhieuPhat.txt"))) {
            for (int i = 0; i < size; i++) {
                writer.println(list[i].getMaPP() + ", " + list[i].getMaSach() + ", " + list[i].getMaQD() + ", " + list[i].getTienPhat());
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Add regulation to the array
    public void add(ChiTietPhieuPhat chiTiet) {
        if (size >= list.length) {
            ChiTietPhieuPhat[] newList = new ChiTietPhieuPhat[list.length * 2];
            System.arraycopy(list, 0, newList, 0, list.length);
            list = newList;
        }
        list[size++] = chiTiet; // Add new object and increment size
    }

    // Remove regulation from the array
    public void remove(ChiTietPhieuPhat chiTiet) {
        int index = indexOf(chiTiet.getMaPP());
        if (index != -1) {
            System.arraycopy(list, index + 1, list, index, size - index - 1);
            size--; // Decrement size
        }
    }

    // Get regulation by code
    public ChiTietPhieuPhat get(String mapp) {
        for (int i = 0; i < size; i++) {
            if (list[i].getMaPP().equals(mapp)) {
                return list[i];
            }
        }
        return null; // Return null if not found
    }

    // Get position of regulation in the array
    public int indexOf(String mapp) {
        for (int i = 0; i < size; i++) {
            if (list[i].getMaPP().equals(mapp)) {
                return i;
            }
        }
        return -1; // Not found
    }

    // Check if array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get length of array
    public int size() {
        return size;
    }
}