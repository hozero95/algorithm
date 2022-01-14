package programmers.no_42889;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Programmers
 * 코딩테스트 연습 > 2019 KAKAO BLIND RECRUITMENT > 실패율
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
                        5,
                        new int[]{2, 1, 2, 6, 2, 4, 3, 3},
                        new int[]{3, 4, 2, 1, 5}
                },
                {
                        4,
                        new int[]{4, 4, 4, 4, 4},
                        new int[]{4, 1, 2, 3}
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int N, int[] stages, int[] result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(N, stages));
        Assert.assertArrayEquals(result, solution.solution(N, stages));
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] result = new int[N];
        int[][] state = new int[N][2]; // [도전 중인 사람 수][도전한 사람 수]
        double[] failPer = new double[N];
        Map<Integer, Double> map = new HashMap<>();

        for (int num : stages) {
            if (num <= N) {
                state[num - 1][0]++;
                state[num - 1][1]++;
            }
            for (int i = 0; i < num - 1; i++) {
                state[i][1]++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (state[i][0] == 0) {
                failPer[i] = 0;
            } else {
                failPer[i] = (double) state[i][0] / state[i][1];
            }
            map.put(i + 1, failPer[i]);
        }

        Arrays.sort(failPer);
        int key = 0;
        for (int i = failPer.length - 1; i >= 0; i--) {
            for (int j = 0; j < map.size(); j++) {
                if (map.get(j + 1) == failPer[i]) {
                    result[key] = j + 1;
                    map.put(j + 1, -1.0);
                    key++;
                    break;
                }
            }
        }

        return result;
    }
}