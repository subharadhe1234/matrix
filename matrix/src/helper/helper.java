package helper;

import java.util.Scanner;
//import determenant.determinent;

public   class helper {
    Scanner sc=new Scanner(System.in);
    //determinent dt=new determinent();


    public double dou_to_red_dou(double n,int p){
        double dob;
       // System.out.println(n);
       //dob= (((int)(n*power(10, p)))*1.0)/power(10, p);
       n*=100;
       if(n-(int)n>0.5){
        n+=1;
       }
       dob= (((((int)n)*1.0)/100));
        return dob;
    }
    //opreration of matrix-------------------------
    public  void operations(){
        System.out.println("wellcome in matrix calculation..");
        System.out.println("you can chose any operation and press this num  ");
        System.out.println("1: find determent");
        System.out.println("2: matrix addition");
        System.out.println("3: matrix sunstraction");
        System.out.println("4: matrix multification");
        System.out.println("5: transpose of matrix ");
        System.out.println("6: cofactor of a matrix");
        System.out.println("7: the inverse of matrix");
        System.out.println("8: rank of matrix");
        System.out.println("9: tress of matrix");
        System.out.println("10: solve eq..");
    }
   public char[] get_var(int n,int p){
    char [] var=new char[n];
/*     System.out.println("1: CAP A,B.. ");
    System.out.println("2: sml a,b.. "); */
    int k=0;
    
    switch (p) {
        case 1:
        k=65;
            
            break;
        case 2:
        k=97;
            
            break;
    
        default:
            break;
            

    }
    for(int i=k;i<k+n;i++){
        //Character []var=new Character[a];
        var[i-k]=(char)i;
        //System.out.println(var[i-65]);
    

}
    return var;
   }
    //input function----------------------------------
    public  int []get_int_input(int a){
        
        int [] inp=new int [a];
        for(int i=0;i<a;i++){
            inp[i]=sc.nextInt();
        }
    
        return inp;
    }

   
    //finding power----------
    public   int power(int n,int p){
        int k=1;
        for(int i=0;i<p;i++){
            k=k*n;
        }
        return k;
    }
        // finding cofactor of a matrix-------------------------------------------- 
         public  int[][] cofactor(int[][]m,int a,int b){
            int [][] c=new int[m.length-1][m.length-1];
            int x=0,y=0;
            
            for(int i=0;i<m.length;i++){
                if(i==a) continue;
                y=0;
                for(int j=0;j<m.length;j++){
                
                   if(j==b||i==a) continue;
                    //System.out.println(m[i][j]);
                    c[x][y]=m[i][j];
                    y++;
                
                } 
                x++;
            }
    
            return c;
        }
        // printing the matrix ---------------------------------------------
        public  void loop(int[][]n,int a,int b){
            System.out.println("the matrix is ...");
            for(int i =0;i<a;i++){
                System.out.print(" |");
                
                for(int j =0;j<b;j++){
                    System.out.print(n[i][j]+"|");
                    
        
                }System.out.println();
               
            }
        }
        public  void loop(double[][]n,int a,int b){
            System.out.println("the matrix is ...");
            for(int i =0;i<a;i++){
                System.out.print(" |");
                
                for(int j =0;j<b;j++){
                    System.out.print(n[i][j]+"|");
                    
        
                }System.out.println();
               
            }
        }
} 
