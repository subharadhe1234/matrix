package determenant;
import java.util.Scanner;

import helper.helper;
public class determinent {
    helper hp=new helper();
    Scanner sc=new Scanner(System.in);

    //==================================================
//
    public double [][] eq_solve(int a){
        //a=no of eq or no of variable
        //a1x+b1y+c1z=d1
        //a2x+b2y+c2z=d2
        //a3x+b3y+c3z=d3
        /* 
         *   |a1|b1|c1|
         *A= |a2|b2|c2|
         *   |a3|b3|c3|
         * 
         *   |d1|
         * C=|d2|
         *   |d3|
         * 
         * X= A^-1*C
         * 
         */
        double [][] val=new double[a][1];
        int [][]A=new int[a][a];
        int [][]C=new int[a][1];
        char []l= hp.get_var(a+1, 2);
        char []h= hp.get_var(a, 1);
        for(int i=1;i<=a;i++){
            //System.out.println("for eq "+ i+ "  a"+i+"x + b"+i+"y + c"+i+"z = d"+i+" enter "+ "a"+i+" , b"+i+", c"+i+" & d"+i   );
           // this is for variable set up...
           System.out.println("for eq "+i);
           for(int m=0;m<a+1;m++){
            if(m<a-1)
           System.out.print(l[m]+""+i+""+h[m]+" + ");
           else if (m==a-1) {
            System.out.print(l[m]+""+i+""+h[m]+" = ");
            
           }
           else if (m==a) {
            System.out.print(l[m]+""+i+"  \n"+l[m-a]+""+i+" is cof & "+h[m-a]+" is var. \n"+"enter all "+a+" coff.....");
            
           }


        }
            System.out.println();
            for(int j=0;j<a;j++){
               // int k=sc.nextInt();
                
                A[i-1][j]=sc.nextInt();
                
            }
            C[i-1][0]=sc.nextInt();
           
        }
        System.out.println("all "+3+"eq are...");

        for(int i=0;i<a;i++){
            for (int j = 0; j < a+1; j++) {
                if(j<a-1)
                System.out.print(A[i][j]+""+h[j]+" + ");
                else if(j==a-1)
                System.out.print(A[i][j]+""+h[j]+" = ");
                else if(j==a)
                System.out.print(C[i][0]);
            }
            System.out.println();
        }
       //
        //hp.loop(A, a, a);
        
       // hp.loop(C, a, 1);
        
        //hp.loop(inver(A, a, a), a, a);
       val= mul(inver(A, a, a), C, a, a, a, 1);
       // hp.loop(mul(inver(A, a, a), C, a, a, a, 1), a, 1);
       return val;
       
    }

