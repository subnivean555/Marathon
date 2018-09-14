package structure.heap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *  为什么使用 优先队列, 在 N 个元素中选出前 M 名,
 *  排序算法的复杂度为 N*logN,
 *  优先队列的复杂度为 N*logM
 *
 *  algo4 中实现的 最大堆
 * @param <Key>
 */

public class MaxPriorityQueue<Key> implements Iterable<Key> {

    private Key[] keys;
    private int n;
    private Comparator<Key> comparator;

    public MaxPriorityQueue(int initCapacity){
        keys = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    public MaxPriorityQueue(){
        this(1);
    }

    public MaxPriorityQueue(int initCapacity, Comparator<Key> comparator){
        this.comparator = comparator;
    }

    public MaxPriorityQueue(Comparator<Key> comparator){
        this(1, comparator);
    }

    public MaxPriorityQueue(Key[] keys){
        n = keys.length;
        this.keys = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++){
            this.keys[i + 1] = keys[i];
        }
        for (int k = n / 2; k >= 1; k--){
            sink(k);
        }
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public Key max(){
        if (isEmpty())
            throw new NoSuchElementException("priority queue underflow");
        return keys[1];
    }

    private void resize(int capacity){
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++){
            temp[i] = keys[i];
        }
        keys = temp;
    }

    public void insert(Key x){
        if (n == keys.length - 1){
            resize(2 * keys.length);
        }
        keys[++n] = x;
        swim(n);
    }

    public Key delMax(){
        if (isEmpty())
            throw new NoSuchElementException("Priority queue underflow");

        Key max = keys[1];
        exch(1, n--);
        sink(1);
        keys[n + 1] = null;
        if ((n > 0) && (n == (keys.length - 1)/4)){
            resize(keys.length / 2);
        }
        return max;
    }

    /**
     *  restore the heap
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k/2, k)){
            exch(k, k/2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n){
            int j = 2 * k;
            if (j < n && less(j, j+1))
                j++;
            if (!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j){
        if (comparator == null){
            return ((Comparable<Key>) keys[i]).compareTo(keys[j]) < 0;
        } else {
            return comparator.compare(keys[i], keys[j]) < 0;
        }
    }

    private void exch(int i, int j) {
        Key swap = keys[i];
        keys[i] = keys[j];
        keys[j] = swap;
    }

    @Override
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }


    private class HeapIterator implements Iterator<Key>{
        private MaxPriorityQueue<Key> copy;

        public HeapIterator(){
            if (comparator == null){
                copy = new MaxPriorityQueue<>(size());
            } else {
                copy = new MaxPriorityQueue<>(size(), comparator);
            }
            for (int i = 1; i <= n; i++){
                copy.insert(keys[i]);
            }
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Key next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            return copy.delMax();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaxPriorityQueue<String> pq = new MaxPriorityQueue<>();
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            if (str.equals("==")) {
                break;
            }
            pq.insert(str);
        }

        Iterator it = pq.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
