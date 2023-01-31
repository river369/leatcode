package algorithm.dp;

public class NumDecodings {

    public static void main(String[] args) {
        NumDecodings numDecodings = new NumDecodings();
        int[] a = new int[]{2,5,0,0};
        System.out.println(numDecodings.numDecodings("226"));
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        int preInt = Integer.parseInt(String.valueOf(s.charAt(0)));
        if (preInt==0) return 0;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2 ; i <= s.length(); i++){
            int currentInt = Integer.parseInt(String.valueOf(s.charAt(i-1)));
            int twoDigitNumber = preInt *10 + currentInt;
            preInt = currentInt;
            if (currentInt>0) dp[i] = dp[i-1];
            if (twoDigitNumber>9 && twoDigitNumber <27) dp[i] += dp[i-2];
        }
        return dp[s.length()];

    }

}