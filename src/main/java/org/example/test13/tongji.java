package org.example.test13;

public class tongji {
    public static void main(String[] args) {
        String S = "ABBAAABC";
        int[] arr = new int[26];
        for (int i = 0; i < S.length(); i++) {
            int x = S.charAt(i) - 'A';
            arr[x]++;
        }
        int max = arr[0];
        for (int i = 1; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for(int i = 0; i < 26; i++){
            if(arr[i]==max){
                Character temp= (char) (i+'A');
                System.out.println(temp);
            }
        }
    }
}
