package leetcode.search;

class SegmentTree {

    private int[] data;
    private int[] tree;

    public SegmentTree(int[] arr) {

        data = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            data[i] = arr[i];
        tree = new int[4 * arr.length];

        buildSegmentTree(0, 0, data.length - 1);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void buildSegmentTree(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = left + (right - left) / 2;

        buildSegmentTree(leftTreeIndex, left, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, right);

        tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
    }

    public void update(int index, int element) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException();
        data[index] = element;
        update(0, 0, data.length - 1, index, element);
    }

    private void update(int treeIndex, int left, int right, int index, int element) {
        if (left == right) {
            tree[treeIndex] = element;
            return;
        }
        int mid = left + (right - left) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (index >= mid + 1)
            update(rightTreeIndex, mid + 1, right, index, element);
        else
            update(leftTreeIndex, left, mid, index, element);

        tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
    }

    public int query(int qleft, int qright) {
        if (qleft < 0 || qleft >= data.length || qright < 0 || qright >= data.length || qleft > qright)
            throw new IllegalArgumentException();
        return query(0, 0, data.length - 1, qleft, qright);
    }

    /**
     * 在查询时会出现三种状况, 查询区间位于区间中点左边, 查询区间位于区间中点邮编 , 查询区间经过区间中点
     *
     * @param treeIndex tree 区间
     * @param left      区间下限
     * @param right     区间上限
     * @param qleft     查询左边界
     * @param qright    查询右边界
     * @return
     */
    private int query(int treeIndex, int left, int right, int qleft, int qright) {
        if ((left == qleft) && (right == qright)) {
            return tree[treeIndex];
        }

        int mid = left + (right - left) / 2;
        int leftTreeChild = leftChild(treeIndex);
        int rightTreeChild = rightChild(treeIndex);

        if (qleft >= mid + 1)
            return query(rightTreeChild, mid + 1, right, qleft, qright);
        else if (qright <= mid)
            return query(leftTreeChild, left, mid, qleft, qright);

        int leftResult = query(leftTreeChild, left, mid, qleft, mid);
        int rightResult = query(rightTreeChild, mid + 1, right, mid + 1, qright);
        return leftResult + rightResult;
    }
}

public class Medium_NumArray {
    private SegmentTree tree;

    public Medium_NumArray(int[] nums) {
        if(nums.length != 0 && nums != null){
            tree = new SegmentTree(nums);
        }
    }

    public void update(int i, int val) {
        tree.update(i, val);
    }

    public int sumRange(int i, int j) {
        return tree.query(i, j);
    }

}
