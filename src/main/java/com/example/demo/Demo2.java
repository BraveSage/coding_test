package com.example.demo;


import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 *
 * @author 刘周舟
 *
 * Instead of removing the consecutively identical characters, replace them with a
 * single character that comes before it alphabetically.
 *
 * ccc -> b
 * bbb -> a
 * Input: abcccbad
 * Output:
 * -> abbbad, ccc is replaced by b
 * -> aaad, bbb is replaced by a
 * -> d
 */
public class Demo2 {

    public static void main(String[] args) {
        String[] cases = new String[]{
                "abcccbad",
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
            char[] chars = str.toCharArray();
            int length = solution(chars, chars.length);
            System.out.println(new String(Arrays.copyOf(chars, length)));
        }
    }

    public static int solution(char[] chars, int length) {
        if (length <= 1) {
            return length;
        }
        int i = 0; int j = 1;boolean flag = false;

        while (i < length) {
            j = i + 1;
            while (j < length && chars[i] == chars[j]) {
                j ++;
            }
            if (j - i >= 3) {
                if (i >= 1) {
                    chars[i] = chars[i - 1];
                    i ++;
                }
                while (i < length && j < length) {
                    chars[i++] = chars[j++];
                }
                flag = true;
                break;
            } else {
                i = j;
            }
        }
        if (flag) {
            return solution(chars, i);
        }
        return i;
    }
}
