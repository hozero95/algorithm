package programmers.no_87389;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.stream.IntStream;

/**
 * Programmers
 * 코딩테스트 연습 > 월간 코드 챌린지 시즌3 > 나머지가 1이 되는 수 찾기
 *
 * @author Zero
 * @since 2022-01-20
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        10,
                        3
                },
                {
                        12,
                        11
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int n, int result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(n));
        Assert.assertEquals(result, solution.solution(n));
    }
}

class Solution {
    public int solution(int n) {
        return IntStream.range(1, n).filter(x -> n % x == 1).min().getAsInt();
    }
}