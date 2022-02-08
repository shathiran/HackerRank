package com.sharan.ds;

import java.io.*;
import java.util.*;

class NodeConnectedSet {
    int n;
    int[][] matrix;
    NodeConnectedSet(int n){
        this.n = n;
        this.matrix = new int[n][n];
    }
}

public class ConnectedSet {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases : ");
        int t = Integer.parseInt(sc.next());
        NodeConnectedSet[] nodeArr = new NodeConnectedSet[t];
        
        for(int x=0;x<t;x++){
            System.out.println("Enter length of "+x+1+" element : ");
            int n = Integer.parseInt(sc.next());
            
            int[][] matrix = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.println("Enter value for ["+i+"]["+j+"]");
                    matrix[i][j] = Integer.parseInt(sc.next());
                }
            }
            NodeConnectedSet node = new NodeConnectedSet(n);
            node.matrix = matrix;
            nodeArr[x] = node;
        }
        
//         int n = Integer.parseInt(sc.next());
//         // System.out.println("t : "+t);
//         // System.out.println("n : "+n);
//         int count = 0;
//         int[][] matrix = new int[n][n];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 matrix[i][j] = Integer.parseInt(sc.next());
//             }
//         }
        
//         // for(int i=0;i<n;i++){
//         //     for(int j=0;j<n;j++){
//         //         System.out.print(matrix[i][j]);
//         //     }
//         //     System.out.println();
//         // }
        
        for(int x=0;x<t;x++){
            int count = 0;
            for(int i=0;i<nodeArr[x].n;i++){
                for(int j=0;j<nodeArr[x].n;j++){
                    if(nodeArr[x].matrix[i][j] == 1){
                        // System.out.println("matched");
                        checkOuterLayer(nodeArr[x].matrix, i, j, nodeArr[x].n);
                        count++;
                    }
                }
            }
            System.out.println(count);    
        }
        
        
    }
    
    /*
    0 0 1 0
    1 0 1 0
    0 1 0 0
    1 1 1 1
    */
    static void checkOuterLayer(int[][] matrix, int x, int y, int n){
        matrix[x][y] = 0;
        int prevX = x-1 <= 0 ? 0 : x-1;
        int prevY = y-1 <= 0 ? 0 : y-1;
        int nextX = x+1 >= n ? n-1 : x+1;
        int nextY = y+1 >= n ? n-1 : y+1;
        
        // System.out.println("x: "+x+" prevX: "+prevX+" nextX: "+nextX);
        // System.out.println("y: "+y+" prevY: "+prevY+" nextY: "+nextY);
        
        for(int i = prevX; i<= nextX; i++){
            for(int j = prevY; j<= nextY; j++){
                // System.out.println("i:"+i+" j:"+j);
                if(matrix[i][j] == 1){
                    // System.out.println("matched inside");
                    checkOuterLayer(matrix, i, j, n);
                }
            }
        }
    }
}
