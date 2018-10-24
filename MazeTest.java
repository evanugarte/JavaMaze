public class MazeTest{
    public static void main(String[] args){
        Maze<Integer> maze = new Maze<Integer>(4);
        System.out.println(maze.addEdge(4, 2, 4, 3));
        System.out.println(maze.addEdge(4, 4, 3, 4));
        
        
        maze.print();
        maze.DFS();
    }
}