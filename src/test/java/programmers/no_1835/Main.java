package programmers.no_1835;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

/**
 * Programmers
 * 코딩테스트 연습 > 2017 카카오코드 본선 > 단체사진 찍기
 *
 * @author Zero
 * @since 2022-06-03
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        2,
                        new String[]{"N~F=0", "R~T>2"},
                        3648
                },
                {
                        2,
                        new String[]{"M~C<2", "C~M>1"},
                        0
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int n, String[] data, int result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(n, data));
        Assert.assertEquals(result, solution.solution(n, data));
    }
}

class Solution {
    static char[] friends;
    static ArrayList<Case> cases;
    static boolean[] visited;
    static StringBuilder sb;
    static int answer;

    public int solution(int n, String[] data) {
        friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        cases = new ArrayList<>();
        visited = new boolean[friends.length];
        sb = new StringBuilder();
        answer = 0;

        for (int i = 0; i < n; i++) {
            cases.add(new Case(data[i].charAt(0), data[i].charAt(2), data[i].charAt(3), Integer.parseInt(String.valueOf(data[i].charAt(4)))));
        }

        dfs(0);

        return answer;
    }

    private void dfs(int depth) {
        if (depth >= 8) {
            if (checkCondition(sb.toString())) {
                answer++;
            }
        }

        for (int i = 0; i < friends.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(friends[i]);
                dfs(depth + 1);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }

    private boolean checkCondition(String now) {
        for (Case data : cases) {
            int from = now.indexOf(data.from);
            int to = now.indexOf(data.to);

            switch (data.condition) {
                case '=':
                    if (!(Math.abs(from - to) == data.num + 1)) {
                        return false;
                    }
                    break;
                case '>':
                    if (!(Math.abs(from - to) > data.num + 1)) {
                        return false;
                    }
                    break;
                case '<':
                    if (!(Math.abs(from - to) < data.num + 1)) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    private static class Case {
        private final char from;
        private final char to;
        private final char condition;
        private final int num;

        public Case(char from, char to, char condition, int num) {
            this.from = from;
            this.to = to;
            this.condition = condition;
            this.num = num;
        }
    }
}