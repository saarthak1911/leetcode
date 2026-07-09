class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        int n = str1.length;
        int m = str2.length;
        dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(str1, str2, n - 1, m - 1);
    }

    private int helper(char[] str1, char[] str2, int i, int j) {
        // Base case: strings are exhausted
        if (i < 0 || j < 0) return 0;
        
        // Return memoized result
        if (dp[i][j] != -1) return dp[i][j];

        if (str1[i] == str2[j]) {
            // Characters match: 1 + solve remaining
            return dp[i][j] = 1 + helper(str1, str2, i - 1, j - 1);
        } else {
            // Mismatch: max of skipping character from str1 or str2
            return dp[i][j] = Math.max(helper(str1, str2, i - 1, j), 
                                       helper(str1, str2, i, j - 1));
        }
    }
}