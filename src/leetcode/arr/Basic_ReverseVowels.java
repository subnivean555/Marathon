package leetcode.arr;

import java.util.ArrayList;
import java.util.List;

public class Basic_ReverseVowels {

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();

        int i = 0, j = arr.length - 1;
        List<Character> list = new ArrayList();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');
        while (i <= j){
            while (i < j && !list.contains(arr[i])){
                i++;
            }
            while (i < j && !list.contains(arr[j])){
                j--;
            }
            swap(arr, i , j);
            i++;
            j--;
        }

        return new String(arr);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