    //finding trace addintion of diagonal element===========================
    public int trs(int [][]m,int a,int b){
        int tr=0;
        if(a==b){
            for(int i=0;i<a;i++){
                tr+=m[i][i];
            }

        }else {
            System.out.println("not valided rank ");
            
        }
        return tr;
    }
    //finding the rank of a matrix====================================
    public int rank(int [][]m,int a,int b){
        
        //if matrix row and col are same size;
        
       if(a==b){
        //hp.loop(m, a, b);
        if(det(m)!=0) return a;
        else{
            if ((a==1||b==1)){
                if(m[0][0]!=0)return 1;
                return 0;
                
            } 
            int [][]k=new int[a-1][b-1];
            int p=0;
            for(int i=0;i<a;i++){
                
                for(int j=0;j<b;j++){
                    if((i==0||i==a-1)&&(j==0||j==b-1)){
                       k=rank_cofactor(m, a, b,i,j);
                       
                           //System.out.println(det(k));
                           if(det(k)!=0){
                            return k.length;
                           }
                           if(rank(k,k.length , k.length)!=0)
                           p= rank(k,k.length , k.length);
                    }
                    
          
                }   
            } 
            return p; 
           
        }

    }
    //row is grater than col =========================================
    else if (a>b) {
       
      int w=0;
      int l=b;
      
    return  row_col(m, a, b, 0, l,0);

    }
    //col is grater than row===================
    else if (b>a) {
       
      int w=0;
      int l=a;
      /* hp.loop(trans(m, a, b), b, a); */
    return  row_col(trans(m, a, b), b, a, 0, l,0);

    }

        return 0;
    } 
    //for a>b row >col---------------------------------------------------------
    public int row_col(int [][]m,int a,int b,int w, int l,int p){
        int x=0 ;
        
        int [][]v=new int[b][b];
        
        for(int i=w;i<l;i++){
          //  System.out.println("i= "+i);
           // int y=0;
            for(int j=0;j<b;j++){
               // System.out.println("j= "+j);
                v[x][j]=m[i][j];
            }
            x++;
        }
        //hp.loop(v, b, b);
       // System.out.println("hj"+(rank(v, b, b)));
       int o=rank(v, b, b);
        if (o>p){
        p= o;
    } if(l==a){ return p;}
        return row_col(m, a, b, w+1, l+1,p) ;
    }
   /*  public int ineq_row_col_cofac(int [][]m,int a,int b,int w, int l,int p){
        int x=0 ;
        
        int [][]v=new int[b][b];
        
        for(int i=w;i<l;i++){
          //  System.out.println("i= "+i);
           // int y=0;
            for(int j=0;j<b;j++){
               // System.out.println("j= "+j);
                v[x][j]=m[i][j];
            }
            x++;
        }
        //hp.loop(v, b, b);
       // System.out.println("hj"+(rank(v, b, b)));
       int o=rank(v, b, b);
        if (o>p){
        p= o;
       
      
    } if(l==a){ return p;}
     
      
      
   
        return row_col(m, a, b, w+1, l+1,p) ;
    }
    // for a<b col>row----------------------------------------------
    public int row_col2(int [][]m,int a,int b,int w, int l,int p){
        
        
        int [][]v=new int[a][a];
        
        for(int i=0;i<a;i++){
           System.out.println("i= "+i);
           // int y=0;
           int x=0 ;
            for(int j=w;j<l;j++){
                System.out.println("j= "+j);
                v[i][x]=m[i][j];
                x++;
            }
           
        }
        //hp.loop(v, b, b);
       // System.out.println("hj"+(rank(v, b, b)));
       hp.loop(v, a, a);
       int o=rank(v, a, a);
        if (o>p){
        p= o;
       
      
    } if(l==b){ return p;}
     
      
      
   
        return row_col2(m, a, b, w+1, l+1,p) ;
    }
     */
    
    // row ==col -----------------------------------------------------------------
     public int[][] rank_cofactor(int [][]m,int a,int b,int c,int d){
        int [][]k=new int[Math.max(a, b)-1][Math.max(a, b)-1];
        int g=2, x=0;
        
        for(int i=0;i<a;i++){
            if (i==c)continue;
            int y=0;
            for(int j=0;j<b;j++){
                if(i==c||j==d) continue;
                k[x][y]=m[i][j];
                y++;
                
            }
            x++;
        }
//hp.loop(k, a-1, b-1);
        return k;
    }
    //inverse of a matrix--------------------------
    public double[][] inver(int [][]m,int a,int b){
       
        //int [][]inv=new int[a][b];
        double [][]inv=new double[a][b];
        
        for(int i=0;i<a;i++){
            for (int j=0;j<b;j++){
               // double p=(((hp.power(-1, i+j)*det(hp.cofactor(m, i, j)))*1.0)/det(m));
                //inv[i][j]=hp.dou_to_red_dou(p, 2);
                inv[i][j]=(((hp.power(-1, i+j)*det(hp.cofactor(m, i, j)))*1.0)/det(m));
                

               // hp.loop(hp.cofactor(m, i, j), a-1, b-1);


            }
        }
   //hp.loop(inv, a, b);
        return trans(inv,a,b); 
    }
    //transpose of matrix------------------------------
    public int [][] trans(int [][]m,int a,int b){
        int [][]k=new int[b][a];
        for(int i=0;i<a;i++){

            for(int j=0;j<a;j++){
                k[i][j]=m[j][i];
    
            }
        }
        return k;
    }
    public double [][] trans(double [][]m,int a,int b){
       // int [][]k=new int[b][a];
        double [][]k=new double[b][a];
        for(int i=0;i<a;i++){

            for(int j=0;j<a;j++){
                k[i][j]=m[j][i];
    
            }
        }
        return k;
    }
    
