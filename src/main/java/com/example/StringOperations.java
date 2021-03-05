package com.example;

public class StringOperations {

    public static void main(String[] args) {

        String str = "aabbbccccaaabbbbccccc";

        compress(str);
        decompress("aab3c4a3b4c5");
    }

    public static void compress(String s) {

        for (int i = 0; i < s.length(); i++) {

            int count = 1;
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }

            if (count <= 2) {
                for (int j = 0; j < count; j++) {
                    System.out.print(s.charAt(i));
                }
                System.out.print(" ");
            } else {
                System.out.print(s.charAt(i) + "" + count + " ");
            }
        }
    }

    public static void decompress(String s) {

        for (int i = 0; i < s.length(); i++) {

        }
    }
}
