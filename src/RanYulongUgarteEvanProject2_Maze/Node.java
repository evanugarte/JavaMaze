package RanYulongUgarteEvanProject2_Maze;

import java.util.*;

public class Node<E>
{
	private int data;
	private int xCor;
	private int yCor;
	//North = 1, South = 2, East = 3, West = 4
	HashMap<Integer, Node<E>> edges;
	protected String color;
	private boolean isPath;
	private int steps;
	
	public Node(int xCor, int yCor, int data)
	{
		this.steps=-1;
		this.isPath=false;
		this.color="White";
		this.xCor= xCor;
		this.yCor=yCor;
		this.data = data;
		edges = new HashMap<Integer, Node<E>>();
	}
	
	public boolean addEdge(Node<E> n, int key) {
		if(edges.get(key) != null)
		{
			return false;
		}
		edges.put(key, n);
		return true;
	}
	
	public boolean hasAllWalls()
	{
		if(this.edges.isEmpty())
		{
			return true;
		}
		return false;
	}
	
	public ArrayList<Node<E>> getAllNeighborsWithWallIntact(){
		
		
		return null;
	}

	public boolean hasNorthEdges()
	{
		if(this.getEdges().containsKey(1))
		{
			return true;
		}
		return false;
	}
	public boolean hasSouthEdges()
	{
		if(this.getEdges().containsKey(2))
		{
			return true;
		}
		return false;
	}
	
	public boolean hasWestEdges()
	{
		if(this.getEdges().containsKey(4))
		{
			return true;
		}
		return false;
	}
	public boolean hasEastEdges()
	{
		if(this.getEdges().containsKey(3))
		{
			return true;
		}
		return false;
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
	
	public HashMap<Integer, Node<E>> getEdges()
	{
		return edges;
	}
	
	public void setColor(String c)
	{
		this.color=c;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public int getSteps()
	{
		return steps;
	}
	
	public void setSteps(int steps)
	{
		this.steps=steps;
	}
}

