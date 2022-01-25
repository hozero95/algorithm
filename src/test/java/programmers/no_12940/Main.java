package programmers.no_12940;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

/**
 * Programmers
 * 코딩테스트 연습 > 연습문제 > 최대공약수와 최소공배수
 *
 * @author Zero
 * @since 2022-01-25
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        3,
                        12,
                        new int[]{3, 12}
                },
                {
                        2,
                        5,
                        new int[]{1, 10}
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int n, int m, int[] result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(n, m));
        Assert.assertArrayEquals(result, solution.solution(n, m));
    }
}

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        Arrays.sort(answer);
        answer[0] = gcd(n, m);
        answer[1] = (n * m) / answer[0];
        return answer;
    }

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}