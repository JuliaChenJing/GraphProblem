package findShortestPath;

class Node 
{
    public int label; // this node's label (parent node in path tree)
    public int weight; // weight of edge to this node (distance to start)
 
    public Node(int v, int w) 
    { 
        label = v;
        weight = w;
    }
}
 
