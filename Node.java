

import java.util.*;

public class Node<E>
{
	private int data;
	private int xCor;
	private int yCor;
	//North = 1, South = 2, East = 3, West = 4
	HashMap<Integer, Node<E>> edges;
	
	public Node(int xCor, int yCor, int data)
	{
		this.xCor= xCor;
		this.yCor=yCor;
		this.data = data;
		edges = new HashMap<Integer, Node<E>>();
	}
	
	public boolean addEdge(Node<E> n, int key) {
		if(edges.get(key) != null)
			return false;
		
		edges.put(key, n);
		return true;
	}
	
	public ArrayList<Node<E>> getAllNeighborsWithWallIntact(){
		
		
		return null;
	}

	public boolean hasAllWalls() {
		return edges.isEmpty();
	}
	
	public int getData()
	{
		return data;
	}
	
	public int getYCor() {
		return yCor;
	}
	
	public int getXCor() {
		return xCor;
	}
}

