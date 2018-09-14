package structure.tree;

public class BinarySearch {

    public static int search(Comparable[] arr, int len, Comparable target){

        int l = 0, r = len - 1;
        while (l <= r){
            int mid = l + (l - r) / 2;
            if (arr[mid] == target){
                return mid;
            }
            if (arr[mid].compareTo(target) < 0){
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return len;
    }
}
