package collectionsTask8ExerciseDoublyLinkedList;

public class DoublyLinkedListImpl {

    public void node() {
    }

    public void node(Object element) {
    }

    private class Node {
        Object data;
        Node prev, next;

        public Node(Object data) {
            this.data = data;

        }

        private Node head, tail;

        public boolean addFirst(Object element) {
            if (element == null) throw new NullPointerException();
            Node node = new Node(element);
            if (head == null) head = tail = node;
            else {
                node.next = head;
                head.prev = node;
                head = node;
            }
            return true;
        }

        public boolean addLast(Object element) {
            if (element == null) throw new NullPointerException();
            Node node = new Node(element);
            if (tail == null) head = tail = node;
            else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            return true;
        }

        public boolean delete(int index) {
            Node node = getNode(index);
            if (node == head && node == tail) head = tail = null;
            else if (node == head) {
                head = head.next;
                head.prev = null;
            } else if (node == tail) {
                tail = tail.prev;
                tail.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            return true;
        }

        public Object remove(Object element) {
            if (element == null) throw new NullPointerException();
            Node curr = head;
            while (curr != tail) {
                if (curr.data.equals(element)) {
                    Object data = curr.data;
                    if (curr == head && curr == tail) head = tail = null;
                    else if (curr == head) {
                        head = head.next;
                        head.prev = null;
                    } else if (curr == tail) {
                        tail = tail.prev;
                        tail.next = null;
                    } else {
                        curr.prev.next = curr.next;
                        curr.next.prev = curr.prev;
                    }
                    return data;
                }
                curr = curr.next;
            }
            return null;
        }

        public boolean set(int index, Object element) {
            if (element == null) throw new NullPointerException();
            Node node = getNode(index);
            node.data = element;
            return true;
        }

        public int size() {
            int count = 0;
            Node curr = head;
            while (curr != tail) {
                count++;
                curr = curr.next;
            }
                return count;
            }


            public Object[] toArray(){
                Object[] arr = new Object[size()];
                Node curr =head;
                int i = 0;
                while (curr != null) {
                    arr[i++] = curr.data;
                    curr = curr.next;

                }
                return arr;
            }
            public String toString(){
            StringBuilder sb = new StringBuilder();
            Node curr = head;
            while (curr != null){
                sb.append(curr.data.toString());
                if(curr.next != null)
                    sb.append(" ");
                curr = curr.next;
            }
            return sb.toString();

        }

        private Node getNode(int index){
            if(index < 0) throw new IndexOutOfBoundsException();
            Node curr = head;
            for(int i = 0; i < index; i++){
                if(curr == null) throw new IndexOutOfBoundsException();
                curr = curr.next;
            }
            if(curr == null) throw new IndexOutOfBoundsException();
            return curr;
        }

    }
}