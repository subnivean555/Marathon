package structure.arr;

/**
 *  添加操作    O(n)
 *  删除操作    O(n)
 *
 *  复杂度震荡, 当数组的 size 处于某些特殊值时, 可能会反复的 resize, 因此可以使用更为 lazy resize 方式
 * @param <Element>
 */
public class Array<Element> {

    private Element[] data;
    private int size;

    public Array(int capacity){
        data = (Element[]) new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast(Element ele){
        add(size, ele);
    }

    public boolean contains(Element ele){
        for (int i = 0; i < size; i++){
            if (data[i].equals(ele))
                return true;
        }
        return false;
    }

    public int find(Element ele){
        for (int i = 0; i < size; i++){
            if (data[i] == ele)
                return i;
        }
        return -1;
    }

    public void addFirst(Element ele) {
        add(0, ele);
    }

    public void add(int index, Element ele){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed , index out of bounds");
        if (size == data.length){
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = ele;
        size++;
    }

    private void resize(int newCapacity) {
        Element[] dist = (Element[]) new Object[newCapacity];

        for (int i = 0; i < size; i++){
            dist[i] = data[i];
        }

        data = dist;
    }

    public Element removeFirst(){
        return remove(0);
    }

    public Element removeLast(){
        return remove(size - 1);
    }

    /**
     *  loitering objects
     * @param index
     * @return
     */
    public Element remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("remove failed, index is illegal");
        }
        Element ret = data[index];

        for (int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        /*
        if (size == data.length / 2)
            resize(data.length / 2);
         */

        if ((size == data.length / 4) && (data.length / 2 != 0))
            resize(data.length / 2);

        return ret;
    }

    public void removeElement(Element ele){
        int index = find(ele);
        if (index != -1){
            remove(index);
        }
    }

    public Element get(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("get failed , index out of bounds");
        else
            return data[index];
    }

    public Element getLast(){
        return get(size - 1);
    }

    public Element getFirst(){
        return get(0);
    }

    public void swap(int i , int j){
        if (i < 0 || i >= size || j < 0 || j >= size){
            throw new IllegalArgumentException("index is invalid");
        }
        Element temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array : size = %d , capacity = %d \n",size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++){
            res.append(data[i]);
            if (i != size -1){
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

}
