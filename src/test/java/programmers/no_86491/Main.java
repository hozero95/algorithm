package programmers.no_86491;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Programmers
 * 코딩테스트 연습 > 위클리 챌린지 > 최소직사각형
 *
 * @author Zero
 * @since 2022-01-17
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}},
                        4000
                },
                {
                        new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}},
                        120
                },
                {
                        new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}},
                        133
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int[][] sizes, int result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(sizes));
        Assert.assertEquals(result, solution.solution(sizes));
    }
}

class Solution {
    public int solution(int[][] sizes) {
        int max = 0;
        int min = 0;

        for (int[] size : sizes) {
            int bigNum = Math.max(size[0], size[1]);
            int smallNum = Math.min(size[0], size[1]);

            max = max < bigNum ? bigNum : max;
            min = min < smallNum ? smallNum : min;
        }

        return max * min;
    }
}