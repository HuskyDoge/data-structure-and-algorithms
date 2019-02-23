import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author Jialun Li on 2019-02-04
 */
public class DFS {

    public static char[][] grid = new char[5][5];

    static {
        char[] l1 = new char[]{'1', '1', '0', '0', '0'};
        char[] l2 = new char[]{'1', '1', '0', '0', '0'};
        char[] l3 = new char[]{'0', '0', '1', '0', '0'};
        char[] l4 = new char[]{'0', '0', '0', '1', '1'};
        grid[0] = l1;
        grid[1] = l2;
        grid[2] = l3;
        grid[3] = l4;
    }

    public static void main(String[] args) {
//        traverseLand();
        System.out.println(numIslands(grid));
    }

    public static void traverseLand() {
        List<String> result = new ArrayList<>();
        int width = grid[0].length;
        int height = grid.length;
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(toPair(0, 0));
        visited.add(toPair(0, 0));
        while (!stack.isEmpty()) {
            String last = stack.peek();
            String[] split = last.split("\\|");
            int i = Integer.parseInt(split[0]);
            int j = Integer.parseInt(split[1]);
            if (i + 1 < height && !visited.contains(toPair(i + 1, j))) { //存在下边
                visited.add(toPair(i + 1, j));
                stack.push(toPair(i + 1, j));
            } else if (j + 1 < width && !visited.contains(toPair(i, j + 1))) { // 有右边
                visited.add(toPair(i, j + 1));
                stack.push(toPair(i, j + 1));
            } else {
                result.add(stack.pop());
            }
        }

        result.forEach(System.out::println);
    }

    public static int numIslands(char[][] grid) {
        int ans = 0;
        int width = grid[0].length;
        int height = grid.length;
        Set<String> landSet = new HashSet<>();
        // 获取land set  O(n^2)
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                char c = grid[i][j];
                if (c == '1') landSet.add(toPair(i,j));
            }
        }

        while (!landSet.isEmpty()) {
            ans++;
            String pair = landSet.iterator().next();
            String[] split = pair.split("\\|");
            int i = Integer.parseInt(split[0]);
            int j = Integer.parseInt(split[1]);
            Set<String> visited = new HashSet<>();
            visited.add(pair);
            Stack<String> stack = new Stack<>();
            stack.add(pair);
            while (!stack.isEmpty()) {
                String last = stack.peek();
                split = last.split("\\|");
                int ii = Integer.parseInt(split[0]);
                int jj = Integer.parseInt(split[1]);
                if (ii + 1 < height && !visited.contains(toPair(ii + 1, jj)) && grid[ii + 1][jj] == '1') {
                    visited.add(toPair(ii + 1, jj));
                    stack.push(toPair(ii + 1, jj));
                } else if (jj + 1 < width && !visited.contains(toPair(ii, jj + 1)) && grid[ii][jj + 1] == '1') {
                    visited.add(toPair(ii, jj + 1));
                    stack.push(toPair(ii, jj + 1));
                } else {
                    landSet.remove(stack.pop());
                }
            }
        }
        return ans;
    }


    private static String toPair(int i, int j) {
        return i + "|" + j;
    }

}
