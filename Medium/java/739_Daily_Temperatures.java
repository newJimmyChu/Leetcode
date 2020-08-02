class Solution {
    public int[] dailyTemperatures(int[] T) {
    	if (T.length == 0 || T == null) {
    		return new int[] {0};
    	}
    	int sum = 0;
    	int[] dp = new int [T.length];
    	// Initialize T to store all the latter element minus the previous element

        // Iterate through T and iterate all the elements after T[i] s.t.
        // sum is greater than 0
        for (int i = 0; i < T.length; i ++) {
        	for (int j = i + 1; j < T.length; j ++) {
        		if (T[j] > T[i]) {
        			dp[i] = j - i;
        			break;
        		}
        	}
        }
        dp[T.length - 1] = 0;
        return dp;
    }
}

// complexity: O(n^2)
// space: O(1)
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] T) {
    	if (T.length == 0 || T == null) {
    		return new int[] {0};
    	}
    	int[] result = new int[T.length];
    	Stack<Integer> stack = new Stack<>();

    	for (int i = T.length - 1; i >= 0; i --) {
    		while (!stack.empty() && T[i] >= T[stack.peek()]) {
    			stack.pop();
    		}
    		if (!stack.empty()) {
    			result[i] = stack.peek() - i; 
    		} else {
    			result[i] = 0;
    		}
    		stack.push(i);
    	}
    	return result;
    }
}




