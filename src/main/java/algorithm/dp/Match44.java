package algorithm.dp;

public class Match44 {
    public static void main(String[] args){
        Match44 match44 = new Match44();
        //System.out.println(match44.isMatch("abc","a*c"));
        System.out.println(match44.isMatch("adceb","*a*b"));
        System.out.println(match44.isMatch("acdcb","a*cb"));
    }

    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        boolean[][] state = new boolean[sl+1][pl+1];
        state[0][0] = true;
        for (int i = 1; i <= sl; i++) {
            state[i][0] = false;
        }
        for (int j = 1; j <= pl; j++) {
            char pc = p.charAt(j-1);
            if(pc == '*') {
                state[0][j] = state[0][j-1];
            } else {
                state[0][j] = false;
            }
        }
        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                char sc = s.charAt(i-1);
                char pc = p.charAt(j-1);
                if(pc == sc || pc == '?') {
                    state[i][j] = state[i-1][j-1];
                } else if (pc == '*') {
                    state[i][j] = state[i-1][j-1] || state[i][j-1] || state[i-1][j];
                } else {
                    state[i][j] = false;
                }
            }
        }
        return state[sl][pl];
    }

}
