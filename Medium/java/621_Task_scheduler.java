class Solution {
    public int leastInterval(char[] tasks, int n) {
    	int temp = 0;
    	int result = 0, off = 0;
    	for (int i = 0; i < tasks.length; i ++) {
    		if (tasks[i] == 0) {
    			continue;
    		}
    		ArrayList<Character> prev = new ArrayList<>();
    		prev.add(tasks[i]);
    		for (int j = tasks.length - 1; j > i; j --) {
    			if (temp == n) {
    				break;
    			}
    			if (tasks[j] == 0 || prev.contains(tasks[j])) {
    				continue;
    			} else {
    				prev.add(tasks[j]);
    				tasks[j] = 0;
    				temp ++;
    			}
    		}
    		result += n + 1;
    		off = n - temp;  // cpu idled n - temp units of time
    		temp = 0;

    	}
    	return result - off;
        
    }
}

// Analyze: Create a table contains 26 letter's frequency
// Using greedy algorithm to arrange the time slot based on the
// letter that has the largest frequence.
class Solution {
	public int leastInterval(char[] tasks, int n) {
		int[] freq = new int [26];
		for (char c : tasks) {
			freq[c - 'A'] ++;
		}
		Arrays.sort(freq);
		int max = freq[25];
		int idle = (freq[25] - 1) * n;

		for (int i = 0; i < 25; i ++) {
			idle -= Math.min(freq[i], freq[25] - 1);
		}
		return idle > 0 ? idle + tasks.length : tasks.length;

	}
}