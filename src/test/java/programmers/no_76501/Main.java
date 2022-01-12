package programmers.no_76501;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Programmers
 * 코딩테스트 연습 > 월간 코드 챌린지 시즌2 > 음양 더하기
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
                        new int[]{4, 7, 12},
                        new boolean[]{true, false, true},
                        9
                },
                {
                        new int[]{1, 2, 3},
                        new boolean[]{false, false, true},
                        0
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int[] absolutes, boolean[] signs, int result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(absolutes, signs));
        Assert.assertEquals(result, solution.solution(absolutes, signs));
    }
}

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int result = 0;

        for (int i = 0; i < absolutes.length; i++) {
            result += signs[i] ? absolutes[i] : -absolutes[i];
        }

        return result;
    }
}