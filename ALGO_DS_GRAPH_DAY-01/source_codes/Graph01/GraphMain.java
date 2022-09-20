import java.util.Scanner;
import java.util.*;

//implementation of "unweighted undirected graph" - "adjacancy matrix" 

class Graph{
    int [][] mat;
    int vertCount, edgeCount;

    Graph(int vCount){
        edgeCount=0;//graph may contains 0 no. of edges
        vertCount=vCount;//it must contains atleast 1 vertex
        mat = new int[ vCount ][ vertCount ];
        //in java all ele's in a matrix gets intialized by 0 bydefault
    }

    void accept(){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter no. of egdes: ");
        edgeCount = sc.nextInt();

        //accept pairs of vertices from user i.e. edges
        //no. of pairs of vertices = no. of edges
        for( int i = 0 ; i < edgeCount ; i++ ){
            int from, to;
            System.out.print("enter an edge: from -> to : ");
            from = sc.nextInt();
            to = sc.nextInt();

            mat[ from ][ to ] = 1;
            mat[ to ][ from ] = 1;//this line will be in comment for di-graph
        }
    }

    void display(){
        System.out.println("input graph is: ");
        System.out.println("No. of vertices are: "+vertCount+" No. of edges are: "+edgeCount);
        for( int i =0 ; i < vertCount ; i++ ){
            for( int j = 0 ; j < vertCount ; j++ ){
                System.out.printf("%4d", mat[i][j]);
            }
            System.out.println();
        }
    }

}

class GraphMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter no. of vertices : ");
        int vCount = sc.nextInt();       
        Graph g1 = new Graph(vCount);

        g1.accept();
        g1.display();

    }
    
}
