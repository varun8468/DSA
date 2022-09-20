import java.util.Scanner;
import java.util.*;

//implementation of "weighted undirected & diretcted graph" - "adjacancy matrix" 

class Graph{
    public static final int INF=9999;
    int [][] mat;
    int vertCount, edgeCount;

    Graph(int vCount){
        edgeCount=0;//graph may contains 0 no. of edges
        vertCount=vCount;//it must contains atleast 1 vertex
        mat = new int[ vCount ][ vertCount ];
        //intially all the entries in a matrix are INF
        for( int i = 0 ; i < vertCount ; i++ ){
            for( int j = 0 ; j < vertCount ; j++ ){
                mat[i][j] = INF;
            }
        }
    }

    void accept(){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter no. of egdes: ");
        edgeCount = sc.nextInt();

        //accept pairs of vertices from user i.e. edges with weights
        //no. of pairs of vertices = no. of edges
        for( int i = 0 ; i < edgeCount ; i++ ){
            int from, to, weight;
            System.out.print("enter an edge: from -> to : ");
            from = sc.nextInt();
            to = sc.nextInt();
            weight = sc.nextInt();

            mat[ from ][ to ] = weight;
            mat[ to ][ from ] = weight;//this line will be in comment for di-graph
        }
    }

    void display(){
        System.out.println("input graph is: ");
        System.out.println("No. of vertices are: "+vertCount+" No. of edges are: "+edgeCount);
        for( int i =0 ; i < vertCount ; i++ ){
            for( int j = 0 ; j < vertCount ; j++ ){
                if( mat[i][j] != INF )
                    System.out.printf("%4d", mat[i][j]);
                else
                System.out.printf("%4s", "#");
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
