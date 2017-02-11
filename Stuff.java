package Practice;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Stuff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Ints
		Integer NumberApples = new Integer(4);
		System.out.println(NumberApples + " Number of Apples");
		String x = NumberApples.toString(); //we can do this because it is type string.
		System.out.println(x);
		Integer a = 5;
		System.out.println(a.toString() + " tostring");
		System.out.println(NumberApples.toString());
		
		
		//Arrays
		int[] myInts = new int[5]; //Initially, all elements contain 0.
		System.out.println(myInts[0] + " First element in myInts");
		System.out.println(myInts[4] + " Last element in myInts");
		myInts[1] = 10;
		System.out.println(Arrays.toString(myInts));
		System.out.println(myInts.length + " length of myInts");
		myInts[0] = 6;
		myInts[2] = 7;
		System.out.println(myInts[0] + " First element in myInts");
		System.out.println(Arrays.toString(myInts));
		
		// For arrays of objects, all elements are initially null.
		Integer[] top5scores = new Integer[5];
		Integer[] myIntegers = new Integer[10];
		myIntegers[4] = new Integer(4);
		top5scores[2] = new Integer(7);
		System.out.println(Arrays.toString(myIntegers) + " myIntegers");
		top5scores[0] = 7200;
		top5scores[1] = 6500;
		System.out.println(Arrays.toString(top5scores) + " TOP SCORE LIST");
		
		//Strings
		String enter = new String("Hello!");
		String exit = "Goodbye.";
		// Does not work: s = enter + exit;
		enter =  enter + " " + exit;
		System.out.println(enter);
		
		char firstletter = enter.charAt(0);
		System.out.println(firstletter + " First letter");
		enter = enter.substring(0,6);
		System.out.println(enter);
		String txt = "   A string with white space .   ";
		String strippedtxt = txt.trim();
		System.out.println(strippedtxt);
		String[] items = strippedtxt.split("i");
		System.out.println(items); //this just gives an object ID
		System.out.println(Arrays.toString(items));
		
		//Basic for loop

		String[] names = {"Nicky", "Andy", "Joe"};
		int[] numbers = new int[] {0,1,0,1};
		//String[] names = new String[] {"abc", "def", "ghi"};
		//List<String> names = Arrays.asList("Nicky", "Andy", "Joe");
		
		//List<String> namesList = namesArray;
		//System.out.println(namesArray);
		//System.out.println(namesList);
		System.out.println(numbers); // id
		System.out.println(names); // id
		
		for (int i=0; i < names.length; i++){
			System.out.println(names[i]);
		}
		
		for (Integer i : myIntegers) {
			System.out.println(i);
		}
		
		//Lists
		List<String> tList = new ArrayList<String>();
		tList.add("Hello");
		tList.add("World");
		System.out.println(tList.get(0).charAt(0));
        System.out.println(tList.size());
        System.out.println(tList);
        
        //Maps
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        
        myMap.put("csc", new Integer(207));
        System.out.println(myMap.get("csc"));
        
    	// "mat" is not a key, so this returns null.
        System.out.println(myMap.get("mat"));
        
        System.out.println("Generics, do not do this:");
        List firstList = new ArrayList();
        firstList.add("Hello");
        firstList.add(new Integer(3));
        System.out.println(firstList);
        
        // Let's imagine that we want an ArrayList of String, but
        // we declared it as shown above. Nothing stops us from
        // adding non-Strings to the list.
        // To call a String method, we would need to typecast:
        System.out.println(((String) firstList.get(0)).charAt(0));
        
        //Casting down
        System.out.println("casting down");
        Object o = new String("hello");
        // char c = o.charAt(1);  //NO! Object does not have a charAt method
        char c = ((String) o).charAt(1); //cast the object that o refers to as a string to use string methods.
        System.out.println(c);
        
        List meList = new ArrayList();
        meList.add(new Integer(3));
        meList.add("Hello");
        meList.add("World");
        System.out.println(meList);
        System.out.println(meList.get(0));
        System.out.println(meList.get(1));
        System.out.println(((String) meList.get(1)).charAt(0));
	}

}
