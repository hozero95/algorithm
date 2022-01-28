package programmers.no_60057;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Programmers
 * 코딩테스트 연습 > 2020 KAKAO BLIND RECRUITMENT > 문자열 압축
 *
 * @author Zero
 * @since 2022-01-27
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        "aabbaccc",
                        7
                },
                {
                        "ababcdcdababcdcd",
                        9
                },
                {
                        "abcabcdede",
                        8
                },
                {
                        "abcabcabcabcdededededede",
                        14
                },
                {
                        "xababcdcdababcdcd",
                        17
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(String s, int result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(s));
        Assert.assertEquals(result, solution.solution(s));
    }
}

class Solution {
    public int solution(String s) {
        int result = s.length();
        String temp = "";
        int count = 0;

        for (int i = 1; i <= s.length() / 2; i++) {
            String prevStr = s.substring(0, i);
            for (int j = 0; j < s.length(); j += i) {
                String nextStr = s.substring(j, j + i < s.length() ? j + i : s.length());
                if (prevStr.equals(nextStr)) {
                    count++;
                } else {
                    if (count > 1) {
                        temp += count;
                        temp += prevStr;
                    } else {
                        temp += nextStr;
                    }
                    prevStr = nextStr;
                    count = 0;
                }
            }
            if (result > temp.length()) {
                result = temp.length();
            }
            temp = "";
        }

        return result;
    }
}