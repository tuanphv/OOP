package Validate;

import java.util.Scanner;
import java.util.function.Function;

import Format.ANSI;
import Format.ANSI.BG_COLOR;
import Format.ANSI.FG_COLOR;
import Format.ANSI.STYLE;

public class Validate {
    /**
     * Xoá dòng hiện tại và chèn thông báo lỗi hoặc thông báo thành công
     * nếu {@code isCall} là {@code true} thì xoá báo lỗi hoặc báo lỗi khác
     * @param error : thông báo khi xảy ra lỗi
     * @param message : lời nhắc nhập hoặc thông báo thành công
     * @param isCall : kiểm tra xem hàm đã được gọi trước đó chưa
     */
    public static void notification(String error, String message, boolean isCall) {
        if (isCall)
            System.out.print("\033[F\033[K");
        System.out.print("\033[F\033[K");
        if (error != "") System.out.println(ANSI.formatText(error, FG_COLOR.RED, BG_COLOR.NONE, STYLE.BOLD));
        System.out.print(message);
    }

    /**
     * Lấy lựa chọn từ người dùng là kiểu int trong khoảng {@code min} đến {@code max}
     * @param sc : đối tượng Scanner
     * @param min : giá trị nhỏ nhất
     * @param max : giá trị lớn nhất
     * @return lựa chọn của người dùng
     * @see #getDate(Scanner, String)
     * @see #getNumber(Scanner, String)
     * @see #getSoLSong(Scanner, String, String, String, Integer)
     */
    public static int getChoice(Scanner sc, int min, int max) {
        System.out.print(ANSI.formatText(">> Chon chuc nang: "));
        int choice;
        boolean isCall = false;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < min || choice > max) {
                    notification(">> So vua nhap khong hop le!", ANSI.formatText(">> Chon lai chuc nang: "), isCall);
                    isCall = true;
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                notification(">> Du lieu vao phai la so!", ANSI.formatText(">> Chon lai chuc nang: "), isCall);
                isCall = true;
            }
        }
        notification("", ANSI.formatText(">> Chuc nang da chon: " + choice) + "\n", isCall);
        return choice; 
    }

    /**
     * Check chuỗi nhập từ bàn phím có phải là số nguyên hay không.
     * <p> Nếu sai thì thông báo lỗi và nhập lại.
     * @param sc : đối tượng Scanner
     * @param message : lời nhắc nhập
     * @return số nguyên nhập từ bàn phím
     * @see #getNumber(Scanner, String)
     * @see #getSoLSong(Scanner, String, String, String, Integer)
     * @see #getDate(Scanner, String)
     */
    public static int getNumber(Scanner sc, String message) {
        System.out.print(message);
        int number;
        boolean isCall = false;
        while (true) {
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number < 0) {
                    notification(">> So vua nhap khong hop le!", message, isCall);
                    isCall = true;
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                notification(">> Du lieu vao phai la so!", message, isCall);
                isCall = true;
            }
        }
        notification("", message + number + "\n", isCall);
        return number;
    }
    /**
     * Check chuỗi nhập vào có phải là ngày tháng hay không.
     * <p>
     * Nếu sai thì thông báo lỗi và nhập lại.
     * @param sc : đối tượng Scanner
     * @param message : lời nhắc nhập
     * @return chuỗi ngày tháng nhập từ bàn phím
     * @see #getNumber(Scanner, String)
     * @see #getSoLSong(Scanner, String, String, String, Integer)
     * @see #getChoice(Scanner, Integer, Integer)
     */
    public static String getDate(Scanner sc, String message) {
        System.out.print(message);
        String date;
        boolean isCall = false;
        while (true) {
            date = sc.nextLine();
            if (!date.matches("\\d{1,2}/\\d{1,2}/\\d{4}") || (new Ngay(date).isValidDate()) == false) {
                notification(">> Ngay thang phai co dang (dd/mm/yyyy)!", message, isCall);
                isCall = true;
                continue;
            }
            break;
        }
        notification("", message + date + "\n", isCall);
        return date;
    }

    /**
     * Check chuỗi nhập vào có phải là số nguyên hay không.
     * <p>
     * Số đã nhập phải nằm trong khoảng từ 0 đến {@code max}.
     * <p>
     * Nếu sai thì thông báo lỗi và nhập lại.
     * @param sc : đối tượng Scanner
     * @param message : lời nhắc nhập
     * @param error : thông báo lỗi format
     * @param outOfRange : thông báo lỗi ngoài phạm vi
     * @param max : giá trị tối đa được phép nhập
     * @return số nguyên nhập từ bàn phím.
     * @see #getNumber(Scanner, String)
     * @see #getChoice(Scanner, Integer, Integer)
     * @see #getDate(Scanner, String)
     */
    public static int getSoLSong(Scanner sc, String message, String error, String outOfRange, int max) {
        System.out.print(message);
        int number;
        boolean isCall = false;
        while (true) {
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number < 0 || number > max) {
                    notification(outOfRange, message, isCall);
                    isCall = true;
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                notification(error, message, isCall);
                isCall = true;
            }
        }
        notification("", message + number + "\n", isCall);
        return number;
    }

    /**
     * Check đối tượng có {@code ma} đã tồn tại trong mảng {@code array} hay chưa.
     * <p>
     * Mã của đối tượng được gọi thông qua {@code method}.
     * <p>
     * Nếu không tồn tại thì thông báo lỗi và nhập lại.
     * <p>
     * Ví dụ: {@code checkExist(sc, "Nhap ma: ", "Ma khong ton tai", Sach[], Sach::getMaSach)}
     * @param <T> : kiểu dữ liệu của đối tượng
     * @param sc : đối tượng Scanner {@code sc}
     * @param message : lời nhắc nhập {@code "Nhap ma: "}
     * @param notFound : thông báo lỗi khi {@code ma} không tồn tại {@code "Ma khong ton tai"}
     * @param array : mảng chứa đối tượng {@code Sach[]}
     * @param method : phương thức lấy mã của đối tượng {@code Sach::getMaSach}
     * @return mã của đối tượng thoả điều kiện
     */
    public static <T> String checkExist(Scanner sc, String message, String notFound, T[] array, Function<T, String> method) {
        System.out.print(message);
        String ma;
        boolean isCall = false;
        while (true) {
            ma = sc.nextLine();
            boolean isExist = false;
            for (T t : array) {
                if (method.apply(t).equals(ma)) {
                    isExist = true;
                    break;
                }
            }
            // nếu mã không tồn tại trong danh sách
            if (!isExist) {
                notification(notFound, message, isCall);
                isCall = true;
                continue;
            }
            break;
        }
        notification("", message + ma + "\n", isCall);
        return ma;
    }

    /**
     * Check đối tượng có {@code ma} không tồn tại trong mảng {@code array}.
     * @param <T> : kiểu dữ liệu của đối tượng
     * @param sc : đối tượng Scanner {@code sc}
     * @param message : lời nhắc nhập {@code "Nhap ma: "}
     * @param notFound : thông báo lỗi khi {@code ma} đã tồn tại {@code "Ma da ton tai"}
     * @param array : mảng chứa đối tượng {@code Sach[]}
     * @param method : phương thức lấy mã của đối tượng {@code Sach::getMaSach}
     * @return mã của đối tượng thoả điều kiện
     * @see #checkExist
     */
    public static <T> String checkNotExist(Scanner sc, String message, String found, T[] array, Function<T, String> method) {
        System.out.print(message);
        String ma;
        boolean isCall = false;
        while (true) {
            ma = sc.nextLine();
            boolean isExist = false;
            for (T t : array) {
                if (method.apply(t).equals(ma)) {
                    isExist = true;
                    break;
                }
            }
            // nếu mã tồn tại trong danh sách
            if (isExist) {
                notification(found, message, isCall);
                isCall = true;
                continue;
            }
            break;
        }
        notification("", message + ma + "\n", isCall);
        return ma;
    }
}
