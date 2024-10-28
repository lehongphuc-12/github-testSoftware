package Menu;

import java.util.Scanner;

public class Utils {
    Scanner scanner = new Scanner(System.in);

    public String getString(String mess) {
        while (true) {
            System.out.println(mess);
            String s = scanner.nextLine();
            if (!s.isEmpty())
                return s;
            System.out.println("Input empty. Try again!");
        }
    }

    public int getInt(String mess) {
        while (true) {
            try {
                int n = Integer.parseInt(getString(mess));
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Input invalid. Try again!");
            }
        }
    }

    public double getDouble(String mess) {
        while (true) {
            try {
                double n = Double.parseDouble(getString(mess));
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Input invalid. Try again!");
            }
        }
    }

    public int getState(String mess) {
        while (true) {
            try {
                int n = Integer.parseInt(getString(mess));
                switch (n) {
                    case 0:
                        return 0;
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    default:
                        break;
                }
                System.out.println("This input invalid! Try again! ");
            } catch (NumberFormatException e) {
                System.err.println("Input invalid. Try again!");
            }
        }
    }

    public int getbYear(String mess) {
        while (true) {
            try {
                int n = Integer.parseInt(getString(mess));
                if (n >= 1900 && n <= 2010) {
                    return n;
                }
                System.out.println("This year must between 1900 and 2010! ");
            } catch (NumberFormatException e) {
                System.err.println("Input invalid. Try again!");
            }
        }
    }
}
