package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

    private UseCollection() {
    }
    
    private static void addArrayHead(ArrayList<Integer> array, int elm) {
    	array.add(array.get(array.size()-1));
    	for(var i=array.size()-3; i>=0; i--) {
    		array.set(i+1, array.get(i));
    	}
    }
    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
    	
    	final ArrayList<Integer> array = new ArrayList<>();
    	final LinkedList<Integer> list;
    	final Map<String,Long> mappa;
    	int temp;
    	long time;
    	
    	for(int i=1000; i<2000; i++) {
    		array.add(i);
    	}
    	
    	list = new LinkedList<>(array);
    	
    	temp = array.get(array.size()-1);
    	array.set(array.size()-1 , array.get(0));
    	array.set(0, temp);
    	
    	for(var elm: array) {
    		System.out.println(elm);
    	}
    	
    	time = System.nanoTime();
    	for(int i=0; i<100_000; i++) {
    		//addArrayHead(array,i);
    	}
    	time = System.nanoTime() - time;
        System.out.println("Insert 100_000 in array head " + time+ "ns (" + time / 1_000_000 + "ms)");
        
       
        time = System.nanoTime();
    	for(int i=0; i<100_000; i++) {
    		list.addFirst(i);
    	}
    	time = System.nanoTime() - time;
        System.out.println("Insert 100_000 in LinkedList head " + time+ "ns (" + time / 1_000_000 + "ms)");
        //System.out.println(list);
        
        
        time = System.nanoTime();
    	System.out.println(array.get(array.size()/2));
    	time = System.nanoTime() - time;
        System.out.println("Read middle of array " + time+ "ns (" + time / 1_000_000 + "ms)");
        
        time = System.nanoTime();
    	int h=0;
        for(var elm: list) {
        	if(h==list.size()/2) {
        		System.out.println(elm);
        	}
        	h++;
    	}
    	time = System.nanoTime() - time;
        System.out.println("Read middle of LinkedList " + time+ "ns (" + time / 1_000_000 + "ms)");
        
        
        mappa = new HashMap<>(Map.of("Africa",1_110_635_000L,"Americas",975_005_000L,"Antartica",0L,"Asia",4_298723000L,"Europe",742452000L,"Oceania",38304000L));
        long population=0;
        for(var elm: mappa.keySet()) {
        	population+= mappa.get(elm);
        }
        
        System.out.println("Population tot = "+population);
        
        
        
        
        
    	
    }
}
