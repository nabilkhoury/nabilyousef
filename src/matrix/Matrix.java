/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

/**
 *
 * @author ESMAIL
 */
public class Matrix {

    /**
     * @param args the command line arguments
     */
    public static void Subtract(int[][] A, int[][] B)
    {
        
        for(int row = 0; A.length > row;row++ )
        {
            for(int column = 0; A[0].length > column;column++ )
            {
                System.out.print(A[row][column] - B[row][column] + " ");
            }
        
            System.out.println();
        }
    
    
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 10;
        int[][] A = new int[10][5];
        int[][] B = new int[10][5];
        A[0][0] = 10;
        B[0][0] = 5;
        Subtract(A, B);
    }
}
