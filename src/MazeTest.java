public class MazeTest{
    public static void main(String[] args){
        Maze<Integer> maze = new Maze<Integer>(4);
        System.out.println(maze.addEdge(1, 1, 1, 2));
        maze.print();
        maze.DFS();
    }
}