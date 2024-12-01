import java.io.*;
import java.util.Scanner;

public class DSQuyDinhPhat implements IList<Quydinhphat> {
    private Quydinhphat[] list = new Quydinhphat[100];  // Fixed-size array

    public DSQuyDinhPhat() {}

    public DSQuyDinhPhat(Quydinhphat[] l1) {
        this.list = l1;
    }

    // Read data from file and store in array
    public void docFile() {
        try (Scanner scanner = new Scanner(new File("./lib/QuyDinhPhat.txt"))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(", ");
                String maqd = data[0];
                String noidung = data[1];
                Double mucphat = Double.parseDouble(data[2]);

                Quydinhphat quydinhphat = new Quydinhphat(maqd, noidung, mucphat);

                // Expand array to add new object
                Quydinhphat[] newList = new Quydinhphat[list.length + 1];
                System.arraycopy(list, 0, newList, 0, list.length);
                newList[list.length] = quydinhphat;
                list = newList;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    // Write data to file
    public void ghiFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("./lib/QuyDinhPhat.txt"))) {
            for (Quydinhphat quydinhphat : list) {
                writer.println(quydinhphat.getMaqd() + ", " + quydinhphat.getNoidung() + ", " + quydinhphat.getMucphat());
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Add regulation to the array
    public void add(Quydinhphat quydinhphat) {
        // Expand array to add new object
        Quydinhphat[] newList = new Quydinhphat[list.length + 1];
        System.arraycopy(list, 0, newList, 0, list.length);
        newList[list.length] = quydinhphat;
        list = newList;
    }

    // Remove regulation from the array
    public void remove(Quydinhphat quydinhphat) {
        int index = indexOf(quydinhphat.getMaqd());  // Get position of regulation by code
        if (index != -1) {  // If regulation found
            Quydinhphat[] newList = new Quydinhphat[list.length - 1];  // Create new array with size reduced by 1
            System.arraycopy(list, 0, newList, 0, index);  // Copy part before regulation
            System.arraycopy(list, index + 1, newList, index, list.length - index - 1);  // Copy part after regulation
            list = newList;  // Assign new array to list
        }
    }

    // Get position of regulation in the array
    public int indexOf(String Maqd) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].getMaqd().equals(Maqd)) {
                return i;
            }
        }
        return -1; // Not found
    }

    // Get regulation by code
    public Quydinhphat get(String maqd) {
        for (Quydinhphat quydinhphat : list) {
            if (quydinhphat.getMaqd().equals(maqd)) {
                return quydinhphat;
            }
        }
        return null;  // Return null if not found
    }

    // Check if array is empty
    public boolean isEmpty() {
        return list.length == 0;
    }

    // Get length of array
    public int size() {
        return list.length;
    }

    // Get list of regulations
    public Quydinhphat[] getList() {
        return list;
    }
}
