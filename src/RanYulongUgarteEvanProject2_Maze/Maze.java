package RanYulongUgarteEvanProject2_Maze;

// Rewrite the print maze
// Add a stack on the DFS method
// Add nodes hadEastEdges / WestEdges
// Modified addEdgesMethod
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Maze<E> {

	Node<E>[][] nodeGraph;
	int nodeCount;
	int size;

	public Maze(int size) {
		this.size = size;
		nodeCount = 0;
		nodeGraph = new Node[size + 1][size + 1];
		for (int i = 1; i < nodeGraph.length; i++) {
			for (int j = 1; j < nodeGraph.length; j++) {
				nodeGraph[i][j] = new Node<E>(i, j, nodeCount);
				nodeCount++;
			}
		}
	}

	public void print() {
		for (int i = 1; i < nodeGraph.length; i++) {
			for (int k = 1; k < nodeGraph.length; k++) {
				System.out.print("+   ");
				System.out.print("-\t");
			}

			// NOT TOUCHING
			System.out.print("+"); // Righest line +
			System.out.println();

			for (int j = 1; j < nodeGraph.length; j++) {
				System.out.print("|   " + nodeGraph[j][i].getData() + "\t");
			}
			System.out.print("|");
			System.out.println();
		}

		// NOT TOUCHING
		for (int k = 1; k < nodeGraph.length; k++) {
			System.out.print("+   -\t");
		}
		System.out.println("+");
	}

	public void print2() {
		String space = "   "; // one space
		String tabe = "	";

		// First line does not affect by the Maze
		System.out.print("+");
		System.out.print(space + " ");
		System.out.print(tabe);
		for (int i = 1; i < size; i++) {
			System.out.print("+");
			System.out.print(space + "-");
			System.out.print(tabe);
		}
		System.out.print("+");
		System.out.println();

		//
		for (int j = 1; j <= size; j++) {
			System.out.print("|");
			for (int k = 1; k <= size; k++) {
				System.out.print(space);
				System.out.print(nodeGraph[j][k].getData()%10);
				//System.out.print(" ");
				System.out.print(space);

				if (nodeGraph[j][k].hasEastEdges()) {
					System.out.print(" ");

				} else {
					System.out.print("|");
				}

			}
			System.out.println();
			System.out.print("+");
			for (int p = 1; p <= size; p++) {

				System.out.print(space);
				if (nodeGraph[j][p].hasSouthEdges()) {
					System.out.print(" ");

				} else if (j == size && p == size) {
					System.out.print(" ");
				} else {
					System.out.print("-");
				}

				System.out.print(space);
				System.out.print("+");
			}
			System.out.println();
		}

	}

	// x1 = row
	// y1= column
	public boolean addEdge(int x1, int y1, int x2, int y2) {
		int key = 0;
		int key2 = 0;

		// get both nodes from 2D array
		if (x2 == x1 && y2 == y1 + 1) {

			// To the right (east), key value of 3
			key = 3;
			key2 = 4;
		} else if (x2 == x1 && y2 == y1 - 1) {


			// To the left (west), key value of 4
			key = 4;
			key2 = 3;
		} else if (y2 == y1 && x2 == x1 - 1) {
			// Above (north), key value of 1
			key = 1;
			key2 = 2;
		} else if (y2 == y1 && x2 == x1 + 1) {
			// Below (south), key value of 2
			key = 2;
			key2 = 1;
		} else {
			// Coordinates are invalid
			return false;
		}

		// node1.addEdge(node2);
		return nodeGraph[x1][y1].addEdge(nodeGraph[x2][y2], key) && nodeGraph[x2][y2].addEdge(nodeGraph[x1][y1], key2);
	}

	public void DFS() {
		Stack<Node<E>> cellStack = new Stack<Node<E>>();

		Node<E> currentCell = nodeGraph[1][1];
		int visitedCells = 1;

		while (visitedCells < nodeCount) {
			ArrayList<Node<E>> neighbors = this.getAllNeighbors(currentCell);
			ArrayList<Node<E>> neighborsWithAllWall = new ArrayList<>();

			//Stack<Node<E>> allWalls = new Stack<>();

			// Issue before is when remove a Node from ArrayList, the size of the ArrayList
			// decrease, so the loop won't run enough times as expected
			for (int l = 0; l < neighbors.size(); l++) {
				if ((neighbors.get(l).hasAllWalls())) {

					neighborsWithAllWall.add(neighbors.get(l));
				}
			}

			// Create a array list of neighbors with no edges

//			while (!allWalls.isEmpty()) {
//
//				neighborsWithAllWall.add(allWalls.pop());
//			}

			Random r = new Random();

			if (!neighborsWithAllWall.isEmpty()) {

				Node<E> randomNeighbor = neighborsWithAllWall.get(r.nextInt(neighborsWithAllWall.size()));
				addEdge(currentCell.getXCor(), currentCell.getYCor(), randomNeighbor.getXCor(),
						randomNeighbor.getYCor());
				cellStack.push(currentCell);
				currentCell = randomNeighbor;
				visitedCells++;

			} else {
				// System.out.println(nodeCount);
				currentCell = cellStack.pop();
				// System.out.println(currentCell.getData());
			}
		}

	}

	private ArrayList<Node<E>> getAllNeighbors(Node<E> currNode) {
		ArrayList<Node<E>> neighbors = new ArrayList<Node<E>>();
		int currX = currNode.getXCor();
		int currY = currNode.getYCor();

		if (currX - 1 != 0) {
			neighbors.add(nodeGraph[currX - 1][currY]);
		}
		if (currX + 1 != nodeGraph.length) {
			neighbors.add(nodeGraph[currX + 1][currY]);
		}
		if (currY - 1 != 0) {
			neighbors.add(nodeGraph[currX][currY - 1]);
		}
		if (currY + 1 != nodeGraph.length) {
			neighbors.add(nodeGraph[currX][currY + 1]);
		}

		return neighbors;
	}

	public int getNodeCount() {
		return this.nodeCount;
	}

	public Node<E>[][] getNodeGraph() {
		return nodeGraph;
	}
}