package programmers.no_12899;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Programmers
 * 코딩테스트 연습 > 연습문제 > 124 나라의 숫자
 *
 * @author Zero
 * @since 2022-06-08
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        1,
                        "1"
                },
                {
                        2,
                        "2"
                },
                {
                        3,
                        "4"
                },
                {
                        4,
                        "11"
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int n, String result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(n));
        Assert.assertEquals(result, solution.solution(n));
    }
}

class Solution {
    StringBuilder sb;

    public String solution(int n) {
        sb = new StringBuilder();
        convertN(n);
        return sb.toString();
    }

    private void convertN(int n) {
        if (n > 0) {
            if (n % 3 == 0) {
                sb.insert(0, 4);
                n = n / 3 - 1;
            } else {
                sb.insert(0, n % 3);
                n = n / 3;
            }
            convertN(n);
        }
    }
}