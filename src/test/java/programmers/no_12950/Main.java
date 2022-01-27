package programmers.no_12950;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Programmers
 * 코딩테스트 연습 > 연습문제 > 행렬의 덧셈
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
                        new int[][]{{1, 2}, {2, 3}},
                        new int[][]{{3, 4}, {5, 6}},
                        new int[][]{{4, 6}, {7, 9}}
                },
                {
                        new int[][]{{1}, {2}},
                        new int[][]{{3}, {4}},
                        new int[][]{{4}, {6}}
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int[][] arr1, int[][] arr2, int[][] result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(arr1, arr2));
        Assert.assertArrayEquals(result, solution.solution(arr1, arr2));
    }
}

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                answer[i][j] += (arr1[i][j] + arr2[i][j]);
            }
        }

        return answer;
    }
}