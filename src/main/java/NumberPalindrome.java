public class NumberPalindrome {
    public static void main(String[] args){
        NumberPalindrome numberPalindrome = new NumberPalindrome();
        System.out.println(numberPalindrome.isPalindrome(13));
    }
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        String s = String.valueOf(x);

        int b = 0, e = s.length()  - 1;

        while (b < e) {
            char bc = s.charAt(b);
            char ec = s.charAt(e);
            if(ec!=bc) return false;
            b++;
            e--;
        }
        return true;
    }
}
