package programmers.no_81301;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Programmers
 * 코딩테스트 연습 > 2021 카카오 채용연계형 인턴십 > 숫자 문자열과 영단어
 *
 * @author Zero
 * @since 2021-12-30
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        "one4seveneight",
                        1478
                },
                {
                        "23four5six7",
                        234567
                },
                {
                        "2three45sixseven",
                        234567
                },
                {
                        "123",
                        123
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(String param1, int result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(param1));
        Assert.assertEquals(result, solution.solution(param1));
    }
}

class Solution {
    public int solution(String s) {
        Number[] numbers = Number.values();

        for (Number number : numbers) {
            if (s.contains(number.name)) {
                s = s.replaceAll(number.name, Integer.toString(number.value));
            }
        }

        return Integer.parseInt(s);
    }

    enum Number {
        ZERO("zero", 0),
        ONE("one", 1),
        TWO("two", 2),
        THREE("three", 3),
        FOUR("four", 4),
        FIVE("five", 5),
        SIX("six", 6),
        SEVEN("seven", 7),
        EIGHT("eight", 8),
        NINE("nine", 9);

        private final String name;
        private final int value;

        Number(String name, int value) {
            this.name = name;
            this.value = value;
        }
    }
}