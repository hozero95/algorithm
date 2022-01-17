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
        return 0;
    }
}