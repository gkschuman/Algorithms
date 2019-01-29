
package fractionalknapsack;
import java.util.Scanner;
import java.util.Arrays; //might want to get rid of later
import java.util.ArrayList; //.currently don't need. Should add later potentially depending on desired data structure
import java.util.List; //might not need now
import java.lang.Comparable;
import java.util.Collections;

/* 
    Goal: implement algorithm for fractional knapsack problem
    Input format: first line of input contains the number n of times and the 
        capacity W of a knapsack. The next n lines define the values and weights
        of the items. The i-th line contins integers v_{i} and w_{i} - the value
        and the weight of the i-th item, respectively.
    Output format: maximum value of fractions of items that fit into knapsack.
        The absolute value of the differences between the answer of your program
        and the optimal value should be at most 10^{-3}. To ensure this, output
        your answer with at least four digits after the decimal point (otherwise
        your answer, while being compute correctly, can yurn out to be wrong bc
        of rounding issues).
*/



class FractionalKnapsack {
    
    /**
     * @param capacity
     * @param values
     * @param weights
     */
    
    static class Item implements Comparable<Item>{
    //will never modify these values
    private final int value; 
    private final int weight;
    private final double density; // density = value/weight
        
    public Item(int v, int w) {
        this.value = v;
        this.weight = w;
        this.density = (double) v / (double) w;
        
    }
        
       
    public int getValue() {
        return this.value;
    }
        
    public int getWeight(){
        return this.weight;
    }
        
    //if class not public
    public double getDensity() {
        return this.density;
    }
    
    
    
    @Override    
    public int compareTo(Item compareItem) {
        /*CompareTo
            -1 for placing it before in Collection
            0 indicates same value already exists in Collection
            +1 for placing it afterwards in Collection
        */
        
        double compareDensity = ((Item) compareItem).getDensity();
        
        //sort by max density first
        if (this.density < compareDensity) {
            return 1;
        }
        else if(this.density > compareDensity) {
            return -1;
            
        
            
            //equivalent 
            //return (item.density > this.density ? item.density : this.density);
        }
        
        return 0;
    }
    
    @Override
    public String toString() {
        return "[value: " + value + " weight: " + weight + " density: " + density + "]\n";
    }
        
    
} //class Item
    
    public void StressTest(int capacity, int[] 
            values, int[] weights) {
        
    }
   
    private static double fractionalKnapsack(List<Item> items, int capacity) {
        //Returns the Maximum Value of the Loot
        double maxAmount = 0.0;
        double curWeight = capacity;
        
        for (Item it: items) {
            
            if (curWeight == 0) {
                return maxAmount;
            }
            
            else if (curWeight >= it.getWeight()) {
                
                curWeight = curWeight - it.getWeight();
                maxAmount += (it.getValue());
            }
            
            else if (curWeight < it.getWeight()) {
                //need to take a fractional amount
                maxAmount += (it.getValue())*(curWeight/it.getWeight());
                return maxAmount;
            }
            
        }
        
        return maxAmount;
    }
    
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        List<Item> items = new ArrayList<Item>();
        
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        
        int[] values = new int[n];
        int[] weights = new int[n];
        
        
        for (int i = 0; i < n; i++) {
            
            values[i] = scanner.nextInt();
            
            weights[i] = scanner.nextInt();
            Item it = new Item(values[i], weights[i]);
            items.add(it);
            //ideally sort here using merge sort so we don't have to rebuild
            //should use Override
            
        }
        //System.out.println("Unsorted Collection: " + items);
        Collections.sort(items);
        //System.out.println("Sorted Collection: " + items);
        
        System.out.printf("%.4f\n", fractionalKnapsack(items, capacity));
        //System.out.printf("%.4f\n", getOptimalValue(capacity, values, weights));
    }
    
}

/*
 * Resources:
 * https://stackoverflow.com/questions/18895915/how-to-sort-an-array-of-objects-in-java
 * https://www.geeksforgeeks.org/merge-sort/
*/
