
package matrix;

import static matrix.Matrix.add;
import static matrix.Matrix.print;

public class Matrix {


    
    public static void main(String[] args) {

        int aa[][]={{1,2},{1,2}};
        int bb[][]={{1,2},{1,2}};
        add(aa,bb);
        
        print(aa);
        
       
    }
    public static void test11(int a [][], int b [][]) {
    }
    public static void test3(int a [][], int b [][]) {
    }
    public static void test4(int a [][], int b [][]) {
    }
    public static void test1(int a [][], int b [][]) {
    }
    public static void test(int a [][], int b [][]) {
    }
    public static void sub(int a [][], int b [][]) {
    }
    public static void adddd(int a [][], int b [][]) {
    }
    public static void adddddd(int a [][], int b [][]) {
    }
    public static void addd(int a [][], int b [][]) {
    }
    
    public static void add(int a [][], int b [][]) {
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                a[i][j] += b[i][j];
            }
        }
    }
    
    public static void print(int a [][]) {
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.println(a[i][j]);
            }
        }
    }
    public static void print2(int a [][]) {
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.println(a[i][j]);
            }
        }
    }
    ///////
    ////zzzzzzzzzzzzzzzzkkkkkkkkkkkkkaaaaaaaaaaaaaaa
    public static void test20(int a [][], int b [][]) {
    }
}
