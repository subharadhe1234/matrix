import java.util.Scanner;
import helper.helper;
//import  matrix.sc.helper ;
public class App {
    // find the power of a num-------------------------------------------
    public static int power(int n,int p){
        int k=1;
        for(int i=0;i<p;i++){
            k=k*n;
        }
        return k;
    }
    //calculate determinent of a matrix-----------------------------------------
    public static int  det(int [][]m){
       
    int det=0;
    if(m.length==2){
        det=(m[0][0]*m[1][1])-(m[0][1]*m[1][0]);
        return det;
    } else{
        for(int i=0;i<m.length;i++){
            det+=(power(-1, i)*(m[0][i]*det(cofactor(m, 0, i))));
        }
         return det;
     } 
    }
    // finding cofactor of a matrix-------------------------------------------- 
    public static int[][] cofactor(int[][]m,int a,int b){
        int [][] c=new int[m.length-1][m.length-1];
        int x=0,y=0;
        
        for(int i=a+1;i<m.length;i++){
            y=0;
            for(int j=0;j<m.length;j++){
            
               if(j==b) continue;
                //System.out.println(m[i][j]);
                c[x][y]=m[i][j];
                y++;
            
            } 
            x++;
        }

        return c;
    }
    // printing the matrix ---------------------------------------------
    public static void loop(int[][]n,int a,int b){
        System.out.println("the matrix is ...");
        for(int i =0;i<b;i++){
            System.out.print(" |");
            
            for(int j =0;j<a;j++){
                System.out.print(n[i][j]+"|");
                
    
            }System.out.println();
           
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int a,b;
        a=sc.nextInt();
        b=sc.nextInt();
        int [][] m=new int[a][b];
         for(int i=0;i<b;i++){
            for(int j=0;j<a;j++){
                
                m[i][j]=sc.nextInt();
            }
        } 
      
        loop(m, a, b);
        System.out.println("determinent is "+ det(m));
    }
}
