public class Node<T> {
    T data;
    Node<T> next;
    Node<T> child;
    Node<T> grandChild;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.child = null;
        this.grandChild = null;
    }
}