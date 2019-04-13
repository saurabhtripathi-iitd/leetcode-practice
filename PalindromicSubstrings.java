class Solution {
    public int countSubstrings(String s) {
        int len = s.length(), numSS = 0;
        boolean[][] isPal = new boolean[len][len];
        
        for (int i = len - 1;i >= 0;i--) {
            for (int j = i;j < len;j++) {
                isPal[i][j] = s.charAt(i) == s.charAt(j) && ((j - i < 3) || isPal[i + 1][j - 1]);
                
                if (isPal[i][j]) {
                    numSS++;
                }
            }
        }
        
        return numSS;
    }
}