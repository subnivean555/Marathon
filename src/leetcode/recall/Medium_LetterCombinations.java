package leetcode.recall;

import java.util.ArrayList;
import java.util.List;

public class Medium_LetterCombinations {

    private String[] letterMap = {
           " ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };

    private ArrayList<String> res;


    public List<String> letterCombinations(String digits) {
        res = new ArrayList<String>();
        if (digits.equals(""))
            return res;

        findCombination(digits, 0, "");

        return res;
    }

    private void findCombination(String digits, int index, String s) {

        if (index == digits.length()){
            res.add(s);
            return;
        }

        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++){
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
        return;
    }

    private static void printList(List<String> list){
        for(String s: list)
            System.out.println(s);
    }

    public static void main(String[] args) {
        printList(new Medium_LetterCombinations().letterCombinations("23"));
    }

}
