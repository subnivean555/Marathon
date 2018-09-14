package structure.heap;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  索引堆
 *  索引对并不操作原始数组, 而是操作 索引数组
 *
 */
public class IndexMaxPriorityQueue<Key extends Comparable<Key>> implements Iterable<Integer> {

    /**
     *  通过索引来快速访问堆中元素,
     */
    private int[] index;

    /**
     *  rev 数组保存的是 index 数组的反转, 用以快速进行交换操作
     *  index[i] - rev[index[i]] = index[rev[i]] = i
     */
    private int[] rev;

    /**
     *  保存堆中的元素
     */
    private Key[] keys;

    /**
     *  堆中的元素个数
     */
    private int len;

    public IndexMaxPriorityQueue(int max){
        if (max < 0)
            throw new IllegalArgumentException();
        len = 0;
        keys = (Key[]) new Comparable[max + 1];
        index = new int[max + 1];
        rev = new int[max + 1];
        for (int i = 0; i <= max; i++)
            rev[i] = -1;
    }

    public boolean isEmpty(){
        return len == 0;
    }

    public boolean contains(int i){
        return rev[i] != -1;
    }

    public int size(){
        return len;
    }

    /**
     * 插入方法
     * @param i
     * @param key
     */
    public void insert(int i, Key key){
        if (contains(i))
            throw new IllegalArgumentException("index is already in the priority queue");
        len++;
        rev[i] = len;
        index[len] = i;
        keys[i] = key;
        swim(len);
    }

    /**
     *  最大索引
     * @return
     */
    public int maxIndex(){
        if (len == 0)
            throw new NoSuchElementException("priority queue underflow");
        return index[1];
    }

    /**
     *  最大值
     * @return
     */
    public Key maxKey(){
        if (len == 0)
            throw new NoSuchElementException("Priority queue underflow");
        return keys[index[1]];
    }

    public int delMax(){
        if (len == 0)
            throw new NoSuchElementException("Priority queue underflow");
        int min = index[1];
        exch(1, len--);
        sink(1);

        rev[min] = -1;
        keys[min] = null;
        index[len + 1] = -1;
        return min;
    }

    public Key keyOf(int i){
        if (!contains(i))
            throw new NoSuchElementException("index is not in the priority queue");
        else
            return keys[i];
    }

    public void changeKey(int i, Key key){
        if (!contains(i))
            throw new NoSuchElementException("index is not in the priority queue");
        keys[i] = key;
        swim(rev[i]);
        sink(rev[i]);
    }

    public void increaseKey(int i, Key key){
        if (!contains(i))
            throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) >= 0)
            throw new IllegalArgumentException("calling increaseKey() with given argument would not strictly increase the key");
        keys[i] = key;
        swim(rev[i]);
    }

    public void decreaseKey(int i, Key key){
        if (!contains(i))
            throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) >= 0)
            throw new IllegalArgumentException("calling increaseKey() with given argument would not strictly increase the key");
        keys[i] = key;
        sink(rev[i]);
    }

    public void delete(int i){
        if (!contains(i))
            throw new NoSuchElementException("index is not in the priority queue");
        int temp = rev[i];
        exch(temp, len--);
        swim(temp);
        sink(temp);
        keys[i] = null;
        rev[i] = -1;
    }

    private boolean less(int i, int j){
        return keys[index[i]].compareTo(keys[index[j]]) < 0;
    }

    private void exch(int i, int j){
        int swap = index[i];
        index[i] = index[j];
        index[j] = swap;
        rev[index[i]] = i;
        rev[index[j]] = j;
    }

    private void swim(int k){
        while (k > 1 && less(k / 2, k)){
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k){
        while (2 * k <= len){
            int j = 2 * k;
            if (j < len && less(j, j + 1))
                j++;
            if (!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new HeapIterator();
    }

    /**
     * 迭代器会返回 最大堆 keys 的索引
     */
    private class HeapIterator implements Iterator<Integer>{

        private IndexMaxPriorityQueue<Key> copy;

        public HeapIterator(){
            copy = new IndexMaxPriorityQueue<Key>(index.length - 1);
            for (int i = 1; i <= len; i++)
                copy.insert(index[i], keys[index[i]]);
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        @Override
        public Integer next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return copy.delMax();
        }
    }


    public static void main(String[] args) {

        String[] strings = { "it", "was", "the", "best", "of", "times", "it", "was", "the", "worst" };

        IndexMaxPriorityQueue<String> priorityQueue = new IndexMaxPriorityQueue<>(strings.length);
        for (int i = 0; i < strings.length; i++){
            priorityQueue.insert(i, strings[i]);
        }

        Iterator it = priorityQueue.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
