import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumber {
    public static void main(String[] args){
        ThreeNumber threeNumber  = new ThreeNumber();
        //int[] nums = new int[]{-1,0,1,2,-1,-4};
        //int[] nums = new int[]{0,0,0};
        //int[] nums = new int[]{0,0,0,0};
        int[] nums = new int[]{-2,0,1,1,2};
        System.out.println(threeNumber.threeSum(nums));
    }
    public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList();
            int len = nums.length;
            if(nums == null || len < 3) return ans;
            Arrays.sort(nums); // 排序
            for (int i = 0; i < len ; i++) {
                if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
                if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
                int L = i+1;
                int R = len-1;
                while(L < R){
                    int sum = nums[i] + nums[L] + nums[R];
                    if(sum == 0){
                        ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                        while (L<R && nums[L] == nums[L+1]) L++; // 去重
                        while (L<R && nums[R] == nums[R-1]) R--; // 去重
                        L++;
                        R--;
                    }
                    else if (sum < 0) L++;
                    else if (sum > 0) R--;
                }
            }
            return ans;
    }
    /*
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int begin = 0, end = nums.length-1;
        ArrayList res = new ArrayList();
        while(begin < end) {
            int sum2 = nums[begin] + nums[end];
            for (int i = begin+1; i<end; i++){
                int sum3 = sum2 + nums[i];
                if (sum3 == 0 ) {
                    ArrayList item = new ArrayList();
                    item.add(nums[begin]);
                    item.add(nums[end]);
                    item.add(nums[i]);
                    res.add(item);
                    //break;
                }
            }
            if (sum2>0) {
                while(begin<end){
                    end--;
                    if(nums[end]!=nums[end+1]) {
                        break;
                    }
                }
            } else {
                while(begin<end){
                    begin++;
                    if(nums[begin]!=nums[begin-1]) {
                        break;
                    }
                }
            }
        }
        return res;
    }
     */
}
