package algorithm.dp;

public class ClimbStairs {

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(5));
    }
    public int climbStairs(int n) {
        int[] dp = new int[n];
        dp[0]= 1;
        if(n>1) dp[1]=2;
        for (int i=2; i<n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}