package algorithm.dp;

import java.util.ArrayList;
import java.util.List;

public class YanghuiSanjiao {
    public static void main(String[] args){
        YanghuiSanjiao yanghuiSanjiao = new YanghuiSanjiao();
        System.out.println(yanghuiSanjiao.generate(1));
        System.out.println(yanghuiSanjiao.getRow(3));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> dp0 = new ArrayList<Integer>();
        dp0.add(1);
        ans.add(dp0);
        for (int i = 1 ; i < numRows; i++){
            List<Integer> dpi = new ArrayList<Integer>();
            List<Integer> pre = ans.get(i-1);
            dpi.add(pre.get(0));
            for (int j = 0 ;j < pre.size() -1; j++) {
                dpi.add(pre.get(j) + pre.get(j+1));
            }
            dpi.add(pre.get(pre.size() -1));
            ans.add(dpi);
        }
        return ans;
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        for (int i = 0 ; i < rowIndex; i++){
            List<Integer> dpn = new ArrayList<Integer>();
            dpn.add(pre.get(0));
            for (int j = 0 ;j < pre.size() -1; j++) {
                dpn.add(pre.get(j) + pre.get(j+1));
            }
            dpn.add(pre.get(pre.size() -1));
            pre = dpn;
        }
        return pre;
    }
}
