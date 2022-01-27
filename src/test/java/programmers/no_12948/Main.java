package programmers.no_12948;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Programmers
 * 코딩테스트 연습 > 연습문제 > 핸드폰 번호 가리기
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
                        "01033334444",
                        "*******4444"
                },
                {
                        "027778888",
                        "*****8888"
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(String phone_number, String result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(phone_number));
        Assert.assertEquals(result, solution.solution(phone_number));
    }
}

class Solution {
    public String solution(String phone_number) {
        return phone_number.substring(0, phone_number.length() - 4).replaceAll(".", "*") + phone_number.substring(phone_number.length() - 4);
    }
}