public class Int2Roman {

    public static void main(String[] args){
        Int2Roman int2Roman = new Int2Roman();
        System.out.println("======"+int2Roman.intToRoman(14));
    }
    /*
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
49 应该写作 XLIX，999 应该写作 CMXCIX
     */
    public String intToRoman(int num) {
        int values[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String reps[] = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String res = "";
        for (int i = 0; i < 13; i ++ ) {
            while(num >= values[i])
            {
                num -= values[i];
                res += reps[i];
            }
        }
        return res;
    }

    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

}
