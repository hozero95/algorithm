package programmers.no_12944;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

/**
 * Programmers
 * 코딩테스트 연습 > 연습문제 > 평균 구하기
 *
 * @author Zero
 * @since 2022-01-26
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        new int[]{1, 2, 3, 4},
                        2.5
                },
                {
                        new int[]{5, 5},
                        5
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int[] arr, double result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(arr));
        Assert.assertEquals(result, solution.solution(arr), 0.0);
    }
}

class Solution {
    public double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }
}