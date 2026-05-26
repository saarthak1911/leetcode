class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        Set<Integer> st1 = new HashSet<>();
        Set<Integer> st2 = new HashSet<>();

        
        for (int num : nums1) {
            st1.add(num);
        }

        for (int num : nums2) {
            st2.add(num);
        }

        List<Integer> ls1 = new ArrayList<>();
        for (int num : st1) {
            if (!st2.contains(num)) {
                ls1.add(num);
            }
        }

        List<Integer> ls2 = new ArrayList<>();
        for (int num : st2) {
            if (!st1.contains(num)) {
                ls2.add(num);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(ls1);
        ans.add(ls2);

        return ans;
    }
}