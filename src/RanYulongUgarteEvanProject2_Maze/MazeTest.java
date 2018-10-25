package RanYulongUgarteEvanProject2_Maze;


public class MazeTest{
    public static void main(String[] args){
        Maze<Integer> maze = new Maze<Integer>(4);
     //  System.out.println(maze.addEdge(1, 1, 1, 2));
      // maze.addEdge(2, 2, 1, 2);
    //   maze.addEdge(2, 2, 2, 1);
     //  maze.addEdge(2, 2, 3, 2);
     //  maze.addEdge(2, 2, 2, 3);
       
        maze.print();
      // System.out.println( maze.getNodeCount());
        maze.DFS();
        
        System.out.println();
        System.out.println();
        System.out.println();
        maze.print2();
      // System.out.println( maze.getNodeGraph()[2][4].hasSouthEdges());
     //  System.out.println( maze.getNodeGraph()[2][4].hasEastEdges());
     //  maze.getNodeCount();
      // System.out.println("Node Count: " + maze.getNodeCount());
    }
    
}


//BFS()
//current = Node(1,1)
//Enque(current)
//whil(! Empty)
//{
//	Node u = q.dequeue
//	for(Node in u.hashMap)
//	{
//		if(Node is White)
//			Node color to Grey
//	}
//		
//}