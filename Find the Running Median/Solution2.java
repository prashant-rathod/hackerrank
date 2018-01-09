import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static double[] getMedians(int[] a){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        double[] medians = new double[a.length];
        for(int i=0; i<a.length; i++){
            addNumber(a[i], maxHeap, minHeap);
            reArrange(maxHeap, minHeap);
            medians[i] = getMedian(maxHeap, minHeap);
        }
        return medians;
    }
    public static void addNumber(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
        if(maxHeap.size() == 0 || maxHeap.peek() > num){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
    }
    public static void reArrange(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
        PriorityQueue<Integer> bigHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
        PriorityQueue<Integer> smallHeap = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;
        
        if((bigHeap.size() - smallHeap.size()) > 1){
            smallHeap.add(bigHeap.poll());
        }
    }
    public static double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
        PriorityQueue<Integer> bigHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
        PriorityQueue<Integer> smallHeap = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;
        if(bigHeap.size() == smallHeap.size()) {
            return  ((double)bigHeap.peek() + smallHeap.peek()) / 2;
        }else{
            return bigHeap.peek();   
        }
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
             a[a_i] = in.nextInt();
        }
        
        //using heaps
        double[] medians = getMedians(a);
        for(int a_i=0; a_i < n; a_i++){
             System.out.println(medians[a_i]);
        }
        
    }
}
