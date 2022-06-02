package programmers.no_1829;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Programmers
 * 코딩테스트 연습 > 2017 카카오코드 예선 > 카카오프렌즈 컬러링북
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
                        6,
                        4,
                        new int[][]{
                                {1, 1, 1, 0},
                                {1, 2, 2, 0},
                                {1, 0, 0, 1},
                                {0, 0, 0, 1},
                                {0, 0, 0, 3},
                                {0, 0, 0, 3}
                        },
                        new int[]{4, 5}
                }
        };
    }

    @Test
    @UseDataProvider("resultData")
    public void solutionTest(int m, int n, int[][] picture, int[] result) {
        Solution solution = new Solution();
        System.out.println("result: ");
        Arrays.stream(result).forEach(System.out::println);
        System.out.println("answer: ");
        Arrays.stream(solution.solution(m, n, picture)).forEach(System.out::println);
        Assert.assertArrayEquals(result, solution.solution(m, n, picture));
    }
}

class Solution {
    int numberOfArea; // 영역의 갯수
    int maxSizeOfOneArea; // 가장 큰 영역의 크기
    int M, N;
    int[][] board;
    boolean[][] visited;

    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        M = m;
        N = n;
        board = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            if (N >= 0) {
                System.arraycopy(picture[i], 0, board[i], 0, N);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!visited[i][j] && board[i][j] != 0) { // 처음 방문 && 색칠된 영역
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j));
                    numberOfArea++;
                }
            }
        }

        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    private int bfs(int x, int y) {
        int[] dx = {0, 0, -1, 1}; // 상, 하, 좌, 우
        int[] dy = {-1, 1, 0, 0};
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll(); // 현재 좌표
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + curX;
                int ny = dy[i] + curY;

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) { // 옮긴 좌표가 board 내부인지 검사
                    if (!visited[nx][ny] && board[nx][ny] == board[curX][curY]) { // 처음 방문 && 이전 좌표와 같은 색인지 검사
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        count++;
                    }
                }
            }
        }

        return count;
    }
}