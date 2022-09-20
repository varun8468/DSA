import java.util.Scanner;
import java.util.*;

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
        System.out.println("No. of vertices are: "+vertCount);
        System.out.println("No. of edges are: "+edgeCount);
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

    int get_min(int [] dist, boolean [] marked){
        int min_ind=0;
        int min_dist=INF;
        
        for( int i = 0 ; i < vertCount ; i++ ){
            if( marked[ i ] == false && dist[ i ] < min_dist ){
                min_ind = i;
                min_dist = dist[i];	
            }
        }
        return min_ind;
        /* this function returns/selects vertex from original vertex set, which is not yet 
        added into MST set of vertices and having min key value */ 
    }

    void dijstkras(int source){
        boolean [] marked = new boolean[ vertCount ];
        int [] dist = new int[ vertCount ];
        int mst_vert_cnt=0;

        //initially distance of all vertices from given source vertex is INF and
        //all vertices are unmarked i.e. not yet added into the MST set of vertices
        for( int v = 0 ; v < vertCount ; v++ ){
            dist[ v ] = INF;
            marked[ v ] = false;
        }
        //distance of source vertext from itself is 0
        dist[ source ] = 0;
        System.out.print("MST SET OF VERTICES: { ");
        while( mst_vert_cnt < vertCount ){
            int min_key_vert = get_min(dist, marked);
            System.out.print(min_key_vert+" ");
            //mark "min_key_vert" as added into the MST set of vertices and increment the counter
            marked[ min_key_vert ] = true;
            mst_vert_cnt++;


            //update distance of all its adjancent but unmarked vertices to the min dist
            for( int v = 0 ; v < vertCount ; v++ ){
                if( mat[ min_key_vert ][ v] != INF && marked[v] == false &&
                    dist[min_key_vert] + mat[min_key_vert][v] < dist[ v ] ){
                    dist[ v ] = dist[min_key_vert] + mat[min_key_vert][v] ;
                }
            }
        }//end of while loop
        System.out.println(" } ");

        System.out.println("shortest distance of all vertices from given source vertex : "+source+" is: ");
        for( int v = 0 ; v < vertCount ; v++ ){
            System.out.println(source+" -> "+v+" : "+dist[ v ] );
        }
    }

    void prims(int root){
        boolean [] marked = new boolean[ vertCount ];
        int [] vertKey = new int[ vertCount ];
        int mst_vert_cnt=0;
        int [] parent = new int[ vertCount ]; 
        int weightMST = 0;

        //initially key value of all vertices is INF and parent of each vertex is -1 
        //all vertices are unmarked i.e. not yet added into the MST set of vertices
        for( int v = 0 ; v < vertCount ; v++ ){
            vertKey[ v ] = INF;
            marked[ v ] = false;
            parent[ v ] = -1;
        }

        //key value of root vertext is 0 & parent of root vertex is root itself
        vertKey[ root ] = 0;
        parent[ root ] = root;

        System.out.print("MST SET OF VERTICES: { ");
        while( mst_vert_cnt < vertCount ){
            int min_key_vert = get_min(vertKey, marked);
            System.out.print(min_key_vert+" ");
            //mark "min_key_vert" as added into the MST set of vertices and increment the counter
            marked[ min_key_vert ] = true;
            mst_vert_cnt++;


            //update key values of all its adjancent but unmarked vertices to the min weigh
            for( int v = 0 ; v < vertCount ; v++ ){
                if( mat[ min_key_vert ][ v] != INF && marked[v] == false &&
                    mat[min_key_vert][v] < vertKey[v] ) {
                    vertKey[ v ] = mat[ min_key_vert ][ v ] ;
                    parent[ v ] = min_key_vert;
                }
            }
        }//end of while loop
        System.out.println(" } ");
        System.out.println("edge set of MST is : ");
        for( int i = 0 ; i < vertCount ; i++ ){
            if( i != root ){
                System.out.println(i +" -> "+ parent[i] + " : " + mat[ i ][ parent[i] ]);
                weightMST += mat[ i ][ parent[i] ];
            } 
        }

        System.out.println("Weight of MST is : "+weightMST);
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

        /*
        System.out.print("enter source vertex : ");
        int source = sc.nextInt();       
        g1.dijstkras(source);
        */
        System.out.print("enter root vertex : ");
        int root = sc.nextInt();       
        g1.prims(root);

    }
  
}
