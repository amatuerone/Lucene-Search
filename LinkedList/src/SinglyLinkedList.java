public class SinglyLinkedList
{    
    public static void main(String[] args)
    {   
        linkedList list1 = new linkedList();
        linkedList list2 = new linkedList();
        Intersection inter = new Intersection();
        System.out.println("Singly Linked List Test\n");          
        
            System.out.println("\nSingly Linked List Operations\n");
            
            System.out.println("Populating Linked list 1.");
            Node n1 = new Node(1, null);
            Node n2 = new Node(2, null);
            Node n3 = new Node(3, null);
            Node n4 = new Node(4, null);
            Node n5 = new Node(5, null);
            Node n6 = new Node(6, null);
            Node n7 = new Node(7, null);
            Node n8 = new Node(8, null);
            
            list1.insertNode(n1);
            list1.insertNode(n2);
            list1.insertNode(n3);
            list1.insertNode(n4);
            list1.insertNode(n5);
            list1.insertNode(n6);
            
            list2.insertNode(n7);
            list2.insertNode(n8);
            list2.insertNode(n5);
            list2.insertNode(n6);
            list1.printList();
            list2.printList();
            int index = inter.findIntersection(list1, list2);
            if(index == 0)
            {
            	System.out.println("the linked lists do not intersect");
            }else
            {
            	System.out.println("the linked lists intersect at index " + index + " of larger linked list.");
            }
    }
}

class Intersection
{    
	public int findIntersection(linkedList headA, linkedList headB)
	{
		int size1 = headA.getSize();
		int size2 = headB.getSize();
		int diff = size1 - size2;
		int n = size1;
		int i = 0;
		Node largerNode = headA.getHead();
		Node smallerNode = headB.getHead();
		if(diff < 0)
		{
			 largerNode = headB.getHead();
			 smallerNode = headA.getHead();
			 n = size2;
		}
		int difference = diff;
		while(difference != 0)
		{
			largerNode = largerNode.getLink();
			difference--;
		}
		for(i=0; i<n;i++)
		{
			if(largerNode == smallerNode)
			{
				return i + diff + 1;
			}
			largerNode = largerNode.getLink();
			smallerNode = smallerNode.getLink();
		}
		return 0;
	}
}