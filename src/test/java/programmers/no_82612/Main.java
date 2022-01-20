package programmers.no_82612;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.stream.LongStream;

/**
 * Programmers
 * 코딩테스트 연습 > 위클리 챌린지 > 부족한 금액 계산하기
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
                        3,
                        20,
                        4,
                        10
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int price, int money, int count, int result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(price, money, count));
        Assert.assertEquals(result, solution.solution(price, money, count));
    }
}

class Solution {
    public long solution(int price, int money, int count) {
        long sum = LongStream.rangeClosed(1, count).map(x -> x = x * price).sum();
        return sum > money ? sum - money : 0;
    }
}