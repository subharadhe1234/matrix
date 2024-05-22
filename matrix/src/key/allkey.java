package key;

import java.util.Scanner;

import determenant.determinent;
import helper.helper;

public class allkey {
     Scanner sc=new Scanner(System.in);
        determinent dt=new determinent();
            helper hp=new helper();
    int a,b,c,d;
    int []arr,arr1;
    int [][]m,n;
    // key of determination find-------------------------------------------
    public void det_key(){
        System.out.println("you chose determent of matrix");
        System.out.println("enter the row and col sixe of matrix");
        arr=hp.get_int_input(2);
        a=arr[0];
        b=arr[1];
        m=dt.new_matrix(a, b);
        hp.loop(m, a, b);
        System.out.println("determinent of matrix is "+dt.det(m));
            
    }
    //key of addition matrix------------------------------------------
    public void add_key(){
        System.out.println("you choseadditon of matrix");
        System.out.println("you need minium 2 matix");
        System.out.println("enter the 1st matrix row and col sixe");
       arr= hp.get_int_input(2);
        a=arr[0];
        b=arr[1];
         m=dt.new_matrix(a, b);
         System.out.println("enter the 2nd matrix row and col sixe");
       arr1= hp.get_int_input(2);
        c=arr[0];
        d=arr[1];
         n=dt.new_matrix(c, d);
        hp.loop(m, a, b);
        hp.loop(n, c, d);
        System.out.println("addition  of  two ");
        hp.loop(dt.add(m, n), a, b);
     
    }
    //key of substractiion matrix------------------------------
    public void sub_key() {
        System.out.println("you choseadditon of matrix");
        System.out.println("you need minium 2 matix");
        System.out.println("enter the 1st matrix row and col sixe");
       arr= hp.get_int_input(2);
        a=arr[0];
        b=arr[1];
         m=dt.new_matrix(a, b);
         System.out.println("enter the 2nd matrix row and col sixe");
       arr1= hp.get_int_input(2);
        c=arr[0];
        d=arr[1];
         n=dt.new_matrix(c, d);
        hp.loop(m, a, b);
        hp.loop(n, c, d);
        System.out.println("substraction of  two ");
        hp.loop(dt.sub(m, n), a, b);
    }
    //multification of matrix key--------------------------

    public void mul_key() {
        System.out.println("you chose multification of matrix");
        System.out.println("you need minium 2 matix");
        System.out.println("enter the 1st matrix row and col sixe");
       arr= hp.get_int_input(2);
        a=arr[0];
        b=arr[1];
         m=dt.new_matrix(a, b);
         System.out.println("enter the 2nd matrix row and col sixe");
       arr1= hp.get_int_input(2);
        c=arr[0];
        d=arr[1];
         n=dt.new_matrix(c, d);
        hp.loop(m, a, b);
        hp.loop(n, c, d);
        System.out.println("multifaication  of  two ");
       
        hp.loop(dt.mul(m, n,a,b,c,d), a, d);
        
    }
    //transpose matrix key=========================================
    public void trans_key() {
        System.out.println("you chose transpose of matrix");
        System.out.println("enter the row and col sixe of matrix");
        arr=hp.get_int_input(2);
        a=arr[0];
        b=arr[1];
        m=dt.new_matrix(a, b);
        hp.loop(m, a, b);
        System.out.println("transpose of ..");
        hp.loop(dt.trans(m, a, b), a, b);
        
    }

    public void cofactor_key() {
        System.out.println("you chose cofactor of matrix");
        System.out.println("enter the row and col sixe of matrix");
        arr=hp.get_int_input(2);
        a=arr[0];
        b=arr[1];
        m=dt.new_matrix(a, b);
        hp.loop(m, a, b);
        System.out.println("transpose of ..");
        hp.loop(hp.cofactor(m, 1, 1), a-1, b-1);
    }
    public void inverse_key() {
        System.out.println("you chose inverse  of matrix");
        System.out.println("enter the row and col sixe of matrix");
        arr=hp.get_int_input(2);
        a=arr[0];
        b=arr[1];
        m=dt.new_matrix(a, b);
        
        hp.loop(m, a, b);
        System.out.println("inverse of ..");
        
        hp.loop(dt.inver(m, a, b), a, b);
    }
    public void rank_key() {
        System.out.println("you chose rank  of matrix");
        System.out.println("enter the row and col sixe of matrix");
        arr=hp.get_int_input(2);
        a=arr[0];
        b=arr[1];
        m=dt.new_matrix(a, b);
        
        hp.loop(m, a, b);
        System.out.println("rank of .. "+ dt.rank(m, a, b));
       
    }
    public void tres() {
        System.out.println("you chose trace  of matrix");
        System.out.println("enter the row and col sixe of matrix");
        arr=hp.get_int_input(2);
        a=arr[0];
        b=arr[1];
        m=dt.new_matrix(a, b);
        
        hp.loop(m, a, b);
        System.out.println("trace of matrix is .. "+ dt.trs(m, a, b));
    }public void values(int a){
        double [][]k=new double[a][1];
        k=dt.eq_solve(a);
       //hp.loop(k, a, 1);
       char []var=new char[a];
     
     /*    for(int i=65;i<65+a;i++){
            //Character []var=new Character[a];
            var[i-65]=(char)i;
            //System.out.println(var[i-65]);
        

    } */
        var=hp.get_var(a,1);
        System.out.println("those system of eq solution are...");
       for(int i=0;i<a;i++){
        System.out.println(var[i]+" = "+hp.dou_to_red_dou(k[i][0], 2));
       }
       

    }
    public void pol_sol() {
        //quaditaic eq solve..
       /*  System.out.println(""); */
       
    }
    
}
