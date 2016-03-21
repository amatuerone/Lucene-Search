
public class linkedList
{
    protected Node head ;
    public int size ;
 
    
    public linkedList()
    {
        head = null;
        size = 0;
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public int getSize()
    {
        return size;
    }
    public Node getHead()
    {
        return head;
    }
    
    public void insertAtEnd(int val)
    {
        Node nptr = new Node(val,null);    
        size++ ;    
        if(head == null) 
        {
            head = nptr;
        }
        else 
        {
            head.setLink(nptr);
            head = nptr;
        }
    }
    
    public void insertNode(Node node)
    {
        size++ ;    
        Node temp;
        if(head == null) 
        {
            head = node;
        }
        else 
        {
        	temp = head;
        	while(temp.getLink() != null)
        	{
        		temp = temp.getLink();
        	}
            temp.setLink(node);
        }
    }
    
    public void insertAtPos(int val, int pos)
    {
        Node nptr = new Node(val, null);                
        Node ptr = head;
        pos = pos - 1 ;
        for (int i = 1; i < size; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getLink() ;
                ptr.setLink(nptr);
                nptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size++ ;
    }
    
    public void printList()
    {
    	int i = 0;
    	int val;
    	Node temp;
    	temp = head;
    	for(i = 0; i< size; i++)
    	{
    		val = temp.getData();
    		temp = temp.getLink();
    		System.out.println(i + " element: " + val);
    	}
    }
}