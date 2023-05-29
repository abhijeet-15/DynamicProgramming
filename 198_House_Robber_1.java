// https://leetcode.com/problems/house-robber/

//rec + memo
class Solution {
    private int solve(int[] nums, int[] t, int idx) {
        
        if(idx >= nums.length)
            return 0;
        
        if(t[idx] != -1)
            return t[idx];
        
        int take = nums[idx] + solve(nums,t,idx+2);
        int notTake = solve(nums,t,idx+1);
        
        return t[idx] = Math.max(take, notTake);
    }
    public int rob(int[] nums) {
        int[] t = new int[nums.length+1];
        Arrays.fill(t,-1);
        return solve(nums,t,0);
    }
}

//Bottom up
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] t = new int[n+1];
        
        //t[i] --> max profit obtained till house i
        t[0]=0;
        t[1]=nums[0];
        
        for(int i=2; i<n+1; i++){
            t[i] = Math.max(t[i-2]+nums[i-1], t[i-1]);
        }
        
        return t[n];
    }
}