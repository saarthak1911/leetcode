class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> list= new ArrayList<>();
        combination(1, n , k , list , ans, 0);
        return ans;
    }
    void combination(int idx , int n , int k  , List<Integer> list , List<List<Integer>> ans , int sum){
        if(sum==n && list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(idx>9){
            return ;
        }

        list.add(idx);
        sum+=idx;
        combination(idx+1 , n, k , list, ans , sum);
        list.remove(list.size()-1);
        sum-=idx;

        //dont pick
        combination(idx+1 , n , k , list, ans, sum);
    }
}