package algorithm.dp;

public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] a = new int[]{1,3};
        System.out.println(maxSubArray.maxSubArray(a));
    }
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
    // this is still 2 dimension in fact, just for save memory
    public int maxSubArray1DimensionArray(int[] nums) {
        int nl = nums.length;
        int al = nl*(nl-1)/2 + nl;
        int[] dp = new int[al];

        int max = Integer.MIN_VALUE;
        int cum = 0;
        for (int i = 0; i<nl ; i++) {
            int loc = i*nl+i-i-cum;
            dp[loc] = nums[i];
            if(dp[loc]> max){
                max = dp[loc];
            }
            cum += i;
        }
        cum = 0;
        for(int i = 0; i < nl; i++) {
            //System.out.println("i="+i);
            for(int j = i+1; j < nl; j++) {
                int loc = i*nl+j-i-cum;
                //System.out.print(" j="+j);
                dp[loc] = dp[loc-1] + nums[j];
                if(dp[loc]> max){
                    max = dp[loc];
                }
            }
            cum += i;
        }
        return max;
    }

    public int maxSubArray2DimensionArray(int[] nums) {
        int l = nums.length;
        int[][] dp = new int[l][l];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i<l ; i++) {
            dp[i][i] = nums[i];
            if(dp[i][i]> max){
                max = dp[i][i];
            }
        }
        for(int i = 0; i < l; i++) {
            //System.out.println("i="+i);
            for(int j = i+1; j < l; j++) {
                //System.out.print(" j="+j);
                dp[i][j] = dp[i][j-1] + nums[j];
                if(dp[i][j]> max){
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
}