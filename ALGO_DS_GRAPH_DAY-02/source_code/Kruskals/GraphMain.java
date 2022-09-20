import java.util.Scanner;
import java.util.Comparator;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Edge{
    int src, dest, weight;
     Edge(){
    }

    Edge(int src, int dest, int weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    int getWeight(){
        return weight;
    }

    @Override
    public String toString(){
        return "\n" + src + " - " + dest + " : " + weight;
    }
}

class Graph{
    public static final int INF=9999;
    int vertCount, edgeCount;
    int [][] mat;
    List<Edge> edgeList;
 
    Graph(int vCount){
        edgeList = new ArrayList<>();
        vertCount = vCount;
        edgeCount=0;
    
        mat = new int[ vertCount ] [ vertCount ];
        for( int i = 0 ; i < vertCount ; i++ ){
            for( int j = 0 ; j < vertCount ; j++ ){
                mat[i][j] = INF;
            }
        }
    }

    void accept(){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter number of edges: ");
        edgeCount = sc.nextInt();
        for( int i = 0 ; i < edgeCount ; i++ ){
            System.out.print("enter an edge : from -> to: & weight ");
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            mat[ from ][ to ] = weight;
            mat[ to ][ from ] = weight;

            Edge ed = new Edge(from, to, weight);
            edgeList.add(ed);
        }
    }

    void display(){
        System.out.println("input graph is: ");
        for( int i =0 ; i < vertCount ; i++ ){
            for( int j = 0 ; j < vertCount ; j++ ){
                if( mat[i][j] != INF )
                    System.out.printf("%4d", mat[i][j]);
                else
                    System.out.printf("%4s", "#");
            }
            System.out.println();
        }

        System.out.println("list of edges: ");
        System.out.println(edgeList.toString());
    }

    int root(int i, int [] parent ){
        while( parent[i] != -1 )
            i = parent[ i ];

        return i;
    }

    void combine(int srcRoot, int destRoot, int [] parent ){
        parent[ srcRoot ] = destRoot;
    }

    boolean unionFind(List<Edge> mst){
        //array to keep track of parent of vertices -  init all -1
        int [] parent = new int[ vertCount ];
        for( int i = 0 ; i < vertCount ; i++ ){
            parent[ i ] = -1;
        }

        //for:wqa each edge in MST
        for( Edge e : mst ){
            //find root of src & dest
            int srcRoot = root( e.src, parent );
            int destRoot = root( e.dest, parent);
            //if both are same from same set (root), then it is forming a cycle
            if( srcRoot == destRoot )
                return true;
            //if both not from same set, combine/union them
            combine(srcRoot, destRoot, parent );
        }
        return false;
    }

    void kruskals(){
        //MST set of edges
        List<Edge> mst = new ArrayList<>();
        //sort all edges in an ascending order of their weight
        edgeList.sort( (e1, e2) -> e1.weight - e2.weight );
        System.out.println(edgeList.toString());

        //pick the edges one by one
        for( Edge e : edgeList ){
            //add edge into MST set of vertices
            mst.add(e);
            //check if forming a cycle, discard it from MST (last element)
            if( unionFind(mst))
                mst.remove(mst.size()-1);

            //if vertCount-1 edges are in MST, stop
            if( mst.size() == vertCount-1 )
                break;
        }
        System.out.println("edges in MST are: ");
        System.out.println(mst.toString());
        
    }
}

class GraphMain{
    public static void main(String [] args ){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter number of vertices: ");
        int vCount = sc.nextInt();
        Graph g1 = new Graph(vCount);

        g1.accept();
        g1.display();
              
        g1.kruskals();
    }
}