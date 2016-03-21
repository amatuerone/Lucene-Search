
public class Node
{
    protected int data;
    protected Node link;
 
    public Node()
    {
        link = null;
        data = 0;
    }    
    
    public Node(int d, Node n)
    {
        data = d;
        link = n;
    }    
    
    public void setLink(Node n)
    {
        link = n;
    }    
    
    public void setData(int d)
    {
        data = d;
    }    
    
    public Node getLink()
    {
        return link;
    }    
    
    public int getData()
    {
        return data;
    }
    public int getSize()
    {
    	int n =0;
    	Node temp = link;
    	
    	while(temp!=null)
    	{
    		temp = link.getLink();
    		n++;
    	}
    	return n;
    }
}