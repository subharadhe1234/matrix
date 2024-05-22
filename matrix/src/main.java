import java.util.Scanner;

import helper.helper;
import determenant.determinent;
import key.*;

public class main {
 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        determinent dt=new determinent(); 
        helper hp=new helper();
        allkey key=new  allkey();
      
      hp.operations();
      int s=sc.nextInt();
        switch (s) {
            case 1:
           //determination of matrix
            key.det_key();
                
                break;
            case 2:
            //additon of 2 matrix
            key.add_key();
                  break;
            case 3:
            //substraction of a matrix;
            key.sub_key();
            break;
            case 4:
            //multification of matrix
            key.mul_key();

            break;
            case 5:
            //transpose of matrix
            key.trans_key();

            break;
            case 6:
            key.cofactor_key();
            break;
            case 7:
            key.inverse_key();
            break;
            case 8:
            key.rank_key();
            break;
            case 9:
            key.tres();
            break;
            case 10:
            //dt.eq_input(3);
           //int k= hp.int_input(1)[0];
           System.out.println("how many eq.. remenber no of variable= no of eq ");
            key.values(hp.get_int_input(1)[0]);
            break;
            case 11:
            //dt.eq_input(3);
            key.values(4);
            break;
            case 12:
            //dt.eq_input(3);
            key.pol_sol();
            break;
        
            default:
                break;
        }

    }
    
    
}
