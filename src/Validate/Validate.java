package Validate;

import java.util.Scanner;

import Format.ANSI;
import Format.ANSI.BG_COLOR;
import Format.ANSI.FG_COLOR;
import Format.ANSI.STYLE;

public class Validate {
    public static void notification(String error, String message, boolean isCall) {
        if (isCall)
            System.out.print("\033[F\033[K");
        System.out.print("\033[F\033[K");
        if (error != "") System.out.println(ANSI.formatText(error, FG_COLOR.RED, BG_COLOR.NONE, STYLE.BOLD));
        System.out.print(message);
    }

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
}
