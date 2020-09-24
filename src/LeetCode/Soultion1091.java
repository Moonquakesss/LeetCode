package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Soultion1091 {
    public static void main(String[] args) {
        int[][] test = new int[][]{{0,0,0,0,1},{1,0,0,0,0},{0,1,0,1,0},{0,0,0,1,1},{0,0,0,1,0}};
        Soultion1091 soultion1091 = new Soultion1091();
        System.out.println(soultion1091.shortestPathBinaryMatrix(test));
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid.length == 0 || grid[0].length == 0 || grid[0][0] == 1 || grid[m-1][n-1] == 1)
            return -1;
        Queue<int[]> position = new LinkedList<>();
//        int[][] directions = new int[][]{{0,1},{0,-1},{1,1},{1,-1},{1,0},{-1,0},{-1,1},{-1,-1}};
        int[][] directions = new int[][]{{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int pathlength = 0;
        position.add(new int[]{0,0});

        while (!position.isEmpty()) {
            int size = position.size();
            pathlength+=1;
            while (size-- > 0) {
                int[] cur = position.poll();
                int cx = cur[0], cy = cur[1];
                if (grid[cx][cy] == 1)
                    continue;
                if (cx == m-1 && cy == n-1)
                    return pathlength;
                grid[cx][cy] = 1;
                for (int[] direction : directions) {
//                    cx += direction[0];
//                    cy += direction[1];
//                    if (cx < 0 || cx >= m || cy < 0 || cy >= n)
//                        continue;
                    int nr = cx + direction[0];
                    int nc = cy + direction[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                        continue;

//                    position.add(new int[]{cx,cy});
                    position.add(new int[]{nr,nc});
                }

            }
        }
        return -1;
    }
}
