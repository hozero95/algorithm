package programmers.no_12954;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.stream.LongStream;

/**
 * Programmers
 * 코딩테스트 연습 > 연습문제 > x만큼 간격이 있는 n개의 숫자
 *
 * @author Zero
 * @since 2022-01-27
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        2,
                        5,
                        new long[]{2, 4, 6, 8, 10}
                },
                {
                        4,
                        3,
                        new long[]{4, 8, 12}
                },
                {
                        -4,
                        2,
                        new long[]{-4, -8}
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int x, int n, long[] result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(x, n));
        Assert.assertArrayEquals(result, solution.solution(x, n));
    }
}

class Solution {
    public long[] solution(int x, int n) {
        return LongStream.rangeClosed(1, n).map(num -> num * x).toArray();
    }
}