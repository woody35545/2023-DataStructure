package DS_230324_SLIST.study;


public interface List<E> {
    /* 리스트에서 특정 값을 가진 노드의 위치를 찾는다 */
    int search(E target);

    /* 리스트의 가장 앞부분(head 방향)에 값을 추가한다. */
    void insertFront(E newItem);

    void insertBefore(E newItem, Node target);

    /* 리스트의 특정 노드 뒤에 새로운 노드를 추가한다. */
    void insertAfter(E newItem, Node target);

    /* 리스트의 맨 앞 노드를 삭제한다. */
    void deleteFront();

    void deleteBefore(Node target);
    void deleteAfter(Node target);

    /* 리스트에서 가장 마지막 부분(head의 반대방향)을 삭제한다. */
    void deleteLast();



}
