class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions,(a,b)->a[0]-b[0]);
        int m = restrictions.length+2;
        int[][] list = new int[m][2];

        list[0] = new int[]{1,0};

        for(int i=0;i<restrictions.length;i++){
            list[i+1] = restrictions[i];
        }
        // max height of last building of 1 is max diff 
        list[m-1] = new int[]{n,n-1};
       
        for(int i=1;i<m;i++){
            int[] curr = list[i];
            int[] last = list[i-1];
            int gapIndex = curr[0] - last[0];
            curr[1]= Math.min(curr[1],last[1]+gapIndex);
        }

        for(int i=m-2;i>=0;i--){
            int[] curr = list[i];
            int[] last = list[i+1];
            int gapIndex = last[0]-curr[0];
            curr[1]=Math.min(curr[1],last[1]+gapIndex);
        }
        int ans =0;
        for(int i=1;i<m;i++){
            // how this fomula come 
            // peak height b/w 2 point  denote P from P to hi and hj height should diff (j-i) as max diff is 1 
            // hi, hj
            // (P - hi) + (P - hj) <= (j - i)
            // 2p - hj - hi <= j-i
            // p = (hj+hi+(j-1))/2
            int max = (list[i][1] + list[i-1][1] + (list[i][0]-list[i-1][0]))/2;
            ans = Math.max(ans,max);
        }
        return ans;
    }
}