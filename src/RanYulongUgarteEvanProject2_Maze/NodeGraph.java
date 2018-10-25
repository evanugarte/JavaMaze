package RanYulongUgarteEvanProject2_Maze;

public class NodeGraph<E>{
    
    Node<E>[][] nodeGraph;
    int nodeCount;

    public NodeGraph(int size){
    	nodeCount = 0;
        Node<E>[][] nodeGraph = new Node[size + 1][size + 1];
        for(int i = 1; i < nodeGraph.length; i++){
            for(int j = 1; j < nodeGraph.length; j++){
                nodeGraph[i][j] = new Node<E>(i, j, 0);
                //System.out.println(nodeCount + " " + i + " " + j);
                nodeCount++;
            }          
        }
    }
    
    public void print() {
    	for(int i = 1; i < nodeGraph.length; i++){
            for(int j = 1; j < nodeGraph.length; j++){
                System.out.print(nodeGraph[i][j].getData());
            }
            System.out.println();
    	}
    }
    
    public int getNodeCount() {
    	return this.nodeCount;
    }
}
