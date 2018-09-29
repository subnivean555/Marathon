package leetcode.recall;

import java.util.ArrayList;
import java.util.List;

public class Medium_Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        generate(n, k, 1, list, temp);
        return list;
    }

    private void generate(int n, int k, int start, List<List<Integer>> res, ArrayList<Integer> temp){
        if (temp.size() == k){
            res.add(new ArrayList<>(temp));
        } else if (temp.size() > k){
            return;
        } else {
            for (int i = start; i <= n - (k- temp.size()) + 1; i++){
                temp.add(i);
                generate(n, k, i + 1, res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
