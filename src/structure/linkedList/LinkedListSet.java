package structure.linkedList;

public class LinkedListSet<Element> {

    private MyLinkedList<Element> set;

    public LinkedListSet(){
        set = new MyLinkedList<>();
    }

    public int getSize(){
        return set.getSize();
    }

    public boolean isEmpty(){
        return set.isEmpty();
    }

    public boolean contains(Element element){
        return set.contains(element);
    }

    public void add(Element element){
        if (!set.contains(element)){
            set.addFirst(element);
        }
    }

    public void remove(Element element){
        set.removeElement(element);
    }
}
