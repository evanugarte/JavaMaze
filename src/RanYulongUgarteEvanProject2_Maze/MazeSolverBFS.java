package RanYulongUgarteEvanProject2_Maze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Solve Maze by BFS
 * 
 * @author Yulong and Evan
 *
 * @param <E>
 */
public class MazeSolverBFS<E> {
	// 2D array of cells
	private Node<E>[][] nodeGraph;

	// Size of the Maze
	private int size;

	/**
	 * Construct a MazeSolver
	 * 
	 * @param nodeGraph
	 *            2D array of nodes structure is Maze
	 * @param size
	 *            dimension of the Maze
	 */
	public MazeSolverBFS(Node<E>[][] nodeGraph, int size) {
		this.nodeGraph = nodeGraph;
		this.size = size;

	}

	/**
	 * Solve Maze by DFS
	 * 
	 */
	public void SolveMazeBFS() {

		// Starting node always set to first cell
		Node<E> starting = nodeGraph[1][1];

		// Beginning cell has no parent
		starting.setParent(null);

		// Empty Queue for DFS
		Queue<Node<E>> q = new LinkedList<Node<E>>();

		// Add first cell to the Queue
		q.add(starting);

		// Set last cell be the path of solution
		nodeGraph[size][size].setIsPath();

		// Reach the last cell or exit of the maze
		boolean findLast = false;

		// Solution Steps
		int steps = 0;

		// Initialize the starting node as step 0
		starting.setSteps(steps);

		// DFS Looping when Queue is not empty and not yet find the exist cell
		while (!q.isEmpty() && !findLast) {

			// Pop one cell from the Queue and set to U
			Node<E> u = q.poll();

			// For every neighbors of cell u
			for (int i = 0; i < getEdges(u).size(); i++) {

				// Get one neighbors of u and assign it to the Node v
				Node<E> v = getEdges(u).get(i);

				// If this cell have not visited
				if (v.getColor().equals("WHITE")) {

					// Change color to Grey
					v.setColor("GREY");

					// Increment steps
					steps++;

					// Set parent of v to u
					v.setParent(u);

					// Set steps
					v.setSteps(steps);

					/// Add v to the Queue
					q.add(v);
				}

				// If reach the exist cell, terminate the DFS
				if (v.getXCor() == size && v.getYCor() == size) {
					findLast = true;
				}
			}

			// Set u to color black; U have full explored
			u.setColor("BLACK");

		}

		// Reaches the beginning cell
		boolean end = false;

		// Starting from the exist cell
		Node<E> traverse = nodeGraph[size][size];

		// Traverse from the exit cell, finding its parent and set them as solution path
		while (!end) {

			// Set the parent of the traverse cell to IsPath
			traverse.getParent().setIsPath();

			// If not reach the beginning cell
			if (!(traverse.getParent().getXCor() == 1 && traverse.getParent().getYCor() == 1)) {
				// If the parent of the current cell is null
				if (traverse.getParent() == null) {

					// Reach the beginning cell
					end = true;
				} else {

					// Change the traverse cell to its parent and continue traversing
					traverse = traverse.getParent();
				}
			}
			// Reach the beginning cell
			else {

				// Terminate the loop
				end = true;
			}
		}

	}


	/**
	 * Get all neighbors that have all walls up or get Node that have edges connect to n
	 * @param n A cell of the Maze
	 * @return An array list contains neighbors that have edges connect to the cell
	 */
	public ArrayList<Node<E>> getEdges(Node<E> n) {

		// Array list contains all neighbors connect by an edges
		ArrayList<Node<E>> l = new ArrayList<Node<E>>();

		// Hash map contains all neighbors connect by an edges
		HashMap<Integer, Node<E>> edges = n.getEdges();

		
		// If the hash map contains a South edges, add it to the array list
		if (edges.containsKey(2)) {
			l.add(edges.get(2));
		}
		
		// If the hash map contains a East edges, add it to the array list
		if (edges.containsKey(3)) {
			l.add(edges.get(3));
			
		// If the hash map contains a North edges, add it to the array list	
		}
		if (edges.containsKey(1)) {
			l.add(edges.get(1));
		}
		
		// If the hash map contains a West edges, add it to the array list
		if (edges.containsKey(4)) {
			l.add(edges.get(4));
		}

		
		return l;
	}

