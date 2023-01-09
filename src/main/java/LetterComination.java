import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterComination {

    public static void main(String[] args){
        LetterComination letterComination = new LetterComination();
        System.out.println(letterComination.letterCombinations("234"));

    }
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        char[][] number2Char = new char[][]{
                {},{},
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}
        };
        getStrings( combinations, number2Char, digits, 0, new StringBuffer());
        return combinations;
    }

    void getStrings( List<String> combinations,char[][] number2Char,String digits, int level, StringBuffer sb){
        if(level < digits.length()){
            int number = Integer.parseInt(String.valueOf(digits.charAt(level)));
            System.out.println(number);
            for(int i =0; i< number2Char[number].length; i++) {
                sb.append(number2Char[number][i]);
                getStrings( combinations, number2Char, digits, level+1, sb);
                sb.deleteCharAt(level);
            }
        } else {
            combinations.add(sb.toString());
        }
    }
    /*
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

     */
}
