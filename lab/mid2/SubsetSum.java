package mid2;
import java.util.*;

public class SubsetSum {

    public static void findSubsets(int[] set, int target) {
        Arrays.sort(set);  // Optional but helps skip duplicates
        List<Integer> subset = new ArrayList<>();
        boolean found = findSubsetUtil(set, target, 0, subset);

        if (!found) {
            System.out.println("No subset found with the given sum");
        }
    }

    private static boolean findSubsetUtil(int[] set, int target, int index, List<Integer> subset) {
        if (target == 0) {
            System.out.println(subset);
            return true;
        }

        if (index == set.length || target < 0) {
            return false;
        }

        boolean found = false;

        // Include the current element
        subset.add(set[index]);
        found = findSubsetUtil(set, target - set[index], index + 1, subset);
        subset.remove(subset.size() - 1);  // backtrack

        // Skip duplicates
        while (index + 1 < set.length && set[index] == set[index + 1]) {
            index++;
        }

        // Exclude the current element and move forward
        found |= findSubsetUtil(set, target, index + 1, subset);

        return found;
    }

    public static void main(String[] args) {
        int[] set = {1, 2, 5, 6, 8};
        int target = 9;

        System.out.println("Subsets with sum: " + target);
        findSubsets(set, target);
    }
}