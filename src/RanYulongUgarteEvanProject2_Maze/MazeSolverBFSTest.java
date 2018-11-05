package RanYulongUgarteEvanProject2_Maze;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Junit Testing for MazeSolveBFS class
 * @author Yulong  and Evan
 *
 */

class MazeSolverBFSTest {

	@Test
	// Maze dimension of 4 with random seed 0
	void SolveMazeBFStest1() {

		// Construct a Maze with dimension of 4 and random seed 0
		Maze<Integer> tester = new Maze<Integer>(4, 0);

		// Generate a Maze
		tester.generateMazeDFS();

		// Construct a MazeSolverBFS tester
		MazeSolverBFS solveTester = new MazeSolverBFS(tester.getNodeGraph(), 4);

		// Solve the Maze by BFS
		solveTester.SolveMazeBFS();

		// Only Print the Maze
		System.out.println("Graph Size: 4");
		System.out.println("Maze");
		System.out.println();
		tester.printMaze();
		System.out.println();
		System.out.println();

		// Print the Maze with Solution Steps
		System.out.println("BFS: ");
		solveTester.printSolutionWithSteps();
		System.out.println();
		System.out.println();

		// Print the Maze with #
		solveTester.printSolution();
	}

	@Test
	// Maze dimension of 6 with random seed 0
	void SolveMazeBFStest2() {

		// Construct a Maze with dimension of 6 and random seed 0
		Maze<Integer> tester = new Maze<Integer>(6, 0);

		// Generate a Maze
		tester.generateMazeDFS();

		// Construct a MazeSolverBFS tester
		MazeSolverBFS solveTester = new MazeSolverBFS(tester.getNodeGraph(), 6);

		// Solve the Maze by BFS
		solveTester.SolveMazeBFS();

		// Only Print the Maze
		System.out.println("Graph Size: 6");
		System.out.println("Maze");
		System.out.println();
		tester.printMaze();
		System.out.println();
		System.out.println();

		// Print the Maze with Solution Steps
		System.out.println("BFS: ");
		solveTester.printSolutionWithSteps();
		System.out.println();
		System.out.println();

		// Print the Maze with #
		solveTester.printSolution();
	}

	@Test
	// Maze dimension of 8 with random seed 0
	void SolveMazeBFStest3() {

		// Construct a Maze with dimension of 6 and random seed 0

		Maze<Integer> tester = new Maze<Integer>(8, 0);

		// Generate a Maze
		tester.generateMazeDFS();

		// Construct a MazeSolverBFS tester
		MazeSolverBFS solveTester = new MazeSolverBFS(tester.getNodeGraph(), 8);

		// Solve the Maze by BFS
		solveTester.SolveMazeBFS();
		System.out.println("Graph Size: 8");
		System.out.println("Maze");
		System.out.println();

		// Only Print the Maze
		tester.printMaze();
		System.out.println();
		System.out.println();

		// Print the Maze with Solution Steps
		System.out.println("BFS: ");
		solveTester.printSolutionWithSteps();
		System.out.println();
		System.out.println();

		// Print the Maze with #
		solveTester.printSolution();
	}

	@Test
	<E> // Test method of getEdges
	// North = 1, South = 2, East = 3, West = 4
	// getEdges add the node in the order of South East North and West
	void getEdgesTest() {
		// Construct a tester node with x coordinate =1 , y coordinate=1 and data =5
		Node<E> tester = new Node<E>(1, 1, 5);

		// Construct a North Neighbor of the tester node with x coordinate =0 , y
		// coordinate=1 and data =3
		Node<E> testerN = new Node<E>(0, 1, 3);

		// Construct a West Neighbor of the tester node with x coordinate =1 , y
		// coordinate=0 and data = 4
		Node<E> testerW = new Node<E>(1, 0, 4);

		// Add North node as edges of tester
		tester.addEdge(testerN, 1);

		// Add South node as edges of tester
		tester.addEdge(testerW, 4);

		// Construct a Maze
		Maze<Integer> t = new Maze<Integer>(4, 0);

		// Generate the 2D array
		t.generateMazeDFS();

		// Generate a Maze Solver
		MazeSolverBFS m = new MazeSolverBFS(t.getNodeGraph(), 4);

		// ArrayList for Testing
		ArrayList<Node<E>> testList = m.getEdges(tester);

		// Test the ArrayList has the size of two
		assertEquals(2, testList.size());

		// Test the first Node has x coordinate of 0
		assertEquals(0, testList.get(0).getXCor());

		// Test the first Node has data of 3
		assertEquals(3, testList.get(0).getData());

		// Test the second Node has data of 4
		assertEquals(4, testList.get(1).getData());
	}

}
