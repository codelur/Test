package runexercises;

public class LinkedList {
	static Node head;
	 
    public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		LinkedList.head = head;
	}

	static class Node {
 
        int data;
        Node next;
 
        public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		Node(int d)
        {
            data = d;
            next = null;
        }
    }
 
    /* Function to remove duplicates from an
       unsorted linked list */
   
 
    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
 
    public static void main(String[] args)
    {
        LinkedList firstList = new LinkedList();
        firstList.setHead(new Node(1)); 
        firstList.getHead().setNext(new Node(2));
        firstList.getHead().getNext().setNext(new Node(3)); 
        LinkedList secondList = new LinkedList();
        secondList.head = new Node(4);
        secondList.head.next = new Node(5);
        secondList.head.next.next = new Node(6);
        secondList.head.next.next.next = new Node(7);
 
        

    }
}
