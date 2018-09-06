package algoAndStructure.heap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MinPriorityQueue<Key> implements Iterable<Key> {

    private Key[] keys;
    private int len;
    private Comparator<Key> comparator;

    public MinPriorityQueue(int initCapacity){
        keys = (Key[]) new Object[initCapacity + 1];
        len = 0;
    }
    
    public MinPriorityQueue(){
        this(1);
    }
    
    public MinPriorityQueue(int initCapacity, Comparator<Key> comparator){
        this.comparator = comparator;
        keys = (Key[]) new Object[initCapacity + 1];
        len = 0;
    }
    
    public MinPriorityQueue(Comparator<Key> comparator){
        this(1, comparator);
    }
    
    public MinPriorityQueue(Key[] arr){
        len = arr.length;
        keys = (Key[]) new Object[arr.length + 1];
        for (int i = 0; i < len; i++)
            keys[i + 1] = arr[i];
        for (int k = len / 2; k >= 1; k--)
            sink(k);
    }

    public int size(){
        return len;
    }

    public boolean isEmpty(){
        return len == 0;
    }

    public Key min(){
        if (isEmpty())
            throw new NoSuchElementException("Priority queue underflow");
        return keys[1];
    }

    private void resize(int capacity){
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= len; i++) {
            temp[i] = keys[i];
        }
        keys = temp;
    }

    public void insert(Key key){
        if (len == keys.length - 1){
            resize(2 * keys.length);
        }
        keys[++len] = key;
        swim(len);
    }

    public Key delMin(){
        if (isEmpty())
            throw new NoSuchElementException("Priority queue underflow");
        Key min = keys[1];
        exch(1, len--);
        sink(1);
        keys[len + 1] = null;
        if ((len > 0) && (len == (keys.length - 1) / 4))
            resize(keys.length / 2);
        return min;
    }

    private void exch(int i, int j) {
        Key swap = keys[i];
        keys[i] = keys[j];
        keys[j] = swap;
    }

    private void sink(int k) {
        while(2 * k <= k){
            int j = 2 * k;
            if (j < len && greater(j, j+1))
                j++;
            if (!greater(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)){
            exch(k, k/2);
            k = k / 2;
        }
    }

    private boolean greater(int i, int k) {
        if (comparator == null){
            return ((Comparable<Key>) keys[i]).compareTo(keys[k]) > 0;
        } else {
            return comparator.compare(keys[i], keys[k]) > 0;
        }
    }

    @Override
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key>{
        private MinPriorityQueue<Key> copy;

        public HeapIterator(){
            if (comparator == null){
                copy = new MinPriorityQueue<>(size());
            } else {
                copy = new MinPriorityQueue<>(size(), comparator);
            }
            for (int i = 1; i <= len; i++){
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
            return copy.delMin();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MinPriorityQueue<String> minPQ = new MinPriorityQueue<>();
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            if (str.equals("==")) {
                break;
            }
            minPQ.insert(str);
        }

        Iterator it = minPQ.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
