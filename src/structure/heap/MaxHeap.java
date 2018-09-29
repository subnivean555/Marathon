package structure.heap;

import structure.arr.Array;

import java.util.Random;

/**
 *  如果堆的索引从 1 开始, 那么索引的计算方法如下
 *  parent(i) = i / 2
 *  left child = 2 * i
 *  right child = 2 * i + 1
 *
 *  如果堆的索引从 0 开始 , 那么索引计算方法如下
 *  parent(i) = (i - 1) /2
 *  left child = 2 * i + 1
 *  right child = 2 * i + 2
 *
 */
public class MaxHeap<Element extends Comparable<Element>> {

    private Array<Element> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    private int parent(int index){
        if (index == 0)
            throw new IllegalArgumentException("index - 0 doesn't have parent");
        return (index - 1) / 2;
    }

    private int leftChild(int index){
        return index * 2 + 1;
    }

    private int rightChild(int index){
        return index * 2 + 2;
    }

    public void add(Element element){
        data.addLast(element);
        siftUp(data.getSize() - 1);
    }

    public Element findMax(){
        if (data.isEmpty())
            throw new IllegalArgumentException("can not findMax when heap is empty");
        return data.get(0);
    }

    public Element extractMax(){
        Element ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int pos) {
        while (leftChild(pos) < data.getSize()){
            int temp = leftChild(pos);
            /**
             *  data[temp] 是 leftChild 和 rightChild 中的最大值
             */
            if (temp + 1 < data.getSize() && data.get(temp + 1).compareTo(data.get(temp)) > 0){
                temp++;
            }

            if (data.get(pos).compareTo(data.get(temp)) >= 0)
                break;

            data.swap(pos, temp);
            pos = temp;
        }
    }

    private void siftUp(int pos) {
        while (pos > 0 && data.get(parent(pos)).compareTo(data.get(pos)) < 0){
            data.swap(pos, parent(pos));
            pos = parent(pos);
        }
    }

    public static void main(String[] args) {
        int n = 100000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++){
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = maxHeap.extractMax();

        for (int i = 1; i < n; i++){
            if (arr[i - 1] < arr[i]){
                throw new IllegalArgumentException("error heap");
            }
        }
        System.out.println("MaxHeap completed");
    }
}
