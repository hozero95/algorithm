package programmers.no_62048;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Programmers
 * 코딩테스트 연습 > Summer/Winter Coding(2019) > 멀쩡한 사각형
 *
 * @author Zero
 * @since 2022-06-03
 */

@RunWith(DataProviderRunner.class)

public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        8,
                        12,
                        80
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int w, int h, int result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(w, h));
        Assert.assertEquals(result, solution.solution(w, h));
    }
}

class Solution {
    long W;
    long H;

    public long solution(int w, int h) {
        W = w;
        H = h;
        long gcd = gcd(W, H);

        return (W * H) - ((W / gcd) + (H / gcd) - 1) * gcd;
    }

    private long gcd(long w, long h) {
        if (w == 0) {
            return h;
        }

        return gcd(h % w, w);
    }
}