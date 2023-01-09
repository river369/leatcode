public class MyAToI {

    public static void main(String[] args){
        MyAToI myAToI = new MyAToI();
        System.out.println( myAToI.myAtoi(" -91283472332 "));
    }
    public int myAtoi(String s) {
        String sc = s.trim();
        char c = sc.charAt(0);
        if (!Character.isDigit(c) && c!='-' ){
            return 0;
        }

        boolean startNumber = false;
        boolean minus = false;
        int ret = 0;
        for(int i=0; i<sc.length()  ; i++) {
            c = sc.charAt(i);
            if(Character.isDigit(c)){
                int ci = Integer.parseInt(String.valueOf(c));
                if(!startNumber){
                    startNumber=true;
                    if (i > 0 && sc.charAt(i-1) == '-') {
                       minus = true;
                    }
                }
                if (!minus && ret>Integer.MAX_VALUE/10){
                    return Integer.MAX_VALUE;
                }
                if (minus && ret*-1 < Integer.MIN_VALUE /10){
                    return Integer.MIN_VALUE;
                }
                ret = ret * 10 + ci;
            } else{
                if (startNumber){
                    break;
                }
            }
        }
        return minus? -1*ret : ret;
    }
}
