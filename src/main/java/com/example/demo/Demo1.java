package com.example.demo;

import java.util.Arrays;

/**
 * @author 刘周舟
 * For a given string that only contains alphabet characters a-z, if 3 or more consecutive
 * characters are identical, remove them from the string. Repeat this process until
 * there is no more than 3 identical characters sitting besides each other.
 * <p>
 * Example:
 * Input: aabcccbbad
 * Output:
 * -> aabbbad
 * -> aaad
 * -> d
 */
public class Demo1 {

    private static boolean deleteRepeatChar(StringBuilder stringBuilder) {
        char lastChar = 0;
        int repeatCount = 0;
        boolean isDeleted = false;

        for (int i = 0; i < stringBuilder.length(); i++) {
            if (lastChar == stringBuilder.charAt(i)) {
                repeatCount++;
            } else {
                lastChar = stringBuilder.charAt(i);
                repeatCount = 1;
            }
            if (repeatCount >= 3) {
                stringBuilder.delete(i - 2, i + 1);
                repeatCount -= 3;
                i -= 2;
                isDeleted = true;
            }
        }
        return isDeleted;
    }

    public static String solution(String str) {
        if(str == null){
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        while (deleteRepeatChar(stringBuilder));

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] cases = new String[]{
                "aabcccbbad",
                "abcccbade",
                "abcccbad",
                "abcccccbade",
                "a",
                "aabcccbadee",
                "acabcccbadee",
                "accabcccbadeee",
                ""
        };
        for (String str : cases) {
            System.out.println(solution(str));

        }
    }
}
