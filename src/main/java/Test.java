import java.util.Stack;

/**
 * @author Jialun Li on 2019-02-02
 */
public class Test {
    public static void main(String[] args) {
        int[] t = new int[]{73,74,75,71,69,72,76,73};
        dailyTemperatures(t);
    }

    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            int futureCount = 0;
            Stack<Integer> tempStack = new Stack<>();
            boolean find = false;
            while (!stack.isEmpty()) {
                futureCount++;
                if (T[i] < stack.peek()) {
                    find = true;
                    break;
                }
                tempStack.push(stack.pop());
            }
            if (stack.isEmpty() && !find) {
                ans[i] = 0;
            } else {
                ans[i] = futureCount;
            }
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
            stack.push(T[i]);
        }
        return ans;
    }
}
