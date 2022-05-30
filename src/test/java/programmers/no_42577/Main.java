package programmers.no_42577;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

/**
 * Programmers
 * 코딩테스트 연습 > 해시 > 전화번호 목록
 *
 * @author Zero
 * @since 2022-05-30
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        new String[]{"119", "97674223", "1195524421"},
                        false
                },
                {
                        new String[]{"123", "456", "789"},
                        true
                },
                {
                        new String[]{"12", "123", "1235", "567", "88"},
                        false
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(String[] phone_book, boolean result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(phone_book));
        Assert.assertEquals(result, solution.solution(phone_book));
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (!phone_book[i].equals(phone_book[i + 1]) && phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}