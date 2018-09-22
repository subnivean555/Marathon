package structure.map;

import structure.tree.AVLTree;

public class AVLMap<Key extends Comparable<Key>,Value>{

    private AVLTree<Key, Value> avl;

    public AVLMap(){
        avl = new AVLTree<>();
    }

    public int getSize(){
        return avl.getSize();
    }

    public void add(Key key, Value value){
        avl.add(key, value);
    }

    public boolean contains(Key key){
        return avl.contains(key);
    }

    public Value get(Key key){
        return avl.get(key);
    }

    public void set(Key key, Value value){
        avl.set(key, value);
    }

    public Value remove(Key key){
        return avl.remove(key);
    }

}
