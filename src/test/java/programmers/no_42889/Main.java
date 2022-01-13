package programmers.no_42889;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Programmers
 * 코딩테스트 연습 > 2019 KAKAO BLIND RECRUITMENT > 실패율
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
                        5,
                        new int[]{2, 2, 2, 6, 2, 4, 3, 3},
                        new int[]{3, 4, 2, 1, 5}
                },
                {
                        4,
                        new int[]{4, 4, 4, 4, 4},
                        new int[]{4, 1, 2, 3}
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int N, int[] stages, int[] result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(N, stages));
        Assert.assertArrayEquals(result, solution.solution(N, stages));
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[][] state = new int[N][2];
        double[] failPer = new double[N];
        int[] result = new int[N];

        for (int num : stages) {
            if (num > N) {
                state[num - 1][0]++;
            }
            for (int i = 0; i < num - 1; i++) {
                state[i][1]++;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(state[i][0] + " : " + state[i][1]);
        }

        return new int[]{1, 1, 1, 1};
    }
}