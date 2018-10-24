import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Maze<E>{
    
	Node<E>[][] nodeGraph;
    int nodeCount;

    public Maze(int size){
    	nodeCount = 1;
        nodeGraph = new Node[size + 1][size + 1];
        for(int i = 1; i < nodeGraph.length; i++){
            for(int j = 1; j < nodeGraph.length; j++){
                nodeGraph[i][j] = new Node<E>(i, j, nodeCount);
                System.out.println(nodeCount + " " + i + " " + j);
                nodeCount++;
            }          
        }
    }
    
    public void print() {
    	for(int i = 1; i <  nodeGraph.length; i++){
    		for(int k = 1; k <  nodeGraph.length; k++)
    			System.out.print("+   -\t");
    		System.out.print("+");
    		System.out.println();
            for(int j = 1; j < nodeGraph.length; j++)
                System.out.print("|   " + nodeGraph[i][j].getData() + "\t" );
    		System.out.print("|");
            System.out.println();
    	}
		for(int k = 1; k <  nodeGraph.length; k++)
			System.out.print("+   -\t");
		System.out.println("+");
    }
    
    public boolean addEdge(int y1, int x1, int y2, int x2) {
    	int key = 0;
    	//get both nodes from 2D array
    	if(x2 == x1 + 1 && y2 == y1) {
			//To the right (east), key value of 3
			key = 3;
		}else if(x2 == x1 - 1 && y2 == y1) {
			//To the left (west), key value of 4
			key = 4;
		}else if(y2 == y1 + 1 && x2 == x1) {
			//Above (north), key value of 1
			key = 1;
		}else if(y2 == y1 - 1 && x2 == x1) {
			//Below (south), key value of 2
			key = 2;
		}else{
			//Coordinates are invalid
			return false;
		}
    	
    	//node1.addEdge(node2);
    	return (nodeGraph[y1][x1].addEdge(nodeGraph[x2][y2], key) && nodeGraph[x2][y2].addEdge(nodeGraph[x1][y1], key));
    }
    
    
    public void DFS() {
    	Stack<Node<E>> cellStack = new Stack<Node<E>>();
    	int totalCells = nodeCount;
    	Node<E> currentCell = nodeGraph[4][4];
    	int visitedCells = 1;
    	ArrayList<Node<E>> withWallIntact= new ArrayList<>();
    	//withWallIntact = node.getAllNeighbors
    	ArrayList<Node<E>> neighbors = this.getAllNeighbors(currentCell);
    	System.out.println();
    	for(int i = 0; i < neighbors.size(); i++) {
    		if(!neighbors.get(i).hasAllWalls())
    			neighbors.remove(neighbors.get(i));
    	}
    	
    	for(Node<E> n : neighbors) {
    		System.out.print(n.getData() + " ");
    	}
//    		while(visitedCells < nodeCount)
//    		{
//
//    		}
    		//list = find all neighbors with current walls intact
    		//if(list isnt empty){
    		//   add edge between an element in the list and the current cell
    		//   add the currentCell to stack
    		//   make the randomly chosen cell currentCell
    		//   visitedCells++;
    		//}else{
    		//   currentCell = stack.pop();
    		//}
    		
    		
    		//nodeGraph[(currentCell.getXCor() + 1)][currentCell.getYCor()].getData();
    }
    
    private ArrayList<Node<E>> getAllNeighbors(Node<E> currNode){
    	ArrayList<Node<E>> neighbors = new ArrayList<Node<E>>();
    	int currX = currNode.getXCor();
    	int currY = currNode.getYCor();

    	if(currX - 1 != 0) {
    		neighbors.add(nodeGraph[currX - 1][currY]);
    	}
    	if(currX + 1 != nodeGraph.length) {
    		neighbors.add(nodeGraph[currX + 1][currY]);
    	}
    	if(currY - 1 != 0) {
    		neighbors.add(nodeGraph[currX][currY - 1]);
    	}
    	if(currY + 1 != nodeGraph.length) {
    		neighbors.add(nodeGraph[currX][currY + 1]);
    	}
    	
    	
    	return neighbors;
    }
    
    public int getNodeCount() {
    	return this.nodeCount;
    }
}