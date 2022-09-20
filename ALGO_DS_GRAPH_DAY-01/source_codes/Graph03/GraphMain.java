import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.*;

class Graph{
    int vertCount, edgeCount;
    List [] adjList;

    Graph(int vCount){
        vertCount=vCount;
        edgeCount=0;

        //arr = new int[ size ];

        //memory gets allocated for List whose size if : vertCount
        adjList = new LinkedList[ vertCount ];
        
        for( int i = 0 ; i < vertCount ; i++ ){
            //create an empty LinkedList object for each list
            adjList[ i ] = new LinkedList<Integer>();
        }
    }

    void accept(){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter no. of edges : ");
        edgeCount = sc.nextInt();
        //accept edges i.e. pairs of vertices from user:
        for( int i = 0 ; i < edgeCount ; i++ ){
            System.out.print("enter an edge => from -> to : ");
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjList[ from ].add( to );
            adjList[ to ].add( from );//for directed graph -> this line will be in comment
        }
    }

    void display(){
        System.out.println("No. of vertices are: "+vertCount+"No. of edges are: "+edgeCount);
        System.out.println("input graph is: ");
        for( int i = 0 ; i < vertCount ; i++ ){
            System.out.print("[ "+i+" ] => ");
            System.out.println( adjList[ i ].toString() );
        }
    }
}

public class GraphMain {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter no. of vertices : ");
        int vCount = sc.nextInt();

        Graph g1 = new Graph(vCount);    
        g1.accept();
        g1.display();    
    }    
}

