package programmers.no_12943;


import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Programmers
 * 코딩테스트 연습 > 연습분제 > 콜라츠 추측
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
                        6,
                        8
                },
                {
                        16,
                        4
                },
                {
                        626331,
                        -1
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int num, int result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(num));
        Assert.assertEquals(result, solution.solution(num));
    }
}

class Solution {
    public int solution(long num) {
        return collatz(num, 0);
    }

    public int collatz(long num, int count) {
        if(count >= 500) {
            return -1;
        }
        if (num == 1) {
            return count;
        }
        if (num % 2 == 0) {
            num /= 2;
        } else {
            num = num * 3 + 1;
        }
        return collatz(num, ++count);
    }
}