public class Match {
    public static void main(String[] args){
        Match match = new Match();
        System.out.println(match.isMatch("abc","a.c"));
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
                state[0][j] = state[0][j-2];
            } else {
                state[0][j] = false;
            }
        }
        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                char sc = s.charAt(i-1);
                char pc = p.charAt(j-1);
                if(pc == sc || pc == '.') {
                    state[i][j] = state[i-1][j-1];
                } else if (pc == '*') {
                    if (state[i][j-2]){
                        state[i][j] = state[i][j-2];
                    } else {
                        char pf = p.charAt(j -2);
                        if (pf == sc || pf == '.'){
                            state[i][j] = state[i-1][j];
                        } else {
                            state[i][j] = false;
                        }
                    }
                } else {
                    state[i][j] = false;
                }
            }
        }
        return state[sl][pl];
    }
//    public boolean isMatch(String s, String p) {
//        int m = s.length();
//        int n = p.length();
//
//        boolean[][] f = new boolean[m + 1][n + 1];
//        f[0][0] = true;
//        for (int i = 0; i <= m; ++i) {
//            for (int j = 1; j <= n; ++j) {
//                if (p.charAt(j - 1) == '*') {
//                    f[i][j] = f[i][j - 2];
//                    if (matches(s, p, i, j - 1)) {
//                        f[i][j] = f[i][j] || f[i - 1][j];
//                    }
//                } else {
//                    if (matches(s, p, i, j)) {
//                        f[i][j] = f[i - 1][j - 1];
//                    }
//                }
//            }
//        }
//        return f[m][n];
//    }
//
//    public boolean matches(String s, String p, int i, int j) {
//        if (i == 0) {
//            return false;
//        }
//        if (p.charAt(j - 1) == '.') {
//            return true;
//        }
//        return s.charAt(i - 1) == p.charAt(j - 1);
//    }
//    public boolean isMatch(String s, String p) {
//        int sPointer = 0, pPointer = 0;
//        char sc,pc;
//        while(sPointer < s.length() && pPointer < p.length()){
//             sc = s.charAt(sPointer);
//             pc = p.charAt(pPointer);
//             if (sc == pc || pc == '.') {
//                 sPointer++;
//                 pPointer++;
//             } else if (pc == '*') {
//                 char lastS = sc;
//                 while(sPointer < s.length()){
//                     sPointer++;
//                     if(sPointer == s.length()){
//                         pPointer ++;
//                         break;
//                     }
//                     sc = s.charAt(sPointer);
//                     if (sc != lastS){
//                         pPointer ++;
//                         break;
//                     }
//                 }
//             } else {
//                 if(pPointer< p.length()-1) {
//                     pPointer++;
//                     pc = p.charAt(pPointer);
//                     if(pc=='*'){
//                         pPointer++;
//                     } else {
//                         return false;
//                     }
//                 }
////                 return false;
//             }
//        }
//        if(sPointer < s.length()) return false;
//        if(pPointer < p.length()) {
//            while(pPointer < p.length()){
//                pc = p.charAt(pPointer);
//                if(pc!='*') return false;
//                pPointer++;
//            }
//        }
//        return true;
//    }
//    public boolean isMatch(String s, String p) {
//        int sl = s.length();
//        int pl = p.length();
//        boolean [][] state = new boolean[pl][sl];
//        for (int i = 0; i < pl; i++) {
//            for (int j = 0; j < sl; j++) {
//                char ic = p.charAt(i);
//                char jc = s.charAt(j);
//                if ((ic == jc || jc=='.') && (i == 0 || j== 0)) {
//                    state[i][j] = true;
//                } else if ((ic == jc || jc=='.') && (i > 0 && j > 0)) {
//                    state[i][j] = state[i-1][j-1];
//                }
//            }
//        }
//        return false;
//    }




}
