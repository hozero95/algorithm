package programmers.no_42888;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.*;

/**
 * Programmers
 * 코딩테스트 연습 > 2019 KAKAO BLIND RECRUITMENT > 오픈채팅방
 *
 * @author Zero
 * @since 2022-06-02
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        new String[]{
                                "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"
                        },
                        new String[]{
                                "Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."
                        }
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(String[] record, String[] result) {
        Solution solution = new Solution();
        System.out.println("result: ");
        Arrays.stream(result).forEach(System.out::println);
        System.out.println("answer: ");
        Arrays.stream(solution.solution(record)).forEach(System.out::println);
        Assert.assertArrayEquals(result, solution.solution(record));
    }
}

class Solution {
    public String[] solution(String[] record) {
        List<String> result = new ArrayList<>();
        Map<String, String> users = new HashMap<>();

        for (String str : record) {
            String[] state = str.split(" ");

            switch (state[0]) {
                case "Leave":
                    result.add(state[1] + "님이 나갔습니다.");
                    break;
                case "Enter":
                    result.add(state[1] + "님이 들어왔습니다.");
                default:
                    users.put(state[1], state[2]);
                    break;
            }
        }

        for (int i = 0; i < result.size(); i++) {
            String[] state = result.get(i).split("님");
            state[0] = users.get(state[0]) + "님";
            result.set(i, state[0] + state[1]);
        }

        return result.toArray(new String[0]);
    }
}