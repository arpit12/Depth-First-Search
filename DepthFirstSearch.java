import java.util.Queue;
import java.util.LinkedList;
import java.util.*;

class Node {

	Node parent;
	Node left;
	Node right;
	int data;
	
	public Node(int data)
	{
		this.data = data;
	}
	
	public String toString()
	{
		return ""+data;
	}
	
	
}
 
public class DepthFirstSearch {

private Node root;
	
	public void insert(int data)
		{
		root = insert(root,data);
		}
		
		public Node insert(Node node,int data)
		{
		if(node==null)
		{
			node = new Node(data);
		}
		
		else if(data < node.data)
		{
			node.left=insert(node.left,data);
			node.left.parent=node;
		}
		
		else 
		{
			node.right=insert(node.right,data);
			node.right.parent=node;
		}
		
		return node;
		
		}
 
    /** Checks if the specified value exists in the binary tree */
    public static boolean search( Node node, int value ) {
 
    	// Check if it's an empty tree.
        if( node == null ) {
            return false;
							}
 
        Stack<Node> stack = new Stack<Node>( );
        stack.push( node ); // To put an object on the top of the stack, call push()
		
		 Node nn = stack.peek( ); //  just checking . it inserts only root node, thats it
			System.out.print(" current node"+nn.data);
 
        while( ! stack.isEmpty( ) ) {
 
            Node currentNode = stack.pop( ); //  To remove and return the top element, call pop(). 
			System.out.print(" "+currentNode.data);
 
            if( currentNode.data == value ) {
                // Found the value!
                return true;
            }
 
            if( currentNode.right != null ) {
            	stack.push( currentNode.right );
            }
 
     // As we want to visit left child first,we must push this node(left) last,as this is stack last inserted will come up.
            if( currentNode.left != null ) {
                stack.push( currentNode.left );
            }
        }
 
        // Not found.
        return false;
    }
 
    /** Test Method */
    public static void main( String[ ] args ) {
 
    	// Initialize the binary search tree
    	DepthFirstSearch bst = new DepthFirstSearch( );
    	int[ ] input = new int[ ] { 5, 10, 3, 9, 7, 8 };
    	for( int i : input ) {
    		bst.insert( i );
    	}
		
		DepthFirstSearch bst2 = new DepthFirstSearch( );

		int[ ] input2 = new int[ ] { 15,6,18,3,7,17,20,2,4,13,9 };
		
		for(int j:input2)
		{
			bst2.insert(j);
		}
		// just remember preorder format- root left right , thats it..
		/// Depth  order Traversal:/ also Pre order Traversal(both same)
		
		
    	System.out.println( "\n Is 8 in the tree? " + 
    	    ( DepthFirstSearch.search( bst.root, 8 )  ? "Yes!" : "No." ) );
 
    	System.out.println( "\n Is 42 in the tree? " + 
    	    ( DepthFirstSearch.search( bst.root, 42 )  ? "Yes!" : "No." ) );
		
		/// 2 treee.....
    	System.out.println( "\n Is 13 in the tree? " + 
    	    ( DepthFirstSearch.search( bst2.root, 13 )  ? "Yes!" : "No." ) );
			
    	System.out.println( "\n Is 13 in the tree? " + 
    	    ( DepthFirstSearch.search( bst2.root, 20 )  ? "Yes!" : "No." ) );
			
    	System.out.println( "\n Is 13 in the tree? " + 
    	    ( DepthFirstSearch.search( bst2.root, 9 )  ? "Yes!" : "No." ) );
		
 
    }
}