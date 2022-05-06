package com.likou;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelphoneStrConbination {

    public static void main(String[] args) {
//        System.out.println(new TelphoneStrConbination().letterCombinations("2"));
        System.out.println(new TelphoneStrConbination().letterCombinations2("23"));
    }


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

    public List<String> letterCombinations2(String digits) {
        if (digits== null || digits.length()==0) return new ArrayList<>();
        Map<Character, String> alpha = new HashMap<>();
//        alpha.put('1', "abc");
        alpha.put('2', "abc");
        alpha.put('3', "def");
        alpha.put('4', "ghi");
        alpha.put('5', "jkl");
        alpha.put('6', "mno");
        alpha.put('7', "pqrs");
        alpha.put('8', "tuv");
        alpha.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        compute(result, digits, alpha, 0, new StringBuffer());
        return result;

    }

    private void compute(List<String> result, String digits, Map<Character, String> alpha, int index, StringBuffer thisTime) {
        int digLen = digits.length();
        if (index == digLen) {
            result.add(thisTime.toString());
        } else {
            String s = alpha.get(digits.charAt(index));
            for (int j = 0; j < s.length(); j++) {
                thisTime.append(s.charAt(j));
                compute(result, digits, alpha, index+1, thisTime);
                thisTime.deleteCharAt(index);
            }
        }
    }

    private StringBuffer perDeal(String substring, Map<Character, String> alpha) {
        StringBuffer buffer = new StringBuffer();
        int length = substring.length();
        for (int i = 0; i < length; i++) {
            String s = alpha.get(substring.charAt(i));
            buffer.append(s);
            if (length > 0) {
                perDeal(substring.substring(i + 1, length), alpha);
            }


        }


        return buffer;
    }
}
