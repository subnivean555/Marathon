package problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
##输入描述: 　　题目包括多组测试数据。
　　每组测试数据以三个整数N,M,T(00)开头，分别代表迷宫的长和高，以及公主能坚持的天数。
　　紧接着有M行，N列字符，由"."，""，"P"，"S"组成。其中
　　"." 代表能够行走的空地。
　　"" 代表墙壁，NowCoder不能从此通过。
　　"P" 是公主所在的位置。
　　"S" 是NowCoder的起始位置。
　　每个时间段里NowCoder只能选择“上、下、左、右”任意一方向走一步。
　　输入以0 0 0结束。

##输出描述: 　　如果能在规定时间内救出公主输出“YES”，否则输出“NO”。


思路 : 广度优先遍历
 */

public class FindPrincess {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int col = scanner.nextInt();
            int row = scanner.nextInt();
            int time = scanner.nextInt();

            if (row == 0 && col == 0 && time == 0) {
                break;
            }

            int px = 0;
            int py = 0;

            int sx = 0;
            int sy = 0;

            char[][] maze = new char[row][col];
            for (int i = 0; i < row; i++) {
                String line = scanner.next();
                maze[i] = new char[col];
                for (int j = 0; j < col; j++) {
                    maze[i][j] = line.charAt(j);
                    if (maze[i][j] == 'P') {
                        px = i;
                        py = j;
                    } else if (maze[i][j] == 'S') {
                        sx = i;
                        sy = j;
                    }
                }
            }
            System.out.println(findPath(maze, px, py, sx, sy, time));
        }
        scanner.close();
    }

    private static String findPath(char[][] maze, int px, int py, int sx, int sy, int time) {

        int row = maze.length;
        int col = maze[0].length;

        List<Integer> curr = new LinkedList<>();
        List<Integer> next = new LinkedList<>();

        curr.add(px);
        curr.add(py);

        maze[px][py] = '*';
        while (!curr.isEmpty()) {
            px = curr.remove(0);
            py = curr.remove(0);

            if (px == sx && py == sy) {
                return "YES";
            }

            if (px - 1 >= 0 && maze[px - 1][py] != '*') {
                next.add(px - 1);
                next.add(py);
                maze[px - 1][py] = '*';
            }

            if (py + 1 < col && maze[px][py + 1] != '*') {
                next.add(px);
                next.add(py + 1);
                maze[px][py + 1] = '*';
            }

            if (px + 1 < row && maze[px + 1][py] != '*') {
                next.add(px + 1);
                next.add(py);
                maze[px + 1][py] = '*';
            }

            if (py - 1 >= 0 && maze[px][py - 1] != '*') {
                next.add(px);
                next.add(py - 1);
                maze[px][py - 1] = '*';
            }

            if (curr.isEmpty()) {
                time--;

                if (time < 0) {
                    return "NO";
                } else {
                    List<Integer> queue = curr;
                    curr = next;
                    next = queue;
                }
            }
        }
        return "NO";
    }
}
