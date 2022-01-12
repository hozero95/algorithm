package programmers.no_86051;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Programmers
 * 코딩테스트 연습 > 월간 코드 챌린지 시즌3 > 없는 숫자 더하기
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
                        new int[]{1, 2, 3, 4, 6, 7, 8, 0},
                        14
                },
                {
                        new int[]{5, 8, 4, 0, 6, 7, 9},
                        6
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int[] numbers, int result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(numbers));
        Assert.assertEquals(result, solution.solution(numbers));
    }
}

class Solution {
    public int solution(int[] numbers) {
        return IntStream.rangeClosed(0, 9).sum() - Arrays.stream(numbers).sum();
    }
}