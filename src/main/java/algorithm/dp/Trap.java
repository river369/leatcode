package algorithm.dp;

public class Trap {

    public static void main(String[] args) {
        Trap trap = new Trap();
        //int[] a = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[] a = new int[]{4,2,0,3,2,5};
        System.out.println(trap.trap(a));
    }

    //dp
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    //pointer
    public int trapPointer(int[] height) {
        int leftMostHighestPosition = 0, rightMostHighestPosition = 0;
        int totalWater = 0;
        // from left to right
        for(int i = 1; i<height.length; i++){
            if(height[i] >= height[leftMostHighestPosition] ) {
                rightMostHighestPosition = i;
                //add water
                totalWater += calculateWater(height, leftMostHighestPosition, rightMostHighestPosition);
            }
            leftMostHighestPosition = rightMostHighestPosition;
        }
        if(leftMostHighestPosition == rightMostHighestPosition){
            //from end to start
            int highest = leftMostHighestPosition;
            rightMostHighestPosition = height.length-1;
            leftMostHighestPosition = rightMostHighestPosition;

            for(int i = height.length-1; i>=highest; i--){
                if(height[i] > height[rightMostHighestPosition] ) {
                    leftMostHighestPosition = i;
                    //add water
                    totalWater += calculateWater(height, leftMostHighestPosition, rightMostHighestPosition);
                }
                rightMostHighestPosition = leftMostHighestPosition;
            }
        }
        return totalWater;
    }
    public int calculateWater(int[] height, int left, int right){
        int h = Math.min(height[left], height[right]);
        int w = right - left + 1;
        int s= w*h;
        for (int i=left; i<=right; i++){
            s -= Math.min(height[i], h);
        }
        return s;
    }

    // pinter in leet code
    public int trapFromLeetCode(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}