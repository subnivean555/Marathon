package algoAndStructure.arr;

/**
 *  出队操作的时间复杂度为 O(n), 可以使用 LoopQueue 来提高性能
 * @param <Element>
 */
public class ArrayQueue<Element> {

    private Array<Element> array;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        array = new Array<>();
    }

    public int getSize(){
        return array.getSize();
    }

    public boolean isEmpty(){
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    public void enqueue(Element element){
        array.addLast(element);
    }

    public Element dequeue(){
        return array.removeFirst();
    }

    public Element getFront(){
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("queue : front [");
        for (int i = 0; i < array.getSize(); i++){
            res.append(array.get(i));
            if (i != array.getSize() - 1){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

}
