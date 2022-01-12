package programmers.no_70128;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Programmers
 * 코딩테스트 연습 > 월간 코드 챌린지 시즌1 > 내적
 *
 * @author Zero
 * @since 2022-01-12
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        new int[]{1, 2, 3, 4},
                        new int[]{-3, -1, 0, 2},
                        3
                },
                {
                        new int[]{-1, 0, 1},
                        new int[]{1, 0, -1},
                        -2
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int[] a, int[] b, int result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(a, b));
        Assert.assertEquals(result, solution.solution(a, b));
    }
}

class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;

        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }

        return answer;
    }
}