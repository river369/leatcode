public class ZConvert {

    public static void main(String[] args){
        ZConvert zConvert = new ZConvert();
        System.out.println(zConvert.convert("PAYPALISHIRING" +
                "3", 3));

    }
    public String convert(String s, int numRows) {
        if (numRows <= 1 ) {
            return s;
        }

        String[][] outputs = new String[numRows][s.length()];

        int groupGraphLength = numRows - 1;
        int groupNumberLength = numRows + numRows - 2;


        for(int i = 0 ; i < s.length(); i++) {
            String si = String.valueOf(s.charAt(i));
            int group = i / groupNumberLength;
            int row = i % groupNumberLength;
            int column = group * groupGraphLength;
            if (row >= numRows) {
                column = column + row - numRows + 1;
            }
            if (row >= numRows) {
                row = numRows - 2 - (row - numRows);
            }
            outputs[row][column] = si;
        }

        StringBuffer outputStringBuffer = new StringBuffer();
        for (int i = 0; i < outputs.length; i++) {
            for (int j = 0; j < outputs[i].length; j++) {
                String so = outputs[i][j];
                if (so != null){
                    outputStringBuffer.append(so);
                }
            }
            //outputStringBuffer.append("\n");
        }
        return outputStringBuffer.toString();

    }
}
