// 70 https://leetcode.com/problems/climbing-stairs/

//rec + memo
class Solution {
    
    private int solve(int n, int[] t) {
        if(n<0) return 0;
        if(n == 0) return 1;
        if(t[n] != -1) return t[n];
        
        int oneStep = solve(n-1,t);
        int twoStep = solve(n-2,t);
        
        return t[n] = oneStep+twoStep;
    }
    
    public int climbStairs(int n) {
        int[] t = new int[n+1];
        Arrays.fill(t,-1);     
        return solve(n,t);
    }
}

//bottom up
class Solution {
    public int climbStairs(int n) {
        
        if(n==1) return 1;
        int[] t = new int[n+1];
        //t[i] =  ways to reach till ith stair
        t[0]=0;
        t[1]=1;
        t[2]=2;
        
        for(int i=3; i<n+1; i++) {
            t[i] = t[i-1] + t[i-2];
        }
        return t[n];
    }
}

//space optimised
class Solution {
    public int climbStairs(int n) {
        
        if(n==1 || n==2) return n;
        
        int a=1; //i-2
        int b=2; //i-1
        int c=3; //i
        
        for(int i=3; i<n+1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}