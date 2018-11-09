package RanYulongUgarteEvanProject2_Maze;

import java.util.*;

/**
 * Node class
 * @author Evan and Yulong
 *
 * @param <E>
 */
public class Node<E> {
	
	//Position of the Node
	private int data;
	
	//X coordinate of the Node
	private int xCor;
	
	//Y coordinate of the Node
	private int yCor;
	
	// HashMap contains all edges of the node with their direction as key
	// North = 1, South = 2, East = 3, West = 4
	HashMap<Integer, Node<E>> edges;
	protected String color;
	
	//Path of the solution for the Maze
	private boolean isPath;
	
	//Number of steps takes for the BFS and DFS
	private int steps;
	
	//Parent of the node
	private Node<E> parent;

	public Node(int xCor, int yCor, int data)
	{
		this.steps = -1;
		this.isPath = false;
		this.color = "WHITE";
		this.xCor = xCor;
		this.yCor = yCor;
		this.data = data;
		edges = new HashMap<Integer, Node<E>>();
	}

	/**
	 * Add edge to the Node
	 * @param n node
	 * @param key direction of the edge
	 * @return false if node already exist, true if successfully addEdge into HashMap
	 */
	public boolean addEdge(Node<E> n, int key) {
		if (edges.get(key) != null) {
			return false;
		}
		edges.put(key, n);
		return true;
	}

	/**
	 * Check Node has Edges
	 * @return true if no Edges, false otherwise
	 */
	public boolean hasAllWalls() {
		if (this.edges.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Check if node has NorthEdges
	 * @return true if has NorthEdges, false no NorthEdges
	 */
	public boolean hasNorthEdges() {
		if (this.getEdges().containsKey(1)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Check if node has SouthEdges
	 * @return true if has SouthEdges, false no SouthEdges
	 */
	public boolean hasSouthEdges() {
		if (this.getEdges().containsKey(2)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Check if node has WestEdges
	 * @return true if has WestEdges, false no WestEdges
	 */
	public boolean hasWestEdges() {
		if (this.getEdges().containsKey(4)) {
			return true;
		}
		return false;
	}

	/**
	 * Check if node has EastEdges
	 * @return true if has EastEdges, false no EastEdges
	 */
	public boolean hasEastEdges() {
		if (this.getEdges().containsKey(3)) {
			return true;
		}
		return false;
	}

	public int getData() {
		return data;
	}

	public int getYCor() {
		return yCor;
	}

	public int getXCor() {
		return xCor;
	}

	public HashMap<Integer, Node<E>> getEdges() {
		return edges;
	}

	public void setColor(String c) {
		this.color = c;
	}

	public String getColor() {
		return color;
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public Node<E> getParent() {
		return parent;
	}

	public void setParent(Node<E> p) {
		this.parent = p;
	}

	public void setIsPath() {
		this.isPath = true;
	}

	public boolean isPath() {
		return isPath;
	}


}
