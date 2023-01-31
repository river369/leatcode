package algorithm.dp;

import java.util.ArrayList;
import java.util.List;

public class IsScramble {
    public static void main(String[] args) {
        IsScramble isScramble = new IsScramble();
        System.out.println(isScramble.isScramble("great", "rgeat"));
        System.out.println(isScramble.isScramble("abcde", "caebd"));
        System.out.println(isScramble.isScramble("a", "a"));
        //System.out.println(isScramble.isScramble("abcd bdac bdac", "bdac abcd bdac"));
        System.out.println(isScramble.isScramble("abac", "acab"));
    }


    //wrong
    public boolean isScramble(String s1, String s2) {
        List<String>[] dp = new List[s1.length()];

        List<String> dp0 = new ArrayList<String>();
        dp0.add(String.valueOf(s1.charAt(0)));
        dp[0] = dp0;

        for(int i=1;i<s1.length();i++){
            char c = s1.charAt(i);
            List<String> dpi = new ArrayList<String>();
            for(String s : dp[i-1]) {
                dpi.add(c+s);
                dpi.add(s+c);
            }
            dp[i] = dpi;
        }

        for (String s : dp[s1.length() -1]){
            if(s.equalsIgnoreCase(s2)) return true;
        }
        return false;
    }
}
