package programmers.no_12947;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

/**
 * Programmers
 * 코딩테스트 연습 > 연습문제 > 하샤드 수
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
                        10,
                        true
                },
                {
                        12,
                        true
                },
                {
                        11,
                        false
                },
                {
                        13,
                        false
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int x, boolean result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(x));
        Assert.assertEquals(result, solution.solution(x));
    }
}

class Solution {
    public boolean solution(int x) {
        return x % Arrays.stream(Integer.toString(x).split("")).mapToInt(n -> Integer.parseInt(n)).sum() == 0 ? true : false;
    }
}