

#238. Product of Array Except Self

# Here I have used division operation

class Solution(object):
    def productExceptSelf(self, nums):
        total_product = 1
        zero_count = 0
        
        for num in nums:
            if num != 0:
                total_product *= num
            else:
                zero_count += 1
                
        result = []
        
        if zero_count > 1:
            return [0] * len(nums)
        
        for num in nums:
            if num != 0:
                if zero_count == 1:
                    result.append(0)
                else:
                    result.append(total_product // num)
            else:
                result.append(total_product)
        
        return result






# it is in java and it is brute force approach

# class Solution {

#     public int[] productExceptSelf(int[] nums) {

#         int n = nums.length;

#         int[] ans = new int[n];

#         // Initialize all elements with 1
#         for(int i = 0; i < n; i++) {
#             ans[i] = 1;
#         }

#         for(int i = 0; i < n; i++) {

#             for(int j = 0; j < n; j++) {

#                 if(i != j) {
#                     ans[i] *= nums[j];
#                 }
#             }
#         }

#         return ans;
#     }
# }
