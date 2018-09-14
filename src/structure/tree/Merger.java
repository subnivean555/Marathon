package structure.tree;

public interface Merger<Element> {
    Element merge(Element a, Element b);
}
