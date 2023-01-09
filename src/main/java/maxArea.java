import java.util.PriorityQueue;
import java.util.Queue;

public class maxArea {

    public static void main(String[] args){
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add("s1");priorityQueue.add("s2");
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.size());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.size());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.size());
        System.out.println(Math.pow(2,32) +"   "+ Integer.MAX_VALUE);
        maxArea maxArea = new maxArea();
        int[] h = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea.maxArea(h));
    }
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

//    public int maxArea(int[] height) {
//        int ret = 0;
//        for(int i=0; i<height.length ; i++){
//            for (int j=i+1;j<height.length; j++){
//                int l = j-i;
//                int h = Math.min(height[i],height[j]);
//                int multi = l * h;
//                if (multi>ret){
//                    ret = multi;
//                }
//            }
//        }
//        return ret;
//    }
}
