package leetcode;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
public class AllPermutations {
    public static void main(String[] args) {
        List<List<Integer>> result = permute(new int[] {1, 2, 3});
        System.out.println(result.toString());
    }
   
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums.length == 0)
            return permutations;
        List<Integer> firstPermutation = new ArrayList<>();
        firstPermutation.add(nums[0]);
        permutations.add(firstPermutation);
       
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> newPermutations = new ArrayList<>();
            for (List<Integer> permutation : permutations) {
                for (int j = 0; j <= permutation.size(); j++) {
                    List<Integer> onePermutation = new ArrayList<>(permutation);
                    onePermutation.add(j, nums[i]);
                    newPermutations.add(onePermutation);
                }
            }
            permutations = newPermutations;
        }
       
        return permutations;
    }
}
