import java.util.*;

public class GenerateParenthesis {

    public static void main(String[] args){
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println( generateParenthesis.generateParenthesis(5));

        /*
i=0 dp=[]
i=1 dp=[()]
i=2 dp=[(()), ()()]
i=3 dp=[((())), (()()), ()(()), ()()(), (())()]
i=4 dp=[(((()))), ((()())), (()(())), (()()()), ((())()), ()((())), ()(()()), ()()(()), ()()()(), ()(())(), (())(()), (())()(), ((()))(), (()())()]
i=5 dp=[((((())))), (((()()))), ((()(()))), ((()()())), (((())())), (()((()))), (()(()())), (()()(())), (()()()()), (()(())()), ((())(())), ((())()()), (((()))()), ((()())()), ()(((()))), ()((()())), ()(()(())), ()(()()()), ()((())()), ()()((())), ()()(()()), ()()()(()), ()()()()(), ()()(())(), ()(())(()), ()(())()(), ()((()))(), ()(()())(), (())((())), (())(()()), (())()(()), (())()()(), (())(())(), ((()))(()), ((()))()(), (()())(()), (()())()(), (((())))(), ((()()))(), (()(()))(), (()()())(), ((())())()]
         */
    }
    public List<String> generateParenthesis(int n) {
        List<String>[] dp = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            dp[i] = calculatePure(i, dp);
            System.out.println("i="+ i + " dp=" +dp[i]);
        }
        return dp[n];
    }
    public List<String> calculatePure(int n, List<String>[] dp) {
        List<String> ret = new ArrayList<String>();
        if (n == 0) {
            ret.add("");
            return ret;
        }
        if (n == 1) {
            ret.add("()");
            return ret;
        }
        List<String> nextLevel = dp[n-1];

        for (int i=0; i<n ; i++){
            for(String left : dp[i]){
                for(String right : dp[n-i-1]){
                    ret.add("(" + left  + ")"+right);
                }
            }
        }
        return ret;
    }
    /*
    public List<String> calculatePure(int n, List<String>[] dp) {
        Set<String> uniqueSet = new HashSet<String>();
        List<String> ret = new ArrayList<String>();
        if (n == 1) {
            ret.add("()");
            return ret;
        }
        List<String> nextLevel = dp[n-1];

        //add () to the value
        for (String pre : nextLevel) {
            String nv = "(" + pre  + ")";
            if (!uniqueSet.contains(nv)) {
                uniqueSet.add(nv);
                ret.add(nv);
            }

            // this part is not need.
            nv = "()" + pre;
            if (!uniqueSet.contains(nv)) {
                uniqueSet.add(nv);
                ret.add(nv);
            }
            nv = pre + "()";
            if (!uniqueSet.contains(nv)) {
                uniqueSet.add(nv);
                ret.add(nv);
            }
        }
        for (int i=1; i<n ; i++){
            for(String left : dp[i]){
                for(String right : dp[n-i]){
                    String value = left+right;
                    if(!uniqueSet.contains(value)){
                        uniqueSet.add(value);
                        ret.add(value);
                    }
                }
            }
        }
        return ret;
    }
     */
}