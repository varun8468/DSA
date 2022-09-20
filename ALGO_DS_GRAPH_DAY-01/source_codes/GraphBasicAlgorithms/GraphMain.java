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

    void dfsTraversal(int start){

        boolean [] marked = new boolean[ vertCount ];
        Stack<Integer> s = new Stack<Integer>();//initially stack empty

        //initially all the vertices are unmarked i.e. not yet visited
        for( int v = 0 ; v < vertCount ; v++ ){
            marked[ v ] = false;
        }

        //step-1: push starting vertex onto the stack and mark it
        s.push(start);
        marked[ start ] = true;
        System.out.print("dfs traversal is: ");
        while( !s.empty() ){
            //step-2: pop vertex from the stack and visit it
            int trav = s.peek(); s.pop();
            System.out.print(trav+" ");
            //step-3: push all its  adjancent but unmarked vertices (of trav) onto the stack and mark them
            for( int v = 0 ; v < vertCount ; v++ ){
                if( mat[ trav ][ v ] != 0 && marked[ v ] == false ){
                    s.push(v);
                    marked[ v ] = true;
                }
            }
        }//step-4: repeat step-2 & step-3 till stack not becomes empty
        System.out.println();
    }

    void dfsSpanningTree(int root){

        boolean [] marked = new boolean[ vertCount ];
        Stack<Integer> s = new Stack<Integer>();//initially stack empty

        //initially all the vertices are unmarked i.e. not yet visited
        for( int v = 0 ; v < vertCount ; v++ ){
            marked[ v ] = false;
        }

        //step-1: push root vertex onto the stack and mark it
        s.push(root);
        marked[ root ] = true;
        System.out.print("dfs spanning tree is : ");
        while( !s.empty() ){
            //step-2: pop vertex from the stack and visit it
            int trav = s.peek(); s.pop();
            System.out.print(trav+" ");
            //step-3: push all its  adjancent but unmarked vertices (of trav) onto the stack and mark them
            for( int v = 0 ; v < vertCount ; v++ ){
                if( mat[ trav ][ v ] != 0 && marked[ v ] == false ){
                    s.push(v);
                    marked[ v ] = true;
                }
            }
        }//step-4: repeat step-2 & step-3 till stack not becomes empty
        System.out.println();
    }

    boolean isGraphconnected(int source){

        boolean [] marked = new boolean[ vertCount ];
        Stack<Integer> s = new Stack<Integer>();//initially stack empty
        int connected_vert_cnt = 0;

        //initially all the vertices are unmarked i.e. not yet visited
        for( int v = 0 ; v < vertCount ; v++ ){
            marked[ v ] = false;
        }

        //step-1: push root vertex onto the stack and mark it
        s.push(source);
        marked[ source ] = true;
        while( !s.empty() ){
            //step-2: pop vertex from the stack and visit it
            int trav = s.peek(); s.pop();
            //step-3: push all its  adjancent but unmarked vertices (of trav) onto the stack and mark them
            for( int v = 0 ; v < vertCount ; v++ ){
                if( mat[ trav ][ v ] != 0 && marked[ v ] == false ){
                    s.push(v);
                    marked[ v ] = true;
                    connected_vert_cnt++;
                    if( connected_vert_cnt == vertCount-1 )
                        return true;
                }
            }
        }//step-4: repeat step-2 & step-3 till stack not becomes empty
        
        return ( (connected_vert_cnt == vertCount-1) ? true : false );
    }

    void bfsTraversal(int start){

        boolean [] marked = new boolean[ vertCount ];
        Queue<Integer> q = new LinkedList<Integer>();//initially queue empty

        //initially all the vertices are unmarked i.e. not yet visited
        for( int v = 0 ; v < vertCount ; v++ ){
            marked[ v ] = false;
        }

        //step-1: push starting vertex into the queue and mark it
        q.offer(start);
        marked[ start ] = true;
        System.out.print("bfs traversal is: ");
        while( !q.isEmpty() ){
            //step-2: pop vertex from the queue and visit it
            int trav = q.poll();
            System.out.print(trav+" ");
            //step-3: push all its adjancent but unmarked vertices (of trav) into queue and mark them
            for( int v = 0 ; v < vertCount ; v++ ){
                if( mat[ trav ][ v ] != 0 && marked[ v ] == false ){
                    q.offer(v);
                    marked[ v ] = true;
                }
            }
        }//step-4: repeat step-2 & step-3 till queue not becomes empty
        System.out.println();
    }


    void bfsSpanningTree(int root){

        boolean [] marked = new boolean[ vertCount ];
        Queue<Integer> q = new LinkedList<Integer>();//initially queue empty

        //initially all the vertices are unmarked i.e. not yet visited
        for( int v = 0 ; v < vertCount ; v++ ){
            marked[ v ] = false;
        }

        //step-1: push starting vertex into the queue and mark it
        q.offer(root);
        marked[ root ] = true;
        System.out.print("bfs spanning tree is: ");
        while( !q.isEmpty() ){
            //step-2: pop vertex from the queue and visit it
            int trav = q.poll();
            System.out.print(trav+" ");
            //step-3: push all its adjancent but unmarked vertices (of trav) into queue and mark them
            for( int v = 0 ; v < vertCount ; v++ ){
                if( mat[ trav ][ v ] != 0 && marked[ v ] == false ){
                    q.offer(v);
                    marked[ v ] = true;
                }
            }
        }//step-4: repeat step-2 & step-3 till queue not becomes empty
        System.out.println();
    }

    void pathLength(int source){

        boolean [] marked = new boolean[ vertCount ];
        Queue<Integer> q = new LinkedList<Integer>();//initially queue empty
        int [] pathLen = new int[ vertCount ];
        //initially all the vertices are unmarked i.e. not yet visited, and path len is 0
        for( int v = 0 ; v < vertCount ; v++ ){
            marked[ v ] = false;
            pathLen[ v ] = 0;
        }

        //step-1: push starting vertex into the queue and mark it
        q.offer(source);
        marked[ source ] = true;
        while( !q.isEmpty() ){
            //step-2: pop vertex from the queue and visit it
            int trav = q.poll();
            //step-3: push all its adjancent but unmarked vertices (of trav) into queue and mark them
            for( int v = 0 ; v < vertCount ; v++ ){
                if( mat[ trav ][ v ] != 0 && marked[ v ] == false ){
                    q.offer(v);
                    marked[ v ] = true;
                    pathLen[ v ] = pathLen[ trav ] + 1;
                }
            }
        }//step-4: repeat step-2 & step-3 till queue not becomes empty
        System.out.println("path length of all vertices from source vertex : "+source+" is : ");
        for( int i = 0 ; i < vertCount ; i++ ){
            System.out.println(source+" -> "+i+" : "+pathLen[ i ] );
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
    
        System.out.print("enter starting vertex : ");
        int start = sc.nextInt();       
        g1.dfsTraversal(start);
        g1.bfsTraversal(start);

    /*
        System.out.print("enter root vertex : ");
        int root = sc.nextInt();
        g1.dfsSpanningTree(root);
        g1.bfsSpanningTree(root);

        System.out.print("enter source vertex : ");
        int source = sc.nextInt();
        if( g1.isGraphconnected(source) )
            System.out.println(" g1 is connected ....");
        else
            System.out.println(" g1 is not connected ....");
    */
        System.out.print("enter source vertex : ");
        int source = sc.nextInt();
        g1.pathLength(source);

    }
    
}
