package algorithm.sort;

public class QuickSort {
    public static void main(String[] args){
        int[] array = new int[]{4,6,5,8,2,9,1,3};
        QuickSort quickSort = new QuickSort();
        int[] res = quickSort.quickSort(array, 0 ,array.length -1);
        quickSort.printArray(res);
    }
    void printArray(int[] res){
        for(int i : res){
            System.out.print(i + " ") ;
        }
        System.out.println();
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            System.out.println("after partition");
            printArray(arr);
            quickSort(arr, left, partitionIndex - 1);
            System.out.println("after right move");
            printArray(arr);
            quickSort(arr, partitionIndex + 1, right);
            System.out.println("after left move");
            printArray(arr);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
