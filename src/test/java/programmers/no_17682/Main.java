package programmers.no_17682;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Programmers
 * 코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT > [1차] 다트 게임
 *
 * @author Zero
 * @since 2022-01-21
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {

                        "1S2D*3T",
                        37
                },
                {
                        "1D2S#10S",
                        9
                },
                {
                        "1D2S0T",
                        3
                },
                {
                        "1S*2T*3S",
                        23
                },
                {
                        "1D#2S*3S",
                        5
                },
                {
                        "1T2D3D#",
                        -4
                },
                {
                        "1D2S3T*",
                        59
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(String dartResult, int result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(dartResult));
        Assert.assertEquals(result, solution.solution(dartResult));
    }
}

class Solution {
    public int solution(String dartResult) {
        int result = 0;
        String num = "";
        int[] score = new int[3];
        int index = -1;

        for (int i = 0; i < dartResult.length(); i++) {
            String str = String.valueOf(dartResult.charAt(i));
            if (str.matches("^[0-9]*$")) {
                if (num.equals("")) {
                    index++;
                }
                num += str;
                score[index] = Integer.parseInt(num);
            } else {
                num = "";
                switch (str.toUpperCase()) {
                    case "S":
                        score[index] = score[index];
                        break;
                    case "D":
                        score[index] = (int) Math.pow(score[index], 2);
                        break;
                    case "T":
                        score[index] = (int) Math.pow(score[index], 3);
                        break;
                    case "*":
                        if (index > 0) {
                            score[index - 1] = score[index - 1] * 2;
                        }
                        score[index] = score[index] * 2;
                        break;
                    case "#":
                        score[index] = -score[index];
                        break;
                }
            }
        }

        for (int i = 0; i < score.length; i++) {
            result += score[i];
        }

        return result;
    }
}