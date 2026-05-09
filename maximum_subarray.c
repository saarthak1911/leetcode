int maxSubArray(int nums[], int n) {
    int maxSum = INT_MIN;

    for (int st = 0; st < n; st++) {
        int currSum = 0;

        for (int end = st; end < n; end++) {
            currSum += nums[end];

            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }
    }

    return maxSum;
}