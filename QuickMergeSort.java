/* Programming Assigment 2
   Author: Franklin Young
   Date: 11-5-13
   Purpose: To measure the time between the implementations of mergesort and quicksort
*/

import java.util.Scanner;
import java.util.Random;
import java.util.Calendar;
import java.util.Date;

public class QuickMergeSort 
{  
   public static void main(String[] args) 
   {   
      System.out.println("Starting... ");
      
      Random rand = new Random();
      int[] numSet1 = new int[500]; // two arrays of numbers for each algorithm to sort
      int[] numSet2 = new int[500];
      
      for(int i = 0; i < numSet1.length; i++) {
          numSet1[i] = rand.nextInt(100) + 1;
          numSet2[i] = rand.nextInt(100) + 1;
      }
      
      long quickStartTime = System.nanoTime();
      // call quicksort
      quickSort(numSet1);
      long quickEndTime = System.nanoTime();
      
      long mergeStartTime = System.nanoTime();
      // call mergesort class
      Mergesort sorter = new Mergesort();
      sorter.sort(numSet2);
      long mergeEndTime = System.nanoTime();
     
      // calculate Quicksort time length and print sorted array
      System.out.println("\nQuicksort Algorithm Duration: " + ((quickEndTime - quickStartTime) / 100000.0)); 
      for(int i = 0; i < numSet1.length; i++) 
      {
          System.out.print(numSet1[i] + ", ");
      }
      // calculate Mergesort time length and print sorted array
      System.out.println("\n\nMergesort Algorithm Duration: " + ((mergeEndTime - mergeStartTime) / 100000.0));
      for(int i = 0; i < numSet2.length; i++) 
      {
          System.out.print(numSet2[i] + ", ");
      }
      
      System.out.print("\n\nThe Quicksort Algorithm is " + (((mergeEndTime - mergeStartTime)/100000.0) - ((quickEndTime-quickStartTime)/100000.0)));
      System.out.print(" faster"); 
   }
   
   // get array and pass the array, left node, and right node to the algorithm
   public static void quickSort(int array[])
   {
      doQuickSort(array,0,array.length-1);
   }
   
   public static void doQuickSort(int array[],int start,int end)// quicksort recursion
   {
      int pivotPoint;
      if(start<end)
      {
         pivotPoint = partition(array,start,end); 
	
	      doQuickSort(array,start,pivotPoint-1);
	
	      doQuickSort(array,pivotPoint+1,end);
      }
   }
   
   public static int partition(int array[],int start,int end)// partition the array
   {
      int pivotValue;
      int endOfLeftList;
      int mid;
  
      mid = medianOf3(array,start,end); // method call to find middle value
    
      swap(array,start,mid);
  
      pivotValue = array[start];
  
      endOfLeftList=start;
  
      for(int scan=start+1;scan<=end;scan++)// put all elements which are smaller than the pivot to the pivot's left
      {
         if(array[scan]<pivotValue)
	      {
	         endOfLeftList++;
	         swap(array,endOfLeftList,scan);
	 
	      }
      }
  
      swap(array,start,endOfLeftList);
  
      return endOfLeftList;
   }

   public static void swap(int[] array,int a,int b)// swap locations
   {
      int temp;
 
      temp=array[a];
      array[a]=array[b];
      array[b]=temp;
   }

   public static int medianOf3(int[] array,int start,int end)// finds median and sorts low middle and high values
   {
      int mid = (start+end)/2;
  
      if(array[start]>array[mid])
      {
         swap(array,start,mid);
      }
      if(array[start]>array[end])
      {
         swap(array,start,end);
      }
      if(array[mid]>array[end])
      {
         swap(array,mid,end);
      }
      return mid;
   }
}  
 