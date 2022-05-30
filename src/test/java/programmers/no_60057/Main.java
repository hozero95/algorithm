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
        StringBuilder result = new StringBuilder();
        int min = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            String temp = s;
            int count = 0;
            for (int j = 0; j <= s.length() - i; j += i) {
                String key = s.substring(j, j + i);

                if (!temp.startsWith(key)) {
                    if (count > 1) {
                        result.append(count);
                        j += (count * i) - i;
                    }
                    result.append(key);
                    count = 0;
                } else {
                    count++;
                    temp = temp.substring(i);
                    j -= i;
                }
            }
            result.append(temp);

            if (min > result.length()) {
                min = result.length();
            }
            result = new StringBuilder();
        }

        return min;
    }
}