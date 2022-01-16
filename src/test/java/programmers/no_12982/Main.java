package programmers.no_12982;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

/**
 * Programmers
 * 코딩테스트 연습 > Summer/Winter Coding(~2018) > 예산
 *
 * @author Zero
 * @since 2022-01-16
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        new int[]{1, 3, 2, 5, 4},
                        9,
                        3
                },
                {
                        new int[]{2, 2, 3, 3},
                        10,
                        4
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int[] d, int budget, int result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(d, budget));
        Assert.assertEquals(result, solution.solution(d, budget));
    }
}

class Solution {
    public int solution(int[] d, int budget) {
        int sum = 0;

        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            if (sum > budget) {
                return i;
            } else if (sum == budget) {
                return i + 1;
            }
        }

        return d.length;
    }
}