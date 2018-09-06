package algoAndStructure.linkedList;

public class LinkedListStack<Element> {

    private MyLinkedList<Element> list;

    public LinkedListStack(){
        list = new MyLinkedList<>();
    }

    public int getSize(){
        return list.getSize();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(Element element){
        list.addFirst(element);
    }

    public Element pop(){
        return list.removeFirst();
    }

    public Element peek(){
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack : top ");
        res.append(list);
        return res.toString();
    }


    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
