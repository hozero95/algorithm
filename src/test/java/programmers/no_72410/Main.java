package programmers.no_72410;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Locale;
import java.util.stream.Stream;

/**
 * Programmers
 * 코딩테스트 연습 > 2021 KAKAO BLIND RECRUITMENT > 신규 아이디 추천
 *
 * @author Zero
 * @since 2021-12-29
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        "...!@BaT#*..y.abcdefghijklm",
                        "bat.y.abcdefghi"
                },
                {
                        "z-+.^.",
                        "z--"
                },
                {
                        "=.=",
                        "aaa"
                },
                {
                        "123_.def",
                        "123_.def"
                },
                {
                        "abcdefghijklmn.p",
                        "abcdefghijklmn"
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(String param1, String result) {
        Solution2 solution = new Solution2();
        Assert.assertEquals(result, solution.solution(param1));
    }
}

class Solution1 {
    public String solution(String new_id) {
        // level 1
        new_id = new_id.toLowerCase();

        // level 2
        new_id = new_id.replaceAll("[^0-9a-z\\-\\_\\.]", "");

        // level 3
        while (true) {
            if (new_id.contains("..")) {
                new_id = new_id.replace("..", ".");
            } else {
                break;
            }
        }

        // level 4
        if (new_id.charAt(0) == '.' && new_id.length() >= 1) {
            new_id = new_id.replaceFirst(".", "");
        }
        if (new_id.length() - 1 == new_id.lastIndexOf(".") && new_id.length() >= 1) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        // level 5
        if (new_id.isEmpty() || new_id.isBlank()) {
            new_id = "a";
        }

        // level 6
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.length() - 1 == new_id.lastIndexOf(".") && new_id.length() >= 1) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }

        // level 7
        if (new_id.length() <= 2) {
            int length = new_id.length();
            for (int i = 0; i < 3 - length; i++) {
                new_id += new_id.charAt(length - 1);
            }
        }

        return new_id;
    }
}

class Solution2 {
    public String solution(String new_id) {
        return new KakaoID(new_id)
                .replaceToLowerCase()
                .filterString()
                .replaceToSingleDot()
                .replaceStartEndDot()
                .noBlank()
                .filterMaxLength()
                .filterMinLength()
                .getId();
    }

    private static class KakaoID {
        private String id;

        KakaoID(String id) {
            this.id = id;
        }

        private KakaoID replaceToLowerCase() {
            id = id.toLowerCase();
            return this;
        }

        private KakaoID filterString() {
            id = id.replaceAll("[^0-9a-z\\-\\_\\.]", "");
            return this;
        }

        private KakaoID replaceToSingleDot() {
            while (true) {
                if (id.contains("..")) {
                    id = id.replace("..", ".");
                } else {
                    break;
                }
            }
            return this;
        }

        private KakaoID replaceStartEndDot() {
            if (id.charAt(0) == '.' && id.length() >= 1) {
                id = id.replaceFirst(".", "");
            }
            if (id.length() - 1 == id.lastIndexOf(".") && id.length() >= 1) {
                id = id.substring(0, id.length() - 1);
            }
            return this;
        }

        private KakaoID noBlank() {
            if (id.isEmpty() || id.isBlank()) {
                id = "a";
            }
            return this;
        }

        private KakaoID filterMaxLength() {
            if (id.length() >= 16) {
                id = id.substring(0, 15);
                if (id.length() - 1 == id.lastIndexOf(".") && id.length() >= 1) {
                    id = id.substring(0, id.length() - 1);
                }
            }
            return this;
        }

        private KakaoID filterMinLength() {
            if (id.length() <= 2) {
                int length = id.length();
                for (int i = 0; i < 3 - length; i++) {
                    id += id.charAt(length - 1);
                }
            }
            return this;
        }

        public String getId() {
            return id;
        }
    }
}