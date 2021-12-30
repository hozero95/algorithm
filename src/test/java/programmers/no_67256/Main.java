package programmers.no_67256;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

/**
 * Programmers
 * 코딩테스트 연습 > 2020 카카오 인턴십 > 키패드 누르기
 *
 * @author Zero
 * @since 2021-12-30
 */

@RunWith(DataProviderRunner.class)
public class Main {
    @DataProvider
    public static Object[][] resultData() {
        return new Object[][]{
                {
                        new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},
                        "right",
                        "LRLLLRLLRRL"
                },
                {
                        new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},
                        "left",
                        "LRLLRRLLLRR"
                },
                {
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                        "right",
                        "LLRLLRLLRL"
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int[] numbers, String hand, String result) {
        Solution solution = new Solution();
        System.out.println("result: " + result);
        System.out.println("answer: " + solution.solution(numbers, hand));
        Assert.assertEquals(result, solution.solution(numbers, hand));
    }
}

class Solution {
    private StringBuilder sb;
    private Map<Integer, Position> key;
    private Position lPos, rPos;

    public String solution(int[] numbers, String hand) {
        init();

        for (int i = 0; i < numbers.length; i++) {
            int x = key.get(numbers[i]).getX();
            int y = key.get(numbers[i]).getY();

            if (y == 0) {
                moveHand("L", x, y);
            } else if (y == 2) {
                moveHand("R", x, y);
            } else {
                int lDis = Math.abs(lPos.getX() - x) + Math.abs(lPos.getY() - y);
                int rDis = Math.abs(rPos.getX() - x) + Math.abs(rPos.getY() - y);

                if (lDis < rDis) {
                    moveHand("L", x, y);
                } else if (lDis > rDis) {
                    moveHand("R", x, y);
                } else {
                    if (hand.equals("right")) {
                        moveHand("R", x, y);
                    } else if (hand.equals("left")) {
                        moveHand("L", x, y);
                    }
                }
            }
        }

        return sb.toString();
    }

    private void init() {
        sb = new StringBuilder();
        key = new HashMap<>();
        key.put(1, new Position(0, 0));
        key.put(2, new Position(0, 1));
        key.put(3, new Position(0, 2));
        key.put(4, new Position(1, 0));
        key.put(5, new Position(1, 1));
        key.put(6, new Position(1, 2));
        key.put(7, new Position(2, 0));
        key.put(8, new Position(2, 1));
        key.put(9, new Position(2, 2));
        key.put(0, new Position(3, 1));

        lPos = new Position(3, 0);
        rPos = new Position(3, 2);
    }

    private void moveHand(String hand, int x, int y) {
        sb.append(hand);
        if (hand.equals("L")) {
            lPos.setX(x);
            lPos.setY(y);
        } else if (hand.equals("R")) {
            rPos.setX(x);
            rPos.setY(y);
        }
    }

    private class Position {
        private int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}