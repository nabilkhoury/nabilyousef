package matrix;

public class Matrix {


    
    public static void main(String[] args) {

        int aa[][]={{1,2},{1,2}};
        int bb[][]={{1,2},{1,2}};
        add(aa,bb);
        
        print(aa);
        
       
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
    /////
    
}
