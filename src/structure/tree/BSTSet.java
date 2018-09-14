package structure.tree;

public class BSTSet<Element extends Comparable<Element>> {

    private BST<Element> bst;

    public BSTSet(){
        bst = new BST<>();
    }

    public int  getSize() {
        return bst.getSize();
    }

    public boolean isEmpty(){
        return bst.isEmpty();
    }

    public boolean contains(Element element){
        return bst.contains(element);
    }

    public void add(Element element){
        bst.add(element);
    }

    public void remove(Element element){
        bst.remove(element);
    }
}