	/**
	 * Print Solution of the Maze with #
	 */
	public void printSolution() {
		String space = "   "; // one space
		
		// One tab for the spacing of the Maze
		String tabe = "	";
		
		
		// Independently print the beginning cell of the Maze
		System.out.print("+");
		System.out.print(space + " ");
		System.out.print(tabe);
		
		// For every cell, except the first beginning, print a "+  -  "
		for (int i = 1; i < size; i++) {
			System.out.print("+");
			System.out.print(space + "-");
			System.out.print(tabe);
		}
		
		// Print the end "+" for first line
		System.out.print("+");
		
		// Start a new line
		System.out.println();

		// For every horizontal cell
		for (int j = 1; j <= size; j++) {
			
			//Each row each with "|"
			System.out.print("|");
			
			// For every horizontal cell
			for (int k = 1; k <= size; k++) {
				System.out.print(space);

				// Middle char and if a cell is Path of solving Maze
				if (nodeGraph[j][k].isPath()) {
					
					// Print "#" to visualize the Path
					System.out.print("#");
				} else {
					
					// If the cell is not part of the solution Path, print empty space
					System.out.print(" ");
				}
				
				//Space indent
				System.out.print(space);
				
				// If the cell has a east edges, print "#" for visualize the Path
				if (nodeGraph[j][k].hasEastEdges() && nodeGraph[j][k].isPath()) {
					System.out.print("#");

				} 
				// If the cell has not east edges or has wall on the east side, print "|"
				else {
					System.out.print("|");
				}

			}
			
			//Start a new Line
			System.out.println();
			System.out.print("+");
			
			// For every horizontal edges looks like "+ - +"
			for (int p = 1; p <= size; p++) {
				
				//Space indent
				System.out.print(space);
				
				// If the cell contains a south edges or has no walls on the South
				if (nodeGraph[j][p].hasSouthEdges() && nodeGraph[j][p].isPath()) {
					
					// Print "#" for visualize the Path
					System.out.print("#");

				} 
				
				// If the cell is the exist cell, leave the South side open
				else if (j == size && p == size) {
					System.out.print(" ");
				}
				
				// If the cell is not hte exist cell and has wall on the South side, print wall
				else {
					System.out.print("-");
				}

				System.out.print(space);
				System.out.print("+");
			}
			System.out.println();
		}

	}

	/**
	 * Print solution of the Maze with BFS steps
	 */
	public void printSolutionWithSteps() {
		String space = "   "; // one space
		
		// One tab
		String tabe = "	"; 

		// Independently print the beginning cell of the Maze
		System.out.print("+");
		System.out.print(space + " ");
		System.out.print(tabe);
		
		// For every cell, except the first beginning, print a "+  -  "
		for (int i = 1; i < size; i++) {
			System.out.print("+");
			System.out.print(space + "-");
			System.out.print(tabe);
		}
		
		// Print the end "+" for first line
		System.out.print("+");
		
		// Start a new line
		System.out.println();

		// For every horizontal cell
		for (int j = 1; j <= size; j++) {
			
			//Each row each with "|"
			System.out.print("|");
			
			// For every horizontal cell
			for (int k = 1; k <= size; k++) {
				
				// Print one space
				System.out.print(space);

				// Middle char and if a cell has steps
				if (nodeGraph[j][k].getSteps() != -1) {
					
					// Print the steps of each cell % 10
					System.out.print(nodeGraph[j][k].getSteps() % 10);
				} 
				// If a cell contains no steps or steps is -1, print empty space
				else {
					System.out.print(" ");
				}
				
				//Space indent
				System.out.print(space);

				// If the cell has a east edges, leave an opening for the east neighboring
				if (nodeGraph[j][k].hasEastEdges()) {
					System.out.print(" ");

				} 
				
				// If the cell has no east edges, print a wall "|"
				else 
				{
					System.out.print("|");
				}

			}
			
			// Start with new line
			System.out.println();
			
			// Start with the new Line with star
			System.out.print("+");
			
			// For every horizontal edges looks like "+  -  +"
			for (int p = 1; p <= size; p++) {
				
				//Print a space
				System.out.print(space);
				
				// If the cell contains south Edges
				if (nodeGraph[j][p].hasSouthEdges()) {
					
					// Print empty space or no walls
					System.out.print(" ");
					
				} 
				
				// If the cell is exisit cell, print empty space too
				else if (j == size && p == size) {
					System.out.print(" ");
				} 
				
				// If the cell contains no south neighbors and not last cell, print wall
				else {
					System.out.print("-");
				}
				
				// Print the end " +"
				System.out.print(space);
				System.out.print("+");
			}
			System.out.println();
		}

	}
}
