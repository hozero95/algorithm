package programmers.no_12977;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

/**
 * Programmers
 * 코딩테스트 연습 > Summer/Winter Coding(~2018) > 소수 만들기
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
                        new int[]{1, 2, 3, 4},
                        1
                },
                {
                        new int[]{1, 2, 7, 6, 4},
                        4
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int[] nums, int result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(nums));
        Assert.assertEquals(result, solution.solution(nums));
    }
}

class Solution {
    public int solution(int[] nums) {
        int result = 0;
        List<Integer> sum = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        for (int num : sum) {
            if (prime(num)) {
                result++;
            }
        }

        return result;
    }

    private boolean prime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
