package RanYulongUgarteEvanProject2_Maze;
import static org.junit.jupiter.api.Assertions.*;
//
///**
// * Maze program runner
// * @author yulongran
// *
// */
//public class MazeTest{
//    public static void main(String[] args){
//        Maze<Integer> maze = new Maze<Integer>(5);
//        MazeSolverBFS BFS = new MazeSolverBFS(maze.getNodeGraph(), maze.size);
//       
//      //  maze.print();
//        maze.DFS();
//        
//        System.out.println("Maze :" );
//        System.out.println();
//        maze.printMaze();
//        
//        //Solve the Maze with DFS
//        BFS.SolveMazeBFS();
//        
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println("BFS Solution: ");
//        System.out.println();
//        BFS.printSolution();
//        
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println("BFS Solution with Steps: ");
//        System.out.println();
//        BFS.printSolutionWithSteps();
//     
//    }
//    
//}
//

import org.junit.jupiter.api.Test;

/**
 * JUnit testing for the Maze class
 * @author Yulong and Evan
 *
 * @param <E>
 */
public class MazeBuilderTest{

	@Test
	//Testing if the Maze is successfully generated and printed
	<E> void test() {
		Maze<E> tester= new Maze<E>(4,0);
		tester.generateMazeDFS();
		tester.printMaze();
	}
}
