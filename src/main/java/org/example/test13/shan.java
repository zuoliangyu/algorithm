package org.example.test13;

public class shan {
    public static void main(String[] args) {
        int flag = 0;
        for (long i = 2022; i <= 2022222022; i++) {
            String i_str = String.valueOf(i);
            int up = 0;
            int down = i_str.length() - 1;
            while (true) {
                if (i_str.charAt(up) == i_str.charAt(down)) {
                    up++;
                    down--;
                    if (up == down - 1) {
                        flag++;
                        break;
                    } else if (up == down) {
                        flag++;
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
