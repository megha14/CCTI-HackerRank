public class IsBST{

	public static class Node{
	
		Node left, right;
		int data;
		
		public Node(int data){
			this.data = data;
		}
		
		public void insert(int value){
			if(value <= data){
				if(left == null){
					left = new Node(value);
				}else {
					left.insert(value);
				}
			}else {
				if(right == null){
					right = new Node(value);
				}else {
					right.insert(value);
				}
			}
		}
		
	}
	
	public static boolean checkBST(Node root){
		return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	public static boolean isBST(Node node, int min, int max){
		if(node == null)
			return true;
		if(node.data<min || node.data>max)
			return false;
		return isBST(node.left,min,node.data-1) && isBST(node.right,node.data+1,max);
	}
	
	public static void main(String args[]){
	
		Node node = new Node(4);
		node.insert(2);
		node.insert(6);
		node.insert(1);
		node.insert(3);
		node.insert(5);
		node.insert(7);
		
		
		System.out.println(checkBST(node));
	}
	
}