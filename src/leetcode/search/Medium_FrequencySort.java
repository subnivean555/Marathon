package leetcode.search;

public class Medium_FrequencySort {

    public String frequencySort(String s) {
        final int ASCII_CHARS = 128;
        int[] letters = new int[ASCII_CHARS];
        StringBuilder sb = new StringBuilder();
        int max = 0, index = 0;

        for (char c : s.toCharArray())
            letters[c]++;

        for (int i = 0; i < ASCII_CHARS; i++){
            max = 0;
            index = 0;
            for (int j = 0; j < ASCII_CHARS; j++){
                if (letters[j] > max){
                    max = letters[j];
                    index = j;
                }
            }
            for (int k = 0; k < max; k++)
                sb.append((char)index);

            letters[index] = -1;
        }

        return sb.toString();
    }

}
