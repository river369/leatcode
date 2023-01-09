public class LongestPalindrome {

    public static void main(String[] args){
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        //System.out.println(longestPalindrome.longestPalindrome("a"));
        //System.out.println(longestPalindrome.longestPalindrome("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
        System.out.println(longestPalindrome.longestPalindrome("xcsx"));

    }

    public String longestPalindrome(String s) {
        int maxLength = 0;
        String maxString = "";
        for(int i = 0 ; i < s.length() ; i++) {
            String startS = String.valueOf(s.charAt(i));
            int endLoctaion = s.lastIndexOf(startS,s.length());
            while (endLoctaion > 0) {
                int tis = i + 1 ;
                int tie = endLoctaion - 1;
                boolean isPalindrome = true;
                while ( tis < tie){
                    String ss = String.valueOf(s.charAt(tis));
                    String es = String.valueOf(s.charAt(tie));
                    if(es.equalsIgnoreCase(ss)){
                        tis++;
                        tie--;
                    } else {
                        isPalindrome = false;
                        break;
                    }
                }

               if (isPalindrome) {
                   int retLength = endLoctaion - i;
                   if (retLength > maxLength){
                       maxLength = retLength;
                       maxString = s.substring(i, endLoctaion + 1);
                   }
                   break;
               }
               endLoctaion = s.lastIndexOf(startS, endLoctaion-1);
            }
        }

        if (maxLength == 0) {
            return String.valueOf(s.charAt(0));
        } else {
            return maxString;
        }
    }
}
