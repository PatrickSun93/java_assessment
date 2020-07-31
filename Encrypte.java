// author: Peidong Sun
// emial: peidongsun@gmail.com
// time 9:13PM
// Durations: 20 Mins 

import java.util.Scanner;

public class Encrypte {
    private String password;

    public Encrypte(final String password) {
        this.password = password;
    }

    public Encrypte() {
        this.password = null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void encrypt(final String data) {
        final String pwd = data.replace(" ", "");
        System.out.println(pwd);
        final int size = pwd.length();
        System.out.println(size);
        if (size > 81) {
            System.out.println("the password exceeded the maximum length:81");
        }
        final int high = (int) Math.ceil(Math.sqrt(size));

        final int low = (int) Math.floor(Math.sqrt(size));
        int row = low;
        final int col = high;
        if (row * col < size) {
            row++;
        }
        System.out.println(row + ":" + col);
        final char[][] a = new char[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (count <= size - 1) {
                    a[i][j] = pwd.charAt(count);
                    count++;
                }
            }
        }
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                System.out.print(a[i][j]);
            }
            System.out.print(" ");
        }
    }

    public static void main(final String[] args) {
        final Encrypte epass = new Encrypte();
        final Scanner scan = new Scanner(System.in);
        System.out.println("please input the password");
        final String pwd = scan.nextLine();
        epass.encrypt(pwd);
    }
}
