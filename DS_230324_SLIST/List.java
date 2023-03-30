package DS_230324_SLIST;

public interface List<E> {
    int search(E target);
    void insertFront(E newItem);
    void insertAfter(E newItem, Node p);
    void deleteFront();
    void deleteAfter(Node p);
}
