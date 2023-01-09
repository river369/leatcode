public class LongestCommonPrefix {
    public static void main(String[] args){
        LongestCommonPrefix match = new LongestCommonPrefix();
        String[] strs = new String[]{"","abcde","abcdsss","abcdffs"};
        System.out.println(match.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {

        String res = "";
        for (int i=0; i<strs.length; i++){
            if(strs[i].length()==0){
                return res;
            }
        }
        boolean end = false;
        int pointer = 0;
        while (!end) {
            char common = strs[0].charAt(pointer) ;
            if(pointer == strs[0].length() - 1) end = true;
            for (int i=1; i<strs.length; i++){
                char c = strs[i].charAt(pointer);
                if(c!=common) {
                    return res;
                }
                if(pointer == strs[i].length() - 1) end = true;
            }
            pointer++;
            res += common;
        }
        return res;
    }

}
