public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        System.out.println(myLinkedList.get(1));              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        System.out.println(myLinkedList.get(1));              // return 3
    }

    static class MyLinkedList {

        private static final class ListNode {
            int value;
            ListNode next;

            ListNode() { }

            ListNode(int value) {
                this.value = value;
            }

            @Override
            public String toString() {
                if (next == null) {
                    return "ListNode{" +
                            "value=" + value +
                            '}';
                }
                return "ListNode{" +
                        "value=" + value +
                        ", next=" + next +
                        '}';
            }
        }

        private ListNode head;
        private ListNode tail;
        private int size = 0;

        public MyLinkedList() {
        }

        @Override
        public String toString() {
            return "MyLinkedList{" +
                    "head=" + head +
                    ", size=" + size +
                    '}';
        }

        public int get(int index) {
            ListNode current = head;
            int i = 0;
            for ( ; current != null && i < index ; i++) {
                current = current.next;
            }
            return current != null ? current.value: -1;
        }

        public void addAtHead(int val) {
            ListNode newHead = new ListNode(val);
            newHead.next = head;
            this.head = newHead;
            if (size == 0) {
                tail = head;
            }
            this.size ++;
        }

        public void addAtTail(int val) {
            size++;
            if (tail == null) {
                head = new ListNode(val);
                tail = head;
                return;
            }
            tail.next = new ListNode(val);
            tail = tail.next;
        }

        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
                return;
            } else if (index == size) {
                addAtTail(val);
                return;
            } else if (index < 0 || index > size) {
                return;
            }
            ListNode current = head;
            for (int i = 0 ; i < index - 1 ; i++) {
                current = current.next;
            }
            ListNode temp = current.next;
            current.next = new ListNode(val);
            current.next.next = temp;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            if (index == 0) {
                this.head = this.head.next;
            } else {
                ListNode current = head;
                for (int i = 0 ; i < index - 1 ; i++) {
                    current = current.next;
                }
                current.next = current.next == null ? null : current.next.next;
            }
            size--;
        }
    }
}
