class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        ArrayList < Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if( min > nums[i])
                min = nums[i];

            if( max < nums[i])
                max = nums[i];
        list.add(nums[i]);
        }
        ArrayList < Integer> ret = new ArrayList<>();
        for(int i = min; i < max; i++){
            if(! list.contains(i) )
             ret.add(i);
        }
        return ret;
    }
}