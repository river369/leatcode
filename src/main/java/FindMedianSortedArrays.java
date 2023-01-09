public class FindMedianSortedArrays {

    public static void main(String[] args){
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        int[] nums1 = new int[]{1,5};
        int[] nums2 = new int[]{3};
        double r = findMedianSortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(r);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0; ;
        int j = 0;
        int[] numsN = new int[nums1.length + nums2.length];
        int k = 0;
        while( i < nums1.length || j < nums2.length ){
            if(i == nums1.length) {
                numsN[k] = nums2[j];
                j++;
                k++;
            } else if ( j == nums2.length) {
                numsN[k] = nums1[i];
                i++;
                k++;
            } else {
                if(nums1[i] <= nums2[j]){
                    numsN[k] = nums1[i];
                    i++;
                    k++;
                } else {
                    numsN[k] = nums2[j];
                    j++;
                    k++;
                }
            }

        }
        int numsLength = numsN.length;
        if (numsLength%2 == 0){
            double r = (numsN[numsLength/2]+ numsN[numsLength/2 -1])/2.0;
            //System.out.println(r);
            return r;
        } else {
            //System.out.println(numsLength/2);
            return numsN[numsLength/2];
        }

    }
}
