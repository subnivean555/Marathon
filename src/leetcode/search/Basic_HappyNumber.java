package leetcode.search;


import java.util.HashSet;
import java.util.Set;

public class Basic_HappyNumber {

    /**
     *  runtime 7ms
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while (n != 1){
            int temp = 0;
            while(n > 0){
                int a = n % 10;
                temp += a * a;
                n = n / 10;
            }
            if (set.contains(temp)){
                return false;
            } else {
                set.add(temp);
            }
            n = temp;
        }
        return true;
    }

    public boolean isHappy_better(int n ){
        if (n == 1)
            return true;

        int result = 0;

        while (true){
            while (n > 0){
                result += Math.pow(n % 10, 2);
                n /= 10;
            }

            if (result == 1){
                return true;
            } else if (result == 4){
                return false;
            } else {
                n = result;
                result = 0;
            }
        }
    }
}
