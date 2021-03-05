package com.example;

public class Anagram {

    public static void main(String[] args) {

        permutation("", "123");

        System.out.println();
        createPalindromes("", "12321");
    }

    public static void permutation(String prefix, String str) {

        int n = str.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }

    private static String swap(String str, int i, int j) {

        char[] charArray = str.toCharArray();

        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;

        return String.valueOf(charArray);
    }

    public static void createPalindromes(String prefix, String str) {

        int n = str.length();
        if (n == 0 && isPalindrome(prefix)) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                createPalindromes(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }

    public static boolean isPalindrome(String str) {

        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
