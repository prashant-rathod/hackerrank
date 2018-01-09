import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
             int nextValue = in.nextInt();
             
            //run through insertion sort
            int i = a_i - 1;
             while(i >= 0 && nextValue < a[i]){
                a[i+1] = a[i];
                i--;
             }
            
             a[i+1] = nextValue;
            
            if(a_i % 2 != 0){
                System.out.println(0.5*(a[a_i/2]+a[1+a_i/2]));
            } else {
                System.out.println(1.0*a[a_i/2]);
            }
        }
    }
}
