package structure.tree;

public class SegmentTree<Element> {

    private Element[] data;
    private Element[] tree;
    private Merger<Element> merger;

    public SegmentTree(Element[] arr, Merger<Element> merger){
        this.merger = merger;
        data = (Element[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++)
            data[i] = arr[i];
        tree = (Element[]) new Object[4 * arr.length];

        buildSegmentTree(0, 0, data.length - 1);
    }

    public int getSize(){
        return data.length;
    }

    public Element get(int index){
        if (index < 0 || index > data.length)
            throw new IllegalArgumentException("index is illegal");
        return data[index];
    }

    private int leftChild(int index){
        return  2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }

    private void buildSegmentTree(int treeIndex, int left, int right){
        if (left == right){
            tree[treeIndex] = data[left];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = left + (right - left) / 2;

        buildSegmentTree(leftTreeIndex, left, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, right);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public void update(int index, Element element){
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException();
        data[index] = element;
        update(0, 0, data.length - 1, index , element);
    }

    private void update(int treeIndex, int left, int right, int index, Element element) {
        if (left == right){
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

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public Element query(int qleft, int qright){
        if (qleft < 0 || qleft>= data.length || qright < 0 || qright >= data.length || qleft > qright)
            throw new IllegalArgumentException();
        return query(0,0,data.length - 1, qleft, qright);
    }

    /**
     *  在查询时会出现三种状况, 查询区间位于区间中点左边, 查询区间位于区间中点邮编 , 查询区间经过区间中点
     *
     * @param treeIndex tree 区间
     * @param left      区间下限
     * @param right     区间上限
     * @param qleft     查询左边界
     * @param qright    查询右边界
     * @return
     */
    private Element query(int treeIndex, int left, int right, int qleft, int qright) {
        if ((left == qleft)&&(right == qright)){
            return tree[treeIndex];
        }

        int mid = left + (right - left) / 2;
        int leftTreeChild = leftChild(treeIndex);
        int rightTreeChild = rightChild(treeIndex);

        if (qleft >= mid + 1)
            return query(rightTreeChild, mid + 1, right, qleft, qright);
        else if (qright <= mid)
            return query(leftTreeChild, left, mid, qleft, qright);

        Element leftResult = query(leftTreeChild, left, mid, qleft, mid);
        Element rightResult = query(rightTreeChild, mid + 1 , right, mid + 1, qright);
        return merger.merge(leftResult, rightResult);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++){
            if (tree[i] != null){
                res.append(tree[i]);
            } else {
                res.append("null");
            }
            if (i != tree.length - 1)
                res.append(",");
        }
        res.append(']');
        return res.toString();
    }

    public static void main(String[] args) {
        Integer[] nums = {2, 8, 4, 6, 5, 7, 1, 9};
        SegmentTree<Integer> tree = new SegmentTree<>(nums, ((a, b) -> a + b));
        System.out.println(tree);
        System.out.println(tree.query(0, 3));
        System.out.println(tree.query(1 ,3));
        System.out.println(tree.query(4, 6));
    }
}
