import java.util.Scanner;

class Alphabet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String in the form %Ns");
        String str = sc.next();
        str = str.substring(1, str.length() - 1);
        int num = Integer.parseInt(str);
        if (num > 99 && num <= 0) {
            System.out.println("Number out of Range:Range must be in Range 1 to 99");
        } else {
            if (num > 26) {
                char c;
                for (c = 'A'; c <= 'Z'; c++) {
                    System.out.print(c + " ");
                }

            } else {
                for (int i = 91 - num; i <= 90; i++) {
                    char a = (char) i;
                    System.out.print(" " + a);
                }
            }
        }
        sc.close();
    }
}