/**
 * HackerRank Prims subTree Sum Problem
 * Graph is implemented as Adjacency List
 * 
 * there is arraylist of heads of user defined linked list
 */

import java.util.*;

/**
 * node for the linked list
 *
 */
class GraphNode{
	int weight;
	int neighbour;
	GraphNode next;
	
	GraphNode(int weight, int neighbour){
		this.weight = weight;
		this.neighbour = neighbour;
		this.next = null;
	}
}

/**
 * 
 * Class for the graph
 * 
 * @author Vikalp
 *
 */
class Graph{
	ArrayList<GraphNode> al;
	GraphNode temp;
	
	// to keep the track of visited nodes
	boolean visited[];
	
	Graph(int size){
		// initializes arraylist of given size with null at each index
		al = new ArrayList<GraphNode>(Collections.nCopies(size, null));
		visited = new boolean[size];
	}
	
	// function to insert an edge in graph
	void insert(int x, int y, int weight){
		temp = al.get(x-1);
		if(temp == null){
			al.set(x-1, new GraphNode(weight, y-1));
			return;
		}
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next = new GraphNode(weight, y-1);
		
		
	}
	
	// function to calculate and return sum of MST
	long getPrimsSum(int start){
		long sum = 0;
		int visitedCount = al.size();
		
		//set start vertex as visited and decrease visited count by 1
		visited[start-1] = true;
        visitedCount--;
		
        //while all the nodes are not visited find closest unvisited neighbor and add to MST
        while(visitedCount>0){
        	sum += getClosest();
        	
        	visitedCount--;
        }
        
        return sum;
	}
	
	//fucntion to get appropriate next edge for the MST
	int getClosest(){
		// greater than the possible max dist
		int min = 1000000;
		int closestVertex = 0;

		for(int i=0; i<al.size(); i++){
			//if this vertex is not visited continue
			//we have to look only the neighbors of visited nodes
			if(visited[i] == false)
				continue;
			temp = al.get(i);
			while(temp!=null){
				// if the neighbor is not visited and it is smaller then the minimum
				// closest found till now then take that as closest
				// we have to look at only non visited neighbors
				if(visited[temp.neighbour]==false && temp.weight<min){
					min = temp.weight;
					closestVertex = temp.neighbour;
				}
				temp = temp.next;
			}
		}
		// mark the closest neighbor found as visited and return weight of edge to reach it
		visited[closestVertex] = true;
		return min;
		
	}
}

public class PrimsTreeSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // number of vertices
        int n = sc.nextInt();
        // number of edges
        int m = sc.nextInt();
        
        // create a new graph with n vertices
        Graph graph = new Graph(n);
       
        long primsSum = 0;
        // first vertex, second vertex, weight, start vertex for prims
        int x, y, weight, start;
        while(m>0){
            x = sc.nextInt();
            y = sc.nextInt();
            weight = sc.nextInt();
            
            graph.insert(x, y, weight);
            graph.insert(y, x, weight);
                      
            m--;
        }
        start = sc.nextInt();
        
        primsSum = graph.getPrimsSum(start);
        System.out.println(primsSum);
        
        sc.close();
        
    }
}