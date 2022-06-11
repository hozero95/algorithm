package programmers.no_42586;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Programmers
 * 코딩테스트 연습 > 스택/큐 > 기능개발
 *
 * @author Zero
 * @since 2022-06-11
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        new int[]{93, 30, 55},
                        new int[]{1, 30, 5},
                        new int[]{2, 1}
                },
                {
                        new int[]{95, 90, 99, 99, 80, 99},
                        new int[]{1, 1, 1, 1, 1, 1},
                        new int[]{1, 3, 2}
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int[] progresses, int[] speeds, int[] result) {
        Solution solution = new Solution();
        int[] answer = solution.solution(progresses, speeds);

        System.out.println("result: ");
        Arrays.stream(result).forEach(System.out::println);
        System.out.println("answer: ");
        Arrays.stream(answer).forEach(System.out::println);
        Assert.assertArrayEquals(result, answer);
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;
        int cnt = 0;

        while (true) {
            if (progresses[index] >= 100) {
                cnt++;
                index++;
                if (index < progresses.length) {
                    continue;
                }
            }

            if (cnt > 0) {
                result.add(cnt);
                cnt = 0;
                if (index >= progresses.length) {
                    break;
                }
            }

            for (int i = index; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}