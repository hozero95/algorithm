package programmers.no_12969;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Programmers
 * 코딩테스트 연습 > 연습문제 > 직사각형 별찍기
 *
 * @author Zero
 * @since 2022-01-27
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        "*****\n" + "*****\n" + "*****"
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(String result) throws IOException {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution());
    }
}

class Solution {
    public String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sb.append("*");
                System.out.print("*");
            }
            sb.append("\n");
            System.out.println();
        }

        return sb.toString();
    }
}