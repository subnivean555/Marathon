package algoAndStructure.arr;

/**
 *
 * @param <Element>
 */
public class LoopQueue<Element> {

    private Element[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity){
        data = (Element[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    public boolean isEmpty(){
        return front == tail;
    }

    public int getSize(){
        return size;
    }

    public void enqueue(Element element){
        if ((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = element;
        tail = (tail + 1) % data.length;
        size++;
    }

    public Element dequeue(){
        if (isEmpty())
            throw new IllegalArgumentException("canont dequeue from an empty queue");

        Element ret = data[front];
        data[front] = null;
        front = (front + 1) & data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    public Element getFront(){
        if (isEmpty())
            throw new IllegalArgumentException("canont getFront from an empty queue");
        return data[front];
    }

    private void resize(int newLen) {
        Element[] newData = (Element[]) new Object[newLen + 1];
        for (int i = 0; i < size; i++){
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("loopqueue : front [");
        for (int i = front; i != tail; i = (i + 1) % data.length){
            res.append(data[i]);
            if ((i + 1) % data.length != tail){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

}
