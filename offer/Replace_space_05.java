public class Solution {
    public String replaceSpace(StringBuffer str) {
    	if (str == null || str.length() == 0 ) {
    		return "";
    	}
    	int m = str.length() - 1;
    	// For each space encountered, we append three place
    	// holders to the end of str for %20
    	for (int i = 0; i <= m; i++) {
    		if (str.charAt(i) == ' ') {
    			str.append("  ");
    		}
    	}
    	int n = str.length() - 1;

    	// Iterate through m to 0, if str.charAt(i) == ' ', 
    	// replace three space with '0' '2' '%'
    	while(m >= 0 && n > m) {
    		char c = str.charAt(m--);
    		if (c == ' ') {
    			str.setCharAt(n--, '0');
    			str.setCharAt(n--, '2');
    			str.setCharAt(n--, '%');
    		} else {
    			str.setCharAt(n--, c);
    		}
    	}
    	return str.toString();
    }
}