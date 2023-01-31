package algorithm.dp;

public class CanJump {

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        int[] a = new int[]{2,5,0,0};
        System.out.println(canJump.canJumpLeet(a));
    }
    public boolean canJumpLeet(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean canJumpMisUnderstanding(int[] nums) {
        int loc = 0;
        while(loc < nums.length) {
            if( nums[loc] == 0) {
                if(loc==nums.length-1){
                    return true;
                }
                return false;
            }
            loc += nums[loc];
        }
        return true;
    }

}