    //calculate determinent of a matrix-----------------------------------------
    public int  det(int [][]m){
        
        try{
       helper hp=new helper();
        int det=0;
        if(m.length==1) return m[0][0];
        if(m.length==2){
            det=(m[0][0]*m[1][1])-(m[0][1]*m[1][0]);
            return det;
        } else{
            for(int i=0;i<m.length;i++){
                det+=(hp.power(-1, i)*(m[0][i]*det(hp.cofactor(m, 0, i))));
            }
            return det;
         } }catch(Exception e) {
            System.out.println("check the row and col are equal or not");

         }return 0;
        }
        //addition------------
        public int [][] add(int [][]m,int [][]n){
            int [][]k=new int[m.length][n.length];
            for(int i=0;i<m.length;i++){
                
                for(int j=0;j<m.length;j++){
                    k[i][j]=(m[i][j]+n[i][j]);
                }
            }
            return k;
        }
        //substraction------------
        public int [][] sub(int [][]m,int [][]n){
            int [][]k=new int[m.length][n.length];
            for(int i=0;i<m.length;i++){
                
                for(int j=0;j<m.length;j++){
                    k[i][j]=(m[i][j]-n[i][j]);
                }
            }
            return k;
        }
        //multification------------
        public int [][] mul(int [][]m,int [][]n,int a,int b,int c,int d){
           
            int [][]k=new int[a][d];
            int sum=0;
            if(b==c){
            for(int i=0;i<a;i++){
                int p=0;
                
                //System.out.println("i= "+i);
                
                for(int j=0;(j<b&&p<d);j++){
                    //System.out.printf(sum+" " +"i= "+i+"j= "+j,"p= "+p);
                    //System.out.println();
                    //for(int t=0;t<a;t++)
                    sum+=(m[i][j]*n[j][p]);
                    //System.out.println();
                   
                    if(j==b-1){
                        
                        k[i][p]=sum;
                        p++;
                        j=-1;
                        sum=0;
                    }
                    
                }
            }
            }
            else System.out.println("first matrix no of col is not equal to second matrix no of row place cheak");
            return k;
        }
        public double [][] mul(double [][]m,int [][]n,int a,int b,int c,int d){
           
            //int [][]k=new int[a][d];
            double [][]k=new double[a][d];
            //int sum=0;
            double sum=0.0;
            if(b==c){
            for(int i=0;i<a;i++){
                int p=0;
                
                //System.out.println("i= "+i);
                
                for(int j=0;(j<b&&p<d);j++){
                    //System.out.printf(sum+" " +"i= "+i+"j= "+j,"p= "+p);
                    //System.out.println();
                    //for(int t=0;t<a;t++)
                    sum+=(m[i][j]*n[j][p]);
                    //System.out.println();
                   
                    if(j==b-1){
                        
                        k[i][p]=sum;
                        p++;
                        j=-1;
                        sum=0.0;
                    }
                    
                }
            }
            }
            else System.out.println("first matrix no of col is not equal to second matrix no of row place cheak");
            return k;
        }
        public int [][] new_matrix(int a,int b){  
            
              Scanner sc=new Scanner(System.in);
            int [][]k=new int[a][b];
            System.out.println("you want "+a+"x"+b+" matrix enter all "+a*b+" elements");
            for(int i=0;i<a;i++){
                for(int j=0;j<b;j++){
                    
                    k[i][j]=sc.nextInt();
                }
            }
            
            return k;

        }   
}
