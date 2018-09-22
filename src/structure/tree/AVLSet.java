package structure.tree;

public class AVLSet<Element extends Comparable<Element>> {

    private AVLTree<Element, Object> avl;

    public AVLSet(){
        avl = new AVLTree<>();
    }

    public int getSize(){
        return avl.getSize();
    }

    public boolean isEmpty(){
        return avl.isEmpty();
    }

    public void add(Element element){
        avl.add(element, null);
    }

    public boolean contains(Element element){
        return avl.contains(element);
    }

    public void remove(Element element){
        avl.remove(element);
    }
}
