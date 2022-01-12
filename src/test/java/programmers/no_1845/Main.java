package programmers.no_1845;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashSet;
import java.util.Set;

/**
 * Programmers
 * 코딩테스트 연습 > 찾아라 프로그래밍 마에스터 > 폰켓몬
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
                        new int[]{3, 1, 2, 3},
                        2
                },
                {
                        new int[]{3, 3, 3, 2, 2, 4},
                        3
                },
                {
                        new int[]{3, 3, 3, 2, 2, 2},
                        2
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
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return nums.length / 2 < set.size() ? nums.length / 2 : set.size();
    }
}