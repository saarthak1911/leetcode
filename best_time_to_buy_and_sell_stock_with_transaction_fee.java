
       class Solution {
    public int maxProfit(int[] prices, int fee) {
        int size = prices.length;
        int[][] dp = new int[size+1][2];
        for(int i = 0;i<=size;i++){
            for(int j = 0;j<2;j++){
                dp[i][j] = -1;
            }
        }
        return ans(prices ,fee , 0 , 1, size, dp);
    }
    public int ans(int[] prices , int fee , int index ,int canBuy , int size, int[][] dp){
        if(index == size){
            return 0;
        }
        int profit = 0;
        if(dp[index][canBuy]!=-1){
            return dp[index][canBuy];
        }
        if(canBuy == 1){
            profit = Math.max(ans(prices , fee , index+1 , canBuy , size, dp) , -prices[index]+ans(prices ,fee , index+1 , 0 , size, dp));
        } else {
            profit = Math.max(ans(prices , fee , index+1 , canBuy , size, dp) , prices[index] - fee + ans(prices , fee ,index+1 , 1 , size, dp));
        }
        return dp[index][canBuy] = profit ;
    }
} 
    