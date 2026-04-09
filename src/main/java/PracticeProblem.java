import java.util.*;

public class PracticeProblem {

	public static void main(String args[]) {

	}
    
    public static int[] recaman(int n) {
        if (n <= 0) {
            return new int[0];
        }
        
        Set<Integer> usedNumbers = new HashSet<>();
        usedNumbers.add(0);
        
        int[] result = new int[n];
        
        generateSequence(0, 0, usedNumbers, result, n);
        
        return result;
    }
    
    private static void generateSequence(int currentIndex, int lastValue, Set<Integer> usedNumbers, int[] result, int n) {
        if (currentIndex == n) {
            return;
        }
        
        int nextValue = lastValue - (currentIndex + 1);
        
        if (nextValue > 0 && !usedNumbers.contains(nextValue)) {
            result[currentIndex] = nextValue;
            usedNumbers.add(nextValue);
            generateSequence(currentIndex + 1, nextValue, usedNumbers, result, n);
        } else {
            nextValue = lastValue + (currentIndex + 1);
            result[currentIndex] = nextValue;
            usedNumbers.add(nextValue);
            generateSequence(currentIndex + 1, nextValue, usedNumbers, result, n);
        }
    }
    
    public static void printArray(int[] arr) {
        if (arr.length == 0) {
            System.out.println("[]");
            return;
        }
        
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
	}
}
