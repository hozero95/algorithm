package programmers.no_92334;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Programmers
 * 코딩테스트 연습 > 2022 KAKAO BLIND RECRUITMENT > 신고 결과 받기
 *
 * @author Zero
 * @since 2022-01-14
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        new String[]{"muzi", "frodo", "apeach", "neo"},
                        new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach, muzi"},
                        2,
                        new int[]{2, 1, 1, 0}
                },
                {
                        new String[]{"con", "ryan"},
                        new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
                        3,
                        new int[]{0, 0}
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(String[] id_list, String[] report, int k, int[] result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(id_list, report, k));
        Assert.assertArrayEquals(result, solution.solution(id_list, report, k));
    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> idIndex = new HashMap<>();
        Map<String, List<String>> reportMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            idIndex.put(id_list[i], i);
            reportMap.put(id_list[i], new ArrayList<>());
        }

        for (String reported : report) {
            String[] temp = reported.split(" ");
            if (!reportMap.get(temp[1]).contains(temp[0])) {
                reportMap.get(temp[1]).add(temp[0]);
            }
        }

        for (String id : reportMap.keySet()) {
            if (k <= reportMap.get(id).size()) {
                for (String reporter : reportMap.get(id)) {
                    answer[idIndex.get(reporter)]++;
                }
            }
        }

        return answer;
    }
}