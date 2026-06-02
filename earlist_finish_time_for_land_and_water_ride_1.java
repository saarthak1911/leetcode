class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        // Try every possible pair of rides
        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {

                // Case 1: Land -> Water
                int landFinish = landStartTime[i] + landDuration[i];
                int finish1 = Math.max(landFinish, waterStartTime[j]) + waterDuration[j];

                // Case 2: Water -> Land
                int waterFinish = waterStartTime[j] + waterDuration[j];
                int finish2 = Math.max(waterFinish, landStartTime[i]) + landDuration[i];

                // Keep track of the earliest finish time
                ans = Math.min(ans, finish1);
                ans = Math.min(ans, finish2);
            }
        }

        return ans;
    }
}