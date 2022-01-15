package programmers.no_77884;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Programmers
 * 코딩테스트 연습 > 월간 코드 챌린지 시즌2 > 약수의 개수와 덧셈
 *
 * @author Zero
 * @since 2022-01-15
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        13,
                        17,
                        43
                },
                {
                        24,
                        27,
                        52
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int left, int right, int result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(left, right));
        Assert.assertEquals(result, solution.solution(left, right));
    }
}

class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int type = 1;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    type = -type;
                }
            }
            answer += type * i;
        }

        return answer;
    }
}