import java.util.stream.IntStream;

public class MaxProduct {
	
	public static void main(String[] args) {
		int[] set = {-8, 6, -7, 3, 2, 1, -9};
		System.out.println(maxProductFinderK(set, 2));
		System.out.println(maxProductFinder(new int[] {-6, -8, 4, 2, 5, 3, -1, 9, 10}));
		System.out.println(maxProductFinder(set));
	}

	public static int maxProductFinder(int[] n) {
		return maxProductFinderK(n, 3); 
	}
	
	public static int maxProductFinderK(int[] n, int k) { 
	    return maxProductFinderK(new int[k], n, k, 0, new int[] { (int) Double.NEGATIVE_INFINITY }); 
	}

	private static int maxProductFinderK(int[] cur, int[] n, int k, int index, int products[]) {
	    int len = n.length;
	    
	    if(index == k) {
	    	//Finds the product of all the elements
	    	int product = IntStream.of(cur).reduce(1, (a, b) -> a * b);
	    	//If it is larger than the current largest number, set it
	    	if(product > products[0]) {
	    		//Sets the new largest product
	    		products[0] = product;
	    	}
	    } else {
		    for(int i = 0; i < len; i++) {
		    	cur[index] = n[i];
		    	//Deletes elements index and all elements before index
		    	maxProductFinderK(cur, beforeIndex(n, i), k, index + 1, products);
		    }
	    }
	    
	    return products[0];
	}
	public static int[] beforeIndex(int[] original, int element){
		//Reduce the new array size
	    int[] n = new int[original.length - element];
	    for(int i = element + 1; i < original.length; i++) {
	    	n[i - element] = original[i];
	    }
	    return n;
	}
}
