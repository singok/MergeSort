/* Java program for Merge Sort using ArrayList */
import java.util.ArrayList;
import java.util.Scanner;
public class MergeSort{
    // Function for getting input from user
    ArrayList<Integer> getInput(ArrayList<Integer> al){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the size of an ArrayList:");    
        int size = sc.nextInt();
        System.out.println("Enter "+size+ " elements in an ArrayList");
        for(int i=0;i<size;i++){
            al.add(sc.nextInt());
        }
        return al;
    }
    // Function to print ArrayList elements
    void getOutput(ArrayList<Integer> al){
        for(int i:al){
            System.out.print(i+" ");
        }
    }
    // Function to merge two sub ArraList
    void merge(ArrayList<Integer> al,int beg,int mid,int end){
        // Create an ArrayList temp 
        ArrayList<Integer> temp = new ArrayList<Integer>();
        // Initial indexes of first and second sub-ArrayList
        int leftIndex = beg;
        int rightIndex = mid + 1;
        while(leftIndex<=mid && rightIndex<=end){
            if(al.get(leftIndex)<al.get(rightIndex)){
                temp.add(al.get(leftIndex++));
            }
            else{
                temp.add(al.get(rightIndex++));
            }
        }
        // Either one of the while loop will execute
        // Copy remaining elements of left half if any
        while(leftIndex<=mid && rightIndex>end){
            temp.add(al.get(leftIndex++));
        }
        // Copy remaining elements of right half if any
        while(rightIndex<=end && leftIndex>mid){
            temp.add(al.get(rightIndex++));
        }
        // Setting sorted array to original one
        for(int i=0;i<temp.size();i++){
            al.set(beg++,temp.get(i));
        }
    }
    // Function that sorts ArrayList using merge()
    void sort(ArrayList<Integer> al,int beg,int end){
        if(beg<end){
            // Find the middle point
            int mid = (beg+end)/2;
            // Divide ArrayList until you get single element
            sort(al,beg,mid);
            sort(al,mid+1,end);
            // Merge two sorted halves 
            merge(al,beg,mid,end);
        }
    }
    // Driver code
    public static void main(String[] args){
        ArrayList<Integer> al = new ArrayList<Integer>();
        MergeSort obj = new MergeSort();
        al = obj.getInput(al);
        System.out.print("\nThe Unsorted Elements present in an ArrayList: ");
        obj.getOutput(al);
        obj.sort(al,0,al.size()-1); 
        System.out.print("\nThe Sorted Elements present in an ArrayList: ");
        obj.getOutput(al);
    }
}