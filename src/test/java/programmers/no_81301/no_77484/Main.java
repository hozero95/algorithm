package programmers.no_81301.no_77484;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Programmers
 * 코딩테스트 연습 > 2021 Dev-Matching: 웹 백엔드 코딩테스트 > 로또의 최고 순위와 최저 순위
 * @author Zero
 * @since  2021-12-29
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        new int[]{44, 1, 0, 0, 31, 25},
                        new int[]{31, 10, 45, 1, 6, 19},
                        new int[]{3, 5}
                },
                {
                        new int[]{0, 0, 0, 0, 0, 0},
                        new int[]{38, 19, 20, 40, 15, 25},
                        new int[]{1, 6}
                },
                {
                        new int[]{45, 4, 35, 20, 3, 9},
                        new int[]{20, 9, 3, 45, 4, 35},
                        new int[]{1, 1}
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int[] param1, int[] param2, int[] result) {
        Solution solution = new Solution();
        Assert.assertArrayEquals(result, solution.solution(param1, param2));
    }
}

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {7, 7};

        for (int num1 : lottos) {
            if (num1 == 0) {
                answer[0]--;
            }
            for (int num2 : win_nums) {
                if (num1 == num2) {
                    answer[0]--;
                    answer[1]--;
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] > 6) {
                answer[i]--;
            }
        }

        return answer;
    }
}