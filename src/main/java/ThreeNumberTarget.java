import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberTarget {
    public static void main(String[] args){
        ThreeNumberTarget threeNumber  = new ThreeNumberTarget();

        int[] nums = new int[]{-102,0,5,19,101};
        System.out.println(threeNumber.threeSumClosest(nums,3));
    }
    public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums); // 排序
            int res = 0, distance=Integer.MAX_VALUE;
            for(int i=0; i<nums.length; i++){
                int newTarget = target - nums[i];
                int start = i + 1 ;
                int end = nums.length - 1;
                while(start < end) {
                    int sum = nums[i] + nums[start] + nums[end];
                    int delta = sum - target;
                    if(Math.abs(delta) < distance){
                        res = sum;
                        distance = Math.abs(delta);
                    }
                    if(nums[start] + nums[end] - newTarget <0){
                        start++;
                    }else {
                        end--;
                    }
                }
            }
            return res;
    }

}
