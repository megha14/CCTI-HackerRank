import java.io.*;
import java.util.*;

public class BFSSolution {

     
    
    public static class Graph {
        
    	//Total number of nodes in a graph
        private int size;
        
        //HashMap with Integer as Key and Node as value to store nodes of the graph and also the Adjacency List
        private static HashMap<Integer,Node> graph = new HashMap<Integer,Node>();
        
        //Weight of each edge in a graph
        private int EDGE_DISTANCE = 6;
        
        //Node class to store a node
        private static class Node{
        	
        	//Integer id of the node
            private int id;
            
            //Linkedlist to store adjacent nodes
            private LinkedList<Node> adjacent;
            
            //Constructor
            public Node(int id){
                this.id = id;
                adjacent = new LinkedList<Node>();
            }
            
            //Getter method of id
            public int getID(){
                return id;
            }
            
            //To print Node 
            public String toString(){
            	String msg = id + " : ";
            	for(Node node: adjacent)
            		msg = msg + node.id + " ";
            	return msg;
            }
        }
        
        //Initialize HasMap with all the nodes 
        public void initializeHashMap(){
        	for(int i = 0;i<size;i++){
        		graph.put(i,new Node(i));
        	}
        }
        
        //print graph
        public void printGraph(){
        	//Hashset to store all the keys
        	HashSet<Integer> keys = new HashSet<Integer>(graph.keySet());
        	//Loop to access keys and print Node stored in that key
        	for(int key: keys)
        		System.out.println(graph.get(key).toString());
        }
        
        //Graph Constructor
        public Graph(int size) {
            this.size = size;
            
        }

        //To get Node stored at key id
        private static Node getNode(int id){
		    if(graph.containsKey(id))
		    	return graph.get(id);
            return null;
	   }
	   
	   //To add an edge inside a graph
        public void addEdge(int first, int second) {
        	if(first>=0 && first<size && second>=0 && second<size){
        		Node s = getNode(first);
        		Node d = getNode(second);
        		
        		//adding d to s'adjacency list and s to d's adjacency list as it is an undirected graph.
        		s.adjacent.add(d);
        		d.adjacent.add(s);
        	}
        }
        
        //Find the shortest path to all nodes from one node
        public HashMap<Integer,Integer> shortestReach(int startId) { // 0 indexed
            
        	//HashMap to store distances
            HashMap<Integer,Integer> distances = new HashMap<Integer,Integer>();
            
            //Initialize HashMap with -1 for all nodes
            for(int n=0; n<size; n++){
	   	   	   distances.put(n,-1);
	   	    }
            
	   	    //Check if startId is within 0 and size
            if(startId >= 0 && startId<size){
            	
            	//To store the children of nodes visited
                LinkedList<Node> nextToVisit = new LinkedList<Node>();
                
                //adding node of startId in the linkedlist
		        nextToVisit.add(getNode(startId));	
		        
		        //Giving distance 0 as it is the start node
		        distances.put(startId,0);
		        
		        //traversing the linkedlist to add it's child nodes and update distances
                while(!nextToVisit.isEmpty()){
                	
                	//Removing the first node from the linkedlist
                    Node node = nextToVisit.remove();
                    
                    //Looping through all the children of node 
                    for(Node child: node.adjacent){ 
                    	
                    	//Checking distance of child
                        if(distances.get(child.getID()) == -1){ 
                        	
                            int newDistance = distances.get(node.getID()) + EDGE_DISTANCE;
                            
                            //updating distance in the HashMap
                            distances.put(child.getID(),newDistance);                           
                          
                            nextToVisit.add(child);
                        }
                    }				
		      }
        }
		return distances;
        }
    }
    
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        int startId;
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            int n = scanner.nextInt();
            Graph graph = new Graph(n);
            graph.initializeHashMap();
            int m = scanner.nextInt();
            
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
                
            }
            
            //graph.printGraph();
           	 
           	startId = scanner.nextInt() - 1;
           
        	
            HashMap<Integer,Integer> distances = graph.shortestReach(startId);
            HashSet<Integer> keys = new HashSet<Integer>(distances.keySet());
            
            for (int key: keys) {
                if (key != startId) 
                    System.out.print(distances.get(key) + " ");   
            } 
            
            
            System.out.println();      
        
        }
        scanner.close();
        
    }
}
