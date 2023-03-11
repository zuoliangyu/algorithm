package org.example.test6;

public class lifang {
    public static void main(String[] args) {
        int flag = 0;
        for (int i = 1; i < 55; i++) {
            int x = (int) Math.pow(i, 3);
            String s = x + "";
            char[] c = s.toCharArray();
            x = 0;
            for (char value : c) {
                x += value - '0';
            }
            if (x == i) {
                flag++;
                System.out.println(i);
            }
        }
        System.out.println(flag);
    }
}
